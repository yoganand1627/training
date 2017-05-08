<%--
JSP Name:     Case Summary
Created by:   Marie Au-Young
Date Created: 12/17/02

Description:
The Case Summary window allows the user to view summary information for a specific case and allows a user quick
access to important case information regarding allegations, related people, as well as events.


  Change History:
  Date      User              Description
  --------  ----------------  --------------------------------------------------
  4/1/03    Jonathan Hardy    QA Sweep -- added restrictRepost, removed imports
  06/09/03  Todd Reser        Removed two <br> tag's.  One after the Collapse
                              All line and one before Case File Print Button.
  01/25/04  Hadjimh           SIR# 22579: When a case is merged with another case, carry forward
                              all information in the closed case's Locating Information
                              textbox on the Case File Management window to the same field for
                              the Case Forward Case.
  04/25/04  CORLEYAN          SIR 22638 Add Ov Dsp to display on case list
  6/15/2004 gerryc        SIR 22926 - use hdnUlIdCase as the name of the
                              case id field because txtUlIdCase was not always
                              populated when coming from the Case List page.
                              Even though the value is set from GlobalData, the
                              field in the request object overwrites it.
  07/12/04  CORLEYAN          SIR 22985 - When clicking on Re-Open Stage, Select
                              Stage, or Admin Review, the check to see if the user
                              had selected a radio button was not working.  It was
                              based on if a hidden field had a value.  That hidden
                              field is available from request on Case List, and thus
                              was getting a value and allowing the buttons to be selected
                              inappropriately.  Instead of checking the hidden field, we
                              want to loop through the radio buttons to see if one has
                              been selected.
  08/18/04    REEDLG        SIR 22943 - modify to disable the Stage Re-open button on
                              stages FSU, FRE, SUB, or PAD if user is not in the CPS or FPS programs.
  09/27/04      Hadjimh       SIR# 23125. Cases are being created that do not have
                              any stages associated with them. The Case To in the
                              split has been recorded as a Case From in a Case Merge."
  12/08/04      Hadjimh       SIR# 23285. Ability to launch Family/Child(ren) Reading Tool
                              from Case Summary page. The Reading Tool can be launched from
                              the Case Summary Page once a worker has selected any of the
                              following five stages: ADO, SUB, FPR, FRE, FSU
  5/09/05   cooganpj          SIR 23572 - MPS Online IMPACT Enhancements -  Added
                              Case Utility import and call to getCaseCheckoutStatus to
                              hide the Case Merge expandable submodule for cases
                              checked out to the mobile (Phase I only).
  06/09/05      Fraserkr      SIR 23499, Include stage abbreviation in the Description of
                              the Reading Tool (csd01o00.sqr) on the Report List page
                              instead of the constant 'Family/Child(ren).'  The requirement
                              is for the Description of the report to be:
                              "{stage} {stageID} Reading Tool~{StageName}" where
                              variable pre-fill data is indicated by {}. (e.g. with
                              data:  FSU 30640311 Reading Tool~Castrejon, Debby M.)
                             If the trailing part of the name must be cut-off, is OK.
 06/23/2005   Nallavs        SIR 23714 Case Merge expandable section should be hidden for all C-REG and C-GUA stages types.
 06/28/2005   cooganpj       SIR 23726 - MPS Phase II - Removed Case Merge/Split expandable section hide implemented for
                             MPS Phase I (SIR 23572)
 08/26/05     anandv         Added IMPACT Corresponds to MOBILE comments at the General section.
 09/08/05     Hadjimh     SIR#23645. Staff who access case summary page in modify mode
                          (assigned worker, those above worker in unit hierarchy) should
                          be able to merge case information--even if the user does not have
                          the case merge attribute.  Currently, the "ADD" button is not
                          displayed if the case merge attribute is absent from the user's
                          profile, even for cases/stages assigned to the user or accessible
                          via unit summary/summary workload.
  09/19/05    Frasrkr    SIR 23262, Add the Case History of Investigations report to the
                report drop down list box for CPS cases.

  09/14/06   AODUTAYO   Implementing and completeing changes for R1 of SHINES
  10/05/06   AODUTAYO  Fixed SIR 404. User without SEC_MERGE_CASE should not see the add button
                       in the Case Merge/Split Section.
  10/25/08   vdevarak  Added code to display the ADO stages in a PAD case summary for SAU users  
  11/13/08   arege     Per STGAP00006539 In Shines, we do not create Admin Review stage of ARF
                       An error message is displayed when the user clicks on Admin Review Appeal button in the FAD stage.   
  11/21/08   arege     Per STGAP00010463 changed the style attribute for expandable sections 
                       of Case Merge/Split and Staff Assignment History, set  width:767px. This will prevent these
                       sections from going out of the main boundary when  the data is too large.
  12/22/08   charden   STGAP00005890 - removed onChange attribute from unit field    
  12/23/08   charden   STGAP00005788 - removed depracated txtSzAddrMailCode form attribute    
  1/5/09	 charden   STGAP00010157 - do not display add button for case merge/split if the user does not have stage access
  07/17/2009 bgehlot  STGAP00014341: MR51- Stage Reopen Changes
  09/11/2009 bgehlot  STGAP00015304: Called function isRadioChecked on clicking Reopen Stage button
  01/08/2010 ssubram  Adding Warnings and Errors to the case summary.
                            
--%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>
<%@ page import="java.util.Enumeration" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.workload.CFMgmntValueBean" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC19SO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC21SO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN37SO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN81SO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC39SOG00" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC39SOG00_ARRAY" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37SOG01" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37SOG02" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37SOG02_ARRAY" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.STFFASSGNMTHIST" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.STFFASSGNMTHIST_ARRAY" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.SpecHD" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.workload.CaseSummaryConversation" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CaseErrorsSO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CaseWarningsSO" %>
<% /*SIR 23572 - MPS Online IMPACT Enhancements - Import Case Utility*/ %>
<%
  int loopCount = 0;
  int selectedIndex = -1;
  String pageMode = PageModeConstants.MODIFY;
  int selectedStageId = 0;
  String selectedStageCode = null;
  org.exolab.castor.types.Date selectedStageDateClosed = null;
  //Error Warning Variables
  int caseErrorCount = 0;
  int caseWarningCount = 0;
  List<String> caseErrors = null;
  List<String> caseWarnings = null;
