<%
  // Note this page produces XML; to simplify this, all output is done through out.print()
  response.setContentType("text/xml; UTF-8");
  String idErrorString = request.getParameter("ID_ERROR");
  int idError;
  try {
    idError = Integer.parseInt(idErrorString);
  } catch (NumberFormatException e) {
    idError = -1;
  }

  if (idError >= 0) {
    java.sql.Connection connection = null;
    java.sql.PreparedStatement stmt = null;
    java.sql.ResultSet rs = null;
    java.io.ObjectInputStream ois = null;
    try {
      connection = gov.georgia.dhr.dfcs.sacwis.core.jdbchelper.JdbcHelper.getConnection();
      stmt = connection.prepareStatement("SELECT BL_ERROR FROM IMPACT_ERRORS WHERE ID_ERROR = ?");
      stmt.setInt(1, idError);
      rs = stmt.executeQuery();
      if (rs.next()) {
        ois = new java.io.ObjectInputStream(new java.util.zip.InflaterInputStream(rs.getBlob(1).getBinaryStream()));
        String xmlString = (String) ois.readObject();
        out.print(xmlString);
      } else {
        out.print("<error>No record found for ID_ERROR=" + idError + ".</error>");
      }
    } catch (Exception t) {
      out.print("<error>Failure retreiving record for ID_ERROR=" + idError + ".</error>");
    } finally {
      ois.close();
      try {
        if (rs != null) {
          rs.close();
        }
        if (stmt != null) {
          stmt.close();
        }
        if (connection != null && !connection.isClosed()) {
          connection.close();
        }
      }
      catch (Throwable t) {
        out.print("<error>Failure closing database connections.</error>");
      }
    }
  } else if (session != null) {
    gov.georgia.dhr.dfcs.sacwis.web.core.exception.logging.ImpactExceptionLogRecord record =
            (gov.georgia.dhr.dfcs.sacwis.web.core.exception.logging.ImpactExceptionLogRecord) session.getAttribute(
            gov.georgia.dhr.dfcs.sacwis.web.core.exception.handler.PrsExceptionHandler.BASE_PRS_EXCEPTION_LOG_RECORD_KEY);
    if (record != null) {
      try {
        gov.georgia.dhr.dfcs.sacwis.web.core.exception.logging.ImpactExceptionFormatter impactExceptionFormatter =
                new gov.georgia.dhr.dfcs.sacwis.web.core.exception.logging.ImpactExceptionFormatter();
        String xml = impactExceptionFormatter.format(record);
        out.print(xml);
      }
      catch (Throwable t) {
        out.print("<error>Error creating XML representation of ImpactExceptionLogRecord.</error>");
      }
    }
  } else {
    out.print("<error>No ID_ERROR specified.</error>");
  }
%>
