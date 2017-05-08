package org.apache.jsp.grnds_002ddocs.test;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.web.admin.OutputLaunchConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;

public final class NameHistoryIncluding_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n<html>\r\n<head>\r\n<title>\r\nName History Including page STUB\r\n</title>\r\n</head>\r\n<body>\r\n");
 String pageMode = "4";
      out.write("\r\n\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmNameHistSub");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/test/NameHistorySubmodTest/display");
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      _jspx_th_impact_validateForm_0.setRedisplayParameters("true");
      _jspx_th_impact_validateForm_0.setPageMode( pageMode );
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n");
String bIntakeIndicator = "Y";
          out.write("\r\n\r\n");
          //  impact:include
          gov.georgia.dhr.dfcs.sacwis.web.core.decorator.IncludeTag _jspx_th_impact_include_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.decorator.IncludeTag();
          _jspx_th_impact_include_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_include_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_include_0.setPage("/submodule/NameHistorySubmoduleConversation/displayNameHistory");
          _jspx_th_impact_include_0.setCallingPage("/test/NameHistorySubmodTest/display");
          _jspx_th_impact_include_0.setTabIndex(1);
          _jspx_th_impact_include_0.setIncludingForm("frmNameHistSub");
          int _jspx_eval_impact_include_0 = _jspx_th_impact_include_0.doStartTag();
          if (_jspx_eval_impact_include_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_include_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_include_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_include_0.doInitBody();
            }
            do {
              out.write("\r\n  ");
              //  impact:attribute
              gov.georgia.dhr.dfcs.sacwis.web.core.decorator.AttributeTag _jspx_th_impact_attribute_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.decorator.AttributeTag();
              _jspx_th_impact_attribute_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_attribute_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_include_0);
              _jspx_th_impact_attribute_0.setName("intakeIndicator");
              _jspx_th_impact_attribute_0.setValue( bIntakeIndicator );
              int _jspx_eval_impact_attribute_0 = _jspx_th_impact_attribute_0.doStartTag();
              if (_jspx_th_impact_attribute_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write('\r');
              out.write('\n');
              int evalDoAfterBody = _jspx_th_impact_include_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_include_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_include_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n<input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\"/>\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n</body>\r\n</html>\r\n");
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

  private boolean _jspx_meth_impact_validateErrors_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateErrors
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormErrorTag _jspx_th_impact_validateErrors_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormErrorTag();
    _jspx_th_impact_validateErrors_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateErrors_0.setParent(null);
    int _jspx_eval_impact_validateErrors_0 = _jspx_th_impact_validateErrors_0.doStartTag();
    if (_jspx_th_impact_validateErrors_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
