<%/**
       * JSP Name:     RecordsCheckDetail
       * Created by:   Katy Laura
       * Date Created: 11/27/02
       * Description:
       * This JSP called from the Records Check List page using the Add button or
       * the Search Type hyperlink.  The Search Type hyperlink prefills the page
       * with data, the Add button presents an empty form.
       *
       **/
      /* Change History:
       Date      User              Description
       --------  ----------------  --------------------------------------------------
       SPB               SIR 19056 - Remove Automatic population of Complete date
       This is incorrect, as there was no record returned from the DPS batch.
       If the completed date is filled, the user may think that
       the row in the results listbox (no records exist/no hit returned)
       means that no history was found.
       08/06/03  Todd Reser        Added Changelog.
       08/29/03  Todd Reser        SIR 19550 - Added cnfrmDelete(), added delete
       button code.
       10/15/04  CORLEYAN          SIR 23210 - Two new Check Types have been added,
       FBI Exigent Check, and DPS Direct Check.  These
       rows are not deletable, and require that type be
       disabled after initial save.
       1/14/2005 gerryc            SIR 23242 - added a narrative for the EBC background
       check types (see SIR 23210).  This narrative button
       will only display for those with the correct security
       and for those EBC types.  The page needs to be saved
       before the button displays.  The records check id
       is now used to retrieve the record from state instead
       of the array index, because this page reloads after
       saving the two EBC types, and the index was not
       matching after that.  After saving this page for
       an EBC type, the page reloads.
       08/16/2005 Nallavs          SIR 23379 -- Added code for setting indicator
       to display check mark besides narrative button if
       narrative exists for given id_record_check.
       08/30/2010  bgehlot     SMS 66380 Added Help link which opens Policy Help Page
       */
%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact"%>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC26SO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC26SOG00"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC26SOG00_ARRAY"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.person.RecordsCheckConversation"%>
<%@ page import="java.util.Hashtable"%>
<%@ page import="java.util.Enumeration"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%--SIR 23242--%>
<%--SIR 23242--%>

<%
      //*******************************
      //*** SET NARRATIVE INDICATOR ***
      //*******************************
      // SIR 23379 -- Setting Record Check Narrative checkmark for display or not.
      boolean indicator = false;
      if (ArchitectureConstants.TRUE.equals(request.getAttribute(RecordsCheckConversation.DOCEXISTS))) {
        indicator = true;
      }

      %>

