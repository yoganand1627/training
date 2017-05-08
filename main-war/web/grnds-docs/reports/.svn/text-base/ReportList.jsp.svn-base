<%--
JSP Name:     Output Launch
Created by:   Heather Dean
Date Created: 11/01/02

Description:
This JSP allows the user to view the Report List, launch a report or retry a report

Change History:
Date      User              Description
--------  ----------------  --------------------------------------------------
11/01/02  Heather Dean      Initial jsp creation
12/01/08  alwilliams		STGAP00009474: Updated pagination support
--%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>
<%@ page import="java.util.Enumeration" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.input.CARC06SI" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CARC06SO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC06SOG" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC06SOG_ARRAY" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.reports.ReportsConversation" %>

<script type="text/javascript" language="JavaScript">
  function updateReports(id) {
    document.frmUpdateReports.ulIdRptList.value = id;
    document.frmUpdateReports.submit();
  }

  function setRetryParms(reportName, reportVersion, reportID, emailMessage, reportType) {
    document.frmUpdateReports.retry.value = 'true';
    document.frmUpdateReports.szNmRptSqrName.value = reportName;
    document.frmUpdateReports.szNmRptSqrVer.value = reportVersion;
    document.frmUpdateReports.ulIdRptList.value = reportID;
    document.frmUpdateReports.szTxtEmailMessage.value = emailMessage;
    document.frmUpdateReports.szNmRptType.value = reportType;
    
  }

  function checkRetryStatus() {
    if (!(document.frmUpdateReports.retry.value == 'true')) {
      alert('<%=MessageLookup.getMessageByName("MSG_SELECT_ROW_ACTION")%>');
      return false;
    } else {
      document.frmUpdateReports.FormValidateCancel = 'true';
      return true;
    }
  }
</script>

<%
  CARC06SI carc06si = (CARC06SI) request.getAttribute("INPUT");
  CARC06SO carc06so = (CARC06SO) request.getAttribute("OUTPUT");
  int loopCount = 0;
  int tabIndex = 1;
  String pageMode = PageModeConstants.EDIT; //Needed for validate form
  boolean bRetryButtonHide = true;
  boolean bIsBatchReport = false;
  String personID = ContextHelper.getStringSafe(request, "ulIdPerson");
  String retrieveType = ContextHelper.getStringSafe(request, "cSysIndRptRtrvType");
