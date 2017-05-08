<!--
Description: Tool for displaying code-decode values from the in memory
hashmaps in used for codes table lookups.
Author: Brad Eilers
Date: 08/21/03
-->
<%@ page import="java.util.Iterator" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.LookupData" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.initialize.LookupInit" %>
<%!
  // Max size of the html tables generated
  public static final int tableSize = 50;
  //Allow user to enter Category and list all entries for that category.
%>
<%
  //Get codes table object
  String codeCategory = request.getParameter("codeCategory");
  String onDemand = request.getParameter("onDemandRefresh");
  if (onDemand != null) {
    LookupInit.updateLookupData();
  }
%>

<html>
<head>
  <LINK href="/grnds-docs/css/impact.css" rel=stylesheet>
  <script type="text/javascript" language="JavaScript1.2" src="/grnds-docs/js/shared/prsValidation.js"></script>
  <script type="text/javascript" src="/grnds-docs/js/shared/syncscroll.js"></script>
  <script type="text/javascript" src="/grnds-docs/js/shared/impact.js"></script>
  <script type="text/javascript" src="/grnds-docs/js/document/document.js"></script>

</head>
<body>
<b>Lookup Data Last Update: <%= LookupData.getLastUpdate()%>
</b> <br/>

<form action="/grnds-docs/LookupDataTool.jsp" method="post">
  <br/><b>On-Demand Refresh of Lookup Data (In Memory Codes Tables):</b><br/>
  <input type="submit" name="onDemandRefresh" value="Start Refresh"/><br/><br/>
  <br/><b>Look up Current (In Memory) Values:</b><br/>
  Codes Table Name:<input type="text" maxlength="20" name="codeCategory"
                          value="<%= ( request.getParameter( "codeCategory" ) != null ) ? request.getParameter( "codeCategory" ) : "" %>"/>
  <input type="submit" name="getCodeCategory" value="Get Codes Table Data"/><br/>
</form>
<%
  //If the codeCategory is not null, display its contents
  if (codeCategory != null && !"".equals(codeCategory)) {
    //Loop through all of the codes table entries displaying code and decode
    Iterator i = Lookup.getCategoryListing(codeCategory.toUpperCase());
    out.println("Codes for " + codeCategory + ":<br/>");
    if (i.hasNext()) {
      out.println("<table border=1 cellpadding=3 cellspacing=0><th>Code</th><th>Decode</th>");
      int rowCount = 0;
      while (i.hasNext()) {
        rowCount++;
        CodeAttributes codeAttr = (CodeAttributes) i.next();
%>
<tr class='<%=rowCount % 2 == 0 ? "odd" : "even"%>'>
  <td><%=codeAttr.getCode() %>
  </td>
  <td><%=codeAttr.getDecode() %>
  </td>
</tr>
<%
    }
    out.println("</table>");
  }
  //If there are any expired codes, display them
  i = Lookup.getExpiredCategoryCollection(codeCategory).iterator();
  if (i.hasNext()) {
    out.println("<br/>Expired Codes:<br/>");
    out.println("<table border=1 cellpadding=3 cellspacing=0><th>Code</th><th>Decode</th>");
    int rowCount = 0;
    while (i.hasNext()) {
      rowCount++;
      CodeAttributes codeAttr = (CodeAttributes) i.next();
%>
<tr class='<%=rowCount % 2 == 0 ? "odd" : "even"%>'>
  <td><%=codeAttr.getCode() %>
  </td>
  <td><%=codeAttr.getDecode() %>
  </td>
</tr>
<%
      }
      out.println("</table>");
    }
  }

%>
<br/>

</body>
</html>
