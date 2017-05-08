package org.apache.jsp.grnds_002ddocs;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Iterator;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.LookupData;
import gov.georgia.dhr.dfcs.sacwis.web.core.initialize.LookupInit;

public final class LookupDataTool_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


  // Max size of the html tables generated
  public static final int tableSize = 50;
  //Allow user to enter Category and list all entries for that category.

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

      out.write("<!--\nDescription: Tool for displaying code-decode values from the in memory\nhashmaps in used for codes table lookups.\nAuthor: Brad Eilers\nDate: 08/21/03\n-->\n\n\n\n\n\n");
      out.write('\n');

  //Get codes table object
  String codeCategory = request.getParameter("codeCategory");
  String onDemand = request.getParameter("onDemandRefresh");
  if (onDemand != null) {
    LookupInit.updateLookupData();
  }

      out.write("\n\n<html>\n<head>\n  <LINK href=\"/grnds-docs/css/impact.css\" rel=stylesheet>\n  <script type=\"text/javascript\" language=\"JavaScript1.2\" src=\"/grnds-docs/js/shared/prsValidation.js\"></script>\n  <script type=\"text/javascript\" src=\"/grnds-docs/js/shared/syncscroll.js\"></script>\n  <script type=\"text/javascript\" src=\"/grnds-docs/js/shared/impact.js\"></script>\n  <script type=\"text/javascript\" src=\"/grnds-docs/js/document/document.js\"></script>\n\n</head>\n<body>\n<b>Lookup Data Last Update: ");
      out.print( LookupData.getLastUpdate());
      out.write("\n</b> <br/>\n\n<form action=\"/grnds-docs/LookupDataTool.jsp\" method=\"post\">\n  <br/><b>On-Demand Refresh of Lookup Data (In Memory Codes Tables):</b><br/>\n  <input type=\"submit\" name=\"onDemandRefresh\" value=\"Start Refresh\"/><br/><br/>\n  <br/><b>Look up Current (In Memory) Values:</b><br/>\n  Codes Table Name:<input type=\"text\" maxlength=\"20\" name=\"codeCategory\"\n                          value=\"");
      out.print( ( request.getParameter( "codeCategory" ) != null ) ? request.getParameter( "codeCategory" ) : "" );
      out.write("\"/>\n  <input type=\"submit\" name=\"getCodeCategory\" value=\"Get Codes Table Data\"/><br/>\n</form>\n");

  //If the codeCategory is not null, display its contents
  if (codeCategory != null && !"".equals(codeCategory)) {
    //Loop through all of the codes table entries displaying code and decode
    Iterator i = Lookup.getCategoryListing(codeCategory.toUpperCase());
    out.println("Codes for " + codeCategory + ":<br/>");
    if (i.hasNext()) {
      out.println("<table border=1 cellpadding=3 cellspacing=0><th>Code</th><th>Decode</th>");
      int rowCount = 0;
      while (i.hasNext()) {
        rowCount++;
        CodeAttributes codeAttr = (CodeAttributes) i.next();

      out.write("\n<tr class='");
      out.print(rowCount % 2 == 0 ? "odd" : "even");
      out.write("'>\n  <td>");
      out.print(codeAttr.getCode() );
      out.write("\n  </td>\n  <td>");
      out.print(codeAttr.getDecode() );
      out.write("\n  </td>\n</tr>\n");

    }
    out.println("</table>");
  }
  //If there are any expired codes, display them
  i = Lookup.getExpiredCategoryCollection(codeCategory).iterator();
  if (i.hasNext()) {
    out.println("<br/>Expired Codes:<br/>");
    out.println("<table border=1 cellpadding=3 cellspacing=0><th>Code</th><th>Decode</th>");
    int rowCount = 0;
    while (i.hasNext()) {
      rowCount++;
      CodeAttributes codeAttr = (CodeAttributes) i.next();

      out.write("\n<tr class='");
      out.print(rowCount % 2 == 0 ? "odd" : "even");
      out.write("'>\n  <td>");
      out.print(codeAttr.getCode() );
      out.write("\n  </td>\n  <td>");
      out.print(codeAttr.getDecode() );
      out.write("\n  </td>\n</tr>\n");

      }
      out.println("</table>");
    }
  }


      out.write("\n<br/>\n\n</body>\n</html>\n");
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
