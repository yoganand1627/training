package gov.georgia.dhr.dfcs.sacwis.web.core.user;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.BasePrsRuntimeException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.jdbchelper.JdbcHelper;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;

import java.io.IOException;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.grnds.facility.config.GrndsConfiguration;
import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

import netscape.ldap.LDAPConnection;
import netscape.ldap.LDAPEntry;
import netscape.ldap.LDAPException;
import netscape.ldap.LDAPSearchConstraints;
import netscape.ldap.LDAPSearchResults;
import netscape.ldap.LDAPv2;
import netscape.ldap.LDAPv3;
import netscape.ldap.factory.JSSESocketFactory;

import gov.georgia.dhr.dfcs.sacwis.core.sql.SqlHelper;

public class UserProfileHelper {
  /** String TRACE_TAG */
  private static final String TRACE_TAG = "UserProfileHelper";

  /** String GLOBAL_DATA_USER_ID */
  protected static final String GLOBAL_DATA_USER_ID = "GLOBAL_DATA_USER_ID";

  /** String USER_PROFILE_SESSION_ID */
  public static final String USER_PROFILE_SESSION_ID = "userProfile";

  public static final String[] SUN_SERVER_IP = {
          GrndsConfiguration.getInstance().getProperty(ArchitectureConstants.GRNDS_DOMAIN,
                                                       "security.login.sun_server.ip1"),
          GrndsConfiguration.getInstance().getProperty(ArchitectureConstants.GRNDS_DOMAIN,
                                                       "security.login.sun_server.ip2"),
  };

  /** number of servers configured for NTLM Authentication. */
  public static final int AUTHENTICATION_SERVER_COUNT = SUN_SERVER_IP.length;

  /** String[] SUN_SERVER_PORT */
  public static final String[] SUN_SERVER_PORT = {
          GrndsConfiguration.getInstance().getProperty(ArchitectureConstants.GRNDS_DOMAIN,
                                                       "security.login.sun_server.port1"),
          GrndsConfiguration.getInstance().getProperty(ArchitectureConstants.GRNDS_DOMAIN,
                                                       "security.login.sun_server.port2"),
  };

  /** String METAPHOR_USER_ID_KEY */
  public static final String METAPHOR_USER_ID_KEY = TRACE_TAG + "MetaphorUserIdKey";
  /** String CLAIM_USER_ID_KEY */
  public static final String CLAIM_USER_ID_KEY = TRACE_TAG + "ClaimUserIdKey";
  /** String LOGIN_NAME_KEY */
  public static final String LOGIN_NAME_KEY = TRACE_TAG + "LoginNameKey";
  /** String PASSWORD_KEY */
  public static final String PASSWORD_KEY = TRACE_TAG + "PasswordKey";

  /** String LDAP baseDN */
  public static final String LDAP_BASEDN = GrndsConfiguration.getInstance().getProperty(
          ArchitectureConstants.GRNDS_DOMAIN,
          "security.login.baseDN");
  /** String LDAP Search Criteria */
  public static final String SEARCH_CRITERIA = GrndsConfiguration.getInstance().getProperty(
          ArchitectureConstants.GRNDS_DOMAIN,
          "security.login.search.criteria");
  /** String LDAP Secured Port # */
  public static final String SECURED_PORT = GrndsConfiguration.getInstance().getProperty(
          ArchitectureConstants.GRNDS_DOMAIN,
          "security.login.secured.port");
  /** String LDAP User ID Suffix */
  public static final String USERID_SUFFIX = GrndsConfiguration.getInstance().getProperty(
          ArchitectureConstants.GRNDS_DOMAIN,
          "security.login.userid.suffix");
  /** String PASSWORD_CHECK */
  public static final String PASSWORD_CHECK =
          "true".equals(GrndsConfiguration.getInstance().getProperty(ArchitectureConstants.GRNDS_DOMAIN,
                                                                     "security.login.password_check"))
          ? "true" : "false";
  
