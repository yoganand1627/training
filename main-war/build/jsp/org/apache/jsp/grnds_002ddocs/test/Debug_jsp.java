package org.apache.jsp.grnds_002ddocs.test;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.web.test.TestHelper;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.Enumeration;
import java.util.StringTokenizer;
import java.util.Random;
import java.util.Iterator;
import gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import java.util.Enumeration;
import java.util.StringTokenizer;
import java.util.Random;
import java.util.Iterator;
import gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import java.util.Enumeration;
import java.util.StringTokenizer;
import java.util.Random;
import java.util.Iterator;
import gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import java.util.Enumeration;
import java.util.StringTokenizer;
import java.util.Random;
import java.util.Iterator;
import gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;

public final class Debug_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(7);
    _jspx_dependants.add("/grnds-docs/test/DebugGlobalData.jsp");
    _jspx_dependants.add("/WEB-INF/impact.tld");
    _jspx_dependants.add("/grnds-docs/test/DebugRequestParameters.jsp");
    _jspx_dependants.add("/grnds-docs/test/DebugRequestAttributes.jsp");
    _jspx_dependants.add("/WEB-INF/debug.tld");
    _jspx_dependants.add("/grnds-docs/test/DebugStateAttributes.jsp");
    _jspx_dependants.add("/grnds-docs/test/DebugSessionAttributes.jsp");
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

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n");

  int debugGlobalDataRowCss=0;

      out.write("\r\n\r\n");
