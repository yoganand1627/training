package org.apache.jsp.grnds_002ddocs.document;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.web.document.DocumentPresentation;

public final class promptLegacy_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n\r\n");

  // Set character encoding before printing anything out; this MUST
  //   be done in order to properly display extended characters.
  response.setContentType( "text/html; charset=" + ArchitectureConstants.CHARACTER_ENCODING );
  String legacyDocument = (String) request.getAttribute(DocumentPresentation.CONTENT_REQUEST_NAME);
  String mimeType = (String) request.getAttribute(DocumentPresentation.MIMETYPE_REQUEST_NAME);

      out.write("\r\n\r\n<html>\r\n<head>\r\n  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=");
      out.print(ArchitectureConstants.CHARACTER_ENCODING);
      out.write("\">\r\n  <title>Approved Word Document</title>\r\n  <LINK href=\"/grnds-docs/css/impact.css\" rel=stylesheet>\r\n</head>\r\n<body>\r\n\r\n<div class=\"tableborderList\">\r\n<table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"3\" class=\"tableBorder\">\r\n <tr><th>Approved Word Document</th></tr>\r\n  <tr>\r\n   <td>\r\n      The document requested is an approved Word Document, and any modifications will not be saved.\r\n      Please click 'OK' to open the Word document.\r\n   </td>\r\n  </tr>\r\n</table>\r\n</div>\r\n<form action=\"/document/DocumentConversation/displayLegacyDocument\" method=\"post\">\r\n  <input type=\"hidden\" name=\"");
      out.print(DocumentPresentation.CONTENT_REQUEST_NAME);
      out.write("\" value=\"");
      out.print(legacyDocument);
      out.write("\">\r\n  <input type=\"hidden\" name=\"");
      out.print(DocumentPresentation.MIMETYPE_REQUEST_NAME);
      out.write("\" value=\"");
      out.print(mimeType);
      out.write("\">\r\n<table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"3\">\r\n  <tr>\r\n    <td align=\"right\">\r\n       <input type=\"image\" src=\"/grnds-docs/images/shared/btnOk.gif\" border=\"0\">\r\n    </td>\r\n  </tr>\r\n</table>\r\n</form>\r\n</body>\r\n</html>\r\n");
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