//SIR 23714 Case Merge expandable section should be hidden for all C-REG and C-GUA stages types.
  String globalSzStageType = GlobalData.getSzCdStageType(request);

  UserProfile user = UserProfileHelper.getUserProfile(request);

  int tabIndex = 1;
  BaseSessionStateManager state =
          (BaseSessionStateManager) request.getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);

  List cfmLocationInfoList = null;
  String sLocatingInfo = "";
  if (state.getAttribute("LocatingInformation", request) != null) {
    cfmLocationInfoList = (List) (state.getAttribute("LocatingInformation", request));
  }

  CFMgmntValueBean cfmLocationInfoRow;
  if (cfmLocationInfoList != null) {
    for (int iLoopCounter = 0; iLoopCounter < cfmLocationInfoList.size(); iLoopCounter++) {
      cfmLocationInfoRow = (CFMgmntValueBean) cfmLocationInfoList.get(iLoopCounter);
      String locatingInformation = cfmLocationInfoRow.getLocatingInformation();
      if (locatingInformation == null || locatingInformation.trim().length() == 0) {
        sLocatingInfo = FormattingHelper.formatString(sLocatingInfo);
      } else {
        int mCount = iLoopCounter + 1;
        String sConcat = "(" + mCount + ")";
        sLocatingInfo = FormattingHelper.formatString(sLocatingInfo) + sConcat;
        sLocatingInfo = sLocatingInfo + cfmLocationInfoRow.getCaseId() + "_";
        sLocatingInfo = sLocatingInfo + FormattingHelper.formatString(locatingInformation) + " ";
      }
    }
  }
  sLocatingInfo = FormattingHelper.formatString(sLocatingInfo);
  // Get the output object from the request for Case Summary
  CCMN37SO ccmn37so = (CCMN37SO) state.getAttribute("CCMN37SO", request);
  // Get the output object from the request for Special Handling
  CCMN81SO ccmn81so = (CCMN81SO) state.getAttribute("CCMN81SO", request);
  // Get the output object from the request for Case File Management
  CCFC21SO ccfc21so = (CCFC21SO) state.getAttribute("CCFC21SO", request);
  // Get the output object from the request for Records Retention
  CCFC19SO ccfc19so = (CCFC19SO) state.getAttribute("CCFC19SO", request);

  // Get the Warnings and Errors Output objects
  CaseErrorsSO caseErrorsSO = (CaseErrorsSO) state.getAttribute("CaseErrorsSO", request);
  CaseWarningsSO caseWarningsSO = (CaseWarningsSO) state.getAttribute("CaseWarningsSO", request);
  
  if (caseErrorsSO != null ) {
    
    caseErrorCount = caseErrorsSO.getErrorCount();
    caseErrors = caseErrorsSO.getErrorCodes();
  }
  if (caseWarningsSO != null ) {
    
    caseWarningCount = caseWarningsSO.getWarningCount();
    caseWarnings = caseWarningsSO.getWarningCodes();
  }
  // Null catch for Case Summary objects, if null set to blank
  if (ccmn37so == null) {
    ccmn37so = new CCMN37SO();
  }
  if (ccmn81so == null) {
    ccmn81so = new CCMN81SO();
  }

  //Get Case Summary object
  ROWCCMN37SOG01 caseSummary;
  if (ccmn37so.getROWCCMN37SOG01() != null) {
    caseSummary = ccmn37so.getROWCCMN37SOG01();
  } else {
    caseSummary = new ROWCCMN37SOG01();
  }

  //Get Case Summary Array of stages
  ROWCCMN37SOG02_ARRAY caseSummaryArray;
  if (ccmn37so.getROWCCMN37SOG02_ARRAY() != null) {
    caseSummaryArray = ccmn37so.getROWCCMN37SOG02_ARRAY();
  } else {
    caseSummaryArray = new ROWCCMN37SOG02_ARRAY();
  }

  // Null catch for Special Handling, if null set to blank
  if (ccmn81so == null) {
    ccmn81so = new CCMN81SO();
  }
  SpecHD specialHandling;
  if (ccmn81so.getSpecHD() != null) {
    specialHandling = ccmn81so.getSpecHD();
  } else {
    specialHandling = new SpecHD();
  }

  ROWCCFC39SOG00_ARRAY caseMergeSplitArray = (ROWCCFC39SOG00_ARRAY) request.getAttribute("caseMergeArray");
  if (caseMergeSplitArray == null) {
    caseMergeSplitArray = new ROWCCFC39SOG00_ARRAY();
  }

// Null catch for Case File Management, if null set to blank
  if (ccfc21so == null) {
    ccfc21so = new CCFC21SO();
  }

// Null catch for Records Retention, if null set to blank
  if (ccfc19so == null) {
    ccfc19so = new CCFC19SO();
  }

  // These boolean values find out from the conversation if the section should be in modify mode or browse by checking
  //  security and workload status. If the attributes are true, they disable various widgets in the expandable sections.
  boolean pageSetEDisabled = request.getAttribute(CaseSummaryConversation.PAGE_E) != null;
  // SIR#23645. changed != to == in the following statement. PAGE_F attribute is set to Boolean.TRUE
  //   if user has SEC_MERGE_CASE security attribute or stage access. Otherwise  it's set to null
  boolean pageSetFDisabled = request.getAttribute(CaseSummaryConversation.PAGE_F) == null;
  boolean pageSetGDisabled = request.getAttribute(CaseSummaryConversation.PAGE_G) != null;
  boolean pageSetHDisabled = request.getAttribute(CaseSummaryConversation.PAGE_H) != null;
  boolean hasCaseAccess = request.getAttribute("hasCaseAccess") != null;
  // This boolean is used to allow closed cases to be saved when they have been converted and
  // therefore do not have a records retention section - SIR 22406
  boolean bIndHasRecordsRet = true;

  if (("N").equals(request.getAttribute(CaseSummaryConversation.HAS_REC_RET))) {
    bIndHasRecordsRet = false;
  }

  String cdCounty = StringHelper.EMPTY_STRING;
  
  if (request.getParameter("selSzCdCounty") == null) {
        cdCounty = FormattingHelper.formatString(ccfc21so.getSzCdCounty());
  }else{
        cdCounty = request.getParameter("selSzCdCounty");
  }
  
  String cdRegion = ccfc21so.getSzCdOfficeRegion();
  
  if (("").equals(cdRegion) || cdRegion == null) {
       cdRegion = request.getParameter("selSzCdOfficeRegion");
  }
%>

<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/javascript" language="JavaScript1.2">
function changeSpecHandlingComment(commentField, checkBox) {
  checkBox.checked = commentField.value != "";
}

