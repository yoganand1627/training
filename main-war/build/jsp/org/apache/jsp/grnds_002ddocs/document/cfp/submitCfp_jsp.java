package org.apache.jsp.grnds_002ddocs.document.cfp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.ServerSideValidationUtility;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.document.cfp.CfpConversation;
import gov.georgia.dhr.dfcs.sacwis.web.document.cfp.CfpConversation;

public final class submitCfp_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(2);
    _jspx_dependants.add("/WEB-INF/impact.tld");
    _jspx_dependants.add("/grnds-docs/document/cfp/OpenQueueStatus.jsp");
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

      out.write("\r\n\r\n\r\n\r\n");

String nextUrl =
  ContextHelper.getStringSafe(request,
                              ServerSideValidationUtility.FORM_VALIDATION_PREV_URL);

if (nextUrl.equals(CfpConversation.CASE_SUMMARY_STUB) == false)
{
  nextUrl = CfpConversation.URL_CASE_SUMMARY;
}

      out.write("\r\nIn a couple seconds, you will be forwarded back to the <a href=\"javascript:submitForm()\">Case Summary page.</a><br>\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("caseSummary");
      _jspx_th_impact_validateForm_0.setAction( nextUrl );
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setPageMode( PageModeConstants.EDIT );
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n  ");
          if (_jspx_meth_impact_hiddenFieldSessionStateManager_0(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n");
      out.write("\r\n\r\n\r\n");

//Matthew McClain 5/2/2003
//I could have made this a .js, but I didn't want to mess with the problem
//of the .js not loading before the button was clicked or the method was called.

      out.write("\r\n\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n<!--\r\nfunction openQueueStatus()\r\n{\r\n  //http://www.devguru.com/technologies/ecmascript/quickref/win_open.html\r\n  var width = 760;\r\n  var height = 350;\r\n  var left = screen.availWidth - width - 10;\r\n  var top = 0;\r\n  var queueStatus = window.open(\"");
      out.print( CfpConversation.QUEUE_STATUS );
      out.write("\",\r\n                                \"queueStatus\",\r\n                                \"menubar=no,\" +\r\n                                \"location=no,\" +\r\n                                \"resizable=yes,\" +\r\n                                \"scrollbars=yes,\" +\r\n                                \"width=\" + width + \",\" +\r\n                                \"height=\" + height + \",\" +\r\n                                \"left=\" + left + \",\" +\r\n                                \"top=\" + top);\r\n  queueStatus.focus();\r\n  return false;\r\n}\r\n//-->\r\n</script>\r\n");
      out.write("\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n<!--\r\nopenQueueStatus();\r\n\r\nfunction submitForm() {\r\n  document.all[\"caseSummary\"].submit();\r\n}\r\nsubmitForm();\r\n//-->\r\n</script>\r\n");
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

  private boolean _jspx_meth_impact_hiddenFieldSessionStateManager_0(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:hiddenFieldSessionStateManager
    gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateTag _jspx_th_impact_hiddenFieldSessionStateManager_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateTag();
    _jspx_th_impact_hiddenFieldSessionStateManager_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_hiddenFieldSessionStateManager_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    int _jspx_eval_impact_hiddenFieldSessionStateManager_0 = _jspx_th_impact_hiddenFieldSessionStateManager_0.doStartTag();
    if (_jspx_th_impact_hiddenFieldSessionStateManager_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
