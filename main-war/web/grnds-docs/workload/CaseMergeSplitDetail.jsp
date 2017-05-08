<%
//*  JSP Name:     CaseMerge/SplitDetail
//*  Created by:   Marie Au-Young
//*  Date Created: 12/20/02
//*
//*  Description:
//*  The Case Merge/Split Detail page will be used  to merge two separate existing Cases into one Case
//*  or to Split a previously merged case. The cases can be open or closed. The Merge To case will retain its
//*  information history and case ID. The Merge From case will become part of the Merge To case. After a case is
//*  merged, all the information related to the Merge From case will be found in the Merge To case.
//*  The user will access this detail page from the case Summary page in either Browse or Modify mode. If the user is
//*  going to merge or split a case, the user must be in the case Summary window for the Merge To Case.
//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**  4/1/03    Jonathan Hardy    QA Sweep -- added restrictRepost, removed imports
//**  12/08/04  Hadjimh           SIR#23257. Add Case Split Confirmation Message
//**  05/04/05  Malpans            SIR 23258 - Modify the current Merge Confirmation Message
//**                              to include case name for the merge.
// *  06/01/05  Hadjimh    SIR#14411. Intake received date is incorrect after a case merge of
// *                       two open INV stages. When merging open INV stages with open INV
// *                       stages, the merge to case must have the earliest intake date.
// *                       If the worker has entered the merge with the case to case being
// *                       the newer case, the case ids must be switched prior to the merge.
// *                       An message box should tell the worker the cases have been switched
// *                       to allow the case to case be the case with the earliest intake date.
//**  07/31/2008 arege     STGAP00007353 Modified Code to enable Merge for Cases with Pending
//**                       approvals. The Case that is being merged should be closed.
%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC39SO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC40SO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC39SOG00" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.Sets" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper"  %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.workload.CaseSummaryConversation" %>

<%
  /* Set the page mode - String pageMode = PageMode.VIEW;  */
  String pageMode = PageModeConstants.EDIT;
