<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.decorator.ScreenDefinitionsXmlDao" %>
<%
  // Submodule try-catch block
  try {
%>
<!--- BEGIN HtmlBody insertion (Submodule.jsp) --->
<impact:insert parameter="HtmlBody"/>
<!--- END HtmlBody insertion (Submodule.jsp) --->
<%
  } catch (Exception e) {
    throw new JspException("Error in Submodule '" + request.getAttribute(
            ScreenDefinitionsXmlDao.SCREEN) + "':" + e.getMessage(), e);
  }
%>