// This function is called when the user clicks a hyperlink in the list for merged/split cases.
// It takes the user to the CaseMergeSplitDetail page.
function caseMergeSplitHyperlink(index, pendStatus, staffNameMerge, staffNameSplit, idCaseMerge) {
  frmCaseSummary.arrayIndex.value = index;
  frmCaseSummary.pendStatus.value = pendStatus;
  frmCaseSummary.staffNameMerge.value = staffNameMerge;
  frmCaseSummary.staffNameSplit.value = staffNameSplit;
  frmCaseSummary.idCaseMerge.value = idCaseMerge;
  disableValidation('frmCaseSummary');
  submitValidateForm('frmCaseSummary', '/workload/CaseSummary/displayCaseMergeSplitDetail');
}

//This functions checks to make sure the selected stage can be reopened. Only FSU, SUB,
//FRE, and PAD stages can be reopened, and they must be closed.
function reopenStage(rowCount) {
  var form = document.all["frmCaseSummary"];
  // SIR 22985 - Call isRadioChecked to determine if a stage has been selected
  // by the user.
  if (!isRadioChecked(rowCount)) {
    return false;
  }
  if (form.hdnDtDtStageClose.value == "null" || form.hdnDtDtStageClose.value == "3500-12-31" || form.hdnDtDtStageClose.value == "4712-12-31") {
    alert('<%= MessageLookup.getMessageByNumber(Messages.MSG_ROP_CLOSED_STAGE) %>');
    return false;
  }
  if (form.hdnSzCdStage.value != '<%= CaseSummaryConversation.SUB_STAGE %>' &&
      form.hdnSzCdStage.value != '<%= CaseSummaryConversation.FSU_STAGE %>' &&
      form.hdnSzCdStage.value != '<%= CaseSummaryConversation.ADO_STAGE %>' &&
      form.hdnSzCdStage.value != '<%= CaseSummaryConversation.PAD_STAGE %>' &&
      form.hdnSzCdStage.value != '<%= CaseSummaryConversation.DIV_STAGE %>' &&
      form.hdnSzCdStage.value != '<%= CaseSummaryConversation.FPR_STAGE %>' &&
      form.hdnSzCdStage.value != '<%= CaseSummaryConversation.PFC_STAGE %>' ) {
    alert('<%= MessageLookup.getMessageByNumber(Messages.MSG_ROP_TYPE) %>');
    return false;
  }
  return true;
}


function caseFilePrint() {
  disableValidation('frmCaseSummary');
  return true;
}

//This function checks to see that the chosen stage can perform an admin review. Closed
//INV stages can create a review as well as closed ARI/ARF or open/closed FAD stages.
//This button submits to callAdminCommand, which uses form.hdnAdminCommand to determine
//what command to execute.
function adminReview(rowCount) {
  var form = document.all["frmCaseSummary"];
  // SIR 22985 - Call isRadioChecked to determine if a stage has been selected
  // by the user.12
  if (!isRadioChecked(rowCount)) {
    return false;
  }
  //User cannot create admin reviews for cases that are closed to merge
  if (form.hdnCScrIndStageMerged.value == "Y") {
    alert('<%= MessageLookup.getMessageByNumber(Messages.MSG_CASE_CLOSED_TO_MERGE) %>');
    return false;
  }
  //Prompts user to created stage, INV stage must be closed
  if (form.hdnSzCdStage.value == '<%= CaseSummaryConversation.INV_STAGE %>' &&
      (form.hdnDtDtStageClose.value != "null" && form.hdnDtDtStageClose.value != "3500-12-31" && form.hdnDtDtStageClose.value != "4712-12-31" )) {
    goOn = confirm("<%=MessageLookup.getMessageByNumber(Messages.MSG_ACTION_CREATE_AR)%>");
    if (!goOn) {
      return false;
    }
    disableValidation('frmCaseSummary');
    form.hdnAdminCommand.value = "/workload/CaseSummary/createAdmnReview_CheckPersonList";
    return true;
  }
   //Prompts user to created stage, FAD stage can be open or closed
   //Per STGAP00006539 In Shines, we do not create Admin Review stage of ARF 
  if (form.hdnSzCdStage.value == '<%= CaseSummaryConversation.FAD_STAGE %>') {
   // goOn = confirm("<%=MessageLookup.getMessageByNumber(Messages.MSG_ACTION_CREATE_AR)%>");
   //if (!goOn) {
   // return false;
   // }
   //disableValidation('frmCaseSummary');
   //form.hdnAdminCommand.value = "/workload/CaseSummary/createAdmnReview_CallCCFC42S";
   alert('<%= MessageLookup.getMessageByNumber(Messages.MSG_NOT_ADMIN_STAGE) %>');
   return false;
  }
  //ARI/ARF stages must be closed, no prompt to create stage, only can view Admin Review
  else if (( form.hdnSzCdStage.value == '<%= CaseSummaryConversation.ARI_STAGE %>' ||
             form.hdnSzCdStage.value == '<%= CaseSummaryConversation.ARF_STAGE %>') &&
           (form.hdnDtDtStageClose.value != "null" && form.hdnDtDtStageClose.value != "3500-12-31" && form.hdnDtDtStageClose.value != "4712-12-31")) {
    disableValidation('frmCaseSummary');
    form.hdnAdminCommand.value = "/workload/CaseSummary/callAdmnReview";
    return true;
  }
  else {
    alert('<%= MessageLookup.getMessageByNumber(Messages.MSG_NOT_ADMIN_STAGE) %>');
    return false;
  }
}

<%
org.exolab.castor.types.Date closedDate = ccfc19so.getDtDtCaseClosed();
org.exolab.castor.types.Date destroyDate = ccfc19so.getDtDtRecRtnDstryElig();

