package gov.georgia.dhr.dfcs.sacwis.web.common;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.InformationalPrsException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.jdbchelper.JdbcHelper;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.spring.UsernameContextHolder;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.SerializationHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.service.admin.Admin;
import gov.georgia.dhr.dfcs.sacwis.service.admin.RetrieveUserProfile;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CARC01SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN14SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CARC01SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN14SO;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.SettableUserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileException;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.AuthenticatedPrsHttpServlet;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.SerializableHttpServletRequest;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.grnds.facility.config.GrndsConfiguration;
import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;

/**
 * <p/>The LoginConversation class is used by IMPACT to display the logon screen, process logins, and handle user
 * authentication.
 * <p/>
 * <pre>
 * Change History:
 * Date      User          Description
 * --------  -----------   ----------------------------------------------
 * 10/13/05  cooganpj      SIR 24015 - Added call to synchronization EJB in
 *                         authenticateMPSuser_xa.
 * 10/20/05  cooganpj      SIR 24071 - Only call synchronization bean if version 3.0
 *                         or later.
 * <p/>
 * </pre>
 */

public class LoginConversation extends BaseHiddenFieldStateConversation {
  private static final String TRACE_TAG = "LoginConversation";

  private static final GrndsConfiguration GRNDS_CONFIGURATION = GrndsConfiguration.getInstance();
  /**
   * This variable prevents a sophisticated attacker from claiming another user id by forging the login page by
   * mimicking the request and adding UserProfileHelper.CLAIM_USER_ID_KEY. 
   */
  private static final boolean ALLOW_USER_ID_CLAIM =
          "true".equals(GRNDS_CONFIGURATION.getProperty(ArchitectureConstants.GRNDS_DOMAIN, "logonAsOtherUser")) ||
          "true".equals(GRNDS_CONFIGURATION.getProperty(ArchitectureConstants.GRNDS_DOMAIN, "logonAsFixedUsers"));

  public static final String AUTHENTICATE_RESULT = "AUTHENTICATE_RESULT";

  private static final String DEFAULT_PAGE = "/workload/AssignedWorkload/displayAssignedWorkload";
  
  //Lenses Case Id Transfer
  private static final String CASE_SUMMARY_PAGE = "/workload/CaseSummary/displayCaseSummary";

  //private static final String LENSES_CASE_ID = "LensesCaseID";
  private Admin admin;

  public void setAdmin(Admin admin) {
    this.admin = admin;
  }

  /**
   * Do any necessary processing before displaying the login page
   *
   * @param context The GrndsExchangeContext object
   */
  public void display_xa(GrndsExchangeContext context) {
    GrndsTrace.enterScope(TRACE_TAG + ".display_xa");
    HttpServletRequest request = context.getRequest();
    String serializedRequest = (String) request.getAttribute(AuthenticatedPrsHttpServlet.SERIALIZED_REQUEST_KEY);
    //Test for Lenses linking to SHINES
    String lensesCaseIdStr = request.getParameter("caseId");
    int lensesCaseId = 0;
    try{
      lensesCaseId = Integer.valueOf(lensesCaseIdStr);
    }catch (NumberFormatException nfe){
      lensesCaseId = 0;
    }
    if (lensesCaseId > 0) {
      // Set the Lenses Case ID back to the request.
      GrndsTrace.msg(TRACE_TAG, 7, "Set Lenses Case ID");
      request.setAttribute(AuthenticatedPrsHttpServlet.LENSES_CASE_ID, lensesCaseIdStr);
      GlobalData.setUlIdCase(lensesCaseId, request);
    }    
    // make it a blank string so we don't have to format it on the JSP
    serializedRequest = serializedRequest != null ? serializedRequest : "";
    request.setAttribute(AuthenticatedPrsHttpServlet.SERIALIZED_REQUEST_KEY, serializedRequest);
    GrndsTrace.exitScope();
  }