  /** String TRAINING_PASSWORD CHECK */
  public static final String TRNG_PWD_CHECK =
          "true".equals(GrndsConfiguration.getInstance().getProperty(ArchitectureConstants.GRNDS_DOMAIN,
                                                                     "perUserSchemaSupport")) ? "true" : "false";
  /** boolean ACTIVE_DIRECTORY_AUTH */
  public static boolean ACTIVE_DIRECTORY_AUTH =
          "true".equals(GrndsConfiguration.getInstance().getProperty(ArchitectureConstants.GRNDS_DOMAIN,
                                                                     "security.login.active_directory"));

  /** int MSG_CMN_NOT_CAPS_USER */
  public static final int MSG_CMN_NOT_CAPS_USER = 2081;

  /** //Timeout for Ping of NT Auth Server = 10s or 10,000ms */
  public static final int NT_SERVER_PING_TIMEOUT_MS = 10000;
  /**
   * /* Port for authentication - used to "ping" the server before authenticating to is so that it doesn't take 2
   * minutes to timeout. /
   */
  public static final int NT_SERVER_AUTH_PORT = 137;
  //LDAP Host Machine
  public static final String LDAP_HOST = GrndsConfiguration.getInstance().getProperty(
          ArchitectureConstants.GRNDS_DOMAIN, "ldap-host");
  public static final String LDAP_PORT = GrndsConfiguration.getInstance().getProperty(
          ArchitectureConstants.GRNDS_DOMAIN, "ldap-port");
  public static final String LDAP_AUTH_REQ = GrndsConfiguration.getInstance().getProperty(
          ArchitectureConstants.GRNDS_DOMAIN, "ldap-auth-req");

  //Successfully pinged IP and Port
  private static String successLDAPIp = "";
  private static String successLDAPPort = "";

  private UserProfileHelper() {
    // prevents instantiation
  }

  /**
   * This method should be called when the user chooses to log out of the application. It will remove the UserProfile
   * object from the HttpSession.
   *
   * @param request The HttpServletRequest
   */
  public static void logoff(HttpServletRequest request) {
    // First, invalidate the user's session if one exsists.
    HttpSession session = request.getSession(false);
    if (session != null) {
      session.invalidate();
    }
    // Next, clear state (both attributes and context parameters)
    //   to ensure that nothing carries over between sessions.
    BaseSessionStateManager state = BaseHiddenFieldStateConversation.getSessionStateManager(request);
    state.clearAll(request);
  }

  /**
   * This method allows for easy retrieval of the UserProfile, given a GrndsExchangeContext object.
   *
   * @param context The GrndsExchangeContext object to get the UserProfile from.
   * @return UserProfile The current user's profile.
   */
  public static UserProfile getUserProfile(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    return getUserProfile(request);
  }

  /**
   * This method allows for easy retrieval of the UserProfile, given an HttpServletRequest object.
   *
   * @param request The HttpServletRequest object to get the UserProfile from.
   * @return UserProfile The current user's profile.
   */
  public static UserProfile getUserProfile(HttpServletRequest request) {
    HttpSession session = request.getSession(false);
    UserProfile userProfile = null;
    if (session != null) {
      userProfile = (UserProfile) session.getAttribute(UserProfileHelper.USER_PROFILE_SESSION_ID);
    }
    return userProfile;
  }

  /**
   * validateLogin
   *
   * @param context parameter for validateLogin
   * @throws SecurityException -
   */
  public static void validateLogin(GrndsExchangeContext context) throws SecurityException {
    GrndsTrace.enterScope(TRACE_TAG + ".validateLogin");
    validateLogin(context.getRequest());
    GrndsTrace.exitScope();
  }

  /**
   * validateLogin
   *
   * @param request parameter for validateLogin
   * @throws SecurityException -
   */
  public static void validateLogin(HttpServletRequest request) throws SecurityException {
    GrndsTrace.enterScope(TRACE_TAG + ".validateLogin");
    String userName = request.getParameter(LOGIN_NAME_KEY);
    String password = request.getParameter(PASSWORD_KEY);
    //Validate username and password combination.
    validateLogin(userName, password);
    GrndsTrace.exitScope();
  }

  /**
   * Validates the username and Password against the configured SUN LDAP Authentication
   *
   * @param userName parameter for validateLogin_LDAP
   * @param password parameter for validateLogin_LDAP
   * @throws SecurityException -
   */