if (!DateHelper.isNull(closedDate)) {%>
// break the incoming date from the CCFC19S service into M/D/Y parts
var iCYear = <%= (100 * closedDate.getCentury()) + closedDate.getYear()%>;
var iCMonth = <%=closedDate.getMonth()%>;
var iCDay = <%=closedDate.getDay()%>;

var iDYear = <%= (100 * destroyDate.getCentury()) + destroyDate.getYear()%>;
var iDMonth = <%= destroyDate.getMonth()%>;
var iDDay = <%= destroyDate.getDay()%>;

// called when we change the Destruction Date to confirm user intentions if time > 20 yr
function validateDestructionDate() {
  // get the date from the date control, and parse it into M/D/Y parts
  var sRemovalDate = frmCaseSummary.txtDtDtRecRtnDstryActual.value;

  var valid = validateDate(sRemovalDate);
  if (!valid) {
    alert('<%= MessageLookup.getMessageByNumber(Messages.MSG_INVALID_DATE) %>');
    frmCaseSummary.txtDtDtRecRtnDstryActual.value =
    "<%= FormattingHelper.formatDate(ccfc19so.getDtDtRecRtnDstryActual())%>";
    frmCaseSummary.cbxScrIndDestrctnDateChng.checked = false;
    return;
  }

  var pos = sRemovalDate.search('/');
  var iMonth = parseInt(sRemovalDate.substring(0, pos));
  sRemovalDate = sRemovalDate.substring(pos + 1, sRemovalDate.length);
  pos = sRemovalDate.search('/');
  var iDay = parseInt(sRemovalDate.substring(0, pos));
  var iYear = parseInt(sRemovalDate.substring(pos + 1, sRemovalDate.length));

  // compute the number of full months between the two dates
  var months = (iYear - iCYear) * 12 + (iMonth - iCMonth);
  if (iDay < iCDay) {
    months--;
  }

  // if the time is greater than 20 yr, and the user does not confirm, clear the control
  if ((months > 240 || (months == 240 && iDay > iCDay)) &&
      !confirm('<%= MessageLookup.getMessageByNumber(Messages.MSG_CFC_REC_RETN_EXTENSION) %>')) {
    frmCaseSummary.txtDtDtRecRtnDstryActual.value =
    "<%= FormattingHelper.formatDate(ccfc19so.getDtDtRecRtnDstryActual()) %>";
    frmCaseSummary.cbxScrIndDestrctnDateChng.checked = false;
  }
  else {
    frmCaseSummary.cbxScrIndDestrctnDateChng.checked = true;
  }

  // if the date in the date control is less than the date that was returned by the database, post a message
  if (isBefore(iDay, iMonth, iYear, iDDay, iDMonth, iDYear)) {
    alert('<%= MessageLookup.getMessageByNumber(Messages.SSM_DEST_AFTER_SAME_CALC) %>');
    frmCaseSummary.txtDtDtRecRtnDstryActual.value =
    "<%= FormattingHelper.formatDate(ccfc19so.getDtDtRecRtnDstryActual()) %>";
    frmCaseSummary.cbxScrIndDestrctnDateChng.checked = false;
  }
}
<%
} // end if (closedDate != null)
%>

//returns true if the date represented by day1, month1, year1 is before  the date represented by day2, month2, year2
function isBefore(day1, month1, year1, day2, month2, year2) {
  if (year1 < year2) {
    return true;
  } else if (year1 > year2) {
    return false;
  }
  if (month1 < month2) {
    return true;
  } else if (month1 > month2) {
    return false;
  }
  return day1 < day2;
}

//calls the method to pass in data for the new stage so the 2nd level tabs can update accordingly
function selectNewStage(rowCount) {
  // SIR 22985 - Call isRadioChecked to determine if a stage has been selected
  // by the user.
  if (!isRadioChecked(rowCount)) {
    return false;
  }
  else {
    disableValidation('frmCaseSummary');
    return true;
  }
}

// SIR 22985 - Added isRadioChecked to insure that a Radio button
// is selected, if it isn't display a message.
function isRadioChecked(arrayLength) {
  var bRadio = false;
  var listRb = document.getElementsByName("radioIndex_CLEAN");
  for (var i = 0; i < arrayLength; i++) {
    bRadio = listRb[i].checked;
    if (bRadio) {
      break;
    }
  }
  if (!bRadio) {
    alert('<%= MessageLookup.getMessageByNumber( Messages.MSG_SELECT_STAGE ) %>');
  }
  return bRadio;
}

window.onbeforeunload = function () {
  IsDirty();
}

window.attachEvent("onload", initializePage);

function initializePage(){
 updateCountyCodes();
}

// STGAP00004864 
var codes001 = new Array();
codes001[0]= "|"; 
codes001[1]= "047"+"|"+"047 CATOOSA";
codes001[2]= "055"+"|"+"055 CHATTOOGA";
codes001[3]= "083"+"|"+"083 DADE";
codes001[4]= "111"+"|"+"111 FANNIN";
codes001[5]= "123"+"|"+"123 GILMER";
codes001[6]= "213"+"|"+"213 MURRAY";
codes001[7]= "227"+"|"+"227 PICKENS";
codes001[8]= "295"+"|"+"295 CATOOSA";
codes001[9]= "313"+"|"+"313 WHITFIELD";

var codes002 = new Array();
codes002[0]= "|"; 
codes002[1]= "011"+"|"+"011 BANKS";
codes002[2]= "085"+"|"+"085 DAWSON";
codes002[3]= "117"+"|"+"117 FORSYTH";
codes002[4]= "119"+"|"+"119 FRANKLIN";
codes002[5]= "137"+"|"+"137 HABERSHAM";
codes002[6]= "139"+"|"+"139 HALL";
codes002[7]= "147"+"|"+"147 HART";
codes002[8]= "187"+"|"+"187 LUMPKIN";
codes002[9]= "241"+"|"+"241 RABUN";
codes002[10]= "257"+"|"+"257 STEPHENS";
codes002[11]= "281"+"|"+"281 TOWNS";
codes002[12]= "291"+"|"+"291 UNION";
codes002[13]= "311"+"|"+"311 WHITE";



var codes003 = new Array();
codes003[0]= "|"; 
codes003[1]= "015"+"|"+"015 BARTOW";
codes003[2]= "115"+"|"+"115 FLOYD";
codes003[3]= "129"+"|"+"129 GORDON";
codes003[4]= "143"+"|"+"143 HARALSON";
codes003[5]= "223"+"|"+"223 PAULDING";
codes003[6]= "233"+"|"+"233 POLK";

var codes004 = new Array();
codes004[0]= "|"; 
codes004[1]= "035"+"|"+"035 BUTTS";
codes004[2]= "045"+"|"+"045 CARROLL";
codes004[3]= "077"+"|"+"077 COWETA";
codes004[4]= "149"+"|"+"149 HEARD";
codes004[5]= "171"+"|"+"171 LAMAR";
codes004[6]= "199"+"|"+"199 MERIWETHER";
codes004[7]= "231"+"|"+"231 PIKE";
codes004[8]= "255"+"|"+"255 SPALDING";
codes004[9]= "285"+"|"+"285 TROUP";
codes004[10]= "293"+"|"+"293 UPSON";

