package org.apache.jsp.grnds_002ddocs.document.utility;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.structs.document.Column;
import gov.georgia.dhr.dfcs.sacwis.structs.document.DocumentMetaData;
import gov.georgia.dhr.dfcs.sacwis.structs.document.Parameter;
import gov.georgia.dhr.dfcs.sacwis.structs.document.PreFillMetaData;
import gov.georgia.dhr.dfcs.sacwis.structs.document.TableFields;
import gov.georgia.dhr.dfcs.sacwis.web.document.DocumentLookup;
import org.exolab.castor.xml.Unmarshaller;
import java.io.StringReader;

public final class documentConverterStep2_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n\n\n\n\n\n\n\n\n");

  // Set character encoding before printing anything out; this MUST
  //   be done in order to properly display extended characters.
  response.setContentType( "text/html; charset=" + ArchitectureConstants.CHARACTER_ENCODING );

      out.write("\n<html>\n\n<head>\n  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=");
      out.print(ArchitectureConstants.CHARACTER_ENCODING);
      out.write("\">\n  <title>Document Maintenance Step 2</title>\n  <script>\n\n  function getCurrentDocument()\n  {\n      document.frmDocumentType.action=\"/document/DocumentUtilityConversation/showCurrentDocument\";\n  }\n\n  function getNewDocument()\n  {\n      document.frmDocumentType.action=\"/document/DocumentUtilityConversation/getNewDocument\";\n  }\n\n\n\n  function getCurrentBlankDocument()\n  {\n      document.frmDocumentType.action=\"/document/DocumentUtilityConversation/showCurrentBlankDocument\";\n  }\n\n  function getNewBlankDocument()\n  {\n      document.frmDocumentType.action=\"/document/DocumentUtilityConversation/getNewBlankDocument\";\n  }\n\n\n  </script>\n\n\n</head>\n<body>\n  <h1 style=\"font-size:1.0pc\">Document Conversion Step 2</h1>\n<table>\n    <tr>\n       <td>\n         Step 2:  Get the current and new documents\n       </td>\n\n    </tr>\n\n</table>\n\n\n\n<form action=\"/document/DocumentUtilityConversation/getNewDocument\" method=\"post\" name=\"frmDocumentType\" target=\"_blank\">\n");

  if (request.getParameter("cboDocumentType") != null)
  {
      String docType = request.getParameter("cboDocumentType");
      out.println("Document Type:" + docType + "<br>");
      out.println("<input type=\"hidden\" value=\"" + docType + "\" name=\"docType\">");
      String documentMetaDataString = DocumentLookup.lookup(docType);
      StringReader stringReader = new StringReader( documentMetaDataString );
      DocumentMetaData documentMetaData = null;
      try
      {
         // Unmarshall the Xml String into the DocumentMetaData object
         documentMetaData = (DocumentMetaData)Unmarshaller.unmarshal( DocumentMetaData.class, stringReader );
      }
      catch( Exception e )
      {
          out.println("Exception in unmarshalling metadata.");
      }


     out.println("<h2 style=\"font-size:.8pc\">PreFill Parameters</h2>");


     if (documentMetaData.getPreFillMetaData() != null)
     {
         PreFillMetaData preFillMetaData = documentMetaData.getPreFillMetaData();

         for (int i=0; i<preFillMetaData.getInputClass().getParameter().length; i++)
         {
             Parameter param = preFillMetaData.getInputClass().getParameter(i);
             out.println(param.getName() + ": <input type=\"text\" name=\"" + param.getRequestName() +
                     "\" size=\"30\" maxlength=\"20\"> <br>");

         }
     }



      out.println("<h2 style=\"font-size:.8pc\">Document Save IDs</h2>");
      TableFields tableFields = documentMetaData.getTableMetaData().getTableFields();

      for (int x=0; x<tableFields.getColumn().length; x++)
      {
         Column column = tableFields.getColumn(x);

         if (!"DT_LAST_UPDATE".equals(column.getName().toUpperCase()))
         {
           out.println(column.getName() + ": <input type=\"text\" name=\"" + column.getRequestName() +
                     "\" size=\"30\" maxlength=\"20\"> <br>");
         }
      }

      out.println("<input type=\"submit\" value=\"Get Current Document\" onClick=\"getCurrentDocument();\">");
      out.println("<input type=\"submit\" value=\"Get New Document\" onClick=\"getNewDocument();\">");
  }
  else if (request.getParameter("tableName") != null)
  {
    out.println("<input type=\"hidden\" name=\"tableName\" value=\"" + request.getParameter("tableName") + "\">");
    out.println("<input type=\"hidden\" name=\"sEvent\" value=\"" + request.getParameter("sEvent") + "\">");
    out.println("<input type=\"hidden\" name=\"docType\" value=\"" + request.getParameter("docType") + "\">");
    out.println("<input type=\"submit\" value=\"Get Current Document\" onClick=\"getCurrentBlankDocument();\">");
    out.println("<input type=\"submit\" value=\"Get New Document\" onClick=\"getNewBlankDocument();\">");


  }


      out.write("\n\n<input type=\"hidden\" name=\"docExists\" value=\"true\">\n\n\n</form>\n\n\n\n\n\n  <h1 style=\"font-size:1.0pc\">Document Conversion Step 3</h1>\n<table>\n    <tr>\n       <td>\n         Step 3:  Copy the current document contents into the new document.  Save the\n         new document.\n       </td>\n\n    </tr>\n\n</table>\n\n\n\n\n\n\n  <h1 style=\"font-size:1.0pc\">Document Conversion Step 4</h1>\n<table>\n    <tr>\n       <td>\n         Step 4:  Verify your changes.\n       </td>\n\n    </tr>\n\n</table>\n");

  String javaScriptFunction = null;

  if (request.getParameter("tableName") != null)
  {
    javaScriptFunction = "getCurrentBlankDocument();frmDocumentType.submit();";
  }
  else
  {
    javaScriptFunction = "getCurrentDocument();frmDocumentType.submit();";
  }





      out.write("\n<input type=\"submit\" onClick=\"");
      out.print(javaScriptFunction);
      out.write("\" value=\"Get Changed Document\">\n\n\n\n\n</body>\n</html>");
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
