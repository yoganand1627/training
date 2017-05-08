package org.apache.jsp.grnds_002ddocs;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Legend_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n\r\n");
      if (_jspx_meth_impact_setAttribute_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_impact_setAttribute_1(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');

  String legend1 = (String)request.getAttribute( "Legend1" );
  String legend2 = (String)request.getAttribute( "Legend2" );

      out.write('\r');
      out.write('\n');
 
//*  JSP Name:     Legend
//*  Created by:   Stephan Brauchli
//*  Date Created: 11/04/02
//*
//*  Description:
//*  This JSP is used to case on the legend attributes set in a JSP's 
//*  ScreenDefinitions xml file to determine what data to display.
//*
//*  Values Supported:
//*  condRequired
//*  required
//*  newStage
//*  Reporter
//*  New Case or New Stage
//*  Superintendent
//*  Submitted Events
//*  Returned is Created
//*  
//*  
 
      out.write("\r\n<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\r\n");

  for( int i = 0; i < 2; i++ )
  {
    String legend = legend1;
  if( i == 1 )
  {
    legend = legend2;
  }
  if( legend == null )
  {
    legend  = "";

      out.write("\r\n  <tr>\r\n    <td>&nbsp;</td>\r\n    </tr>\r\n");

  }
  if ("required".equals(legend) )
    {

      out.write("\r\n  <tr>\r\n    <td class=\"requiredInst\"><span class=\"formRequiredText\">*</span>&nbsp;required field</td>\r\n    </tr>\r\n");

    }
    else if ("condRequired".equals(legend)  )
    {

      out.write("\r\n    <tr>\r\n      <td class=\"requiredInst\">\r\n      <span class=\"formCondRequiredText\">&#135;</span>&nbsp;conditionally required field\r\n    </td>\r\n    </tr>\r\n");

    }
    else if ("newStage".equals(legend)  )
    {

      out.write("\r\n  <tr>\r\n    <td class=\"requiredInst\"><span class=\"formBoldedText\">#</span>&nbsp;New Assignment</td>\r\n    </tr>\r\n");

    }
    else if ("Reporter".equals(legend)  )
    {

      out.write("\r\n  <tr>\r\n    <td class=\"requiredInst\"><span class=\"formBoldedText\">#</span>&nbsp;Reporter</td>\r\n    </tr>\r\n");

    }
    else if ("New Case or New Stage".equals(legend)  )
    {

      out.write("\r\n  <tr>\r\n    <td class=\"requiredInst\"><span class=\"formBoldedText\">#</span>&nbsp;New Case or New Stage of Case</td>\r\n    </tr>\r\n");

    }
    else if ("Superintendent".equals(legend)  )
    {

      out.write("\r\n  <tr>\r\n    <td class=\"requiredInst\"><span class=\"formBoldedText\">&clubs;</span>&nbsp;Superintendent (APS)</td>\r\n    </tr>\r\n");

    }
    else if ("Submitted Events".equals(legend)  )
    {

      out.write("\r\n  <tr>\r\n    <td class=\"requiredInst\"><span class=\"formBoldedText\">#</span>&nbsp;Submitted Events</td>\r\n    </tr>\r\n");

    }
    else if ("Returned is Created".equals(legend)  )
    {

      out.write("\r\n  <tr>\r\n    <td class=\"requiredInst\"><span class=\"formBoldedText\">#</span>&nbsp;Person Returned is Same Person just created</td>\r\n    </tr>\r\n");
   }
  }

      out.write("\r\n</table> \r\n");
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

  private boolean _jspx_meth_impact_setAttribute_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:setAttribute
    gov.georgia.dhr.dfcs.sacwis.web.core.decorator.SetTabTag _jspx_th_impact_setAttribute_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.decorator.SetTabTag();
    _jspx_th_impact_setAttribute_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_setAttribute_0.setParent(null);
    _jspx_th_impact_setAttribute_0.setParameter("Legend1");
    int _jspx_eval_impact_setAttribute_0 = _jspx_th_impact_setAttribute_0.doStartTag();
    if (_jspx_th_impact_setAttribute_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_setAttribute_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:setAttribute
    gov.georgia.dhr.dfcs.sacwis.web.core.decorator.SetTabTag _jspx_th_impact_setAttribute_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.decorator.SetTabTag();
    _jspx_th_impact_setAttribute_1.setPageContext(_jspx_page_context);
    _jspx_th_impact_setAttribute_1.setParent(null);
    _jspx_th_impact_setAttribute_1.setParameter("Legend2");
    int _jspx_eval_impact_setAttribute_1 = _jspx_th_impact_setAttribute_1.doStartTag();
    if (_jspx_th_impact_setAttribute_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
