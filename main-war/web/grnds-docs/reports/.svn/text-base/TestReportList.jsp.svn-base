<%@ page import="java.io.PrintWriter,
                 java.sql.Connection,
                 java.sql.ResultSet,
                 java.sql.Statement" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.jdbchelper.JdbcHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.reports.ReportTestConversation" %>

<!DOCTYPE HTML PUBLIC "-//IETF//DTD HTML//EN">
<html>
<head>
  <title>Test Report List</title>
</head>

<body>
<h1>List of available reports</h1>

<table>
  <tr>
    <th>Report Name</th>
    <!--    <th>dt_last_update</th> -->
    <!--    <th>nm_rpt_sqr_name</th> -->
    <!--    <th>nm_rpt_sqr_ver</th> -->
    <!--    <th>nbr_rpt_retainage</th> -->
    <!--    <th>nm_rpt_type</th> -->
    <!--    <th>txt_rpt_full_name</th> -->
    <!--    <th>nm_rpt_template_name</th> -->
    <!--    <th>nm_rpt_orientation</th> -->
    <!--    <th>txt_rpt_email_options</th> -->
  </tr>
  <%
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
    try {
      String query =
              "select \n" +
              "       dt_last_update, \n" +
              "       nm_rpt_sqr_name, \n" +
              "       nm_rpt_sqr_ver, \n" +
              "       nbr_rpt_retainage, \n" +
              "       nm_rpt_type, \n" +
              "       txt_rpt_full_name, \n" +
              "       nm_rpt_template_name, \n" +
              "       nm_rpt_orientation, \n" +
              "       txt_rpt_email_options \n" +
              "from reports \n" +
              "order by txt_rpt_full_name \n";

      connection = JdbcHelper.getConnection();
      statement = connection.createStatement();
      resultSet = statement.executeQuery(query);

      while (resultSet.next()) {
        int i = 1;
        String dt_last_update = resultSet.getString(i++);
        String nm_rpt_sqr_name = resultSet.getString(i++);
        String nm_rpt_sqr_ver = resultSet.getString(i++);
        String nbr_rpt_retainage = resultSet.getString(i++);
        String nm_rpt_type = resultSet.getString(i++);
        String txt_rpt_full_name = resultSet.getString(i++);
        String nm_rpt_template_name = resultSet.getString(i++);
        String nm_rpt_orientation = resultSet.getString(i++);
        String txt_rpt_email_options = resultSet.getString(i++);

        Map hashtable = new HashMap();
        hashtable.put("nm_rpt_sqr_name", nm_rpt_sqr_name);
        hashtable.put("nm_rpt_sqr_ver", nm_rpt_sqr_ver);
        hashtable.put("txt_rpt_full_name", txt_rpt_full_name);

        String baseUrl = ReportTestConversation.REPORT_FORM;
        baseUrl = "/admin/ReportTest/displayReportForm";
        String url = ReportTestConversation.getUrl(baseUrl, hashtable);
  %>
  <tr>
    <td><a href="<%= url %>"/><%= txt_rpt_full_name %> (<%= nm_rpt_sqr_name %>, <%= nm_rpt_sqr_ver %>)</a>
  </td>
</tr>
<%
  }
%>
</table>

<hr>
<address></address>
<!-- hhmts start -->
Last modified: Tue Feb 11 17:14:22 Central Standard Time 2003
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
  finally {
    if (resultSet != null) {
      resultSet.close();
    }
    if (statement != null) {
      statement.close();
    }
    if (connection != null && !connection.isClosed()) {
      connection.close();
    }
  }
%>
