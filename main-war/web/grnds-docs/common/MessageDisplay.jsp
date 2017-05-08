<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<impact:validateErrors formName="messageForm"/>

<impact:validateForm name="frmJobHistory"
   method="post"
   action=""
   pageMode="<%= PageModeConstants.VIEW %>"
   schema="/WEB-INF/Constraints.xsd"
   redisplayParameters="true">
</impact:validateForm>