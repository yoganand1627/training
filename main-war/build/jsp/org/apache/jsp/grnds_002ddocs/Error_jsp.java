package org.apache.jsp.grnds_002ddocs;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Date;
import org.grnds.facility.config.GrndsConfiguration;
import gov.georgia.dhr.dfcs.sacwis.core.exception.PrsException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.web.core.exception.handler.ExceptionHandler;
import gov.georgia.dhr.dfcs.sacwis.web.core.exception.handler.PrsExceptionHandler;
import gov.georgia.dhr.dfcs.sacwis.web.core.exception.handler.SpecificExceptionHandler;
import gov.georgia.dhr.dfcs.sacwis.web.core.exception.logging.ImpactExceptionLogRecord;
import gov.georgia.dhr.dfcs.sacwis.web.core.exception.logging.ImpactExceptionLoggingUtility;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;

public final class Error_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

private static final boolean DEBUG = "true"
        .equals(GrndsConfiguration.getInstance().getProperty(ArchitectureConstants.GRNDS_DOMAIN, "debugJSP"));


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

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n<html>\r\n  <head>\r\n    <title>ERROR Page</title>\r\n    <SCRIPT type=\"text/javascript\" src=\"/grnds-docs/js/shared/impact.js\"></script>\r\n    <LINK href=\"/grnds-docs/css/impact.css\" rel=stylesheet>\r\n  </head>\r\n\r\n  <body bgcolor=\"#FFFFFF\" text=\"#996666\" link=\"#FF0000\" alink=\"#FF9999\" vlink=\"#663333\">\r\n    ");
PrsException e = (PrsException) request.getAttribute(SpecificExceptionHandler.EXCEPTION_REQUEST_LOOKUP);
    String systemError = MessageLookup.getMessageByNumber( Messages.MSG_HELP_DESK_NO ); 

      out.write("\r\n    <table class=\"tableBorder\" width=\"780\" border=\"0\" cellspacing=\"0\" cellpadding=\"3\" bgcolor=\"#FFFFFF\">\r\n      <tr>\r\n        <td class=\"SecondLevel\" height=\"35\">\r\n          <div align=\"center\" class=\"errorTitle\">\r\n            SYSTEM ERROR\r\n          </div>\r\n        </td>\r\n      </tr>\r\n      <tr>\r\n        <td class=\"formErrorText\">\r\n          ");
      out.print(systemError);
      out.write("\r\n          ");
      out.write(" \r\n        </td>\r\n      </tr>\r\n      <tr>\r\n        <td class=\"formInfoText\">\r\n          UniqueID:\r\n          ");
      out.print(e.getUniqueId());
      out.write("\r\n          <br>\r\n          <br>\r\n          Exception:\r\n          ");
      out.print(e.getClass().getName());
      out.write("\r\n          <br>\r\n          <br>\r\n          Message:\r\n          ");
      out.print(e.getMessage());
      out.write("\r\n          <br>\r\n          <br>\r\n        </td>\r\n      </tr>\r\n      <tr>\r\n        <td class=\"formErrorText\">\r\n          The error occured at the following time:\r\n        </td>\r\n      </tr>\r\n      <tr>\r\n        <td class=\"formInfoText\">\r\n          ");
      out.print(new Date());
      out.write("\r\n        </td>\r\n      </tr>\r\n      <tr>\r\n        <td>\r\n          <br>\r\n          <br>\r\n        </td>\r\n      </tr>\r\n    </table>\r\n    <br>\r\n    <br>\r\n\r\n    <table border=\"0\" width=\"780\" cellSpacing=\"0\" cellPadding=\"3\" class=\"tableBorder\">\r\n      <tr>\r\n        <td>\r\n          ");
      //  impact:ExpandableSectionTag
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
      _jspx_th_impact_ExpandableSectionTag_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_ExpandableSectionTag_0.setParent(null);
      _jspx_th_impact_ExpandableSectionTag_0.setName("Error");
      _jspx_th_impact_ExpandableSectionTag_0.setId("errorDetail");
      _jspx_th_impact_ExpandableSectionTag_0.setLabel("Click for Stack Trace");
      _jspx_th_impact_ExpandableSectionTag_0.setTabIndex(1);
      int _jspx_eval_impact_ExpandableSectionTag_0 = _jspx_th_impact_ExpandableSectionTag_0.doStartTag();
      if (_jspx_eval_impact_ExpandableSectionTag_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n            ");
if (DEBUG && ImpactExceptionLoggingUtility.ERROR_LOGGING_ENABLED) {
        String idErrorString = (String) request
                                               .getAttribute(PrsExceptionHandler.BASE_PRS_EXCEPTION_LOG_RECORD_INDEX_KEY);
        ImpactExceptionLogRecord record = null;
        int idError;
        try {
          idError = Integer.parseInt(idErrorString);
        } catch (NumberFormatException nfe) {
          idError = -1;
          record = (ImpactExceptionLogRecord) request
                                                     .getAttribute(PrsExceptionHandler.BASE_PRS_EXCEPTION_LOG_RECORD_KEY);
        }
        if (idError >= 0) {

          
          out.write("\r\n            <SCRIPT type=\"text/javascript\" LANGUAGE=\"javascript\">\r\n    function openDetails(id)\r\n    {\r\n      var descriptor = \"\";\r\n      descriptor += \"width=800,\";\r\n      descriptor += \"height=600,\";\r\n      descriptor += \"channelmode=0,\";\r\n      descriptor += \"dependent=0,\";\r\n      descriptor += \"directories=0,\";\r\n      descriptor += \"fullscreen=0,\";\r\n      descriptor += \"location=0,\";\r\n      descriptor += \"menubar=0,\";\r\n      descriptor += \"resizable=1,\";\r\n      descriptor += \"scrollbars=1,\";\r\n      descriptor += \"status=0,\";\r\n      descriptor += \"toolbar=0\";\r\n      var newWindow = window.open('/grnds-docs/ErrorDetails.jsp?ID_ERROR=' + id, '_blank', descriptor);\r\n      newWindow.document.title.innerHTML = 'Error Details for ID_ERROR=' + id;\r\n    }\r\n  </SCRIPT>\r\n\r\n            <div>\r\n              <a href='javascript:openDetails( ");
          out.print(idError);
          out.write(" );'>Open System State Report</a>\r\n            </div>\r\n            <br>\r\n            <br>\r\n            ");
} else if (null != record) {
          if (session != null) {
            session.setAttribute(PrsExceptionHandler.BASE_PRS_EXCEPTION_LOG_RECORD_KEY, record);

          
          out.write("\r\n            <SCRIPT type=\"text/javascript\" LANGUAGE=\"javascript\">\r\n    function openDetails()\r\n    {\r\n      var descriptor = \"\";\r\n      descriptor += \"width=800,\";\r\n      descriptor += \"height=600,\";\r\n      descriptor += \"channelmode=0,\";\r\n      descriptor += \"dependent=0,\";\r\n      descriptor += \"directories=0,\";\r\n      descriptor += \"fullscreen=0,\";\r\n      descriptor += \"location=0,\";\r\n      descriptor += \"menubar=0,\";\r\n      descriptor += \"resizable=1,\";\r\n      descriptor += \"scrollbars=1,\";\r\n      descriptor += \"status=0,\";\r\n      descriptor += \"toolbar=0\";\r\n      var newWindow = window.open('/grnds-docs/ErrorDetails.jsp?useSession=true', '_blank', descriptor);\r\n      newWindow.document.title.innerHTML = 'Error Details for error information stored in session.';\r\n    }\r\n  </SCRIPT>\r\n\r\n            <div style=\"font-family: Arial, Helvetica, Verdana, sans-serif; font-size: 9pt;font-weight: bold;color: #FF0000\">\r\n              WARNING: Error information stored in session; information will be lost if the session is invalidated.\r\n");
          out.write("            </div>\r\n            <br>\r\n            <br>\r\n\r\n            <div>\r\n              <a href='javascript:openDetails();'>Open System State Report</a>\r\n            </div>\r\n            <br>\r\n            <br>\r\n            ");
}
        }
      }
      if (e instanceof ServiceException) {
        ServiceException se = (ServiceException) e;

        
          out.write("\r\n  Error Message Text : ");
          out.print(se.getErrorMessage());
          out.write("\r\n            <br>\r\n            <br>\r\n  Error Code: ");
          out.print(se.getErrorCode());
          out.write(' ');
          out.write('[');
          out.print(MessageLookup.getMessageByNumber(se.getErrorCode()));
          out.write("] <br>\r\n            <br>\r\n            ");
}
      Throwable t = (Throwable) e;

      
          out.write("\r\n  Stack Trace: ");
          out.print(ExceptionHandler.getStackTraceHTML(t));
          out.write("\r\n            <br>\r\n            <br>\r\n\r\n          ");
          int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_ExpandableSectionTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n        </td>\r\n      </tr>\r\n    </table>\r\n    ");
//Remove the exception b/c some exceptions cannot be encoded and it is not needed any longer.
      request.removeAttribute(SpecificExceptionHandler.EXCEPTION_REQUEST_LOOKUP);

    
      out.write("\r\n  </body>\r\n</html>\r\n");
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
