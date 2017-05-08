package org.apache.jsp.grnds_002ddocs.test;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.web.test.TestHelper;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;

public final class DebugGlobalData_jsp extends org.apache.jasper.runtime.HttpJspBase
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
