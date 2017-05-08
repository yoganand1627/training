<%--
  --  SubmoduleTest.jsp
  --  Created by:  Michael K. Werle
  --  01/02/03
  --%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.Map"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>

<%
  BaseSessionStateManager state = (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
%>

<impact:validateErrors />
<impact:validateForm name="SubmoduleTest"
                     method="post"
                     action="/test/Test/displaySubModuleTest"
                     schema="/WEB-INF/Constraints.xsd"
                     pageMode="<%= PageMode.getPageMode( request ) %>" >
  <impact:include page="<%=(String)state.getAttribute( gov.georgia.dhr.dfcs.sacwis.web.test.TestConversation.SUBMODULE_URI_KEY, request )%>"
                  callingPage="/test/Test/displaySubModuleTest"
                  includingForm="SubmoduleTest"  tabIndex="1" >
    <%
      Map attributeMap = (Map)state.getAttribute( gov.georgia.dhr.dfcs.sacwis.web.test.TestConversation.ATTRIBUTES_KEY, request );
      if( attributeMap != null )
      {
        Iterator attributeIt = attributeMap.keySet().iterator();
        while( attributeIt.hasNext() )
        {
          String name = (String)attributeIt.next();
          String value = (String)attributeMap.get( name );
          %>
            <impact:attribute name="<%=name%>" value="<%=value%>" />
          <%
        }
      }
    %>
  </impact:include>
  <input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
</impact:validateForm>
