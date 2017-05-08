package gov.georgia.dhr.dfcs.sacwis.web.common;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.InformationalPrsException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.jdbchelper.JdbcHelper;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.mail.EmailDelivery;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.spring.UsernameContextHolder;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.SerializationHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.service.admin.Admin;
import gov.georgia.dhr.dfcs.sacwis.service.admin.RetrieveUserProfile;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CARC01SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN14SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.RetrieveVendorStaffDetailSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SaveVendorStaffDetailSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ValidateLoginSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CARC01SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN14SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RetrieveVendorStaffDetailSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SaveVendorStaffDetailSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ValidateLoginSO;
import gov.georgia.dhr.dfcs.sacwis.web.core.audit.AuditLogin;
import gov.georgia.dhr.dfcs.sacwis.web.core.audit.AuditLoginRecord;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.SettableUserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileException;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.ServerSideValidationUtility;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.AuthenticatedPrsHttpServlet;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.SerializableHttpServletRequest;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;
import org.grnds.facility.config.GrndsConfiguration;
import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

/**
 * <p/>The LoginConversation class is used by IMPACT to display the logon
 * screen, process logins, and handle user authentication. <p/>
 * 
 * <pre>
 * Change History:
 * Date      User          Description
 * --------  -----------   ----------------------------------------------
 * 10/13/05  cooganpj      SIR 24015 - Added call to synchronization EJB in
 *                         authenticateMPSuser_xa.
 * 10/20/05  cooganpj      SIR 24071 - Only call synchronization bean if version 3.0
 *                         or later.
 * 10/20/09  ssubram       Added new validation for Portal
 * 11/20/09  ssubram       Added Login Audit functionality
 * 08/23/10  hnguyen       MR-067 Updated to accommodate new default pages for different users 
 * 08/27/10  htvo          MR-067: add password reset and enable login for NYTD user
 * 09/01/10  htvo          SMS#69116: replace system error with user-friendly error when user enter non-registered 
 *                         email on password reset page 
 * 09/28/10  htvo          SMS#73404: remove setPresentationBranch for password change and reset password
 *                         b/c the error screen is the same with main screen; define the default screen instead.                     
 *  
 * &lt;p/&gt;
 * </pre>
 */

public class LoginConversation extends BaseHiddenFieldStateConversation {
	private static final String TRACE_TAG = "LoginConversation";

	private static final GrndsConfiguration GRNDS_CONFIGURATION = GrndsConfiguration
			.getInstance();
	/**
	 * This variable prevents a sophisticated attacker from claiming another
	 * user id by forging the login page by mimicking the request and adding
	 * UserProfileHelper.CLAIM_USER_ID_KEY.
	 */
	private static final boolean ALLOW_USER_ID_CLAIM = "true"
			.equals(GRNDS_CONFIGURATION.getProperty(
					ArchitectureConstants.GRNDS_DOMAIN, "logonAsOtherUser"))
			|| "true".equals(GRNDS_CONFIGURATION.getProperty(
					ArchitectureConstants.GRNDS_DOMAIN, "logonAsFixedUsers"));

	public static final String AUTHENTICATE_RESULT = "AUTHENTICATE_RESULT";

	private static final String CHILD_LIST_PAGE = "/workload/PortalChildList/displayChildListAll";

	private static final String USER_PROFILE_PAGE = "/admin/VendorStaffDetail/displayUserProfileDetail";

	private static final String PORTAL_SURVEY_PAGE = "/person/PortalSurveyDetail/displayPortalSurveyDetail";

	private static final String CHANGE_PASSWORD_PAGE = "/login/Login/displayChangePassword";

	private static final String LOGIN_PAGE = "/login/Login/default";

	private static final String LOGIN_USER_TYPE = "P"; // Portal USER

	private static final Integer RESET_FAILED_ATTEMPT = 0;

	private static final Integer FIRST_FAILED_ATTEMPT = 1;

	private static final Integer MAX_NUM_OF_FAILED_ATTEMPTS = 3;

	private static final Integer NUM_OF_DAYS_FOR_PASSWORD_EXPIRES = 45;

	public static final String SELECT_USER_PASSWORD_INITIAL_LOGIN = "SELECT_USER_PASSWORD_INITIAL_LOGIN";

	private static final String SELECT_USER_PASSWORD = "SELECT_USER_PASSWORD";

	private static final String UPDATE_FAILED_LOGIN_ATTEMPT = "UPDATE_FAILED_LOGIN_ATTEMPT";

	private static final String UPDATE_NEW_PASSWORD_LOGIN_ATTEMPT = "UPDATE_NEW_PASSWORD_LOGIN_ATTEMPT";

	private static final String CHECK_PREVIOUS_PASSWORDS = "CHECK_PREVIOUS_PASSWORDS";

	private static final String COUNT_PORTAL_USER = "COUNT_PORTAL_USER";

	private static final Integer CHECK_NUM_OF_PREVIOUS_PASSWORDS = 15;

	private final static String PORTAL_REGISTRATION = "PORTAL_REGISTRATION";

	private static final String SAVE_PORTAL_REGISTRATION = "SAVE_PORTAL_REGISTRATION";

	private static final String VALIDATE_USER_EMAIL = "VALIDATE_USER_EMAIL";

	/** String SMTP */
	private static final String SMTP_HOST = GrndsConfiguration.getInstance()
			.getProperty(ArchitectureConstants.GRNDS_DOMAIN, "smtp.host.name");

	private static final String SMTP_USER_NAME = GrndsConfiguration
			.getInstance().getProperty(ArchitectureConstants.GRNDS_DOMAIN,
					"smtp.user.name");

	private static final String SMTP_USER_PASSWORD = GrndsConfiguration
			.getInstance().getProperty(ArchitectureConstants.GRNDS_DOMAIN,
					"smtp.user.password");

	private static final String SMTP_USER_EMAIL = GrndsConfiguration
			.getInstance().getProperty(ArchitectureConstants.GRNDS_DOMAIN,
					"smtp.user.email");

	private static final String SMTP_USER_DONOT_REPLY = GrndsConfiguration
			.getInstance().getProperty(ArchitectureConstants.GRNDS_DOMAIN,
					"smtp.user.donot.reply");
	private static final String DONOT_REPLY_MSG = "Do not reply";
	private Admin admin;

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	/**
	 * Do any necessary processing before displaying the login page
	 * 
	 * @param context
	 *            The GrndsExchangeContext object
	 */
	public void display_xa(GrndsExchangeContext context) {
		GrndsTrace.enterScope(TRACE_TAG + ".display_xa");
		HttpServletRequest request = context.getRequest();
		String serializedRequest = (String) request
				.getAttribute(AuthenticatedPrsHttpServlet.SERIALIZED_REQUEST_KEY);
		// make it a blank string so we don't have to format it on the JSP
		serializedRequest = serializedRequest != null ? serializedRequest : "";
		request.setAttribute(
				AuthenticatedPrsHttpServlet.SERIALIZED_REQUEST_KEY,
				serializedRequest);
		GrndsTrace.exitScope();
	}

