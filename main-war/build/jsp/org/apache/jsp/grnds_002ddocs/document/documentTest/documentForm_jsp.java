package org.apache.jsp.grnds_002ddocs.document.documentTest;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.structs.document.Column;
import gov.georgia.dhr.dfcs.sacwis.structs.document.DocumentMetaData;
import gov.georgia.dhr.dfcs.sacwis.structs.document.Parameter;

public final class documentForm_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n\r\n\r\n\r\n");

  // Set character encoding before printing anything out; this MUST
  //   be done in order to properly display extended characters.
  response.setContentType( "text/html; charset=" + ArchitectureConstants.CHARACTER_ENCODING );

      out.write("\r\n<html>\r\n<head>\r\n<title>Document Input Form</title>\r\n  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=");
      out.print(ArchitectureConstants.CHARACTER_ENCODING);
      out.write("\">\r\n  <LINK href=\"/grnds-docs/css/impact.css\" rel=stylesheet>\r\n  <script src=\"/grnds-docs/js/document/document.js\"></script>\r\n</head>\r\n\r\n<style>\r\n\r\nbody td {\r\n  font-family : Verdana, Geneva, Arial, Helvetica, sans-serif;\r\n  font-size : .8pc;\r\n}\r\n\r\n\r\nh1{\r\n  font-family : Verdana, Geneva, Arial, Helvetica, sans-serif;\r\n  font-size : 1.2pc;\r\n}\r\nh2{\r\n  font-family : Verdana, Geneva, Arial, Helvetica, sans-serif;\r\n  font-size : 1pc;\r\n}\r\n\r\n</style>\r\n\r\n\r\n<script>\r\n\r\nfunction submitDocument()\r\n{\r\n   frmInput.action=\"/document/DocumentConversation/showDocument\";\r\n   var newWindow = openDocumentConversationWindow();\r\n   frmInput.target = newWindow;\r\n   return true;\r\n\r\n}\r\n\r\nfunction deleteDocument()\r\n{\r\n   frmInput.action='/document/DocumentTestConversation/deleteDocument';\r\n   frmInput.target = \"\";\r\n   return true;\r\n}\r\n\r\n\r\n\r\n\r\n\r\n</script>\r\n\r\n\r\n<body>\r\n<a href=\"/document/DocumentTestConversation/documentList\">Back to Document List</a>\r\n\r\n<h1>Document Input Form</h1>\r\n\r\n\r\n\r\n<font color=\"red\">\r\n");

DocumentMetaData documentMetaData = null;
if (request.getAttribute("documentMetaData") != null)
{
   documentMetaData = (DocumentMetaData) request.getAttribute("documentMetaData");
}
else
{
   out.println("Lookup for the document type failed.");
}


if (request.getAttribute("message")!= null)
{
  String message =(String) request.getAttribute("message");
  out.println (message);
}



if (documentMetaData.getNewTemplateVersion() == 9999)
  out.println("This document is not ready to be tested.  Template needs to be converted & loaded in the DB.");




