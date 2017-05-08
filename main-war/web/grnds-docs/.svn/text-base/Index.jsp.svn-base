<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact"%>
<%@ page import="org.grnds.facility.config.GrndsConfiguration"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.exception.BasePrsException"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.SerializationHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.errorlist.ErrorList"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.validation.RepostCheckUtility"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.AuthenticatedPrsHttpServlet"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.BasePrsConversation"%>
<%
  // Global try-catch block
  try {
%>
<impact:setAttribute parameter="level1Tab"/>
<impact:setAttribute parameter="level2Tab"/>
<impact:setAttribute parameter="level3Tab"/>
<html>
<head>
  <title><impact:insert parameter="HtmlTitle" /></title>
  <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
  <LINK href="/grnds-docs/css/impact.css" rel="stylesheet">
  <SCRIPT type="text/javascript" language="JavaScript1.2" src="/grnds-docs/js/shared/prsValidation.js"></script>
  <SCRIPT type="text/javascript" src="/grnds-docs/js/shared/syncscroll.js"></script>
  <SCRIPT type="text/javascript" src="/grnds-docs/js/shared/impact.js"></script>
  <SCRIPT type="text/javascript" src="/grnds-docs/js/shared/timer.js"></script>
  <SCRIPT type="text/javascript" src="/grnds-docs/js/document/document.js"></script>
  <script type="text/javascript" language="JavaScript1.2">
<%-- Prevent this comment from writing out on every page display
  //SIR 22350 - Add a session timeout timer in the status bar of IE.
                Pop up a warning message with 5 minutes left to go.
  //session timer variables
--%>
<%
    final String SESSION_ID_NAME = "JSESSIONID";
    String jSessionId = session.getId();
// FIXME: Determine how to fix this in SJSAS.
// hopefully the mechanism for changing the sessionId to the id in the JSESSIONID cookie won't change
//
//    int lastIndexOfBang = jSessionId.lastIndexOf("!");
//    jSessionId = jSessionId.substring(0, lastIndexOfBang);

    //Set the user's logon id into the response as a cookie.  ...used in apache audit logging.
    gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile user = gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper.getUserProfile( request );
    if( user != null ) {
%>
      var today = new Date()
      var expires = new Date()
      //Set cookie expiration to 10 hours
      expires.setTime(today.getTime() + 1000*60*60*10 )
      setCookie('IMPACTLogonID', '<%=user.getUserLogonID() %>', expires);
<%
    }
%>
    var oldSessionId = "<%= jSessionId %>";
    var newSessionId = getCookie("<%= SESSION_ID_NAME %>");
    if ((oldSessionId != "") && (oldSessionId != newSessionId)) {
      document.location = "<%= AuthenticatedPrsHttpServlet.LOGIN_URL %>";
    }
<%-- Prevent this comment from writing out on every page display
    /*
      SPB - 04/10/03 - currently disabled
      This function is used when the body of the page is hidden during load.
      As soon as the page is fully loaded it switches the div tag that contains it to visible
    */
    //function toggleBody()
    //{
    //  toggleVisibility( 'expandedContent', 'block');
    //
    //  eval("document.getElementById('Alex').style.display='none'");
    //}
    /*
      SPB - 04/10/03
      This function is called when error list is supposed to pop up.
      It copies state into ErrorListForm and then submits it.
    */
--%>
    function callErrorListFormSubmit() {
      ErrorListForm.<%= HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY %>.value=hiddenFieldStateForm.<%= HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY %>.value;
      var errorList = window.open('about:blank','errorWin','toolbar=no,location=no,scrollbars=auto,resizable=yes,width=550,height=250');
      ErrorListForm.target = "errorWin";
      if( window.focus ) {
        errorList.focus();
      }
      ErrorListForm.submit();
    }

    var pageHasLoaded = false;
    //End Java Script
  </script>
</head>
<%
    String serializedErrorList = "";
    if(request.getAttribute(ErrorList.ERROR_LIST_ATTR) != null) {
      serializedErrorList = SerializationHelper.serializeObject(request.getAttribute(ErrorList.ERROR_LIST_ATTR));
      request.removeAttribute(ErrorList.ERROR_LIST_ATTR);
%>
<body topmargin="10px" onload="callErrorListFormSubmit()">
<%
    }
    else {
%>
<body topmargin="10px">
<%
    }
%>
<div align="center">
  <impact:insert parameter="HtmlBanner" />
  <table width="780" border="0" cellspacing="0" cellpadding="0"  background="/grnds-docs/images/bg.gif" >
    <tr>
      <td>
        <!-- Begin Title and Legend table-->
        <table width="770" border="0" cellspacing="0" cellpadding="2" class="parentTable">
          <tr>
            <td width="33%">
              <%@ include file="InfoBox.jsp" %>
            </td>
            <td width="33%" class="pageTitle">
              <impact:insert parameter="HtmlTitle"/>
            </td>
            <td width="33%">
              <%@ include file="Legend.jsp" %>
            </td>
          </tr>
        </table>
        <!-- End Title and Legend table-->
        <!-- Begin Parent table-->
        <table width="770" border="0" cellspacing="0" cellpadding="0" class="parentTable">
          <tr>
            <td>
        <!--- BEGIN HtmlBody insertion (index.jsp) --->
              <impact:insert parameter="HtmlBody" /><br/>
        <!--- END HtmlBody insertion (index.jsp)-- END Parent Table --->
            </td>
          </tr>
        </table>
      </td>
    </tr>
  </table>
  <table width="780" cellpadding="0" cellspacing="0" border="0" background="/grnds-docs/images/metaphor/SACWIS_Footer.jpg">
    <tr><td>&nbsp;</td></tr>
  </table>
</div>  
  <!--Begin Footer-->
<br/>
<div align="center" class = "footer">
 	<a class="footer" href="http://www.georgia.gov/00/home/0,2061,4802,00.html" target='_blank'>georgia.gov</a> |<a class="footer" href="http://www.georgia.gov/00/topic_index_channel/0,2092,4802_937045,00.html" target='_blank'>Agencies</a> |<a class="footer" href="http://www.georgia.gov/00/static/0,2085,4802_0_0_Privacy,00.html" target='_blank'>Privacy/Security</a> |<a class="footer" href="http://www.georgia.gov/00/static/0,2085,4802_0_0_Important-Notices,00.html" target='_blank'>Notices</a> |<a class="footer" href="http://www.georgia.gov/00/static/0,2085,4802_0_0_Accessibility,00.html" target='_blank'>Accessibility</a> |<a class="footer"  href="http://www.georgia.gov/00/contact_us/0,2603,4802,00.html" target='_blank'>Contact georgia.gov</a>
</div>
<!--End Footer-->
<br/>
  

<% //Don't write Repost Check cookie unless it has a value.  ...This allows the
   //  cookie to not be overwritten after a session timeout
   String repostCodeKeyString = RepostCheckUtility.getCodeKeyString( request );
   if( repostCodeKeyString != null && !"".equals( repostCodeKeyString ) ) {
%>
  <script type="text/javascript" language="javascript" >
      //This RepostCheckUtility Cookie holds the values of the Repost key code pairs
      var myday = new Date()
      var cookieExpires = new Date()
      //Set cookie expiration to 10 hours
      cookieExpires.setTime( myday.getTime() + 1000*60*60*10 )
      setCookie('<%=RepostCheckUtility.COOKIE_NAME%>', '<%= repostCodeKeyString %>', cookieExpires);
  </script>
<%  } //End check for repostCodeKeyString
%>
<%-- BEGIN HiddenFieldState form --%>
  <form name="hiddenFieldStateForm">
    <input type="hidden" name="requestStartTime" value='<%=request.getParameter("requestStartTime") %>'>
    <input type="hidden" name="requestTotalTime">
    <impact:hiddenFieldSessionStateManager/>
    <input type="hidden" name="bSubmitted" value="false">
  </form>
  <%-- END HiddenFieldState form --%>

<%
  String debugJsp = GrndsConfiguration.getInstance().getProperty(ArchitectureConstants.GRNDS_DOMAIN, "debugJSP");
  if ("true".equals(debugJsp))
    if (DEBUG) {
%>
  <div align="center">
  <table width="780" border="0" cellspacing="0" cellpadding="3" class="tableborder">
    <tr>
      <th>Debugging Information:</th>
    </tr>
    <tr>
     <td>
       <%@ include file="/grnds-docs/test/DebugGlobalData.jsp" %>
       <%@ include file="/grnds-docs/test/DebugRequestParameters.jsp" %>
       <%@ include file="/grnds-docs/test/DebugRequestAttributes.jsp" %>
       <%--<%@ include file="/grnds-docs/test/DebugStateAttributes.jsp" %>--%>
       <%--<%@ include file="/grnds-docs/test/DebugSessionAttributes.jsp" %>--%>
     </td>
    </tr>
  </table>
  </div>
<%
    } //End debug check
%>
<%--- </div> ---%>
<%
    // BEGIN: Create javascript alert for any messages set into popup messages
    if ( request.getAttribute( BasePrsConversation.POPUP_MESSAGES ) != null ) {
      StringBuffer popupMessage = new StringBuffer();
      java.util.Map popupsMap = (java.util.Map) request.getAttribute( BasePrsConversation.POPUP_MESSAGES );
      java.util.Collection popupMsgs = popupsMap.values();
      java.util.Iterator popupMsgsIterator = popupMsgs.iterator();
      while ( popupMsgsIterator.hasNext() ) {
        popupMessage.append( (String) popupMsgsIterator.next() );
        popupMessage.append( "\\n" );
      }
      String message = popupMessage.toString();
%>
  <script type="text/javascript" language="javascript" >
    alert( "<%=message%>" );
  </script>
<%
    }
    // END: Create javascript alert for any messages set into popup messages
%>
  <form name="ErrorListForm" method="post" action="/errorlist/ErrorList/display">
    <input type="hidden" name="<%= ErrorList.ERROR_LIST_PARAM %>" value="<%= serializedErrorList %>" />
    <input type="hidden" name="<%= HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY %>" value="" />
  </form>
  <script type="text/javascript" language="JavaScript1.2">
    // toggleBody();
    window.attachEvent('onload', setPerformanceStop );
    window.attachEvent('onload', setIsDirtyCalledFalse );
    function setIsDirtyCalledFalse() {
      setIsDirtyCalled(false);
    }
    pageHasLoaded = true;
  </script>
<font color="#164861"><%= request.getServerName() + ":" + request.getServerPort() %></font>
<%-- // TODO: Add this invisible text back. --%>
<%--<font color="#ffffff"><%= System.getProperty("weblogicUrl") %></font>--%>


<%
   // If in BrownOut Mode then add the function to disable widgets
   // to the onLoad page event.
   if (ArchitectureConstants.BROWNOUT_MODE) {
%>
    <script type="text/javascript" language="JavaScript1.2">
      window.attachEvent('onload', disableWidgets);
    </script>
<%
  }
%>

</body>
</html>
<%
  } catch (Exception e) {
    out.println("<h2>Your JSP generated an exception: </h2>");
    // Attempt to loop through and recursively unwrap the root causes of exceptions
    StringBuffer sb = new StringBuffer();
    sb.append(" ");
    // Start with the caught exception
    Throwable throwable = e;
    do {
      sb.insert(0, "\n</pre>\n");
      sb.insert(0, BasePrsException.getStackTrace(throwable));
      sb.insert(0, "\n<pre>\n");
      // Start by trying to get the JDK 1.4+ wrapped cause (usually works).
      throwable = throwable.getCause();
      if (throwable == null) {
        // This try attempts to execute the "getRootCause" method on the exception using reflection.
        try {
          throwable = (Throwable) throwable.getClass().getMethod("getRootCause").invoke(throwable);
        } catch (NoSuchMethodException nsme) {
          try {
            // Check to see if there is a getEnclosedError method (if this is wrapped by GrndsException, there might be.
            throwable = (Throwable) throwable.getClass().getMethod("getEnclosedError").invoke(throwable);
          } catch (Exception e1) {
            try {
              throwable = (Throwable) throwable.getClass().getMethod("getThrowable").invoke(throwable);
            } catch (Exception e2) {
              try {
                // None of the known methods to extract wrapped exceptions exist; loop through the methods that the
                //   object does have to find one that returns Throwable and use the first one that we find.
                Method[] methods = throwable.getClass().getMethods();
                Throwable newThrowable = null;
                for (int i = 0; i < methods.length; i++) {
                  Method method = methods[i];
                  Class returnType = method.getReturnType();
                  if (throwable.getClass().isAssignableFrom(returnType) && method.getParameterTypes().length == 0) {
                    newThrowable = (Throwable) method.invoke(throwable);
                    break;
                  }
                }
                throwable = newThrowable;
              } catch (Exception e3) {
                // There is no wrapped exception; end the loop by setting e to null
                //noinspection AssignmentToNull
                throwable = null;
              }
            }
          }
        } catch (Exception e3) {
          // Something odd happened; set e to null to end the loop.
          //noinspection AssignmentToNull
          throwable = null;
        }
      }
      if (throwable != null) {
        sb.insert(0, "\nWas the cause of:\n");
      }
    } while (throwable != null);
    out.println(sb.toString());
  }
%>
<%!
  private static final boolean DEBUG =
          "true".equals(GrndsConfiguration.getInstance().getProperty(ArchitectureConstants.GRNDS_DOMAIN, "debugJSP"));
%>