	/**
	 * Do any necessary processing before displaying the reset password page
	 * 
	 * @param context
	 *            The GrndsExchangeContext object
	 */
	public void displayResetPassword_xa(GrndsExchangeContext context) {
		GrndsTrace.enterScope(TRACE_TAG + ".displayResetPassword_xa");
		HttpServletRequest request = context.getRequest();
		String resetPasswordSelected = ContextHelper.getStringSafe(request,
				"hdnResetPasswordSelected");
		String userName = ContextHelper.getStringSafe(request,
				UserProfileHelper.LOGIN_NAME_KEY);
		String serializedRequest = (String) request
				.getAttribute(AuthenticatedPrsHttpServlet.SERIALIZED_REQUEST_KEY);
		// make it a blank string so we don't have to format it on the JSP
		serializedRequest = serializedRequest != null ? serializedRequest : "";
		request.setAttribute(
				AuthenticatedPrsHttpServlet.SERIALIZED_REQUEST_KEY,
				serializedRequest);
		request.setAttribute(UserProfileHelper.LOGIN_NAME_KEY, userName);
		request.setAttribute("hdnResetPasswordSelected", resetPasswordSelected);
		GrndsTrace.exitScope();
	}

	/**
	 * Validate email supplied by user is a registered one for portal access.
	 * 
	 * @param context
	 */
	public void validateResetPassword_xa(GrndsExchangeContext context) {
		GrndsTrace.enterScope(TRACE_TAG + ".validateResetPassword_xa");
		BaseSessionStateManager state = getSessionStateManager(context);
		HttpServletRequest request = context.getRequest();
		ValidateLoginSI validateLoginSI = new ValidateLoginSI();
		ValidateLoginSO validateLoginSO = new ValidateLoginSO();

		String userName = ContextHelper.getStringSafe(request,
				UserProfileHelper.LOGIN_NAME_KEY).toUpperCase().trim();
		validateLoginSI.setUserName(userName);
		String resetPasswordSelected = ContextHelper.getStringSafe(request,
				"hdnResetPasswordSelected");
		// set value for validateLogin service to retrieve user based on email
		// entered
		validateLoginSI.setCrudFlag(VALIDATE_USER_EMAIL);
		try {
			validateLoginSO = admin.validateLogin(validateLoginSI);
			// User entered an e-mail address that is not registered.
			if (validateLoginSO != null) {
				if (validateLoginSO == null
						|| StringHelper.isEmptyOrNull(validateLoginSO
								.getUserName())) {
					throw new ServiceException(Messages.MSG_PORTAL_EMAIL_ERROR);
				} else if (ArchitectureConstants.Y.equals(validateLoginSO
						.getIndPasswordTemp())) {
					// FIX ME: flip to Service Ex. when DBCR comes through for new message
					throw new SecurityException(MessageLookup
							.getMessageByNumber(Messages.MSG_PORTAL_TMP_PWD_RESET_NOT_ALLOWED));
				}
			}
			// Logoff, then create a new session so we are sure that we have a
			// fresh start. 
			// SMS#69116: move getUserProfileData inside catch to catch MSG_PORTAL_EMAIL_ERROR
			UserProfile user = getUserProfileData(userName, admin);
			UserProfileHelper.logoff(request);
			HttpSession session = request.getSession(true);
			session.setAttribute(UserProfileHelper.USER_PROFILE_SESSION_ID,
					user);
			UserProfileHelper.setGlobalDataUserId(request, validateLoginSO
					.getIdUser());
			session.setAttribute("UserName", userName);

			GrndsTrace.msg(TRACE_TAG, 7,
					"Setting the error attribute and presentation branch");
			state.setAttribute("validateLoginSO", validateLoginSO, request);
			state.setAttribute("hdnResetPasswordSelected",
					resetPasswordSelected, request);
			forward(CHANGE_PASSWORD_PAGE, request, context.getResponse());
			

		} catch (ServiceException se) {
			setInformationalMessage(se.getErrorMessage(), request);
			ServerSideValidationUtility.setBRefreshWidgetsFromRequest(request,
					true);
			//this.setPresentationBranch("error_rpp", context);
			GrndsTrace.exitScope();

		} catch (SecurityException se) {
			setInformationalMessage(se.getMessage(), request);
			ServerSideValidationUtility.setBRefreshWidgetsFromRequest(request,
					true);
			//this.setPresentationBranch("error_rpp", context);
			GrndsTrace.exitScope();

		} catch (Exception e) {
			processSevereException(context, e);
		}
		GrndsTrace.exitScope();
	}

	/**
	 * Do any necessary processing before displaying the change password page
	 * 
	 * @param context
	 *            The GrndsExchangeContext object
	 */
	public void displayChangePassword_xa(GrndsExchangeContext context) {
		GrndsTrace.enterScope(TRACE_TAG + ".displayChangePassword_xa");
		HttpServletRequest request = context.getRequest();
		String serializedRequest = (String) request
				.getAttribute(AuthenticatedPrsHttpServlet.SERIALIZED_REQUEST_KEY);
		// make it a blank string so we don't have to format it on the JSP
		serializedRequest = serializedRequest != null ? serializedRequest : "";
		request.setAttribute(
				AuthenticatedPrsHttpServlet.SERIALIZED_REQUEST_KEY,
				serializedRequest);
		GrndsTrace.exitScope();
	}

	/**
	 * Log in the user.
	 * 
	 * @param context
	 *            The GrndsExchangeContext object
	 */
	public void processLogin_xa(GrndsExchangeContext context) {
		GrndsTrace.enterScope(TRACE_TAG + ".processLogin_xa");
		logonUser(context, true, null);
	}

	/**
	 * Log in the user.
	 * 
	 * @param context
	 *            The GrndsExchangeContext object
	 */
	public void processChangePassword_xa(GrndsExchangeContext context) {
		GrndsTrace.enterScope(TRACE_TAG + ".processChangePassword_xa");
		processChangePassword(context);
	}

	/**
	 * Display Vendor Staff Detail (Registration Page).
	 * 
	 * @param context
	 *            The GrndsExchangeContext object
	 */
	public void displayVendorStaffDetail_xa(GrndsExchangeContext context) {
		GrndsTrace.enterScope(TRACE_TAG + ".displayVendorStaffDetail_xa");
		HttpServletRequest request = context.getRequest();
		String serializedRequest = (String) request
				.getAttribute(AuthenticatedPrsHttpServlet.SERIALIZED_REQUEST_KEY);
		// make it a blank string so we don't have to format it on the JSP
		serializedRequest = serializedRequest != null ? serializedRequest : "";
		request.setAttribute(
				AuthenticatedPrsHttpServlet.SERIALIZED_REQUEST_KEY,
				serializedRequest);
		RetrieveVendorStaffDetailSI retrieveVendorStaffDetailSI = populateRetrieveVendorStaffDetailSI();
		RetrieveVendorStaffDetailSO retrieveVendorStaffDetailSO = admin
				.retrieveVendorStaffDetail(retrieveVendorStaffDetailSI);
		request.setAttribute("retrieveVendorStaffDetailSO",
				retrieveVendorStaffDetailSO);
		GrndsTrace.exitScope();
	}