<%BaseSessionStateManager state = (BaseSessionStateManager) request
                                                                       .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
      String pageMode = PageModeConstants.VIEW;
      //If the mode was set in the activity method, get it
      UserProfile userProfile = UserProfileHelper.getUserProfile(request);
      if (request.getParameter("hdnPageMode") != null && !"".equals(request.getParameter("hdnPageMode"))) {
        pageMode = request.getParameter("hdnPageMode");
        state.setAttribute("pageMode", pageMode, request);
      } else {
        pageMode = (String) state.getAttribute("pageMode", request);
      }

      int tabIndex = 1;
      ROWCCFC26SOG00 recordsCheckRow = new ROWCCFC26SOG00();
      if (pageMode.equals(PageModeConstants.NEW)) {
        // prefill values for adding a new row in the save method
        // when adding records, the user id becomes the jsp's requested by: and id_rec_check_requestor
        recordsCheckRow.setSzScrNmRequestedBy(userProfile.getUserFullName());
        recordsCheckRow.setUlIdRecCheckRequestor(userProfile.getUserID());
      } else {
        CCFC26SO ccfc26so = (CCFC26SO) state.getAttribute("CCFC26SO", request);
        //int index = ContextHelper.getIntSafe(request, "hdnIndex");

        //SIR 23242 - instead of using the index to get the records check row, use
        //the id of the records check.  This solves the problems of the page
        //re-displaying for EBC types.
        int ulIdRecCheck = 0;
        if (request.getAttribute("txtUlIdRecCheck") != null) {
          //this is set into the attributes in the conversation after saving an EBC
          //Records Check Detail page.
          ulIdRecCheck = Integer.parseInt((String) request.getAttribute("txtUlIdRecCheck"));
        } else if (request.getParameter("hdnUlIdRecCheck") != null
                   && !"".equals(request.getParameter("hdnUlIdRecCheck"))) {
          //this is passed from the Records Check List page, or reloaded from
          //this page in case of a validation error.
          ulIdRecCheck = ContextHelper.getIntSafe(request, "hdnUlIdRecCheck");
        }
        //end SIR 23242

        if (ccfc26so == null) {
          ccfc26so = new CCFC26SO();
        }
        ROWCCFC26SOG00_ARRAY listArray = new ROWCCFC26SOG00_ARRAY();
        if (ccfc26so.getROWCCFC26SOG00_ARRAY() != null) {
          listArray = ccfc26so.getROWCCFC26SOG00_ARRAY();
        }

        for (Enumeration listArrayEnum = listArray.enumerateROWCCFC26SOG00(); listArrayEnum.hasMoreElements();) {
          ROWCCFC26SOG00 rowccfc26sog00 = (ROWCCFC26SOG00) listArrayEnum.nextElement();
          if (ulIdRecCheck == rowccfc26sog00.getUlIdRecCheck()) {
            recordsCheckRow = rowccfc26sog00;
            break;
          }
        }

        //end SIR 23242

        if (recordsCheckRow == null) {
          recordsCheckRow = new ROWCCFC26SOG00();
        }
      }
      boolean bDisabled = false;
      //boolean bDisableDate = false;
      boolean bDeletable = true;
      //boolean bResultsDisabled = true;
      //boolean bDisableType = false;
      boolean bEBCNarrativeDisabled = true; //23242

      String recCheckId = FormattingHelper.formatInt(recordsCheckRow.getUlIdRecCheck());
      String dtRequest = FormattingHelper.formatDate(recordsCheckRow.getDtDtRecCheckRequest());
      if (dtRequest == "") {
        dtRequest = FormattingHelper.formatDate(DateHelper.getTodayCastorDate());
      }
      String history_Yes = "false";
      String history_No = "false";
      String dtCompleted = FormattingHelper.formatDate(recordsCheckRow.getDtDtRecCheckCompleted());
      String ind_history = recordsCheckRow.getCIndRecCheckHistory();
      if ("N".equals(ind_history)) {
        history_No = "true";
      } else {
        history_Yes = "true";
      }

      String userName = StringHelper.getNonNullString(recordsCheckRow.getSzScrNmRequestedBy());
      String txtCdSearchType = StringHelper.getNonNullString(recordsCheckRow.getSzCdRecCheckCheckType());
      String txtOfComments = StringHelper.getNonNullString(recordsCheckRow.getSzTxtRecCheckComments());
      
      String selDtFingerprintCardGiven = FormattingHelper.formatDate(recordsCheckRow.getSelDtFingerprintCardGiven());
      String selDtFingerprintCardReturn = FormattingHelper.formatDate(recordsCheckRow.getSelDtFingerprintCardReturn());
      String selDtCriminalReleaseReceived = FormattingHelper.formatDate(recordsCheckRow.getSelDtCriminalReleaseReceived());
      String selDtLiveScanPerformed = FormattingHelper.formatDate(recordsCheckRow.getSelDtLiveScanPerformed());
      String selDtLiveScanResultReceived = FormattingHelper.formatDate(recordsCheckRow.getSelDtLiveScanResultReceived());
      
      String refusedForInvestigation_yes = "false";
      String refusedForInvestigation_no = "false";
      String rb_refuseSignCriminalInvestigationClearance = recordsCheckRow.getRbRefuseSignInvestigationClearance();
      if("N".equals(rb_refuseSignCriminalInvestigationClearance)){
        refusedForInvestigation_no = "true";
      } else {
        refusedForInvestigation_yes = "true";
      }
      
      String fpOutcome_positive = "false";
      String fpOutcome_negative = "false";
      String rb_FingerPrintCkResult = recordsCheckRow.getRbFingerPrintCkResult();
      if("N".equals(rb_FingerPrintCkResult)){
        fpOutcome_negative = "true";
      } else {
        fpOutcome_positive = "true";
      }
      
      String recm_approved = "false";
      String recm_disapproved = "false";
      String recm_conditional = "false";
      String rb_Recommendation = recordsCheckRow.getRbRecommendation();
      if("A".equals(rb_Recommendation)){
        recm_approved = "true";
      }
      else if("D".equals(rb_Recommendation)){
        recm_disapproved = "true";
      } 
      else
      {
        recm_conditional = "true";
      }
      
      String obtainedByFpCard = "";
      String cb_FingerprintCard = recordsCheckRow.getCbFingerprintCard();
      if("Y".equals(cb_FingerprintCard)){
        obtainedByFpCard = "Y";
      }
      String obtainedByLiveScan = "";
      String cb_LiveScan = recordsCheckRow.getCbLiveScan();
      if("Y".equals(cb_LiveScan)){
        obtainedByLiveScan = "Y";
      }
      
      if (("10".equals(txtCdSearchType)) || ("20".equals(txtCdSearchType)) || ("85".equals(txtCdSearchType))) {
        // if dps, central registry or FPS History type, only the comments should be enabled; disable the search type field
        //bDisableDate = true;
      }
      // SIR 23210 - If DPS Criminal History/10, Central Registry/85, FPS History Check/20,
      // DPS Direct Check/25, or FBI Exigent Check/15 type, do not allow the record to be deleted
      // or the type to be changed
      if ("10".equals(txtCdSearchType) || "20".equals(txtCdSearchType) || "85".equals(txtCdSearchType)
          || "25".equals(txtCdSearchType) || "15".equals(txtCdSearchType)) {
        bDeletable = false;
        //bDisableType = true;
      }

      if ("10".equals(txtCdSearchType) && StringHelper.isValid(recordsCheckRow.getSzCdRecCheckStatus())) { // only DPS records check have Results.  Show results if type = 10, show the Results btn
        // also have to check that there is a status - SIR 22349
        //bResultsDisabled = false;
      }

      //SIR 23242 - only show the narrative button if the pagemode isn't new or view
      //and if it's an EBC type (FBI Exigent or DPS Direct)
      if (!pageMode.equals(PageModeConstants.NEW) && !pageMode.equals(PageModeConstants.VIEW)
          && (txtCdSearchType.equals(CodesTables.CCHKTYPE_15) || txtCdSearchType.equals(CodesTables.CCHKTYPE_25))) {
        bEBCNarrativeDisabled = false;
      }

      if (pageMode.equals(PageModeConstants.VIEW)) {
        //bResultsDisabled = true;
      }

      %>