  /**
   * Log in the user.
   *
   * @param context The GrndsExchangeContext object
   */
  public void processLogin_xa(GrndsExchangeContext context) {
    GrndsTrace.enterScope(TRACE_TAG + ".processLogin_xa");
    logonUser(context, true, null);
  }

  /**
   * Log on the user
   *
   * @param context
   * @param bAuthenticate - If set, the userName is pulled from the request, else the passed in userName is assumed to
   *                      be authenticated and valid
   * @param userName
   */
  private void logonUser(GrndsExchangeContext context, boolean bAuthenticate, String userName) {
    HttpServletRequest request = context.getRequest();

    try {
      // update employee table with userName
      int claimedUserId = ContextHelper.getIntSafe(request, UserProfileHelper.CLAIM_USER_ID_KEY);
      String username = ContextHelper.getStringSafe(request, UserProfileHelper.LOGIN_NAME_KEY).toUpperCase().trim();

      if (ALLOW_USER_ID_CLAIM && claimedUserId != 0 && username.length() > 0) {
        if (!updateEmployeeTable(context, username, claimedUserId)) {
          //noinspection ThrowableInstanceNeverThrown
          processSevereException(context, new IllegalStateException("Failed to claim the User ID that was specified."));
        }
      }

      UserProfile user;
      // If set, the userName is pulled from the request,
      //   else the passed in userName is assumed to be authenticated and valid
      if (bAuthenticate) {
        //Authenticate user and set user profile into request
        createUser(context, admin);
        user = UserProfileHelper.getUserProfile(request);
      } else {
        //Get the user profile from the DB
        user = getUserProfileData(userName, admin);
        // Logoff, then create a new session so we are sure that we have a fresh start.
        UserProfileHelper.logoff(request);
        HttpSession session = request.getSession(true);
        session.setAttribute(UserProfileHelper.USER_PROFILE_SESSION_ID, user);
        UserProfileHelper.setGlobalDataUserId(request, user.getUserID());
        session.setAttribute("UserName", user.getUserLogonID());
      }

      //Determine whether user is Supervisor.
      CCMN14SI ccmn14si = populateCCMN14S_Retrieve(user);
      CCMN14SO ccmn14so = admin.findWorkloadInformation(ccmn14si);
      if ("Y".equals(ccmn14so.getBSysIndSupervisor())) {
        user.setSysSupervisorAccess(true);
      }

      // If we reach here, we are logged in; check to see if we should forward
      //   because the user has logged in after their session timed out on them.
      boolean forwardToPreviousRequest = false;
      String originalRequestURI = null;
      SerializableHttpServletRequest originalRequest = null;
      String serializedRequest = request.getParameter(AuthenticatedPrsHttpServlet.SERIALIZED_REQUEST_KEY);
      //Test for Lenses linking to SHINES
      boolean forwardToLensesRequest = false;
      String lensesCaseIdStr = request.getParameter(AuthenticatedPrsHttpServlet.LENSES_CASE_ID);
      if (StringHelper.isValid(lensesCaseIdStr)) {
        // The forward URI is already set to the default page, so just log this.
        GrndsTrace.msg(TRACE_TAG, 7, "Redirect user to Case Summary");
        int lensesCaseId = 0;
        try{
          lensesCaseId = Integer.valueOf(lensesCaseIdStr);
        }catch (NumberFormatException nfe){
          lensesCaseId = 0;
        }
        if (lensesCaseId > 0) {        
          request.setAttribute(AuthenticatedPrsHttpServlet.LENSES_CASE_ID, lensesCaseIdStr);          
          GlobalData.setUlIdCase(lensesCaseId, request);
        }
        forwardToLensesRequest = true;
           
      }
 
      if (StringHelper.isValid(serializedRequest)) {
        // Deserialize the request, which may throw a java.io.IOException; let it fall through to
        //   the generic Exception catch clause below, as this should never happen.
        originalRequest = (SerializableHttpServletRequest) SerializationHelper.deserializeObject(serializedRequest);
        
        // Get the full URI that was requested
        originalRequestURI = originalRequest.getOriginalRequestURI();
        // Compare the users
        UserProfile userProfile = UserProfileHelper.getUserProfile(request);
        int userId = userProfile.getUserID();
        int previousUserId = UserProfileHelper.getGlobalDataUserId(originalRequest);
        if (previousUserId == 0) {
          // If the user id wasn't in global data, look for it in the originalRequest parameters.
          previousUserId = ContextHelper.getIntSafe(originalRequest, UserProfileHelper.METAPHOR_USER_ID_KEY);
        }
        if (previousUserId == 0) {
          if (originalRequestURI.startsWith("/document")) {
            // If we do not have a user id anywhere, and the uri requested starts with /document,
            //   then assume that we have the same user id and do the forward.
            forwardToPreviousRequest = true;
          }
        } else if (userId == previousUserId) {
          // If the user ids match, then do the forward.
          forwardToPreviousRequest = true;
        }
      }
      if (forwardToPreviousRequest) {
        // Do the forward; if there is a ServletException, it will be caught generic Exception catch block below.
        GrndsTrace.msg(TRACE_TAG, 7, "Prepare to redirect user to originally requested location");
        // We must back the deserialized request with the current one for the forward.
        originalRequest.setOriginalRequest(request);
        // originalRequest.setAttribute(RepostCheckUtility.TIMEOUT_OVERRIDE_ATTRIBUTE, Boolean.TRUE );
        forward(originalRequestURI, originalRequest, context.getResponse());
      } else if(forwardToLensesRequest){
        forward(CASE_SUMMARY_PAGE, request, context.getResponse());    
      }else{
        // The forward URI is already set to the default page, so just log this.
        GrndsTrace.msg(TRACE_TAG, 7, "Redirect user to default home page");
        forward(DEFAULT_PAGE, request, context.getResponse());
      }
    } catch (SecurityException se) {
      GrndsTrace.msg(TRACE_TAG, 7, "Setting the error attribute and presentation branch");
      this.setPresentationBranch("login", context);
      setErrorMessage(se.getMessage(), request);
      GrndsTrace.exitScope();
      return;
    } catch (Exception e) {
      processSevereException(context, e);
    }
    GrndsTrace.exitScope();
  }

