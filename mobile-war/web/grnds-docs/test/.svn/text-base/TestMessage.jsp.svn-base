<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages,
                 gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>

<%
String messageName = request.getParameter("message");

if (messageName == null || "".equals(messageName))
{
%>
  <form name="frmMessageTest" method="post">
    <p>Message:<input name="message" value=""/></p>
    <p><input type="submit" value="SUBMIT" name="btnSubmit"/></p>
  </form>
<%
}
else
{
  try
  {
    Integer messageCode = (Integer)(Messages.class.getField(messageName).get(null));
%>
<h2><%=messageName%> = <%=MessageLookup.getMessageByNumber(messageCode)%></h2>
<%
  }
  catch (Throwable t)
  {
%>
<h2>error looking up: <%=messageName%></h2>
  <%=t%>
  <pre>
<%
     t.printStackTrace(response.getWriter());
%>
  </pre>
<%
  }
}
%>