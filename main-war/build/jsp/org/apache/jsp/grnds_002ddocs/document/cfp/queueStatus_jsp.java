package org.apache.jsp.grnds_002ddocs.document.cfp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import org.grnds.facility.config.GrndsConfiguration;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.dao.document.cfp.CfpStatusDB;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BasePrsConversation;
import gov.georgia.dhr.dfcs.sacwis.web.document.cfp.CfpConversation;

public final class queueStatus_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


  protected static final String CFP_HTTP_FILE_LOCATION =
          GrndsConfiguration.getInstance().getProperty(ArchitectureConstants.GRNDS_DOMAIN, "cfp.http.file.location");

  /**
   * Derived value based on Path.
   * Location to serve up cfp document via http.
   */
  public String getHttpPath(String path) {
    if (path == null) {
      return null;
    }
    int index = path.replace('\\', '/').lastIndexOf("/");
    return CFP_HTTP_FILE_LOCATION + path.substring(index + 1);
  }

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

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  try {
    // Set character encoding before printing anything out; this MUST
    response.setContentType("text/html; charset=" + ArchitectureConstants.CHARACTER_ENCODING);

    List list = (List)
            request.getAttribute(CfpConversation.QUEUE_STATUS_DATABEAN);

    int userId = BasePrsConversation.getUserID(request);
    int tabIndex = 1;
    String formName = "queueStatus";

      out.write("\r\n<html>\r\n<head>\r\n  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=");
      out.print(ArchitectureConstants.CHARACTER_ENCODING);
      out.write("\">\r\n  <title>Case File Print - Queue Viewer</title>\r\n  <link href=\"/grnds-docs/css/impact.css\" rel=stylesheet>\r\n  <script src=\"/grnds-docs/js/shared/impact.js\" type=\"text/javascript\"></script>\r\n</head>\r\n\r\n");
      out.write("\r\n<body bgcolor=\"#FFFFFF\" text=\"#996666\" link=\"#FF0000\" alink=\"#FF9999\" vlink=\"#663333\">\r\n\r\n\r\n");
      out.write("\r\n<!-- BEGIN HiddenFieldState form -->\r\n<form name=\"hiddenFieldStateForm\" action=\"#\">\r\n  <input type=\"hidden\" name=\"requestStartTime\" value='");
      out.print(request.getParameter("requestStartTime") );
      out.write("'>\r\n  <input type=\"hidden\" name=\"requestTotalTime\">\r\n  ");
      if (_jspx_meth_impact_hiddenFieldSessionStateManager_0(_jspx_page_context))
        return;
      out.write("\r\n  <input type=\"hidden\" name=\"bSubmitted\" value=\"false\">\r\n</form>\r\n<!-- END HiddenFieldState form -->\r\n\r\n\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n  <!--Insert Java Script here\r\n  function cancelCfp(cfpId)\r\n  {\r\n    document.all[\"");
      out.print( formName );
      out.write("\"].cfpId.value = cfpId;\r\n    disableValidation(\"");
      out.print( formName );
      out.write("\");\r\n    submitValidateForm('");
      out.print( formName );
      out.write("', '");
      out.print( CfpConversation.CANCEL_CFP );
      out.write("');\r\n    return false;\r\n  }\r\n\r\n\r\n  function refresh()\r\n  {\r\n    disableValidation(\"");
      out.print( formName );
      out.write("\");\r\n    submitValidateForm('");
      out.print( formName );
      out.write("', '");
      out.print( CfpConversation.QUEUE_STATUS );
      out.write("');\r\n    return false;\r\n  }\r\n  //http://developer.irt.org/script/1563.htm\r\n  //refresh after 30 seconds\r\n  setTimeout('refresh()', (30 * 1000));\r\n  //-->\r\n</script>\r\n\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write("\r\n\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName( formName );
      _jspx_th_impact_validateForm_0.setAction("/not/a/real/path");
      _jspx_th_impact_validateForm_0.setDefaultButton("true");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setPageMode( PageModeConstants.EDIT );
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n");
          //  impact:pagination
          gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag _jspx_th_impact_pagination_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag();
          _jspx_th_impact_pagination_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_pagination_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_pagination_0.setSubmitUrl( CfpConversation.QUEUE_STATUS );
          _jspx_th_impact_pagination_0.setSaveState("false");
          int _jspx_eval_impact_pagination_0 = _jspx_th_impact_pagination_0.doStartTag();
          if (_jspx_eval_impact_pagination_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\r\n  <table cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorderList\">\r\n    <tr>\r\n      <th class=\"thList\"><nobr>Staff Name</nobr></th>\r\n      <th class=\"thList\"><nobr>Case Name</nobr></th>\r\n      <th class=\"thList\">Status</th>\r\n      <th class=\"thList\">Case ID</th>\r\n      <th class=\"thList\">Stage</th>\r\n      <th class=\"thList\">Progress</th>\r\n      <th class=\"thList\">Submitted&nbsp;&nbsp;</th>\r\n      <th class=\"thList\">Completed&nbsp;&nbsp;</th>\r\n      <th class=\"thList\">Message/Cancel</th>\r\n      <!--      <th class=\"thList\">Cancel</th> -->\r\n    </tr>\r\n    ");

      int i = -1;

      Iterator iterator = list.iterator();
      while (iterator.hasNext()) {
        CfpStatusDB cfpStatus = (CfpStatusDB) iterator.next();

        i++;
        String trClass = "odd";
        if (i % 2 == 1) {
          trClass = "even";
        }

        String errorDescription = "&nbsp;";
        if (cfpStatus.isComplete()) {
          errorDescription = "Success";
        }
        if (cfpStatus.isError()) {
          errorDescription = cfpStatus.getErrorDescription();
        }

        String completionTime = "&nbsp;";
        if (cfpStatus.isError() ||
            cfpStatus.isComplete()) {
          completionTime = cfpStatus.getCompletionTime();
        }
    
              out.write("\r\n    <tr class=\"");
              out.print( trClass );
              out.write("\">\r\n      <td>");
              out.print( cfpStatus.getStaffName() );
              out.write("</td>\r\n\r\n      ");
              //  impact:if
              gov.georgia.dhr.dfcs.sacwis.web.core.state.IfTag _jspx_th_impact_if_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfTag();
              _jspx_th_impact_if_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_if_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_if_0.setTest( ((cfpStatus.getPersonId() == userId) && (cfpStatus.isComplete())) );
              int _jspx_eval_impact_if_0 = _jspx_th_impact_if_0.doStartTag();
              if (_jspx_eval_impact_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n        ");
                  //  impact:then
                  gov.georgia.dhr.dfcs.sacwis.web.core.state.ThenTag _jspx_th_impact_then_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.ThenTag();
                  _jspx_th_impact_then_0.setPageContext(_jspx_page_context);
                  _jspx_th_impact_then_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_if_0);
                  int _jspx_eval_impact_then_0 = _jspx_th_impact_then_0.doStartTag();
                  if (_jspx_eval_impact_then_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                    do {
                      out.write("\r\n          <td><a tabIndex=\"");
                      out.print( tabIndex++ );
                      out.write("\"\r\n                 target=\"_blank\"\r\n                 href=\"");
                      out.print( getHttpPath(cfpStatus.getPath()) );
                      out.write('"');
                      out.write('>');
                      out.print( cfpStatus.getCaseName() );
                      out.write("</a></td>\r\n        ");
                      int evalDoAfterBody = _jspx_th_impact_then_0.doAfterBody();
                      if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                        break;
                    } while (true);
                  }
                  if (_jspx_th_impact_then_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n        ");
                  //  impact:else
                  gov.georgia.dhr.dfcs.sacwis.web.core.state.ElseTag _jspx_th_impact_else_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.ElseTag();
                  _jspx_th_impact_else_0.setPageContext(_jspx_page_context);
                  _jspx_th_impact_else_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_if_0);
                  int _jspx_eval_impact_else_0 = _jspx_th_impact_else_0.doStartTag();
                  if (_jspx_eval_impact_else_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                    do {
                      out.write("\r\n          <td>");
                      out.print( cfpStatus.getCaseName() );
                      out.write("</td>\r\n        ");
                      int evalDoAfterBody = _jspx_th_impact_else_0.doAfterBody();
                      if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                        break;
                    } while (true);
                  }
                  if (_jspx_th_impact_else_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n      ");
                  int evalDoAfterBody = _jspx_th_impact_if_0.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\r\n      <td>");
              out.print( cfpStatus.getDescriptiveStatus() );
              out.write("</td>\r\n      <td>");
              out.print( cfpStatus.getCaseId() );
              out.write("</td>\r\n      <td>");
              out.print( cfpStatus.getStageCode() );
              out.write("</td>\r\n      <td>");
              out.print( cfpStatus.getProgress() );
              out.write("</td>\r\n      <td>");
              out.print( cfpStatus.getSubmissionTime() );
              out.write("</td>\r\n      <td>");
              out.print( completionTime );
              out.write("</td>\r\n      <!--      <td>");
              out.print( errorDescription );
              out.write("</td> -->\r\n\r\n      ");
              //  impact:if
              gov.georgia.dhr.dfcs.sacwis.web.core.state.IfTag _jspx_th_impact_if_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfTag();
              _jspx_th_impact_if_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_if_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_if_1.setTest( ((cfpStatus.getPersonId() == userId) && (cfpStatus.isSubmitted())) );
              int _jspx_eval_impact_if_1 = _jspx_th_impact_if_1.doStartTag();
              if (_jspx_eval_impact_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n        ");
                  //  impact:then
                  gov.georgia.dhr.dfcs.sacwis.web.core.state.ThenTag _jspx_th_impact_then_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.ThenTag();
                  _jspx_th_impact_then_1.setPageContext(_jspx_page_context);
                  _jspx_th_impact_then_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_if_1);
                  int _jspx_eval_impact_then_1 = _jspx_th_impact_then_1.doStartTag();
                  if (_jspx_eval_impact_then_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                    do {
                      out.write("\r\n          <td><a href='javascript:cancelCfp(\"");
                      out.print( cfpStatus.getStatusId() );
                      out.write("\")'\r\n                 tabIndex=\"");
                      out.print( tabIndex++ );
                      out.write("\">Cancel</a></td>\r\n        ");
                      int evalDoAfterBody = _jspx_th_impact_then_1.doAfterBody();
                      if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                        break;
                    } while (true);
                  }
                  if (_jspx_th_impact_then_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n        ");
                  //  impact:else
                  gov.georgia.dhr.dfcs.sacwis.web.core.state.ElseTag _jspx_th_impact_else_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.ElseTag();
                  _jspx_th_impact_else_1.setPageContext(_jspx_page_context);
                  _jspx_th_impact_else_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_if_1);
                  int _jspx_eval_impact_else_1 = _jspx_th_impact_else_1.doStartTag();
                  if (_jspx_eval_impact_else_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                    do {
                      out.write("\r\n          <td>");
                      out.print( errorDescription );
                      out.write("</td>\r\n          <!-- <td>&nbsp;</td> -->\r\n        ");
                      int evalDoAfterBody = _jspx_th_impact_else_1.doAfterBody();
                      if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                        break;
                    } while (true);
                  }
                  if (_jspx_th_impact_else_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n      ");
                  int evalDoAfterBody = _jspx_th_impact_if_1.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_if_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </tr>\r\n    ");

      }
    
              out.write("\r\n  </table>\r\n");
              int evalDoAfterBody = _jspx_th_impact_pagination_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_pagination_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n<table width=\"100%\" cellpadding=\"3\" cellspacing=\"0\">\r\n  <tr>\r\n    <td align=\"right\">\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("Refresh");
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_ButtonTag_0.setFunction("return refresh();");
          _jspx_th_impact_ButtonTag_0.setAction("/not/a/real/path");
          _jspx_th_impact_ButtonTag_0.setForm( formName );
          _jspx_th_impact_ButtonTag_0.setImg("btnRefresh");
          _jspx_th_impact_ButtonTag_0.setEditableMode( EditableMode.EDIT );
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n\r\n");
          if (_jspx_meth_impact_validateInput_0(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n<input type=\"hidden\" name=\"");
          out.print( HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY );
          out.write("\">\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n\r\n</body>\r\n</html>\r\n\r\n");

  }
  catch (Throwable e) {
    out.println("<pre>");
    e.printStackTrace(new PrintWriter(out));
    out.println("</pre>");
  }

      out.write("\r\n\r\n");
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

  private boolean _jspx_meth_impact_hiddenFieldSessionStateManager_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:hiddenFieldSessionStateManager
    gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateTag _jspx_th_impact_hiddenFieldSessionStateManager_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateTag();
    _jspx_th_impact_hiddenFieldSessionStateManager_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_hiddenFieldSessionStateManager_0.setParent(null);
    int _jspx_eval_impact_hiddenFieldSessionStateManager_0 = _jspx_th_impact_hiddenFieldSessionStateManager_0.doStartTag();
    if (_jspx_th_impact_hiddenFieldSessionStateManager_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
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

  private boolean _jspx_meth_impact_validateInput_0(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_0.setType("hidden");
    _jspx_th_impact_validateInput_0.setName("cfpId");
    int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
    if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
