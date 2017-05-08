package org.apache.jsp.grnds_002ddocs;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.utility.URLHelper;

public final class DbTool_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


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

      out.write("<!--\nDescription: This is a Database Querying tool for IMPACT development.\nAuthor: Brad Eilers\nDate: 06/24/02\n\nRevised by MKW on 7/6/2003\n-->\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
      out.write('\n');
      out.write('\n');

  // This must be set before the response is started
  response.setContentType("text/html; charset=" + ArchitectureConstants.CHARACTER_ENCODING);

      out.write("\n<html>\n<head>\n  <title>Impact Database Query Tool</title>\n  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=");
      out.print(ArchitectureConstants.CHARACTER_ENCODING);
      out.write("\">\n  <link href=\"/grnds-docs/css/impact.css\" rel=stylesheet>\n</head>\n<body>\n\n");

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

      out.write("\n<form name=\"selectDatabase\" action=\"DbTool.jsp\" method=\"post\">\n  Select a database:&nbsp;\n  <select name=\"database\">\n    <option value=\"");
      out.print(SAC_DEV);
      out.write("\">DEV on 167.193.157.252</option>\n    <option value=\"");
      out.print(SAC_INT);
      out.write("\">INT on 167.193.157.252</option>\n    <option value=\"");
      out.print(SAC_SYS);
      out.write("\">SYS on 167.193.157.252</option>\n    <option value=\"");
      out.print(GASACWDM);
      out.write("\">GASACWDM on localhost</option>\n    <option value=\"");
      out.print(GASACWL);
      out.write("\">GASACWL on localhost</option>\n  </select>&nbsp;\n  <input type=\"submit\" value=\"Change Database\"/>\n  <br>\n  User Name (e.g. eilersbe):<input type=\"text\" name=\"userName\"/>&nbsp;\n  User ID (e.g. 2271):<input type=\"text\" name=\"userID\"/>&nbsp;\n  <input type=\"submit\" name=\"updateLogon\" value=\"Update Logon\"/>\n  <br>\n  <a href=\"DbTool.jsp?database=");
      out.print(database);
      out.write("&viewTables=true\">Tables</a>&nbsp;\n  <a href=\"DbTool.jsp?database=");
      out.print(database);
      out.write("&viewViews=true\">Views</a><br>\n  <input type=\"hidden\" name=\"runSQL\" value='");
      out.print(sql != null ? sql : "");
      out.write("'/>\n  ");

    if (getTotal) {
  
      out.write("\n  <input type=\"hidden\" name=\"getTotal\" value=\"true\"/>\n  ");

    }
  
      out.write("\n  <input type=\"hidden\" name=\"pageSize\" value=\"");
      out.print(pageSize);
      out.write("\"/>\n</form>\n<script type=\"text/javascript\" language=\"JavaScript\">\n  document.selectDatabase.database.value = \"");
      out.print(database);
      out.write("\";\n</script>\n<form action=\"DbTool.jsp\" method=\"post\">\n  <textarea name=\"runSQL\" rows=\"10\" cols=\"120\">");
      out.print(sql != null ? sql : "");
      out.write("\n  </textarea>\n\n  <div>\n    Page Size (0 for all results):&nbsp;<input name=\"pageSize\" type=\"text\" value=\"");
      out.print(pageSize);
      out.write("\"/><br>\n    Get total count (may increase response time dramatically):\n    &nbsp;<input name=\"getTotal\" type=\"checkbox\" ");
      out.print(getTotal ? "checked" : "");
      out.write("/><br>\n  </div>\n  <input type=\"submit\" value=\"Execute SQL\" name=\"execute\"/>\n  &nbsp;<input type=\"submit\" value=\"Next Page\" name=\"next\"/>\n  &nbsp;<input type=\"submit\" value=\"Previous Page\" name=\"previous\"/>\n  <input type=\"hidden\" name=\"database\" value=\"");
      out.print(database);
      out.write("\"/>\n  <input type=\"hidden\" name=\"currentPage\" value=\"");
      out.print(currentPage);
      out.write("\"/>\n</form>\n");

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

      out.write("\n<div>Database Connection Successful</div>\n");


  //View Tables
  if (request.getParameter("viewTables") != null) {

      out.write("\n<table border=\"1\" cellpadding=\"3\" cellspacing=\"0\">\n  <tr>\n    <td>Tables</td>\n    <td>Data</td>\n  </tr>\n  ");

    DatabaseMetaData dbmd = connection.getMetaData();
    rs = dbmd.getTables(null, null, "%", new String[] {"TABLE"});
    while (rs.next()) {
      String tableName = rs.getString("TABLE_NAME");
  
      out.write("\n  <tr>\n    <td>\n      <a href=\"DbTool.jsp?database=");
      out.print(database);
      out.write("&viewTableDetail=");
      out.print(tableName);
      out.write('"');
      out.write('>');
      out.print(tableName);
      out.write("\n      </a>\n    </td>\n    <td>\n      <a href=\"DbTool.jsp?database=");
      out.print(database);
      out.write("&execute=true&runSQL=");
      out.print(URLHelper.encode("select * from " + tableName));
      out.write("\">Select\n        * from ");
      out.print(tableName);
      out.write("\n      </a>\n    </td>\n  </tr>\n  ");

    }
  
      out.write("\n</table>\n");

}
//View Views
else if (request.getParameter("viewViews") != null) {

      out.write("\n<table border=\"1\" cellpadding=\"3\" cellspacing=\"0\">\n  <tr>\n    <td>Tables</td>\n    <td>Data</td>\n  </tr>\n  ");

    DatabaseMetaData dbmd = connection.getMetaData();
    rs = dbmd.getTables(null, null, "%", new String[] {"VIEW"});
    while (rs.next()) {
      String tableName = rs.getString("TABLE_NAME");
  
      out.write("\n  <tr>\n    <td>\n      <a href=\"DbTool.jsp?database=");
      out.print(database);
      out.write("&viewTableDetail=");
      out.print(tableName);
      out.write('"');
      out.write('>');
      out.print(tableName);
      out.write("\n      </a>\n    </td>\n    <td>\n      <a href=\"DbTool.jsp?database=");
      out.print(database);
      out.write("&execute=true&runSQL=");
      out.print(URLHelper.encode("select * from " + tableName));
      out.write("\">Select\n        * from ");
      out.print(tableName);
      out.write("\n      </a>\n    </td>\n  </tr>\n  ");

    }
  
      out.write("\n</table>\n");

} else if (tableDetailName != null) {
  //View Table Detail

      out.write("\n<table border=\"1\" cellpadding=\"3\" cellspacing=\"0\">\n  <tr>\n    <td>Table Name</td>\n    <td>Column Name</td>\n    <td>Data Type</td>\n    <td>Data Length</td>\n    <td>Null?</td>\n  </tr>\n  ");

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
  
      out.write("\n  <tr>\n    <td>");
      out.print(colTableName);
      out.write("\n    </td>\n    <td>");
      out.print(colName);
      out.write("\n    </td>\n    <td>");
      out.print(colType);
      out.write("\n    </td>\n    <td>");
      out.print(colSize);
      out.write("\n    </td>\n    <td>");
      out.print(colNull);
      out.write("\n    </td>\n  </tr>\n  ");

    }
  
      out.write("\n</table>\n");

} else if (execute && sql != null) {
  stmt = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

  boolean hasMoreResults = stmt.execute();
  int updateCount = stmt.getUpdateCount();

  while (hasMoreResults || updateCount != -1) {
    if (updateCount != -1) {
      // The query was not a select; do not try to display the results

      out.write("\n<div>\n  ");
      out.print(updateCount);
      out.write(" records affected.\n</div>\n");

} else {
  //View SQL Query Results
  if (getTotal) {
    // put a div here that we can update in javascript below

      out.write("\n<div id=\"total\"></div>\n");

} else if (pageSize > 0) {

      out.write("\n<div>Displaying up to ");
      out.print(pageSize);
      out.write(" records starting at record ");
      out.print((pageSize * currentPage) + 1);
      out.write(".</div>\n");

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

      out.write("\n<table border=\"1\" cellpadding=\"3\" cellspacing=\"0\">\n  <tr>\n    ");

      for (int colIndex = 1; colIndex <= numberOfColumns; colIndex++) {
    
      out.write("\n    <th class=\"thList\" style=\"white-space: nowrap;\">");
      out.print(rsmd.getColumnLabel(colIndex));
      out.write("\n    </th>\n    ");

      }
    
      out.write("\n  </tr>\n  ");

    }
  
      out.write("\n  <tr class='");
      out.print(rowCount % 2 == 0 ? "odd" : "even");
      out.write("'>\n    ");

      for (int colIndex = 1; colIndex <= numberOfColumns; colIndex++) {
    
      out.write("\n    <td>");
      out.print(rs.getString(colIndex));
      out.write("\n    </td>\n    ");

      }
    
      out.write("\n  </tr>\n  ");

    }
  
      out.write("\n</table>\n");

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

      out.write("\n<script type=\"text/javascript\" language=\"JavaScript\">\n  document.getElementById('total').innerHTML = \"");
      out.print(innerHTML);
      out.write("\";\n</script>\n");

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

      out.write("\nDriver not found; please ensure that <tt>");
      out.print(driverClassName);
      out.write("\n</tt> is found in the path for this web application.\n");

}
catch (SQLException e) {
  // Catch any sql exceptions on the page.

      out.write("\nSQL Error!<br>\n");
      out.print(e.getErrorCode());
      out.write("<br>\n");
      out.print(e.getMessage());
      out.write("<br>\n<pre>\n");

  // print the stack trace for debugging purposes
  e.printStackTrace(new PrintWriter(out));

      out.write("\n</pre>\n");


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

      out.write("\nError closing connections.<br>\n");
      out.print(e.getErrorCode());
      out.write("<br>");
      out.print(e.getMessage());
      out.write("<br>\n");

    }
  }

      out.write("\n</body>\n</html>\n");
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