<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/javascript" language="JavaScript1.2">

// if the user is adding a new dps request, the dtCompleted must be set to null
 function rePopulateDtCompleted()
        {
           //Check to see if the search type is dps, value 10
           if(frmRecordsCheckDetail.selCdSearchType.options.value == '10')
           {
              //Clear the selDtCompleted - Call the populateDropdown method (from impact.js) to attach the codes table.
              frmRecordsCheckDetail.selDtCompleted.value='' ;
           }
          else
          {
        frmRecordsCheckDetail.selDtCompleted.value='<%= FormattingHelper.formatDate( DateHelper.getTodayCastorDate() ) %>';
          }
   }


//  Called onUnload of page to remind user unsaved data will be lost
window.onbeforeunload = function ()
{
  IsDirty();
}

<% /* SIR 19550 - Added function to confirm delete */ %>
function cnfrmDelete()
{
 return confirm( "<%= MessageLookup.getMessageByNumber( Messages.MSG_CONFIRM_ON_DELETE ) %>" );
}

function openSecondWindow(url, name, w, h)
{
  // Fudge factors for window decoration space.
  // In my tests these work well on all platforms & browsers.
  w += 32;
  h += 96;
  wleft = (screen.width - w) / 2;
  wtop = (screen.height - h) / 2;
  var win;
  try {
    win = window.open(url,
      name,
      'width=' + w + ', height=' + h + ', ' +
      'left=' + wleft + ', top=' + wtop + ', ' +
      'location=no, menubar=no, ' +
      'status=no, toolbar=no, scrollbars=yes, resizable=yes');
  } catch(e1) {
    //alert("Opening URL:\n"+e1.message);
  }
  
  try {
    // Just in case width and height are ignored
    win.resizeTo(w, h);
  } catch(e2) {
    //alert("Resizing window:\n"+e2.message);
  }
  
  try {
    // Just in case left and top are ignored
    win.moveTo(wleft, wtop);
  } catch(e3) {
    //alert("Moving window:\n"+e3.message);
  }
  
  try {
    win.focus();
  } catch(e4) {
    //alert("Setting focus:\n"+e4.message);
  }
}