//  //If the mode was set in the activity method, get it
//  if( request.getAttribute( PageMode.PAGE_MODE_ATTRIBUTE_NAME ) != null )
//  {
//    pageMode = (String)request.getAttribute( PageMode.PAGE_MODE_ATTRIBUTE_NAME );
//  } else if( request.getParameter( PageMode.PAGE_MODE_ATTRIBUTE_NAME ) != null )
//  {
//    pageMode = request.getParameter( PageMode.PAGE_MODE_ATTRIBUTE_NAME );
//  }

  // Initialize variables
  int tabIndex = 1;
  String cReqFuncCd = (String) request.getAttribute("hdnCReqFuncCd");
  if (cReqFuncCd == null)
  {
    cReqFuncCd = request.getParameter("hdnCReqFuncCd");
  }
  String hdnDataAction = (String) request.getAttribute("hdnDataAction");
  if (hdnDataAction == null)
  {
    hdnDataAction = request.getParameter("hdnDataAction");
  }
  String txtUlIdCaseMergeTo = "";
  String txtSzScrNmCaseMrgTo = "";
  String txtUlIdCaseMergeFrom = "";
  String txtSzScrNmCaseMrgFrom = "";
  String txtSzScrMergeWorker = "";
  String txtDtDtCaseMerg = "";
  String txtSzScrNmSplitWorker = "";
  String txtDtCaseMergeSplit = "";
  UserProfile user = UserProfileHelper.getUserProfile( request );
  String hdnBIndValidate = (String) request.getAttribute("hdnBIndValidate");
  hdnBIndValidate = hdnBIndValidate == null ? "" : hdnBIndValidate;

  // SIR#14411. Added state and sSwitch objects
  BaseSessionStateManager state =
          (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
  String sSwitch = (String)state.getAttribute(CaseSummaryConversation.MERGE_BY_INTAKE_DATE, request);
  // Get the output object from the request for Case Merge/Split
  CCFC39SO ccfc39so = (CCFC39SO) state.getAttribute("CCFC39SO", request);
  CCFC40SO ccfc40so = (CCFC40SO) request.getAttribute("CCFC40SO");

  //Declare the actual row object.
  ROWCCFC39SOG00 caseMergeSplitRow = (ROWCCFC39SOG00) state.getAttribute( "currentRow", request );

  // Null catch for Case Merge/Split, if null set to blank
  if (ccfc39so == null)
  {
    ccfc39so = new CCFC39SO();
  }
  if (ccfc40so == null)
  {
    ccfc40so = new CCFC40SO();
  }
//System.out.println("the value of ccfc40so is "+ ccfc40so);
//System.out.println("reqFuncCd is " + cReqFuncCd);
  //If the user clicks on a hyperlink, display all data
  if (cReqFuncCd.equals(ServiceConstants.REQ_FUNC_CD_UPDATE))
  {
    txtUlIdCaseMergeTo = FormattingHelper.formatString(String.valueOf(caseMergeSplitRow.getUlIdCaseMergeTo()));
    txtSzScrNmCaseMrgTo = FormattingHelper.formatString(caseMergeSplitRow.getSzScrNmCaseMrgTo() );
    txtUlIdCaseMergeFrom = FormattingHelper.formatString(String.valueOf(caseMergeSplitRow.getUlIdCaseMergeFrom()) );
    txtSzScrNmCaseMrgFrom = FormattingHelper.formatString(caseMergeSplitRow.getSzScrNmCaseMrgFrom());
    txtSzScrMergeWorker = FormattingHelper.formatString(caseMergeSplitRow.getSzScrMergeWorker());
    txtDtDtCaseMerg = FormattingHelper.formatDate(caseMergeSplitRow.getDtDtCaseMerge());
    txtSzScrNmSplitWorker = FormattingHelper.formatString(caseMergeSplitRow.getSzScrNmSplitWorker());
    txtDtCaseMergeSplit = FormattingHelper.formatDate(caseMergeSplitRow.getDtCaseMergeSplit() );
  }


  //if the user clicks the ADD pushbutton, only the Name Case To name and id, user's name and current date should populate
  if (cReqFuncCd.equals(ServiceConstants.REQ_FUNC_CD_ADD))
  {
    txtUlIdCaseMergeTo = FormattingHelper.formatString(String.valueOf( GlobalData.getUlIdCase( request ) ));
    txtSzScrNmCaseMrgTo = (String) request.getAttribute("txtSzScrNmCaseMrgTo");
    txtUlIdCaseMergeFrom = "";
    txtSzScrNmCaseMrgFrom = "";
    txtSzScrMergeWorker = user.getUserFullName();
    txtDtDtCaseMerg = FormattingHelper.formatDate(ccfc39so.getDtDtTodaysDate());
    txtSzScrNmSplitWorker = "";
    txtDtCaseMergeSplit = "";
  }
  //the user clicks the VALIDATE pushbutton
  if (cReqFuncCd.equals(ServiceConstants.REQ_FUNC_CD_KEEP) )
  {
    txtUlIdCaseMergeTo = FormattingHelper.formatString(String.valueOf( GlobalData.getUlIdCase( request ) ));
    txtSzScrNmCaseMrgTo = (String) request.getAttribute("txtSzScrNmCaseMrgTo");
    txtUlIdCaseMergeFrom = (String) request.getAttribute("txtUlIdCaseMergeFrom");
    txtSzScrNmCaseMrgFrom = (String) request.getAttribute("txtSzScrNmCaseMrgFrom");
    txtSzScrMergeWorker = user.getUserFullName();
    txtDtDtCaseMerg = FormattingHelper.formatDate(ccfc39so.getDtDtTodaysDate());
    txtSzScrNmSplitWorker = "";
    txtDtCaseMergeSplit = "";
  }
%>

<script type="text/javascript" language="JavaScript1.2">
//this message warns that pending approvals will be invalidated if the cases are merged
function mergePending()
{
<%
      if (CodesTables.CEVTSTAT_PEND.equals(ccfc40so.getSzCdCaseFromCCLStatus()) ||
          CodesTables.CEVTSTAT_PEND.equals(ccfc40so.getSzCdCaseToCCLStatus()) ||
          CodesTables.CEVTSTAT_PEND.equals(ccfc40so.getSzCdCasePendEvent()))
      {
%>
  return confirm('<%=MessageLookup.getMessageByNumber(Messages.MSG_INV_PEND_APRV_INVALDT)%>');
<%
      }
      else
      {
%>
   return true;
<%
      }
%>
}
//Confimation message to ask if the user wants to merge
function mergePerson()
{
     if (<%="Y".equals(hdnBIndValidate)%>)
    {
        <%
        String message ="";
        /* SIR 23258 Start- Message content changed from "Merge case# into case# ?" to
         *  "Merge case name, case# into case name, case# ?"
         */
        String to ="";
        String from = "";
        to = (String) request.getAttribute("txtSzScrNmCaseMrgTo");
        from = (String) request.getAttribute("txtSzScrNmCaseMrgFrom");
        if(to != null && from != null)
        {
            message = MessageLookup.getMessageByNumber(Messages.MSG_CONFIRM_CASE_MERGE);
            message = MessageLookup.addMessageParameter( message, from );
            message = MessageLookup.addMessageParameter( message, ContextHelper.getIntSafe(request, "txtUlIdCaseMergeFrom") );
            message = MessageLookup.addMessageParameter( message,to);
            message = MessageLookup.addMessageParameter( message, ContextHelper.getIntSafe(request, "txtUlIdCaseMergeTo") );
            message = message.trim();
            //sir#14411. added the if statement
            if ( sSwitch != null &&
                 sSwitch.compareToIgnoreCase( CaseSummaryConversation.SWITCH_CASES ) == 0 )
            {
               message = message.concat("\\n");
               message = message.concat(MessageLookup.getMessageByNumber(Messages.MSG_MERGE_BY_INTAKE_DATE));
            }
        }
        /* SIR 23258 End*/
      %>
       bMerge = confirm("<%= message %>");
       return bMerge;
     }
     else
     {
        alert('<%= MessageLookup.getMessageByNumber( Messages.MSG_VALIDATION_MERGE) %>');
        return false;
     }
}


function merge()
{
  if ( mergePerson() )
  {
    if ( mergePending() )
    {
      return true;
    }
  }
  return false;
}
<% /* SIR#23257: added splitCase() function */%>
function splitCase()
{
    <%
    String message1 = "";
    String message2 = " Note: All Stages originally closed to merge will RE-OPEN with original start-date ON YOUR WORKLOAD.";
    message1 = MessageLookup.getMessageByNumber( Messages.MSG_CONFIRM_SPLIT) ;
    message1 = MessageLookup.addMessageParameter( message1, Integer.parseInt( txtUlIdCaseMergeTo ));
    if ( txtUlIdCaseMergeFrom != "")
    {
      message1 = MessageLookup.addMessageParameter( message1, Integer.parseInt( txtUlIdCaseMergeFrom ));
    }
    message1 = message1.concat( "\\n" );
    message1 = message1.concat( message2 );
    %>
    return confirm("<%= message1 %> ");
}

</script>

<% /* Include custom tag for displaying errors on the page */ %>
<impact:validateErrors/>
<% String defaultButtonString = Sets.isInSetStr( Sets.A + Sets.B + Sets.C, request );
%>
<impact:validateForm
name="frmCaseMergeSplitDetail"
defaultButton="<%=defaultButtonString%>"
method="post"
action="/workload/CaseSummary/displayCaseMergeSplitDetail"
validationClass="gov.georgia.dhr.dfcs.sacwis.web.workload.CaseSummaryCustomValidation"
pageMode="<%=pageMode%>"
schema="/WEB-INF/Constraints.xsd">

<% /* Include any hidden fields needed on the page */%>
<impact:validateInput type="hidden" name="arrayIndex" value=""/>
<impact:validateInput type="hidden" name="hdnCReqFuncCd" value=""/>
<impact:validateInput type="hidden" name="hdnDataAction" value="<%=hdnDataAction %>"/>
<impact:validateInput type="hidden" name="hdnBIndValidate" value="<%=hdnBIndValidate%>"/>

<% /* Start the HTML for the page */ %>
<% /* Begin Case Merge Split Main Table */ %>
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
  <tr>
    <th colspan="6">To</th>
  </tr>
  <tr>
     <td><impact:validateDisplayOnlyField label="ID" name="txtUlIdCaseMergeTo"
          value="<%= FormattingHelper.formatString( txtUlIdCaseMergeTo ) %>" />
     </td>
     <td width="15%">&nbsp;</td>
     <td><impact:validateDisplayOnlyField label="Name" name="txtSzScrNmCaseMrgTo"
         value="<%= FormattingHelper.formatString( txtSzScrNmCaseMrgTo ) %>" />
     </td>
     <td width="25%">&nbsp;</td>
  </tr>
  <tr>
    <th colspan="6">From</th>
  </tr>
  <tr>
    <td><impact:validateInput label="ID" name="txtUlIdCaseMergeFrom"
        value="<%= FormattingHelper.formatString( txtUlIdCaseMergeFrom ) %>"
        type="text"  cssClass="formInput" size="9" maxLength="8" required="true" constraint="ID" tabIndex="<%= tabIndex++ %>" />
        <impact:ButtonTag img="btnValidate" name="btnValidate" form="frmCaseMergeSplitDetail"
        action="/workload/CaseSummary/validateCaseMerge" tabIndex="<%= tabIndex++ %>"
        disabled="<%= Sets.isInSetStr( Sets.A + Sets.B + Sets.C, request )%>"/>
    </td>
    <td>&nbsp;</td>
    <td><impact:validateDisplayOnlyField label="Name" name="txtSzScrNmCaseMrgFrom"
         value="<%= FormattingHelper.formatString( txtSzScrNmCaseMrgFrom ) %>" />
    </td>
    <td>&nbsp;</td>
  </tr>
</table>
<% /* End Case Merge Split Main Table */ %>
<br>
<% /* Begin Merge Information */ %>
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
   <tr>
     <th colspan="6">Merge Information</th>
  </tr>
  <tr>
    <td><impact:validateDisplayOnlyField label="Staff Name Merge" name="txtSzScrMergeWorker"
         value="<%= FormattingHelper.formatString( txtSzScrMergeWorker ) %>" />
    </td>
    <td width="15%">&nbsp;</td>
    <td><impact:validateDisplayOnlyField label="Date Merge" name="txtDtDtCaseMerge"
         value="<%= FormattingHelper.formatString( txtDtDtCaseMerg ) %>" />
    </td>
    <td width="25%">&nbsp;</td>
   </tr>
</table>
<% /* End Merge Information */ %>

<%if (cReqFuncCd.equals(ServiceConstants.REQ_FUNC_CD_UPDATE))
  {%>
<% /* Begin Split Information */ %>
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
   <tr>
     <th colspan="6">Split Information</th>
  </tr>
  <tr>
    <td><impact:validateDisplayOnlyField label="Staff Name Split" name="txtSzScrNmSplitWorker"
         value="<%= FormattingHelper.formatString( txtSzScrNmSplitWorker ) %>" />
    </td>
    <td width="15%">&nbsp;</td>
    <td><impact:validateDisplayOnlyField label="Date Split" name="txtDtCaseMergeSplit"
         value="<%= FormattingHelper.formatString( txtDtCaseMergeSplit ) %>" />
    </td>
    <td width="25%">&nbsp;</td>
  </tr>
</table>
  <%}%>

<% /* End Split Information */ %>

<% /* SIR#23257: added splitCase() function to btnSplit ButtonTag */ %>
<% /* Begin Buttons */ %>
<table border="0" cellspacing="0" cellpadding="3" width="100%">
  <tr>
    <td class="alignRight">
      <impact:ButtonTag img="btnVoidPending" name="btnVoidPending" form="frmCaseMergeSplitDetail"
        action="/workload/CaseSummary/voidPending" tabIndex="<%= tabIndex++ %>"
        restrictRepost="true"
        disabled="<%= Sets.isInSetStr( Sets.B + Sets.C + Sets.D, request )%>"/>
      <impact:ButtonTag img="btnMerge" name="btnMerge" form="frmCaseMergeSplitDetail"
        action="/workload/CaseSummary/saveCaseMergeSplitDetail" tabIndex="<%= tabIndex++ %>"
        restrictRepost="true"
        disabled="<%= Sets.isInSetStr( Sets.A + Sets.B + Sets.C, request )%>"
        function="return merge()" />
      <impact:ButtonTag img="btnSplit" name="btnSplit" form="frmCaseMergeSplitDetail"
        action="/workload/CaseSummary/saveCaseMergeSplitDetail" tabIndex="<%= tabIndex++ %>"
        restrictRepost="true"
        disabled="<%= Sets.isInSetStr( Sets.A + Sets.C + Sets.D, request )%>"
        function="return splitCase()" />    </td>
  </tr>
</table>
<% /* End Buttons */ %>

<%-- Always include this hidden field in your form --%>
<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
</impact:validateForm>

