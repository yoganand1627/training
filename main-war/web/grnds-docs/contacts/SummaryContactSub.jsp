<%
//**  Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**  07/24/05 Mike Werle    SIR 23728 - Moved constants for code reuse in MPS
//**
//**
//**
%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>


<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.contacts.ContactSearchListDetailConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS08SO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS08SO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>


<%
{
  int _tabIndex = (Integer) request.getAttribute("tabIndex");

  BaseSessionStateManager _state = (BaseSessionStateManager)
    request.getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);


  CSYS08SO _csys08so = (CSYS08SO) _state.getAttribute("CSYS08SO", request);
  if (_csys08so == null) 
  { 
    _csys08so = new CSYS08SO(); 
  }

  String _selSzCdContactType =  ContactSearchListDetailConversation.getSelSzCdContactType(request);


  // SIR 18273 has decreed that from this day forth EXR's will no longer have a
  // Summary Period! :-) (so I removed EXR from the needsSummaryDates array)
  // We drop the first letter from the codes below because all MTH's have
  // Summary Dates and the rest of the list is all I's
  String[] needsSummaryDates = {"ATZ", "DVZ", "MAZ", "MTH", "PHZ", "QUZ", "REE", "REZ", "SEZ", "VAZ", "VIZ"};


  String disableSummaryDates = "true";
  boolean usesSummaryDates = false;
  
  //if the Contact Type needs summary dates set usesSummaryDates to true.
  for (int i = 0; i < needsSummaryDates.length; i++)
  {
    //!!!
    if (_selSzCdContactType.substring(1, 4).equals(needsSummaryDates[i]))
    {
      // SIR 19275 - If it's a Monthly Summary and Pending don't allow the
      // From and To dates to be modified.
      if (_csys08so.getROWCCMN45DO() != null && 
          CodesTables.CEVTSTAT_PEND.equals(_csys08so.getROWCCMN45DO().getSzCdEventStatus()) &&
          "MTH".equals( _selSzCdContactType.substring( 1, 4 ) ) )
      {
        disableSummaryDates = "true";
      } 
      else 
      {
        disableSummaryDates = "false";
      }
      usesSummaryDates = true;
      break;
    }
  }
  // If the dates aren't used then blank them for the display.
  String txtDtDtMonthlySummBegin = FormattingHelper.formatDate(_csys08so.getDtDtMonthlySummBegin());
  String txtDtDtMonthlySummEnd = FormattingHelper.formatDate(_csys08so.getDtDtMonthlySummEnd());
  if (!usesSummaryDates)
  {
    txtDtDtMonthlySummBegin = "";
    txtDtDtMonthlySummEnd = "";
  }
%>
</table>
<br>
  <impact:validateInput type="hidden" name="usesSummaryDates" value="<%= String.valueOf(usesSummaryDates) %>"/>

  <impact:ifThen test="<%= usesSummaryDates %>">
    <table border="0" cellspacing="0" cellpadding="3" width="100%" class="TableBorder">
      <tr class="subDetail">
        <th colspan="4">Contact Summary Period</th>
      </tr>
      <tr>
        <td width="15%">
          <impact:validateDate label="From"
                               width="34%"
                               constraint="Date"
                               name="txtDtDtMonthlySummBegin"
                               disabled="<%= disableSummaryDates %>"
                               conditionallyRequired="true" 
                               value="<%= txtDtDtMonthlySummBegin %>"
                               size="8"
                               tabIndex="<%= _tabIndex++ %>" />
        </td>
        <td width="15%">
          <impact:validateDate label="To"
                               constraint="Date"
                               name="txtDtDtMonthlySummEnd"
                               disabled="<%= disableSummaryDates %>"
                               conditionallyRequired="true" 
                               value="<%= txtDtDtMonthlySummEnd %>"
                               size="8"
                               tabIndex="<%= _tabIndex++ %>" />
        </td>
      </tr>
    </table>
  </impact:ifThen>
<%
  request.setAttribute("tabIndex", _tabIndex);
}
%>
