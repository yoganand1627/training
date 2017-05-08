<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%@ page import="java.util.Enumeration" %>
<%@ page import="java.util.StringTokenizer" %>
<%@ page import="java.util.Random" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%
  int debugRequestParametersRowCss=0;
%>

<%/********* BEGIN: REQUEST PARAMETERS ***********/ %>
<br>
<impact:ExpandableSectionTag
  name="Request Parameters"
  label="Request Parameters"
  tabIndex="-1">
  <table border="0" width="760" cellSpacing="0" cellPadding="3" class="tableBorder">
    <tr class="subDetail">
      <th>Parameter Name</th>
      <th>Parameter Value</th>
    </tr>
    <%
      Iterator params = request.getParameterMap().keySet().iterator();
      while ( params.hasNext() )
      {
        String paramName = (String) params.next();
        String paramString = request.getParameter( paramName );
    %>
    <tr class="<%= FormattingHelper.getRowCss( debugRequestParametersRowCss++ ) %>">
      <td>
      <%= paramName %>
      </td>
      <td>
      <%
        if ( paramString.length() > 70 )
        {
          String shortParamString = paramString.substring(0,30) + "...";
          String functionName = "displayAttribute_" + Math.abs( new Random( System.currentTimeMillis() ).nextInt() );
          StringBuffer sb = new StringBuffer( paramString );
          for( int i = 0; i < sb.length(); i++ )
          {
            switch( sb.charAt( i ) )
            {
              case '\'':
                sb.replace( i, i + 1, "&apos;" );
                break;
              case '\"':
                sb.replace( i, i + 1, "&quot;" );
                break;
              case '<':
                sb.replace( i, i + 1, "&lt;" );
                break;
              case '>':
                sb.replace( i, i + 1, "&gt;" );
                break;
              case '&':
                sb.replace( i, i + 1, "&amp;" );
                break;
            }
          }
          paramString = sb.toString();
          %>
          <SCRIPT LANGUAGE="javascript">
            function <%=functionName%>()
            {
              var descriptor = "";
              descriptor += "width=450,";
              descriptor += "height=600,";
              descriptor += "channelmode=0,";
              descriptor += "dependent=0,";
              descriptor += "directories=0,";
              descriptor += "fullscreen=0,";
              descriptor += "location=0,";
              descriptor += "menubar=0,";
              descriptor += "resizable=1,";
              descriptor += "scrollbars=1,";
              descriptor += "status=0,";
              descriptor += "toolbar=0";
              var newWindow = window.open( '', '_blank', descriptor );
              newWindow.document.title.innerHTML = '" + beanName + ".xml';
              <%
                StringTokenizer st = new StringTokenizer( paramString, "\n\r\f", false );
                while( st.hasMoreTokens() )
                {
                  %>
                    newWindow.document.write( '<%=st.nextToken()%>' );
                  <%
                  if( st.hasMoreTokens() )
                  {
                    %>
                      newWindow.document.writeln( '<br>' );
                    <%
                  }
                }
              %>
            }
          </SCRIPT>
          <a onClick="hrefDirtyBypass=true;" href="javascript:<%=functionName%>()"><%=shortParamString%></a>
          <%
        }
        else
        {
          out.print( paramString );
        }
      %>
      </td>
    </tr>
    <%
      }
    %>
  </table>
</impact:ExpandableSectionTag>
<%/********* END: REQUEST PARAMETERS ***********/ %>
