<%
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
%>
<%@ page import="java.lang.reflect.Method"%>
<%@ page import="java.util.Date"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.exception.BasePrsException"%>

<html>
<head>
  <title>ERROR Page</title>
  <SCRIPT src="/grnds-docs/js/shared/impact.js"></script>
  <LINK href="/grnds-docs/css/impact.css" rel=stylesheet>
</head>
<body bgcolor="#FFFFFF" text="#996666" link="#FF0000" alink="#FF9999" vlink="#663333">
<%
  try  // Global try-catch block
  {
%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>
  <table width="780" border="0" cellspacing="0" cellpadding="0"  background="/grnds-docs/images/bg.gif" >
    <tr>
      <td class="SecondLevelSides" height="35" width="2">&nbsp;</td>
      <td class="SecondLevel" height="35" width="776">
        <div align="center" class="errorTitle">IMPACT ERROR</div>
      </td>
      <td class="SecondLevelSides" height="35" width="2">&nbsp;</td>
    </tr>
    <tr>
      <td colspan="3">
      <br><br>
        <table class="tableBorder" align="center" border="0" cellpadding="5" cellspacing="0" width="760">
          <tr>
            <th height="20">The system has generated an error.</th>
          </tr>
          <tr>
            <td class="formErrorText">
              An error has occurred in IMPACT.  Please contact the Customer Service Center at (877) 642-4777 and provide them with the following information:
            </td>
          </tr>
          <tr>
            <td  class="formInfoText">
              UniqueID:  <%= request.getParameter( "uniqueID" ) %> <br><br>
              Exception: <%= request.getParameter( "errorName" ) %> <br><br>
              Message:   <%=request.getParameter( "message" ) %> <br><br>
            </td>
          </tr>
          <tr>
            <td class="formErrorText">The error occured at the following time:</td>
          </tr>
          <tr>
            <td class="formInfoText"><%=new Date()%></td>
          </tr>
          <tr><td><br><br></td></tr>
        </table>
        <br><br><br>
      </td>
    </tr>
  </table>
  <table width="780" cellpadding="0" cellspacing="0" border="0"  background="/grnds-docs/images/metaphor/SACWIS_Footer.jpg">
    <tr><td>&nbsp;</td></tr>
  </table>
  <br><br>
<%
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
%>
</body>
</html>
