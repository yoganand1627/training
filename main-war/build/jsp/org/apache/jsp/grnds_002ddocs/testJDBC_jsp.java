package org.apache.jsp.grnds_002ddocs;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import gov.georgia.dhr.dfcs.sacwis.core.jdbchelper.JdbcHelper;

public final class testJDBC_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

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

      out.write("\n\n\n\n\n\n<html>\n<head>\n  <title>JDBC Test Page</title>\n</head>\n<body>\n");

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

      out.write("\n</body>\n</html>\n");
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
