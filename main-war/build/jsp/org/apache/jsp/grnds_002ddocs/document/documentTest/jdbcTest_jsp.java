package org.apache.jsp.grnds_002ddocs.document.documentTest;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Vector;
import gov.georgia.dhr.dfcs.sacwis.core.jdbchelper.JdbcHelper;

public final class jdbcTest_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


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

  private static java.util.Vector _jspx_dependants;

  public java.util.List getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    JspFactory _jspxFactory = null;
    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      _jspxFactory = JspFactory.getDefaultFactory();
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

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

      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      if (_jspxFactory != null) _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