if (documentMetaData != null)
{


      out.write("\r\n</font>\r\n\r\n\r\nTest Case:");
      out.print( String.valueOf(request.getParameter("ID_TEST")));
      out.write("\r\n<br>\r\nDocument Test Type: ");
      out.print( String.valueOf(request.getParameter("TEST_TYPE")));
      out.write("\r\n<br>\r\nStatus: ");
      out.print( String.valueOf(request.getParameter("STATUS")));
      out.write("\r\n\r\n<form name=\"frmInput\" method=\"post\" action=\"/document/DocumentConversation/showDocument\">\r\n<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n  <tr>\r\n    <td valign=\"top\" width=\"50%\">\r\n   <table>\r\n   <tr><td  colspan=\"1\"><h2>Document Information</h2></td></tr>\r\n   <tr><td>Display Name:</td><td> ");
      out.print(documentMetaData.getDocumentDisplayName());
      out.write("</td> </tr>\r\n     <tr><td>Doc Type:</td><td> ");
      out.print(documentMetaData.getDocumentType());
      out.write("</td> </tr>\r\n     <tr><td>Template:</td><td> ");
      out.print(documentMetaData.getTemplateType());
      out.write(" </td> </tr>\r\n   <tr><td>New Template Version:</td><td> ");
      out.print(String.valueOf(documentMetaData.getNewTemplateVersion()));
      out.write("</td> </tr>\r\n   <tr><td>Document Category:</td><td> ");
      out.print(documentMetaData.getDocumentCategory().toString());
      out.write(" </td> </tr>\r\n   <tr><td>Display Only:</td><td> ");
      out.print(String.valueOf(documentMetaData.getDisplayOnly()));
      out.write(" </td> </tr>\r\n   <tr><td>Has Footer: </td><td> ");
      out.print(String.valueOf(documentMetaData.getHasFooter()));
      out.write(" </td> </tr>\r\n\r\n\r\n   <tr><td>CheckStage</td><td><input type=\"text\" name=\"checkStage\"></td></tr>\r\n  </table>\r\n  </td>\r\n    <td valign=\"top\" width=\"50%\">\r\n  <table cellpadding=\"0\" cellspacing=\"0\">\r\n    <tr><td  colspan=\"2\"><h2>Render Type</h2></td></tr>\r\n   <tr><td width=\"3\"><input type=\"radio\" name=\"renderFormat\" value=\"HTML_WITH_SHELL\" checked></td><td>  HTML_WITH_SHELL </td> </tr>\r\n   <tr><td width=\"3\"><input type=\"radio\" name=\"renderFormat\" value=\"PDF\"></td><td>  PDF </td> </tr>\r\n   <tr><td width=\"3\"><input type=\"radio\" name=\"renderFormat\" value=\"HTML_WITHOUT_SHELL\"></td><td>  HTML_WITHOUT_SHELL  </td> </tr>\r\n   <tr><td width=\"3\"><input type=\"radio\" name=\"renderFormat\" value=\"HTML_COMMENT_SHELL\"></td><td>  HTML_COMMENT_SHELL  </td> </tr>\r\n    </table>\r\n    <br>\r\n  <table cellpadding=\"0\" cellspacing=\"0\">\r\n    <tr><td  colspan=\"2\"><h2>Document Exists</h2></td></tr>\r\n   <tr><td width=\"1\"><input type=\"radio\" name=\"docExists\" value=\"true\" checked></td><td>True</td></tr>\r\n   <tr><td width=\"1\"><input type=\"radio\" name=\"docExists\" value=\"false\"></td><td>False</td> </tr>\r\n");
      out.write("    </table>\r\n\r\n\r\n\r\n  </td>\r\n\r\n  </tr>\r\n  <tr>\r\n    <td colspan=\"2\">\r\n  &nbsp;\r\n  </td>\r\n  </tr>\r\n  <tr>\r\n    <td colspan=\"2\">\r\n   <h2>PreFill Parameters</h2>\r\n  </td>\r\n  </tr>\r\n\r\n    ");

  if (documentMetaData.getPreFillMetaData() != null)
  {
      out.println("<tr><td colspan=\"2\">");
    out.println("Prefill Service:  " + documentMetaData.getPreFillMetaData().getInputClass().getName());
    out.println("</td></tr>");

    for (int x=0; x < documentMetaData.getPreFillMetaData().getInputClass().getParameterCount(); x++)
    {
      Parameter param = documentMetaData.getPreFillMetaData().getInputClass().getParameter(x);
      out.println("<tr><td colspan=\"1\">" + param.getName().toUpperCase() + ":&nbsp;&nbsp;<input type=\"text\" name=\"" + param.getRequestName()+ "\"" );

            if ("PCASE".equals(param.getRequestName().toUpperCase()) || "SCASE".equals(
                    param.getRequestName().toUpperCase()))
            {
              if (request.getParameter("ID_CASE") != null)
              {
                out.println("value=\"");
                out.println(request.getParameter("ID_CASE"));
                out.println("\"");
              }
            }

            if ("PSTAGE".equals(param.getRequestName().toUpperCase()) || "SSTAGE".equals(
                    param.getRequestName().toUpperCase()))
            {
               if (request.getParameter("ID_STAGE") != null)
               {
                 out.println("value=\"");
                 out.println(request.getParameter("ID_STAGE"));
                 out.println("\"");
               }
            }

            if ("PEVENT".equals(param.getRequestName().toUpperCase()) || "SEVENT".equals(
                    param.getRequestName().toUpperCase()))
            {

               if (request.getParameter("ID_EVENT") != null)
               {
                 out.println("value=\"");
                 out.println(request.getParameter("ID_EVENT"));
                 out.println("\"");
               }
            }

            if ("PPERSON".equals(param.getRequestName().toUpperCase()) || "SPERSON".equals(
                    param.getRequestName().toUpperCase()))
            {
               if (request.getParameter("ID_PERSON") != null)
               {
                 out.println("value=\"");
                 out.println(request.getParameter("ID_PERSON"));
                 out.println("\"");
               }
            }


            out.println("> </td></tr>");

    }
  }

    
      out.write("\r\n\r\n    <td colspan=\"2\">\r\n  &nbsp;\r\n  </td>\r\n  </tr>\r\n  <tr>\r\n    <td colspan=\"2\">\r\n   <h2>Save Parameters</h2>\r\n  </td>\r\n  </tr>\r\n\r\n     ");


  if (documentMetaData.getTableMetaData() != null)
  {
      out.println("<tr><td colspan=\"2\">");
    out.println("Database Table:  " + documentMetaData.getTableMetaData().getTableName());
    out.println("</td></tr>");

    for (int x=0; x < documentMetaData.getTableMetaData().getTableFields().getColumnCount(); x++)
    {
      Column column = documentMetaData.getTableMetaData().getTableFields().getColumn(x);
      out.println("<tr><td colspan=\"1\">" + column.getName().toUpperCase() + ":&nbsp;&nbsp;<input type=\"text\" name=\"" + column.getRequestName() + "\"");



            if ("PCASE".equals(column.getRequestName().toUpperCase()) || "SCASE".equals(
                    column.getRequestName().toUpperCase()))
            {
              if (request.getParameter("ID_CASE") != null)
              {
                out.println("value=\"");
                out.println(request.getParameter("ID_CASE"));
                out.println("\"");
              }
            }

            if ("PSTAGE".equals(column.getRequestName().toUpperCase()) || "SSTAGE".equals(
                    column.getRequestName().toUpperCase()))
            {
               if (request.getParameter("ID_STAGE") != null)
               {
                 out.println("value=\"");
                 out.println(request.getParameter("ID_STAGE"));
                 out.println("\"");
               }
            }

            if ("PEVENT".equals(column.getRequestName().toUpperCase()) || "SEVENT".equals(
                    column.getRequestName().toUpperCase()))
            {

               if (request.getParameter("ID_EVENT") != null)
               {
                 out.println("value=\"");
                 out.println(request.getParameter("ID_EVENT"));
                 out.println("\"");
               }
            }

            if ("PPERSON".equals(column.getRequestName().toUpperCase()) || "SPERSON".equals(
                    column.getRequestName().toUpperCase()))
            {
               if (request.getParameter("ID_PERSON") != null)
               {
                 out.println("value=\"");
                 out.println(request.getParameter("ID_PERSON"));
                 out.println("\"");
               }
            }

            out.println("> </td></tr>");



    }
  }
    
      out.write("\r\n\r\n\r\n\r\n\r\n\r\n</table>\r\n\r\n<input type=\"hidden\" name=\"docType\" value=\"");
      out.print(documentMetaData.getDocumentType());
      out.write("\">\r\n\r\n<br>\r\n<br>\r\n<input type=\"submit\" value=\"Submit Document\" onClick=\"submitDocument();\">\r\n\r\n");

if (documentMetaData.getTableMetaData() != null)
{
  
      out.write("\r\n   <input type=\"submit\" value=\"Delete Document\" onClick=\"deleteDocument();\">\r\n  ");

}

      out.write("\r\n\r\n\r\n<input type=\"reset\" value=\"Reset\">\r\n\r\n</form>\r\n\r\n\r\n");

}


      out.write("\r\n\r\n\r\n\r\n</body>\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n</html>\r\n\r\n");
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
