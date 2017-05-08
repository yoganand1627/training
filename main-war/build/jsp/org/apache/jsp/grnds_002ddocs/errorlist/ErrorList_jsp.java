package org.apache.jsp.grnds_002ddocs.errorlist;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.utility.SerializationHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.errorlist.ErrorList;
import gov.georgia.dhr.dfcs.sacwis.web.core.errorlist.ErrorListMessage;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import java.util.List;

public final class ErrorList_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


  protected static String getUrl(String url, String linkTaskCode) {
    String linkUrl = url;
    linkUrl += "?taskCD=";

    if (linkTaskCode == null || "NULL".equalsIgnoreCase(linkTaskCode)) {
      return linkUrl + "NULL";
    }
    return linkUrl + linkTaskCode;
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

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n<html>\r\n<head>\r\n  <title>Error List Page</title>\r\n  <LINK href=\"/grnds-docs/css/impact.css\" rel=stylesheet>\r\n  <SCRIPT type=\"text/javascript\" src=\"/grnds-docs/js/shared/impact.js\"></script>\r\n</head>\r\n\r\n<body bgcolor=\"#FFFFFF\" text=\"#996666\" link=\"#FF0000\" alink=\"#FF9999\" vlink=\"#663333\">\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n  function callParent(url) {\r\n    self.opener.processErrorListSubmit(url);\r\n  }\r\n</script>\r\n<div id=\"errorList\" style=\"height:185px;width:528px;overflow:auto\" class=\"tableborderList\">\r\n  <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"3\">\r\n    <tr>\r\n      <th class=\"thList\">Error List - <span class=\"formInstruct\">Links may not work if you navigate away from the page before resolving errors.</span>\r\n      </th>\r\n    </tr>\r\n    ");

      int loopCount = 0;
      String serializedErrorList = ContextHelper.getStringSafe(request, ErrorList.ERROR_LIST_PARAM);
      if (StringHelper.isValid(serializedErrorList)) {
        List errorArray = (List) SerializationHelper.deserializeObject(serializedErrorList);
        int errorNum = errorArray.size();

        for (int i = 0; i < errorNum; i++) {
    
      out.write("\r\n    <tr ");
 if ( loopCount % 2 == 1 ) { 
      out.write("class=\"altcolor\"");
 } 
      out.write(" >\r\n      <td>\r\n        ");

          // cast as bean then call gets on bean
          ErrorListMessage errorListMessage = (ErrorListMessage) errorArray.get(i);
          String url = errorListMessage.getMsgURL();
          String taskCode = errorListMessage.getTaskCD();
          if (!"null".equals(url)) {
        
      out.write("\r\n        <span class=\"formErrorListText\">\r\n        <a href=\"#\" onClick=\"callParent('");
      out.print( getUrl( url, taskCode ) );
      out.write("');\">");
      out.print( errorListMessage.getErrorMessage() );
      out.write("\r\n        </a><br>\r\n        </span>\r\n\r\n        ");

        } else {
        
      out.write("\r\n        <span class=\"formErrorListText\">\r\n        ");
      out.print( errorListMessage.getErrorMessage() );
      out.write("<br>\r\n        </span>\r\n\r\n        ");

          }
        
      out.write("\r\n      </td>\r\n    </tr>\r\n    ");

        loopCount++;
      }
    } else {
    
      out.write("\r\n    <tr>\r\n      <td>\r\n        No error list messages found.\r\n      </td>\r\n    </tr>\r\n    ");

      }
    
      out.write("\r\n  </table>\r\n\r\n</div>\r\n<br>\r\n<br>\r\n\r\n<div align=\"center\">\r\n  <a href=\"javascript: window.close();\" tabIndex=\"1\">Close this page</a>\r\n</div>\r\n<br>\r\n");
      out.write("\r\n</body>\r\n</html>\r\n");
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