	/**
	 * Retrieve the Resource ID to display
	 * 
	 * @return
	 */
	private RetrieveVendorStaffDetailSI populateRetrieveVendorStaffDetailSI() {
		RetrieveVendorStaffDetailSI retrieveVendorStaffDetailSI = new RetrieveVendorStaffDetailSI();
		retrieveVendorStaffDetailSI.setRetrieveFlag(PORTAL_REGISTRATION);
		return retrieveVendorStaffDetailSI;
	}

	/**
	 * Save Vendor Staff Detail (Registration Page).
	 * 
	 * @param context
	 */
	public void saveVendorStaffDetail_xa(GrndsExchangeContext context) {
		GrndsTrace.enterScope(TRACE_TAG + ".display_xa");
		HttpServletRequest request = context.getRequest();
		try {
			SaveVendorStaffDetailSI saveVendorStaffDetailSI = populateSaveVendorStaffDetailSI(context);
			SaveVendorStaffDetailSO saveVendorStaffDetailSO = admin
					.saveVendorStaffDetail(saveVendorStaffDetailSI);

			if (saveVendorStaffDetailSO != null
					&& saveVendorStaffDetailSO.isSaveFlag()) {
				// Send Email Notification
				sendMail(
						saveVendorStaffDetailSI.getTxtUserEmail(),
						MessageLookup
								.getMessageByNumber(Messages.MSG_PORTAL_EMAIL_SUBJ1),
						MessageLookup
								.getMessageByNumber(Messages.MSG_PORTAL_EMAIL_REG));
				setInformationalMessage(Messages.MSG_PORTAL_REG_CONFIRM,
						LOGIN_PAGE, request);
				forward(LOGIN_PAGE, request, context.getResponse());
			}
			GrndsTrace.exitScope();
		} catch (SecurityException se) {
			GrndsTrace.msg(TRACE_TAG, 7,
					"Setting the error attribute and presentation branch");
			this.setPresentationBranch("login", context);
			setErrorMessage(se.getMessage(), request);
			GrndsTrace.exitScope();
			return;
		} catch (Exception e) {
			processSevereException(context, e);
		}
	}

	private SaveVendorStaffDetailSI populateSaveVendorStaffDetailSI(
			GrndsExchangeContext context) throws SecurityException {
		HttpServletRequest request = context.getRequest();
		// Validate whether the email already exist in the system
		ValidateLoginSI validateLoginSI = new ValidateLoginSI();
		// Set the User name (email ID) to SI object
		validateLoginSI.setUserName(ContextHelper.getStringSafe(request,
				"txtEmail"));
		validateLoginSI.setCrudFlag(COUNT_PORTAL_USER);
		ValidateLoginSO validateLoginSO = admin.validateLogin(validateLoginSI);
		if (validateLoginSO != null && validateLoginSO.getEmailCount() > 0) {
			throw new SecurityException(MessageLookup
					.getMessageByNumber(Messages.MSG_PORTAL_DUP_REG));
		}
		SaveVendorStaffDetailSI saveVendorStaffDetailSI = new SaveVendorStaffDetailSI();
		saveVendorStaffDetailSI.setSavePage(SAVE_PORTAL_REGISTRATION);
		saveVendorStaffDetailSI.setTxtUserEmail(ContextHelper.getStringSafe(
				request, "txtEmail"));

		saveVendorStaffDetailSI.setNmUserFirst(ContextHelper.getStringSafe(
				request, "txtFirstName"));
		saveVendorStaffDetailSI.setNmUserMiddle(ContextHelper.getStringSafe(
				request, "txtMiddleInitial"));
		saveVendorStaffDetailSI.setNmUserLast(ContextHelper.getStringSafe(
				request, "txtLastName"));
		saveVendorStaffDetailSI.setTxtTitle(ContextHelper.getStringSafe(
				request, "txtTitle"));
		saveVendorStaffDetailSI.setNbrUserPhone(ContextHelper.getPhoneSafe(
				request, "txtPhoneNumber"));
		saveVendorStaffDetailSI.setNbrUserPhoneExtension(ContextHelper
				.getStringSafe(request, "txtPhoneExtension"));
		saveVendorStaffDetailSI.setAddrUserAddrStLn1(ContextHelper
				.getStringSafe(request, "txtAddress1"));
		saveVendorStaffDetailSI.setAddrUserAddrStLn2(ContextHelper
				.getStringSafe(request, "txtAddress2"));
		saveVendorStaffDetailSI.setAddrUserAddrCity(ContextHelper
				.getStringSafe(request, "txtCity"));
		saveVendorStaffDetailSI.setAddrUserAddrZip(ContextHelper.getStringSafe(
				request, "txtZip")
				+ ContextHelper.getStringSafe(request, "txtZipSuff"));
		saveVendorStaffDetailSI.setCdUserAddrState(ContextHelper.getStringSafe(
				request, "selState"));
		saveVendorStaffDetailSI.setCdUserAddrCounty(ContextHelper
				.getStringSafe(request, "selCounty"));
		saveVendorStaffDetailSI.setCdRequestType(ContextHelper.getStringSafe(
				request, "selReqType"));
		saveVendorStaffDetailSI.setCdUserType(ContextHelper.getStringSafe(
				request, "selReqType"));
		String idResource = ContextHelper.getStringSafe(request, "selVendor")
				.trim().length() <= 0 ? "0" : ContextHelper.getStringSafe(
				request, "selVendor");
		saveVendorStaffDetailSI.setIdResource(idResource);
		saveVendorStaffDetailSI.setIdResource(ContextHelper.getStringSafe(
				request, "hdnDisplayRsrcId").trim().length() <= 0 ? "0"
				: ContextHelper.getStringSafe(request, "hdnDisplayRsrcId"));
		saveVendorStaffDetailSI.setTxtOther(ContextHelper.getStringSafe(
				request, "txtOther"));
		saveVendorStaffDetailSI.setIndUserAgreement(CheckboxHelper
				.getCheckboxValue(request, "cbxUsrAgrmnt"));
		saveVendorStaffDetailSI.setCdQuestion1(ContextHelper.getStringSafe(
				request, "selSecQues1"));
		saveVendorStaffDetailSI.setCdQuestion2(ContextHelper.getStringSafe(
				request, "selSecQues2"));
		saveVendorStaffDetailSI.setCdQuestion3(ContextHelper.getStringSafe(
				request, "selSecQues3"));
		saveVendorStaffDetailSI.setTxtAnswer1(ContextHelper.getStringSafe(
				request, "txtSecAns1"));
		saveVendorStaffDetailSI.setTxtAnswer2(ContextHelper.getStringSafe(
				request, "txtSecAns2"));
		saveVendorStaffDetailSI.setTxtAnswer3(ContextHelper.getStringSafe(
				request, "txtSecAns3"));
		saveVendorStaffDetailSI.setTxtPassword(ContextHelper.getStringSafe(
				request, "txtNewPassword"));
		saveVendorStaffDetailSI.setNbrFailedLoginAttempts(RESET_FAILED_ATTEMPT);
		saveVendorStaffDetailSI.setCdStatus(CodesTables.CUSRSTAT_PEN);
		saveVendorStaffDetailSI.setDtLastPasswdReset(new Date());
		return saveVendorStaffDetailSI;
	}

