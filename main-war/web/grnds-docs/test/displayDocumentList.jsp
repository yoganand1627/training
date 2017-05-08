<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.Set"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.BasePrsConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.BasePrsConversation"%>
<%
  // Set character encoding before printing anything out; this MUST
  //   be done in order to properly display extended characters.
  response.setContentType( "text/html; charset=" + ArchitectureConstants.CHARACTER_ENCODING );
%>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=<%=ArchitectureConstants.CHARACTER_ENCODING%>">
  <title>Display Document List</title>
  <link href="/grnds-docs/css/impact.css" rel="stylesheet">
</head>
<body>
  <table width="500" cellpadding="1">
    <tr>
      <td class="formErrorText">
        <hr noshade size="1">
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
      out.println(nextErrorMessage + "<br>");
    }

  }
%>
      <hr noshade size="1">
    </td>
  </tr>
</table>
</body>
</html>