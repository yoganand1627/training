<%
//*  JSP Name:     Stage Closure
//*  Created by:   Paula Blaha
//*  Date Created: 1/13/03
//*
//*  Description:
//*  The function of the Stage Closure page is to capture the reason for
//*  closure, the closure date and any closure comments.
//*
//*  Change History:
//*  Date      User         Description
//*  --------  -----------  --------------------------------------------------
//*  06/24/03  GRIMSHAN     SIR 18416 Set editable mode to all for approval
//*                         status button
//*  08/07/03  Todd Reser   Added Description.
//*  10/30/03  CORLEYAN     SIR 19857 todo removals and remove validation class
//*  07/01/04  RIOSJA       SIR 16114 - Each time the user accesses this page
//*                         for a family stage (FPR, FRE or FSU), display a
//*                         reminder that says: "Please review the Services and
//*                         Referrals Checklist for completeness and accuracy."
//*  10/28/08  vdevarak		STGAP00010749: Added the name fields and a javascript
//*                         function to show the fields when the reason closed is
//*                         Adoption Finalized
//*  07/25/09 bgehlot       STGAP00014341: MR-51 Reopen Stage Changes
//*  07/31/09 bgehlot       STGAP00014943: Data Closed is also prepopulated

%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB67SO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB67SOG00"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB67SOG01"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CSVC15SO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG00"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV19SOG02"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.workload.StageClosureConversation" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>

