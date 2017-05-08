
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.admin.OutputLaunchConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>

<html>
<head>
<title>
Name History Including page STUB
</title>
</head>
<body>
<% String pageMode = "4";%>

<impact:validateErrors/>
<impact:validateForm
   name="frmNameHistSub"
   method="post"
   action="/test/NameHistorySubmodTest/display"
   schema="/WEB-INF/Constraints.xsd"
   redisplayParameters="true"
   pageMode="<%= pageMode %>">

<%String bIntakeIndicator = "Y";%>

<impact:include page="/submodule/NameHistorySubmoduleConversation/displayNameHistory" callingPage="/test/NameHistorySubmodTest/display" tabIndex="1" includingForm="frmNameHistSub">
  <impact:attribute name="intakeIndicator" value="<%= bIntakeIndicator %>" />
</impact:include>
<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>"/>
</impact:validateForm>

</body>
</html>
