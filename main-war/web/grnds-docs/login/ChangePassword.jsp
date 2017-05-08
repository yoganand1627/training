<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.AuthenticatedPrsHttpServlet" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ValidateLoginSO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>
<%@ page import="java.util.LinkedHashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Random" %>
<%@ page import="org.grnds.facility.config.GrndsConfiguration" %>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>
<%
  // Initialize tabIndex
  int tabIndex = 1;

  // Get the serialized request
  String serializedRequestString = (String) request.getAttribute(AuthenticatedPrsHttpServlet.SERIALIZED_REQUEST_KEY);
  BaseSessionStateManager state = (BaseSessionStateManager) request.getAttribute(
          BaseSessionStateManager.STATE_MANAGER_KEY);
  //Get the SO object
  ValidateLoginSO validateLoginSO = (ValidateLoginSO)state.getAttribute("validateLoginSO",request);
  //Randomly choose a question
  Random generator = new Random();
  int randomQuesNum = generator.nextInt(3);
  List<String> questionsList = new ArrayList<String>();
  String currentQuestionDisplayed = "";
  String userName = "";
  String password = "";
  if(validateLoginSO != null){
	  questionsList = validateLoginSO.getCdQuestion();
	  currentQuestionDisplayed = Lookup.simpleDecodeSafe("CSECQUES", questionsList.get(randomQuesNum).trim());
	  userName = validateLoginSO.getUserName();
	  password = "TempPass";
	  validateLoginSO.setRandomQuestionNum(randomQuesNum);
	  //Set validateLoginSO to the state so that the random question number can be validated with the answer
      state.setAttribute("validateLoginSO", validateLoginSO, request);
  }
%>
<impact:validateErrors formName="chngPasswd"/>
<impact:validateForm name="frmChngPasswd" method="post" defaultButton="true" action="/login/Login/displayChangePassword"
                     validationClass="gov.georgia.dhr.dfcs.sacwis.web.common.ChangePasswordCustomValidation"
                     schema="/WEB-INF/Constraints.xsd" pageMode="<%= PageModeConstants.CREATE %>"
                     redisplayParameters="true">
  <table border="0" cellpadding="3" cellspacing="0"  align="center">
    <tr>
      <td align="center">
        <table>
          <tr>
            <td width="120"><impact:validateInput type="text" tabIndex="<%=tabIndex++%>" constraint="Email"
                                                 colspan="2" name="<%=UserProfileHelper.LOGIN_NAME_KEY%>"
                                                 label="Email Address" maxLength="320" value="<%=userName %>"  
                                                 editableMode="<%=EditableMode.VIEW %>"/></td>
          </tr>
          <tr>
            <td>Security Question:</td><td><%=currentQuestionDisplayed %></td>
          </tr>          
          <tr>
            <td width="120"><impact:validateInput type="text" tabIndex="<%=tabIndex++%>" constraint="Name25"
                                                 colspan="2" name="<%=UserProfileHelper.SECURITY_ANSWER_KEY%>"
                                                 label="Answer" required="true" maxLength="30"/></td>
          </tr>
          <tr>
            <td width="120"><impact:validateInput type="password" constraint="Password" tabIndex="<%=tabIndex++%>"
                                                 colspan="2" name="<%=UserProfileHelper.NEW_PASSWORD_KEY%>" 
                                                 label="New Password" required="true" maxLength="20"/></td>
          </tr>
          <tr>
            <td width="120"><impact:validateInput type="password" constraint="Password" tabIndex="<%=tabIndex++%>"
                                                 colspan="2" name="<%=UserProfileHelper.NEW_PASSWORD_CONFIRM_KEY%>" 
                                                 label="Re-enter New Password" required="true" maxLength="20"/></td>
          </tr>
          <tr>
          	<td></td>
            <td>
							<impact:ButtonTag name="Logon" img="btnLogon" align="left"
								form="frmChngPasswd" action="/login/Login/changePassword"
								tabIndex="<%=tabIndex++%>" restrictRepost="true" />
						</td>
          </tr>
        </table>
      </td>
    </tr>
  </table>
  <!-- </tr>
  </table> -->
  <input type="hidden" name="<%= HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY %>"/>
  <input type="hidden" name="hdnFormInformation" value="<%= request.getParameter( "hdnFormInformation" ) %>"/>
  <input type="hidden" name="<%= AuthenticatedPrsHttpServlet.SERIALIZED_REQUEST_KEY %>"
         value="<%= FormattingHelper.formatString( serializedRequestString )%>">
</impact:validateForm>

<script type="text/javascript" language="JavaScript1.2">
  document.frmChngPasswd.<%= UserProfileHelper.SECURITY_ANSWER_KEY %>.focus();
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