function displayRecordsCheckPolicy() {
  var descriptor = "";
  descriptor += "width=500,";
  descriptor += "height=800,";
  descriptor += "channelmode=0,";
  descriptor += "dependent=0,";
  descriptor += "directories=0,";
  descriptor += "fullscreen=0,";
  descriptor += "location=0,";
  descriptor += "menubar=0,";
  descriptor += "resizable=0,";
  descriptor += "scrollbars=1,";
  descriptor += "status=0,";
  descriptor += "toolbar=0,";
  descriptor += "left=725,";
  descriptor += "top=0"; 
  return window.open('/person/RecordsCheck/displayRecordsCheckHelp', "DFCS_FACILITY_DESC", descriptor);
 }


</script>

<impact:validateErrors />
<impact:validateForm
  name="frmRecordsCheckDetail"
  method="post"
  action="/person/RecordsCheck/saveRecordsCheckDetail"
  validationClass="gov.georgia.dhr.dfcs.sacwis.web.person.RecordsCheckDetailCustomValidation"
  pageMode="<%=pageMode%>"
  schema="/WEB-INF/Constraints.xsd">

  <impact:validateInput type="hidden" name="txtUlIdRecCheck" value="<%= recCheckId %>" />
  <impact:validateInput type="hidden" name="hdnUlIdRecCheck" value="<%= recCheckId %>" />
  <%--SIR 23242--%>
  <table border="0" cellspacing="0" cellpadding="3" class="tableBorder" width="100%">
    <tr>
      <th colspan="4">
        Records Check Detail
      </th>
    </tr>
    <tr>
      <%// ExcludeOptions for NEW ( added )prs history check and central registry request.
      //  These rows can only be added when the user launches a new report on the Records Check
      //  List page.
      Hashtable<String, String> excludeList = new Hashtable<String, String>();
      if (pageMode.equals(PageModeConstants.NEW)) {
        excludeList.put("FPS History Check", "20");
        excludeList.put("Central Registry", "85");
      }
      // If the pagemode is modify and the type is deletable, do not allow the user to change from a
      //  deletable type to a Non deletable type, exclude those options from the dropdown.
      if (pageMode.equals(PageModeConstants.MODIFY) && bDeletable) {
        excludeList.put("DPS Criminal History", "10");
        excludeList.put("FPS History Check", "20");
        excludeList.put("Central Registry", "85");
        excludeList.put("DPS Direct Check", "25");
        excludeList.put("FBI Exigent Check", "15");
      }

      %>
      <td width="15%">
      <% if (pageMode.equals(PageModeConstants.NEW)) {
            bDisabled = false;            
      } else {
          bDisabled = true;
      }%>
        <impact:validateSelect required="true" disabled="<%= String.valueOf( bDisabled )%>" excludeOptions="<%= excludeList.values() %>"  tabIndex="<%= tabIndex++ %>" name="selCdSearchType" label="Search Type"
          codesTable="CCHKTYPE" width="25%" value="<%=  txtCdSearchType %>" />
          &nbsp;&nbsp;&nbsp;<strong><a href="#" onClick = "displayRecordsCheckPolicy()">?</a></strong>
      </td>
      <td colspan="3" width="25%" class="formLabel">
        History&nbsp;&nbsp;
      <% if (pageMode.equals(PageModeConstants.NEW) || pageMode.equals(PageModeConstants.MODIFY)) {
            bDisabled = false;            
      } else {
          bDisabled = true;
      }%>
        <impact:validateInput type="radio" label="Yes" id="History_Yes" name="rbHistory" disabled="<%= String.valueOf( bDisabled )%>" value="Y" cssClass="formInput" checked="<%= history_Yes %>" tabIndex="<%= tabIndex++ %>" />
        <impact:validateInput type="radio" label="No" id="History_No" name="rbHistory" disabled="<%= String.valueOf( bDisabled )%>" value="N" cssClass="formInput" checked="<%= history_No %>" tabIndex="<%= tabIndex++ %>" />
      </td>
    </tr>
    <tr>

      <td>
      <% if (pageMode.equals(PageModeConstants.NEW)) {
            bDisabled = false;            
      } else {
          bDisabled = true;
      }%>
        <impact:validateDate type="text" size="10" disabled="<%= String.valueOf( bDisabled ) %>" required="true" value="<%= dtRequest %>" name="selDtRequest" tabIndex="<%= tabIndex++ %>" label="Date of Request" constraint="Date" />
      </td>

      <td>
      <% if (pageMode.equals(PageModeConstants.NEW) || pageMode.equals(PageModeConstants.MODIFY)) {
            bDisabled = false;            
      } else {
          bDisabled = true;
      }%>
        <impact:validateDate type="text" size="10" disabled="<%= String.valueOf( bDisabled ) %>" value="<%= dtCompleted %>" name="selDtCompleted" tabIndex="<%= tabIndex++ %>" label="Date Completed" constraint="Date" conditionallyRequired="true" />
      </td>
    </tr>
    <tr>
      <td>
        <impact:validateDisplayOnlyField name="selRequestorName" label="Requested By" value="<%= userName %>" />
      </td>
    </tr>
    <%-- This is where the br tags were --%>
    <tr>
      <td>
      <% if (pageMode.equals(PageModeConstants.NEW) || pageMode.equals(PageModeConstants.MODIFY)) {
            bDisabled = false;            
      } else {
          bDisabled = true;
      }%>
        <impact:validateTextArea
          name="selComments"
          disabled="<%= String.valueOf( bDisabled )%>"
          conditionallyRequired="true"
          colspan="3"
          label="Comments"
          rows="3"
          cols="75"
          tabIndex="<%= tabIndex++ %>"
          maxLength="500">
          <%=txtOfComments%>
        </impact:validateTextArea>
      </td>
    </tr>
    </table>
