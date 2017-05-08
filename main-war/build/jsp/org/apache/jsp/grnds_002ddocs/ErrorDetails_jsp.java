package org.apache.jsp.grnds_002ddocs;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class ErrorDetails_jsp extends org.apache.jasper.runtime.HttpJspBase
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
