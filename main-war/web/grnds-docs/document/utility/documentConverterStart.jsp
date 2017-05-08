<%@ page import="java.io.StringReader" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.TreeMap" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.document.DocumentMetaData" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.document.DocumentLookup" %>
<%@ page import="org.exolab.castor.xml.Unmarshaller" %>
<%
  // Set character encoding before printing anything out; this MUST
  //   be done in order to properly display extended characters.
  response.setContentType("text/html; charset=" + ArchitectureConstants.CHARACTER_ENCODING);
%>
<html>

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=<%=ArchitectureConstants.CHARACTER_ENCODING%>">
  <title>Document Conversion Step 1</title>
</head>
<body style="font:size:.8pc">


<h1 style="font-size:1.0pc">Document Conversion Step 1</h1>


<table>
  <tr>
    <td>
      Step 1: Choose the document type of the errored document.
    </td>

  </tr>

</table>


<form action="/document/DocumentUtilityConversation/documentConverterStep2" method="post" name="frmDocumentType">
  <%
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

  %>
  <br>
  <input type="submit" value="Submit">
</form>

<br>
<br>
<br>
Or

<br>
<br>
<br>


<table>
  <tr>
    <td>
      Step 1: To convert a word document using a blank template enter the following.
    </td>
  </tr>

</table>

<form name="frmBlankTemplateConversion" action="/document/DocumentUtilityConversation/documentConverterStep2"
      method="post">
  <input type="radio" name="docType" value="CONVERT" checked> Header/Body Template <br>
  <input type="radio" name="docType" value="UTILITYHELPER"> Body Template <br>
  Table: <input type="text" name="tableName" size="30" maxlength="30"> <br>
  Event: <input type="text" name="sEvent" size="30" maxlength="30"> <br>
  <input type="submit" value="Submit">


</form>
</body>
</html>