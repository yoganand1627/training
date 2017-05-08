<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.document.Column"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.document.DocumentMetaData"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.document.Parameter"%>
<%
  // Set character encoding before printing anything out; this MUST
  //   be done in order to properly display extended characters.
  response.setContentType( "text/html; charset=" + ArchitectureConstants.CHARACTER_ENCODING );
%>
<html>
<head>
<title>Document Input Form</title>
  <meta http-equiv="Content-Type" content="text/html; charset=<%=ArchitectureConstants.CHARACTER_ENCODING%>">
  <LINK href="/grnds-docs/css/impact.css" rel=stylesheet>
  <script src="/grnds-docs/js/document/document.js"></script>
</head>

<style>

body td {
  font-family : Verdana, Geneva, Arial, Helvetica, sans-serif;
  font-size : .8pc;
}


h1{
  font-family : Verdana, Geneva, Arial, Helvetica, sans-serif;
  font-size : 1.2pc;
}
h2{
  font-family : Verdana, Geneva, Arial, Helvetica, sans-serif;
  font-size : 1pc;
}

</style>


<script>

function submitDocument()
{
   frmInput.action="/document/DocumentConversation/showDocument";
   var newWindow = openDocumentConversationWindow();
   frmInput.target = newWindow;
   return true;

}

function deleteDocument()
{
   frmInput.action='/document/DocumentTestConversation/deleteDocument';
   frmInput.target = "";
   return true;
}





</script>


<body>
<a href="/document/DocumentTestConversation/documentList">Back to Document List</a>

<h1>Document Input Form</h1>



<font color="red">
<%
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

%>
</font>


Test Case:<%= String.valueOf(request.getParameter("ID_TEST"))%>
<br>
Document Test Type: <%= String.valueOf(request.getParameter("TEST_TYPE"))%>
<br>
Status: <%= String.valueOf(request.getParameter("STATUS"))%>

<form name="frmInput" method="post" action="/document/DocumentConversation/showDocument">
<table border="0" cellpadding="0" cellspacing="0" width="100%">
  <tr>
    <td valign="top" width="50%">
   <table>
   <tr><td  colspan="1"><h2>Document Information</h2></td></tr>
   <tr><td>Display Name:</td><td> <%=documentMetaData.getDocumentDisplayName()%></td> </tr>
     <tr><td>Doc Type:</td><td> <%=documentMetaData.getDocumentType()%></td> </tr>
     <tr><td>Template:</td><td> <%=documentMetaData.getTemplateType()%> </td> </tr>
   <tr><td>New Template Version:</td><td> <%=String.valueOf(documentMetaData.getNewTemplateVersion())%></td> </tr>
   <tr><td>Document Category:</td><td> <%=documentMetaData.getDocumentCategory().toString()%> </td> </tr>
   <tr><td>Display Only:</td><td> <%=String.valueOf(documentMetaData.getDisplayOnly())%> </td> </tr>
   <tr><td>Has Footer: </td><td> <%=String.valueOf(documentMetaData.getHasFooter())%> </td> </tr>


   <tr><td>CheckStage</td><td><input type="text" name="checkStage"></td></tr>
  </table>
  </td>
    <td valign="top" width="50%">
  <table cellpadding="0" cellspacing="0">
    <tr><td  colspan="2"><h2>Render Type</h2></td></tr>
   <tr><td width="3"><input type="radio" name="renderFormat" value="HTML_WITH_SHELL" checked></td><td>  HTML_WITH_SHELL </td> </tr>
   <tr><td width="3"><input type="radio" name="renderFormat" value="PDF"></td><td>  PDF </td> </tr>
   <tr><td width="3"><input type="radio" name="renderFormat" value="HTML_WITHOUT_SHELL"></td><td>  HTML_WITHOUT_SHELL  </td> </tr>
   <tr><td width="3"><input type="radio" name="renderFormat" value="HTML_COMMENT_SHELL"></td><td>  HTML_COMMENT_SHELL  </td> </tr>
    </table>
    <br>
  <table cellpadding="0" cellspacing="0">
    <tr><td  colspan="2"><h2>Document Exists</h2></td></tr>
   <tr><td width="1"><input type="radio" name="docExists" value="true" checked></td><td>True</td></tr>
   <tr><td width="1"><input type="radio" name="docExists" value="false"></td><td>False</td> </tr>
    </table>



  </td>

  </tr>
  <tr>
    <td colspan="2">
  &nbsp;
  </td>
  </tr>
  <tr>
    <td colspan="2">
   <h2>PreFill Parameters</h2>
  </td>
  </tr>

    <%
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

    %>

    <td colspan="2">
  &nbsp;
  </td>
  </tr>
  <tr>
    <td colspan="2">
   <h2>Save Parameters</h2>
  </td>
  </tr>

     <%

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
    %>





</table>

<input type="hidden" name="docType" value="<%=documentMetaData.getDocumentType()%>">

<br>
<br>
<input type="submit" value="Submit Document" onClick="submitDocument();">

<%
if (documentMetaData.getTableMetaData() != null)
{
  %>
   <input type="submit" value="Delete Document" onClick="deleteDocument();">
  <%
}
%>


<input type="reset" value="Reset">

</form>


<%
}

%>



</body>








</html>

