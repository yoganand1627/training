package org.apache.jsp.grnds_002ddocs;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.web.core.decorator.ScreenDefinitionsXmlDao;

public final class Submodule_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n\r\n\r\n");

  // Submodule try-catch block
  try {

      out.write("\r\n<!--- BEGIN HtmlBody insertion (Submodule.jsp) --->\r\n");
      if (_jspx_meth_impact_insert_0(_jspx_page_context))
        return;
      out.write("\r\n<!--- END HtmlBody insertion (Submodule.jsp) --->\r\n");

  } catch (Exception e) {
    throw new JspException("Error in Submodule '" + request.getAttribute(
            ScreenDefinitionsXmlDao.SCREEN) + "':" + e.getMessage(), e);
  }

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

  private boolean _jspx_meth_impact_insert_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:insert
    gov.georgia.dhr.dfcs.sacwis.web.core.decorator.InsertTag _jspx_th_impact_insert_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.decorator.InsertTag();
    _jspx_th_impact_insert_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_insert_0.setParent(null);
    _jspx_th_impact_insert_0.setParameter("HtmlBody");
    int _jspx_eval_impact_insert_0 = _jspx_th_impact_insert_0.doStartTag();
    if (_jspx_th_impact_insert_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
