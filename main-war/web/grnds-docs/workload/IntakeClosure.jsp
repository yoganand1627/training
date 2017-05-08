<%
//*  JSP Name:     Intake Priority Closure
//*  Created by:   Rodrigo DeJuana
//*  Date Created: 1/10/03
//*
//*  Description:
//*  The Priority/Closure page is used to change the priority of an existing 
//*  Intake that has not been progressed to Investigation.
//*  It can also be used to close CPS Intakes that are non-incident intakes.
/* Change History:
  Date      User              Description
  --------  ----------------  --------------------------------------------------
  06/09/03  GRIMSHAN          SIR 16979 get pagemode from page mode instead of
                              from page mode attribute name
  06/11/03  Todd Reser        SIR 18235 - Removed <br> between tables and <hr>
                              before save button.
  06/30/03  CASDORJM          SIR 18590 - The user was getting confused and
                              forgetting what the original current priority was
                               - we added code that will set the Current
                              Priority back to what was originally retrieved
                              after the user recieves the "Invalid Priority for
                              Stage Type." error message.
  07/15/03  CASDORJM          SIR 18855 - Changed logic so that the Forms
                              section would display for all programs that
                              started with a "C" and not just CPS.
  08/07/03  Todd Reser        Added Description.
  05/09/05  ochumd            Sir 23019 - Added 3 new reason closed codes for the
                              new Special Request types to the Special Request Type
                              List:CCL Standards Violation RCL Standards Violation
                              and CPS Foster Home Standards Violation.
  04/17/08  JRAMSPOT          Update to work for Georgia SHINES. STGAP00008086
  
  07/15/08  arege             STGAP00009014 Changed the Comments box under Response Time 
                              validate Text Area name to szTxtStageResponseTimeCmnts in order to
                              separate from the comments box on IntakeActions Page.
                            
                      
  
*/
%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.Sets" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CINT99SO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.StageRow" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.workload.IntakeClosureConversation"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.Option"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.workload.ApprovalStatusConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper"%>

<%
  String pageMode = PageMode.getPageMode( request );

  BaseSessionStateManager state = (BaseSessionStateManager)
    request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );

  int tabIndex = 1;
%>

<%

CINT99SO cint99so = (CINT99SO) state.getAttribute( "CINT99SO", request );
StageRow stageRow = new StageRow();
if ( cint99so == null )
{
  cint99so = new CINT99SO();
}
if ( cint99so.getStageRow() != null )
{
  stageRow = cint99so.getStageRow();
}
//setup correct codestables for dropdowns
String currPriCT = IntakeClosureConversation.CT_CURRENT_PRIORITY;
String disableApprovalStatus = "true";

// If the user is entering this page as an approver, there are certain fields that should be disabled.
boolean approvalMode = false;
String approvalAction = ApprovalStatusConversation.DISPLAY_URI;
if (GlobalData.isApprovalMode(request)) {
    approvalMode = true;
    approvalAction = "/workload/IntakePriorityClosure/validateApprv";
}

if (CaseUtility.hasBeenSubmittedForApproval(GlobalData.getUlIdEvent(request)) && approvalMode) {
        disableApprovalStatus = "false";
}

String initial     = "";
String initialDecoded = "";
String current     = "";
String dtChanged   = "";
String rsnChanged  = "";
String priComments = "";
String clsComments = "";
String disposition = "";
String screenOutReason = "";
String actionSave = "/workload/IntakePriorityClosure/saveAndSubmitIntakeClosure";

char mymode = (char)Sets.getPageSet( request ).toCharArray()[0];