<%
  /*
  ** RIOSJA, SIR 16114 - If the user attempts to save and submit
  ** the page and validation edits are encountered, an indicator
  ** will be put into the request to be used by this JSP.
  */
  //Boolean bValidationEditsFound = null;
  //if ( request.getAttribute( "bValidationEditsFound" ) != null )
  //{
  //  bValidationEditsFound = (Boolean)request.getAttribute( "bValidationEditsFound" );
  //}

  BaseSessionStateManager state = (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );

  //Set the page mode
  String pageMode = PageModeConstants.VIEW;

  if (PageMode.getPageMode(request) != null)
  {
    pageMode = PageMode.getPageMode(request);
  }

  // Declare all the row objects you will need to display data on the page
  ROWCSUB67SOG00 StageClosure00 = null;
  ROWCSUB67SOG01 StageClosure01 = null;
  String nmFirst = "";
  String nmLast = "";
  String nmMiddle = "";

  // Get the whole output object here from the request and get the individual pieces later.
  CSUB67SO csub67so = (CSUB67SO) state.getAttribute("CSUB67SO", request);

  // Null catch and initialization for the output object
  if (csub67so == null)
  {
    csub67so = new CSUB67SO();
  }else{
  nmFirst = FormattingHelper.formatString(csub67so.getTxtNmFirst());
  nmLast = FormattingHelper.formatString(csub67so.getTxtNmLast());
  nmMiddle = FormattingHelper.formatString(csub67so.getTxtNmMiddle());
  }

  // Null catch and initialization for the row objects
  if (csub67so.getROWCSUB67SOG00() == null)
  {
    StageClosure00 = new ROWCSUB67SOG00();
  }
  else
  {
    StageClosure00 = csub67so.getROWCSUB67SOG00();
  }

  if (csub67so.getROWCSUB67SOG01() == null)
  {
  StageClosure01 = new ROWCSUB67SOG01();
   }
  else
  {
  StageClosure01 = csub67so.getROWCSUB67SOG01();
  }
 
       // Get the CSVC15SO output object out of the request
      CSVC15SO csvc15so = (CSVC15SO) state.getAttribute("CSVC15SO", request);
      ROWCCMN01UIG00 rowccmn01uig00 = null;
      ROWCINV19SOG02 rowcinv19sog02 = null;

      // Null catch for csvc15so, if null set to blank (initialize)
      if (csvc15so == null) {
        csvc15so = new CSVC15SO();
      }

      // Null catch for ROW objects, if not null get rows
      if (csvc15so.getROWCCMN01UIG00() != null) {
        rowccmn01uig00 = csvc15so.getROWCCMN01UIG00();
      } else {
        rowccmn01uig00 = new ROWCCMN01UIG00();
      }
      if (csvc15so.getROWCINV19SOG02() != null) {
        rowcinv19sog02 = csvc15so.getROWCINV19SOG02();
      } else {
        rowcinv19sog02 = new ROWCINV19SOG02();
      }

  // Set the date to system date for PAD and AOC.  Leave it blank for the other four stages.
  String stage = "";
  String eventStatus = "";
  String stageType ="";
  String szCdTask = "";
  String szCdEventType = "";
  String szTxtEventDescr = "";
  String FirstName = "none";
  String LastName = "none";
  String MiddleName = "none";
  String Label = "none";
  org.exolab.castor.types.Date dtEventOccurred = null;
  Date tsLastUpdate1 = null;
  Date tsLastUpdate2 = null;
  org.exolab.castor.types.Date dtStageClose = null;
  org.exolab.castor.types.Date dtStageCloseFromReopen = null;
  int ulIdEvent = 0;
  int ulIdStage = 0;
  int ulIdCase = 0;
  int ulIdPerson = 0;
  String szCdStage = "";
  String szCdStageProgram = "";
  String actionSave = "";
  String actionSaveAndSubmit = "";
  String validApprv = "";
  if (csub67so.getROWCSUB67SOG01() != null){
    eventStatus = StageClosure00.getSzCdEventStatus();
    stageType = StageClosure01.getSzCdStageType();
    stage = StageClosure01.getSzCdStage();
    szCdTask = StageClosure00.getSzCdTask();
    szCdEventType = StageClosure00.getSzCdEventType();
    ulIdEvent = StageClosure00.getUlIdEvent();
    ulIdStage = StageClosure01.getUlIdStage();
    ulIdCase = StageClosure01.getUlIdCase();
    szTxtEventDescr = StageClosure00.getSzTxtEventDescr();
    dtEventOccurred = StageClosure00.getDtDtEventOccurred();
    tsLastUpdate1 = StageClosure00.getTsLastUpdate();
    tsLastUpdate2 = StageClosure01.getTsLastUpdate();
    ulIdPerson = StageClosure00.getUlIdPerson();
    szCdStage = StageClosure01.getSzCdStage();
    szCdStageProgram = StageClosure01.getSzCdStageProgram();
    dtStageClose = StageClosure01.getDtDtStageClose();
    actionSave = "/workload/StageClosure/saveStageClosure";
    actionSaveAndSubmit = "/workload/StageClosure/saveSubmitStageClosure";
    validApprv = "/workload/StageClosure/validateApprv";
  }
  if (csvc15so.getROWCINV19SOG02() != null) {
    eventStatus = rowccmn01uig00.getSzCdEventStatus();
    stageType = rowcinv19sog02.getSzCdStageType();
    stage = rowcinv19sog02.getSzCdStage();
    szCdTask = rowccmn01uig00.getSzCdTask();
    szCdEventType = rowccmn01uig00.getSzCdEventType();
    ulIdEvent = rowccmn01uig00.getUlIdEvent();
    ulIdStage = rowcinv19sog02.getUlIdStage();
    ulIdCase = rowcinv19sog02.getUlIdCase();
    szTxtEventDescr = rowccmn01uig00.getSzTxtEventDescr();
    dtEventOccurred = rowccmn01uig00.getDtDtEventOccurred();
    tsLastUpdate1 = rowccmn01uig00.getTsLastUpdate();
    tsLastUpdate2 = rowcinv19sog02.getTsLastUpdate();
    ulIdPerson = rowccmn01uig00.getUlIdPerson();
    szCdStage = rowcinv19sog02.getSzCdStage();
    szCdStageProgram = rowcinv19sog02.getSzCdStageProgram();
    dtStageClose = rowcinv19sog02.getDtDtStageClose();
    actionSave = "/workload/StageClosure/updateSrvcDlvryClsr";
    actionSaveAndSubmit = "/workload/StageClosure/updateAndSubmitSrvcDlvryClsr";
    validApprv = "/workload/StageClosure/validateApprvFPR";
  }

  if ((((dtStageClose == null) || (dtStageClose ==  DateHelper.toCastorDate( "3500-12-31")))) && ((
          CodesTables.CSTAGES_AOC.equals(stage) || (CodesTables.CSTAGES_PAD.equals(stage) ))))
  {
    if (csub67so.getROWCSUB67SOG01() != null){
      StageClosure01.setDtDtStageClose( DateHelper.toCastorDate( new Date() ) );
    }
    if (csvc15so.getROWCINV19SOG02() != null) {
    rowcinv19sog02.setDtDtStageClose( DateHelper.toCastorDate( new Date() ) );
    }
  }
  //STGAP00014943: Data Closed is also prepopulated
  if(dtStageClose == null || (dtStageClose ==  DateHelper.toCastorDate( DateHelper.MAX_JAVA_DATE))){
    if((CodesTables.CEVTSTAT_COMP.equals(eventStatus) || eventStatus == null)&& ArchitectureConstants.Y.equals(csub67so.getBIndReopenStageEvent())){
      dtStageClose = csub67so.getDtDtStageCloseFromReopen();
    }
    if((CodesTables.CEVTSTAT_COMP.equals(eventStatus) || eventStatus == null )&& ArchitectureConstants.Y.equals(csvc15so.getBIndReopenStageEvent())){
      dtStageClose = csvc15so.getDtDtStageCloseFromReopen();
    }
  }
  
  //STGAP00014966 : Data Closed is also prepopulated
  if(dtStageCloseFromReopen == null || (dtStageCloseFromReopen ==  DateHelper.toCastorDate( DateHelper.MAX_JAVA_DATE))){
    if((CodesTables.CEVTSTAT_COMP.equals(eventStatus)|| eventStatus == null) && ArchitectureConstants.Y.equals(csub67so.getBIndReopenStageEvent())){
      dtStageCloseFromReopen = csub67so.getDtDtStageCloseFromReopen();
    }
    if((CodesTables.CEVTSTAT_COMP.equals(eventStatus)|| eventStatus == null) && ArchitectureConstants.Y.equals(csvc15so.getBIndReopenStageEvent())){
      dtStageCloseFromReopen = csvc15so.getDtDtStageCloseFromReopen();
    }
  }

  // If the stage has already been saved (event status = COMP) or saved and submitted (event status = PEND),
  // we need to be in BROWSE mode
  List excludeOptions = new ArrayList();

  if (eventStatus != null && CodesTables.CEVTSTAT_APRV.equals(eventStatus) )
  {
     pageMode = PageModeConstants.VIEW;
  }

  // initialize the tabIndex to 0
  int tabIndex = 1;

  // Attach the codes table for Reason.
  String reasonCodesTable = StringHelper.EMPTY_STRING;  

  if ((stageType.startsWith("C-")) && !(CodesTables.CSTAGES_PAD.equals(stage)))
  {
    reasonCodesTable =  CodesTables.CCLOSCRS;
  }
  else if(CodesTables.CSTAGES_FSU.equals(stage)){
    reasonCodesTable = CodesTables.CCLOSFCF; // FSU (Foster Care Child) reasons
  }
  else if(CodesTables.CSTAGES_SUB.equals(stage)){
    reasonCodesTable = CodesTables.CCLOSFCC; // SUB (Foster Care Family) reasons
  }
  else if(CodesTables.CSTAGES_PAD.equals(stage)){
    reasonCodesTable = CodesTables.CCLOSPAD; // PAD (Post Adoption) reasons
  }
  else if(CodesTables.CSTAGES_ADO.equals(stage)){
    reasonCodesTable = CodesTables.CCLOSADO; // ADO (Adoption) reasons
  }
  else if(CodesTables.CSTAGES_PFC.equals(stage)){
    reasonCodesTable = CodesTables.CCLOSPFC; // PFC (Post Foster Care Services) reasons
  }
  else if(CodesTables.CSTAGES_FPR.equals(stage)){
    reasonCodesTable = CodesTables.CCLOSONG; // FPR (CPS On Going) reasons
  }  
 
  boolean bApprovalStatusHide = true;

  if ( CodesTables.CEVTSTAT_PEND.equals( eventStatus ) ||
       CodesTables.CEVTSTAT_APRV.equals( eventStatus ) )
  {
    bApprovalStatusHide = false;
  }
  else
  {
    //-- will only be PROC if last approval was rejected
    if (CodesTables.CEVTSTAT_PROC.equals( eventStatus )) {
      if(CaseUtility.hasBeenSubmittedForApproval(GlobalData.getUlIdEvent(request))) {
        bApprovalStatusHide = false;
      }
    }
  }

