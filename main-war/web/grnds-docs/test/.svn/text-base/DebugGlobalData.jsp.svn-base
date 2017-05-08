<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper,
                 gov.georgia.dhr.dfcs.sacwis.web.test.TestHelper" %>
<%@ page import="java.lang.reflect.Method" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Map" %>
<%
  int debugGlobalDataRowCss=0;
%>

<%/********* BEGIN: GLOBAL DATA ***********/ %>
<br>
<impact:ExpandableSectionTag
  name="GlobalData"
  label="Global Data"
  tabIndex="-1">

  <table border="0" width="760" cellSpacing="0" cellPadding="3" class="tableBorder">
    <tr class="subDetail">
      <th>Field Name</th>
      <th>Field Value</th>
      <th>Field Name</th>
      <th>Field Value</th>
    </tr>
    <%
      boolean newRow = true;
      Map globalDataGetters = TestHelper.getGlobalDataGetters();
      Iterator nameIt = globalDataGetters.keySet().iterator();
      while( nameIt.hasNext() )
      {
        if( newRow )
        {
          %><tr class="<%= FormattingHelper.getRowCss( debugGlobalDataRowCss++ ) %>"><%
        }
        String name = (String)nameIt.next();
        %><td><%=name%></td><%
        Method getMethod = (Method)globalDataGetters.get( name );
        Class returnType = getMethod.getReturnType();
        if( returnType == Integer.TYPE )
        {
          int intValue = (Integer) getMethod.invoke(null, new Object[] {request});
          %>
            <td><%=FormattingHelper.formatInt( intValue )%></td>
          <%
        }
        else if( returnType == String.class )
        {
          String stringValue = (String)getMethod.invoke( null, request);
          %>
            <td><%=FormattingHelper.formatString( stringValue )%></td>
          <%
        }
        else if( returnType == Boolean.TYPE )
        {
          boolean booleanValue = (Boolean) getMethod.invoke(null, new Object[] {request});
          %>
            <td><%=booleanValue ? "True" : "False"%></td>
          <%
        }
        else if( returnType ==  org.exolab.castor.types.Date.class )
        {
          org.exolab.castor.types.Date date = (org.exolab.castor.types.Date)getMethod.invoke( null,
                                                                                              request);
          %>
            <td><%=FormattingHelper.formatDate( date )%></td>
          <%
        }
        if( newRow )
        {
          newRow = false;
        }
        else
        {
          newRow = true;
          %></tr><%
        }
      }
      if( !newRow )
      {
        %>
          <tr><td>&nbsp;</td><td>&nbsp;</td></tr>
        <%
      }
    %>
  </table>
</impact:ExpandableSectionTag>
<%/********* END: GLOBAL DATA ***********/ %>
