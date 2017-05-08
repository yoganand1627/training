<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>
<%@ taglib uri="/WEB-INF/debug.tld" prefix="debug" %>

<%@ page import="java.util.Enumeration" %>
<%@ page import="java.util.StringTokenizer" %>
<%@ page import="java.util.Random" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%
  int debugRequestAttributesRowCss=0;
%>

<%/********* BEGIN: REQUEST ATTRIBUTES ***********/ %>
<br>
<impact:ExpandableSectionTag
  name="Request Attributes"
  label="Request Attributes"
  tabIndex="-1">
  <table border="0" width="760" cellSpacing="0" cellPadding="3" class="tableBorder">
    <tr class="subDetail">
      <th>Attribute Name</th>
      <th>Attribute Value</th>
    </tr>
    <tr class="<%= FormattingHelper.getRowCss( debugRequestAttributesRowCss++ ) %>">
      <td align="top">PageMode (in state)</td>
      <td><%= PageMode.getPageMode(request) %></td>
    </tr>
    <%
      Enumeration attributes = request.getAttributeNames();
      while ( attributes.hasMoreElements() )
      {
        String attName = (String) attributes.nextElement();
        Object attVal = request.getAttribute( attName );
        String attString ="";

    %>
    <tr class="<%= FormattingHelper.getRowCss( debugRequestAttributesRowCss++ ) %>">
      <td align="top">
      <%= attName %>
      </td>
      <td>
      <%
        if (attVal instanceof String )
        {
          out.println ( (String) attVal );
        }
        else if (attVal instanceof XmlValueBean )
        {
        %>
          <debug:displayXmlValueBean xmlValueBean="<%=(XmlValueBean)attVal%>" />
        <%
        }
        else
        {
          attString = attVal.toString();
          if ( attString.length() > 70 )
          {
            String shortAttString = attString.substring(0,30) + "...";
            String functionName = "displayAttribute_" + Math.abs( new Random( System.currentTimeMillis() ).nextInt() );
            StringBuffer sb = new StringBuffer( attString );
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
            attString = sb.toString();
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
                  StringTokenizer st = new StringTokenizer( attString, "\n\r\f", false );
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
            <a onClick="hrefDirtyBypass=true;" href="javascript:<%=functionName%>()"><%=shortAttString%></a>
            <%
          }
          else
          {
            out.print( attString );
          }
        }
      %>
      </td>
    </tr>
    <%
      }
    %>
  </table>
</impact:ExpandableSectionTag>
<%/********* END: REQUEST ATTRIBUTES ***********/ %>