/********* BEGIN: GLOBAL DATA ***********/ 
      out.write("\r\n<br>\r\n");
      //  impact:ExpandableSectionTag
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
      _jspx_th_impact_ExpandableSectionTag_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_ExpandableSectionTag_0.setParent(null);
      _jspx_th_impact_ExpandableSectionTag_0.setName("GlobalData");
      _jspx_th_impact_ExpandableSectionTag_0.setLabel("Global Data");
      _jspx_th_impact_ExpandableSectionTag_0.setTabIndex(-1);
      int _jspx_eval_impact_ExpandableSectionTag_0 = _jspx_th_impact_ExpandableSectionTag_0.doStartTag();
      if (_jspx_eval_impact_ExpandableSectionTag_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n  <table border=\"0\" width=\"760\" cellSpacing=\"0\" cellPadding=\"3\" class=\"tableBorder\">\r\n    <tr class=\"subDetail\">\r\n      <th>Field Name</th>\r\n      <th>Field Value</th>\r\n      <th>Field Name</th>\r\n      <th>Field Value</th>\r\n    </tr>\r\n    ");

      boolean newRow = true;
      Map globalDataGetters = TestHelper.getGlobalDataGetters();
      Iterator nameIt = globalDataGetters.keySet().iterator();
      while( nameIt.hasNext() )
      {
        if( newRow )
        {
          
          out.write("<tr class=\"");
          out.print( FormattingHelper.getRowCss( debugGlobalDataRowCss++ ) );
          out.write('"');
          out.write('>');

        }
        String name = (String)nameIt.next();
        
          out.write("<td>");
          out.print(name);
          out.write("</td>");

        Method getMethod = (Method)globalDataGetters.get( name );
        Class returnType = getMethod.getReturnType();
        if( returnType == Integer.TYPE )
        {
          int intValue = (Integer) getMethod.invoke(null, new Object[] {request});
          
          out.write("\r\n            <td>");
          out.print(FormattingHelper.formatInt( intValue ));
          out.write("</td>\r\n          ");

        }
        else if( returnType == String.class )
        {
          String stringValue = (String)getMethod.invoke( null, request);
          
          out.write("\r\n            <td>");
          out.print(FormattingHelper.formatString( stringValue ));
          out.write("</td>\r\n          ");

        }
        else if( returnType == Boolean.TYPE )
        {
          boolean booleanValue = (Boolean) getMethod.invoke(null, new Object[] {request});
          
          out.write("\r\n            <td>");
          out.print(booleanValue ? "True" : "False");
          out.write("</td>\r\n          ");

        }
        else if( returnType ==  org.exolab.castor.types.Date.class )
        {
          org.exolab.castor.types.Date date = (org.exolab.castor.types.Date)getMethod.invoke( null,
                                                                                              request);
          
          out.write("\r\n            <td>");
          out.print(FormattingHelper.formatDate( date ));
          out.write("</td>\r\n          ");

        }
        if( newRow )
        {
          newRow = false;
        }
        else
        {
          newRow = true;
          
          out.write("</tr>");

        }
      }
      if( !newRow )
      {
        
          out.write("\r\n          <tr><td>&nbsp;</td><td>&nbsp;</td></tr>\r\n        ");

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
/********* END: GLOBAL DATA ***********/ 
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  int debugRequestParametersRowCss=0;

      out.write("\r\n\r\n");
/********* BEGIN: REQUEST PARAMETERS ***********/ 
      out.write("\r\n<br>\r\n");
      //  impact:ExpandableSectionTag
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
      _jspx_th_impact_ExpandableSectionTag_1.setPageContext(_jspx_page_context);
      _jspx_th_impact_ExpandableSectionTag_1.setParent(null);
      _jspx_th_impact_ExpandableSectionTag_1.setName("Request Parameters");
      _jspx_th_impact_ExpandableSectionTag_1.setLabel("Request Parameters");
      _jspx_th_impact_ExpandableSectionTag_1.setTabIndex(-1);
      int _jspx_eval_impact_ExpandableSectionTag_1 = _jspx_th_impact_ExpandableSectionTag_1.doStartTag();
      if (_jspx_eval_impact_ExpandableSectionTag_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
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
          int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_ExpandableSectionTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write('\r');
      out.write('\n');
/********* END: REQUEST PARAMETERS ***********/ 
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  int debugRequestAttributesRowCss=0;

      out.write("\r\n\r\n");
/********* BEGIN: REQUEST ATTRIBUTES ***********/ 
      out.write("\r\n<br>\r\n");
      //  impact:ExpandableSectionTag
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
      _jspx_th_impact_ExpandableSectionTag_2.setPageContext(_jspx_page_context);
      _jspx_th_impact_ExpandableSectionTag_2.setParent(null);
      _jspx_th_impact_ExpandableSectionTag_2.setName("Request Attributes");
      _jspx_th_impact_ExpandableSectionTag_2.setLabel("Request Attributes");
      _jspx_th_impact_ExpandableSectionTag_2.setTabIndex(-1);
      int _jspx_eval_impact_ExpandableSectionTag_2 = _jspx_th_impact_ExpandableSectionTag_2.doStartTag();
      if (_jspx_eval_impact_ExpandableSectionTag_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n  <table border=\"0\" width=\"760\" cellSpacing=\"0\" cellPadding=\"3\" class=\"tableBorder\">\r\n    <tr class=\"subDetail\">\r\n      <th>Attribute Name</th>\r\n      <th>Attribute Value</th>\r\n    </tr>\r\n    <tr class=\"");
          out.print( FormattingHelper.getRowCss( debugRequestAttributesRowCss++ ) );
          out.write("\">\r\n      <td align=\"top\">PageMode (in state)</td>\r\n      <td>");
          out.print( PageMode.getPageMode(request) );
          out.write("</td>\r\n    </tr>\r\n    ");

      Enumeration attributes = request.getAttributeNames();
      while ( attributes.hasMoreElements() )
      {
        String attName = (String) attributes.nextElement();
        Object attVal = request.getAttribute( attName );
        String attString ="";

    
          out.write("\r\n    <tr class=\"");
          out.print( FormattingHelper.getRowCss( debugRequestAttributesRowCss++ ) );
          out.write("\">\r\n      <td align=\"top\">\r\n      ");
          out.print( attName );
          out.write("\r\n      </td>\r\n      <td>\r\n      ");

        if (attVal instanceof String )
        {
          out.println ( (String) attVal );
        }
        else if (attVal instanceof XmlValueBean )
        {
        
          out.write("\r\n          ");
          //  debug:displayXmlValueBean
          gov.georgia.dhr.dfcs.sacwis.web.test.XmlValueBeanTag _jspx_th_debug_displayXmlValueBean_0 = new gov.georgia.dhr.dfcs.sacwis.web.test.XmlValueBeanTag();
          _jspx_th_debug_displayXmlValueBean_0.setPageContext(_jspx_page_context);
          _jspx_th_debug_displayXmlValueBean_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
          _jspx_th_debug_displayXmlValueBean_0.setXmlValueBean((XmlValueBean)attVal);
          int _jspx_eval_debug_displayXmlValueBean_0 = _jspx_th_debug_displayXmlValueBean_0.doStartTag();
          if (_jspx_th_debug_displayXmlValueBean_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        ");

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
            
          out.write("\r\n            <SCRIPT LANGUAGE=\"javascript\">\r\n              function ");
          out.print(functionName);
          out.write("()\r\n              {\r\n                var descriptor = \"\";\r\n                descriptor += \"width=450,\";\r\n                descriptor += \"height=600,\";\r\n                descriptor += \"channelmode=0,\";\r\n                descriptor += \"dependent=0,\";\r\n                descriptor += \"directories=0,\";\r\n                descriptor += \"fullscreen=0,\";\r\n                descriptor += \"location=0,\";\r\n                descriptor += \"menubar=0,\";\r\n                descriptor += \"resizable=1,\";\r\n                descriptor += \"scrollbars=1,\";\r\n                descriptor += \"status=0,\";\r\n                descriptor += \"toolbar=0\";\r\n                var newWindow = window.open( '', '_blank', descriptor );\r\n                newWindow.document.title.innerHTML = '\" + beanName + \".xml';\r\n                ");

                  StringTokenizer st = new StringTokenizer( attString, "\n\r\f", false );
                  while( st.hasMoreTokens() )
                  {
                    
          out.write("\r\n                      newWindow.document.write( '");
          out.print(st.nextToken());
          out.write("' );\r\n                    ");

                    if( st.hasMoreTokens() )
                    {
                      
          out.write("\r\n                        newWindow.document.writeln( '<br>' );\r\n                      ");

                    }
                  }
                
          out.write("\r\n              }\r\n            </SCRIPT>\r\n            <a onClick=\"hrefDirtyBypass=true;\" href=\"javascript:");
          out.print(functionName);
          out.write("()\">");
          out.print(shortAttString);
          out.write("</a>\r\n            ");

          }
          else
          {
            out.print( attString );
          }
        }
      
          out.write("\r\n      </td>\r\n    </tr>\r\n    ");

      }
    
          out.write("\r\n  </table>\r\n");
          int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_2.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_ExpandableSectionTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write('\r');
      out.write('\n');
/********* END: REQUEST ATTRIBUTES ***********/ 
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  int debugStateAttributesRowCss=0;

      out.write("\r\n\r\n");
/********* BEGIN: STATE ATTRIBUTES ***********/ 
      out.write('\r');
      out.write('\n');

  debugStateAttributesRowCss=0;

      out.write("\r\n<br>\r\n");
      //  impact:ExpandableSectionTag
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
      _jspx_th_impact_ExpandableSectionTag_3.setPageContext(_jspx_page_context);
      _jspx_th_impact_ExpandableSectionTag_3.setParent(null);
      _jspx_th_impact_ExpandableSectionTag_3.setName("State Attributes");
      _jspx_th_impact_ExpandableSectionTag_3.setLabel("State Attributes");
      _jspx_th_impact_ExpandableSectionTag_3.setTabIndex(-1);
      int _jspx_eval_impact_ExpandableSectionTag_3 = _jspx_th_impact_ExpandableSectionTag_3.doStartTag();
      if (_jspx_eval_impact_ExpandableSectionTag_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n  <table border=\"0\" width=\"760\" cellSpacing=\"0\" cellPadding=\"3\" class=\"tableBorder\">\r\n    <tr class=\"subDetail\">\r\n      <th>Attribute Name</th>\r\n      <th>Attribute Value</th>\r\n    </tr>\r\n    ");

      BaseSessionStateManager debugPageState = (BaseSessionStateManager) request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
      Iterator stateAttributes = debugPageState.getAttributeNames( request );
      while ( stateAttributes.hasNext() )
      {
        String attName = (String) stateAttributes.next();
        Object attVal = debugPageState.getAttribute( attName, request );
        String attString ="";

    
          out.write("\r\n    <tr class=\"");
          out.print( FormattingHelper.getRowCss( debugStateAttributesRowCss++ ) );
          out.write("\">\r\n      <td align=\"top\">\r\n      ");
          out.print( attName );
          out.write("\r\n      </td>\r\n      <td>\r\n      ");

        if (attVal == null)
        {
          out.println("null");
        }
        else if (attVal instanceof String )
        {
          out.println ( (String) attVal );
        }
        else if (attVal instanceof XmlValueBean )
        {
          attString = attVal.toString().replace('\n', ' ');
        
          out.write("\r\n          ");
          //  debug:displayXmlValueBean
          gov.georgia.dhr.dfcs.sacwis.web.test.XmlValueBeanTag _jspx_th_debug_displayXmlValueBean_1 = new gov.georgia.dhr.dfcs.sacwis.web.test.XmlValueBeanTag();
          _jspx_th_debug_displayXmlValueBean_1.setPageContext(_jspx_page_context);
          _jspx_th_debug_displayXmlValueBean_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
          _jspx_th_debug_displayXmlValueBean_1.setXmlValueBean((XmlValueBean)attVal);
          int _jspx_eval_debug_displayXmlValueBean_1 = _jspx_th_debug_displayXmlValueBean_1.doStartTag();
          if (_jspx_th_debug_displayXmlValueBean_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        ");

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
                case '\f':
                  sb.replace( i, i + 1, "&lt;br>" );
                  break;
                case '\r':
                  sb.replace( i, i + 1, "&lt;br>" );
                  break;
                case '\n':
                  sb.replace( i, i + 1, "&lt;br>" );
                  break;
              }
            }
            attString = sb.toString();
            
          out.write("\r\n            <SCRIPT LANGUAGE=\"javascript\">\r\n              function ");
          out.print(functionName);
          out.write("()\r\n              {\r\n                var descriptor = \"\";\r\n                descriptor += \"width=450,\";\r\n                descriptor += \"height=600,\";\r\n                descriptor += \"channelmode=0,\";\r\n                descriptor += \"dependent=0,\";\r\n                descriptor += \"directories=0,\";\r\n                descriptor += \"fullscreen=0,\";\r\n                descriptor += \"location=0,\";\r\n                descriptor += \"menubar=0,\";\r\n                descriptor += \"resizable=1,\";\r\n                descriptor += \"scrollbars=1,\";\r\n                descriptor += \"status=0,\";\r\n                descriptor += \"toolbar=0\";\r\n                var newWindow = window.open( '', '_blank', descriptor );\r\n                newWindow.document.title.innerHTML = '\" + beanName + \".xml';\r\n                ");

                  StringTokenizer st = new StringTokenizer( attString, "\n\r\f", false );
                  while( st.hasMoreTokens() )
                  {
                    
          out.write("\r\n                      newWindow.document.write( '");
          out.print(st.nextToken());
          out.write("' );\r\n                    ");

                    if( st.hasMoreTokens() )
                    {
                      
          out.write("\r\n                        newWindow.document.writeln( '<br>' );\r\n                      ");

                    }
                  }
                
          out.write("\r\n              }\r\n            </SCRIPT>\r\n            <a onClick=\"hrefDirtyBypass=true;\" href=\"javascript:");
          out.print(functionName);
          out.write("()\">");
          out.print(shortAttString);
          out.write("</a>\r\n            ");

          }
          else
          {
            out.print( attString );
          }
        }
      
          out.write("\r\n      </td>\r\n    </tr>\r\n    ");

      }
    
          out.write("\r\n  </table>\r\n");
          int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_3.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_ExpandableSectionTag_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write('\r');
      out.write('\n');
