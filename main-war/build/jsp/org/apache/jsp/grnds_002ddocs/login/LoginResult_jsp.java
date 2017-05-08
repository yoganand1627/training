package org.apache.jsp.grnds_002ddocs.login;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Iterator;
import java.util.List;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.TempAssignment;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;

public final class LoginResult_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  UserProfile user = UserProfileHelper.getUserProfile(request);

      out.write("\r\n<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n<tr>\r\n<td valign=\"top\">\r\n  <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n    <tr>\r\n      <td colspan=\"2\">\r\n        <h3>User Profile</h3>\r\n      </td>\r\n    </tr>\r\n\r\n\r\n    <tr>\r\n      <td>UserLogonID:\r\n      </td>\r\n      <td>");
out.println(user.getUserLogonID());
      out.write("\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td>UserID:\r\n      </td>\r\n      <td>");
out.println(String.valueOf(user.getUserID()));
      out.write("\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td>UserFullName:\r\n      </td>\r\n      <td>");
out.println(user.getUserFullName());
      out.write("\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td>UserRegion:\r\n      </td>\r\n      <td>");
out.println(user.getUserRegion());
      out.write("\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td>UserOfficeID:\r\n      </td>\r\n      <td>");
out.println(String.valueOf(user.getUserOfficeID()));
      out.write("\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td>UserOfficeCity:\r\n      </td>\r\n      <td>");
out.println(user.getUserOfficeCity());
      out.write("\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td>UserUnit:\r\n      </td>\r\n      <td>");
out.println(user.getUserUnit());
      out.write("\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td>UserProgram:\r\n      </td>\r\n      <td>");
out.println(user.getUserProgram());
      out.write("\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td>UserClass:\r\n      </td>\r\n      <td>");
out.println(user.getUserClass());
      out.write("\r\n      </td>\r\n    </tr>\r\n\r\n  </table>\r\n\r\n\r\n  <h3>Links</h3>\r\n  <a href=\"/resource/ResourceSearch/\">Go to Resource Directory</a> <br>\r\n  <a href=\"/common/Reports/\">Go to Reports</a> <br>\r\n  <a href=\"/login/Login/navigation\">Go to Navigation POC</a> <br>\r\n\r\n\r\n</td>\r\n<td valign=\"top\">\r\n  <h3>All User Rights</h3>\r\n\r\n  ");

    int[] rights = user.getRights();
    for (int i = 0; i < rights.length; i++) {
      out.println(String.valueOf(rights[i]));
    }

  
      out.write("\r\n  <form name=\"securityManager\" method=\"post\" action=\"/login/Login/securityManager\">\r\n    <input type=\"submit\" name=\"Change Security Attributes\" value=\"Change Security Attributes\"/><br>\r\n    ");

      //noinspection UnhandledExceptionInJSP
      Iterator it = Lookup.getCategoryListing("CSECATTR");
      int count = 0;
      while (it.hasNext()) {
        CodeAttributes ca = (CodeAttributes) it.next();
//  out.println(  ca.getDecode() + " " + rights[count] );
    
      out.write("\r\n    <input type=\"checkbox\" name=\"secAtt");
      out.print(count);
      out.write('"');
      out.write(' ');
      out.print((rights[count] == 1) ? "checked" : "");
      out.write(' ');
      out.write('/');
      out.write('>');
      out.print(count);
      out.write('.');
      out.write(' ');
      out.print(
    ca.getDecode() );
      out.write("<br>\r\n    ");

        count++;
      }
    
      out.write("\r\n    <input type=\"submit\" name=\"Change Security Attributes\" value=\"Change Security Attributes\"/>\r\n  </form>\r\n  <!--<h3>Temporary Assignments</h3>-->\r\n  ");

    List tempAssignments = user.getTempAssignments();

    if (tempAssignments != null) {
      Iterator tempIterator = tempAssignments.iterator();
      while (tempIterator.hasNext()) {
        TempAssignment ta = (TempAssignment) tempIterator.next();
        out.println(ta.getTempDesignatorID() + "<br>");
        out.println(ta.getTempFunction() + "<br>");
        out.println(ta.getTempSecurityClass() + "<br>");
        out.println(ta.getTempExpDate().toString() + "<br>");
        out.println("<br><br>");
      }
    }


  
      out.write("\r\n\r\n\r\n</td>\r\n</tr>\r\n</table>\r\n\r\n\r\n\r\n\r\n");
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
