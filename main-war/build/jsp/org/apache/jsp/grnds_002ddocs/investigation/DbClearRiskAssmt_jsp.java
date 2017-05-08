package org.apache.jsp.grnds_002ddocs.investigation;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public final class DbClearRiskAssmt_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!--\nDescription: This is a Database Querying tool for IMPACT development.\nAuthor: Brad Eilers\nDate: 06/24/02\n-->\n\n<html>\n<body>\n\n\n\n\n\n\n");


  // This page will always use PRODCOPY database
  String database = "prodcopy";
  String dbBaseUrl = "jdbc:oracle:thin:@canis:1525:";
  String dbUrl = dbBaseUrl + "prodcopy";
  String dbUserName = "capson";
  String dbPassword = "binuxik";

// Run a test sql to see if we can really connect to the DB
  try {
    DriverManager.registerDriver(new oracle.jdbc.OracleDriver());

    Connection conn = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
    // @machineName:port:SID,   userid,  password
    Statement stmt = conn.createStatement();
    ResultSet rset = stmt.executeQuery("select * from dual");
    while (rset.next()) {
    }
    stmt.close();
    if (conn != null && !conn.isClosed()) {
      conn.close();
    }
  }
  catch (SQLException sqle) {

      out.write("\nCould NOT connect to PRODCOPY<br>\n");
      out.print(sqle.getErrorCode());
      out.write("<br>");
      out.print(sqle.getMessage());
      out.write("<br>\n");


    return;
  }

// If we connect to the DB and do not have an exception,
// let the user know they are connected.


      out.write("\nDatabase Connection Successful<br>\n\n<form name=\"frmClearRiskAssmt\" action=\"DbClearRiskAssmt.jsp\" method=\"post\">\n  <input type=\"hidden\" name=\"action\" value=\"clearRiskAssmt\">\n  <input type=\"submit\" name=\"button\" value=\"Reset Risk Assessment\"/>\n  <input type=\"hidden\" name=\"database\" value=\"");
      out.print(database);
      out.write("\"/>\n</form>\n\n");


  // Clear the Risk Assessment if the user clicked 'Reset Risk Assessment'
  String action = request.getParameter("action");
  String sql =
          "update risk_factors set CD_RISK_FACTOR_RESPONSE = null where ID_EVENT = 66535519 and CD_RISK_FACTOR_CATEG in ('CF','CB')";
  if (action != null && !"".equals(action)) {
    try {
      DriverManager.registerDriver(new oracle.jdbc.OracleDriver());

      Connection conn4 = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
      // @machineName:port:SID,   userid,  password

      Statement stmt4 = conn4.createStatement();
      stmt4.executeUpdate(sql);

      stmt4.close();
      if (conn4 != null && !conn4.isClosed()) {
        conn4.close();
      }



      out.write("<font color=\"green\"><strong>Reset was successful.</strong></font>");


}
catch (SQLException sqle) {

      out.write("\n<br>");
      out.print(sqle.getErrorCode());
      out.write("<br>");
      out.print(sqle.getMessage());
      out.write('\n');


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
