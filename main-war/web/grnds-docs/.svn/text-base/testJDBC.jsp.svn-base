<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.io.StringWriter" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.jdbchelper.JdbcHelper" %>
<html>
<head>
  <title>JDBC Test Page</title>
</head>
<body>
<%
  out.print("Database Connection: ");

  Connection connection = null;
  PreparedStatement statement = null;
  ResultSet results = null;
  PrintWriter printWriter = null;
  try {
    connection = JdbcHelper.getConnection();
    statement = connection.prepareStatement("select 1 from dual");
    results = statement.executeQuery();
    results.next();
    results.getInt(1);
    out.println("SUCCESS");
  } catch (Exception e) {
    out.println("ERROR<br/>");
    out.println("Exception:" + e.getMessage());
    StringWriter writer = new StringWriter();
    printWriter = new PrintWriter(writer);
    e.printStackTrace(printWriter);
    out.print("<pre>");
    out.print(writer.getBuffer().toString());
    out.print("</pre>");
  } finally {
    try {
      if (results != null) {
        results.close();
      }
      if (statement != null) {
        statement.close();
      }
      if (connection != null && !connection.isClosed()) {
        connection.close();
      }
      if (printWriter != null) {
        printWriter.close();
      }
    } catch (Exception e) {
      out.println("ERROR Closing Resources<br/>");
      out.println("Exception:" + e.getMessage());
    }
  }
%>
</body>
</html>