<%
    boolean showFingerPrint = false;
    if(!pageMode.equals(PageModeConstants.NEW)&& (txtCdSearchType.equals(CodesTables.CCHKTYPE_GC) || txtCdSearchType.equals(CodesTables.CCHKTYPE_NC)))
    {
        showFingerPrint = true;
    }
%>      
<%  if(showFingerPrint)
    {
%>    
    <br/>
    <impact:ExpandableSectionTag name="FingerprintCheck" label="Fingerprint Check" id="ctSearchOpen" tabIndex="<%= tabIndex++ %>" >
      <table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
      <tr class="subDetail">
        <td>
          <impact:validateDate
            name="selDtCriminalReleaseReceived"
            value="<%= selDtCriminalReleaseReceived %>"
            label="Date Criminal Release Received"
            constraint="Date"
            conditionallyRequired="false"
            size="10"
            colspan="3"
            tabIndex="<%= tabIndex++ %>"
          />
        </td>
      </tr>
      <tr class="subDetail">
        <td colspan="4" class="formLabel">How were fingerprints obtained?&nbsp;&nbsp;
          <impact:validateInput
            tabIndex="<%= tabIndex++ %>"
            checked="<%= obtainedByFpCard %>"
            value="Y"
            type="checkbox"
            name="cbFingerprintCard"
            label="Fingerprint Card"
          />
          <impact:validateInput
            tabIndex="<%= tabIndex++ %>"
            checked="<%= obtainedByLiveScan %>"
            value="Y"
            type="checkbox"
            name="cbLiveScan"
            label="Live Scan"
          />
        </td>
      </tr>
      <tr class="subDetail">
        <td>
          <impact:validateDate
            size="10"
            constraint="Date"
            required="false"
            width="20%"
            value="<%= selDtFingerprintCardGiven %>"
            name="selDtFingerprintCardGiven"
            tabIndex="<%= tabIndex++ %>"
            label="Date fingerprint cards were given to the household member"
          />
        </td>
        <td>
          <impact:validateDate
            size="10"
            constraint="Date"
            required="false"
            width="20%"
            value="<%= selDtLiveScanPerformed %>"
            name="selDtLiveScanPerformed"
            tabIndex="<%= tabIndex++ %>"
            label="Date live scan was performed for household member"
          />
        </td>
      </tr>
      <tr class="subDetail">
        <td>
          <impact:validateDate
            size="10"
            constraint="Date"
            required="false"
            value="<%= selDtFingerprintCardReturn %>"
            name="selDtFingerprintCardReturn"
            tabIndex="<%= tabIndex++ %>"
            label="Date fingerprint cards were returned"
          />
        </td>
        <td>
          <impact:validateDate
            size="10"
            constraint="Date"
            required="false"
            value="<%= selDtLiveScanResultReceived %>"
            name="selDtLiveScanResultReceived"
            tabIndex="<%= tabIndex++ %>"
            label="Date results of the live scan was received"
          />
        </td>
      </tr>
      <tr class="subDetail">
        <td colspan="4" class="formLabel">Did the client refuse to sign the criminal investigation clearance?&nbsp;&nbsp;
          <impact:validateInput
            type="radio"
            label="Yes"
            name="rbRefuseSignInvestigationClearance"
            value="Y"
            checked="<%= refusedForInvestigation_yes %>"
            tabIndex="<%= tabIndex++ %>"
          />
          <impact:validateInput
            type="radio"
            label="No"
            name="rbRefuseSignInvestigationClearance"
            value="N"
            checked="<%= refusedForInvestigation_no %>"
            tabIndex="<%= tabIndex++ %>"
          />
        </td>
      </tr>
      <tr class="subDetail">
        <td colspan="4" class="formLabel">What was the outcome of the fingerprint check?&nbsp;&nbsp;
          <impact:validateInput
            type="radio"
            label="Negative"
            name="rbFingerPrintCkResult"
            value="N"
            checked="<%= fpOutcome_negative %>"
            tabIndex="<%= tabIndex++ %>"
          />
          <impact:validateInput
            type="radio"
            label="Positive"
            name="rbFingerPrintCkResult"
            value="P"
            checked="<%= fpOutcome_positive %>"
            tabIndex="<%= tabIndex++ %>"
          />
        </td>
      </tr>
      <tr class="subDetail">
        <td colspan="4" class="formLabel">Recommendation:&nbsp;&nbsp;
          <impact:validateInput
            type="radio"
            label="Approved"
            name="rbRecommendation"
            value="A"
            checked="<%= recm_approved %>"
            tabIndex="<%= tabIndex++ %>"
          />
          <impact:validateInput
            type="radio"
            label="Disapproved"
            name="rbRecommendation"
            value="D"
            checked="<%= recm_disapproved %>"
            tabIndex="<%= tabIndex++ %>"
          />
          <impact:validateInput
            type="radio"
            label="Conditional"
            name="rbRecommendation"
            value="C"
            checked="<%= recm_conditional %>"
            tabIndex="<%= tabIndex++ %>"
          />
        </td>
      </tr>
      </table>
    </impact:ExpandableSectionTag>
<%
    }
