<%@ page import="javax.naming.Binding" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.naming.NamingEnumeration" %>

<html>
<head>
  <LINK href="/grnds-docs/css/impact.css" rel=stylesheet>
  <SCRIPT type="text/javascript" language="JavaScript1.2" src="/grnds-docs/js/shared/prsValidation.js"></script>
  <SCRIPT type="text/javascript" src="/grnds-docs/js/shared/syncscroll.js"></script>
  <SCRIPT type="text/javascript" src="/grnds-docs/js/shared/impact.js"></script>
  <SCRIPT type="text/javascript" src="/grnds-docs/js/document/document.js"></script>

</head>

<body>
<%
  InitialContext context = new InitialContext();
  NamingEnumeration<Binding> namingEnumeration = context.listBindings("java:comp/env/ejb");
%>
<table>
  <%
    while (namingEnumeration.hasMoreElements()) {
      Binding binding = namingEnumeration.next();
  %>
  <tr>
    <td><%=binding.getClassName()%></td>
    <td><%=binding.getName()%></td>
    <td><%=binding.getObject()%></td>
  </tr>
  <%
    }
  %>
</table>
</body>
</html>
