<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.document.DocumentPresentation"%>
<%
  // Set character encoding before printing anything out; this MUST
  //   be done in order to properly display extended characters.
  response.setContentType( "text/html; charset=" + ArchitectureConstants.CHARACTER_ENCODING );
  String legacyDocument = (String) request.getAttribute(DocumentPresentation.CONTENT_REQUEST_NAME);
  String mimeType = (String) request.getAttribute(DocumentPresentation.MIMETYPE_REQUEST_NAME);
%>

<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=<%=ArchitectureConstants.CHARACTER_ENCODING%>">
  <title>Approved Word Document</title>
  <LINK href="/grnds-docs/css/impact.css" rel=stylesheet>
</head>
<body>

<div class="tableborderList">
<table border="0" width="100%" cellSpacing="0" cellPadding="3" class="tableBorder">
 <tr><th>Approved Word Document</th></tr>
  <tr>
   <td>
      The document requested is an approved Word Document, and any modifications will not be saved.
      Please click 'OK' to open the Word document.
   </td>
  </tr>
</table>
</div>
<form action="/document/DocumentConversation/displayLegacyDocument" method="post">
  <input type="hidden" name="<%=DocumentPresentation.CONTENT_REQUEST_NAME%>" value="<%=legacyDocument%>">
  <input type="hidden" name="<%=DocumentPresentation.MIMETYPE_REQUEST_NAME%>" value="<%=mimeType%>">
<table border="0" width="100%" cellSpacing="0" cellPadding="3">
  <tr>
    <td align="right">
       <input type="image" src="/grnds-docs/images/shared/btnOk.gif" border="0">
    </td>
  </tr>
</table>
</form>
</body>
</html>
