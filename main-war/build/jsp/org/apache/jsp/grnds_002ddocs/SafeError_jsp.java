package org.apache.jsp.grnds_002ddocs;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.lang.reflect.Method;
import java.util.Date;
import gov.georgia.dhr.dfcs.sacwis.core.exception.BasePrsException;

public final class SafeError_jsp extends org.apache.jasper.runtime.HttpJspBase
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


/**  JSP Name:     IMPACT Error page
*  Created by:   Brad Eilers
*  Date Created: 19 July 2002
*
*  Description:
*  This page can be used to display minimal error information in cases where
*  we need to forward directly to a JSP vs. using a servlet.  The JSP should
*  be safer and be able to handle system errors more easily.
*
*  Change History:
*  Date          User        Description
*  ----------    ----------  --------------------------------------------
*  03/22/2004    EILERSBE    Initial creation.
*
*/

      out.write("\r\n\r\n\r\n\r\n\r\n<html>\r\n<head>\r\n  <title>ERROR Page</title>\r\n  <SCRIPT src=\"/grnds-docs/js/shared/impact.js\"></script>\r\n  <LINK href=\"/grnds-docs/css/impact.css\" rel=stylesheet>\r\n</head>\r\n<body bgcolor=\"#FFFFFF\" text=\"#996666\" link=\"#FF0000\" alink=\"#FF9999\" vlink=\"#663333\">\r\n");

  try  // Global try-catch block
  {

      out.write("\r\n\r\n  <table width=\"780\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\"  background=\"/grnds-docs/images/bg.gif\" >\r\n    <tr>\r\n      <td class=\"SecondLevelSides\" height=\"35\" width=\"2\">&nbsp;</td>\r\n      <td class=\"SecondLevel\" height=\"35\" width=\"776\">\r\n        <div align=\"center\" class=\"errorTitle\">IMPACT ERROR</div>\r\n      </td>\r\n      <td class=\"SecondLevelSides\" height=\"35\" width=\"2\">&nbsp;</td>\r\n    </tr>\r\n    <tr>\r\n      <td colspan=\"3\">\r\n      <br><br>\r\n        <table class=\"tableBorder\" align=\"center\" border=\"0\" cellpadding=\"5\" cellspacing=\"0\" width=\"760\">\r\n          <tr>\r\n            <th height=\"20\">The system has generated an error.</th>\r\n          </tr>\r\n          <tr>\r\n            <td class=\"formErrorText\">\r\n              An error has occurred in IMPACT.  Please contact the Customer Service Center at (877) 642-4777 and provide them with the following information:\r\n            </td>\r\n          </tr>\r\n          <tr>\r\n            <td  class=\"formInfoText\">\r\n              UniqueID:  ");
      out.print( request.getParameter( "uniqueID" ) );
      out.write(" <br><br>\r\n              Exception: ");
      out.print( request.getParameter( "errorName" ) );
      out.write(" <br><br>\r\n              Message:   ");
      out.print(request.getParameter( "message" ) );
      out.write(" <br><br>\r\n            </td>\r\n          </tr>\r\n          <tr>\r\n            <td class=\"formErrorText\">The error occured at the following time:</td>\r\n          </tr>\r\n          <tr>\r\n            <td class=\"formInfoText\">");
      out.print(new Date());
      out.write("</td>\r\n          </tr>\r\n          <tr><td><br><br></td></tr>\r\n        </table>\r\n        <br><br><br>\r\n      </td>\r\n    </tr>\r\n  </table>\r\n  <table width=\"780\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"  background=\"/grnds-docs/images/metaphor/SACWIS_Footer.jpg\">\r\n    <tr><td>&nbsp;</td></tr>\r\n  </table>\r\n  <br><br>\r\n");

  }
  catch (Throwable throwable) //global try-catch block
  {
    out.println("<h2>Your JSP generated an exception: </h2>");
    // Attempt to loop through and recursively unwrap the root causes of exceptions
    StringBuffer sb = new StringBuffer();
    sb.append( " " );
    do
    {
      sb.insert( 0, "\n</pre>\n" );
      sb.insert( 0, BasePrsException.getStackTrace( throwable ) );
      sb.insert( 0, "\n<pre>\n" );
      // This try attempts to execute the "getRootCause" method on the exception using reflection.
      try
      {
        throwable = (Throwable) throwable.getClass().getMethod( "getRootCause" ).invoke( throwable );
      }
      catch( NoSuchMethodException nsme )
      {
        try
        {
          // Check to see if there is a getEnclosedError method (if this is wrapped by GrndsException, there might be.
          throwable = (Throwable) throwable.getClass().getMethod( "getEnclosedError" ).invoke( throwable );
        }
        catch( NoSuchMethodException nsme1 )
        {
          try
          {
            throwable = (Throwable) throwable.getClass().getMethod( "getThrowable" ).invoke( throwable );
          }
          catch( NoSuchMethodException nsme2 )
          {
            try
            {
              // none of the known methods to extract wrapped exceptions exist; loop through the methods that the
              // object does have to find one that returns Throwable
              Method[] methods = throwable.getClass().getMethods();
              Throwable newThrowable = null;
              for( int i = 0; i < methods.length; i++ )
              {
                Method method = methods[i];
                Class returnType = method.getReturnType();
                if( throwable.getClass().isAssignableFrom( returnType )
                    && method.getParameterTypes().length == 0 )
                {
                  newThrowable = (Throwable) method.invoke( throwable );
                }
              }
              throwable = newThrowable;
            }
            catch( Throwable throwable1)
            {
              // There is no wrapped exception; end the loop by setting e to null
              throwable = null;
            }
          }
        }
      }
      catch( ClassCastException cce )
      {
        // The wrapped Throwable is not Throwable or a subclass of Throwable (this should never happen).
        // Set throwable to null to end the loop.
        throwable = null;
      }
      if( throwable != null )
      {
        sb.insert( 0, "\nWas the cause of:\n" );
      }
    }
    while( throwable != null );
    out.println(sb.toString());
  }

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