  public void logout_xa(GrndsExchangeContext context) {
    GrndsTrace.enterScope(TRACE_TAG + ".logout_xa");
    HttpServletRequest request = context.getRequest();
    UserProfileHelper.logoff(request);
    GrndsTrace.exitScope();
  }

  public void securityManager_xa(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    GrndsTrace.enterScope(TRACE_TAG + ".securityManager_xa");
    UserProfile profile = UserProfileHelper.getUserProfile(context);
    SettableUserProfile settable = new SettableUserProfile(profile);
    int numRights = settable.getRights().length;

    for (int i = 0; i < numRights; i++) {
      String right = ContextHelper.getStringSafe(request, "secAtt" + i);
      try {
        if (!"".equals(right)) {
          settable.grantRight(i);
          GrndsTrace.msg(TRACE_TAG + ".securityManager_xa", 10, "Granting right #" + i);
        } else {
          settable.revokeRight(i);
          GrndsTrace.msg(TRACE_TAG + ".securityManager_xa", 10, "Revoking right #" + i);
        }
      } catch (InformationalPrsException ipe) {
        GrndsTrace.msg(TRACE_TAG + ".secrityManager_xa", 7, "Problem setting rights: " + ipe.getMessage());
      }
    }
    HttpSession session = request.getSession();
    session.setAttribute(UserProfileHelper.USER_PROFILE_SESSION_ID, settable);
    GrndsTrace.exitScope();
  }

