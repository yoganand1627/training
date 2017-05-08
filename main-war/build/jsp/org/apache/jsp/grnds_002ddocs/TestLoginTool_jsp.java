package org.apache.jsp.grnds_002ddocs;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;

public final class TestLoginTool_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

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

      out.write("\r\n\r\n\r\n\r\n<html>\r\n<head>\r\n  <title>\r\n    Test Login Tool\r\n  </title>\r\n</head>\r\n\r\n<body>\r\n\r\n");

  //If a request has been submitted, try to authenticate to the specified server
  if (StringHelper.isValid(request.getParameter("username")) &&
      StringHelper.isValid(request.getParameter("password")) &&
      StringHelper.isValid(request.getParameter("authServer"))) {
    // FIXME: This needs to be written
    /*
    try
    {
      com.linar.jintegra.NTLMAuthenticate.validate(request.getParameter( "authServer" ),
          DOMAIN,
          request.getParameter( "username" ),
          request.getParameter( "password" ));
      out.println("Successful Connection to authentication server: " + request.getParameter( "authServer" ) + "<br>");
      out.println("Username and Password are valid.<br>");
    }
    //If successful connection to NT server and password is found to be invalid, throw the exception.
    catch (SecurityException se)
    {
      out.println("Successfully connected to authentication server: " + request.getParameter( "authServer" ) );
      out.println("<br>Security Exception. Invalid username or password.");

    }
    //If there was an error connecting to the NT PDC(Authentication Server), try a different server.
    catch (IOException e)
    {
      out.println("Could not connect to authentication server: " + request.getParameter( "authServer" ) );
    }
    */
  } else if (StringHelper.isValid(request.getParameter("changeAuth"))) {
    //Switch the value of the indicator
    //noinspection AssignmentToStaticFieldFromInstanceMethod
    UserProfileHelper.ACTIVE_DIRECTORY_AUTH = !UserProfileHelper.ACTIVE_DIRECTORY_AUTH;
  }


      out.write("\r\n<h1>\r\n  Test Authentication\r\n</h1>\r\n\r\n<form action=\"#\" method=\"post\">\r\n  <br>\r\n  UserName: <input type=\"text\" name=\"username\"><br>\r\n  Password: <input type=\"password\" name=\"password\"><br>\r\n  <br>\r\n  <select name=\"authServer\">\r\n    ");

      for (int i = 0; i < 3; i++) {
        out.println("<option value=\"" + UserProfileHelper.SUN_SERVER_IP[i] + "\">Server " +
                    (i + 1) + " IP: " + UserProfileHelper.SUN_SERVER_IP[i] + "</option>");
      }
    
      out.write("\r\n  </select>\r\n  <br>\r\n  <input type=\"submit\" name=\"Submit\" value=\"Submit\">\r\n  <input type=\"reset\" value=\"Reset\">\r\n</form>\r\n<br/>\r\n\r\n<form action=\"#\" method=\"post\">\r\n  <br>\r\n  Current Authentication: ");
      out.print( UserProfileHelper.ACTIVE_DIRECTORY_AUTH ? "Active Directory" : "NTLM"  );
      out.write("\r\n  <br>\r\n  <input type=\"submit\" name=\"changeAuth\" value=\"Change Auth\"><br>\r\n</form>\r\n\r\n</body>\r\n</html>\r\n");
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
