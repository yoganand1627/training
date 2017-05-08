package org.apache.jsp.grnds_002ddocs;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public final class TestEReports_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


  public static final String MISSING_STAGEID_SQL =
          "SELECT ID_EREPORT, DT_SUBMIT, ID_PERSON, ID_STAGE FROM EREPORT_STATUS WHERE CD_STATUS='2' AND ID_STAGE IS NULL";
  public static final String ERROR_WITH_STAGEID_SQL =
          "SELECT ID_EREPORT, DT_SUBMIT, ID_PERSON, ID_STAGE FROM EREPORT_STATUS WHERE CD_STATUS='2' AND ID_STAGE IS NOT NULL";
  public static final String CHECK_CALL_NARRATIVE_SQL = "SELECT ID_STAGE FROM INCOMING_NARRATIVE WHERE ID_STAGE=?";

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

      out.write("<!--\r\nDescription: Page that tests for errored E-Reports\r\nAuthor: Stephen Roberts\r\nDate: 03/31/2004\r\n\r\n\r\n************************************************************************\r\nTHIS IS A TOOL FOR SWI TO USE. PLEASE DO NOT MODIFY WITHOUT CONTACTING\r\nSTEPHEN ROBERTS OR RODRIG0 DEJUANA.\r\n\r\nTHIS IS A STANDALONE WEBPAGE THAT HITS THE REPORTING DATABASE.\r\n\r\n\r\n************************************************************************\r\n\r\n\r\n-->\r\n\r\n\r\n\r\n\r\n\r\n<html>\r\n\r\n<head>\r\n  <title>E-Report Error Page</title>\r\n  <link href=\"/grnds-docs/css/impact.css\" rel=stylesheet>\r\n</head>\r\n\r\n");
      out.write('\r');
      out.write('\n');

  Connection connection = null;
  PreparedStatement stmt = null;
  ResultSet rs = null;
  PrintWriter pout = response.getWriter();
  boolean alert = false;

  try {
    // The driver that we will be using
    String driverClassName = "oracle.jdbc.OracleDriver";

    // Register the driver used for connections on this page
    Class.forName(driverClassName);
    //   connection = DriverManager.getConnection("jdbc:oracle:thin:@canis.tdprs.state.tx.us:1522:impactt","capson", "binuxik");
    connection = DriverManager.getConnection("jdbc:oracle:thin:@dbrpt.tdprs.state.tx.us:1522:rpt", "acuser", "olla");

    //Search for E-Reports w/out Stage Ids
    stmt = connection.prepareStatement(MISSING_STAGEID_SQL, ResultSet.TYPE_SCROLL_INSENSITIVE,
                                       ResultSet.CONCUR_READ_ONLY);
    rs = stmt.executeQuery();


      out.write("\r\n\r\n<strong>E-Reports in Error State</strong><br><br>\r\nThe following e-reports have been assigned but generated a blank Intake. They can be processed by using\r\nE-Report search.\r\n<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" class=\"tableBorder\">\r\n  <tr>\r\n    <th>E-Report Confirmation #</th>\r\n    <th>Submit Date</th>\r\n    <th>Person ID</th>\r\n    <th>Call ID</th>\r\n  </tr>\r\n  ");

    while (rs.next()) {
  
      out.write("\r\n  <tr>\r\n    <td>\r\n      ");
      out.print(rs.getInt(1) );
      out.write("\r\n    </td>\r\n    <td>\r\n      ");
      out.print(rs.getTimestamp(2).toString());
      out.write("\r\n    </td>\r\n    <td>\r\n      ");
      out.print(rs.getInt(3) );
      out.write("\r\n    </td>\r\n    <td>\r\n      ");
      out.print(rs.getInt(4) );
      out.write("\r\n    </td>\r\n  </tr>\r\n  ");

      alert = true;
    }
  
      out.write("\r\n</table>\r\n\r\n");

  }
  catch (Exception e) {
    e.printStackTrace(pout);
  }
  finally {
    try {
      if (rs != null) {
        rs.close();
      }
      if (connection != null && !connection.isClosed()) {
        connection.close();
      }
    }
    catch (Exception e) {
    }
  }


      out.write("\r\n\r\nAlert: ");
      out.print(alert);
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