	/**
	 * Log on the user
	 * 
	 * @param context
	 * @param bAuthenticate -
	 *            If set, the userName is pulled from the request, else the
	 *            passed in userName is assumed to be authenticated and valid
	 * @param userName
	 */
	private void logonUser(GrndsExchangeContext context, boolean bAuthenticate,
			String userName) {
		BaseSessionStateManager state = getSessionStateManager(context);
		HttpServletRequest request = context.getRequest();
		ValidateLoginSO validateLoginSO = new ValidateLoginSO();
		try {
			// update portal_user table with userName
			int claimedUserId = ContextHelper.getIntSafe(request,
					UserProfileHelper.CLAIM_USER_ID_KEY);
			String username = ContextHelper.getStringSafe(request,
					UserProfileHelper.LOGIN_NAME_KEY).toUpperCase().trim();
			String typedPassword = ContextHelper.getStringSafe(request,
					UserProfileHelper.PASSWORD_KEY).trim();
			if (ALLOW_USER_ID_CLAIM && claimedUserId != 0
					&& username.length() > 0) {
				if (!updatePortalUserTable(context, username, claimedUserId)) {
					// no inspection ThrowableInstanceNeverThrown
					processSevereException(context, new IllegalStateException(
							"Failed to claim the User ID that was specified."));
				}
			}

			UserProfile user;
			// If set, the userName is pulled from the request,
			// else the passed in userName is assumed to be authenticated and
			// valid
			if (bAuthenticate) {
				String bPasswordCheck = UserProfileHelper.PASSWORD_CHECK;
				// Authenticate the user against the DB encrypted password only
				// if the password check is enforced.
				if ("true".equals(bPasswordCheck)) {
					validateLoginSO = validateLogin(context, username,
							typedPassword);
				}
				// Authenticate user and set user profile into request
				createUser(context, admin);
				user = UserProfileHelper.getUserProfile(request);
			} else {
				// Get the user profile from the DB
				user = getUserProfileData(userName, admin);
				// Logoff, then create a new session so we are sure that we have
				// a fresh start.
				UserProfileHelper.logoff(request);
				HttpSession session = request.getSession(true);
				session.setAttribute(UserProfileHelper.USER_PROFILE_SESSION_ID,
						user);
				UserProfileHelper
						.setGlobalDataUserId(request, user.getUserID());
				session.setAttribute("UserName", user.getUserLogonID());
			}
			// MR-067: NYTD youth do not have tie to resource.
			// Set generic indicator whether resource association should be
			// enforced.
			// This boolean logic relies on youth and vendor profile are
			// mutually exclusive which is true by design.
			boolean bBypassResourceCheck = user.hasRight(UserProfile.NYTD_USER);
			boolean bNytdYouthUser = user.hasRight(UserProfile.NYTD_USER);
			String cdNytdLoginDest = "U"; // U = User Profile page; S = Survey
			// page
			// User attempts to login but no open association exists for the
			// user.
			if (!bBypassResourceCheck && user != null
					&& user.getRsrcMap().isEmpty()) {
				throw new ServiceException(Messages.MSG_PORTAL_USER_LINK);
				/*
				 * throw new SecurityException(MessageLookup.getMessageByNumber(
				 * Messages.MSG_PORTAL_USER_LINK));
				 */
			}
			// Determine whether user is Supervisor.
			CCMN14SI ccmn14si = populateCCMN14S_Retrieve(user);
			CCMN14SO ccmn14so = admin.findWorkloadInformation(ccmn14si);
			if ("Y".equals(ccmn14so.getBSysIndSupervisor())) {
				user.setSysSupervisorAccess(true);
			}

			// If we reach here, we are logged in; check to see if we should
			// forward
			// because the user has logged in after their session timed out on
			// them.
			boolean forwardToPreviousRequest = false;
			String originalRequestURI = null;
			SerializableHttpServletRequest originalRequest = null;
			String serializedRequest = request
					.getParameter(AuthenticatedPrsHttpServlet.SERIALIZED_REQUEST_KEY);
			if (StringHelper.isValid(serializedRequest)) {
				// Deserialize the request, which may throw a
				// java.io.IOException; let it fall through to
				// the generic Exception catch clause below, as this should
				// never happen.
				originalRequest = (SerializableHttpServletRequest) SerializationHelper
						.deserializeObject(serializedRequest);

				// Get the full URI that was requested
				originalRequestURI = originalRequest.getOriginalRequestURI();

				// Compare the users
				UserProfile userProfile = UserProfileHelper
						.getUserProfile(request);
				int userId = userProfile.getUserID();
				int previousUserId = UserProfileHelper
						.getGlobalDataUserId(originalRequest);
				if (previousUserId == 0) {
					// If the user id wasn't in global data, look for it in the
					// originalRequest parameters.
					previousUserId = ContextHelper.getIntSafe(originalRequest,
							UserProfileHelper.METAPHOR_USER_ID_KEY);
				}
				if (previousUserId == 0) {
					if (originalRequestURI.startsWith("/document")) {
						// If we do not have a user id anywhere, and the uri
						// requested starts with /document,
						// then assume that we have the same user id and do the
						// forward.
						forwardToPreviousRequest = true;
					}
				} else if (userId == previousUserId) {
					// If the user ids match, then do the foward.
					forwardToPreviousRequest = true;
				}
				// User attempts to login but no open association exists for the
				// user.
				// MR-067: to exclude NYTD youth user who do not have resource
				// association therefore bBypassResourceCheck = true
				// See first reference of bBypassResourceCheck for more detail.
				if (!bBypassResourceCheck && userProfile != null
						&& userProfile.getRsrcMap().isEmpty()) {
					throw new ServiceException(Messages.MSG_PORTAL_USER_LINK);
					/*
					 * throw new
					 * SecurityException(MessageLookup.getMessageByNumber(
					 * Messages.MSG_PORTAL_USER_LINK));
					 */
				}
			}
			if (forwardToPreviousRequest) {
				// Do the forward; if there is a ServletException, it will be
				// caught generic Exception catch block below.
				GrndsTrace
						.msg(TRACE_TAG, 7,
								"Prepare to redirect user to originally requested location");
				// We must back the deserialized request with the current one
				// for the forward.
				originalRequest.setOriginalRequest(request);
				// originalRequest.setAttribute(RepostCheckUtility.TIMEOUT_OVERRIDE_ATTRIBUTE,
				// Boolean.TRUE );
				forward(originalRequestURI, originalRequest, context
						.getResponse());
			} else {
				// MR-067: to differentiate existing user that has tmp password
				// from new user
				// (NYTD user) that has tmp password and no security questions
				// set.
				// For existing user + tmp pwd: route to password change page
				boolean bSecQuestionsSet = isSecurityQuestionSet(validateLoginSO
						.getCdQuestion());
				if (validateLoginSO.getIndPasswordTemp() != null
						&& ArchitectureConstants.Y.equals(validateLoginSO
								.getIndPasswordTemp()) && bSecQuestionsSet) {
					// Set validateLoginSO to the state
					state.setAttribute("validateLoginSO", validateLoginSO,
							request);
					// The forward URI is Change Password page, so just log
					// this.
					GrndsTrace.msg(TRACE_TAG, 7,
							"Redirect user to Change Password Page");
					//
					setInformationalMessage(Messages.MSG_PORTAL_TEMP_LOGIN,
							CHANGE_PASSWORD_PAGE, request);
					forward(CHANGE_PASSWORD_PAGE, request, context
							.getResponse());
				} else {

					Date today = new Date();
					Date passwordDate = validateLoginSO
							.getDtLastPasswordReset() != null ? validateLoginSO
							.getDtLastPasswordReset() : today;
					double minutesBetween = DateHelper.minutesDifference(today,
							passwordDate);
					double daysBetween = minutesBetween / 1440;
					double daysUntilDue = NUM_OF_DAYS_FOR_PASSWORD_EXPIRES
							- Math.round(daysBetween);

					if (daysUntilDue <= 15) {
						// FIX ME: Replace with message constant
						String message = "ATTENTION: Your password will expire within %f days.  Please navigate to the Profile page to enter a new password.";
						message = MessageLookup.addMessageParameter(message,
								daysUntilDue, 0);
						setInformationalMessage(message, getDefaultPage(user,
								validateLoginSO, context), request);
					}

					// The forward URI is already set to the default page, so
					// just log this.
					GrndsTrace.msg(TRACE_TAG, 7,
							"Redirect user to default home page");
					// MR-067: Added for new route for youth from login to
					// youth's default page (Profile/Survey)
					state
							.setAttribute("hdnUlIdUser", user.getUserID(),
									request);
					state.setAttribute("validateLoginSO", validateLoginSO,
							request);

					forward(getDefaultPage(user, validateLoginSO, context),
							request, context.getResponse());
				}
			}
			// Insert Successful Login to the Audit
			doLoginAudit(context, ArchitectureConstants.Y, 0);
		} catch (ServiceException se) {
			// Insert Failed Login to the Audit
			doLoginAudit(context, ArchitectureConstants.N, se.getErrorCode());
			GrndsTrace.msg(TRACE_TAG, 7,
					"Setting the error attribute and presentation branch");
			this.setPresentationBranch("login", context);
			setErrorMessage(se.getMessage(), request);
			GrndsTrace.exitScope();
			return;
		} catch (SecurityException se) {
			// Insert Failed Login to the Audit
			doLoginAudit(context, ArchitectureConstants.N, 0);
			GrndsTrace.msg(TRACE_TAG, 7,
					"Setting the error attribute and presentation branch");
			this.setPresentationBranch("login", context);
			setErrorMessage(se.getMessage(), request);
			GrndsTrace.exitScope();
			return;
		} catch (Exception e) {
			// Insert Failed Login to the Audit
			doLoginAudit(context, ArchitectureConstants.N, 0);
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
					GrndsTrace.msg(TRACE_TAG + ".securityManager_xa", 10,
							"Granting right #" + i);
				} else {
					settable.revokeRight(i);
					GrndsTrace.msg(TRACE_TAG + ".securityManager_xa", 10,
							"Revoking right #" + i);
				}
			} catch (InformationalPrsException ipe) {
				GrndsTrace.msg(TRACE_TAG + ".secrityManager_xa", 7,
						"Problem setting rights: " + ipe.getMessage());
			}
		}
		HttpSession session = request.getSession();
		session.setAttribute(UserProfileHelper.USER_PROFILE_SESSION_ID,
				settable);
		GrndsTrace.exitScope();
	}

	public static boolean updatePortalUserTable(GrndsExchangeContext context,
			String username, int userid) {
		// Manually set the username into the username context holder
		// because the session won't be bound until after this is done.
		UsernameContextHolder.setUsername(username);
		HttpServletRequest request = context.getRequest();
		Connection conn = JdbcHelper.getConnection();
		PreparedStatement stmt1 = null;
		PreparedStatement stmt2 = null;
		boolean success = false;
		try {
			stmt1 = conn.prepareStatement("update portal_user "
					+ "   set TXT_USER_EMAIL = NULL "
					+ "where TXT_USER_EMAIL = UPPER( ? )");
			stmt1.setString(1, username);
			stmt1.executeUpdate();
			stmt2 = conn.prepareStatement("update portal_user "
					+ "   set TXT_USER_EMAIL = UPPER( ? ) "
					+ " where ID_USER = ?");
			stmt2.setString(1, username);
			stmt2.setInt(2, userid);
			stmt2.executeUpdate();
			conn.commit();
			success = true;
		} catch (SQLException e) {
			setErrorMessage("Failure claiming UserID '"
					+ String.valueOf(userid) + "' for user '" + username + "':"
					+ e.getMessage(), request);
		} finally {
			if (stmt1 != null) {
				try {
					stmt1.close();
				} catch (SQLException e) {
					setErrorMessage("Failure claiming UserID '"
							+ String.valueOf(userid) + "' for user '"
							+ username + "':" + e.getMessage(), request);
					success = false;
				}
			}
			if (stmt2 != null) {
				try {
					stmt2.close();
				} catch (SQLException e) {
					setErrorMessage("Failure claiming UserID '"
							+ String.valueOf(userid) + "' for user '"
							+ username + "':" + e.getMessage(), request);
					success = false;
				}
			}
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException e) {
				setErrorMessage("Failure claiming UserID '"
						+ String.valueOf(userid) + "' for user '" + username
						+ "':" + e.getMessage(), request);
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
	 * Accept logins from web servers that have already authenticated the user
	 * Create the session and log in the user without trying to validate the
	 * user
	 * 
	 * @param context
	 */
	public void extLogin_xa(GrndsExchangeContext context) {
		HttpServletRequest request = context.getRequest();
		String remoteUser = request.getRemoteUser();
		String userName = remoteUser.substring(remoteUser.indexOf("\\") + 1)
				.toUpperCase().trim();

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
	 * @param context -
	 *            current Grnds context
	 * @throws gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileException
	 * 
	 * @throws SecurityException
	 */
	public static void createUser(GrndsExchangeContext context,
			RetrieveUserProfile retrieveUserProfile)
			throws UserProfileException, SecurityException, ServiceException {
		final String methodName = "createUser";
		GrndsTrace.enterScope(TRACE_TAG + "." + methodName);

		try {
			HttpServletRequest request = context.getRequest();
			String userName = request.getParameter(
					UserProfileHelper.LOGIN_NAME_KEY).toUpperCase();
			GrndsTrace.msg(TRACE_TAG + "." + methodName, 7, "userName = "
					+ userName);

			// UserProfileHelper.validateLogin(request);

			// Once the user has been authenticated, retrieve the profile.
			UserProfile user = getUserProfileData(userName, retrieveUserProfile);

			// Logoff, then create a new session so we are sure that we have a
			// fresh start.
			UserProfileHelper.logoff(request);
			HttpSession session = request.getSession(true);
			session.setAttribute(UserProfileHelper.USER_PROFILE_SESSION_ID,
					user);
			UserProfileHelper.setGlobalDataUserId(request, user.getUserID());
			session.setAttribute("UserName", user.getUserLogonID());

			GrndsTrace.exitScope();
		} catch (ServiceException we) {
			switch (we.getErrorCode()) {
			case Messages.MSG_CMN_NOT_CAPS_USER:
				throw new ServiceException(Messages.MSG_CMN_NOT_CAPS_USER);
				// throw new
				// SecurityException(MessageLookup.getMessageByNumber(Messages.MSG_CMN_NOT_CAPS_USER),
				// we);
			case Messages.MSG_AUTH_SERVER_DOWN:
				throw new ServiceException(Messages.MSG_AUTH_SERVER_DOWN);
				// throw new
				// SecurityException(MessageLookup.getMessageByNumber(Messages.MSG_AUTH_SERVER_DOWN),
				// we);
			default:
				handleException(we, methodName);
			}
		} catch (SecurityException se) {
			throw new ServiceException(Messages.MSG_CMN_INVALID_PASSWORD);
			// throw new
			// SecurityException(MessageLookup.getMessageByNumber(Messages.MSG_CMN_INVALID_PASSWORD),
			// se);
		}
	}

	/**
	 * Handle Exceptions for the UserProfile Helper.
	 * 
	 * @param e
	 *            parameter for handleException
	 * @param methodName
	 *            parameter for handleException
	 * @throws UserProfileException -
	 */
	protected static void handleException(Exception e, String methodName)
			throws UserProfileException {
		String msg = e.getClass() + " thrown during " + "login validation in "
				+ TRACE_TAG + "." + methodName;
		boolean displayable = false;

		if (e instanceof ServiceException) {
			// ServiceException Specific Handling
			if (((ServiceException) e).getErrorCode() == Messages.MSG_CMN_NOT_CAPS_USER) {
				msg = e.getMessage();
				displayable = true;
			} else {
				msg += ": " + e.getMessage();
			}
		} else if (e instanceof ValidationException) {
			// ValidationException Specific Handling
		} else if (e instanceof MarshalException) {
			// MarshalException Specific Handling
		} else if (e instanceof IOException) {
			// IOException Specific Handling
		} else {
			// Exception Specific Handling
		}
		GrndsTrace.msg(TRACE_TAG + "." + methodName, 7, e.getClass()
				+ " thrown during login validation " + "in " + TRACE_TAG + "."
				+ methodName + ".");
		throw new UserProfileException(msg + ".", displayable, e);
	}

	/**
	 * Method that calls WTC to to populate castor objects
	 * 
	 * @return UserProfile Returns the profile for the user
	 */
	public static UserProfile getUserProfileData(String username,
			RetrieveUserProfile retrieveUserProfile) throws ServiceException {
		// Manually set the username into the username context holder
		// because the session won't be bound until after this is done.
		UsernameContextHolder.setUsername(username);
		// Enable Performance Tracing
		PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG,
				"getUserProfileData");
		performanceTrace.enterScope();
		CARC01SI carc01si = new CARC01SI();
		ArchInputStruct arcInputStruct = new ArchInputStruct();
		// New user profile object
		UserProfile userProfile = new UserProfile();
		performanceTrace.getTotalTime();
		carc01si.setSzIdEmployeeLogon(username);
		arcInputStruct.setUlPageSizeNbr(1);
		arcInputStruct.setUsPageNbr(1);
		carc01si.setArchInputStruct(arcInputStruct);
		carc01si.setBIndLoginPersonType(LOGIN_USER_TYPE);
		CARC01SO carc01so = retrieveUserProfile.retrieveUserProfile(carc01si);
		userProfile.setProfile(carc01so);
		performanceTrace.exitScope();
		return userProfile;
	}

	public void processLoginSecurity_xa(GrndsExchangeContext context) {
		GrndsTrace.enterScope(TRACE_TAG + ".processLogin_xa");
		logonUser(context, true, null);
	}

	// Thrown Service Exception in order to capture the Message Number for the
	// Login Audit purpose.
	private ValidateLoginSO validateLogin(GrndsExchangeContext context,
			String userName, String typedPassword) throws ServiceException {
		HttpServletRequest request = context.getRequest();
		ValidateLoginSI validateLoginSI = new ValidateLoginSI();
		// Set the User name (email ID) to SI object
		validateLoginSI.setUserName(userName);
		// Get the IP address of the user to store in the Audit table
		validateLoginSI.setIpAddr(request.getRemoteAddr());
		validateLoginSI.setCrudFlag(SELECT_USER_PASSWORD_INITIAL_LOGIN);
		// Get the decrypted password
		ValidateLoginSO validateLoginSO = admin.validateLogin(validateLoginSI);
		if (validateLoginSO != null) {
			// User attempts to login with an e-mail address that is not
			// registered.
			if (validateLoginSO.getUserName() == null) {
				throw new ServiceException(Messages.MSG_PORTAL_EMAIL_ERROR);
			}
			// Get the values
			String indPasswordTemp = validateLoginSO.getIndPasswordTemp();
			String actualPassword = (String) validateLoginSO.getPassword() != null ? (String) validateLoginSO
					.getPassword()
					: "";
			Date dtPasswordLastReset = validateLoginSO.getDtLastPasswordReset();
			Integer numOfFailedLogins = validateLoginSO.getNumOfFailedLogins();
			String cdStatus = validateLoginSO.getCdStatus();
			if (cdStatus != null && cdStatus.equals(CodesTables.CUSRSTAT_PEN)) {
				throw new ServiceException(Messages.MSG_PORTAL_LOGIN_PENDING);
			}
			// User attempts to login to Portal after 3 subsequent login
			// attempts that failed.
			if (numOfFailedLogins != null
					&& numOfFailedLogins >= MAX_NUM_OF_FAILED_ATTEMPTS) {
				throw new ServiceException(Messages.MSG_PORTAL_PWD_LOCKED);
				/*
				 * throw new SecurityException(MessageLookup.getMessageByNumber(
				 * Messages.MSG_PORTAL_PWD_LOCKED));
				 */
			}

			// When a user logs in using a temporary password, the page reloads
			// with change password page
			if (indPasswordTemp != null
					&& ArchitectureConstants.Y.equals(indPasswordTemp)) {
				if (!actualPassword.equals(typedPassword)) {
					// Record the unsuccessful login attempts back to the DB
					if (numOfFailedLogins == null) {
						numOfFailedLogins = FIRST_FAILED_ATTEMPT;
					} else {
						numOfFailedLogins++;
					}
					validateLoginSI.setCrudFlag(UPDATE_FAILED_LOGIN_ATTEMPT);
					validateLoginSI.setNumOfFailedLogins(numOfFailedLogins);
					admin.validateLogin(validateLoginSI);
					// Password didn't match throwing Security Exception.
					throw new ServiceException(
							Messages.MSG_CMN_INVALID_PASSWORD);
				} else {
					return validateLoginSO;
				}
			}

			if (!actualPassword.equals(typedPassword)) {
				// Record the unsuccessful login attempts back to the DB
				if (numOfFailedLogins == null) {
					numOfFailedLogins = FIRST_FAILED_ATTEMPT;
				} else {
					numOfFailedLogins++;
				}
				validateLoginSI.setCrudFlag(UPDATE_FAILED_LOGIN_ATTEMPT);
				validateLoginSI.setNumOfFailedLogins(numOfFailedLogins);
				admin.validateLogin(validateLoginSI);
				// Password didn't match throwing Security Exception.
				throw new ServiceException(Messages.MSG_CMN_INVALID_PASSWORD);
			} else // User attempts to login to Portal with a password that is
			// correct but has not been updated within 45 days.
			if (dtPasswordLastReset != null
					&& DateHelper.isAfter(new Date(), DateHelper.addToDate(
							dtPasswordLastReset, 0, 0,
							NUM_OF_DAYS_FOR_PASSWORD_EXPIRES))) {
				throw new ServiceException(Messages.MSG_PORTAL_PWD_EXPIRED);
			}
		}
		// Reset the Number of Failed Login attempts back to 0 after a
		// successful login
		validateLoginSI.setCrudFlag(UPDATE_FAILED_LOGIN_ATTEMPT);
		validateLoginSI.setNumOfFailedLogins(RESET_FAILED_ATTEMPT);
		admin.validateLogin(validateLoginSI);
		return validateLoginSO;
	}

	/**
	 * Log on the user
	 * 
	 * @param context
	 * @param bAuthenticate -
	 *            If set, the userName is pulled from the request, else the
	 *            passed in userName is assumed to be authenticated and valid
	 * @param userName
	 * @throws ServletException 
	 */
	private void processChangePassword(GrndsExchangeContext context) {
		BaseSessionStateManager state = getSessionStateManager(context);
		HttpServletRequest request = context.getRequest();
		ValidateLoginSI validateLoginSI = new ValidateLoginSI();
		UserProfile user = UserProfileHelper.getUserProfile(request);
		
		String randAnswer = "";
		boolean resetPassword = StringHelper.toBooleanSafe(StringHelper.castToString( state.getAttribute("hdnResetPasswordSelected", request)));
		state.removeAttribute("hdnResetPasswordSelected", request);
		String msgAccountRelocked = MessageLookup
				.getMessageByNumber(Messages.MSG_PORTAL_USER_RELOCKED);
		String msgNewPwdNotMatched = MessageLookup
		.getMessageByNumber(Messages.MSG_PORTAL_PWD_MATCH);
			// Get the SO object that has the random question number loaded from
			// the ChangePassword.jsp page
			ValidateLoginSO validateLoginSO = (ValidateLoginSO) state
					.getAttribute("validateLoginSO", request);
			String typedAnswer = ContextHelper.getStringSafe(request,
					UserProfileHelper.SECURITY_ANSWER_KEY).trim();
			String newPassword = ContextHelper.getStringSafe(request,
					UserProfileHelper.NEW_PASSWORD_KEY).trim();
			String newConfirmPassword = ContextHelper.getStringSafe(request,
					UserProfileHelper.NEW_PASSWORD_CONFIRM_KEY).trim();
			try {
			if (validateLoginSO != null) {
				// Set the Email back to SI object for subsequent
				// queries/updates.
				validateLoginSI.setUserName(validateLoginSO.getUserName());
				validateLoginSI.setCrudFlag(SELECT_USER_PASSWORD);
				// Get the decrypted password
				ValidateLoginSO validateLoginSOToFindFailedLogins = admin
						.validateLogin(validateLoginSI);
				int randomQuestion = validateLoginSO.getRandomQuestionNum();
				Integer numOfFailedLogins = validateLoginSOToFindFailedLogins
						.getNumOfFailedLogins();
				// MR-067 - No longer force user to call Admin when account
				// "relocked". User can reset paswword online.
				// Reset the Number of Failed Login attempts back to 0 after 3
				// failed attempts if user reset through hyperlink
			
				if (!resetPassword && numOfFailedLogins != null
						&& numOfFailedLogins >= MAX_NUM_OF_FAILED_ATTEMPTS) {
					throw new SecurityException(msgAccountRelocked);
				} else if (resetPassword) {
					// reset initiated and committed, clear all prev failed attempts
					validateLoginSI.setCrudFlag(UPDATE_FAILED_LOGIN_ATTEMPT);
					numOfFailedLogins = RESET_FAILED_ATTEMPT; // reset local variable to be in sync with DB value
					validateLoginSI.setNumOfFailedLogins(numOfFailedLogins);
					admin.validateLogin(validateLoginSI);
				}
				if (validateLoginSO.getTxtAnswer() != null) {
					randAnswer = validateLoginSO.getTxtAnswer().get(
							randomQuestion) != null ? validateLoginSO
							.getTxtAnswer().get(randomQuestion) : "";
					// Checking for typed answer against the answer stored in
					// the db
					if ((typedAnswer != null && !typedAnswer
							.equalsIgnoreCase(randAnswer))
							|| (typedAnswer.trim().length() <= 0)) {
						// Record the unsuccessful login attempts back to the DB
						if (numOfFailedLogins == null) {
							numOfFailedLogins = FIRST_FAILED_ATTEMPT;
						} else {
							numOfFailedLogins++;
						}
						// Update Failed Login Attempt number
						validateLoginSI
								.setCrudFlag(UPDATE_FAILED_LOGIN_ATTEMPT);
						validateLoginSI.setNumOfFailedLogins(numOfFailedLogins);
						admin.validateLogin(validateLoginSI);
						throw new SecurityException(
								MessageLookup
										.getMessageByNumber(Messages.MSG_PORTAL_SEC_QUES_INCORRECT));
					}
					// Checking for new and confirm password as same
					if ((newPassword != null && newConfirmPassword != null && !newPassword
							.equals(newConfirmPassword))
							|| (newPassword.trim().length() <= 0)
							|| (newConfirmPassword.trim().length() <= 0)) {
						throw new SecurityException(
								MessageLookup
										.getMessageByNumber(Messages.MSG_PORTAL_PWD_MATCH));
					}
					// Check the current password is not matching the previous
					// 15 passwords
					validateLoginSI.setCrudFlag(CHECK_PREVIOUS_PASSWORDS);
					validateLoginSI
							.setNumOfPrevPasswords(CHECK_NUM_OF_PREVIOUS_PASSWORDS);
					ValidateLoginSO prevPasswordsReturnedSO = admin
							.validateLogin(validateLoginSI);
					if (prevPasswordsReturnedSO != null) {
						List<String> prevPasswordsList = prevPasswordsReturnedSO
								.getPrevPasswords();
						for (int i = 0; i < prevPasswordsList.size(); i++) {
							String prevPassword = prevPasswordsList.get(i);
							if (newPassword != null
									&& newPassword.equals(prevPassword)) {
								throw new SecurityException(
										MessageLookup
												.getMessageByNumber(Messages.MSG_PORTAL_PREV_PWD_MATCH));
							}
						}
					}
					// Logged in successfully
					// Reset the Number of Failed Login attempts back to 0 after
					// a successful logi and also the new password.
					validateLoginSI
							.setCrudFlag(UPDATE_NEW_PASSWORD_LOGIN_ATTEMPT);
					validateLoginSI.setNumOfFailedLogins(RESET_FAILED_ATTEMPT);
					validateLoginSI.setPassword(newPassword);
					admin.validateLogin(validateLoginSI);

					// MR-067: Added for new route for youth from login to
					// youth's default page (Profile/Survey)
					state.setAttribute("hdnUlIdUser", UserProfileHelper
							.getGlobalDataUserId(request), request);
					state.setAttribute("validateLoginSO", validateLoginSO,
							request);
					

					// The forward URI is already set to the default page, so
					// just log this.
					GrndsTrace.msg(TRACE_TAG, 7,
							"Redirect user to default Page");
					forward(getDefaultPage(user, validateLoginSO, context), request,
							context.getResponse());
				}
			}
		} catch (SecurityException se) {
			GrndsTrace.msg(TRACE_TAG, 7,
					"Setting the error attribute and presentation branch");
			// MR-067: forward a locked account (exceeding max no of failed
			// attempts) back to log in page
			if (se.getMessage().equals(msgAccountRelocked) || se.getMessage().equals(msgNewPwdNotMatched)) {
				this.setPresentationBranch("login_page", context);
				setErrorMessage(se.getMessage(), "/login/Login/displayLogin", request);
				setInformationalMessage(MessageLookup
						.getMessageByNumber(Messages.MSG_PORTAL_CONTACT_ADMIN), request);
				
			} else {
				// page reloads, not yet exceeding max no of failed
						// attempts
				//this.setPresentationBranch("error_cpp", context);
				setErrorMessage(se.getMessage(), request);
			}
			
			GrndsTrace.exitScope();
		} catch (Exception e) {
			processSevereException(context, e);
		} 
		GrndsTrace.exitScope();
	}

	private void sendMail(String email, String subject, String body)
			throws Exception {
		try {
			// Send Email Notification
			EmailDelivery ed = new EmailDelivery();
			// ed.setSMTPHost(SMTP_HOST);
			// Comment the following line before Committing back to the
			// Repository
			ed.setSMTPHost(SMTP_HOST, SMTP_USER_NAME, SMTP_USER_PASSWORD);
			ed.setTo(email);
			ed.setFrom(SMTP_USER_EMAIL, SMTP_USER_NAME);
			ed.setSubject(subject);
			ed.setBody(body);
			ed.sendMsg();
		} catch (Exception ex) {
			throw new SecurityException(
					"Your data saved successfully. But Email transmission failed. If the problem persists contact your Administrator.");
		}
	}

	private void doLoginAudit(GrndsExchangeContext context, String indSuccess,
			Integer nbrMessage) {
		GrndsTrace.enterScope(TRACE_TAG + ".doLoginAudit");
		HttpServletRequest request = context.getRequest();
		String username = ContextHelper.getStringSafe(request,
				UserProfileHelper.LOGIN_NAME_KEY).toUpperCase().trim();
		UserProfile userProfile = UserProfileHelper.getUserProfile(request);
		Integer userId = null;
		if (userProfile != null) {
			userId = userProfile.getUserID();
		}
		String ipAddress = request.getRemoteAddr();
		GrndsTrace.msg(TRACE_TAG, 7,
				"Inserting Row in to Portal Login Audit table...");
		GrndsTrace.msg(TRACE_TAG, 7, "User Name :" + username + " user ID: "
				+ userId + " ipAddress: " + ipAddress + " indSuccess: "
				+ indSuccess + " nbrMessage: " + nbrMessage);
		AuditLogin.log(new AuditLoginRecord(username, userId, ipAddress,
				indSuccess, nbrMessage), context);
	}

	/**
	 * Set post login navigation: NYTD user: first login (tmp password and no
	 * secutiry questions set): navigated to User Profile page Vendor user:
	 * Child List page Note: NYTD users with tmp password only are existing
	 * Portal user. This scenario is covered separately in login process
	 * @param profile
	 * @param validateLoginSO
	 * @return
	 */
	private String getDefaultPage(UserProfile profile,
			ValidateLoginSO validateLoginSO, GrndsExchangeContext context) {
		if (profile != null) {
			if (profile.hasRight(UserProfile.NYTD_USER)) {
				BaseSessionStateManager state = getSessionStateManager(context);
				HttpServletRequest request = context.getRequest();
		
				GlobalData.setUlIdPerson(profile.getUserID(), request);
				boolean bSecQuestionsSet = isSecurityQuestionSet(validateLoginSO
						.getCdQuestion());
				if (StringHelper
						.toBooleanSafe(validateLoginSO.getIndPasswordTemp())
						&& !bSecQuestionsSet) {
					return USER_PROFILE_PAGE;
				} else {
					return PORTAL_SURVEY_PAGE;
				}
			}
		
			return CHILD_LIST_PAGE;
		} 
		return LOGIN_PAGE;
	}

	/**
	 * Check whether a question exists (selected). Checking one is enough. This
	 * utilizes the user/vendor page enforcing user to select all 3 security
	 * questions and answers.
	 * 
	 * @param secQuestionList
	 * @return
	 */
	private boolean isSecurityQuestionSet(List<String> secQuestionList) {
		if (secQuestionList != null && secQuestionList.size() > 0) {
			Iterator<String> it = secQuestionList.iterator();
			while (it.hasNext()) {
				String question = it.next();
				if (StringHelper.isValid(question)) {
					return true;
				}
			}
		}

		return false;
	}
}