var codes005 = new Array();
codes005[0]= "|"; 
codes005[1]= "013"+"|"+"013 BARROW";
codes005[2]= "059"+"|"+"059 CLARKE";
codes005[3]= "105"+"|"+"105 ELBERT";
codes005[4]= "133"+"|"+"133 GREENE";
codes005[5]= "157"+"|"+"157 JACKSON";
codes005[6]= "159"+"|"+"159 JASPER";
codes005[7]= "195"+"|"+"195 MADISON";
codes005[8]= "211"+"|"+"211 MORGAN";
codes005[9]= "217"+"|"+"217 NEWTON";
codes005[10]= "219"+"|"+"219 OCONEE";
codes005[11]= "221"+"|"+"221 OGLETHORPE";
codes005[12]= "297"+"|"+"297 WALTON";

var codes006 = new Array();
codes006[0]= "|"; 
codes006[1]= "009"+"|"+"009 BALDWIN";
codes006[2]= "021"+"|"+"021 BIBB";
codes006[3]= "079"+"|"+"079 CRAWFORD";
codes006[4]= "153"+"|"+"153 HOUSTON";
codes006[5]= "169"+"|"+"169 JONES";
codes006[6]= "207"+"|"+"207 MONROE";
codes006[7]= "225"+"|"+"225 PEACH";
codes006[8]= "235"+"|"+"235 PULASKI";
codes006[9]= "237"+"|"+"237 PUTNAM";
codes006[10]= "289"+"|"+"289 TWIGGS";
codes006[11]= "319"+"|"+"319 WILKINSON";

var codes007 = new Array();
codes007[0]= "|"; 
codes007[1]= "033"+"|"+"033 BURKE";
codes007[2]= "073"+"|"+"073 COLUMBIA";
codes007[3]= "125"+"|"+"125 GLASCOCK";
codes007[4]= "141"+"|"+"141 HANCOCK";
codes007[5]= "163"+"|"+"163 JEFFERSON";
codes007[6]= "165"+"|"+"165 JENKINS";
codes007[7]= "181"+"|"+"181 LINCOLN";
codes007[8]= "189"+"|"+"189 MCDUFFIE";
codes007[9]= "245"+"|"+"245 RICHMOND";
codes007[10]= "251"+"|"+"251 SCREVEN";
codes007[11]= "265"+"|"+"265 TALIAFERRO";
codes007[12]= "301"+"|"+"301 WARREN";
codes007[13]= "303"+"|"+"303 WASHINGTON";
codes007[14]= "317"+"|"+"317 WILKES";

var codes008 = new Array();
codes008[0]= "|"; 
codes008[1]= "053"+"|"+"053 CHATTAHOOCHEE";
codes008[2]= "061"+"|"+"061 CLAY";
codes008[3]= "081"+"|"+"081 CRISP";
codes008[4]= "093"+"|"+"093 DOOLY";
codes008[5]= "145"+"|"+"145 HARRIS";
codes008[6]= "193"+"|"+"193 MACON";
codes008[7]= "197"+"|"+"197 MARION";
codes008[8]= "215"+"|"+"215 MUSCOGEE";
codes008[9]= "239"+"|"+"239 QUITMAN";
codes008[10]= "243"+"|"+"243 RANDOLPH";
codes008[11]= "249"+"|"+"249 SCHLEY";
codes008[12]= "259"+"|"+"259 STEWART";
codes008[13]= "261"+"|"+"261 SUMTER";
codes008[14]= "263"+"|"+"263 TALBOT";
codes008[15]= "269"+"|"+"269 TAYLOR";
codes008[16]= "307"+"|"+"307 WEBSTER";

var codes009 = new Array();
codes009[0]= "|"; 
codes009[1]= "001"+"|"+"001 APPLING";
codes009[2]= "023"+"|"+"023 BLECKLEY";
codes009[3]= "043"+"|"+"043 CANDLER";
codes009[4]= "091"+"|"+"091 DODGE";
codes009[5]= "107"+"|"+"107 EMANUEL";
codes009[6]= "109"+"|"+"109 EVANS";
codes009[7]= "161"+"|"+"161 JEFF DAVIS";
codes009[8]= "167"+"|"+"167 JOHNSON";
codes009[9]= "175"+"|"+"175 LAURENS";
codes009[10]= "209"+"|"+"209 MONTGOMERY";
codes009[11]= "267"+"|"+"267 TATTNALL";
codes009[12]= "271"+"|"+"271 TELFAIR";
codes009[13]= "279"+"|"+"279 TOOMBS";
codes009[14]= "283"+"|"+"283 TREUTLEN";
codes009[15]= "305"+"|"+"305 WAYNE";
codes009[16]= "309"+"|"+"309 WHEELER";
codes009[17]= "315"+"|"+"315 WILCOX";

var codes010 = new Array();
codes010[0]= "|"; 
codes010[1]= "007"+"|"+"007 BAKER";
codes010[2]= "037"+"|"+"037 CALHOUN";
codes010[3]= "071"+"|"+"071 COLQUITT";
codes010[4]= "087"+"|"+"087 DECATUR";
codes010[5]= "095"+"|"+"095 DOUGHERTY";
codes010[6]= "099"+"|"+"099 EARLY";
codes010[7]= "131"+"|"+"131 GRADY";
codes010[8]= "177"+"|"+"177 LEE";
codes010[9]= "201"+"|"+"201 MILLER";
codes010[10]= "205"+"|"+"205 MITCHELL";
codes010[11]= "253"+"|"+"253 SEMINOLE";
codes010[12]= "273"+"|"+"273 TERRELL";
codes010[13]= "275"+"|"+"275 THOMAS";
codes010[14]= "321"+"|"+"321 WORTH";

var codes011 = new Array();
codes011[0]= "|"; 
codes011[1]= "003"+"|"+"003 ATKINSON";
codes011[2]= "005"+"|"+"005 BACON";
codes011[3]= "017"+"|"+"017 BEN HILL";
codes011[4]= "019"+"|"+"019 BERRIEN";
codes011[5]= "025"+"|"+"025 BRANTLEY";
codes011[6]= "027"+"|"+"027 BROOKS";
codes011[7]= "049"+"|"+"049 CHARLTON";
codes011[8]= "065"+"|"+"065 CLINCH";
codes011[9]= "069"+"|"+"069 COFFEE";
codes011[10]= "075"+"|"+"075 COOK";
codes011[11]= "101"+"|"+"101 ECHOLS";
codes011[12]= "155"+"|"+"155 IRWIN";
codes011[13]= "173"+"|"+"173 LANIER";
codes011[14]= "185"+"|"+"185 LOWNDES";
codes011[15]= "229"+"|"+"229 PIERCE";
codes011[16]= "277"+"|"+"277 TIFT";
codes011[17]= "287"+"|"+"287 TURNER";
codes011[18]= "299"+"|"+"299 WARE";