%>
<impact:validateErrors/>
<%
  if (carc06so == null) {
%>
<table width="100%" border="0" cellspacing="0" cellpadding="3" class="tableBorderList">
  <tr>
    <th class="thList">&nbsp;</th>
    <th class="thList">Status</th>
    <th class="thList">Name</th>
    <th class="thList">Description</th>
    <th class="thList">Generation Date</th>
    <th class="thList">Purge Date</th>
    <th class="thList">Output</th>
  </tr>
  <tr>
    <td colspan="7">
      <%=MessageLookup.getMessageByName("SSM_NO_ROWS_RETURNED")%>
    </td>
  </tr>
</table>
<%
} else {
  ROWCARC06SOG_ARRAY rowArray = carc06so.getROWCARC06SOG_ARRAY();
  ROWCARC06SOG row;
  String destinationParameters =
          "?cSysIndRptRtrvType=" + carc06si.getCSysIndRptRtrvType() + "&ulIdPerson=" + carc06si.getUlIdPerson();
  String destination = "/admin/Reports/reportDelete" + destinationParameters;
%>

<impact:validateForm name="frmUpdateReports" method="post" action="<%= destination %>" pageMode="<%= pageMode %>"
                     schema="/WEB-INF/Constraints.xsd">
<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>"/>
<impact:validateInput type="hidden" name="ulIdPerson" value="<%= personID %>"/>
<impact:validateInput type="hidden" name="cSysIndRptRtrvType" value="<%= retrieveType %>"/>
<impact:validateInput type="hidden" name="resultsPerPage" value="20"/>
<impact:validateInput type="hidden" name="ulIdRptList"/>
<impact:validateInput type="hidden" name="szNmRptSqrName"/>
<impact:validateInput type="hidden" name="szNmRptSqrVer"/>
<impact:validateInput type="hidden" name="retry"/>
<impact:validateInput type="hidden" name="szTxtEmailMessage"/>
<impact:validateInput type="hidden" name="szNmRptType"/>

<impact:validateErrors/>

<%-- STGAP00009474 - Updated pagination support              --%>
<%-- This is so Previous/Next align correctly with the table --%>
<table border="0" cellspacing="0" cellpadding="3" width="95%">
<tr>
<td>
<impact:pagination submitUrl="/admin/Reports/reportList">
</td>
</tr>
</table>

<table width="100%" border="0" cellspacing="0" cellpadding="3" class="tableBorderList">
<tr>
  <th class="thList">&nbsp;</th>
  <th class="thList">Status</th>
  <th class="thList">Name</th>
  <th class="thList">Description</th>
  <th class="thList">Generation Date</th>
  <th class="thList">Purge Date</th>
</tr>
<%
  for (Enumeration e = rowArray.enumerateROWCARC06SOG(); e.hasMoreElements();) {
    loopCount++;
    String rowCss = loopCount % 2 == 1 ? "altColor" : "";

    row = (ROWCARC06SOG) e.nextElement();
    String reportType = row.getSzNmRptType();
    String reportSqrName = row.getSzNmRptSqrName();
    String indShinesBatch = row.getBIndShinesBatch();
    if ("B".equals(reportType) || "E".equals(reportType) || "M".equals(reportType) || "K".equals(reportType) || "Y".equals(indShinesBatch)) {
      bIsBatchReport = true;
    } else {
      bIsBatchReport = false;
    }
%>
<tr class="<%=rowCss%>">
  <td>
    <%
      if (!bIsBatchReport && (row.getSzTxtRptLstStatus().equals(ReportsConversation.REPORT_STATUS_ERR))) {
        //show radio buttons and 'retry' button
        bRetryButtonHide = false;
        String radioValue = String.valueOf(loopCount);
        String onClickString = "setRetryParms( '" + row.getSzNmRptSqrName() + "', '" + row.getSzNmRptSqrVer() +
                               "', '" + row.getUlIdRptList() + "', '" + row.getSzTxtRptLstRuntimeName() + "', '" + row.getSzNmRptType() +  "' )";
    %>
    <impact:validateInput type="radio" name="rbRowSelect" cssClass="formInput" onClick="<%= onClickString %>"
                          value="<%= radioValue %>" tabIndex="<%= tabIndex++ %>"/>
    <%
    } else {
    %>
    &nbsp;&nbsp;
    <%
      }
    %>
  </td>
  <%
    String strStatus;
    if (row.getSzTxtRptLstStatus().equals(ReportsConversation.REPORT_STATUS_DONE)) {
      strStatus = "Complete";
    } else if (row.getSzTxtRptLstStatus().equals(ReportsConversation.REPORT_STATUS_PENDING)) {
      strStatus = "Pending";
    } else if (row.getSzTxtRptLstStatus().equals(ReportsConversation.REPORT_STATUS_RUNNING)) {
      strStatus = "Running";
    } else if (row.getSzTxtRptLstStatus().equals(ReportsConversation.REPORT_STATUS_ERR)) {
      strStatus = "Error";
    } else {
      strStatus = row.getSzTxtRptLstStatus();
    }
  %>
  <td><%=strStatus%>
  </td>
  <%
    if (row.getSzTxtRptLstStatus().equals(ReportsConversation.REPORT_STATUS_DONE)) {
      if (bIsBatchReport) {
        // report is done and is batch
        // display the report, but don't try to delete it
  %>
  <td>
    <!-- Use a relative URL because we are already in the Reports conversation. -->
    <a href="/admin/Reports/reportRetrieve?FILENAME=<%= row.getSzTxtRptGenName() %>&RPTTYPE=<%= row.getSzNmRptType() %>"
       target="_blank"><%= row.getSzTxtRptFullName() %>
    </a>
  </td>
  <%
  } else {
    // report done and not batch -- display the report and delete it
  %>
  <td>
    <!-- Use a relative URL because we are already in the Reports conversation. -->
    <a href="/admin/Reports/reportRetrieve?FILENAME=<%= row.getSzTxtRptGenName() %>&RPTTYPE=<%= row.getSzNmRptType() %>" target="_blank"
       onClick="updateReports('<%= row.getUlIdRptList() %>')"><%= row.getSzTxtRptFullName() %>
    </a>
  </td>
  <%
    } //end else report done and not batch
  } else {
    // report is not done
  %>
  <td>
    <%=row.getSzTxtRptFullName()%>
  </td>
  <%
    } //end else report is not done
  %>
  <td>
    <%=(row.getSzTxtRptLstRuntimeName() == null) ? "" : row.getSzTxtRptLstRuntimeName()%>
  </td>
  <td>
    <%= FormattingHelper.formatDate(row.getDtDtRptLstGeneration()) %>
  </td>
  <td>
    <%= FormattingHelper.formatDate(row.getDtDtRptLstRetainage()) %>
  </td>

</tr>
<%
  } //end for Enumeration
%>

</table>

<%-- STGAP00009474 - Updated pagination support              --%>
<%-- This is so Previous/Next align correctly with the table --%>
<table border="0" cellspacing="0" cellpadding="3" width="95%">
<tr>
<td>
</impact:pagination>
</td>
</tr>
</table>

<table width="100%" border="0" cellspacing="0" cellpadding="3">
  <tr>
    <td width="5%">
      <%
        if (!bRetryButtonHide) {
      %>
      <impact:ButtonTag name="btnRetry" img="btnRetry" form="frmUpdateReports" action="/admin/Reports/reportRetry"
                        function="return checkRetryStatus()" tabIndex="1"/>
      <%
        } // end if retrybutton hide
      %>
    </td>
  </tr>
</table>

</impact:validateForm>

<%
  } //end big else (inputs, outputs not null)
%>
