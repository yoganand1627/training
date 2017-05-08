<%
/**
 * JSP Name:     ApprovalStatus.jsp
 * Created by:   Jenn Casdorph
 * Date Created: 07/14/05
 *
 * Description:
 * The Approval Rejection page will display the details of why the
 * approval was rejected by the supervisor.
**/
%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UnitStaffIdentifier"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNI3DO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.workload.ApprovalStatusConversation"%>
<%@ page import="java.util.Enumeration"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>

<%
  String pageMode = PageModeConstants.VIEW;

  // get the user id
  UserProfile user = UserProfileHelper.getUserProfile( request );
  BaseSessionStateManager state = (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );

  ROWCCMNI3DO rowccmni3do = (ROWCCMNI3DO)request.getAttribute("rowccmni3do");

%>
<%
//This form is actually just a shortcut.  We want to resuse the code from APproval Status.

%>
<impact:validateForm name="frmApprovalStatus" method="post"
                     action="/workload/ApprovalStatus/displayApprovalStatus"
                     validationClass="gov.georgia.dhr.dfcs.sacwis.web.workload.ApprovalStatusCustomValidation"
                     pageMode="<%=pageMode%>"schema="/WEB-INF/Constraints.xsd">

  <table border="0" width="100%" cellSpacing="0" cellPadding="3" class="tableBorder">
    <tr>
      <th colspan="4">Reasons for Rejection</th>
    </tr>
    <tr>
    <tr>
     <td colspan="2"><b>Rejector:</b>&nbsp;&nbsp;<%= String.valueOf( rowccmni3do.getSzNMRejector()) %></td>
     <td colspan="2"><b>Date:</b>&nbsp;&nbsp;<%= FormattingHelper.formatDate( rowccmni3do.getDtDtRejection()) %></td>
    </tr>

   <!--     <impact:validateDisplayOnlyField
          label="Rejector"
          name="rejector"
          colspan="1"
          value="<%= String.valueOf( rowccmni3do.getSzNMRejector()) %>"/></td>
      <td><impact:validateDisplayOnlyField
          label="Date"
          name="date"
          colspan="1"
          value="<%= FormattingHelper.formatDate( rowccmni3do.getDtDtRejection()) %>"/></td>
    </tr>
   -->

    <%
    String apsEffortLabel="Case cannot be closed, the Client Continues to be in a state of abuse, neglect, or exploitation because of a lack of APS effort.";
    %>
    <tr>
     <td colspan="4"><impact:validateInput
                        label="<%=apsEffortLabel%>"
                        type="checkbox"
                        value="Y"
                        checked="<%=FormattingHelper.formatString(rowccmni3do.getBIndApsEffort())%>"
                        name="bIndApsEffort"/></td>
   </tr>

<%if (CodesTables.CSTAGES_INV.equals(GlobalData.getSzCdStage(request))) {%>


    <%
    String careEnteredLabel="CARE does not include all client problems including root causes.";
    %>
    <tr>
     <td colspan="4"><impact:validateInput
                        label="<%=careEnteredLabel%>"
                        type="checkbox"
                        value="Y"
                        checked="<%=FormattingHelper.formatString(rowccmni3do.getBIndCareEntered())%>"
                        name="bIndCareEntered"/></td>
   </tr>


    <%
    String evidenceLabel="Additional evidence collection needed for determining the truth of an allegation, for understanding the client's situation, or for resolving discrepancies.";
    %>
    <tr>
     <td colspan="4"><impact:validateInput
                        label="<%=evidenceLabel%>"
                        type="checkbox"
                        value="Y"
                        checked="<%=FormattingHelper.formatString(rowccmni3do.getBIndEvidence())%>"
                        name="bIndEvidence"/></td>
   </tr>
  <tr>
    <td colspan="4">

  <table border="0" width="100%" cellSpacing="0" cellPadding="3" class="tableBorder">
    <tr>
      <td width="15%">&nbsp;</td>
      <td colspan="4">Missing Evidence</td>
    </tr>
  <tr>
   <td>&nbsp;</td>
     <td><impact:validateInput
                        label="Reporter"
                        type="checkbox"
                        value="Y"
                        checked="<%=FormattingHelper.formatString(rowccmni3do.getBIndMissingEvidRptr())%>"
                        name="bIndMissingEvidRptr"/></td>
     <td><impact:validateInput
                        label="AP"
                        type="checkbox"
                        value="Y"
                        checked="<%=FormattingHelper.formatString(rowccmni3do.getBIndMissingEvidAp())%>"
                        name="bIndMissingEvidAp"/></td>
     <td colspan="2"><impact:validateInput
                        label="Medical professional"
                        type="checkbox"
                        value="Y"
                        checked="<%=FormattingHelper.formatString(rowccmni3do.getBIndMissingEvidMp())%>"
                        name="bIndMissingEvidMp"/></td>
   </tr>
   <tr>
      <td>&nbsp;</td>
     <td><impact:validateInput
                        label="Collateral"
                        type="checkbox"
                        value="Y"
                        checked="<%=FormattingHelper.formatString(rowccmni3do.getBIndMissingEvidCl())%>"
                        name="bIndMissingEvidCl"/></td>
     <td><impact:validateInput
                        label="Photographs"
                        type="checkbox"
                        value="Y"
                        checked="<%=FormattingHelper.formatString(rowccmni3do.getBIndMissingEvidPhoto())%>"
                        name="bIndMissingEvidPhoto"/></td>
     <td><impact:validateInput
                        label="Documentary Evidence"
                        type="checkbox"
                        value="Y"
                        checked="<%=FormattingHelper.formatString(rowccmni3do.getBIndMissingEvidDe())%>"
                        name="bIndMissingEvidDe"/></td>
     <td><impact:validateInput
                        label="Other"
                        type="checkbox"
                        value="Y"
                        checked="<%=FormattingHelper.formatString(rowccmni3do.getBIndMissingEvidOther())%>"
                        name="bIndMissingEvidOther"/></td>
     </tr>
  </table>
  </td>
</tr>

<%}%>
    <%
    String discretionaryLabel="Discretionary rejection for other reason (See comments).";
    %>
    <tr>
     <td colspan="4"><impact:validateInput
                        label="<%=discretionaryLabel%>"
                        type="checkbox"
                        value="Y"
                        checked="<%=FormattingHelper.formatString(rowccmni3do.getBIndDiscretionaryReason())%>"
                        name="bIndDiscretionaryReason"/></td>
   </tr>
    <tr>
      <td colspan="4" align="left">Comments:&nbsp;&nbsp;
      <%=FormattingHelper.formatString(rowccmni3do.getSzTxtApproversComments())%></td>
    </tr>

</table>
</impact:validateForm>
