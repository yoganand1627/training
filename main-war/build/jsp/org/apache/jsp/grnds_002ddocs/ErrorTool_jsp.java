package org.apache.jsp.grnds_002ddocs;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.jdbchelper.JdbcHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.exception.logging.ImpactExceptionLoggingUtility;

public final class ErrorTool_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


  // Max size of the html tables generated
  public static final int tableSize = 50;

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

      out.write("<!--\r\nDescription: This is a tool for Administering the Error Logging framework.\r\nAuthor: Brad Eilers\r\nDate: 09/23/03\r\n-->\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  // This must be set before the response is started
  response.setContentType("text/html; charset=" + ArchitectureConstants.CHARACTER_ENCODING);

      out.write("\r\n<html>\r\n<head>\r\n  <title>Impact Error Logging Management Tool</title>\r\n  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=");
      out.print(ArchitectureConstants.CHARACTER_ENCODING);
      out.write("\">\r\n  <link href=\"/grnds-docs/css/impact.css\" rel=stylesheet>\r\n  <script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n    function setOrderBy(newOrder)\r\n    {\r\n      document.frmError.orderBy.value = newOrder;\r\n      getPerfData_id.fireEvent(\"onclick\");\r\n      document.frmError.getErrorData.click();\r\n    }\r\n  </script>\r\n</head>\r\n<body>\r\n");
      out.write('\r');
      out.write('\n');

  if (request.getParameter("displayUsage") != null) {

      out.write("\r\n  <pre>\r\n    Notes on Usage:\r\n    Enable Global Performance Tracking -\r\n      Either enable at startup by setting performance.trace to true in architecture.properties\r\n      OR enable real-time by going to each JVM/server in the environment and clicking on 'Enable Perf Logging'\r\n    Enable Performance Tracking for a given user -\r\n      This is a two step process, which is necessary to make reduce processing needed for tracking performance.\r\n      First, enable perf logging by session by going to each JVM/server in the environment\r\n      and clicking on 'Enable Perf Logging By Session'.\r\n      Second, Set the SEC_MNTN_REGION_14 security attribute for the given user and have that\r\n      user log out and then back in to IMPACT.  To verify that the user has performance tracking enabled,\r\n      have the user go to the PerfTool.jsp page at grnds-docs/PerfTool.jsp.\r\n    Update the Batch Size - Perf records are written to the DB in batches to reduce\r\n      performance impact on the system.  The batch size can be decreased to see results\r\n");
      out.write("      in the DB more quickly.  It could also be increased to further reduce performance\r\n      impacts.  Note that anything that has been batched up but not written when the server\r\n      either dies or is shut down is lost.\r\n    Select a Date Range - The date range defaults to the current time to both give\r\n      a starting point and to give an example of the format required for the date.\r\n      When changing this, be sure to follow the example format.\r\n    Select a specific user - Enter the numeric person id for the user.  Invalid user\r\n      IDs will not return any records.\r\n  </pre>\r\n");

  }
  //Parse Date for display in form
  /** @todo Add SQL to select individual perf records vs. a summary */
  /** @todo Add ability to sort by column */
  /** @todo Make SDs color code and viewable via hover/rollover */
  //Get Date/Time for Perf Query
  String fromDate = request.getParameter("fromDate");
  String toDate = request.getParameter("toDate");

  // Format the current time.
  SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
  Date currentTime = new Date();
  String currentTimeString = formatter.format(currentTime);
  //Get a valid fromDate with either submitted date or current time.
  if (fromDate == null) {
    fromDate = currentTimeString;
  } else {
    try {
      //Validate this date and if its not valid, use current time
      formatter.parse(fromDate);
    }
    catch (Exception e) {
      fromDate = currentTimeString;
    }
  }
  //Get a valid toDate with either submitted date or current time.
  if (toDate == null) {
    toDate = currentTimeString;
  } else {
    try {
      //Validate this date and if its not valid, use current time
      formatter.parse(toDate);
    }
    catch (Exception e) {
      toDate = currentTimeString;
    }
  }

  //Enable Perf Logging if the Enable button was pressed.
  if (request.getParameter("enableErrorLogging") != null) {
    ImpactExceptionLoggingUtility.ERROR_LOGGING_ENABLED = true;
  }
  //Disable Perf Logging if the Disable button was pressed.
  if (request.getParameter("disableErrorLogging") != null) {
    ImpactExceptionLoggingUtility.ERROR_LOGGING_ENABLED = false;
  }

      out.write("\r\n<br/>\r\n");

  if (request.getParameter("displayUsage") != null) {

      out.write("\r\n<a href=\"/grnds-docs/ErrorTool.jsp\">UnDisplay Usage Notes</a><br/>\r\n");

} else {

      out.write("\r\n<a href=\"/grnds-docs/ErrorTool.jsp?displayUsage=true\">Display Usage Notes</a><br/>\r\n");

  }
  String idPersonString = (request.getParameter("idPerson") != null) ? request.getParameter("idPerson") : "";

      out.write("\r\nError Logging Enabled: ");
      out.print( ImpactExceptionLoggingUtility.ERROR_LOGGING_ENABLED );
      out.write("<br/>\r\n\r\n<form action=\"/grnds-docs/ErrorTool.jsp\" method=\"post\" name=\"frmError\">\r\n  <input type=\"submit\" name=\"enableErrorLogging\" value=\"Enable Error Logging\"/><br/>\r\n  <input type=\"submit\" name=\"disableErrorLogging\" value=\"Disable Error Logging\"/><br/>\r\n  Get Exception Data: <br/>\r\n  From: <input type=\"text\" maxlength=\"19\" name=\"fromDate\" value=\"");
      out.print( fromDate );
      out.write("\"/>\r\n  To: <input type=\"text\" maxlength=\"19\" name=\"toDate\" value=\"");
      out.print( toDate );
      out.write("\"/><br/>\r\n  Person ID: <input type=\"text\" maxlength=\"19\" name=\"idPerson\" value=\"");
      out.print(idPersonString );
      out.write("\"/><br/>\r\n  <input type=\"submit\" name=\"getPerfData\" id=\"getPerfData_id\" value=\"Get Data\"/><br/>\r\n  <input type=\"hidden\" name=\"orderBy\" value=\"TS_ERROR_OCCURRED\"/>\r\n</form>\r\n");

  //Query the perf table if requested.
  if (request.getParameter("getPerfData") != null && fromDate != null && toDate != null) {

    // Declare variables that will be used on the page
    Connection connection = null;
    PreparedStatement statement = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    // get the total number of rows
    boolean getTotal = request.getParameter("getTotal") != null;
    int idPerson = 0;
    //Get the page Size into an int
    int pageSize;
    try {
      String pageSizeString = request.getParameter("pageSize");
      pageSize = Integer.parseInt(pageSizeString);
      if (pageSize == 0) {
        // if the page size is zero, we should always get the count
        getTotal = true;
      }
    }
    catch (NumberFormatException e) {
      pageSize = 500;
    }

    //Get the ID Person into and int
    try {
      String sIdPerson = request.getParameter("idPerson");
      if (sIdPerson != null) {
        idPerson = Integer.parseInt(sIdPerson);
      }
    }
    catch (NumberFormatException e) {
      idPerson = 0;
    }

    int currentPage;
    try {
      String currentPageString = request.getParameter("currentPage");
      currentPage = Integer.parseInt(currentPageString);
    }
    catch (NumberFormatException e) {
      currentPage = 0;
    }

    // update the current page if next or previous was clicked
    if (request.getParameter("next") != null) {
      currentPage++;
    } else if (request.getParameter("previous") != null) {
      if (currentPage > 0) {
        currentPage--;
      }
    } else if (request.getParameter("execute") != null) {
      currentPage = 0;
    }

    try {
      connection = JdbcHelper.getConnection();

      //Get the data from the Performance Table.
      String sql = "select ID_ERROR, ID_PERSON, DT_LAST_UPDATE, TS_ERROR_OCCURRED, ID_EXCEPTION, "
                   + "ID_CSC_PROBLEM, SZ_IMPACT_VERSION, SZ_ERROR_REPORT_TYPE, dbms_lob.getlength( BL_ERROR ) \"Size\" "
                   + "from impact_errors "
                   + "where DT_LAST_UPDATE > TO_DATE( '" + fromDate + "','MM/DD/YYYY HH24:MI:SS' ) "
                   + "AND DT_LAST_UPDATE < TO_DATE( '" + toDate + "','MM/DD/YYYY HH24:MI:SS' )";
      if (idPerson != 0) {
        sql += "and ID_PERSON=" + idPerson;
      }
      String order = request.getParameter("orderBy") != null ? request.getParameter("orderBy") : "TS_ERROR_OCCURRED";
      sql += " ORDER BY \"" + order + "\" DESC";
      statement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

      rs = statement.executeQuery();
      rs.last();
      if (rs.getRow() == 0) {

      out.write("\r\n<table border=\"1\" cellpadding=\"3\" cellspacing=\"0\">\r\n  No Results Found\r\n</table>\r\n");

  } else {
    rs.beforeFirst();
  }

      out.write('\r');
      out.write('\n');

  ResultSetMetaData rsmd = rs.getMetaData();

  int numberOfColumns = rsmd.getColumnCount();
  int currentRow = currentPage * pageSize + 1;
  if (currentRow != 1) {
    rs.absolute(currentRow - 1);
  }

  for (int rowCount = 0; rs.next() && (pageSize == 0 || rowCount < pageSize); rowCount++) {
    if (rowCount % tableSize == 0) {
      if (rowCount != 0) {

      out.write("\r\n\r\n");

    // flush the buffer to send the last table that we wrote
    out.flush();
  }

      out.write("\r\n<table border=\"1\" cellpadding=\"3\" cellspacing=\"0\">\r\n  <tr>\r\n    ");

      for (int colIndex = 1; colIndex <= numberOfColumns; colIndex++) {
        //Print out each of the column labels.
    
      out.write("\r\n    <th class=\"thList\" style=\"white-space: nowrap;\"><a\r\n            href=\"javascript:setOrderBy('");
      out.print( rsmd.getColumnName( colIndex ) );
      out.write("')\">");
      out.print(rsmd.getColumnLabel(colIndex));
      out.write("\r\n    </a></th>\r\n    ");

      }
      // manually add a column to display a link to the blob
    
      out.write("\r\n    <th class=\"thList\" style=\"white-space: nowrap;\">Details</th>\r\n  </tr>\r\n  ");

    } //End Check on rowCount % tableSize == 0
  
      out.write("\r\n  <tr class='");
      out.print(rowCount % 2 == 0 ? "odd" : "even");
      out.write("'>\r\n    ");

      //Loop through each of the columns and display the data for the column
      for (int colIndex = 1; colIndex <= numberOfColumns; colIndex++) {
    
      out.write("\r\n    <td>");
      out.print(rs.getString(colIndex));
      out.write("\r\n    </td>\r\n    ");

      }
    
      out.write("\r\n    <td><a href='javascript:openDetails( ");
      out.print(rs.getString( "ID_ERROR" ));
      out.write(" );'>Open</a></td>\r\n  </tr>\r\n  ");

    }
  
      out.write("\r\n</table>\r\n");

  // flush the buffer to send the last table that we wrote
  out.flush();

  // Display the total using javascript if it was requested;
  //   this is done to allow flushing of the results before
  //   waiting for all the results.
  if (getTotal) {
    rs.last();
    int total = rs.getRow();
    String innerHTML;
    if (pageSize > 0) {
      innerHTML = "The query returned " + total + " rows; displaying records "
                  + (currentPage * pageSize + 1) + " to "
                  + (((currentPage + 1) * pageSize + 1) < total ? ((currentPage + 1) * pageSize + 1) : total)
                  + ".";
    } else {
      innerHTML = "The query returned " + total + " rows.";
    }

      out.write("\r\n<script type=\"text/javascript\" language=\"JavaScript\">\r\n  document.getElementById('total').innerHTML = \"");
      out.print(innerHTML);
      out.write("\";\r\n</script>\r\n");

  }
  // close the current result set
  rs.close();
}
catch (SQLException e) {

      out.write("\r\nSQL Error!<br>\r\n");
      out.print(e.getErrorCode());
      out.write("<br>\r\n");
      out.print(e.getMessage());
      out.write("<br>\r\n  <pre>\r\n");

  e.printStackTrace(new PrintWriter(out));

      out.write("\r\n  </pre>\r\n");

}
finally {
  try {
    if (rs != null) {
      rs.close();
    }
    if (statement != null) {
      statement.close();
    }
    if (stmt != null) {
      stmt.close();
    }
    if (connection != null && !connection.isClosed()) {
      connection.close();
    }
  }
  catch (SQLException e) {

      out.write("\r\nError closing connections.<br>\r\n");
      out.print(e.getErrorCode());
      out.write("<br>");
      out.print(e.getMessage());
      out.write("<br>\r\n");

      }
    }
  }

      out.write("\r\n<script type=\"text/javascript\" language=\"javascript\">\r\n  function openDetails(id)\r\n  {\r\n    var descriptor = \"\";\r\n    descriptor += \"width=800,\";\r\n    descriptor += \"height=600,\";\r\n    descriptor += \"channelmode=0,\";\r\n    descriptor += \"dependent=0,\";\r\n    descriptor += \"directories=0,\";\r\n    descriptor += \"fullscreen=0,\";\r\n    descriptor += \"location=0,\";\r\n    descriptor += \"menubar=0,\";\r\n    descriptor += \"resizable=1,\";\r\n    descriptor += \"scrollbars=1,\";\r\n    descriptor += \"status=0,\";\r\n    descriptor += \"toolbar=0\";\r\n    var newWindow = window.open('/grnds-docs/ErrorDetails.jsp?ID_ERROR=' + id, '_blank', descriptor);\r\n    newWindow.document.title.innerHTML = 'Error Details for ID_ERROR=' + id;\r\n  }\r\n</script>\r\n</body>\r\n</html>\r\n");
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
