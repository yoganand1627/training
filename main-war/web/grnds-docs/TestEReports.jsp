<!--
Description: Page that tests for errored E-Reports
Author: Stephen Roberts
Date: 03/31/2004


************************************************************************
THIS IS A TOOL FOR SWI TO USE. PLEASE DO NOT MODIFY WITHOUT CONTACTING
STEPHEN ROBERTS OR RODRIG0 DEJUANA.

THIS IS A STANDALONE WEBPAGE THAT HITS THE REPORTING DATABASE.


************************************************************************


-->
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<html>

<head>
  <title>E-Report Error Page</title>
  <link href="/grnds-docs/css/impact.css" rel=stylesheet>
</head>

<%!
  public static final String MISSING_STAGEID_SQL =
          "SELECT ID_EREPORT, DT_SUBMIT, ID_PERSON, ID_STAGE FROM EREPORT_STATUS WHERE CD_STATUS='2' AND ID_STAGE IS NULL";
  public static final String ERROR_WITH_STAGEID_SQL =
          "SELECT ID_EREPORT, DT_SUBMIT, ID_PERSON, ID_STAGE FROM EREPORT_STATUS WHERE CD_STATUS='2' AND ID_STAGE IS NOT NULL";
  public static final String CHECK_CALL_NARRATIVE_SQL = "SELECT ID_STAGE FROM INCOMING_NARRATIVE WHERE ID_STAGE=?";
%>
<%
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

%>

<strong>E-Reports in Error State</strong><br><br>
The following e-reports have been assigned but generated a blank Intake. They can be processed by using
E-Report search.
<table border="0" cellpadding="3" cellspacing="0" width="100%" class="tableBorder">
  <tr>
    <th>E-Report Confirmation #</th>
    <th>Submit Date</th>
    <th>Person ID</th>
    <th>Call ID</th>
  </tr>
  <%
    while (rs.next()) {
  %>
  <tr>
    <td>
      <%=rs.getInt(1) %>
    </td>
    <td>
      <%=rs.getTimestamp(2).toString()%>
    </td>
    <td>
      <%=rs.getInt(3) %>
    </td>
    <td>
      <%=rs.getInt(4) %>
    </td>
  </tr>
  <%
      alert = true;
    }
  %>
</table>

<%
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

%>

Alert: <%=alert%>