switch ( mymode )
{
  case 'A':
  case 'B':
    initial = stageRow.getSzCdStageInitialPriority();
    if (StringHelper.isValid(initial)) {
    	initialDecoded = Lookup.simpleDecode(CodesTables.CPRIORTY, initial);
    	if (StringHelper.isValid(initialDecoded) == false) {
    		initialDecoded=initial;
    	}
    }
    current = StringHelper.getNonNullString(stageRow.getSzCdStageCurrPriority());
    dtChanged = FormattingHelper.formatDate( cint99so.getDtSysDtGenericSysdate() );
    rsnChanged = StringHelper.getNonNullString(stageRow.getSzCdStageRsnPriorityChgd());
    //priComments = StringHelper.getNonNullString(stageRow.getSzTxtStagePriorityCmnts());
    priComments = StringHelper.getNonNullString(stageRow.getSzTxtStageResponseTimeCmnts());
  case 'C':
    disposition = StringHelper.getNonNullString(cint99so.getSzCdIncomingDisposition());
    clsComments = StringHelper.getNonNullString(stageRow.getSzTxtStageClosureCmnts());
    screenOutReason = StringHelper.getNonNullString(stageRow.getSzCdStageScroutReason());
    break;
}
List dispOptions = new ArrayList();
Option dispOption = null;
if (mymode == 'C') {
   dispOption = new Option(disposition, Lookup.simpleDecodeSafe(CodesTables.CDISP, disposition));
   dispOptions.add(dispOption);
   dispOption = new Option (CodesTables.CDISP_OIE, Lookup.simpleDecode(CodesTables.CDISP, CodesTables.CDISP_OIE));
   dispOptions.add(dispOption);
   actionSave = "/workload/IntakePriorityClosure/saveAndCloseIntakeClosure";
}
else {
   // dispOptions = Lookup.getCategoryCollection(CodesTables.CDISP);
   dispOption = new Option (CodesTables.CDISP_ACA, Lookup.simpleDecode(CodesTables.CDISP, CodesTables.CDISP_ACA));
   dispOptions.add(dispOption);
   dispOption = new Option (CodesTables.CDISP_DIV, Lookup.simpleDecode(CodesTables.CDISP, CodesTables.CDISP_DIV));
   dispOptions.add(dispOption);
   dispOption = new Option (CodesTables.CDISP_SCO, Lookup.simpleDecode(CodesTables.CDISP, CodesTables.CDISP_SCO));
   dispOptions.add(dispOption);
   dispOption = new Option (CodesTables.CDISP_SCR, Lookup.simpleDecode(CodesTables.CDISP, CodesTables.CDISP_SCR));
   dispOptions.add(dispOption);
   dispOption = new Option (CodesTables.CDISP_OIE, Lookup.simpleDecode(CodesTables.CDISP, CodesTables.CDISP_OIE));
   dispOptions.add(dispOption);
}


%>
<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>

<script type="text/javascript" language="JavaScript1.2">

<impact:codeArray codeName="CSTGTYPE" arrayName="stageTypes" blankValue="false"/>

window.onbeforeunload = function ()
{
  IsDirty();
};

function processChange(value)
{
     priChange();
}

function priChange()
{
  document.frmPriorityClosure.selSzCdStageRsnPriorityChgd.value = "";
  document.frmPriorityClosure.szTxtStageResponseTimeCmnts.value = "";
}

<%--
// This function is called when the user clicks on the "SaveAndSubmit" button.  If the disposition
// is one that would lead to the closure of a case (Screen Out, Screen Out and Refer, Open in Error),
// we need to confirm that the user wants to do that.
--%>
function promptDispositionChange()
{

  <%--//  If the Disposition would lead to a case closure, then prompt for confirmation --%>
  var retVal = true;
  var value = document.frmPriorityClosure.selSzCdDisp.value;
  if (value == "OIE" || value == "SCO" || value == "SCR" )
  {
    var save = confirm('<%= MessageLookup.getMessageByNumber(Messages.MSG_INT_SAVE_DISP)  %>');
    if (save == true)
    {
      retVal = true;
    }
    else
    {
      retVal = false;
    }
  }
<%--
  // If the disposition does not lead to case closure, then proceed without alerting
--%>
  else
  {
    retVal = true;
  }
  return retVal;
}

</script>

<impact:validateErrors/>

<impact:validateForm name="frmPriorityClosure"
  method="post"
  action="<%=actionSave%>"
  pageMode="<%=pageMode%>"
  validationClass="gov.georgia.dhr.dfcs.sacwis.web.workload.IntakeClosureCustomValidation"
  schema="/WEB-INF/Constraints.xsd">


<!-- Hidden Fields -->
<impact:validateInput type="hidden" name="hdnSzCdStageCurrPriority" value="<%= current %>"/>
<impact:validateInput type="hidden" name="hdnDtDtStageStart" value="<%= FormattingHelper.formatDate( stageRow.getDtDtStageStart() ) %>"/>
<impact:validateInput type="hidden" name="hdnDtSysDtGenericSysdate" value="<%= dtChanged %>"/>
<impact:validateInput type="hidden" name="hdnSzCdIncomingDisposition" value="<%= disposition %>"/>
<impact:validateInput type="hidden" name="mode" value="<%= Sets.getPageSet( request ) %>"/>

<impact:ButtonTag name="btnApprovalStatusFinal" img="btnApprovalStatus" form="frmPriorityClosure" action="<%=approvalAction%>" navAwayCk="true" disabled="<%=disableApprovalStatus%>" editableMode="<%= EditableMode.ALL %>"
		tabIndex="<%=tabIndex%>" />
