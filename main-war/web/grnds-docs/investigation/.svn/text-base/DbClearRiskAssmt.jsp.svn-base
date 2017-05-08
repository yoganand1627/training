<!--
Description: This is a Database Querying tool for IMPACT development.
Author: Brad Eilers
Date: 06/24/02
-->

<html>
<body>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.sql.Statement" %>

<%

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
%>
Could NOT connect to PRODCOPY<br>
<%=sqle.getErrorCode()%><br><%=sqle.getMessage()%><br>
<%

    return;
  }

// If we connect to the DB and do not have an exception,
// let the user know they are connected.

%>
Database Connection Successful<br>

<form name="frmClearRiskAssmt" action="DbClearRiskAssmt.jsp" method="post">
  <input type="hidden" name="action" value="clearRiskAssmt">
  <input type="submit" name="button" value="Reset Risk Assessment"/>
  <input type="hidden" name="database" value="<%=database%>"/>
</form>

<%

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


%><font color="green"><strong>Reset was successful.</strong></font><%

}
catch (SQLException sqle) {
%>
<br><%=sqle.getErrorCode()%><br><%=sqle.getMessage()%>
<%

    }
  }

%>
</body>
</html>