boolean isApprover = false;

if ( GlobalData.getUlIdTodo( request ) != 0 &&
     GlobalData.isApprovalMode( request ) )
{
  isApprover = true;
}

String confirmed = ( String )request.getAttribute("confirmed");
%>

<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/javascript" language="JavaScript1.2">


function confirmCloseCase()
{
      document.frmStageClosure.closeStage.value = '<%=String.valueOf(isApprover)%>';
<%
  if (confirmed != null &&
      "ask".equals(confirmed) &&
      !FormValidation.pageHasErrorMessages(request) &&
      !FormValidation.pageHasValidationMessages("frmStageClosure", request))
  {
    String buttonPressed = request.getParameter( "btnSave.x" );
    if ( buttonPressed == null )
    {
      buttonPressed = "btnSaveSubmit_Id";
    }
    else
    {
      buttonPressed = "btnSave_Id";
    }
%>
    var confirmed = confirm("<%=MessageLookup.getMessageByName("MSG_SUB_CLOSE_CASE")%>");

    if (confirmed)
    {
      document.frmStageClosure.closeStage.value = 'true';
      document.getElementById('<%=buttonPressed%>').click();
    }
<%
    if ( StringHelper.isTrue( request.getParameter("pageIsChanged") ) )
    {
%>
    else // Cancel was clicked - now enable dirty check
    {
      setPageDirtyFlag( true );
    }
<%
    }
  }
%>
}
function toggleNameFields()
{
    toggleVisibility('FirstName', 'none');
    toggleVisibility('LastName', 'none');
    toggleVisibility('MiddleName', 'none');
    toggleVisibility('Label', 'none');
    var value = document.frmStageClosure.selSzCdStageReasonClosed.value;
    if(value == '<%= StageClosureConversation.REASON_ADOPTION_FINALIZED %>'){
      toggleVisibility('FirstName', 'block');
      toggleVisibility('LastName', 'block');
      toggleVisibility('MiddleName', 'block');
      toggleVisibility('Label', 'block');
    }
}
window.attachEvent('onload',toggleNameFields);
window.attachEvent('onload',confirmCloseCase);
window.attachEvent('onbeforeunload', checkIsDirty);
function checkPageChanged()
{
  document.frmStageClosure.pageIsChanged.value = isPageChanged();
}