<% 
 // If the mode is 'C' for modifying a Non-Incident Intake, we do not show the Response Time Section
 if (mymode != 'C') {
%>		
<!--- Begin Detail Table --->
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
  <tr>
    <th colspan="6">Response Time</th>
  </tr>
  <tr>
    <td width="20%"><impact:validateDisplayOnlyField name="dspSzCdStageInitialPriority"
                                         label="Initial"
                                         value="<%= initialDecoded %>" /></td>
    <td><impact:validateSelect name="selSzCdStageCurrPriority"
                               label="Current"
                               value="<%= current %>"
                               codesTable="<%= currPriCT %>"
                               disabled="<%= Sets.isNotInSetStr( Sets.B , request )%>"
                               onChange="processChange(this.value);"
                               tabIndex="<%=tabIndex++%>"
                               blankValue="true" /></td>
  </tr>
  <tr>
    <td><impact:validateDate name="txtDtSysDtGenericSysdate"
                               label="Date Changed"
                               value="<%= dtChanged %>"
                               disabled="<%= Sets.isNotInSetStr( Sets.B , request )%>"
                               tabIndex="<%= tabIndex++ %>"/></td>
    <td><impact:validateSelect name="selSzCdStageRsnPriorityChgd"
                               label="Reason Changed"
                               value="<%= rsnChanged %>"
                               disabled="<%=Sets.isNotInSetStr( Sets.B , request )%>"
                               conditionallyRequired="true"
                               codesTable="CRSNPRIO"
                               tabIndex="<%=tabIndex++%>"
                               blankValue="true"/></td>
  </tr>
  <tr>
  
    <td>
      <impact:validateTextArea name="szTxtStageResponseTimeCmnts"
                               label="Comments"
                               disabled="<%= Sets.isNotInSetStr( Sets.B , request )%>"
                               constraint="Paragraph80"
                               maxLength="80"
                               colspan="4"
                               conditionallyRequired="true"
                               rows="4"
                               cols="40"
                               tabIndex="<%= tabIndex++ %>"><%= priComments %>
      </impact:validateTextArea>
    </td>
  </tr>
</table>
<%
}  //end if we need to show Response time section
%>
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
  <tr>
    <th colspan="4">Disposition</th>
  </tr>
  <tr>
       <td>
          <impact:validateSelect 
                  label="Disposition" 
                  name="selSzCdDisp" 
                  tabIndex="<%= tabIndex++ %>" 
                  options="<%= dispOptions %>" 
                  disabled='<%= Sets.isNotInSetStr( Sets.C + Sets.B , request ) %>' 
                  value="<%= disposition%>"
                  blankValue='<%= Sets.isNotInSetStr( Sets.C, request ) %>'
                  conditionallyRequired="true" />
        </td>
        <td>
          <impact:validateSelect 
                  label="Screen Out Reason" 
                  name="selSzCdScreenOutReason" 
                  tabIndex="<%= tabIndex++ %>" 
                  codesTable="<%= CodesTables.CSCNOTRN %>" 
                  blankValue="true"
                  conditionallyRequired="true"
                  disabled='<%= Sets.isNotInSetStr(Sets.B , request ) %>'
            value="<%= screenOutReason %>" />
        </td>
  </tr>
  <tr>
    <td><impact:validateTextArea name="txtaSzTxtStageClosureCmnts"
                                             label="Comments"
                                             disabled="<%= Sets.isNotInSetStr( Sets.C + Sets.B , request )%>"
                                             colspan="3"
                                             constraint="Paragraph300"
                                             maxLength="300"
                                             rows="4"
                                             cols="70"
                                             conditionallyRequired="true"
                                             tabIndex="<%= tabIndex++ %>"><%= clsComments %>
                    </impact:validateTextArea></td>
  </tr>
</table>
<table border="0" cellspacing="0" cellpadding="3" width="100%">
  <tr>
    <td class="alignRight" width="95%">
<%if ("true".equals(Sets.isInSetStr(Sets.C, request)) && !(approvalMode)) { %>
      <impact:ButtonTag name="btnSaveAndClose"
                               restrictRepost="true"
                               preventDoubleClick="true"
                               img="btnSaveAndClose"
                               form="frmPriorityClosure"
                               action="/workload/IntakePriorityClosure/saveAndCloseIntakeClosure"
                               tabIndex="<%= tabIndex++ %>"/>
    </td>
    <td class="alignRight" width="5%">
<%} else { out.print("&nbsp;"); }
  if ("true".equals(Sets.isInSetStr(Sets.B, request)) && !(approvalMode)) { %>
      <impact:ButtonTag name="btnSaveAndSubmit"
                               restrictRepost="true"
                               preventDoubleClick="true"
                               function="return promptDispositionChange();"
                               img="btnSaveAndSubmit"
                               form="frmPriorityClosure"
                               action="/workload/IntakePriorityClosure/saveAndSubmitIntakeClosure"
                               tabIndex="<%= tabIndex++ %>"/>
<%}%>
    </td>
  </tr>
</table>
<!--- End Detail Table --->
<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
</impact:validateForm>
<script language="JavaScript">
   CleanSelect( frmPriorityClosure.selSzCdDisp );
</script>