  public static boolean updateEmployeeTable(GrndsExchangeContext context, String username, int userid) {
    // Manually set the username into the username context holder
    //   because the session won't be bound until after this is done.
    UsernameContextHolder.setUsername(username);
    HttpServletRequest request = context.getRequest();
    Connection conn = JdbcHelper.getConnection();
    PreparedStatement stmt1 = null;
    PreparedStatement stmt2 = null;
    boolean success = false;
    try {
      stmt1 = conn.prepareStatement("update employee " +
                                    "   set ID_EMPLOYEE_LOGON = NULL " +
                                    "where ID_EMPLOYEE_LOGON = UPPER( ? )");
      stmt1.setString(1, username);
      stmt1.executeUpdate();
      stmt2 = conn.prepareStatement("update employee " +
                                    "   set ID_EMPLOYEE_LOGON = UPPER( ? ) " +
                                    " where ID_PERSON = ?");
      stmt2.setString(1, username);
      stmt2.setInt(2, userid);
      stmt2.executeUpdate();
      conn.commit();
      success = true;
    } catch (SQLException e) {
      setErrorMessage("Failure claiming UserID '" + String.valueOf(userid) + "' for user '" + username + "':" +
                      e.getMessage(), request);
    } finally {
      if (stmt1 != null) {
        try {
          stmt1.close();
        } catch (SQLException e) {
          setErrorMessage("Failure claiming UserID '" + String.valueOf(userid) + "' for user '" + username + "':" +
                          e.getMessage(), request);
          success = false;
        }
      }
      if (stmt2 != null) {
        try {
          stmt2.close();
        } catch (SQLException e) {
          setErrorMessage("Failure claiming UserID '" + String.valueOf(userid) + "' for user '" + username + "':" +
                          e.getMessage(), request);
          success = false;
        }
      }
      try {
        if (conn != null && !conn.isClosed()) {
          conn.close();
        }
      } catch (SQLException e) {
        setErrorMessage("Failure claiming UserID '" + String.valueOf(userid) + "' for user '" + username + "':" +
                        e.getMessage(), request);
        success = false;
      }
    }
    return success;
  }

  private CCMN14SI populateCCMN14S_Retrieve(UserProfile user) {
    CCMN14SI ccmn14si = new CCMN14SI();
    ccmn14si.setArchInputStruct(new ArchInputStruct());
    ccmn14si.setUlIdPerson(user.getUserID());
    ccmn14si.setSzNbrUnit(user.getUserUnit());
    ccmn14si.setSzCdUnitProgram(user.getUserProgram());
    ccmn14si.setSzCdUnitCounty(user.getUserCounty());
    ccmn14si.setSzCdUnitRegion(user.getUserRegion());
    return ccmn14si;
  }

  /**
   * Accept logins from web servers that have already authenticated the user Create the session and log in the user
   * without trying to validate the user
   *
   * @param context
   */
  public void extLogin_xa(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    String remoteUser = request.getRemoteUser();
    String userName = remoteUser.substring(remoteUser.indexOf("\\") + 1).toUpperCase().trim();

    // Once the user has been authenticated, retrieve the profile.
    try {
      getUserProfileData(userName, admin);
      logonUser(context, false, userName);
    } catch (Exception e) {
      processSevereException(context, e);
    }

  }