function checkIsDirty()
{
  IsDirty();
}
</script>

<impact:validateErrors/>
<impact:validateForm name="frmStageClosure"
  method="post"
  action="<%=actionSave%>"
  pageMode="<%=pageMode%>"
  schema="/WEB-INF/Constraints.xsd"
  validationClass="gov.georgia.dhr.dfcs.sacwis.web.workload.StageClosureCustomValidation">

<%
  if ( !bApprovalStatusHide ) {
%>
  <table border="0" cellspacing="0" cellpadding="3" width="100%">
    <tr>
      <td>
        <impact:ButtonTag
          name="btnApprovalStatusFinal"
          img="btnApprovalStatus"
          form="frmStageClosure"
          action="<%=validApprv%>"
          navAwayCk="true"
          tabIndex="<%=tabIndex%>"
          restrictRepost="<%=GlobalData.isApprovalMode(request)%>"
          editableMode="<%= EditableMode.ALL %>"
        />
      </td>
    </tr>
  </table>
<% } %>

<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
  <tr>
    <th colspan="2">Closure Information</th>
  </tr>
<%
    String reason = request.getParameter("selSzCdStageReasonClosed");
    if (reason == null) {
      if (csub67so.getROWCSUB67SOG01() != null) {
        reason = StageClosure01.getSzCdStageReasonClosed();
      }
      if (csvc15so.getROWCINV19SOG02() != null) {
        reason = rowcinv19sog02.getSzCdStageReasonClosed();
      }
      if((CodesTables.CEVTSTAT_COMP.equals(eventStatus) || eventStatus == null) && ArchitectureConstants.Y.equals(csub67so.getBIndReopenStageEvent())){
        reason = csub67so.getSzCdStageReasonClosedFromReopen();
      }
      if((CodesTables.CEVTSTAT_COMP.equals(eventStatus) || eventStatus == null) && ArchitectureConstants.Y.equals(csvc15so.getBIndReopenStageEvent())){
        reason = csvc15so.getSzCdStageReasonClosedFromReopen();
      }
    }   