var codes012 = new Array();
codes012[0]= "|"; 
codes012[1]= "029"+"|"+"029 BRYAN";
codes012[2]= "031"+"|"+"031 BULLOCH";
codes012[3]= "039"+"|"+"039 CAMDEN";
codes012[4]= "051"+"|"+"051 CHATHAM";
codes012[5]= "103"+"|"+"103 EFFINGHAM";
codes012[6]= "127"+"|"+"127 GLYNN";
codes012[7]= "179"+"|"+"179 LIBERTY";
codes012[8]= "183"+"|"+"183 LONG";
codes012[9]= "191"+"|"+"191 MCINTOSH";

var codes013 = new Array();
codes013[0]= "|"; 
codes013[1]= "121"+"|"+"121 FULTON";

var codes014 = new Array();
codes014[0]= "|"; 
codes014[1]= "089"+"|"+"089 DEKALB";

var codes015 = new Array();
codes015[0]= "|"; 
codes015[1]= "135"+"|"+"135 GWINNETT";
codes015[2]= "247"+"|"+"247 ROCKDALE";

var codes016 = new Array();
codes016[0]= "|"; 
codes016[1]= "063"+"|"+"063 CLAYTON";
codes016[2]= "113"+"|"+"113 FAYETTE";
codes016[3]= "151"+"|"+"151 HENRY";

var codes017 = new Array();
codes017[0]= "|"; 
codes017[1]= "057"+"|"+"057 CHEROKEE";
codes017[2]= "067"+"|"+"067 COBB";
codes017[3]= "097"+"|"+"097 DOUGLAS";

var codes097 = new Array();
codes097[0]= "|"; 
codes097[1]= "999"+"|"+"999 OUT OF STATE";

var codes099 = new Array();
codes099[0]= "|"; 
codes099[1]= "XXX"+"|"+"XXX -None-";

<impact:codeArray codeName="CCOUNT" arrayName="countyCodes" blankValue="true" orderBy="decode"/>

function updateCountyCodes()
{
	var category = "";
	var county = "";
	var options = "";

	if(category==""||category){
	  //populateDropdown( frmCaseSummary.selSzCdCounty , "", countyCodes );
	}else{
	  var codeArray = eval("codes" + category);
	  if(options){
	
	  }else{
	     //populateDropdown( frmCaseSummary.selSzCdCounty , "", codeArray );
	  }
	}
	//document.frmCaseSummary.selSzCdCounty.value=county;
}
// end STGAP00002833

</script>

<impact:validateErrors/>
<impact:validateForm name="frmCaseSummary"
                     method="post"
                     action="/workload/CaseSummary/displayCaseSummary"
                     validationClass="gov.georgia.dhr.dfcs.sacwis.web.workload.CaseSummaryCustomValidation"
                     pageMode="<%=pageMode%>"
                     schema="/WEB-INF/Constraints.xsd">
<impact:validateInput type="hidden" name="pageMode" value=""/>
<impact:validateInput type="hidden" name="arrayIndex" value=""/>
<impact:validateInput type="hidden" name="pendStatus" value=""/>
<impact:validateInput type="hidden" name="staffNameMerge" value=""/>
<impact:validateInput type="hidden" name="staffNameSplit" value=""/>
<impact:validateInput type="hidden" name="idCaseMerge" value=""/>
<impact:validateInput type="hidden" name="hdnCReqFuncCd" value=""/>
<impact:validateInput type="hidden" name="hdnDataAction" value=""/>
<impact:validateInput type="hidden" name="hdnCScrIndStageMerged" value=""/>
<impact:validateInput type="hidden" name="hdnSzNmStage" value=""/>
<impact:validateInput type="hidden" name="hdnSzCdStage" value=""/>
<impact:validateInput type="hidden" name="hdnSzCdStageType" value=""/>
<impact:validateInput type="hidden" name="hdnSzCdStageLevel" value=""/>
<impact:validateInput type="hidden" name="hdnDtDtStageStart" value=""/>
<impact:validateInput type="hidden" name="hdnDtDtStageClose" value=""/>
<impact:validateInput type="hidden" name="hdnSzNmPersonFull" value=""/>
<impact:validateInput type="hidden" name="hdnSzCdStageRegion" value=""/>
<impact:validateInput type="hidden" name="hdnSzCdStageCounty" value=""/>
<impact:validateInput type="hidden" name="hdnUlIdStage" value=""/>
<impact:validateInput type="hidden" name="hdnHasAccess" value=""/>
<impact:validateInput type="hidden" name="hdnAdminCommand" value=""/>
<impact:validateInput type="hidden" name="hdnUlIdAdoCase" value=""/>
<impact:validateInput type="hidden" name="hdnSelectedStageCode" value="<%=selectedStageCode%>"/>
<impact:validateInput type="hidden" name="hdnSelectedStageId" value="<%=FormattingHelper.formatInt(selectedStageId) %>"/>
<impact:validateInput type="hidden" name="hdnSelectedStageDateClosed" value="<%=FormattingHelper.formatDate(selectedStageDateClosed)%>"/>
<% // SIR 22406 - If no Records Retention Section set indicator
if (bIndHasRecordsRet) { %>
<impact:validateInput type="hidden" name="indHasRecordsRet" value="Y"/>
<%
} else {
%>
<impact:validateInput type="hidden" name="indHasRecordsRet" value="N"/>
<%
  }
  
  String szStageType = GlobalData.getSzCdStage(request);
%>

