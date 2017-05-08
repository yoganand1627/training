<%//*  JSP Name:     Geogia SHINES Portal Password Reset
      //*  Created by:   HTVO
      //*  Date Created: 08/26/10
      //*
      //*  Description:
      //*  This JSP will be used to validate the email user entered against existing record
      //*
      //** Change History:
      //**  Date      User              Description
      //**  --------  ----------------  --------------------------------------------------
      //**  08/30/10  HTVO          	MR-067: Add hdn password reset flag 
%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.AuthenticatedPrsHttpServlet" %>
<%@ page import="org.grnds.facility.config.GrndsConfiguration" %>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>
<%
  // Initialize tabIndex
  int tabIndex = 1;
  // Get the serialized request
  String serializedRequestString = (String) request.getAttribute(AuthenticatedPrsHttpServlet.SERIALIZED_REQUEST_KEY);
  String userName = (String) request.getAttribute(UserProfileHelper.LOGIN_NAME_KEY);
%>

<script language="JavaScript">
  function setResetPassword()
  {
	document.frmResetPassword.hdnResetPasswordSelected.value = 'Y';
  }   
</script>
<impact:validateErrors />
<impact:validateForm name="frmResetPassword" defaultButton="true" method="post" action="/login/Login/validateResetPassword"
                     validationClass="gov.georgia.dhr.dfcs.sacwis.web.common.LoginCustomValidation"
                     schema="/WEB-INF/Constraints.xsd" pageMode="<%= PageModeConstants.CREATE %>"
                     redisplayParameters="true">
  <table border="0" cellpadding="3" cellspacing="0" align="center">
    <tr>
      
      <td align="center">
        <table>
          <tr>
          	<td>&nbsp;</td>
          	<td>Please enter registered email address</td>
          </tr>
          <tr>
            <td width="200"><impact:validateInput type="text" tabIndex="<%=tabIndex++%>" constraint="Email"
                                                 colspan="2" name="<%=UserProfileHelper.LOGIN_NAME_KEY%>"
                                                 value="<%=userName %>"  
                                                 label="E-mail Address" required="true" size="50" maxLength="320"/></td>
          </tr>
          <tr><td>&nbsp;</td>
          </tr>      
          <tr>
          	<td></td>
            <td><impact:ButtonTag name="Continue" img="btnContinue" align="left" form="frmResetPassword" action="/login/Login/validateResetPassword"
                                  function="setResetPassword()" tabIndex="<%=tabIndex++%>"/></td>
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
  document.frmResetPassword.<%= UserProfileHelper.LOGIN_NAME_KEY %>.focus();
</script>

<%!
  private static final GrndsConfiguration GRNDS_CONFIGURATION = GrndsConfiguration.getInstance();
  private static final boolean LOGON_AS_OTHER_USER =
          "true".equals(GRNDS_CONFIGURATION.getProperty(ArchitectureConstants.GRNDS_DOMAIN, "logonAsOtherUser"));
%>