/********* END: STATE ATTRIBUTES ***********/ 
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  int debugSessionAttributesRowCss=0;

      out.write("\r\n\r\n");
/********* BEGIN: SESSION ATTRIBUTES ***********/ 
      out.write('\r');
      out.write('\n');

  debugSessionAttributesRowCss=0;

      out.write("\r\n<br>\r\n");
      //  impact:ExpandableSectionTag
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
      _jspx_th_impact_ExpandableSectionTag_4.setPageContext(_jspx_page_context);
      _jspx_th_impact_ExpandableSectionTag_4.setParent(null);
      _jspx_th_impact_ExpandableSectionTag_4.setName("Session Attributes");
      _jspx_th_impact_ExpandableSectionTag_4.setLabel("Session Attributes");
      _jspx_th_impact_ExpandableSectionTag_4.setTabIndex(-1);
      int _jspx_eval_impact_ExpandableSectionTag_4 = _jspx_th_impact_ExpandableSectionTag_4.doStartTag();
      if (_jspx_eval_impact_ExpandableSectionTag_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n  <table border=\"0\" width=\"760\" cellSpacing=\"0\" cellPadding=\"3\" class=\"tableBorder\">\r\n    <tr class=\"subDetail\">\r\n      <th>Attribute Name</th>\r\n      <th>Attribute Value</th>\r\n    </tr>\r\n    ");

      Enumeration sessionAttributes = session.getAttributeNames();
      while ( sessionAttributes.hasMoreElements() )
      {
        String attName = (String) sessionAttributes.nextElement();
        Object attVal = session.getAttribute( attName );
        String attString ="";

    
          out.write("\r\n    <tr class=\"");
          out.print( FormattingHelper.getRowCss( debugSessionAttributesRowCss++ ) );
          out.write("\">\r\n      <td align=\"top\">\r\n      ");
          out.print( attName );
          out.write("\r\n      </td>\r\n      <td>\r\n      ");

        if (attVal == null)
        {
          out.println("null");
        }
        else if (attVal instanceof String )
        {
          out.println ( (String) attVal );
        }
        else if (attVal instanceof XmlValueBean )
        {
          attString = attVal.toString().replace('\n', ' ');
        
          out.write("\r\n          ");
          //  debug:displayXmlValueBean
          gov.georgia.dhr.dfcs.sacwis.web.test.XmlValueBeanTag _jspx_th_debug_displayXmlValueBean_2 = new gov.georgia.dhr.dfcs.sacwis.web.test.XmlValueBeanTag();
          _jspx_th_debug_displayXmlValueBean_2.setPageContext(_jspx_page_context);
          _jspx_th_debug_displayXmlValueBean_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
          _jspx_th_debug_displayXmlValueBean_2.setXmlValueBean((XmlValueBean)attVal);
          int _jspx_eval_debug_displayXmlValueBean_2 = _jspx_th_debug_displayXmlValueBean_2.doStartTag();
          if (_jspx_th_debug_displayXmlValueBean_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        ");

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
            
          out.write("\r\n            <SCRIPT LANGUAGE=\"javascript\">\r\n              function ");
          out.print(functionName);
          out.write("()\r\n              {\r\n                var descriptor = \"\";\r\n                descriptor += \"width=450,\";\r\n                descriptor += \"height=600,\";\r\n                descriptor += \"channelmode=0,\";\r\n                descriptor += \"dependent=0,\";\r\n                descriptor += \"directories=0,\";\r\n                descriptor += \"fullscreen=0,\";\r\n                descriptor += \"location=0,\";\r\n                descriptor += \"menubar=0,\";\r\n                descriptor += \"resizable=1,\";\r\n                descriptor += \"scrollbars=1,\";\r\n                descriptor += \"status=0,\";\r\n                descriptor += \"toolbar=0\";\r\n                var newWindow = window.open( '', '_blank', descriptor );\r\n                newWindow.document.title.innerHTML = '\" + beanName + \".xml';\r\n                ");

                  StringTokenizer st = new StringTokenizer( attString, "\n\r\f", false );
                  while( st.hasMoreTokens() )
                  {
                    
          out.write("\r\n                      newWindow.document.write( '");
          out.print(st.nextToken());
          out.write("' );\r\n                    ");

                    if( st.hasMoreTokens() )
                    {
                      
          out.write("\r\n                        newWindow.document.writeln( '<br>' );\r\n                      ");

                    }
                  }
                
          out.write("\r\n              }\r\n            </SCRIPT>\r\n            <a onClick=\"hrefDirtyBypass=true;\" href=\"javascript:");
          out.print(functionName);
          out.write("()\">");
          out.print(shortAttString);
          out.write("</a>\r\n            ");

          }
          else
          {
            out.print( attString );
          }
        }
      
          out.write("\r\n      </td>\r\n    </tr>\r\n    ");

      }
    
          out.write("\r\n  </table>\r\n");
          int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_4.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_ExpandableSectionTag_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write('\r');
      out.write('\n');
/********* END: SESSION ATTRIBUTES ***********/ 
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