<%-- Begin Case Information--%>
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
  <tr>
    <th colspan="6">Case Information</th>
  </tr>
  <tr>
  <td>
      <impact:validateDisplayOnlyField
              label="Case"
              name="hdnUlIdCase"
              colspan="1"
              value="<%= FormattingHelper.formatString(GlobalData.getSzNmCase( request ) ) %>"/>
    </td>
    <td>
      <impact:validateDisplayOnlyField
              label="Case ID"
              name="hdnUlIdCase"
              colspan="1"
              value="<%= String.valueOf( GlobalData.getUlIdCase( request ) ) %>"/>
    </td>
    <td>
      <impact:validateDisplayOnlyField
              label="County"
              name="txtSzCdCaseCounty"
              colspan="1"
              value="<%= FormattingHelper.initCapsName( Lookup.simpleDecodeSafe( CodesTables.CCOUNT, caseSummary.getSzCdCaseCounty() )) %>"/>
    </td>
  </tr>
</table>
<%-- End Case Information--%>
<br/>


<%-- Begin Stage List --%>
<impact:pagination submitUrl="/workload/CaseSummary/displayCaseSummary" saveState="false">
    <table width="100%" cellspacing="0" cellpadding="3" border="0">
      <tr>
        <th class="thList">Stage Name</th>
        <th class="thList">Stage</th>
        <th class="thList">Opened</th>
        <th class="thList">Closed</th>
        <th class="thList">Case Manager</th>
        <th class="thList">County</th>
      </tr>
      <%
        // Get the stage id for the selected stage.
        selectedStageId = GlobalData.getUlIdStage(request);
        if (request.getParameter("radioIndex_CLEAN") != null) {
          selectedStageId = ContextHelper.getIntSafe(request, "hdnUlIdStage");
        }

        Enumeration caseSummaryEnumeration2 = caseSummaryArray.enumerateROWCCMN37SOG02();
        if (!caseSummaryEnumeration2.hasMoreElements()) {%>
      <tr class="odd">
        <td colspan="11">
          <%= MessageLookup.getMessageByName("SSM_NO_ROWS_RETURNED") %>
        </td>
      </tr>
      <%
      } else {
        while (caseSummaryEnumeration2.hasMoreElements()) {
          ROWCCMN37SOG02 caseSummaryRow = (ROWCCMN37SOG02) caseSummaryEnumeration2.nextElement();
      %>
      <tr class="<%=FormattingHelper.getRowCss( loopCount + 1 )%>" valign="top">
        <%
          // Determine whether or not the current stage is the selected stage. If it is the selected stage,
          //   get the stage id, stage code and closure date.
          int currentRowStageId = caseSummaryRow.getUlIdStage();
          if (selectedStageId == currentRowStageId) {
            selectedIndex = loopCount;
            selectedStageId = caseSummaryRow.getUlIdStage();
            selectedStageCode = caseSummaryRow.getSzCdStage();
            selectedStageDateClosed = caseSummaryRow.getDtDtStageClose();
          }
        %>
        <td>
         <a href='javascript:selectStageFromLink(<%=loopCount%>)'
             tabIndex="<%=tabIndex++%>"
          ><%=caseSummaryRow.getSzNmStage()%>
  		</a>
        </td>
        <td><%= Lookup.simpleDecodeSafe(CodesTables.CTXTOGA, caseSummaryRow.getSzCdStage()) %>
        </td>
        <td><%= FormattingHelper.formatDate(caseSummaryRow.getDtDtStageStart())%>
        </td>
        <td><%= FormattingHelper.formatDate(caseSummaryRow.getDtDtStageClose())%>
        </td>
        <td>
          <NOBR><%= caseSummaryRow.getSzNmPersonFull() %>
          </NOBR>
        </td>
        <td><%= FormattingHelper.initCapsName(Lookup.simpleDecodeSafe(CodesTables.CCOUNT,
                                                                      caseSummaryRow.getSzCdStageCounty()))%>
        </td>
      </tr>
      <div style="display:none"><%= "SituationID:" + caseSummaryRow.getUlIdSituation() %>
      </div>
      <%
            loopCount++;
          }
        }
      %>
    </table>
</impact:pagination>
<%-- End Stage List --%>

<%-- Begin Case Errors--%>
<impact:ifThen test='<%=!((caseErrors== null)||(caseErrors.isEmpty()))%>'>
	<table width="100%" cellspacing="0" cellpadding="3" class="tableBorder">
		<tr>
		  <th class="thList">Case Errors:&nbsp;<span style="color:red"><%= caseErrorCount%></span></th>
		</tr>
		<tr class="subDetail">
		  <td width="100%" class="formlabel">
		    <div id="errors" style="width:100%; height:100px; overflow:auto" class="tableBorder">
		      <table width="100%" border="0" cellspacing="0" cellpadding="3">
		        
		<%
		int errorLoopCount = 0;
		if ((caseErrors== null)||(caseErrors.isEmpty())) {
		%>        
		        <tr class="odd">
		            <td>
		              <%= MessageLookup.getMessageByNumber( Messages.SSM_NO_ROWS_RETURNED ) %>
		            </td>
		        </tr>
		<%}
		        
		        else {
		          Iterator<String> iterator = caseErrors.iterator();
		          while (iterator.hasNext()) {
		            String errorCode = iterator.next();
		%>
		
	               <tr class="<%= FormattingHelper.getRowCss( errorLoopCount + 1 ) %>">
                      <td class = "error">
                      	<span style="color:red">
	                      <%= FormattingHelper.formatString(
	                      Lookup.simpleDecodeSafe( "CCASEERR", errorCode ) )%>
	                    </span>
                      </td>
	               </tr>
		<%			errorLoopCount++;
		          }
		        }
		%>
		        
		      </table>
		    </div>
		  </td>
		</tr>
	</table>
	<br>
</impact:ifThen>
<%-- End Case Errors--%>

<%-- Begin Case Warnings--%>
<impact:ifThen test='<%=!((caseWarnings== null)||(caseWarnings.isEmpty()))%>'>
	<table width="100%" cellspacing="0" cellpadding="3" class="tableBorder">
		<tr>
		  <th class="thList">Case Warnings:&nbsp;<span style="color:blue"><%= caseWarningCount%></span></th>
		</tr>
		<tr class="subDetail">
		  <td width="100%" class="formlabel">
		    <div id="warnings" style="width:100%; overflow:auto" class="tableBorder">
		      <table width="100%" border="0" cellspacing="0" cellpadding="3">
		        
		<%
		int warningLoopCount = 0;
		if ((caseWarnings== null)||(caseWarnings.isEmpty())) {
		%>        
		        <tr class="odd">
		            <td>
		              <%= MessageLookup.getMessageByNumber( Messages.SSM_NO_ROWS_RETURNED ) %>
		            </td>
		        </tr>
		<%}
		        
		        else {
		          Iterator<String> iterator = caseWarnings.iterator();
		          while (iterator.hasNext()) {
		            String warningCode = iterator.next();
		%>
		
	               <tr class="<%= FormattingHelper.getRowCss( warningLoopCount + 1 ) %>">
                      <td class = "warning">
                      	<span style="color:blue">
	                      <%= FormattingHelper.formatString(
	                      Lookup.simpleDecodeSafe( "CCASEWAR", warningCode ) )%>
	                    </span>
                      </td>
	               </tr>
		<%			warningLoopCount++;
		          }
		        }
		%>
		        
		      </table>
		    </div>
		  </td>
		</tr>
	</table>
	<br>
