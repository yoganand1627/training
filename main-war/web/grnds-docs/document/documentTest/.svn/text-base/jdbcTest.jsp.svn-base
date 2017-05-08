<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Vector"%>
<%@page import="gov.georgia.dhr.dfcs.sacwis.core.jdbchelper.JdbcHelper"%>
<%
try {
    Connection connection = JdbcHelper.getConnection();
    Statement statement = connection.createStatement();
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = 
    statement.executeQuery("select code, decode from ccpsoutp");

    Vector codeVector = new Vector();
    while (resultSet.next())
    {
        String code = resultSet.getString(1);
        String decode = resultSet.getString(2);
        codeVector.addElement(code);
    }

    String[] codes = new String[codeVector.size()];
    codeVector.copyInto(codes);
    resultSet.close();
    statement.close();
    if (connection != null && !connection.isClosed()) {
      connection.close();
    }


    String dynamicSql = "select decode from ccpsoutp where code = ";
    String staticSql = "select decode from ccpsoutp where code = ?";

    out.println("<table border=1>");
    out.println("<tr>");
    out.println("<th></th>");
    out.println("<th>statement</th>");
    out.println("<th>preparedStatement</th>");
    out.println("</tr>");
    out.println("<tr>");
    out.println("<th>new connection</th>");

    startTime();
    for (int i = 0; i < codes.length; i++)
    {
        connection = JdbcHelper.getConnection();
        statement = connection.createStatement();
        String sql = dynamicSql + "'" + codes[i] + "'";
        resultSet = statement.executeQuery(sql);
        resultSet.next();
        String decode = resultSet.getString(1);
        resultSet.close();
        statement.close();
        if (connection != null && !connection.isClosed()) {
          connection.close();
        }
    }
    out.println("<td>" + endTime() + "</td>");


    startTime();
    for (int i = 0; i < codes.length; i++)
    {
        connection = JdbcHelper.getConnection();
        preparedStatement = connection.prepareStatement(staticSql);
        preparedStatement.setString(1, codes[i]);
        resultSet = preparedStatement.executeQuery();
        resultSet.next();
        String decode = resultSet.getString(1);
        resultSet.close();
        preparedStatement.close();
        if (connection != null && !connection.isClosed()) {
          connection.close();
        }
    }
    out.println("<td>" + endTime() + "</td>");

    out.println("</tr>");
    out.println("<tr>");
    out.println("<th>save connection</th>");

    connection = JdbcHelper.getConnection();

    startTime();
    for (int i = 0; i < codes.length; i++)
    {
        statement = connection.createStatement();
        String sql = dynamicSql + "'" + codes[i] + "'";
        resultSet = statement.executeQuery(sql);
        resultSet.next();
        String decode = resultSet.getString(1);
        resultSet.close();
        statement.close();
    }
    out.println("<td>" + endTime() + "</td>");


    startTime();
    for (int i = 0; i < codes.length; i++)
    {
        preparedStatement = connection.prepareStatement(staticSql);
        preparedStatement.setString(1, codes[i]);
        resultSet = preparedStatement.executeQuery();
        resultSet.next();
        String decode = resultSet.getString(1);
        resultSet.close();
        preparedStatement.close();
    }
    out.println("<td>" + endTime() + "</td>");

    out.println("</tr>");
    out.println("<tr>");
    out.println("<th>save statement</th>");

    statement = connection.createStatement();
    preparedStatement = connection.prepareStatement(staticSql);

    startTime();
    for (int i = 0; i < codes.length; i++)
    {
        String sql = dynamicSql + "'" + codes[i] + "'";
        resultSet = statement.executeQuery(sql);
        resultSet.next();
        String decode = resultSet.getString(1);
        resultSet.close();
    }
    out.println("<td>" + endTime() + "</td>");


    startTime();
    for (int i = 0; i < codes.length; i++)
    {
        preparedStatement.setString(1, codes[i]);
        resultSet = preparedStatement.executeQuery();
        resultSet.next();
        String decode = resultSet.getString(1);
        resultSet.close();
    }
    out.println("<td>" + endTime() + "</td>");

    out.println("</tr>");
    out.println("<tr>");
    out.println("</table>");

    statement.close();
    preparedStatement.close();
    if (connection != null && !connection.isClosed()) {
      connection.close();
    }

} catch (Throwable e) {
    out.println("<pre>");
    e.printStackTrace(new PrintWriter(out));
    out.println("</pre>");
}
%>
<%!
protected long startTime = 0;


protected void startTime()
{
    startTime = new Date().getTime();
}


protected long endTime()
{
    long endTime = new Date().getTime();
    return (endTime - startTime);
}
%>