%>
  <tr>
    <td>
      <impact:validateSelect
        label="Reason"
        style="WIDTH: 240px"
        name="selSzCdStageReasonClosed"
        tabIndex="<%= tabIndex++ %>"
        excludeOptions="<%= excludeOptions %>"
        codesTable="<%= reasonCodesTable %>"
        onChange="toggleNameFields()"
        blankValue="true"
        required="true"
        value="<%= FormattingHelper.formatString(reason)%>"
      />
    </td>
  </tr>
  <tr>
  <%  boolean disableDate = true;
   if(ArchitectureConstants.Y.equals(csub67so.getBIndReopenStageEvent()) ||
     ArchitectureConstants.Y.equals(csvc15so.getBIndReopenStageEvent())){
    disableDate = false;
  %>  
    <td>
	<impact:validateDate name="txtDtDtStageClose" disabled="false"
		label="Date" value="<%=FormattingHelper.formatDate(dtStageClose)%>" size="10"
		constraint="Date" tabIndex="<%=tabIndex++%>" disabled="<%=String.valueOf(disableDate)%>" />
	</td>
  <%}else{ %>	
	<td>
      <impact:validateDisplayOnlyField
        name="txtDtDtStageClose"
        label="Date"
        value="<%=FormattingHelper.formatDate(dtStageClose)%>"
      />
    </td>
  <%} %>
  </tr>
<%
    String comments = request.getParameter("selSzTxtStageClosureCmnts");

    if (comments == null)
    {
      if (csub67so.getROWCSUB67SOG01() != null){
        comments = StageClosure01.getSzTxtStageClosureCmnts();
      }
      if (csvc15so.getROWCINV19SOG02() != null) {
        comments = rowcinv19sog02.getSzTxtStageClosureCmnts();
      }

      if((CodesTables.CEVTSTAT_COMP.equals(eventStatus) || eventStatus == null) && ArchitectureConstants.Y.equals(csub67so.getBIndReopenStageEvent())){
        comments = csub67so.getSzTxtStageClosureCmntsFromReopen();
      }
      if((CodesTables.CEVTSTAT_COMP.equals(eventStatus) || eventStatus == null) && ArchitectureConstants.Y.equals(csvc15so.getBIndReopenStageEvent())){
        comments = csvc15so.getSzTxtStageClosureCmntsFromReopen();
      }
            
      if("null".equals(comments) || comments == null){
         comments = "";
      }
    }
%>
  <tr>
    <td>
      <impact:validateTextArea
        name="selSzTxtStageClosureCmnts"
        label="Comments"
        rows="4"
        cols="80"
        tabIndex="<%= tabIndex++ %>"
        maxLength="300"
        constraint="Comments">
        <%= comments %>
      </impact:validateTextArea>
    </td>
  </tr>
  
 <tr id="Label" style="display: <%=Label%>">
  <td> New Child's Name </td>
 </tr>     
    <tr id="FirstName" style="display: <%=FirstName%>">
    <td>
    <impact:validateInput
                 tabIndex="<%= tabIndex++ %>"
                 value="<%= nmFirst %>"
                 type="text"
                 name="txtNmFirst"
                 label="First"
                 conditionallyRequired="true"
                 disabled="<%= "" %>"
                 cssClass="formInput"
                 size="12"
                 maxLength="12"
                 constraint="Name12"/></td>
     </tr>
     <tr id="MiddleName" style="display: <%=MiddleName%>">
            <td><impact:validateInput
                 tabIndex="<%= tabIndex++ %>"
                 value="<%= nmMiddle %>"
                 type="text"
                 name="txtNmMiddle"
                 label="Middle"
                 conditionallyRequired="false"
                 disabled="<%= "" %>"
                 cssClass="formInput"
                 size="12"
                 maxLength="12"
                 constraint="Name12"/></td>
     </tr>
     <tr id="LastName" style="display: <%=LastName%>">
            <td><impact:validateInput
                 tabIndex="<%= tabIndex++ %>"
                 value="<%= nmLast %>"
                 type="text"
                 name="txtNmLast"
                 label="Last"
                 conditionallyRequired="true"
                 disabled="<%= "" %>"
                 cssClass="formInput"
                 size="22"
                 maxLength="22"
                 constraint="Name22"/></td>
   </tr>

