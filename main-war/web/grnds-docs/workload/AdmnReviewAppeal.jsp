
<%@page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper"%>
<%
//*  JSP Name:     Admin Review & Appeal
//*  Created by:   Rodrigo DeJuana
//*  Date Created: 12/20/02
//*
//*  Description:
//*   The Administrative Review and Appeal page
//*   allows users to record or view information about the
//*   status of an Administrative Review. Administrative
//*   reviews may be recorded for Investigations, the
//*   Release Hearing process, and Foster/Adoptive Home decisions.
//*   This page will allow for the identification of
//*   the Person Reviewed (for Investigations or Release
//*   Hearings), the applicable tracking dates, the
//*   Authority making a determination, the status of the
//*   review, and a result code. If applicable, information
//*   on the Release Hearing process can also be tracked.
//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  ----------------------------------------------
//**  06/09/03  GRIMSHAN          SIR 16979 Get pagemode from page mode instead
//**                              of from page mode attribute name
//**  06/18/03  LAURAMC           SIR 18219 Address style issues.  Remove extra
//**                              br, hr and left align narrative button
//**  02/19/04  thompswa          SIR 22585 Add a new type of review called
//**                              "Preponderance Review".  (For CPS only).
//**  02/20/04  thompswa          SIR 22654 Add a new type of review called
//**                              "Employee Misconduct Registry".(For APS, AFC).
//**  02/23/04  thompswa          SIR 22678 Removed "disabled" attribute from
//**                              the tag for the "Reviewed Person Notifed On"
//**                              field.
//**  06/28/04  Todd Reser        SIR 22937 - Switch between CPS & APS versions
//**                              of Cover Letter to Requestor and Notif to
//**                              Parent/Prof Reporter (Spanish or English)
//**  02/16/10  hnguyen			  STGAP00015822 Add form launch for Response 
//**							  to Case Review Request and Administrative 
//**							  Review Decision Letter forms.
%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables,gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC43SO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC43SOG00" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG00"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG02_ARRAY"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG02"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC42SI" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.workload.AdmnReviewConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.Option"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>

