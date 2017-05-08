<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.AuthenticatedPrsHttpServlet" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.LinkedHashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="org.grnds.facility.config.GrndsConfiguration" %>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>
<%
  // Initialize tabIndex
  int tabIndex = 1;

  // Get the serialized request
  String serializedRequestString = (String) request.getAttribute(AuthenticatedPrsHttpServlet.SERIALIZED_REQUEST_KEY);
  // Get the Lenses Case ID
  String lensesCaseIdStr = (String) request.getAttribute(AuthenticatedPrsHttpServlet.LENSES_CASE_ID);
  
%>
<impact:validateErrors formName="login"/>
<impact:validateForm name="frmLogin" method="post" defaultButton="true" action="/login/Login/test"
                     validationClass="gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation"
                     schema="/WEB-INF/Constraints.xsd" pageMode="<%= PageModeConstants.CREATE %>"
                     redisplayParameters="true">
   <table width="100%" border="0" cellspacing="0" class="parentTable">
        <tr>
          <td class="pageTitle">
            <impact:insert parameter="HtmlTitle"/>
          </td>
        </tr>
  </table>
  <table border="0" cellspacing="0">
    
	      <tr>
            <td><impact:validateInput type="text" tabIndex="<%=tabIndex++%>" constraint="NovellUsername"
                                                 name="<%=UserProfileHelper.LOGIN_NAME_KEY%>"
                                                 value="" 
                                                 label="User Name" required="true" maxLength="20"/></td>
          </tr>
          <tr>
            <td><impact:validateInput type="password" constraint="Password" tabIndex="<%=tabIndex++%>"
                                                 name="<%=UserProfileHelper.PASSWORD_KEY%>" label="Password"
                                                 value=""
                                                 required="true" maxLength="20"/></td>
          </tr>
          <tr>
            <%
              String defaultOtherUserId = FIXED_USERS != null && FIXED_USERS.size() > 0 ?
                                          String.valueOf(FIXED_USERS.keySet().iterator().next()) : "";
              if (LOGON_AS_OTHER_USER) {
            %>
            <td><impact:validateInput type="text" name="<%=UserProfileHelper.CLAIM_USER_ID_KEY %>"
                                      label="Logon As ( UserID )" maxLength="16" tabIndex="<%=tabIndex++%>"
                                      value="" 
                                      constraint="Digit16Less" required="false" /></td>
            <%
            } else {
              // Hidden field needed for fixed users if we have no displayed field.
            %>
            <td><input type="hidden" name="<%= UserProfileHelper.CLAIM_USER_ID_KEY %>"
                                         value=""/></td>
            <%
              }
            %>
          </tr>
		  <tr>
		   <td><impact:ButtonTag name="Logon" img="btnLogon" align="left" form="frmLogin" action="/login/Login/test"
                                  tabIndex="<%=tabIndex++%>"/></td>
		  </tr>
          <%
            if (LOGON_AS_FIXED_USERS) {
              boolean defaultUser = true;
              for (Iterator<Integer> it = FIXED_USERS.keySet().iterator(); it.hasNext();) {
                Integer claimedId = it.next();
                String title = FIXED_USERS.get(claimedId);
          %>
          <tr>
            <td>&nbsp;</td>
            <td colspan="2">
              <input type="radio" id="rdFixedUserId_<%=claimedId%>" name="rdFixedUserId"
                      <%=defaultUser ? "checked" : ""%>
                     onClick="document.frmLogin.<%=UserProfileHelper.CLAIM_USER_ID_KEY%>.value=<%=claimedId%>"/>
              <label for="rdFixedUserId_<%=claimedId%>"><%=title%></label>
            </td>
          </tr>
          <%
                defaultUser = false;
              }
            }
          %>
       
  </table>
  <input type="hidden" name="<%= HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY %>"/>
  <input type="hidden" name="hdnFormInformation" value="<%= request.getParameter( "hdnFormInformation" ) %>"/>
  <input type="hidden" name="<%= AuthenticatedPrsHttpServlet.SERIALIZED_REQUEST_KEY %>"
         value="<%= FormattingHelper.formatString( serializedRequestString )%>">
  <input type="hidden" name="<%= AuthenticatedPrsHttpServlet.LENSES_CASE_ID %>"
         value="<%= FormattingHelper.formatString( lensesCaseIdStr )%>">         
</impact:validateForm>

<script type="text/javascript" language="JavaScript1.2">
  document.frmLogin.<%= UserProfileHelper.LOGIN_NAME_KEY %>.focus();
</script>

<%!
  private static final GrndsConfiguration GRNDS_CONFIGURATION = GrndsConfiguration.getInstance();
  private static final boolean LOGON_AS_OTHER_USER =
          "true".equals(GRNDS_CONFIGURATION.getProperty(ArchitectureConstants.GRNDS_DOMAIN, "logonAsOtherUser"));
  private static final boolean LOGON_AS_FIXED_USERS =
          "true".equals(GRNDS_CONFIGURATION.getProperty(ArchitectureConstants.GRNDS_DOMAIN, "logonAsFixedUsers"));
  // Parse out the fixed users
  private static final Map<Integer, String> FIXED_USERS;

  static {
    if (LOGON_AS_FIXED_USERS) {
      Map<Integer, String> tempMap = new LinkedHashMap<Integer, String>();
      int i = 1;
      String val;
      while (null !=
             (val = GRNDS_CONFIGURATION.getProperty(ArchitectureConstants.GRNDS_DOMAIN, "loginAsFixedUser" + (i++)))) {
        String[] vals = val.split(",");
        tempMap.put(Integer.parseInt(vals[0]), vals[1]);
      }
      FIXED_USERS = tempMap;
    } else {
      //noinspection AssignmentToNull
      FIXED_USERS = null;
    }
  }
%>
