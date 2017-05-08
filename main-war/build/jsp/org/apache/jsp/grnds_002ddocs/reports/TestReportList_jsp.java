package org.apache.jsp.grnds_002ddocs.reports;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import gov.georgia.dhr.dfcs.sacwis.core.jdbchelper.JdbcHelper;
import gov.georgia.dhr.dfcs.sacwis.web.reports.ReportTestConversation;

public final class TestReportList_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n<!DOCTYPE HTML PUBLIC \"-//IETF//DTD HTML//EN\">\r\n<html>\r\n<head>\r\n  <title>Test Report List</title>\r\n</head>\r\n\r\n<body>\r\n<h1>List of available reports</h1>\r\n\r\n<table>\r\n  <tr>\r\n    <th>Report Name</th>\r\n    <!--    <th>dt_last_update</th> -->\r\n    <!--    <th>nm_rpt_sqr_name</th> -->\r\n    <!--    <th>nm_rpt_sqr_ver</th> -->\r\n    <!--    <th>nbr_rpt_retainage</th> -->\r\n    <!--    <th>nm_rpt_type</th> -->\r\n    <!--    <th>txt_rpt_full_name</th> -->\r\n    <!--    <th>nm_rpt_template_name</th> -->\r\n    <!--    <th>nm_rpt_orientation</th> -->\r\n    <!--    <th>txt_rpt_email_options</th> -->\r\n  </tr>\r\n  ");

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
  
      out.write("\r\n  <tr>\r\n    <td><a href=\"");
      out.print( url );
      out.write('"');
      out.write('/');
      out.write('>');
      out.print( txt_rpt_full_name );
      out.write(' ');
      out.write('(');
      out.print( nm_rpt_sqr_name );
      out.write(',');
      out.write(' ');
      out.print( nm_rpt_sqr_ver );
      out.write(")</a>\r\n  </td>\r\n</tr>\r\n");

  }

      out.write("\r\n</table>\r\n\r\n<hr>\r\n<address></address>\r\n<!-- hhmts start -->\r\nLast modified: Tue Feb 11 17:14:22 Central Standard Time 2003\r\n<!-- hhmts end -->\r\n</body>\r\n</html>\r\n");


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
