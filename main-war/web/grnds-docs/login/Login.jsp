<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.AuthenticatedPrsHttpServlet" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>
<%@ page import="java.net.URL" %>
<%@ page import="org.grnds.facility.config.GrndsConfiguration" %>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>
<%
  // Initialize tabIndex
  int tabIndex = 1;
  URL url = new URL( request.getRequestURL().toString() );
  String baseURL = url.getPort() >= 0 ?
                   url.getProtocol() + "://" + url.getHost() + ":" + url.getPort() :
                   url.getProtocol() + "://" + url.getHost();
  // Get the serialized request
  String serializedRequestString = (String) request.getAttribute(AuthenticatedPrsHttpServlet.SERIALIZED_REQUEST_KEY);
%>

<script language="JavaScript">
  function warnSecurityPrivacyPolicy()
  {
    var returnVal = true;
    returnVal = confirm( '<%=MessageLookup.getMessageByNumber( Messages.MSG_PORTAL_LOGIN_CONFIRM )%>' );
    return returnVal;
  }
  function warnRegisterNewUser()
  {
    var returnVal = true;
    returnVal = confirm( '<%=MessageLookup.getMessageByNumber( Messages.MSG_PORTAL_REG_APRV_PROV_CONFIRM )%>' );
    return returnVal;
  }
  function displayVendorStaffDetail()
  {
  	if (warnRegisterNewUser()){
		disableValidation('frmLogin');
		submitValidateForm( 'frmLogin', '/login/Login/displayVendorStaffDetail' );
	}
  }
  function displayResetPassword()
  {
		document.frmLogin.hdnResetPasswordSelected.value = 'Y';
		disableValidation('frmLogin');
		submitValidateForm( 'frmLogin', '/login/Login/displayResetPassword' );

  }   
</script>

<impact:validateErrors formName="login"/>
<impact:validateForm name="frmLogin" method="post" defaultButton="true" action="/login/Login/test"
                     validationClass="gov.georgia.dhr.dfcs.sacwis.web.common.LoginCustomValidation"
                     schema="/WEB-INF/Constraints.xsd" pageMode="<%= PageModeConstants.CREATE %>"
                     redisplayParameters="true">
  <table border="0" cellpadding="3" cellspacing="0" align="center">
    <tr>
      
      <td align="center">
        <table>
          <tr>
            <td width="200"><impact:validateInput type="text" tabIndex="<%=tabIndex++%>" constraint="Email"
                                                 colspan="2" name="<%=UserProfileHelper.LOGIN_NAME_KEY%>"
                                                 label="E-mail Address" required="true" size="50" maxLength="320"/></td>
          </tr>
          <tr>
            <td width="200"><impact:validateInput type="password" constraint="Password" tabIndex="<%=tabIndex++%>"
                                                 colspan="2" name="<%=UserProfileHelper.PASSWORD_KEY%>" label="Password"
                                                 required="true" size="30" maxLength="20"/></td>
          </tr>
          <tr>
            <%
              if (LOGON_AS_OTHER_USER) {
            %>
            <td><impact:validateInput type="text" name="<%=UserProfileHelper.CLAIM_USER_ID_KEY %>"
                                      label="Logon As ( UserID )" size="15" tabIndex="<%=tabIndex++%>"
                                      constraint="Digit16Less" required="false" value=""/></td>
            <%
            } else {
              // Hidden field needed for fixed users if we have no displayed field.
            %>
            <td colspan="2">&nbsp;<input type="hidden" name="<%= UserProfileHelper.CLAIM_USER_ID_KEY %>"
                                         value=""/></td>
            <%
              }
            %>
            <td><impact:ButtonTag name="Logon" img="btnLogon" align="right" form="frmLogin" action="/login/Login/test"
                                  tabIndex="<%=tabIndex++%>" function="return warnSecurityPrivacyPolicy()"/></td>
          </tr>
          <tr><td>&nbsp;</td>
          </tr> 
          <tr>
          	<td colspan=2><a href="javascript:displayVendorStaffDetail();">Click here to register as a new user. This does not apply to NYTD youth user.</a>
          	</td>
          	<td></td>
          	<td><a href="javascript:displayResetPassword();">Click here to reset your password</a>
          	</td>
          </tr>	
          	
        </table>
      </td>
    </tr>
  </table>
  <!-- </tr>
  </table> -->
  <input type="hidden" name="hdnResetPasswordSelected" value=""/>
  <input type="hidden" name="<%= HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY %>"/>
  <input type="hidden" name="hdnFormInformation" value="<%= request.getParameter( "hdnFormInformation" ) %>"/>
  <input type="hidden" name="<%= AuthenticatedPrsHttpServlet.SERIALIZED_REQUEST_KEY %>"
         value="<%= FormattingHelper.formatString( serializedRequestString )%>">
</impact:validateForm>

<script type="text/javascript" language="JavaScript1.2">
  document.frmLogin.<%= UserProfileHelper.LOGIN_NAME_KEY %>.focus();
</script>

<%!
  private static final GrndsConfiguration GRNDS_CONFIGURATION = GrndsConfiguration.getInstance();
  private static final boolean LOGON_AS_OTHER_USER =
          "true".equals(GRNDS_CONFIGURATION.getProperty(ArchitectureConstants.GRNDS_DOMAIN, "logonAsOtherUser"));
%>
