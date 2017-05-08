<!--
Description: This is a Database Querying tool for IMPACT development.
Author: Brad Eilers
Date: 06/24/02

Revised by MKW on 7/6/2003
-->
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DatabaseMetaData" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.ResultSetMetaData" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.sql.Types" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Properties" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.URLHelper" %>

<%-- static information --%>
<%!
  // Max size of the html tables generated
  public static final int tableSize = 50;

  // Constants for the properties that are passed into the driver
  public static final String USER = "user";
  public static final String PASSWORD = "password";
  public static final String URL = "url";

  // Names of the dbs
  public static final String GASACWDM = "gasacwdm";
  public static final String GASACWL = "gasacwl";
  public static final String SAC_DEV = "sac_dev";
  public static final String SAC_INT = "sac_int";
  public static final String SAC_SYS = "sac_sys";
  private static final Map DB_TO_PROPERTIES_MAP = new HashMap();

  {
    Properties sac_dev = new Properties();
    sac_dev.put(URL, "jdbc:oracle:thin:@167.193.157.252:1525:sac_dev");
    sac_dev.put(USER, "capson");
    sac_dev.put(PASSWORD, "impact");
    DB_TO_PROPERTIES_MAP.put(SAC_DEV, sac_dev);

    Properties sac_int = new Properties();
    sac_int.put(URL, "jdbc:oracle:thin:@167.193.157.252:1525:sac_int");
    sac_int.put(USER, "capson");
    sac_int.put(PASSWORD, "impact");
    DB_TO_PROPERTIES_MAP.put(SAC_INT, sac_int);

    Properties sac_sys = new Properties();
    sac_sys.put(URL, "jdbc:oracle:thin:@167.193.157.252:1525:sac_sys");
    sac_sys.put(USER, "capson");
    sac_sys.put(PASSWORD, "impact");
    DB_TO_PROPERTIES_MAP.put(SAC_SYS, sac_sys);

    Properties gasacwdm = new Properties();
    gasacwdm.put(URL, "jdbc:oracle:thin:@localhost:1525:gasacwdm");
    gasacwdm.put(USER, "capson");
    gasacwdm.put(PASSWORD, "impact");
    DB_TO_PROPERTIES_MAP.put(GASACWDM, gasacwdm);

    Properties gasacwl = new Properties();
    gasacwl.put(URL, "jdbc:oracle:thin:@localhost:1525:gasacwl");
    gasacwl.put(USER, "capson");
    gasacwl.put(PASSWORD, "impact");
    DB_TO_PROPERTIES_MAP.put(GASACWL, gasacwl);
  }
%>
<%
  // This must be set before the response is started
  response.setContentType("text/html; charset=" + ArchitectureConstants.CHARACTER_ENCODING);
%>
<html>
<head>
  <title>Impact Database Query Tool</title>
  <meta http-equiv="Content-Type" content="text/html; charset=<%=ArchitectureConstants.CHARACTER_ENCODING%>">
  <link href="/grnds-docs/css/impact.css" rel=stylesheet>
</head>
<body>

<%
  // get the url used
  String database = request.getParameter("database");
  database = database == null ? SAC_DEV : database;

  // get the table or view name for table detail display
  String tableDetailName = request.getParameter("viewTableDetail");

  // Get the current query
  String sql = request.getParameter("runSQL");
  if (sql != null) {
    // trim the query to get rid of extra whitespace so we can find the semicolon, if necessary
    sql = sql.trim();
    // store the length of the query
    int sqlLength = sql.length();
    // chop off a trailing semicolon if it exists
    if (sqlLength > 0 && sql.charAt(sqlLength - 1) == ';') {
      sqlLength--;
      sql = sql.substring(0, sqlLength);
    }
  }

  // get the total number of rows
  boolean getTotal = request.getParameter("getTotal") != null;

  int pageSize = 0;
  try {
    String pageSizeString = null;
    pageSizeString = request.getParameter("pageSize");
    pageSize = Integer.parseInt(pageSizeString);
    if (pageSize == 0) {
      // if the page size is zero, we should always get the count
      getTotal = true;
    }
  }
  catch (NumberFormatException e) {
    pageSize = 500;
  }

  int currentPage = 0;
  try {
    String currentPageString = null;
    currentPageString = request.getParameter("currentPage");
    currentPage = Integer.parseInt(currentPageString);
  }
  catch (NumberFormatException e) {
    currentPage = 0;
  }

  // variable to know whether or not to execute the sql statement;
  //   used to prevent execution when switching databases
  boolean execute = true;

  // update the current page if next or previous was clicked
  if (request.getParameter("next") != null) {
    currentPage++;
  } else if (request.getParameter("previous") != null) {
    if (currentPage > 0) {
      currentPage--;
    }
  } else if (request.getParameter("execute") != null) {
    currentPage = 0;

  } else {
    // None of the buttons used to execute the sql was clicked;
    //   so, so not execute the sql.
    execute = false;
  }