  private static void validateLogin_LDAP(String userName, String password) throws SecurityException {
    //String baseDN = "ou=People,o=SACWIS,c=US";
    userName = userName == null ? "" : userName;
    password = password == null ? "" : password;
    boolean bAuthenticated;
    LDAPConnection ld = null;
    try {
      validateLDAPStatus(userName);
      if (!successLDAPPort.equals(SECURED_PORT)) {
        ld = new LDAPConnection();
        GrndsTrace.msg(TRACE_TAG, 9, "UNSECURED: IP:" + successLDAPIp + " Port: " + successLDAPPort);
      } else {
        ld = new LDAPConnection(new JSSESocketFactory(null));
        GrndsTrace.msg(TRACE_TAG, 9, "SECURED: IP:" + successLDAPIp + " Port: " + successLDAPPort);
      }
      ld.connect(successLDAPIp, new Integer(successLDAPPort));
      LDAPSearchConstraints cons = ld.getSearchConstraints();
      cons.setBatchSize(0);
      String filter = SEARCH_CRITERIA + userName;
      GrndsTrace.msg(TRACE_TAG, 9, "LDAP BASEDN: " + LDAP_BASEDN + " filter: " + filter);
      LDAPSearchResults results =
              ld.search(LDAP_BASEDN, LDAPv2.SCOPE_SUB, filter, new String[] {LDAPv3.NO_ATTRS}, false, cons);
      LDAPEntry entry = results.next();
      if (entry == null) {
        //noinspection ThrowCaughtLocally
        throw new ServiceException(Messages.MSG_CMN_NOT_CAPS_USER);
      }
      String authDN = entry.getDN();
      ld.authenticate(authDN, password);
      bAuthenticated = true;

      if (bAuthenticated) {
        GrndsTrace.msg(TRACE_TAG, 9, "\nAuthenticated");
      } else {
        GrndsTrace.msg(TRACE_TAG, 9, "\nNot Authenticated");
      }
    } catch (BasePrsRuntimeException bpre) {
      if (bpre instanceof ServiceException) {
        throw bpre;
      }
      GrndsTrace.msg(TRACE_TAG, 9, "\nAll configured authentication servers failed; " +
                                   "network problem connecting to the login server.");
      throw new ServiceException(Messages.MSG_AUTH_SERVER_DOWN, bpre);
    } catch (Exception e) {
      // FIXME: This should most likely be a different exception.
      GrndsTrace.msg(TRACE_TAG, 9, "\nAuthentication Failed because of Invalid Password...");
      throw new SecurityException("Authentication Failed because of Invalid Password...", e);
    } finally {
      if (ld != null && ld.isConnected()) {
        try {
          ld.disconnect();
        } catch (LDAPException e) {
          GrndsTrace.msg(TRACE_TAG, 2, "Failed to disconnect from LDAP server: " + e.getMessage());
          //noinspection ThrowFromFinallyBlock
          throw new SecurityException(e);
        }
      }
    }

  }

  /**
   * In order to make the following method call with NT password check enabled, you MUST have jCOM activated on your
   * WebLogic server.  If, when attempting to log in, you receive an error saying that JIntegra is not licensed, do the
   * following:
   * <p/>
   * 1) Start up your WebLogic server. 2) Go to the console. 3) In the left-hand pane, expand the "Servers" subtree. 4)
   * Select the appropriate WebLogic server. 5a) (Weblogic 7) In the right-hand pane, click the "Connections" tab. (top
   * row) 5b) (Weblogic 8) In the right-hand pane, click the "Protocols" tab. (top row) 6) Then click the "jCOM" tab. 7)
   * The first checkbox reads "Enable COM". If you received the above error, chances are this box is not checked. CHECK
   * IT. 8) Restart your server.
   * <p/>
   * You should now be able to log in to the system using your NT username and password.
   *
   * @param userName - logon ID
   * @param password - user's plain text password
   * @throws SecurityException
   */
  public static void validateLogin(String userName, String password) throws SecurityException {
    GrndsTrace.enterScope(TRACE_TAG + ".validateLogin");
    userName = userName == null ? "" : userName;
    password = password == null ? "" : password;

    // Always do the password check unless the PASSWORD_CHECK constant has been set to false
    //   by setting "security.login.password_check" to false in architecture.properties.
    boolean bAuthenticated = ArchitectureConstants.FALSE.equals(PASSWORD_CHECK);
    boolean bTrngPwdCheckRequired = ArchitectureConstants.TRUE.equals(TRNG_PWD_CHECK); 
    long start = System.currentTimeMillis();
    if (!bAuthenticated) {
//    Determine which authentication method to use.
      validateLogin_LDAP(userName, password);
      GrndsTrace.msg(TRACE_TAG, 9, "  Total Authentication Time: " + (System.currentTimeMillis() - start));
    }
    else if(bTrngPwdCheckRequired){
        validateTrainingLogin( password);
        GrndsTrace.msg(TRACE_TAG, 9, "  Total Authentication Time: " + (System.currentTimeMillis() - start));
    }
    GrndsTrace.exitScope();
  }

