package org.apache.jsp.grnds_002ddocs.document.utility;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.StringReader;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.structs.document.DocumentMetaData;
import gov.georgia.dhr.dfcs.sacwis.web.document.DocumentLookup;
import org.exolab.castor.xml.Unmarshaller;

public final class documentConverterStart_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n\n\n\n\n\n\n\n");

  // Set character encoding before printing anything out; this MUST
  //   be done in order to properly display extended characters.
  response.setContentType("text/html; charset=" + ArchitectureConstants.CHARACTER_ENCODING);

      out.write("\n<html>\n\n<head>\n  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=");
      out.print(ArchitectureConstants.CHARACTER_ENCODING);
      out.write("\">\n  <title>Document Conversion Step 1</title>\n</head>\n<body style=\"font:size:.8pc\">\n\n\n<h1 style=\"font-size:1.0pc\">Document Conversion Step 1</h1>\n\n\n<table>\n  <tr>\n    <td>\n      Step 1: Choose the document type of the errored document.\n    </td>\n\n  </tr>\n\n</table>\n\n\n<form action=\"/document/DocumentUtilityConversation/documentConverterStep2\" method=\"post\" name=\"frmDocumentType\">\n  ");

    out.println("<select name=\"cboDocumentType\">");
    Map<String, String> documentsHashMap = DocumentLookup.getDocumentsMetaData();

    TreeMap<String, String> treemap = new TreeMap<String, String>(documentsHashMap);
    Iterator documentsIterator = treemap.keySet().iterator();

    while (documentsIterator.hasNext()) {
      String docType = (String) documentsIterator.next();
      String documentMetaDataString = DocumentLookup.lookup(docType);
      StringReader stringReader = new StringReader(documentMetaDataString);
      DocumentMetaData documentMetaData = null;
      try {
        // Unmarshall the Xml String into the DocumentMetaData object
        documentMetaData = (DocumentMetaData) Unmarshaller.unmarshal(DocumentMetaData.class, stringReader);
      }
      catch (Exception e) {
        out.println("Exception in unmarshalling metadata.");
      }

      if (documentMetaData.getTableMetaData() != null) {
        out.println(
                "<option value=\"" + docType + "\">" + docType + " (" + documentMetaData.getDocumentDisplayName() + ")" + "</option>");
      }
    }
    out.println("</select>");

  
      out.write("\n  <br>\n  <input type=\"submit\" value=\"Submit\">\n</form>\n\n<br>\n<br>\n<br>\nOr\n\n<br>\n<br>\n<br>\n\n\n<table>\n  <tr>\n    <td>\n      Step 1: To convert a word document using a blank template enter the following.\n    </td>\n  </tr>\n\n</table>\n\n<form name=\"frmBlankTemplateConversion\" action=\"/document/DocumentUtilityConversation/documentConverterStep2\"\n      method=\"post\">\n  <input type=\"radio\" name=\"docType\" value=\"CONVERT\" checked> Header/Body Template <br>\n  <input type=\"radio\" name=\"docType\" value=\"UTILITYHELPER\"> Body Template <br>\n  Table: <input type=\"text\" name=\"tableName\" size=\"30\" maxlength=\"30\"> <br>\n  Event: <input type=\"text\" name=\"sEvent\" size=\"30\" maxlength=\"30\"> <br>\n  <input type=\"submit\" value=\"Submit\">\n\n\n</form>\n</body>\n</html>");
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
