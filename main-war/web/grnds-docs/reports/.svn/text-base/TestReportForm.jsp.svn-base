<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.service.document.Cfp" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.reports.ReportTestConversation" %>
<%@ page import="org.springframework.web.context.WebApplicationContext" %>
<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils" %>


<!DOCTYPE HTML PUBLIC "-//IETF//DTD HTML//EN">
<html>
<head>
  <title>Test Report Form</title>
</head>

<body>
<%
  try {
    String formName = "TestReportForm";
    int tabIndex = 1;

    String txt_rpt_full_name = request.getParameter("txt_rpt_full_name");
    String nm_rpt_sqr_name = request.getParameter("nm_rpt_sqr_name");
    String nm_rpt_sqr_ver = request.getParameter("nm_rpt_sqr_ver");

    WebApplicationContext context =
            WebApplicationContextUtils.getWebApplicationContext(getServletConfig().getServletContext());
    Cfp cfp = (Cfp) context.getBean("cfp");
    String[] parameterNames = cfp.getParameterNames(nm_rpt_sqr_name, nm_rpt_sqr_ver);

    String url = ReportTestConversation.EXECUTE_REPORT;
    url = "/admin/ReportTest/executeReport";
%>

<impact:validateForm name="<%= formName %>"
                     method="post"
                     pageMode="<%= PageModeConstants.EDIT %>"
                     action='<%= ReportTestConversation.EXECUTE_REPORT %>'
                     schema="/WEB-INF/Constraints.xsd">

  <impact:validateErrors/>

  <table>
    <tr>
      <td width="100"><b><%= txt_rpt_full_name %>
      </b></td>
      <td width="100">&nbsp;</td>

        <impact:validateInput type="hidden" name="txt_rpt_full_name" value="<%= txt_rpt_full_name %>"/>
        <impact:validateInput type="hidden" name="nm_rpt_sqr_name" value="<%= nm_rpt_sqr_name %>"/>
        <impact:validateInput type="hidden" name="nm_rpt_sqr_ver" value="<%= nm_rpt_sqr_ver %>"/>
        <%

          for (int i = 0; i < parameterNames.length; i++)
          {
            String parameterName = "parameter" + i;

        %>
    <tr>
      <td width="100">
        <impact:if test="<%= ReportTestConversation.isDateParameter(parameterNames[i]) %>">
          <impact:then>
            <impact:validateDate tabIndex="<%= tabIndex++ %>"
                                 size="10"
                                 constraint="Date"
                                 label="<%= parameterNames[i] %>"
                                 name="<%= parameterName %>"
                                 value=""/>
          </impact:then>
          <impact:else>
            <impact:validateInput tabIndex="<%= tabIndex++ %>"
                                  type="text"
                                  label="<%= parameterNames[i] %>"
                                  name="<%= parameterName %>"
                                  value=""/>
          </impact:else>
        </impact:if>
      </td>
    </tr>
    <%
      }
    %>
  </table>
  <impact:ButtonTag name="Submit"
                    accessKey="S"
                    backSafe="true"
                    tabIndex='<%= tabIndex++ %>'
                    action='<%= ReportTestConversation.EXECUTE_REPORT %>'
                    form='<%= formName %>'
                    img="btnSubmit"
                    editableMode='<%= EditableMode.EDIT %>'/>

  <input type="hidden" name="<%= HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY %>">
</impact:validateForm>

<hr>
<address></address>
<!-- hhmts start -->
Last modified: Tue Feb 11 18:30:23 Central Standard Time 2003
<!-- hhmts end -->
</body>
</html>

<%
  }
  catch (Throwable e) {
    out.println("<pre>");
    e.printStackTrace(new PrintWriter(out));
    out.println("</pre>");
  }
%>
