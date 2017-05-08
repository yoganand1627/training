<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.document.Column"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.document.DocumentMetaData"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.document.Parameter"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.document.PreFillMetaData"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.document.TableFields"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.document.DocumentLookup"%>
<%@ page import="org.exolab.castor.xml.Unmarshaller"%>
<%@ page import="java.io.StringReader"%>
<%
  // Set character encoding before printing anything out; this MUST
  //   be done in order to properly display extended characters.
  response.setContentType( "text/html; charset=" + ArchitectureConstants.CHARACTER_ENCODING );
%>
<html>

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=<%=ArchitectureConstants.CHARACTER_ENCODING%>">
  <title>Document Maintenance Step 2</title>
  <script>

  function getCurrentDocument()
  {
      document.frmDocumentType.action="/document/DocumentUtilityConversation/showCurrentDocument";
  }

  function getNewDocument()
  {
      document.frmDocumentType.action="/document/DocumentUtilityConversation/getNewDocument";
  }



  function getCurrentBlankDocument()
  {
      document.frmDocumentType.action="/document/DocumentUtilityConversation/showCurrentBlankDocument";
  }

  function getNewBlankDocument()
  {
      document.frmDocumentType.action="/document/DocumentUtilityConversation/getNewBlankDocument";
  }


  </script>


</head>
<body>
  <h1 style="font-size:1.0pc">Document Conversion Step 2</h1>
<table>
    <tr>
       <td>
         Step 2:  Get the current and new documents
       </td>

    </tr>

</table>



<form action="/document/DocumentUtilityConversation/getNewDocument" method="post" name="frmDocumentType" target="_blank">
<%
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

%>

<input type="hidden" name="docExists" value="true">


</form>





  <h1 style="font-size:1.0pc">Document Conversion Step 3</h1>
<table>
    <tr>
       <td>
         Step 3:  Copy the current document contents into the new document.  Save the
         new document.
       </td>

    </tr>

</table>






  <h1 style="font-size:1.0pc">Document Conversion Step 4</h1>
<table>
    <tr>
       <td>
         Step 4:  Verify your changes.
       </td>

    </tr>

</table>
<%
  String javaScriptFunction = null;

  if (request.getParameter("tableName") != null)
  {
    javaScriptFunction = "getCurrentBlankDocument();frmDocumentType.submit();";
  }
  else
  {
    javaScriptFunction = "getCurrentDocument();frmDocumentType.submit();";
  }




%>
<input type="submit" onClick="<%=javaScriptFunction%>" value="Get Changed Document">




</body>
</html>