%>
  <br>
  <table border="0" cellspacing="0" cellpadding="3" class="tableBorder" width="100%">
    <tr>

      <th colspan="3">
        External Records Checks
      </th>

    </tr>
    <tr>
    <% if (pageMode.equals(PageModeConstants.NEW) || pageMode.equals(PageModeConstants.MODIFY)) { %>   
      <td width="33%" >
        <a href="http://services.georgia.gov/gbi/gbisor/SORSearch.jsp" target="windowName"
           tabIndex="<%= tabIndex++ %>"
           onclick="openSecondWindow('http://services.georgia.gov/gbi/gbisor/SORSearch.jsp',
                                     'windowName', 800, 600); return false;">GBI Sex Offender Registry</a>
      </td>
      <td width="33%">
        <a href="http://www.pap.state.ga.us/opencms/opencms/home/parolee_datbase" target="windowName"
           tabIndex="<%= tabIndex++ %>"
           onclick="openSecondWindow('http://www.pap.state.ga.us/opencms/opencms/home/parolee_datbase',
                                     'windowName', 800, 600); return false;">Board of Pardons and Parole</a>
      </td>
      <td width="33%">
        <a href="http://www.dcor.state.ga.us/GDC/OffenderQuery/jsp/OffQryForm.jsp" target="windowName"
           tabIndex="<%= tabIndex++ %>"
           onclick="openSecondWindow('http://www.dcor.state.ga.us/GDC/OffenderQuery/jsp/OffQryForm.jsp',
                                     'windowName', 800, 450); return false;">Department of Corrections Offender Query</a>
      </td>
      <%}%>
    </tr>

  </table>
  <br />
  <br />
  <%--  place the Results and Save buttons within a table to control alignment  --%>
  <table border="0" cellspacing="0" cellpadding="3" width="100%">
    <tr>
      <td width="80%">
        
      </td>
      <td class="alignRight" width="10%">
      </td>
      
      <% if (pageMode.equals(PageModeConstants.NEW) || pageMode.equals(PageModeConstants.MODIFY)) { %> 
      <td class="alignRight" width="10%s">
        <impact:ButtonTag name="btnSave" img="btnSave" align="right" restrictRepost="true" form="frmRecordsCheckDetail" action="/person/RecordsCheck/saveRecordsCheckDetail" tabIndex="<%= tabIndex++ %>" />
      </td>
      <%}%>
    </tr>

    <impact:validateInput type="hidden" name="hdnIndex" value='<%= request.getParameter ("hdnIndex")%>' />
    <%/* SPB SIR 22349 - Need to propagate szCdRecCheckStatus from List through Criminal History */

      %>
    <impact:validateInput type="hidden" name="hdnCdCheckType" value='<%= request.getParameter ("hdnCdCheckType")%>' />
    <impact:validateInput type="hidden" name="hdnDtRequest" value='<%= request.getParameter ("hdnDtRequest")%>' />
    <impact:validateInput type="hidden" name="hdnDtCompleted" value='<%= request.getParameter ("hdnDtCompleted")%>' />
    <impact:validateInput type="hidden" name="hdnComments" value='<%= request.getParameter ("hdnComments")%>' />
    <impact:validateInput type="hidden" name="txtSubjectName" value='<%= request.getParameter ("txtSubjectName")%>' />
    <impact:validateInput type="hidden" name="dtExactDOB" value='<%= request.getParameter("dtExactDOB")%>' />
    <impact:validateInput type="hidden" name="txtGender" value='<%= request.getParameter("txtGender")%>' />
    <impact:validateInput type="hidden" name="txtRaceEthnicity" value='<%= request.getParameter("txtRaceEthnicity")%>' />
    <input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>" />
  </impact:validateForm>

    <%--SIR 23242 added narrative for EBC records check types --%>
    <%if (!bEBCNarrativeDisabled) {%>
    <tr>
      <td>
        <impact:documentButton pageMode="<%= pageMode %>" tabIndex="<%= tabIndex++ %>">
          <impact:document displayName="EBC Narrative" checkForNewMode="true" name="frmDocument" checkStage="<%= GlobalData.getUlIdStage( request )  %>" protectDocument="false" docType="EBC" docExists="<%=indicator %>">
            <impact:documentParameter name="sIdRecCheck" value="<%= recCheckId %>" />
          </impact:document>
        </impact:documentButton>

      </td>
    </tr>
    <%}

    %>
  </table>