%>
<form name="selectDatabase" action="DbTool.jsp" method="post">
  Select a database:&nbsp;
  <select name="database">
    <option value="<%=SAC_DEV%>">DEV on 167.193.157.252</option>
    <option value="<%=SAC_INT%>">INT on 167.193.157.252</option>
    <option value="<%=SAC_SYS%>">SYS on 167.193.157.252</option>
    <option value="<%=GASACWDM%>">GASACWDM on localhost</option>
    <option value="<%=GASACWL%>">GASACWL on localhost</option>
  </select>&nbsp;
  <input type="submit" value="Change Database"/>
  <br>
  User Name (e.g. eilersbe):<input type="text" name="userName"/>&nbsp;
  User ID (e.g. 2271):<input type="text" name="userID"/>&nbsp;
  <input type="submit" name="updateLogon" value="Update Logon"/>
  <br>
  <a href="DbTool.jsp?database=<%=database%>&viewTables=true">Tables</a>&nbsp;
  <a href="DbTool.jsp?database=<%=database%>&viewViews=true">Views</a><br>
  <input type="hidden" name="runSQL" value='<%=sql != null ? sql : ""%>'/>
  <%
    if (getTotal) {
  %>
  <input type="hidden" name="getTotal" value="true"/>
  <%
    }
  %>
  <input type="hidden" name="pageSize" value="<%=pageSize%>"/>
</form>
<script type="text/javascript" language="JavaScript">
  document.selectDatabase.database.value = "<%=database%>";
</script>
<form action="DbTool.jsp" method="post">
  <textarea name="runSQL" rows="10" cols="120"><%=sql != null ? sql : ""%>
  </textarea>

  <div>
    Page Size (0 for all results):&nbsp;<input name="pageSize" type="text" value="<%=pageSize%>"/><br>
    Get total count (may increase response time dramatically):
    &nbsp;<input name="getTotal" type="checkbox" <%=getTotal ? "checked" : ""%>/><br>
  </div>
  <input type="submit" value="Execute SQL" name="execute"/>
  &nbsp;<input type="submit" value="Next Page" name="next"/>
  &nbsp;<input type="submit" value="Previous Page" name="previous"/>
  <input type="hidden" name="database" value="<%=database%>"/>
  <input type="hidden" name="currentPage" value="<%=currentPage%>"/>
