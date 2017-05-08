<%@ page import="java.io.PrintWriter"%>
<%@ page import="java.io.StringReader"%>
<%@ page import="java.util.Enumeration"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.Set"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.exception.BasePrsException"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.jndihelper.JndiHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.jndihelper.JndiHelperRuntimeException"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.document.DocumentMetaData"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.BasePrsConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.document.successaction.DocumentSuccessAction"%>
<%@ page import="org.exolab.castor.xml.Unmarshaller"%>
<%
  // Set character encoding before printing anything out; this MUST
  //   be done in order to properly display extended characters.
  response.setContentType( "text/html; charset=" + ArchitectureConstants.CHARACTER_ENCODING );
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=<%=ArchitectureConstants.CHARACTER_ENCODING%>">
  <title>Untitled</title>
</head>

<body>

<h1>Document Architecture Interface Page</h1>


This  page shows the parameters that will be passed to the Document Architecture.
 Be sure to verify the parameters that should passed are showing.
<br><br>


<%
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





%>








<%

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


%>



<h2>Request Parameters</h2>

<%


     for (Enumeration en=request.getParameterNames(); en.hasMoreElements();)
     {
         String paramName = (String) en.nextElement();
         out.println("<strong>Parameter</strong><br>");
   out.println("Name:" + paramName + "<br>");
         String paramValue = String.valueOf(request.getParameter(paramName));
   out.println("Value:" + paramValue);
         out.println("<br><br>");
      }

%>


<h2>Request Attributes</h2>
Attributes overide parameters when sent to the document architecture.
<br><br>

<%


   for (Enumeration en=request.getAttributeNames(); en.hasMoreElements();)
     {
         String paramName = (String) en.nextElement();
         out.println("<strong>Attribute</strong><br>");
   out.println("Name:" + paramName + "<br>");

         String paramValue = String.valueOf(request.getAttribute(paramName));
         out.println("Value:" + paramValue);

         out.println("<br><br>");
     }




%>

</body>
</html>
