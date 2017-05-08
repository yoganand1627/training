<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.rmi.RemoteException" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.document.cfp.ExceedQueueLimitException" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.service.document.Cfp" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.BasePrsConversation" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.document.cfp.CaseFilePrint" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.document.cfp.CfpConversation" %>
<%@ page import="org.springframework.web.context.WebApplicationContext" %>
<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%
  try {
    int userId = BasePrsConversation.getUserID(request);
    String outputCode = request.getParameter("outputCode");
    String program = request.getParameter("program");
    String caseId = request.getParameter("caseId");
%>

userId: <%= userId %><br/>
outputCode: <%= outputCode %><br/>
program: <%= program %><br/>
caseId: <%= caseId %><br>

<%
  WebApplicationContext context =
          WebApplicationContextUtils.getWebApplicationContext(getServletConfig().getServletContext());
  Cfp cfp = (Cfp) context.getBean("cfp");
  test(cfp, userId, BasePrsConversation.getUserLogonID(request), outputCode, program, caseId);
%>
Submitted!<br>

<script type="text/javascript" language="JavaScript1.2">
  function openQueue() {
    //http://www.devguru.com/technologies/ecmascript/quickref/win_open.html
    var width = 820;
    var height = 400;
    var left = screen.availWidth - width - 10;
    var top = 0;
    var queueStatus = window.open("<%= CfpConversation.QUEUE_STATUS %>",
            "queueStatus",
            "menubar=no,location=no,resizable=yes,scrollbars=yes," +
            "width=" + width + ",height=" + height + ",left=" + left + ",top=" + top);
    queueStatus.focus();
  }
</script>
<br>
<a href="javascript:openQueue()">see queue</a><br>
<br>
<a href="<%= CfpConversation.CONVERSATION_URL %>QuickTest">submit something else</a><br>
<%
  }
  catch (Exception e) {
    out.println("<pre>");
    e.printStackTrace(new PrintWriter(out));
    out.println("</pre>");
  }
%>
<%!
  public static void test(Cfp cfp, int userId, String userLogin, String outputCode, String program, String caseId)
          throws ExceedQueueLimitException, RemoteException {
    DateFormat dateFormat = new SimpleDateFormat("MMdd_HHmm");

    String jobName = "CFP Test Case " + program + " " + outputCode + " " + caseId;

    String destinationFileName =
            CfpConversation.CFP_BASE_FILE_LOCATION +
            program + "_" +
            outputCode + "_" +
            caseId + "_" +
            dateFormat.format(new Date()) +
            ".pdf";

    String[] outputCodesArray = new String[] {outputCode};

    CaseFilePrint.submitCfp(cfp, userId, userLogin, jobName, destinationFileName, Integer.parseInt(caseId), 0,
                            outputCodesArray);
  }
%>