</table>

<table border="0" cellspacing="0" cellpadding="3" width="100%">
  <tr>
    <td width="80%">&nbsp;</td>
    <td width="10%" class="alignRight">
      <impact:spellCheck
        formToSpellCheck="frmStageClosure"
        fieldsToSpellCheck="selSzTxtStageClosureCmnts"
        tabIndex="<%= tabIndex++ %>"
      />
    </td>
   
<%  
    if (!isApprover ) {
%>
    <td width="10%" class="alignRight">
      <impact:ButtonTag
        name="btnSaveSubmit"
        img="btnSaveAndSubmit" align="right"
        form="frmStageClosure"
        restrictRepost="true"
        action="<%=actionSaveAndSubmit%>"
        function="checkPageChanged()"
        tabIndex="<%= tabIndex++ %>"
      />
    </td>
<%
    }
%>
    <td width="10%" class="alignRight">
      <impact:ButtonTag
        name="btnSave"
        img="btnSave" align="right"
        form="frmStageClosure"
        restrictRepost="true"
        action="<%=actionSave%>"
        function="checkPageChanged()"
        tabIndex="<%= tabIndex++ %>"
      />
    </td>
  </tr>
</table>

<!-------------------------------------------------------------------------------------------------
 !- Hidden fields to persist state
 !------------------------------------------------------------------------------------------------>
<impact:validateInput type="hidden" name="txtUlIdEvent" value="<%=FormattingHelper.formatInt(ulIdEvent)%>" />
<impact:validateInput type="hidden" name="txtUlIdStage" value="<%=FormattingHelper.formatInt(ulIdStage)%>"/>
<impact:validateInput type="hidden" name="txtSzCdTask" value="<%=szCdTask%>" />
<impact:validateInput type="hidden" name="txtSzCdEventType" value="<%=szCdEventType%>" />
<impact:validateInput type="hidden" name="txtDtDtEventOccurred" value="<%=FormattingHelper.formatDate(dtEventOccurred)%>" />
<impact:validateInput type="hidden" name="txtTsLastUpdate1" value="<%=DateHelper.toISOString(tsLastUpdate1)%>" />
<impact:validateInput type="hidden" name="txtSzTxtEventDescr" value="<%=szTxtEventDescr%>" />
<impact:validateInput type="hidden" name="txtSzCdEventStatus" value="<%=eventStatus%>" />
<impact:validateInput type="hidden" name="txtUlIdPerson" value="<%=FormattingHelper.formatInt(ulIdPerson)%>" />
<impact:validateInput type="hidden" name="txtTsLastUpdate2" value="<%=DateHelper.toISOString(tsLastUpdate2)%>" />
<impact:validateInput type="hidden" name="txtUlIdCase" value="<%=FormattingHelper.formatInt(ulIdCase)%>" />
<impact:validateInput type="hidden" name="txtSzCdStage" value="<%=FormattingHelper.formatString(szCdStage)%>" />
<impact:validateInput type="hidden" name="txtSzCdStageProgram" value="<%=szCdStageProgram%>" />
<impact:validateInput type="hidden" name="txtSzCdStageType" value="<%=stageType%>" />
<impact:validateInput type="hidden" name="hdnTxtDtDtStageClose" value="<%=FormattingHelper.formatDate(dtStageClose)%>" />
<impact:validateInput type="hidden" name="closeStage" value="" />
<impact:validateInput type="hidden" name="pageIsChanged" value="false" />
<impact:validateInput type="hidden" name="reasonClosed" value="<%=FormattingHelper.formatString(reason)%>" />
<impact:validateInput type="hidden" name="txtDtDtStageCloseFromReopen" value="<%=FormattingHelper.formatDate(dtStageCloseFromReopen)%>" />
<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>"/>
</impact:validateForm>
