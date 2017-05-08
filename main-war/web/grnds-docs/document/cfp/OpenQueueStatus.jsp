<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.document.cfp.CfpConversation" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.document.cfp.CfpConversation"%>

<%
//Matthew McClain 5/2/2003
//I could have made this a .js, but I didn't want to mess with the problem
//of the .js not loading before the button was clicked or the method was called.
%>

<script type="text/javascript" language="JavaScript1.2">
<!--
function openQueueStatus()
{
  //http://www.devguru.com/technologies/ecmascript/quickref/win_open.html
  var width = 760;
  var height = 350;
  var left = screen.availWidth - width - 10;
  var top = 0;
  var queueStatus = window.open("<%= CfpConversation.QUEUE_STATUS %>",
                                "queueStatus",
                                "menubar=no," +
                                "location=no," +
                                "resizable=yes," +
                                "scrollbars=yes," +
                                "width=" + width + "," +
                                "height=" + height + "," +
                                "left=" + left + "," +
                                "top=" + top);
  queueStatus.focus();
  return false;
}
//-->
</script>
