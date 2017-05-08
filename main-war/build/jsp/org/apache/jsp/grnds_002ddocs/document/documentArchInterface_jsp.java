package org.apache.jsp.grnds_002ddocs.document;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.BasePrsException;
import gov.georgia.dhr.dfcs.sacwis.core.jndihelper.JndiHelper;
import gov.georgia.dhr.dfcs.sacwis.core.jndihelper.JndiHelperRuntimeException;
import gov.georgia.dhr.dfcs.sacwis.structs.document.DocumentMetaData;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BasePrsConversation;
import gov.georgia.dhr.dfcs.sacwis.web.document.successaction.DocumentSuccessAction;
import org.exolab.castor.xml.Unmarshaller;

public final class documentArchInterface_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  // Set character encoding before printing anything out; this MUST
  //   be done in order to properly display extended characters.
  response.setContentType( "text/html; charset=" + ArchitectureConstants.CHARACTER_ENCODING );

      out.write("\r\n<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\r\n<html>\r\n<head>\r\n  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=");
      out.print(ArchitectureConstants.CHARACTER_ENCODING);
      out.write("\">\r\n  <title>Untitled</title>\r\n</head>\r\n\r\n<body>\r\n\r\n<h1>Document Architecture Interface Page</h1>\r\n\r\n\r\nThis  page shows the parameters that will be passed to the Document Architecture.\r\n Be sure to verify the parameters that should passed are showing.\r\n<br><br>\r\n\r\n\r\n");

  //Get the documentmetadata
  String docType = null;
  String docMetaDataString = null;
  DocumentMetaData documentMetaData = null;
  if (request.getParameter("docType") != null)
  {
    docType = request.getParameter("docType");
    request.setAttribute("docType", docType);
  }
  if (request.getAttribute("docType") != null)
  {
      docType = (String) request.getAttribute("docType");
  }


  if (docType!= null)
  {
    docType = docType.toUpperCase();
    try
    {
      docMetaDataString = (String) JndiHelper.lookup(docType.toUpperCase());

      try
      {
         // Unmarshall the Xml String into the DocumentMetaData object
         StringReader stringReader = new StringReader(docMetaDataString);
         documentMetaData = (DocumentMetaData) Unmarshaller.unmarshal(DocumentMetaData.class, stringReader);
      }
      catch (Exception e)
      {
        out.println("Document did not unmarshall correctly.");
      }
    }
    catch(JndiHelperRuntimeException jhre)
    {
      out.println("The document type (" + docType + ") was not found in the JNDI.  This is not an error unless you are testing post actions.");;
    }

    if (documentMetaData!= null)
    {
      //Process the success action
      if (documentMetaData.getSuccessActionClass() != null)
     {
       try
       {
         // Load the Input class
         Class succActionClass = Class.forName(documentMetaData.getSuccessActionClass());
         DocumentSuccessAction documentSuccessAction = (DocumentSuccessAction) succActionClass.newInstance();
         documentSuccessAction.execute(request);
       }
       catch (BasePrsException be)
       {
         out.println(be.getMessage());
       }

       catch (Exception e)
       {
         e.printStackTrace(new PrintWriter(out));
       }
     }

    }
    else
    {
      out.println ("DocumentMetaData is null");
    }



  }






      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");


  if (request.getAttribute( BasePrsConversation.ERROR_MESSAGES )!= null)
  {
    Map nonValidationErrorMessages = (Map)request.getAttribute( BasePrsConversation.ERROR_MESSAGES );

          Set keys = nonValidationErrorMessages.keySet();
    Iterator keyIter = keys.iterator();

      while (keyIter.hasNext())
    {
             String nextErrorName = (String) keyIter.next();
       String nextErrorMessage = (String) nonValidationErrorMessages.get(nextErrorName);
       out.println("Error:" +  nextErrorMessage);
          }

  }



      out.write("\r\n\r\n\r\n\r\n<h2>Request Parameters</h2>\r\n\r\n");



     for (Enumeration en=request.getParameterNames(); en.hasMoreElements();)
     {
         String paramName = (String) en.nextElement();
         out.println("<strong>Parameter</strong><br>");
   out.println("Name:" + paramName + "<br>");
         String paramValue = String.valueOf(request.getParameter(paramName));
   out.println("Value:" + paramValue);
         out.println("<br><br>");
      }


      out.write("\r\n\r\n\r\n<h2>Request Attributes</h2>\r\nAttributes overide parameters when sent to the document architecture.\r\n<br><br>\r\n\r\n");



   for (Enumeration en=request.getAttributeNames(); en.hasMoreElements();)
     {
         String paramName = (String) en.nextElement();
         out.println("<strong>Attribute</strong><br>");
   out.println("Name:" + paramName + "<br>");

         String paramValue = String.valueOf(request.getAttribute(paramName));
         out.println("Value:" + paramValue);

         out.println("<br><br>");
     }





      out.write("\r\n\r\n</body>\r\n</html>\r\n");
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