</form>
<%
  // Declare variables that will be used on the page
  Connection connection = null;
  PreparedStatement testStatement = null;
  PreparedStatement stmt = null;
  ResultSet rs = null;

  // The driver that we will be using
  String driverClassName = "oracle.jdbc.OracleDriver";

  try {
    // Register the driver used for connections on this page
    Class.forName(driverClassName);

    // Create a connection and test it to see if we can actually connect to it
    Properties dbProps = (Properties) DB_TO_PROPERTIES_MAP.get(database);
    dbProps = dbProps == null ? (Properties) DB_TO_PROPERTIES_MAP.get(SAC_DEV) : dbProps;
    connection = DriverManager.getConnection((String) dbProps.get(URL), dbProps);

    // Test the connection
    testStatement = connection.prepareStatement("select * from dual");
    testStatement.executeQuery();

    //If we connect to the DB and do not have an exception, let the user know they are connected.
%>
<div>Database Connection Successful</div>
<%

  //View Tables
  if (request.getParameter("viewTables") != null) {
%>
<table border="1" cellpadding="3" cellspacing="0">
  <tr>
    <td>Tables</td>
    <td>Data</td>
  </tr>
  <%
    DatabaseMetaData dbmd = connection.getMetaData();
    rs = dbmd.getTables(null, null, "%", new String[] {"TABLE"});
    while (rs.next()) {
      String tableName = rs.getString("TABLE_NAME");
  %>
  <tr>
    <td>
      <a href="DbTool.jsp?database=<%=database%>&viewTableDetail=<%=tableName%>"><%=tableName%>
      </a>
    </td>
    <td>
      <a href="DbTool.jsp?database=<%=database%>&execute=true&runSQL=<%=URLHelper.encode("select * from " + tableName)%>">Select
        * from <%=tableName%>
      </a>
    </td>
  </tr>
  <%
    }
  %>
</table>
<%
}
//View Views
else if (request.getParameter("viewViews") != null) {
%>
<table border="1" cellpadding="3" cellspacing="0">
  <tr>
    <td>Tables</td>
    <td>Data</td>
  </tr>
  <%
    DatabaseMetaData dbmd = connection.getMetaData();
    rs = dbmd.getTables(null, null, "%", new String[] {"VIEW"});
    while (rs.next()) {
      String tableName = rs.getString("TABLE_NAME");
  %>
  <tr>
    <td>
      <a href="DbTool.jsp?database=<%=database%>&viewTableDetail=<%=tableName%>"><%=tableName%>
      </a>
    </td>
    <td>
      <a href="DbTool.jsp?database=<%=database%>&execute=true&runSQL=<%=URLHelper.encode("select * from " + tableName)%>">Select
        * from <%=tableName%>
      </a>
    </td>
  </tr>
  <%
    }
  %>
</table>
<%
} else if (tableDetailName != null) {
  //View Table Detail
%>
<table border="1" cellpadding="3" cellspacing="0">
  <tr>
    <td>Table Name</td>
    <td>Column Name</td>
    <td>Data Type</td>
    <td>Data Length</td>
    <td>Null?</td>
  </tr>
  <%
    DatabaseMetaData dbmd = connection.getMetaData();
    rs = dbmd.getColumns(null, null, tableDetailName, null);
    while (rs.next()) {
      String colTableName = rs.getString("TABLE_NAME");
      String colName = rs.getString("COLUMN_NAME");
      int colTypeInt = rs.getInt("DATA_TYPE");
      String colType = getTypeString(colTypeInt);
      int colSize = rs.getInt("COLUMN_SIZE");
      int colNullInt = rs.getInt("NULLABLE");
      String colNull = colNullInt == 0 ? "False" : "True";
  %>
  <tr>
    <td><%=colTableName%>
    </td>
    <td><%=colName%>
    </td>
    <td><%=colType%>
    </td>
    <td><%=colSize%>
    </td>
    <td><%=colNull%>
    </td>
  </tr>
  <%
    }
  %>
</table>
<%
} else if (execute && sql != null) {
  stmt = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

  boolean hasMoreResults = stmt.execute();
  int updateCount = stmt.getUpdateCount();

  while (hasMoreResults || updateCount != -1) {
    if (updateCount != -1) {
      // The query was not a select; do not try to display the results
%>
<div>
  <%=updateCount%> records affected.
</div>
<%
} else {
  //View SQL Query Results
  if (getTotal) {
    // put a div here that we can update in javascript below
%>
<div id="total"></div>
<%
} else if (pageSize > 0) {
%>
<div>Displaying up to <%=pageSize%> records starting at record <%=(pageSize * currentPage) + 1%>.</div>
<%
  }

  rs = stmt.getResultSet();

  // make the fetch size the same as the page size if the pageSize is > 0
  rs.setFetchSize(pageSize > 0 ? pageSize : 2000);

  ResultSetMetaData rsmd = rs.getMetaData();

  int numberOfColumns = rsmd.getColumnCount();

  int currentRow = currentPage * pageSize + 1;
  if (currentRow != 1) {
    rs.absolute(currentRow - 1);
  }

  for (int rowCount = 0; rs.next() && (pageSize == 0 || rowCount < pageSize); rowCount++) {
    if (rowCount % tableSize == 0) {
      if (rowCount != 0) {
        // flush the buffer to send the last table that we wrote
        out.flush();
      }
%>
<table border="1" cellpadding="3" cellspacing="0">
  <tr>
    <%
      for (int colIndex = 1; colIndex <= numberOfColumns; colIndex++) {
    %>
    <th class="thList" style="white-space: nowrap;"><%=rsmd.getColumnLabel(colIndex)%>
    </th>
    <%
      }
    %>
  </tr>
  <%
    }
  %>
  <tr class='<%=rowCount % 2 == 0 ? "odd" : "even"%>'>
    <%
      for (int colIndex = 1; colIndex <= numberOfColumns; colIndex++) {
    %>
    <td><%=rs.getString(colIndex)%>
    </td>
    <%
      }
    %>
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
    String innerHTML = null;
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

      hasMoreResults = stmt.getMoreResults();
      updateCount = stmt.getUpdateCount();
    }
  }
  //Update the specified person id on the employee table with the specified logon id
  else if (request.getParameter("updateLogon") != null) {
    PreparedStatement stmt1 = null;
    PreparedStatement stmt2 = null;
    String username = request.getParameter("userName");
    String sUserId = request.getParameter("userID");
    if (username == null || sUserId == null) {
      throw new Exception("User Name and User ID cannot be null!");
    }
    int userid = Integer.parseInt(sUserId);
    try {
      stmt1 = connection.prepareStatement(
              "update employee set ID_EMPLOYEE_LOGON = NULL where ID_EMPLOYEE_LOGON = UPPER( ? )");
      stmt1.setString(1, username);
      stmt1.executeUpdate();
      stmt2 = connection.prepareStatement("update employee set ID_EMPLOYEE_LOGON = UPPER( ? ) where ID_PERSON = ?");
      stmt2.setString(1, username);
      stmt2.setInt(2, userid);
      stmt2.executeUpdate();
      if (!connection.getAutoCommit()) {
        connection.commit();
      }
      out.println("Successfully updated User ID:" + userid + "with UserName: " + username.toUpperCase());
    }
    catch (SQLException e) {
      out.println("Failure claiming UserID '" + String.valueOf(
              userid) + "' for user '" + username + "':" + e.getMessage());
    }
    finally {
      if (stmt1 != null) {
        try {
          stmt1.close();
        }
        catch (SQLException e) {

          out.println("Failure claiming UserID '" + String.valueOf(
                  userid) + "' for user '" + username + "':" + e.getMessage());
        }
      }
      if (stmt2 != null) {
        try {
          stmt1.close();
        }
        catch (SQLException e) {
          out.println("Failure claiming UserID '" + String.valueOf(
                  userid) + "' for user '" + username + "':" + e.getMessage());
        }
      }
      if (connection != null && !connection.isClosed()) {
        try {
          connection.close();
        }
        catch (SQLException e) {
          out.println("Failure claiming UserID '" + String.valueOf(
                  userid) + "' for user '" + username + "':" + e.getMessage());
        }
      }
    }

  }

}
catch (ClassNotFoundException e) {
  // This happens if the driver isn't found
%>
Driver not found; please ensure that <tt><%=driverClassName%>
</tt> is found in the path for this web application.
<%
}
catch (SQLException e) {
  // Catch any sql exceptions on the page.
%>
SQL Error!<br>
<%=e.getErrorCode()%><br>
<%=e.getMessage()%><br>
<pre>
<%
  // print the stack trace for debugging purposes
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
    if (testStatement != null) {
      testStatement.close();
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
%>
</body>
</html>
<%!
  private static String getTypeString(int colTypeInt) {
    String colType = null;
    switch (colTypeInt) {
      case Types.ARRAY:
        colType = "Array";
        break;
      case Types.BIGINT:
        colType = "Bigint";
        break;
      case Types.BINARY:
        colType = "Binary";
        break;
      case Types.BIT:
        colType = "Bit";
        break;
      case Types.BLOB:
        colType = "BLOB";
        break;
      case Types.BOOLEAN:
        colType = "Boolean";
        break;
      case Types.CHAR:
        colType = "Char";
        break;
      case Types.CLOB:
        colType = "CLOB";
        break;
      case Types.DATALINK:
        colType = "Datalink";
        break;
      case Types.DATE:
        colType = "Date";
        break;
      case Types.DECIMAL:
        colType = "Decimal";
        break;
      case Types.DISTINCT:
        colType = "Distinct";
        break;
      case Types.DOUBLE:
        colType = "Double";
        break;
      case Types.FLOAT:
        colType = "Float";
        break;
      case Types.INTEGER:
        colType = "Integer";
        break;
      case Types.JAVA_OBJECT:
        colType = "Java Object";
        break;
      case Types.LONGVARBINARY:
        colType = "Longvarbinary";
        break;
      case Types.LONGVARCHAR:
        colType = "Longvarchar";
        break;
      case Types.NULL:
        colType = "Null";
        break;
      case Types.NUMERIC:
        colType = "Numeric";
        break;
      case Types.OTHER:
        colType = "Other";
        break;
      case Types.REAL:
        colType = "Real";
        break;
      case Types.REF:
        colType = "Ref";
        break;
      case Types.SMALLINT:
        colType = "Smallint";
        break;
      case Types.STRUCT:
        colType = "Struct";
        break;
      case Types.TIME:
        colType = "Time";
        break;
      case Types.TIMESTAMP:
        colType = "Timestamp";
        break;
      case Types.TINYINT:
        colType = "Tinyint";
        break;
      case Types.VARBINARY:
        colType = "Varbinary";
        break;
      case Types.VARCHAR:
        colType = "Varchar";
        break;
      default:
        colType = "Unknown";
        break;
    }
    return colType;
  }
%>