<%

  String pageMode = PageMode.getPageMode( request );
  BaseSessionStateManager state =
         (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
  //If the mode was set in the activity method, get it
  //Everything above this point should be in every page.
  int tabIndex = 1;
%>

<%
  CCFC43SO ccfc43so = (CCFC43SO) state.getAttribute( "CCFC43SO", request );
  if ( ccfc43so == null )
  {
    ccfc43so = new CCFC43SO();
  }
  CCFC43SOG00 ARIDetail = (ccfc43so.getCCFC43SOG00() != null) ? ccfc43so.getCCFC43SOG00() : new CCFC43SOG00();
  
  ROWCCMN01UIG00 EventStatus = ( ccfc43so.getROWCCMN01UIG00() != null ) ? ccfc43so.getROWCCMN01UIG00() : new ROWCCMN01UIG00();

  String bAFC = ( GlobalData.getSzCdStageProgram( request ).equals(AdmnReviewConversation.PROG_AFC) ) ? "true" : "false" ;
  String bARF = ( GlobalData.getSzCdStage( request ).equals(AdmnReviewConversation.ADMIN_REVIEW_ARF) ) ? "true" : "false" ;
  boolean bARI = ( GlobalData.getSzCdStage( request ).equals(AdmnReviewConversation.ADMIN_REVIEW_ARI) ) ? true : false ;
//SIR 22585 Add boolean and exOptions for CPS only for CARVTYPE_050.
//SIR 22654 Add boolean and exOptions for APS, AFC for CARVTYPE_060.
  boolean bCps = ( GlobalData.getSzCdStageProgram( request ).equals(AdmnReviewConversation.PROG_CPS) ) ? true : false ;
  boolean bAps = ( GlobalData.getSzCdStageProgram( request ).equals(AdmnReviewConversation.PROG_APS) ) ? true : false ;
  boolean bAfc = ( GlobalData.getSzCdStageProgram( request ).equals(AdmnReviewConversation.PROG_AFC) ) ? true : false ;

  List exOptions = new ArrayList();
  if ( bARI )
  {
   // exOptions.add(CodesTables.CARVTYPE_020);
    if ( !bCps )
    {
    //  exOptions.add(CodesTables.CARVTYPE_050);
    }
    if ( !bAps && !bAfc)
    {
      exOptions.add(CodesTables.CARVTYPE_060);
    }
  }
  

  boolean bFindings = Boolean.valueOf((String) request.getAttribute("bFindings"));
  boolean bReqParent = Boolean.valueOf((String) request.getAttribute("bReqParent"));
  boolean bNotif = Boolean.valueOf((String) request.getAttribute("bNotif"));
  boolean bLic = Boolean.valueOf((String) request.getAttribute("bLic"));
  String eventID = (String)request.getAttribute( "AdminReviewEventID" );
  String txtRsnApprvDeny = ARIDetail.getSztxtRsnApprvDeny();
  String originalINVStage = String.valueOf(ARIDetail.getUlIdStageRelated());
  String caseID = String.valueOf(ARIDetail.getUlIdCase());
    
  
  boolean showInitOnly = (ARIDetail.getSzCdAdminRvAppealType() == null || ARIDetail.getSzCdAdminRvAppealType().length() == 0) ? true : false;
  boolean showNonAdminReview = ((showInitOnly == false) && (CodesTables.CARVTYPE_020.equals(ARIDetail.getSzCdAdminRvAppealType())) == false) ? true :false;
  boolean shownIntermediateAdminMode = (CodesTables.CARVTYPE_020.equals(ARIDetail.getSzCdAdminRvAppealType()) == true) ? true :false;
  boolean shownIntermediateAdminModeOnly = (shownIntermediateAdminMode == true && (ARIDetail.getSzCdAdminRvIndLevel() == null || ARIDetail.getSzCdAdminRvIndLevel().length() == 0));
  
  boolean showSaveSubmit = (showInitOnly == true || shownIntermediateAdminModeOnly == true) ? false : true;
  
  boolean showForms = (shownIntermediateAdminMode == true && shownIntermediateAdminModeOnly == false);
  boolean protectDocument = (PageModeConstants.VIEW.equals(pageMode) == true) ? true : false;
  boolean showLevelOneOnly = "1".equals(ARIDetail.getSzCdAdminRvIndLevel()) && shownIntermediateAdminMode == true;
  boolean showLevelTwoThree = "2".equals(ARIDetail.getSzCdAdminRvIndLevel()) && shownIntermediateAdminMode == true;
  boolean showLevelThree =  "2".equals(ARIDetail.getSzCdAdminRvIndLevel()) && "Y".equals(ARIDetail.getBInd2lvlAdmRvComp());
  Boolean disableFirstLevel = (PageModeConstants.VIEW.equals(pageMode) == true) || (showLevelTwoThree == true);
  Boolean disableSecondLevel = (PageModeConstants.VIEW.equals(pageMode) == true) || "Y".equals(ARIDetail.getBInd2lvlAdmRvComp());
  Boolean disableThridLevel = (PageModeConstants.VIEW.equals(pageMode) == true);
  Integer ulIdCommisDes = (request.getAttribute("hdnUlIdCommisDes") != null) ? (Integer) request.getAttribute("hdnUlIdCommisDes") : new Integer(0);
  
  if(showLevelTwoThree == true && disableSecondLevel == false) {
  	showSaveSubmit = false;
  }
  
  String cdAdminRvStatusValue = (showInitOnly == true) ? CodesTables.CARVSTAT_010 : ARIDetail.getSzCdAdminRvStatus();
  List<String> exStatusOptions = new ArrayList<String>();
  if(showInitOnly == true) {
  	exStatusOptions.add(CodesTables.CARVSTAT_020);
  	exStatusOptions.add(CodesTables.CARVSTAT_040);
  	exStatusOptions.add(CodesTables.CARVSTAT_050);
  	exStatusOptions.add(CodesTables.CARVSTAT_060);
  }
  
  
  
  // This initially checks the Staff Radio Buttons
  String Lgl_No   = "false";
  String Lgl_Yes   = "false";
  String SAAG_No    = "true";
  String SAAG_Yes    = "false";

  //SIR 19794 - Added Sets.H

  // Check the request, if a search has been performed pull it out of there
    if ("Y".equalsIgnoreCase(ARIDetail.getBIndLglRepresentation()))
    {
      Lgl_Yes = "true";
      Lgl_No  = "false";
    }
    else if  ("N".equalsIgnoreCase(ARIDetail.getBIndLglRepresentation()))
    {
      Lgl_No  = "true";
      Lgl_Yes = "false";
    }
    
  if ("Y".equalsIgnoreCase(ARIDetail.getBIndSaagNotification()))
    {
      SAAG_Yes = "true";
      SAAG_No  = "false";
    }
    else if ("N".equalsIgnoreCase(ARIDetail.getBIndSaagNotification()))
    {
      SAAG_No = "true";
      SAAG_Yes = "false";
    }

  // This initially checks the 1st levl Staff Radio Buttons
  String Lgl1lvl_No   = "false";
  String Lgl1lvl_Yes   = "false";
  String SAAG1lvl_No    = "false";
  String SAAG1lvl_Yes    = "false";

  //SIR 19794 - Added Sets.H

  // Check the request, if a search has been performed pull it out of there
    if ("Y".equalsIgnoreCase(ARIDetail.getBInd1lvlLglRepresentation()))
    {
      Lgl1lvl_Yes = "true";
      Lgl1lvl_No  = "false";
    }
    else if  ("N".equalsIgnoreCase(ARIDetail.getBInd1lvlLglRepresentation()))
    {
      Lgl1lvl_No  = "true";
      Lgl1lvl_Yes = "false";
    }
    
  if ("Y".equalsIgnoreCase(ARIDetail.getBInd1lvlSaagNotification()))
    {
      SAAG1lvl_Yes = "true";
      SAAG1lvl_No  = "false";
    }
    else if ("N".equalsIgnoreCase(ARIDetail.getBInd1lvlSaagNotification()))
    {
      SAAG1lvl_No = "true";
      SAAG1lvl_Yes = "false";
    }
    
    // This initially checks the 1st levl Staff Radio Buttons
  String Lgl2lvl_No   = "false";
  String Lgl2lvl_Yes   = "false";
  String SAAG2lvl_No    = "false";
  String SAAG2lvl_Yes    = "false";

  //SIR 19794 - Added Sets.H

  // Check the request, if a search has been performed pull it out of there
    if ("Y".equalsIgnoreCase(ARIDetail.getBInd2lvlLglRepresentation()))
    {
      Lgl2lvl_Yes = "true";
      Lgl2lvl_No  = "false";
    }
    else if  ("N".equalsIgnoreCase(ARIDetail.getBInd2lvlLglRepresentation()))
    {
      Lgl2lvl_No  = "true";
      Lgl2lvl_Yes = "false";
    }
    
  if ("Y".equalsIgnoreCase(ARIDetail.getBInd2lvlSaagNotification()))
    {
      SAAG2lvl_Yes = "true";
      SAAG2lvl_No  = "false";
    }
    else if ("N".equalsIgnoreCase(ARIDetail.getBInd2lvlSaagNotification()))
    {
      SAAG2lvl_No = "true";
      SAAG2lvl_Yes = "false";
    }
    
    ROWCCMN01UIG02_ARRAY rowccmn01uig02_array = ARIDetail.getROWCCMN01UIG02_ARRAY();
    List<Option> stageList = new ArrayList<Option>();
    if(rowccmn01uig02_array != null && rowccmn01uig02_array.getROWCCMN01UIG02Count() > 0) {
    	Iterator<ROWCCMN01UIG02> itRow = rowccmn01uig02_array.iterateROWCCMN01UIG02();
    	while (itRow.hasNext()) {
    		ROWCCMN01UIG02 rowccmn01uig02 = itRow.next();
    		stageList.add(new Option(""+rowccmn01uig02.getUlIdStage(), rowccmn01uig02.getUlIdStage() + " - " + rowccmn01uig02.getSzNmStage()));
    	}
    }  
    String priorStage = (ARIDetail.getUlAdmRev2lvlPriorStage() > 0) ? ""+ARIDetail.getUlAdmRev2lvlPriorStage() : "";
%>
<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>

<script type="text/javascript" language="JavaScript1.2">
  window.onbeforeunload = function ()
  {
      IsDirty();
  };

function setDueDate(value)
{
  var dateString = validateDateString(value);
  date = new Date(dateString);
  var year = date.getYear();
  if (year < 2000)
  {
    year += 1900;
  }
  if ( ( date.getMonth() >= 0 && date.getMonth() < 12 ) &&
       ( date.getDate() > 0 && date.getDate() < 32 ) &&
       ( year > 1970 ) )
  {
    date = new Date(date.valueOf() + 2592000000);
    year = date.getYear();
    if (year < 2000)
    {
      year += 1900;
    }
    newDate = date.getMonth()+1 + "/" + date.getDate() + "/" + year;
    document.frmAdmnReview.txtDtDtAdminRvDue.value = newDate;
  }
  document.frmAdmnReview.txtDtDtAdminRvReqAppeal.value = dateString;
}

function set1LvlDueDate(value)
{
  var dateString = validateDateString(value);
  date = new Date(dateString);
  var year = date.getYear();
  if (year < 2000)
  {
    year += 1900;
  }
  if ( ( date.getMonth() >= 0 && date.getMonth() < 12 ) &&
       ( date.getDate() > 0 && date.getDate() < 32 ) &&
       ( year > 1970 ) )
  {
    date = new Date(date.valueOf() + 2592000000);
    year = date.getYear();
    if (year < 2000)
    {
      year += 1900;
    }
    newDate = date.getMonth()+1 + "/" + date.getDate() + "/" + year;
    document.frmAdmnReview.txtDtDt1lvlAdminRvDue.value = newDate;
  }
  document.frmAdmnReview.txtDtDt1lvlAdminRvReqAppeal.value = dateString;
}

function set2LvlDueDate(value)
{
  var dateString = validateDateString(value);
  date = new Date(dateString);
  var year = date.getYear();
  if (year < 2000)
  {
    year += 1900;
  }
  if ( ( date.getMonth() >= 0 && date.getMonth() < 12 ) &&
       ( date.getDate() > 0 && date.getDate() < 32 ) &&
       ( year > 1970 ) )
  {
    date = new Date(date.valueOf() + 3888000000);
    year = date.getYear();
    if (year < 2000)
    {
      year += 1900;
    }
    newDate = date.getMonth()+1 + "/" + date.getDate() + "/" + year;
    document.frmAdmnReview.txtDtDt2lvlAdminRvDue.value = newDate;
  }
  document.frmAdmnReview.txtDtDt2lvlAdminRvReqAppeal.value = dateString;
}

function closePage(){
	<% if(showForms) { %>
	return confirm('<%=MessageLookup.getMessageByNumber(Messages.MSG_ARI_FORMS_UPDATE)%>');
	<% } %>
	return true;
}

function savePage(){
    <% if(showInitOnly == false) { %>
    var origType = '<%=ARIDetail.getSzCdAdminRvAppealType()%>';
    if( origType != frmAdmnReview.selSzCdAdminRvAppealType.value ) {
     var conf = confirm('<%=MessageLookup.getMessageByNumber(Messages.MSG_ARI_REVIEW_TYPE_CHANGE)%>');
     if(conf == true) {
     	disableValidation( "frmAdmnReview" );
     }
     return conf;
    }
	<% } %>
	
	<% if(shownIntermediateAdminModeOnly == false && shownIntermediateAdminMode == true) { %>
    var origLevel = '<%=ARIDetail.getSzCdAdminRvIndLevel()%>';
    if((origLevel == '1' && frmAdmnReview.rbIndAdminLevel[1].checked) || (origLevel == '2' && frmAdmnReview.rbIndAdminLevel[0].checked)) {
     var conf =  confirm('<%=MessageLookup.getMessageByNumber(Messages.MSG_ARI_REVIEW_TYPE_CHANGE)%>');
      if(conf == true) {
     	disableValidation( "frmAdmnReview" );
     }
     return conf;
    }
    <% } %>
    <% if(showLevelTwoThree == true && disableSecondLevel == false) { %>
    if((frmAdmnReview.cb2lvlAdmRv2ndStageComp.checked)) {
     return confirm('<%=MessageLookup.getMessageByNumber(Messages.MSG_ARI_SEC_LEVEL_COMPLETE)%>');
    }    
	<% } %>
	return true;
}

</script>

<impact:validateErrors/>

<impact:validateForm
         name="frmAdmnReview"
         method="post"
         action="/workload/AdmnReview/saveAdmnReview"
         pageMode="<%=pageMode%>"
         validationClass="gov.georgia.dhr.dfcs.sacwis.web.workload.AdmnReviewCustomValidation"
         schema="/WEB-INF/Constraints.xsd">


<!-- Hidden Fields -->
	<impact:validateInput type="hidden" name="hdnProgram" value="<%= GlobalData.getSzCdStageProgram( request ) %>"/>
	<impact:validateInput type="hidden" name="hdnIntOnly" value="<%= Boolean.toString(showInitOnly) %>"/>
	<impact:validateInput type="hidden" name="hdnUlIdCommisDes" value="<%=ulIdCommisDes.toString()%>"/>


<!--- Begin Detail Table --->
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
  <tr>
    <th colspan="4">Review and Appeal</th>
  </tr>
  <tr>
    <td><impact:validateDisplayOnlyField
         name=""
         label="Person Reviewed"
         value="<%= ccfc43so.getSzNmPersonFull() %>" />
    </td>
    <td><impact:validateDisplayOnlyField
         name=""
         label="Original INV Stage"
         value="<%= originalINVStage %>" />
    </td>
<%--    <td> </td><td> </td> --%>
  </tr>
  <tr>
    <td width="21%"><impact:validateSelect
         width="31%"
         name="selSzCdAdminRvAppealType"
         label="Type"
         value="<%= ARIDetail.getSzCdAdminRvAppealType() %>"
         excludeOptions="<%= exOptions %>"
         required="true"
         codesTable="CARVTYPE"
         tabIndex="<%=tabIndex++%>"/>
    </td>
    <td width="21%"><impact:validateSelect
         width="31%"
         name="selSzCdAdminRvStatus"
         label="Status"
         value="<%= cdAdminRvStatusValue %>"
         excludeOptions="<%= exStatusOptions %>"
         required="true"
         codesTable="CARVSTAT"
         tabIndex="<%=tabIndex++%>"/>
    </td>
  </tr>
</table>

<% if(showNonAdminReview == true) { %>
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
  <tr>
    <th colspan="4">Panel/Child Death/Near Fatality/Serious Injury Review</th>
  </tr>
  <tr>
    <td width="25%"><impact:validateDate
         width="26%"
         name="txtDtDtDeterminationLtr"
         label="Determination Letter Generation Date"
         value="<%= FormattingHelper.formatDate( ARIDetail.getDtDtDeterminationLtr() ) %>"
         required="true"
         tabIndex="<%= tabIndex++ %>"/>
    </td>
    
    <td width="21%"><impact:validateDate
         width="31%"
         name="txtDtDtAdminRvReqAppeal"
         label="Request Received Date"
         value="<%= FormattingHelper.formatDate( ARIDetail.getDtDtAdminRvReqAppeal() ) %>"
         required="true"
         onChange="setDueDate(this.value)"
         tabIndex="<%= tabIndex++ %>"/>
    </td>
  </tr>
  <tr>
    <td width="21%"><impact:validateDate
         width="31%"
         name="txtDtDtAdminRvAppealReview"
         label="Review Date"
         value="<%= FormattingHelper.formatDate( ARIDetail.getDtDtAdminRvAppealReview() ) %>"
         conditionallyRequired="true"
         tabIndex="<%= tabIndex++ %>"/>
    </td>
    <td width="21%"><impact:validateDate
         width="31%"
         name="txtDtDtAdminRvDue"
         label="Conduct Review By"
         value="<%= FormattingHelper.formatDate( ARIDetail.getDtDtAdminRvDue() ) %>"
         tabIndex="<%= tabIndex++ %>"/>
    </td>
  </tr>
  <tr>
    <td>
      <span class="formCondRequiredText">&#135;</span><LABEL>Legal Representation</LABEL>      
    </td>
    <td colspan="1">
          <impact:validateInput type="radio" disabled="" label="No" id="Lgl_No" name="rbIndLglRepresentation" 
          value="N" cssClass="formInput" checked="<%= Lgl_No %>" tabIndex="<%= tabIndex++ %>"/>
          <impact:validateInput type="radio" disabled="" label="Yes" id="Lgl_Yes" name="rbIndLglRepresentation" 
          value="Y" cssClass="formInput" checked="<%= Lgl_Yes %>" tabIndex="<%= tabIndex++ %>"/>
    </td>
    <td>
      <span class="formCondRequiredText">&#135;</span><LABEL>SAAG Notification</LABEL>      
    </td>
    <td colspan="1">
          <impact:validateInput type="radio" disabled="" label="No" id="SAA_No" name="rbIndSAAGNotification" 
              value="N" cssClass="formInput" checked="<%= SAAG_No %>" tabIndex="<%= tabIndex++ %>"/>
          <impact:validateInput type="radio" disabled="" label="Yes" id="SAAG_Yes" name="rbIndSAAGNotification" 
              value="Y" cssClass="formInput" checked="<%= SAAG_Yes %>" tabIndex="<%= tabIndex++ %>"/>
    </td>
  </tr>
</table>
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
  <tr>
    <th colspan="2">Result</th>
  </tr>
  <tr>
           <td><impact:validateInput type="text"
                                    label="Result"
                                    conditionallyRequired="true"
                                    constraint="Comments"
                                    name="txtSzAdminRvAppealResult"
                                    cssClass="formInput"
                                    value="<%=  ARIDetail.getSztxtAppealResult() %>"
                                    size="80"
                                    maxLength="80"
                                    tabIndex="<%= tabIndex++ %>"/>
             </td>
  </tr>
  <tr>
    <td><impact:validateDate
         name="txtDtDtAdminRvAppealNotif"
         label="Reviewed Person Notifed On"
         value="<%= FormattingHelper.formatDate( ARIDetail.getDtDtAdminRvAppealNotif() ) %>"
         conditionallyRequired="true"
         tabIndex="<%= tabIndex++ %>"/>
    </td>
  </tr>
  <tr>
    <td>
      <impact:validateTextArea name="txtSzTxtRsnApprvDeny"
              label="Reason for Aproval/Denial"
              rows="3"
              cols="113"
              tabIndex="<%= tabIndex++ %>"
              maxLength="300"
              constraint="Comments"
              conditionallyRequired="true">
              <%= FormattingHelper.formatString( txtRsnApprvDeny ) %>
       </impact:validateTextArea>
    </td>
  </tr>
</table>
<% } //if(showNonAdminReview == true) { %>

<% if(shownIntermediateAdminMode == true) { %>
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
  <tr>
    <th colspan="4">Administrative Review</th>
  </tr>
  <tr>
    <td>
      <span class="formRequiredText">*</span>
       <impact:validateDisplayOnlyField
         name="lbLevel"
         label="Level"/>    
    </td>
    <td>
          <impact:validateInput type="radio" disabled="" label="1st Level Review " id="AL_1" name="rbIndAdminLevel" 
          value="1" cssClass="formInput" checked="<%="1".equals(ARIDetail.getSzCdAdminRvIndLevel()) ? "true" : "false" %>" tabIndex="<%= tabIndex++ %>"/>
    </td>
  </tr>
  <tr>
    <td>
    </td>
    <td>
    </td>
  	<td>
          <impact:validateInput type="radio" disabled="" label="2nd and 3rd Level Review " id="AL_23" name="rbIndAdminLevel" 
          value="2" cssClass="formInput" checked="<%="2".equals(ARIDetail.getSzCdAdminRvIndLevel()) ? "true" : "false" %>" tabIndex="<%= tabIndex++ %>"/>
    </td>
  </tr>
</table>
<% } //if(shownIntermediateAdminMode == true) { %>


<%  if (showLevelOneOnly == true || showLevelTwoThree == true) {%>
<impact:ExpandableSectionTag
		name="firstLevelAdministrativeReview"
		label="1st Level Administrative Review"
		isExpanded="<%=(showLevelOneOnly == true) ? true : false%>"
		tabIndex="<%=tabIndex++%>">
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
  <% if (showLevelTwoThree == true) {%>
  <tr class="subDetail">
    <td width="21%"><impact:validateSelect
         width="31%"
         name="sel1lvlARIStage"
         label="1st Level ARI Stage"
         disabled="<%=disableSecondLevel.toString()%>"
         value="<%=priorStage%>"
         conditionallyRequired="<%= (disableSecondLevel == true) ? "false" : "true" %>"
         options="<%=stageList%>"
         tabIndex="<%=tabIndex++%>"/>
    </td>
    <td>
    </td>
    <td>
    </td>
  </tr>
  <% } //if(showLevelTwoThree == true) { %>
  <tr class="subDetail">
  	<td>
  		<impact:validateDisplayOnlyField
         name=""
         label="Assigned Subject Matter Expert" 
         value="<%= FormattingHelper.formatString( ARIDetail.getSzNmPersonFullAmdRev1lSME() ) %>" />
  	</td>
  	<td>
    </td>
    <td>
    </td>
  </tr>
  <tr class="subDetail">
    <td width="25%"><impact:validateDate
         width="26%"
         name="txtDtDt1lvlDeterminationLtr"
         label="Determination Letter Generation Date"
         disabled="<%=disableFirstLevel.toString()%>"
         value="<%= FormattingHelper.formatDate( ARIDetail.getDtDt1lvlDeterminationLtr() ) %>"
         required="<%= (showLevelTwoThree == true) ? "false" : "true" %>"
         tabIndex="<%= tabIndex++ %>"/>
    </td>
    
    <td width="21%"><impact:validateDate
         width="31%"
         name="txtDtDt1lvlAdminRvReqAppeal"
         label="Request Received Date"
         disabled="<%=disableFirstLevel.toString()%>"
         value="<%= FormattingHelper.formatDate( ARIDetail.getDtDt1lvlAdminRvReqAppeal() ) %>"
         required="<%= (showLevelTwoThree == true) ? "false" : "true" %>"
         onChange="set1LvlDueDate(this.value)"
         tabIndex="<%= tabIndex++ %>"/>
    </td>
  </tr>
  <tr class="subDetail">
    <td width="21%"><impact:validateDate
         width="31%"
         name="txtDtDt1lvlAdminRvAppealReview"
         label="Review Date"
         disabled="<%=disableFirstLevel.toString()%>"
         value="<%= FormattingHelper.formatDate( ARIDetail.getDtDt1lvlAdminRvAppealReview() ) %>"
         conditionallyRequired="<%= (showLevelTwoThree == true) ? "false" : "true" %>"
         tabIndex="<%= tabIndex++ %>"/>
    </td>
    <td width="21%"><impact:validateDate
         width="31%"
         name="txtDtDt1lvlAdminRvDue"
         label="Conduct Review By"
         disabled="<%=disableFirstLevel.toString()%>"
         value="<%= FormattingHelper.formatDate( ARIDetail.getDtDt1lvlAdminRvDue() ) %>"
         tabIndex="<%= tabIndex++ %>"/>
    </td>
  </tr>
  <tr class="subDetail">
    <td>
    <%if (showLevelTwoThree == true) { %>
      <span class="formCondRequiredText"></span><LABEL>Legal Representation</LABEL>      
    <%} else { %>
       <span class="formCondRequiredText">&#135;</span><LABEL>Legal Representation</LABEL>      
    <%}%>
    </td>
    <td colspan="1">
          <impact:validateInput type="radio" disabled="" label="No" id="Lgl1lvl_No" name="rbInd1lvlLglRepresentation" 
          value="N" cssClass="formInput" checked="<%= Lgl1lvl_No %>" tabIndex="<%= tabIndex++ %>" disabled="<%=disableFirstLevel.toString()%>"/>
          <impact:validateInput type="radio" disabled="" label="Yes" id="Lgl1lvl_Yes" name="rbInd1lvlLglRepresentation" 
          value="Y" cssClass="formInput" checked="<%= Lgl1lvl_Yes %>" tabIndex="<%= tabIndex++ %>" disabled="<%=disableFirstLevel.toString()%>"/>
    </td>
    <td>
     <%if (showLevelTwoThree == true) { %>
      <span class="formCondRequiredText"></span><LABEL>SAAG Notification</LABEL>   
    <%} else { %>
       <span class="formCondRequiredText">&#135;</span><LABEL>SAAG Notification</LABEL>   
    <%}%>
    </td>
    </td>
    <td colspan="1">
          <impact:validateInput type="radio" disabled="" label="No" id="SAA1lvl_No" name="rbInd1lvlSAAGNotification" 
              value="N" cssClass="formInput" checked="<%= SAAG1lvl_No %>" tabIndex="<%= tabIndex++ %>" disabled="<%=disableFirstLevel.toString()%>"/>
          <impact:validateInput type="radio" disabled="" label="Yes" id="SAAG1lvl_Yes" name="rbInd1lvlSAAGNotification" 
              value="Y" cssClass="formInput" checked="<%= SAAG1lvl_Yes %>" tabIndex="<%= tabIndex++ %>" disabled="<%=disableFirstLevel.toString()%>"/>
    </td>
  </tr>
</table>
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
  <tr class="subDetail">
    <th colspan="4">Result</th>
  </tr>
  <tr class="subDetail">
  	<td>
    <%if (showLevelTwoThree == true) { %>
      <span class="formCondRequiredText"></span><LABEL>Disposition</LABEL> 
    <%} else { %>
       <span class="formCondRequiredText">&#135;</span><LABEL>Disposition</LABEL>    
    <%}%>
    </td>
    <td>
          <impact:validateInput type="radio" disabled="" label="I agree with the county's case determination of substantiation" id="DP1_1" name="rbInd1lvlDisp" 
          value="Y" cssClass="formInput" checked="<%="Y".equals(ARIDetail.getSzCd1lvlAdminRvDisp()) ? "true" : "false" %>" tabIndex="<%= tabIndex++ %>" disabled="<%=disableFirstLevel.toString()%>"/>
    </td>
  </tr>
  <tr class="subDetail">
    <td>
    </td>
  	<td>
          <impact:validateInput type="radio" disabled="" label="I do not agree with the action the county has taken and therefore the allegations will be unsubstantiated" id="DP2_1" name="rbInd1lvlDisp" 
          value="N" cssClass="formInput" checked="<%="N".equals(ARIDetail.getSzCd1lvlAdminRvDisp()) ? "true" : "false" %>" tabIndex="<%= tabIndex++ %>" disabled="<%=disableFirstLevel.toString()%>"/>
    </td>
  </tr>
  <tr class="subDetail">
    <td>
    </td>
  	<td>
          <impact:validateInput type="radio" disabled="" label="N/A: Review denied" id="DP3_1" name="rbInd1lvlDisp" 
          value="A" cssClass="formInput" checked="<%="A".equals(ARIDetail.getSzCd1lvlAdminRvDisp()) ? "true" : "false" %>" tabIndex="<%= tabIndex++ %>" disabled="<%=disableFirstLevel.toString()%>"/>
    </td>
  </tr>
  <tr class="subDetail">
    <td width="21%"><impact:validateSelect
         width="31%"
         name="selSzCd1lvlRsDisg"
         label="Reason for Disagreement"
         disabled="<%=disableFirstLevel.toString()%>"
         value="<%=FormattingHelper.formatString(ARIDetail.getSzCd1lvlAdminRsDisg())%>"
         conditionallyRequired="<%= (showLevelTwoThree == true) ? "false" : "true" %>"
         codesTable="COVERTUR"
         tabIndex="<%=tabIndex++%>"/>
    </td>
  </tr>
  <tr class="subDetail">
   <td><impact:validateInput type="text"
                                    label="Result"
                                    conditionallyRequired="<%= (showLevelTwoThree == true) ? "false" : "true" %>"
                                    constraint="Comments"
                                    name="txtSz1lvlAdminRvAppealResult"
                                    disabled="<%=disableFirstLevel.toString()%>"
                                    cssClass="formInput"
                                    value="<%= FormattingHelper.formatString(ARIDetail.getSzTxt1lvlAdminRevResults()) %>"
                                    size="80"
                                    maxLength="80"
                                    tabIndex="<%= tabIndex++ %>"/>
   </td>
  </tr>
  <tr class="subDetail">
   <td width="21%"><impact:validateDate
         width="31%"
         name="txtDtDt1lvlAdminRvPersonNoti"
         label="Reviewed Person Notified On"
         disabled="<%=disableFirstLevel.toString()%>"
         value="<%= FormattingHelper.formatDate( ARIDetail.getDtDt1lvlAdminRvPersonNotif()) %>"
         conditionallyRequired="<%= (showLevelTwoThree == true) ? "false" : "true" %>"
         tabIndex="<%= tabIndex++ %>"/>
    </td>
  </tr>
  <tr class="subDetail">
   <td>
		<impact:validateTextArea
		name="szTxt1lvlAdminRevResAppDen" 
		label="Reason for Approval/Denial"
		disabled="<%=disableFirstLevel.toString()%>"
		conditionallyRequired="<%= (showLevelTwoThree == true) ? "false" : "true" %>"
		cols="92" 
		rows="3" 
		tabIndex="<%=tabIndex++%>" 
		maxLength="4000" 
		><%= FormattingHelper.formatString(ARIDetail.getSzTxt1lvlAdminRevResAppDen())%></impact:validateTextArea>
	</td>
  </tr>
</table>
</impact:ExpandableSectionTag>
<% } //if((showLevelOneOnly == true || showLevelTwoThree == true)) { %>


<%  if (showLevelTwoThree == true) {%>
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
  <tr>
    <th colspan="4">2nd Level Administrative Review</th>
  </tr>
  <tr>
   <td><impact:validateInput type="text"
                                    label="Assigned Administrative Review Officer"
                                    required="<%= (disableSecondLevel == true) ? "false" : "true" %>"
                                    constraint="Comments"
                                    name="txtSz2lvlAdminRvOff"
                                    disabled="<%=disableSecondLevel.toString()%>"
                                    cssClass="formInput"
                                    value="<%= FormattingHelper.formatString(ARIDetail.getSzTxt2lvlAdminRevOff()) %>"
                                    size="25"
                                    maxLength="25"
                                    tabIndex="<%= tabIndex++ %>"/>
   </td>
   <td>
      <impact:validateInput tabIndex="<%=tabIndex++%>"
                            type="checkbox"
                            name="cb1lvlAdmRv21lvlStage"
                            label="No 1st Level ARI Stage"
                            cssClass="formInput"
                            value="Y"
                            conditionallyRequired="<%= (disableSecondLevel == true) ? "false" : "true" %>"
                            checked="<%=("Y".equals(ARIDetail.getBInd1lvlAdmRv21lvlStag())) ? "true" : "false"%>"
                            disabled="<%=disableSecondLevel.toString()%>"/>
    </td>
  </tr>
  <tr>
  	<td>
  		<impact:validateDisplayOnlyField
         name=""
         label="Person Completing SHINES Documentation" 
         value="<%= FormattingHelper.formatString( ARIDetail.getSzNmAdmRvPersonFullAmdComp() ) %>" />
  	</td>
  </tr>
  <tr>
    <td width="25%"><impact:validateDate
         width="26%"
         name="txtDtDt2lvlDecisionLtr"
         label="Date 1st Level Administrative Decision Letter Received by Requestor"
         disabled="<%=disableSecondLevel.toString()%>"
         value="<%= FormattingHelper.formatDate( ARIDetail.getDtDt2lvlAdmRvDecLtr() ) %>"
         conditionallyRequired="<%= (disableSecondLevel == true) ? "false" : "true" %>"
         tabIndex="<%= tabIndex++ %>"/>
    </td>
    
    <td width="21%"><impact:validateDate
         width="31%"
         name="txtDtDt2lvlAdminRvReqAppeal"
         label="Request Received Date"
         disabled="<%=disableSecondLevel.toString()%>"
         value="<%= FormattingHelper.formatDate( ARIDetail.getDtDt2lvlAdminRvReqAppeal() ) %>"
         required="<%= (disableSecondLevel == true) ? "false" : "true" %>"
         onChange="set2LvlDueDate(this.value)"
         tabIndex="<%= tabIndex++ %>"/>
    </td>
  </tr>
  <tr>
  	<td>
    <%if (disableSecondLevel == true) { %>
      <span class="formCondRequiredText"></span><LABEL>Review Type</LABEL> 
    <%} else { %>
       <span class="formCondRequiredText">&#135;</span><LABEL>Review Type</LABEL>    
    <%}%>
    </td>
    <td>
          <impact:validateInput type="radio" disabled="" label="Desk Review" id="RT_2" name="rbInd2lvlRevType" 
          value="D" cssClass="formInput" checked="<%="D".equals(ARIDetail.getSzCd2lvlAdminRvType()) ? "true" : "false" %>" tabIndex="<%= tabIndex++ %>" disabled="<%=disableSecondLevel.toString()%>"/>
    </td>
  </tr>
  <tr>
    <td>
    </td>
  	<td>
          <impact:validateInput type="radio" disabled="" label="Face to Face Review" id="RT_2" name="rbInd2lvlRevType" 
          value="F" cssClass="formInput" checked="<%="F".equals(ARIDetail.getSzCd2lvlAdminRvType()) ? "true" : "false" %>" tabIndex="<%= tabIndex++ %>" disabled="<%=disableSecondLevel.toString()%>"/>
    </td>
    <td width="21%"><impact:validateDate
         width="31%"
         name="txtDtDt2lvlAdminSchRevIntrv"
         label="Scheduled Interview Date"
         disabled="<%=disableSecondLevel.toString()%>"
         value="<%= FormattingHelper.formatDate( ARIDetail.getDtDt2lvlAdminRvReqIntrv() ) %>"
         tabIndex="<%= tabIndex++ %>"/>
    </td>
  </tr>
  <tr>
    <td width="21%"><impact:validateDate
         width="31%"
         name="txtDtDt2lvlAdminRvAppealReview"
         label="Review Date"
         disabled="<%=disableSecondLevel.toString()%>"
         value="<%= FormattingHelper.formatDate( ARIDetail.getDtDt2lvlAdminRvAppealReview() ) %>"
         conditionallyRequired="<%= (disableSecondLevel == true) ? "false" : "true" %>"
         tabIndex="<%= tabIndex++ %>"/>
    </td>
    <td width="21%"><impact:validateDate
         width="31%"
         name="txtDtDt2lvlAdminRvDue"
         label="Conduct Review By"
         disabled="<%=disableSecondLevel.toString()%>"
         value="<%= FormattingHelper.formatDate( ARIDetail.getDtDt2lvlAdminRvDue() ) %>"
         tabIndex="<%= tabIndex++ %>"/>
    </td>
  </tr>
  <tr>
    <td>
    <%if (disableSecondLevel == true) { %>
      <span class="formCondRequiredText"></span><LABEL>Legal Representation</LABEL>      
    <%} else { %>
       <span class="formCondRequiredText">&#135;</span><LABEL>Legal Representation</LABEL>      
    <%}%>
    </td>
    <td colspan="1">
          <impact:validateInput type="radio" disabled="" label="No" id="Lgl2lvl_No" name="rbInd2lvlLglRepresentation" 
          value="N" cssClass="formInput" checked="<%= Lgl2lvl_No %>" tabIndex="<%= tabIndex++ %>" disabled="<%=disableSecondLevel.toString()%>"/>
          <impact:validateInput type="radio" disabled="" label="Yes" id="Lgl2lvl_Yes" name="rbInd2lvlLglRepresentation" 
          value="Y" cssClass="formInput" checked="<%= Lgl2lvl_Yes %>" tabIndex="<%= tabIndex++ %>" disabled="<%=disableSecondLevel.toString()%>"/>
    </td>
    <td>
     <%if (disableSecondLevel == true) { %>
      <span class="formCondRequiredText"></span><LABEL>SAAG Notification</LABEL>   
    <%} else { %>
       <span class="formCondRequiredText">&#135;</span><LABEL>SAAG Notification</LABEL>   
    <%}%>
    </td>
    </td>
    <td colspan="1">
          <impact:validateInput type="radio" disabled="" label="No" id="SAA2lvl_No" name="rbInd2lvlSAAGNotification" 
              value="N" cssClass="formInput" checked="<%= SAAG2lvl_No %>" tabIndex="<%= tabIndex++ %>" disabled="<%=disableSecondLevel.toString()%>"/>
          <impact:validateInput type="radio" disabled="" label="Yes" id="SAAG2lvl_Yes" name="rbInd2lvlSAAGNotification" 
              value="Y" cssClass="formInput" checked="<%= SAAG2lvl_Yes %>" tabIndex="<%= tabIndex++ %>" disabled="<%=disableSecondLevel.toString()%>"/>
    </td>
  </tr>
</table>
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
  <tr>
    <th colspan="4">Result</th>
  </tr>
  <tr>
  	<td>
    <%if (disableSecondLevel == true) { %>
      <span class="formCondRequiredText"></span><LABEL>Disposition</LABEL> 
    <%} else { %>
       <span class="formCondRequiredText">&#135;</span><LABEL>Disposition</LABEL>    
    <%}%>
    </td>
    <td>
          <impact:validateInput type="radio" disabled="" label="I agree with the county's case determination of substantiation" id="DP1_2" name="rbInd2lvlDisp" 
          value="Y" cssClass="formInput" checked="<%="Y".equals(ARIDetail.getSzCd2lvlAdminRvDisp()) ? "true" : "false" %>" tabIndex="<%= tabIndex++ %>" disabled="<%=disableSecondLevel.toString()%>"/>
    </td>
  </tr>
  <tr>
    <td>
    </td>
  	<td>
          <impact:validateInput type="radio" disabled="" label="I do not agree with the action the county has taken and therefore the allegations will be unsubstantiated" id="DP2_2" name="rbInd2lvlDisp" 
          value="N" cssClass="formInput" checked="<%="N".equals(ARIDetail.getSzCd2lvlAdminRvDisp()) ? "true" : "false" %>" tabIndex="<%= tabIndex++ %>" disabled="<%=disableSecondLevel.toString()%>"/>
    </td>
  </tr>
  <tr>
    <td>
    </td>
  	<td>
          <impact:validateInput type="radio" disabled="" label="N/A: Review denied" id="DP3_2" name="rbInd2lvlDisp" 
          value="A" cssClass="formInput" checked="<%="A".equals(ARIDetail.getSzCd2lvlAdminRvDisp()) ? "true" : "false" %>" tabIndex="<%= tabIndex++ %>" disabled="<%=disableSecondLevel.toString()%>"/>
    </td>
  </tr>
  <tr>
    <td width="21%"><impact:validateSelect
         width="31%"
         name="selSzCd2lvlRsDisg"
         label="Reason for Disagreement"
         disabled="<%=disableSecondLevel.toString()%>"
         value="<%=FormattingHelper.formatString(ARIDetail.getSzCd2lvlAdminRsDisg())%>"
         conditionallyRequired="<%= (disableSecondLevel == true) ? "false" : "true" %>"
         codesTable="COVERTUR"
         tabIndex="<%=tabIndex++%>"/>
    </td>
  </tr>
  <tr>
   <td><impact:validateInput type="text"
                                    label="Result"
                                    conditionallyRequired="<%= (disableSecondLevel == true) ? "false" : "true" %>"
                                    constraint="Comments"
                                    name="txtSz2lvlAdminRvAppealResult"
                                    disabled="<%=disableSecondLevel.toString()%>"
                                    cssClass="formInput"
                                    value="<%= FormattingHelper.formatString(ARIDetail.getSzTxt2lvlAdminRevResults()) %>"
                                    size="80"
                                    maxLength="80"
                                    tabIndex="<%= tabIndex++ %>"/>
   </td>
  </tr>
  <tr>
   <td width="21%"><impact:validateDate
         width="31%"
         name="txtDtDt2lvlAdminRvPersonNoti"
         label="Reviewed Person Notified On"
         disabled="<%=disableSecondLevel.toString()%>"
         value="<%= FormattingHelper.formatDate( ARIDetail.getDtDt2lvlAdminRvPersonNotif()) %>"
         conditionallyRequired="<%= (disableSecondLevel == true) ? "false" : "true" %>"
         tabIndex="<%= tabIndex++ %>"/>
    </td>
  </tr>
  <tr>
   <td>
		<impact:validateTextArea
		name="szTxt2lvlAdminRevResAppDen" 
		label="Reason for Approval/Denial"
		disabled="<%=disableSecondLevel.toString()%>"
		conditionallyRequired="<%= (disableSecondLevel == true) ? "false" : "true" %>"
		cols="92" 
		rows="3" 
		tabIndex="<%=tabIndex++%>" 
		maxLength="4000" 
		><%= FormattingHelper.formatString(ARIDetail.getSzTxt2lvlAdminRevResAppDen())%></impact:validateTextArea>
	</td>
  </tr>
  <tr>
  <td>
  </td>
  <td>
      <impact:validateInput tabIndex="<%=tabIndex++%>"
                            type="checkbox"
                            name="cb2lvlAdmRv2ndStageComp"
                            label="2nd Level Review Complete"
                            cssClass="formInput"
                            value="Y"
                            checked="<%=("Y".equals(ARIDetail.getBInd2lvlAdmRvComp())) ? "true" : "false"%>"
                            disabled="<%=disableSecondLevel.toString()%>"/>
    </td>
  </tr>
</table>
<% } //if(showLevelTwoThree == true) { %>
<%  if (showLevelThree == true) {%>
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
  <tr>
    <th colspan="4">3rd Level Administrative Review</th>
  </tr>
  <tr>
  	<td>
  		<impact:validateDisplayOnlyField
         name=""
         label="Assigned DHS Commissioner/Designee" 
         value="<%= FormattingHelper.formatString( ARIDetail.getSzTxt3lvlAdminRevCommDes() ) %>" />
  	</td>
  	 <td>
         <impact:ButtonTag name="btnSelectStaff"
                           img="btnSelectStaff"
                           tabIndex="<%=tabIndex++%>"
                           disabled="<%=disableThridLevel.toString()%>"
                           function="javascript:disableValidation( 'frmAdmnReview' );"
                           form="frmAdmnReview"
                           restrictRepost="true"
                           preventDoubleClick="true"
                           action="/workload/AdmnReview/displayStaffSearch" />
       </td>
  </tr>
  <tr>
  	<td>
  		<impact:validateDisplayOnlyField
         name=""
         label="Person Completing SHINES Documentation" 
         value="<%= FormattingHelper.formatString( ARIDetail.getSzTxt3lvlAdminRevCompDoc() ) %>" />
  	</td>
  </tr>
  <tr>
     <td width="25%"><impact:validateDate
         width="26%"
         name="txtDtDt3lvlDecisionLtr"
         label="Date 2nd Level Administrative Decision Letter Received by Requestor"
         disabled="<%=disableThridLevel.toString()%>"
         value="<%= FormattingHelper.formatDate( ARIDetail.getDtDt3lvlAdmRvDecLtr() ) %>"
         required="<%= (disableThridLevel == true) ? "false" : "true" %>"
         tabIndex="<%= tabIndex++ %>"/>
    </td>
  </tr>
  <tr>
    <td width="21%"><impact:validateDate
         width="31%"
         name="txtDtDt3lvlAdminRvAppealReview"
         label="Review Date"
         disabled="<%=disableThridLevel.toString()%>"
         value="<%= FormattingHelper.formatDate( ARIDetail.getDtDt3lvlAdminRvAppealReview() ) %>" 
         conditionallyRequired="<%= (disableThridLevel == true) ? "false" : "true" %>"
         tabIndex="<%= tabIndex++ %>"/>
    </td>
    <td width="21%"><impact:validateDate
         width="31%"
         name="txtDtDt3lvlAdminRvDue"
         label="Conduct Review By"
         disabled="<%=disableThridLevel.toString()%>"
         value="<%= FormattingHelper.formatDate( ARIDetail.getDtDt3lvlAdminRvDue() ) %>"
         tabIndex="<%= tabIndex++ %>"/>
    </td>
  </tr>
</table>
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
  <tr>
    <th colspan="4">Result</th>
  </tr>
  <tr>
  	<td>
    <%if (disableThridLevel == true) { %>
      <span class="formCondRequiredText"></span><LABEL>Disposition</LABEL> 
    <%} else { %>
       <span class="formCondRequiredText">&#135;</span><LABEL>Disposition</LABEL>    
    <%}%>
    </td>
    <td>
          <impact:validateInput type="radio" disabled="" label="I agree with the administrative review officers determination" id="DP1_3" name="rbInd3lvlDisp" 
          value="Y" cssClass="formInput" checked="<%="Y".equals(ARIDetail.getSzCd3lvlAdminRvDisp()) ? "true" : "false" %>" tabIndex="<%= tabIndex++ %>" disabled="<%=disableThridLevel.toString()%>"/>
    </td>
  </tr>
  <tr>
    <td>
    </td>
  	<td>
          <impact:validateInput type="radio" disabled="" label="I do not agree with the administrative review officers determination" id="DP2_3" name="rbInd3lvlDisp" 
          value="N" cssClass="formInput" checked="<%="N".equals(ARIDetail.getSzCd3lvlAdminRvDisp()) ? "true" : "false" %>" tabIndex="<%= tabIndex++ %>" disabled="<%=disableThridLevel.toString()%>"/>
    </td>
  </tr>
  <tr>
    <td>
    <%if (disableThridLevel == true) { %>
      <span class="formCondRequiredText"></span><LABEL>Final Decision</LABEL> 
    <%} else { %>
       <span class="formCondRequiredText">&#135;</span><LABEL>Final Decision</LABEL>    
    <%}%>
    </td>
  	<td>
          <impact:validateInput type="radio" disabled="" label="I agree with the county's case determination of substantiation" id="FD1_3" name="rbInd3lvlFinDec" 
          value="Y" cssClass="formInput" checked="<%="Y".equals(ARIDetail.getSzCd3lvlAdminRvFnDec()) ? "true" : "false" %>" tabIndex="<%= tabIndex++ %>" disabled="<%=disableThridLevel.toString()%>"/>
    </td>
  </tr>
  <tr>
    <td>
    </td>
  	<td>
          <impact:validateInput type="radio" disabled="" label="I do not agree with the actions the county has taken and the allegations will be unsubstantiated " id="FD2_3" name="rbInd3lvlFinDec" 
          value="N" cssClass="formInput" checked="<%="N".equals(ARIDetail.getSzCd3lvlAdminRvFnDec()) ? "true" : "false" %>" tabIndex="<%= tabIndex++ %>" disabled="<%=disableThridLevel.toString()%>"/>
    </td>
  </tr>
  <tr>
    <td width="21%"><impact:validateSelect
         width="31%"
         name="selSzCd3lvlRsDisg"
         label="Reason for Disagreement"
         disabled="<%=disableThridLevel.toString()%>"
         value="<%=FormattingHelper.formatString(ARIDetail.getSzCd3lvlAdminRsDisg())%>"
         conditionallyRequired="<%= (disableThridLevel == true) ? "false" : "true" %>"
         codesTable="COVERTUR"
         tabIndex="<%=tabIndex++%>"/>
    </td>
  </tr>
  <tr>
   <td><impact:validateInput type="text"
                                    label="Result"
                                    conditionallyRequired="<%= (disableThridLevel == true) ? "false" : "true" %>"
                                    constraint="Comments"
                                    name="txtSz3lvlAdminRvAppealResult"
                                    disabled="<%=disableThridLevel.toString()%>"
                                    cssClass="formInput"
                                    value="<%= FormattingHelper.formatString(ARIDetail.getSzTxt3lvlAdminRevResults()) %>"
                                    size="80"
                                    maxLength="80"
                                    tabIndex="<%= tabIndex++ %>"/>
   </td>
  </tr>
  <tr>
   <td width="21%"><impact:validateDate
         width="31%"
         name="txtDtDt3lvlAdminRvPersonNoti"
         label="Reviewed Person Notified On"
         disabled="<%=disableThridLevel.toString()%>"
         value="<%= FormattingHelper.formatDate( ARIDetail.getDtDt3lvlAdminRvPersonNotif()) %>"
         conditionallyRequired="<%= (disableThridLevel == true) ? "false" : "true" %>"
         tabIndex="<%= tabIndex++ %>"/>
    </td>
  </tr>
  <tr>
   <td>
		<impact:validateTextArea
		name="szTxt3lvlAdminRevResAppDen" 
		label="Reason for Approval/Denial"
		disabled="<%=disableThridLevel.toString()%>"
		conditionallyRequired="<%= (disableThridLevel == true) ? "false" : "true" %>"
		cols="92" 
		rows="3" 
		tabIndex="<%=tabIndex++%>" 
		maxLength="4000" 
		><%= FormattingHelper.formatString(ARIDetail.getSzTxt3lvlAdminRevResAppDen())%></impact:validateTextArea>
	</td>
  </tr>
</table>

<% } //if(showLevelThree == true) { %>

<table border="0" cellspacing="0" cellpadding="3" width="100%">
  <tr>
    <td>
    </td>
    <td class="alignRight">
    <%if (showSaveSubmit == true) {%>
      <impact:ButtonTag
         name="btnSaveAndClose"
         img="btnSaveAndClose"
         form="frmAdmnReview"
         action="/workload/AdmnReview/saveAdmnReview"
         tabIndex="<%= tabIndex++ %>"
         function="return closePage()"
         restrictRepost="true"/>
    <%} // if (showSaveSubmit == true) %>  
      <impact:ButtonTag
         name="btnSave"
         img="btnSave"
         form="frmAdmnReview"
         action="/workload/AdmnReview/saveAdmnReview"
         tabIndex="<%= tabIndex++ %>"
         function="return savePage()"
         restrictRepost="true"/>
    </td>
  </tr>
</table>

<!--- End Detail Table --->
<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
</impact:validateForm>

<% if (showForms == true) { %>
<table border="0" cellspacing="0" cellpadding="3" width="100%"
	class="tableBorder">
	<tr>
		<%-- th colspan="4">Form and Report Launch</th --%>
		<th colspan="4">
			Forms Launch
		</th>
	</tr>
	<tr>
		<td>
			<impact:documentList pageMode="<%= pageMode %>"
				tabIndex="<%= tabIndex++ %>">
				<%if (showLevelOneOnly == false) { %>
				 <%if(showLevelThree == true) {%>
				<impact:document
					displayName="CPS Administrative Review Decision Letter - 3rd Level"
					protectDocument="<%=protectDocument%>" checkForNewMode="false" docType="adminmemo3"
					docExists="true" preFillAlways="true">
					<impact:documentParameter name="pCase"
						value='<%= FormattingHelper.formatInt( ARIDetail.getUlIdCase() ) %>' />
					<impact:documentParameter name="pStage"
						value='<%= FormattingHelper.formatInt( ARIDetail.getUlIdStage() ) %>' />
					<impact:documentParameter name="pEvent"
						value='<%= FormattingHelper.formatInt( ARIDetail.getUlIdEvent()  ) %>' />
					<impact:documentParameter name="pPerson"
						value='<%= FormattingHelper.formatInt( ARIDetail.getUlIdPersonRequestor()  ) %>' />
					<impact:documentParameter name="pSzCdAdRevType" value='3' />
				</impact:document>
				 <%} //if (showLevelThree == true)%>
				<impact:document
					displayName="CPS Administrative Review Decision Letter - 2nd Level"
					protectDocument="<%=protectDocument || disableSecondLevel%>" checkForNewMode="false" docType="adminmemo2"
					docExists="true" preFillAlways="true">
					<impact:documentParameter name="pCase"
						value='<%= FormattingHelper.formatInt( ARIDetail.getUlIdCase() ) %>' />
					<impact:documentParameter name="pStage"
						value='<%= FormattingHelper.formatInt( ARIDetail.getUlIdStage() ) %>' />
					<impact:documentParameter name="pEvent"
						value='<%= FormattingHelper.formatInt( ARIDetail.getUlIdEvent()  ) %>' />
					<impact:documentParameter name="pPerson"
						value='<%= FormattingHelper.formatInt( ARIDetail.getUlIdPersonRequestor()  ) %>' />
					<impact:documentParameter name="pSzCdAdRevType" value='2' />
				</impact:document>
				<%} else { //<%if (showLevelOneOnly == false) %>
				<impact:document
					displayName="CPS Administrative Review Decision Letter - 1st Level"
					protectDocument="<%=protectDocument%>"  checkForNewMode="false" docType="adminmemo"
					docExists="true" preFillAlways="true">
					<impact:documentParameter name="pCase"
						value='<%= FormattingHelper.formatInt( ARIDetail.getUlIdCase() ) %>' />
					<impact:documentParameter name="pStage"
						value='<%= FormattingHelper.formatInt( ARIDetail.getUlIdStage() ) %>' />
					<impact:documentParameter name="pEvent"
						value='<%= FormattingHelper.formatInt( ARIDetail.getUlIdEvent()  ) %>' />
					<impact:documentParameter name="pPerson"
						value='<%= FormattingHelper.formatInt( ARIDetail.getUlIdPersonRequestor()  ) %>' />
					<impact:documentParameter name="pSzCdAdRevType" value='1' />
				</impact:document>
				<%} //<%if (showLevelOneOnly == false) %>
				<impact:document displayName="Response to Case Review Request"
					protectDocument="<%=protectDocument%>"  checkForNewMode="false" docType="respareq"
					docExists="true" preFillAlways="true">
					<impact:documentParameter name="pCase"
						value='<%= FormattingHelper.formatInt( ARIDetail.getUlIdCase() ) %>' />
					<impact:documentParameter name="pStage"
						value='<%= FormattingHelper.formatInt( ARIDetail.getUlIdStage() ) %>' />
					<impact:documentParameter name="pEvent"
						value='<%= FormattingHelper.formatInt( ARIDetail.getUlIdEvent()  ) %>' />
					<impact:documentParameter name="pPerson"
						value='<%= FormattingHelper.formatInt( ARIDetail.getUlIdPersonRequestor()  ) %>' />
				</impact:document>
			</impact:documentList>
		</td>
	</tr>
</table>
<%} //if (showForms == true)%>
<br>
<% /* end Forms and Reports */ %>
<%
  if ( !bFindings  ||
       !bReqParent ||
       !bNotif     ||
       !bLic )
  {
    // SIR 22937 - Switch between CPS & APS versions of Cover Letter to
    // Requestor and Notif to Parent/Prof Reporter (Spanish or English)
    String CovLetReqEng = StringHelper.EMPTY_STRING;
    String CovLetReqSpa = StringHelper.EMPTY_STRING;
    String NotiToParEng = StringHelper.EMPTY_STRING;
    String NotiToParSpa = StringHelper.EMPTY_STRING;
    if ( GlobalData.getSzCdStageProgram( request ).equals(AdmnReviewConversation.PROG_CPS) )
    {
      //if CPS
      CovLetReqEng = AdmnReviewConversation.ADMIN_REV_REQSTR_ENG_CPS;
      CovLetReqSpa = AdmnReviewConversation.ADMIN_REV_REQSTR_SPA_CPS;
      NotiToParEng = AdmnReviewConversation.ADMIN_REV_PARENT_ENG_CPS;
      NotiToParSpa = AdmnReviewConversation.ADMIN_REV_PARENT_SPA_CPS;
    } else {
      //if !CPS
      CovLetReqEng = AdmnReviewConversation.ADMIN_REV_REQSTR_ENG;
      CovLetReqSpa = AdmnReviewConversation.ADMIN_REV_REQSTR_SPA;
      NotiToParEng = AdmnReviewConversation.ADMIN_REV_PARENT_ENG;
      NotiToParSpa = AdmnReviewConversation.ADMIN_REV_PARENT_SPA;
    }
}
%>

