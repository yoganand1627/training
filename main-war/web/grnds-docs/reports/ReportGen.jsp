<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.reports.ReportsConversation" %>
<%
  String errorMessage = (String) request.getAttribute(ReportsConversation.REPORT_ERROR_MESSAGE);
  if (errorMessage == null) {
    errorMessage = "";
  }
%>
<%=errorMessage%>
<br>
<a href="javascript:window.close()">Close this page.</a>