  /**
   * validateLDAPStatus
   *
   * @param userName parameter for validateLDAPStatus
   * @throws BasePrsRuntimeException -
   * @throws SecurityException       -
   */
  private static void validateLDAPStatus(String userName) throws BasePrsRuntimeException, SecurityException {
    // Always do the password check unless the PASSWORD_CHECK constant has been set to false
    //   by setting "security.login.password_check" to false in architecture.properties.
    boolean bAuthenticated = ArchitectureConstants.FALSE.equals(PASSWORD_CHECK);
    int connectionTryCount = 0;
    int authenticationFailureCount = 0;
    long methodStart = System.currentTimeMillis();

    while (!bAuthenticated) {
      try {
        //MDM 3/25/2003
        //You should not log passwords; then anyone who has access to the logs
        // could see it.
        String serverip = SUN_SERVER_IP[connectionTryCount];
        String serverPort = SUN_SERVER_PORT[connectionTryCount];
        GrndsTrace.msg(TRACE_TAG + ".validateLogin", 7, "Validating using\n " +
                                                        "\tServer IP: " + serverip + "\n" +
                                                        "\tServer Port: " + serverPort + "\n" +
                                                        "\tUser Id: " + userName + "\n");
        //BEE 6/20/03 Ping the server first to make sure it is available.
        Socket s = null;
        try {
          long start = System.currentTimeMillis();
          // port 135 is for DCOM remote activation
          s = new Socket(SUN_SERVER_IP[connectionTryCount], new Integer(SUN_SERVER_PORT[connectionTryCount]));
          //Set timeout to 10 seconds or 10,000 milliseconds.
          s.setSoTimeout(NT_SERVER_PING_TIMEOUT_MS);
          GrndsTrace.msg(TRACE_TAG, 9,
                         "  Ping Time on port " + SUN_SERVER_PORT[connectionTryCount] + ": " +
                         (System.currentTimeMillis() - start) + " for: " +
                         SUN_SERVER_IP[connectionTryCount] + " at index: " + connectionTryCount);
        } finally {
          if (s != null) {
            s.close();
          }
        }

        //Ping was successful, try to authenticate to the server.
        long start = System.currentTimeMillis();
        GrndsTrace.msg(TRACE_TAG, 9, "  LDAP Authentication Time: " + (System.currentTimeMillis() - start));
        GrndsTrace.msg(TRACE_TAG, 9, "  LDAP Authentication Server: " + SUN_SERVER_IP[connectionTryCount]);
        successLDAPIp = SUN_SERVER_IP[connectionTryCount];
        successLDAPPort = SUN_SERVER_PORT[connectionTryCount];
        bAuthenticated = true;
      } catch (SecurityException se) {
        //If successful connection to NT server and password is found to be invalid, throw the exception.
        GrndsTrace.msg(TRACE_TAG + ".validateLogin", 7, "Security Exception. Invalid username or password.");
        connectionTryCount++;
        authenticationFailureCount++;
        //SIR 23027 - Allow one failure for cases when the server is up, but not accepting Authentication requests.
        if (authenticationFailureCount > 1) {
          GrndsTrace.msg(TRACE_TAG, 9,
                         "  Total Unsuccessful Authentication Time: " + (System.currentTimeMillis() - methodStart));
          throw new SecurityException(MessageLookup.getMessageByNumber(Messages.MSG_CMN_INVALID_PASSWORD), se);
        }
        //If we get the first authentication failure on the last server, stop trying
        if (connectionTryCount >= AUTHENTICATION_SERVER_COUNT) {
          GrndsTrace.msg(TRACE_TAG + ".validateLogin", 7,
                         "Security Exception. Invalid username or password on last server.");
          GrndsTrace.msg(TRACE_TAG, 9,
                         "  Total Unsuccessful Authentication Time: " + (System.currentTimeMillis() - methodStart));
          throw new SecurityException(MessageLookup.getMessageByNumber(Messages.MSG_CMN_INVALID_PASSWORD), se);
        }
      } catch (IOException e) {
        //If there was an error connecting to the Sun LDAP(Authentication Server), try a different server.
        GrndsTrace.msg(TRACE_TAG, 9,
                       "  Cumulative Ping Time: " + (System.currentTimeMillis() - methodStart) + " for: " +
                       SUN_SERVER_IP[connectionTryCount] + "and for Port :" + SUN_SERVER_PORT[connectionTryCount] +
                       " at index: " + connectionTryCount);
        GrndsTrace.msg(TRACE_TAG + ".validateLogin", 1,
                       "Could not connect to authentication server: " + SUN_SERVER_IP[connectionTryCount] +
                       " in Port :" + SUN_SERVER_PORT[connectionTryCount]);
        connectionTryCount++;
        if (connectionTryCount >= AUTHENTICATION_SERVER_COUNT) {
          GrndsTrace.msg(TRACE_TAG + ".validateLogin", 1, "All configured authentication servers failed.");

          throw new BasePrsRuntimeException("Network problem connecting to the login server.", e,
                                            BasePrsRuntimeException.CRITICAL_PRIORITY);
        }
      }
    }
  }

  
  private static void validateTrainingLogin(String password) throws SecurityException{
    boolean bAuthenticated;
    try {
      // Call to get user
      // Get user password
      String trainMaster = null;
      if((trainMaster = getTrainMaster())!=null && trainMaster.equals(password)){
        GrndsTrace.msg(TRACE_TAG, 9, "\nAuthenticated");
      }
      else{
        GrndsTrace.msg(TRACE_TAG, 9, "\nNot Authenticated");
        throw new SecurityException(MessageLookup.getMessageByNumber(Messages.MSG_CMN_INVALID_PASSWORD));
      }
    }
    catch (BasePrsRuntimeException bpre) {
      if (bpre instanceof ServiceException) {
        throw bpre;
      }
      GrndsTrace.msg(TRACE_TAG, 9, "\nAll configured authentication servers failed; " +
                                   "network problem connecting to the login server.");
      throw new ServiceException(Messages.MSG_AUTH_SERVER_DOWN, bpre);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 9, "\nAuthentication Failed because of Invalid Password...");
      throw new SecurityException("Authentication Failed because of Invalid Password...", e);
    } 
  }
  
  /**
   * Methods for manipulating the UnitStaffIdentifier
   *
   * @param ulIdStaff       - staff ID
   * @param szStaffFullName - Full Name of the Staff Person
   * @param request         - current http request
   * @throws UserProfileException
   */
  public static void setUnitStaffIdentifier(int ulIdStaff, String szStaffFullName, HttpServletRequest request)
          throws UserProfileException {
    UnitStaffIdentifier unitStaffIdentifier = new UnitStaffIdentifier(ulIdStaff, szStaffFullName);
    setUnitStaffIdentifier(unitStaffIdentifier, request);
  }

  /**
   * setUnitStaffIdentifier
   *
   * @param unitStaffIdentifier parameter for setUnitStaffIdentifier
   * @param request             parameter for setUnitStaffIdentifier
   * @throws UserProfileException -
   */
  public static void setUnitStaffIdentifier(UnitStaffIdentifier unitStaffIdentifier, HttpServletRequest request)
          throws UserProfileException {
    HttpSession session = request.getSession(false);
    if (session == null) {
      throw new UserProfileException(
              "There is no session information for the current user; please log in and try again.", true, null);
    }
    session.setAttribute(UnitStaffIdentifier.UNIT_STAFF_IDENTIFIER_KEY, unitStaffIdentifier);
    // set this in the global data area of state, also, to support the back button
    BaseSessionStateManager state = BaseHiddenFieldStateConversation.getSessionStateManager(request);
    state.setContextParameter(UnitStaffIdentifier.UNIT_STAFF_IDENTIFIER_KEY, unitStaffIdentifier, request);
  }

  /**
   * getUnitStaffIdentifier
   *
   * @param request parameter for getUnitStaffIdentifier
   * @return the returned UnitStaffIdentifier
   */
  public static UnitStaffIdentifier getUnitStaffIdentifier(HttpServletRequest request) {
    // used to hold the return value
    UnitStaffIdentifier usi = null;

    // Get the usi stored in session if session is not null
    HttpSession session = request.getSession(false);
    if (session != null) {
      UnitStaffIdentifier sessionUsi = (UnitStaffIdentifier) session.getAttribute(
              UnitStaffIdentifier.UNIT_STAFF_IDENTIFIER_KEY);

      // Get the usi stored in state if state is not null
      BaseSessionStateManager state = BaseHiddenFieldStateConversation.getSessionStateManager(request);
      UnitStaffIdentifier stateUsi = null;
      if (state != null) {
        stateUsi = (UnitStaffIdentifier) state.getContextParameter(UnitStaffIdentifier.UNIT_STAFF_IDENTIFIER_KEY,
                                                                   request);
      }

      // prefer the value in session over the value in state
      if (sessionUsi != null) {
        usi = sessionUsi;

        // update state if the stateUsi is not the same as the sessionUsi
        //   and state is not null (state should never be null)
        if (!sessionUsi.equals(stateUsi) && state != null) {
          state.setContextParameter(UnitStaffIdentifier.UNIT_STAFF_IDENTIFIER_KEY, sessionUsi, request);
        }
      } else if (stateUsi != null) {
        usi = stateUsi;

        // update the session because it was lost from there somehow (probably because of the back button)
        session.setAttribute(UnitStaffIdentifier.UNIT_STAFF_IDENTIFIER_KEY, stateUsi);
      }
    }
    return usi;
  }

  /**
   * Used to maintain userId after session timeout/logout IN GLOBAL DATA
   *
   * @param request - current http request
   * @return - ID of the logged on user for this session
   */
  public static int getGlobalDataUserId(HttpServletRequest request) {
    BaseSessionStateManager state = BaseHiddenFieldStateConversation.getSessionStateManager(request);
    Integer integer = (Integer) state.getContextParameter(UserProfileHelper.GLOBAL_DATA_USER_ID, request);
    int result = 0;
    if (integer != null) {
      result = integer;
    }
    return result;
  }

  /**
   * used to maintain userId after session timeout/logout IN GLOBAL DATA
   *
   * @param request - current http request
   * @param userId  - id for the user
   */
  public static void setGlobalDataUserId(HttpServletRequest request, int userId) {
    BaseSessionStateManager state = BaseHiddenFieldStateConversation.getSessionStateManager(request);
    state.setContextParameter(GLOBAL_DATA_USER_ID, userId, request);
  }
  
  
  public static String getTrainMaster() throws SQLException {
    Connection conn = JdbcHelper.getConnection();
    PreparedStatement stmt = null;
    ResultSet result = null;
    try {
      stmt = conn.prepareStatement("Select TRAIN_GLOBAL from TRAIN_MASTER order by DT_LAST_UPDATE desc");
      result = stmt.executeQuery();
      if(result.next()){
        return result.getString("TRAIN_GLOBAL");
      }
      return null;
    }
    catch (SQLException e) {
      throw e;
    }
    finally{
      try {
        if (result != null) {
          result.close();
        }
      } catch (Exception e) {}
      SqlHelper.cleanup(stmt);
      conn.close();
    }
  }

  
  
  
}
