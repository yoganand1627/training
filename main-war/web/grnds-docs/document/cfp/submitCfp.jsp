<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.validation.ServerSideValidationUtility" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper" %>
<%
String nextUrl =
  ContextHelper.getStringSafe(request,
                              ServerSideValidationUtility.FORM_VALIDATION_PREV_URL);

if (nextUrl.equals(CfpConversation.CASE_SUMMARY_STUB) == false)
{
  nextUrl = CfpConversation.URL_CASE_SUMMARY;
}
%>
In a couple seconds, you will be forwarded back to the <a href="javascript:submitForm()">Case Summary page.</a><br>
<impact:validateForm name="caseSummary"
                     action='<%= nextUrl %>' 
                     method="post"
                     pageMode="<%= PageModeConstants.EDIT %>"
                     schema="/WEB-INF/Constraints.xsd">
  <impact:hiddenFieldSessionStateManager/>
</impact:validateForm>

<%@ include file="/grnds-docs/document/cfp/OpenQueueStatus.jsp" %>
<script type="text/javascript" language="JavaScript1.2">
<!--
openQueueStatus();

function submitForm() {
  document.all["caseSummary"].submit();
}
submitForm();
//-->
</script>
