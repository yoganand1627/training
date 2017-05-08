package org.apache.jsp.grnds_002ddocs.test;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Enumeration;
import java.util.StringTokenizer;
import java.util.Random;
import java.util.Iterator;
import gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;

public final class DebugRequestParameters_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(1);
    _jspx_dependants.add("/WEB-INF/impact.tld");
  }

  public java.util.List getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    JspFactory _jspxFactory = null;
    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      _jspxFactory = JspFactory.getDefaultFactory();
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  int debugRequestParametersRowCss=0;

      out.write("\r\n\r\n");
/********* BEGIN: REQUEST PARAMETERS ***********/ 
      out.write("\r\n<br>\r\n");
      //  impact:ExpandableSectionTag
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
      _jspx_th_impact_ExpandableSectionTag_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_ExpandableSectionTag_0.setParent(null);
      _jspx_th_impact_ExpandableSectionTag_0.setName("Request Parameters");
      _jspx_th_impact_ExpandableSectionTag_0.setLabel("Request Parameters");
      _jspx_th_impact_ExpandableSectionTag_0.setTabIndex(-1);
      int _jspx_eval_impact_ExpandableSectionTag_0 = _jspx_th_impact_ExpandableSectionTag_0.doStartTag();
      if (_jspx_eval_impact_ExpandableSectionTag_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n  <table border=\"0\" width=\"760\" cellSpacing=\"0\" cellPadding=\"3\" class=\"tableBorder\">\r\n    <tr class=\"subDetail\">\r\n      <th>Parameter Name</th>\r\n      <th>Parameter Value</th>\r\n    </tr>\r\n    ");

      Iterator params = request.getParameterMap().keySet().iterator();
      while ( params.hasNext() )
      {
        String paramName = (String) params.next();
        String paramString = request.getParameter( paramName );
    
          out.write("\r\n    <tr class=\"");
          out.print( FormattingHelper.getRowCss( debugRequestParametersRowCss++ ) );
          out.write("\">\r\n      <td>\r\n      ");
          out.print( paramName );
          out.write("\r\n      </td>\r\n      <td>\r\n      ");

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
          
          out.write("\r\n          <SCRIPT LANGUAGE=\"javascript\">\r\n            function ");
          out.print(functionName);
          out.write("()\r\n            {\r\n              var descriptor = \"\";\r\n              descriptor += \"width=450,\";\r\n              descriptor += \"height=600,\";\r\n              descriptor += \"channelmode=0,\";\r\n              descriptor += \"dependent=0,\";\r\n              descriptor += \"directories=0,\";\r\n              descriptor += \"fullscreen=0,\";\r\n              descriptor += \"location=0,\";\r\n              descriptor += \"menubar=0,\";\r\n              descriptor += \"resizable=1,\";\r\n              descriptor += \"scrollbars=1,\";\r\n              descriptor += \"status=0,\";\r\n              descriptor += \"toolbar=0\";\r\n              var newWindow = window.open( '', '_blank', descriptor );\r\n              newWindow.document.title.innerHTML = '\" + beanName + \".xml';\r\n              ");

                StringTokenizer st = new StringTokenizer( paramString, "\n\r\f", false );
                while( st.hasMoreTokens() )
                {
                  
          out.write("\r\n                    newWindow.document.write( '");
          out.print(st.nextToken());
          out.write("' );\r\n                  ");

                  if( st.hasMoreTokens() )
                  {
                    
          out.write("\r\n                      newWindow.document.writeln( '<br>' );\r\n                    ");

                  }
                }
              
          out.write("\r\n            }\r\n          </SCRIPT>\r\n          <a onClick=\"hrefDirtyBypass=true;\" href=\"javascript:");
          out.print(functionName);
          out.write("()\">");
          out.print(shortParamString);
          out.write("</a>\r\n          ");

        }
        else
        {
          out.print( paramString );
        }
      
          out.write("\r\n      </td>\r\n    </tr>\r\n    ");

      }
    
          out.write("\r\n  </table>\r\n");
          int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_ExpandableSectionTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write('\r');
      out.write('\n');
/********* END: REQUEST PARAMETERS ***********/ 
      out.write('\r');
      out.write('\n');
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      if (_jspxFactory != null) _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