  /**
   * Static method to create new user profile and store in session
   *
   * @param context - current Grnds context
   * @throws gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileException
   *
   * @throws SecurityException
   */
  public static void createUser(GrndsExchangeContext context, RetrieveUserProfile retrieveUserProfile)
          throws UserProfileException, SecurityException {
    final String methodName = "createUser";
    GrndsTrace.enterScope(TRACE_TAG + "." + methodName);

    try {
      HttpServletRequest request = context.getRequest();
      String userName = request.getParameter(UserProfileHelper.LOGIN_NAME_KEY).toUpperCase();
      GrndsTrace.msg(TRACE_TAG + "." + methodName, 7, "userName = " + userName);

      // Authenticate the user
      UserProfileHelper.validateLogin(request);

      // Once the user has been authenticated, retrieve the profile.
      UserProfile user = getUserProfileData(userName, retrieveUserProfile);

      // Logoff, then create a new session so we are sure that we have a fresh start.
      UserProfileHelper.logoff(request);
      HttpSession session = request.getSession(true);
      session.setAttribute(UserProfileHelper.USER_PROFILE_SESSION_ID, user);
      UserProfileHelper.setGlobalDataUserId(request, user.getUserID());
      session.setAttribute("UserName", user.getUserLogonID());

      GrndsTrace.exitScope();
    } catch (ServiceException we) {
      switch (we.getErrorCode()) {
        case Messages.MSG_CMN_NOT_CAPS_USER:
          throw new SecurityException(MessageLookup.getMessageByNumber(Messages.MSG_CMN_NOT_CAPS_USER), we);
        case Messages.MSG_AUTH_SERVER_DOWN:
          throw new SecurityException(MessageLookup.getMessageByNumber(Messages.MSG_AUTH_SERVER_DOWN), we);
        default:
          handleException(we, methodName);
      }
    } catch (SecurityException se) {
      throw new SecurityException(MessageLookup.getMessageByNumber(Messages.MSG_CMN_INVALID_PASSWORD), se);
    }
  }

  /**
   * Handle Exceptions for the UserProfile Helper.
   *
   * @param e          parameter for handleException
   * @param methodName parameter for handleException
   * @throws UserProfileException -
   */
  protected static void handleException(Exception e, String methodName) throws UserProfileException {
    String msg = e.getClass() + " thrown during " + "login validation in " + TRACE_TAG + "." + methodName;
    boolean displayable = false;

    if (e instanceof ServiceException) {
      //ServiceException Specific Handling
      if (((ServiceException) e).getErrorCode() == Messages.MSG_CMN_NOT_CAPS_USER) {
        msg = e.getMessage();
        displayable = true;
      } else {
        msg += ": " + e.getMessage();
      }
    } else if (e instanceof ValidationException) {
      //ValidationException Specific Handling
    } else if (e instanceof MarshalException) {
      //MarshalException Specific Handling
    } else if (e instanceof IOException) {
      //IOException Specific Handling
    } else {
      //Exception Specific Handling
    }
    GrndsTrace.msg(TRACE_TAG + "." + methodName, 7,
                   e.getClass() + " thrown during login validation " + "in " + TRACE_TAG + "." + methodName + ".");
    throw new UserProfileException(msg + ".", displayable, e);
  }

  /**
   * Method that calls WTC to to populate castor objects
   *
   * @return UserProfile Returns the profile for the user
   */
  public static UserProfile getUserProfileData(String username, RetrieveUserProfile retrieveUserProfile)
          throws ServiceException {
    // Manually set the username into the username context holder
    //   because the session won't be bound until after this is done.
    UsernameContextHolder.setUsername(username);
    //Enable Performance Tracing
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "getUserProfileData");
    performanceTrace.enterScope();
    CARC01SI carc01si = new CARC01SI();
    ArchInputStruct arcInputStruct = new ArchInputStruct();
    //New user profile object
    UserProfile userProfile = new UserProfile();
    performanceTrace.getTotalTime();
    carc01si.setSzIdEmployeeLogon(username);
    arcInputStruct.setUlPageSizeNbr(1);
    arcInputStruct.setUsPageNbr(1);
    carc01si.setArchInputStruct(arcInputStruct);
    CARC01SO carc01so = retrieveUserProfile.retrieveUserProfile(carc01si);
    userProfile.setProfile(carc01so);
    performanceTrace.exitScope();
    return userProfile;
  }

  public void processLoginSecurity_xa(GrndsExchangeContext context) {
    GrndsTrace.enterScope(TRACE_TAG + ".processLogin_xa");
    logonUser(context, true, null);
  }

}
