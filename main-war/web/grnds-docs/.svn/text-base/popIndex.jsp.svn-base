<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.errorlist.ErrorList" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.errorlist.ErrorListMessage" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.SerializationHelper" %>
<%
  // This must be set before the response is started
  response.setContentType( "text/html; charset=" + ArchitectureConstants.CHARACTER_ENCODING );

  try  // Global try-catch block
  {
    //  BaseSessionStateManager state = new HiddenFieldSessionStateManager();
    //(BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
    //  UserProfile userProfile = UserProfileHelper.getUserProfile( request );
    //  String userName = null;
    //  if( userProfile != null)
    //  {
    //    userName = userProfile.getUserFullName();
    //  }
%>
  <impact:setAttribute parameter="level1Tab"/>
  <impact:setAttribute parameter="level2Tab"/>
  <impact:setAttribute parameter="level3Tab"/>
  <html>
  <head>
  <title><impact:insert parameter="HtmlTitle" /></title>
  <meta http-equiv="Content-Type" content="text/html; charset=<%=ArchitectureConstants.CHARACTER_ENCODING%>">
  <LINK href="/grnds-docs/css/impact.css" rel=stylesheet>
  <SCRIPT src="/grnds-docs/js/shared/prsValidation.js"></script>
  <SCRIPT src="/grnds-docs/js/shared/syncscroll.js"></script>
  <SCRIPT src="/grnds-docs/js/shared/impact.js"></script>
  <script type="text/javascript" language="JavaScript1.2">
    opener.resetTimeout();
  </script>
  </head>
  <body leftmargin="0" topmargin="0">
  <!-- Begin Title and Legend table-->
  <table align="center" width="400" border="0" cellspacing="0" cellpadding="2" class="parentTable">
    <tr>
      <td colspan="2" class="pageTitle"><impact:insert parameter="HtmlTitle"/></td>
        </tr>
  </table>
  <!-- End Title and Legend table-->
  <!-- Begin Parent table-->
  <table align="center" width="400" border="0" cellspacing="0" cellpadding="0" class="parentTable">
    <tr>
      <td>
  <!--- BEGIN HtmlBody insertion (index.jsp) --->
        <impact:insert parameter="HtmlBody" /><br/>
  <!--- END HtmlBody insertion (index.jsp)-- END Parent Table --->
      </td>
    </tr>
  </table>
  </body>
  </html>
<%
}
catch (Exception e) //global try-catch block
{
  out.println("<h2>Your JSP generated an exception: </h2>");
  out.println("<pre>");
  out.println( gov.georgia.dhr.dfcs.sacwis.core.exception.BasePrsException.getStackTrace( e ) );
  out.println("</pre>");
}
%>
