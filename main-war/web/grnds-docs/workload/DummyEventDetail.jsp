<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.workload.EventSearchConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper"%>

<!DOCTYPE HTML PUBLIC "-//IETF//DTD HTML//EN">
<html> <head>
<title>Dummy Event Detail</title>
</head>

<body>
<h1>Dummy Event Detail</h1>

If you see this, it's because the EventDetail hasn't been
built for your taskCode yet.<br>
<br>
pageMode: <%= PageMode.getDebugPageMode(PageMode.getPageMode(request)) %><br>
taskCode: <%= GlobalData.getSzCdTask(request) %>
(<%= EventSearchConversation.decodeTask(GlobalData.getSzCdTask(request)) %>) <br>
<br>
eventId: <%= GlobalData.getUlIdEvent(request) %><br>
<br>
caseId: <%= GlobalData.getUlIdCase(request) %><br>
program: <%= GlobalData.getSzCdStageProgram(request) %><br>
stageCode: <%= GlobalData.getSzCdStage(request) %><br>
stageId: <%= GlobalData.getUlIdStage(request) %><br>
stageName: <%= GlobalData.getSzNmStage(request) %><br>
stageType: <%= GlobalData.getSzCdStageType(request) %><br>
<br>
eventListCaller: <%= EventSearchConversation.getCaller(request) %><br>
previousUrl: <%= ContextHelper.getPreviousUrl(request) %><br>
newEventUrl: <%= ContextHelper.getStringSafe(request, "newEventUrl") %><br>
<br>

<hr>
<address></address>
<!-- hhmts start -->
Last modified: Thu Jan 09 09:56:43 Central Standard Time 2003
<!-- hhmts end -->
</body> </html>
