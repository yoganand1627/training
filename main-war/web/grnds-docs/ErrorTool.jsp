<!--
Description: This is a tool for Administering the Error Logging framework.
Author: Brad Eilers
Date: 09/23/03
-->
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.ResultSetMetaData" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.jdbchelper.JdbcHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.exception.logging.ImpactExceptionLoggingUtility" %>
<%
  // This must be set before the response is started
  response.setContentType("text/html; charset=" + ArchitectureConstants.CHARACTER_ENCODING);
%>
<html>
<head>
  <title>Impact Error Logging Management Tool</title>
  <meta http-equiv="Content-Type" content="text/html; charset=<%=ArchitectureConstants.CHARACTER_ENCODING%>">
  <link href="/grnds-docs/css/impact.css" rel=stylesheet>
  <script type="text/javascript" language="JavaScript1.2">
    function setOrderBy(newOrder)
    {
      document.frmError.orderBy.value = newOrder;
      getPerfData_id.fireEvent("onclick");
      document.frmError.getErrorData.click();
    }
  </script>
</head>
<body>
<%!
  // Max size of the html tables generated
  public static final int tableSize = 50;
%>
<%
  if (request.getParameter("displayUsage") != null) {
%>
  <pre>
    Notes on Usage:
    Enable Global Performance Tracking -
      Either enable at startup by setting performance.trace to true in architecture.properties
      OR enable real-time by going to each JVM/server in the environment and clicking on 'Enable Perf Logging'
    Enable Performance Tracking for a given user -
      This is a two step process, which is necessary to make reduce processing needed for tracking performance.
      First, enable perf logging by session by going to each JVM/server in the environment
      and clicking on 'Enable Perf Logging By Session'.
      Second, Set the SEC_MNTN_REGION_14 security attribute for the given user and have that
      user log out and then back in to IMPACT.  To verify that the user has performance tracking enabled,
      have the user go to the PerfTool.jsp page at grnds-docs/PerfTool.jsp.
    Update the Batch Size - Perf records are written to the DB in batches to reduce
      performance impact on the system.  The batch size can be decreased to see results
      in the DB more quickly.  It could also be increased to further reduce performance
      impacts.  Note that anything that has been batched up but not written when the server
      either dies or is shut down is lost.
    Select a Date Range - The date range defaults to the current time to both give
      a starting point and to give an example of the format required for the date.
      When changing this, be sure to follow the example format.
    Select a specific user - Enter the numeric person id for the user.  Invalid user
      IDs will not return any records.
  </pre>
<%
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
%>
<br/>
<%
  if (request.getParameter("displayUsage") != null) {
%>
<a href="/grnds-docs/ErrorTool.jsp">UnDisplay Usage Notes</a><br/>
<%
} else {
%>
<a href="/grnds-docs/ErrorTool.jsp?displayUsage=true">Display Usage Notes</a><br/>
<%
  }
  String idPersonString = (request.getParameter("idPerson") != null) ? request.getParameter("idPerson") : "";
%>
Error Logging Enabled: <%= ImpactExceptionLoggingUtility.ERROR_LOGGING_ENABLED %><br/>

<form action="/grnds-docs/ErrorTool.jsp" method="post" name="frmError">
  <input type="submit" name="enableErrorLogging" value="Enable Error Logging"/><br/>
  <input type="submit" name="disableErrorLogging" value="Disable Error Logging"/><br/>
  Get Exception Data: <br/>
  From: <input type="text" maxlength="19" name="fromDate" value="<%= fromDate %>"/>
  To: <input type="text" maxlength="19" name="toDate" value="<%= toDate %>"/><br/>
  Person ID: <input type="text" maxlength="19" name="idPerson" value="<%=idPersonString %>"/><br/>
  <input type="submit" name="getPerfData" id="getPerfData_id" value="Get Data"/><br/>
  <input type="hidden" name="orderBy" value="TS_ERROR_OCCURRED"/>
</form>
<%
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
%>
<table border="1" cellpadding="3" cellspacing="0">
  No Results Found
</table>
<%
  } else {
    rs.beforeFirst();
  }
%>
<%
  ResultSetMetaData rsmd = rs.getMetaData();

  int numberOfColumns = rsmd.getColumnCount();
  int currentRow = currentPage * pageSize + 1;
  if (currentRow != 1) {
    rs.absolute(currentRow - 1);
  }

  for (int rowCount = 0; rs.next() && (pageSize == 0 || rowCount < pageSize); rowCount++) {
    if (rowCount % tableSize == 0) {
      if (rowCount != 0) {
%>

<%
    // flush the buffer to send the last table that we wrote
    out.flush();
  }
%>
<table border="1" cellpadding="3" cellspacing="0">
  <tr>
    <%
      for (int colIndex = 1; colIndex <= numberOfColumns; colIndex++) {
        //Print out each of the column labels.
    %>
    <th class="thList" style="white-space: nowrap;"><a
            href="javascript:setOrderBy('<%= rsmd.getColumnName( colIndex ) %>')"><%=rsmd.getColumnLabel(colIndex)%>
    </a></th>
    <%
      }
      // manually add a column to display a link to the blob
    %>
    <th class="thList" style="white-space: nowrap;">Details</th>
  </tr>
  <%
    } //End Check on rowCount % tableSize == 0
  %>
  <tr class='<%=rowCount % 2 == 0 ? "odd" : "even"%>'>
    <%
      //Loop through each of the columns and display the data for the column
      for (int colIndex = 1; colIndex <= numberOfColumns; colIndex++) {
    %>
    <td><%=rs.getString(colIndex)%>
    </td>
    <%
      }
    %>
    <td><a href='javascript:openDetails( <%=rs.getString( "ID_ERROR" )%> );'>Open</a></td>
  </tr>
  <%
    }
  %>
</table>
<%
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
%>
<script type="text/javascript" language="JavaScript">
  document.getElementById('total').innerHTML = "<%=innerHTML%>";
</script>
<%
  }
  // close the current result set
  rs.close();
}
catch (SQLException e) {
%>
SQL Error!<br>
<%=e.getErrorCode()%><br>
<%=e.getMessage()%><br>
  <pre>
<%
  e.printStackTrace(new PrintWriter(out));
%>
  </pre>
<%
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
%>
Error closing connections.<br>
<%=e.getErrorCode()%><br><%=e.getMessage()%><br>
<%
      }
    }
  }
%>
<script type="text/javascript" language="javascript">
  function openDetails(id)
  {
    var descriptor = "";
    descriptor += "width=800,";
    descriptor += "height=600,";
    descriptor += "channelmode=0,";
    descriptor += "dependent=0,";
    descriptor += "directories=0,";
    descriptor += "fullscreen=0,";
    descriptor += "location=0,";
    descriptor += "menubar=0,";
    descriptor += "resizable=1,";
    descriptor += "scrollbars=1,";
    descriptor += "status=0,";
    descriptor += "toolbar=0";
    var newWindow = window.open('/grnds-docs/ErrorDetails.jsp?ID_ERROR=' + id, '_blank', descriptor);
    newWindow.document.title.innerHTML = 'Error Details for ID_ERROR=' + id;
  }
</script>
</body>
</html>