</impact:ifThen>
<%-- End Case Warnings--%>

<script type="text/javascript" language="JavaScript1.2">
  <%
    ROWCCMN37SOG02[] rowccmn37sog02array = caseSummaryArray.getROWCCMN37SOG02();
  %>
  var stageArray = new Array(<%= rowccmn37sog02array.length %>);
  <%
    for (int i = 0; i < rowccmn37sog02array.length; i++) {
  %>
  stageArray[<%= i %>] = new Object();
  stageArray[<%= i %>].cScrIndStageMerged = "<%= rowccmn37sog02array[i].getCScrIndStageMerged() %>";
  stageArray[<%= i %>].szNmStage =
  "<%= FormattingHelper.formatStringSpecialChars(rowccmn37sog02array[i].getSzNmStage(), "\\\"") %>"
  stageArray[<%= i %>].szCdStage = "<%= rowccmn37sog02array[i].getSzCdStage() %>";
  stageArray[<%= i %>].bIndEcsVer = "<%= rowccmn37sog02array[i].getBIndEcsVer() %>";
  stageArray[<%= i %>].szCdStageLevel = "<%= rowccmn37sog02array[i].getSzCdStageLevel() %>";
  stageArray[<%= i %>].dtDtStageStart = "<%= rowccmn37sog02array[i].getDtDtStageStart() %>";
  stageArray[<%= i %>].dtDtStageClose = "<%= rowccmn37sog02array[i].getDtDtStageClose() %>";
  stageArray[<%= i %>].szNmPersonFull =
  "<%= FormattingHelper.formatStringSpecialChars(rowccmn37sog02array[i].getSzNmPersonFull(), "\\\"") %>"
  stageArray[<%= i %>].szCdStageCounty = "<%= rowccmn37sog02array[i].getSzCdStageCounty() %>";
  stageArray[<%= i %>].ulIdStage = "<%= rowccmn37sog02array[i].getUlIdStage() %>";
  stageArray[<%= i %>].ulIdCase = "<%= rowccmn37sog02array[i].getUlIdCase() %>";
  <%
  }
  %>
</script>

<%
  boolean bDisableReopenStage = true;

  // STGAP00014341: If the user has the 'Stage Reopen' attibute, they are allowed to reopen any stages.
  //   Enable the Reopen Stage button.
  if (user.hasRight(UserProfile.SEC_STAGE_REOPEN)) {
    bDisableReopenStage = false;
  }
%>






<br/>

<%-- Always include this hidden field in your form --%>
<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>"/>
</impact:validateForm>

<script type="text/javascript" language="javascript">
function selectStageFromLink(index) {
  var form = document.frmCaseSummary;
  form.hdnSzNmStage.value = stageArray[index].szNmStage;
  form.hdnSzCdStage.value = stageArray[index].szCdStage;
  form.hdnSzCdStageType.value = stageArray[index].szCdStageType;
  form.hdnSzCdStageLevel.value = stageArray[index].szCdStageLevel;
  form.hdnDtDtStageStart.value = stageArray[index].dtDtStageStart;
  form.hdnDtDtStageClose.value = stageArray[index].dtDtStageClose;
  form.hdnSzNmPersonFull.value = stageArray[index].szNmPersonFull;
  form.hdnSzCdStageRegion.value = stageArray[index].szCdStageRegion;
  form.hdnSzCdStageCounty.value = stageArray[index].szCdStageCounty;
  form.hdnUlIdStage.value = stageArray[index].ulIdStage;
  form.hdnUlIdAdoCase.value = stageArray[index].ulIdCase;  
  submitValidateForm("frmCaseSummary", "/workload/StageSummary/displayStageSummary");
}
</script>





<%-- Begin Forms and Reports; Begin of commenting out Forms and Reports section
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
<tr>
<th colspan="4">Forms and Reports </th>
</tr>
<tr>
<td>
<impact:reportList tabIndex="<%= tabIndex++ %>" personId="<%= user.getUserID() %>">
  <%
    String emailMessageString = "Case File Cover for Case ID = " + GlobalData.getUlIdCase(request);
  %>
  <impact:report useHiddenParameters="false" reportName="ccf02o00" emailMessage="<%= emailMessageString %>">
    <impact:reportParameter value="<%= String.valueOf(GlobalData.getUlIdCase( request )) %>"/>
  </impact:report>
  <% if (selectedIndex != -1 && ("SUB".equals(GlobalData.getSzCdStage(request)) ||
                                 "ADO".equals(GlobalData.getSzCdStage(request)) ||
                                 "FPR".equals(GlobalData.getSzCdStage(request)) ||
                                 "FRE".equals(GlobalData.getSzCdStage(request)) ||
                                 "FSU".equals(GlobalData.getSzCdStage(request)))) {
    emailMessageString = GlobalData.getSzCdStage(request) + " " +
                         GlobalData.getUlIdStage(request) + " Reading Tool~" + GlobalData.getSzNmStage(request);
  %>
  <impact:report useHiddenParameters="false" reportName="csd01o00" emailMessage="<%= emailMessageString %>">
    <impact:reportParameter value="<%= String.valueOf(GlobalData.getUlIdStage( request )) %>"/>
  </impact:report>
  <%
    }
    if ("CPS".equals(GlobalData.getSzCdStageProgram(request))) {
      emailMessageString =
              "Case " + GlobalData.getUlIdCase(request) + " Case Name " + GlobalData.getSzNmCase(request);
  %>
  <impact:report useHiddenParameters="false" reportName="csd07o00" emailMessage="<%= emailMessageString %>">
    <impact:reportParameter value="<%= String.valueOf(GlobalData.getUlIdCase( request )) %>"/>
  </impact:report>
  <%
    }
  %>
</impact:reportList>
</td>
</tr>
</table>
end of Forms and Reports section -->
End commmenting out of Forms and Reports --%>



