<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.document.cfp.StageDB" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.service.document.Cfp" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.validation.ServerSideValidationUtility" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.BasePrsConversation" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.document.cfp.CfpConversation" %>
<%@ page import="org.springframework.web.context.WebApplicationContext" %>
<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%
  try {
    // Set character encoding before printing anything out; this MUST
    //   be done in order to properly display extended characters.
    response.setContentType("text/html; charset=" + ArchitectureConstants.CHARACTER_ENCODING);
%>
<!DOCTYPE HTML PUBLIC "-//IETF//DTD HTML//EN">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=<%=ArchitectureConstants.CHARACTER_ENCODING%>">
  <title>Case Summary Stub</title>
</head>

<body>
<h1>Case Summary Stub</h1>

<form name="stub" action='<%= CfpConversation.FORWARD_TO_CFP %>' method="get">
  ..... CaseId:&nbsp;&nbsp;<input type="text" name="caseId" value=""><br>
  (opt) StageId:&nbsp;<input type="text" name="stageId" value=""><br>
  <input type="hidden"
         name="<%= ServerSideValidationUtility.FORM_VALIDATION_PREV_URL %>"
         value="<%= CfpConversation.CASE_SUMMARY_STUB %>"/>
  <input type="submit">
</form>
<br>
<br>
<br>

<%
  //don't use 1000000, 1000001
  int[][] ids = new int[][] {
          new int[] {24401368, 0}, //large
          new int[] {16101941, 0}, //large
          new int[] {16015156, 0}, //large; sir 288135
          new int[] {23226045, 0}, //large; sir 288135
          new int[] {23157857, 0}, //large; sir 288135
          new int[] {3000573, 0},  //large; sir 139052
          new int[] {23133019, 0},
          new int[] {23132370, 0}, //has Intake forms time out
          new int[] {23133000, 0},
          new int[] {23132970, 0},
          new int[] {23127091, 0},
          new int[] {23133141, 0},
          new int[] {1000021, 0},
          new int[] {1000001, 0},
          new int[] {23134317, 0},
          new int[] {20064615, 23398497},
          new int[] {20064615, 23398511},
          new int[] {23141007, 23423198},
          new int[] {3001454, 3007040},
          new int[] {1000022, 1000023},
          new int[] {1000001, 1000002},
          new int[] {23090281, 23398513},
          new int[] {23089888, 23398544},
          new int[] {23132986, 23398349},
          new int[] {23132981, 23398442},
          new int[] {23126822, 23398480},
          new int[] {23132680, 23398484},
          new int[] {23133874, 23400607},
          new int[] {23133883, 23400637},
          new int[] {16122488, 23399168},
          new int[] {24288678, 23402657},
          new int[] {23129718, 23398493},
          new int[] {23739724, 23398844}
  };

  WebApplicationContext context =
          WebApplicationContextUtils.getWebApplicationContext(getServletConfig().getServletContext());
  Cfp cfp = (Cfp) context.getBean("cfp");
  for (int i = 0; i < ids.length; i++) {
    int caseId = ids[i][0];
    int stageId = ids[i][1];

    StageDB stageDB = cfp.getStageDB(caseId, stageId);
    Map<String, String> hashtable = new HashMap<String, String>();
    hashtable.put("caseId", "" + caseId);
    hashtable.put("stageId", "" + stageId);
    hashtable.put(ServerSideValidationUtility.FORM_VALIDATION_PREV_URL,
                  CfpConversation.CASE_SUMMARY_STUB);
    String url = BasePrsConversation.getUrl(CfpConversation.FORWARD_TO_CFP, hashtable);
    if (i < 6) {
      out.println("Large: ");
    }
    out.println("<a href=\"" + url + "\">" +
                stageDB.getCaseName() + ", " +
                stageDB.getProgramName() + ", " +
                stageDB.getStageCode() + ", " +
                stageDB.getStageType() + "</a><br>");
  }
%>

<hr>
<address></address>
<!-- hhmts start -->
Last modified: Tue Nov 12 09:48:23 Central Standard Time 2002
<!-- hhmts end -->
</body>
</html>
<%

  }
  catch (Throwable e) {
    out.println("<pre>");
    e.printStackTrace(new PrintWriter(out));
    out.println("</pre>");
  }
%>
