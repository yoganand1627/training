package gov.georgia.dhr.dfcs.sacwis.web.admin;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.grnds.facility.config.GrndsConfiguration;
import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.LookupException;
import gov.georgia.dhr.dfcs.sacwis.core.mail.EmailDelivery;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.PasswordGenerator;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.service.admin.Admin;
import gov.georgia.dhr.dfcs.sacwis.structs.input.RetrieveVendorStaffDetailSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SaveVendorStaffDetailSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ValidateLoginSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.YouthReportDetailSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RetrieveVendorStaffDetailSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SaveVendorStaffDetailSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ValidateLoginSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.YouthReportDetailSaveSO;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.metaphor.Nav;
import gov.georgia.dhr.dfcs.sacwis.web.core.metaphor.TabConstants;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
/**
* <pre>
* Change History:
* Date        User            Description
* ----------  --------------  --------------------------------------------------
* 08/29/2010  schoi           SMS #66384: MR-067 Updated to display/save the User Profile page
*                             for the NYTD User                            
*                             
* </pre>
*/
public class VendorStaffDetailConversation extends
		BaseHiddenFieldStateConversation {

	private Admin admin;

	private static final String SAVE_VENDOR_STAFF_DETAIL = "SAVE_VENDOR_STAFF_DETAIL";

	private static final String APPROVE_VENDOR_STAFF_DETAIL = "APPROVE_VENDOR_STAFF_DETAIL";

	private static final String DISAPPROVE_VENDOR_STAFF_DETAIL = "DISAPPROVE_VENDOR_STAFF_DETAIL";

	private static final String DELETE_VENDOR_STAFF_DETAIL = "DELETE_VENDOR_STAFF_DETAIL";

	private static final String PASSWORD_RESET_STAFF_DETAIL = "PASSWORD_RESET_STAFF_DETAIL";
	
	// SMS #66384: MR-067
        private static final String PORTAL_SURVEY_PAGE = "/person/PortalSurveyDetail/displayPortalSurveyDetail";	

	private static final String PORTAL_STAFF_LIST = "portalActive";

	private static final String PORTAL_PENDING_STAFF_LIST = "portalPending";

	private static final String PORTAL_SYSTEM = "PORTAL_SYSTEM";

	private static final String UPDATE = "UPDATE";

	private static final String INSERT = "INSERT";

	private static final String SELECT_USER_PASSWORD_BY_ID_USER = "SELECT_USER_PASSWORD_BY_ID_USER";

	private static final String CHECK_PREVIOUS_PASSWORDS = "CHECK_PREVIOUS_PASSWORDS";

	private static final Integer CHECK_NUM_OF_PREVIOUS_PASSWORDS = 15;

	private static final String VALIDATE_USER_STATUS = "VALIDATE_USER_STATUS";

	private static final String COUNT_PORTAL_USER_BY_EMAIL_AND_NOT_ID_USER = "COUNT_PORTAL_USER_BY_EMAIL_AND_NOT_ID_USER";

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

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	/**
	 * Save the Vendor Staff Detail page
	 * 
	 * @param context
	 *            The GrndsExchangeContext object
	 */
	public void saveVendorStaffDetail_xa(GrndsExchangeContext context) {
		GrndsTrace.enterScope(TRACE_TAG + ".saveVendorStaffDetail_xa");
		HttpServletRequest request = context.getRequest();
		try {
			boolean passwordChangeFlag = false;
			String screenName = ContextHelper.getStringSafe(request,
					"hdnScreenName").trim().length() <= 0 ? StringHelper.EMPTY_STRING
					: ContextHelper.getStringSafe(request, "hdnScreenName")
							.trim();
			// Check for the duplicate of the email id before updating
			// Set the User name (email ID) to SI object
			ValidateLoginSI validateLoginSI = new ValidateLoginSI();
			int idUser = GlobalData.getUlIdStaff(request);
			String userName = ContextHelper.getStringSafe(request, "txtEmail") != null ? ContextHelper
					.getStringSafe(request, "txtEmail")
					: "";
			validateLoginSI.setUserName(userName);
			validateLoginSI.setIdUser(idUser);
			validateLoginSI
					.setCrudFlag(COUNT_PORTAL_USER_BY_EMAIL_AND_NOT_ID_USER);
			// Get the decrypted password
			ValidateLoginSO validateLoginSO = admin
					.validateLogin(validateLoginSI);
			if (validateLoginSO.getEmailCount() > 0) {
				// Constraint violation for updating the email with the existing
				// email address in the system.
				throw new SecurityException(MessageLookup
						.getMessageByNumber(Messages.MSG_PORTAL_DUP_REG));
			}
			// Do the Password Checking Validation in the Conversation as the
			// service call cannot be made from
			// from the Custom validation.
			UserProfile profile = UserProfileHelper.getUserProfile(context);
			if (profile.hasRight(UserProfile.NYTD_USER) || 
			                (screenName.equals(PORTAL_STAFF_LIST)
					&& (profile.hasRight(UserProfile.PLCMNT_PRV_USRER)
							&& !profile.hasRight(UserProfile.PLCMNT_PRV_ADMIN) || (profile
							.hasRight(UserProfile.PLCMNT_PRV_ADMIN) && GlobalData
							.getUlIdStaff(request) == profile.getUserID())))) {

				// Set the User ID to SI object
				validateLoginSI.setIdUser(idUser);
				validateLoginSI.setCrudFlag(SELECT_USER_PASSWORD_BY_ID_USER);
				// Get the decrypted password
				ValidateLoginSO validateLoginSOPass = admin
						.validateLogin(validateLoginSI);
				// Get the Actual Password from DB and the typed current
				// Password, new and confirm passwords
				String actualPassword = validateLoginSOPass.getPassword();
				String currentPassword = ContextHelper.getStringSafe(request,
						"txtCurrentPassword") != null ? ContextHelper
						.getStringSafe(request, "txtCurrentPassword") : "";
				String newPassword = ContextHelper.getStringSafe(request,
						"txtNewPassword").trim();
				String newConfirmPassword = ContextHelper.getStringSafe(
						request, "txtNewPasswordConfirm").trim();
				// Get the Saved Security Questions/Answers from the DB
				List<String> savedAnswers = validateLoginSOPass.getTxtAnswer();
				List<String> savedQues = validateLoginSOPass.getCdQuestion();
				// Get the currently selected Question and Typed Answers
				// Checking questions
				String selSecQues1 = ContextHelper.getStringSafe(request,
						"selSecQues1");
				String selSecQues2 = ContextHelper.getStringSafe(request,
						"selSecQues2");
				String selSecQues3 = ContextHelper.getStringSafe(request,
						"selSecQues3");
				String typedAns1 = ContextHelper.getStringSafe(request,
						"txtSecAns1");
				String typedAns2 = ContextHelper.getStringSafe(request,
						"txtSecAns2");
				String typedAns3 = ContextHelper.getStringSafe(request,
						"txtSecAns3");
				
				// SMS #66384: MR-067
				// Enforce password change for the user who logged in using
				// temporary password and none of the security questions 
				// and answers are selected				
				boolean bSecQuestionsSet = isSecurityQuestionSet(validateLoginSOPass.getCdQuestion());
				boolean bAnswersSet = isSecurityAnswerSet(validateLoginSOPass.getTxtAnswer());
				if (validateLoginSOPass.getIndPasswordTemp() != null
				       && ArchitectureConstants.Y.equals(validateLoginSOPass.getIndPasswordTemp()) 
				       && (!bSecQuestionsSet || !bAnswersSet)
				       && (currentPassword.trim().length() <= 0 || newPassword.trim().length() <= 0 || 
				                       newConfirmPassword.trim().length() <= 0)) {
				        throw new SecurityException(MessageLookup
			                                                .getMessageByNumber(Messages.MSG_PORTAL_USER_TMP_PASSWORD_RESET));
				}
				// Current password is required to update password or change
				// responses to security questions.
				passwordChangeFlag = (newPassword.length() > 0 && newConfirmPassword
						.length() > 0);
				if ((newPassword.length() > 0 && newConfirmPassword.length() > 0)
						|| !(savedQues.get(0).equals(selSecQues1)
								&& savedQues.get(1).equals(selSecQues2)
								&& savedQues.get(2).equals(selSecQues3)
								&& savedAnswers.get(0).equals(typedAns1)
								&& savedAnswers.get(1).equals(typedAns2) && savedAnswers
								.get(2).equals(typedAns3))) {
					// passwordChangeFlag = true;
					if (currentPassword.trim().length() > 0
							&& !actualPassword.equals(currentPassword)) {
						// Password didn't match
						setErrorMessage(Messages.MSG_CMN_INVALID_PASSWORD,
								request);
						if (profile.hasRight(UserProfile.NYTD_USER)) {
                                                  // Redirect to User Profile Page for NYTD User
                                                  this.setPresentationBranch("errorUser",
                                                                context);
                                                  return;
                                                }
						else {
						// Redirect to Staff Detail Page
						this.setPresentationBranch("errorStaff", context);
						return;
						}
					}
					if (currentPassword.trim().length() <= 0) {
						// Password not entered
						setErrorMessage(Messages.MSG_PORTAL_PWD_REQ, request);
						if (profile.hasRight(UserProfile.NYTD_USER)) {
                                                  // Redirect to User Profile Page for NYTD User
                                                  this.setPresentationBranch("errorUser",
                                                                context);
                                                  return;
                                                }
                                                else {
						// Redirect to Staff Detail Page
						this.setPresentationBranch("errorStaff", context);
						return;
                                                }
					}
					// Checking Password Standards and Match
					if (passwordChangeFlag) {
						// Check the current password is not matching the
						// previous 15 passwords
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
									// Password didn't match
									setErrorMessage(
											Messages.MSG_PORTAL_PREV_PWD_MATCH,
											request);
									if (profile.hasRight(UserProfile.NYTD_USER)) {
									  // Redirect to User Profile Page for NYTD User
	                                                                  this.setPresentationBranch("errorUser",
	                                                                                context);
	                                                                        return;
									}
									else {
									// Redirect to Staff Detail Page
									this.setPresentationBranch("errorStaff",
											context);
									return;
									}
								}
							}
						}
					}
				}
			}
			SaveVendorStaffDetailSI saveVendorStaffDetailSI = populateSaveVendorStaffDetailSI(
					context, SAVE_VENDOR_STAFF_DETAIL);
			SaveVendorStaffDetailSO saveVendorStaffDetailSO = admin
					.saveVendorStaffDetail(saveVendorStaffDetailSI);
			
			boolean passMessageToJsp = false;
			if (saveVendorStaffDetailSO != null
					&& saveVendorStaffDetailSO.isSaveFlag()) {
				if (passwordChangeFlag) {
				  if (profile.hasRight(UserProfile.NYTD_USER)) {
				    // SMS #66384: MR-067
				    // Set flag for this message to true then pass that to JSP 
				    // to display this error message with an error message in JSP
				    passMessageToJsp = true;				    
				  }
				  else {
				        // Vendor access will display this message only
					setInformationalMessage(Messages.MSG_PORTAL_PWD_UPDATE,
							request);
				  }
				}				
	                        boolean navToSurveyFlag = false;
				if (profile.hasRight(UserProfile.NYTD_USER)) {				        	                                      
                                          // Set the flag to true then pass that to JSP for informational message
				          this.setPresentationBranch("userPofile", context);
				          boolean isSurveyPeriod = saveVendorStaffDetailSO.isInSurveyPeriod();
				          boolean isSurveyComp = saveVendorStaffDetailSO.isSurveyComplete();
                                          navToSurveyFlag = true;
                                          // Set flags to check the user is in the Survey Period and the Survey is complete
                                          request.setAttribute("isSurveyPeriod", isSurveyPeriod);
                                          request.setAttribute("isSurveyComp", isSurveyComp);
                                          request.setAttribute("navToSurveyFlag", navToSurveyFlag);  
                                          request.setAttribute("passMessageToJsp", passMessageToJsp);
				} else if (screenName.equals(PORTAL_STAFF_LIST)) {
					// Redirect to Staff Detail Page
					this.setPresentationBranch("staffDtl", context);
				} else if (screenName.equals(PORTAL_PENDING_STAFF_LIST)) {
					// Redirect to Pending Page
					this.setPresentationBranch("pending", context);
				} else {
					// default (this should never be used. Just for safer side)
					this.setPresentationBranch("staffDtl", context);
				}
			}
			GrndsTrace.exitScope();
		} catch (SecurityException se) {
			GrndsTrace.msg(TRACE_TAG, 7,
					"Setting the error attribute and presentation branch");
			String screenName = ContextHelper.getStringSafe(request,
					"hdnScreenName").trim().length() <= 0 ? StringHelper.EMPTY_STRING
					: ContextHelper.getStringSafe(request, "hdnScreenName")
							.trim();
			UserProfile profile = UserProfileHelper.getUserProfile(context);
			if (profile.hasRight(UserProfile.NYTD_USER)) {
                                // Redirect to User Profile Detail Page
                                this.setPresentationBranch("errorUser", context);                                
                        } else if (screenName.equals(PORTAL_STAFF_LIST)) {
				// Redirect to Staff Detail Page
				this.setPresentationBranch("errorStaff", context);
			} else if (screenName.equals(PORTAL_PENDING_STAFF_LIST)) {
				// Redirect to Pending Page
				this.setPresentationBranch("errorPending", context);
			} else {
				// default (this should never be used. Just for safer side)
				this.setPresentationBranch("errorStaff", context);
			}
			// this.setPresentationBranch("admin", context);
			setErrorMessage(se.getMessage(), request);
			GrndsTrace.exitScope();
			return;
		} catch (Exception e) {
			processSevereException(context, e);
		}
		GrndsTrace.exitScope();
	}

	/**
	 * Save the Pending Vendor Staff Detail page
	 * 
	 * @param context
	 *            The GrndsExchangeContext object
	 */
	public void savePendingVendorStaffDetail_xa(GrndsExchangeContext context) {
		GrndsTrace.enterScope(TRACE_TAG + ".saveVendorStaffDetail_xa");
		HttpServletRequest request = context.getRequest();
		try {
			SaveVendorStaffDetailSI saveVendorStaffDetailSI = populateSaveVendorStaffDetailSI(
					context, SAVE_VENDOR_STAFF_DETAIL);
			SaveVendorStaffDetailSO saveVendorStaffDetailSO = admin
					.saveVendorStaffDetail(saveVendorStaffDetailSI);

			if (saveVendorStaffDetailSO != null
					&& saveVendorStaffDetailSO.isSaveFlag()) {
			}

			GrndsTrace.exitScope();
		} catch (SecurityException se) {
			GrndsTrace.msg(TRACE_TAG, 7,
					"Setting the error attribute and presentation branch");

			setErrorMessage(se.getMessage(), request);
			GrndsTrace.exitScope();
			return;
		} catch (Exception e) {
			processSevereException(context, e);
		}
	}

	public static List<CodeAttributes> getMethodOptions(String screenName) {
		List<CodeAttributes> methodOptions = new ArrayList<CodeAttributes>();
		List<CodeAttributes> codesTable = null;

		try {
			codesTable = Lookup
					.getCategoryCollectionSortedByDecode(CodesTables.CUSRSTAT);
		} catch (LookupException le) {
			throw new IllegalStateException(
					"Lookup data has not been initialized. Contact tech support for assistance.");
		}
		if (codesTable != null) {
			if (screenName.equals(PORTAL_STAFF_LIST)) {
				for (CodeAttributes codeAttr : codesTable) {
					if (!CodesTables.CUSRSTAT_PEN.equals(codeAttr.getCode())) {
						methodOptions.add(codeAttr);
					}
				}
			}

			else {

				for (CodeAttributes codeAttr : codesTable) {
					methodOptions.add(codeAttr);
				}

			}
		}

		return methodOptions;
	}

	/**
	 * Do any necessary processing before displaying the Vendor Staff Detail
	 * page
	 * 
	 * @param context
	 *            The GrndsExchangeContext object
	 */
	public void displayVendorStaffDetail_xa(GrndsExchangeContext context) {
		GrndsTrace.enterScope(TRACE_TAG + ".displayVendorStaffDetail_xa");
		BaseSessionStateManager state = getSessionStateManager(context);
		HttpServletRequest request = context.getRequest();
		int idUser = ContextHelper.getIntSafe(request, "hdnUlIdUser");
		String screenName = PORTAL_STAFF_LIST;
		// MR-067: use profile user ID to be consistent with banner User ID
		// retrieval logic. If staff ID not exists, this is youth user, claimed ID and logged-in ID are same
		UserProfile profile = UserProfileHelper.getUserProfile(request);
		if (idUser <= 0) {
			// Get the ID User from the Global Data if user clicks on Staff
			// Detail Tab
			idUser = GlobalData.getUlIdStaff(request) > 0 ? GlobalData
					.getUlIdStaff(request) : profile.getUserID();
		}
		// Load the data for the retrieval
		RetrieveVendorStaffDetailSI retrieveVendorStaffDetailSI = populateRetrieveVendorStaffDetailSI(
				context, idUser, screenName);
		// Retrieve the data
		RetrieveVendorStaffDetailSO retrieveVendorStaffDetailSO = admin
				.retrieveVendorStaffDetail(retrieveVendorStaffDetailSI);
		// Set Logged In User Type
		// UserProfile profile = UserProfileHelper.getUserProfile(context);
		retrieveVendorStaffDetailSO.setIdLoggedInUser(profile.getUserID());
		if (profile.hasRight(UserProfile.PLCMNT_PRV_ADMIN)) {
			retrieveVendorStaffDetailSO
					.setUserAccessType(UserProfile.PLCMNT_PRV_ADMIN);
		} else if (profile.hasRight(UserProfile.PLCMNT_PRV_USRER)) {
			retrieveVendorStaffDetailSO
					.setUserAccessType(UserProfile.PLCMNT_PRV_USRER);
		} else if (profile.hasRight(UserProfile.NYTD_USER)) {
			retrieveVendorStaffDetailSO
					.setUserAccessType(UserProfile.NYTD_USER);
		}
		state.setAttribute("retrieveVendorStaffDetailSO",
				retrieveVendorStaffDetailSO, request);
		GlobalData.setUlIdStaff(idUser, request);
		GrndsTrace.exitScope();
	}

	/**
	 * Do any necessary processing before displaying the Pending Vendor Staff
	 * Detail page
	 * 
	 * @param context
	 *            The GrndsExchangeContext object
	 */
	public void displayPendingVendorStaffDetail_xa(GrndsExchangeContext context) {
		GrndsTrace
				.enterScope(TRACE_TAG + ".displayPendingVendorStaffDetail_xa");
		BaseSessionStateManager state = getSessionStateManager(context);
		HttpServletRequest request = context.getRequest();
		int idUser = ContextHelper.getIntSafe(request, "hdnUlIdUser");
		String screenName = PORTAL_PENDING_STAFF_LIST;
		if (idUser <= 0) {
			// Get the ID User from the Global Data if user clicks on Staff
			// Detail Tab
			idUser = GlobalData.getUlIdStaff(request);
		}
		// Load the data for the retrieval
		RetrieveVendorStaffDetailSI retrieveVendorStaffDetailSI = populateRetrieveVendorStaffDetailSI(
				context, idUser, screenName);
		// Retrieve the data
		RetrieveVendorStaffDetailSO retrieveVendorStaffDetailSO = admin
				.retrieveVendorStaffDetail(retrieveVendorStaffDetailSI);
		// Set Logged In User Type
		UserProfile profile = UserProfileHelper.getUserProfile(context);
		retrieveVendorStaffDetailSO.setIdLoggedInUser(profile.getUserID());
		if (profile.hasRight(UserProfile.PLCMNT_PRV_ADMIN)) {
			retrieveVendorStaffDetailSO
					.setUserAccessType(UserProfile.PLCMNT_PRV_ADMIN);
		} else if (profile.hasRight(UserProfile.PLCMNT_PRV_USRER)) {
			retrieveVendorStaffDetailSO
					.setUserAccessType(UserProfile.PLCMNT_PRV_USRER);
		} else if (profile.hasRight(UserProfile.NYTD_USER)) {
                        retrieveVendorStaffDetailSO
                                        .setUserAccessType(UserProfile.NYTD_USER);
		}
		state.setAttribute("retrieveVendorStaffDetailSO",
				retrieveVendorStaffDetailSO, request);
		GlobalData.setUlIdStaff(idUser, request);
		GrndsTrace.exitScope();
	}

	/**
	 * Reset Password Vendor Staff Detail page
	 * 
	 * @param context
	 *            The GrndsExchangeContext object
	 */
	public void resetPassword_xa(GrndsExchangeContext context) {
		GrndsTrace.enterScope(TRACE_TAG + ".resetPassword_xa");
		HttpServletRequest request = context.getRequest();
		try {
			SaveVendorStaffDetailSI saveVendorStaffDetailSI = populateSaveVendorStaffDetailSI(
					context, PASSWORD_RESET_STAFF_DETAIL);
			SaveVendorStaffDetailSO saveVendorStaffDetailSO = admin
					.saveVendorStaffDetail(saveVendorStaffDetailSI);

			if (saveVendorStaffDetailSO != null
					&& saveVendorStaffDetailSO.isSaveFlag()) {
				// Send Email Notification
				sendMail(
						saveVendorStaffDetailSI.getTxtUserEmail(),
						MessageLookup
								.getMessageByNumber(Messages.MSG_PORTAL_EMAIL_SUBJ3),
						MessageLookup
								.addMessageParameter(
										MessageLookup
												.getMessageByNumber(Messages.MSG_PORTAL_EMAIL_TEMPPWD),
										saveVendorStaffDetailSO
												.getTxtResetPassword()));
				setInformationalMessage(Messages.MSG_PORTAL_PWD_RESET_SUCCESS,
						request);
			}
			GrndsTrace.exitScope();
		} catch (SecurityException se) {
			GrndsTrace.msg(TRACE_TAG, 7,
					"Setting the error attribute and presentation branch");
			setErrorMessage(se.getMessage(), request);
			GrndsTrace.exitScope();
			return;
		} catch (Exception e) {
			processSevereException(context, e);
		}
	}

	/**
	 * Approve the Pending Vendor Staff Detail page
	 * 
	 * @param context
	 *            The GrndsExchangeContext object
	 */
	public void approveVendorStaffDetail_xa(GrndsExchangeContext context) {
		GrndsTrace.enterScope(TRACE_TAG + ".approveVendorStaffDetail_xa");
		HttpServletRequest request = context.getRequest();
		try {
			SaveVendorStaffDetailSI saveVendorStaffDetailSI = populateSaveVendorStaffDetailSI(
					context, APPROVE_VENDOR_STAFF_DETAIL);
			SaveVendorStaffDetailSO saveVendorStaffDetailSO = admin
					.saveVendorStaffDetail(saveVendorStaffDetailSI);

			if (saveVendorStaffDetailSO != null
					&& saveVendorStaffDetailSO.isSaveFlag()) {
				// Send Email Notification
				sendMail(
						saveVendorStaffDetailSI.getTxtUserEmail(),
						MessageLookup
								.getMessageByNumber(Messages.MSG_PORTAL_EMAIL_SUBJ2),
						MessageLookup
								.addMessageParameter(
										MessageLookup
												.getMessageByNumber(Messages.MSG_PORTAL_EMAIL_APPRV),
										saveVendorStaffDetailSI
												.getTxtUserEmail()));
			}

			GrndsTrace.exitScope();
		} catch (SecurityException se) {
			GrndsTrace.msg(TRACE_TAG, 7,
					"Setting the error attribute and presentation branch");

			setErrorMessage(se.getMessage(), request);
			GrndsTrace.exitScope();
			return;
		} catch (Exception e) {
			processSevereException(context, e);
		}
	}

	/**
	 * Disapprove the Pending Vendor Staff Detail page
	 * 
	 * @param context
	 *            The GrndsExchangeContext object
	 */
	public void disapproveVendorStaffDetail_xa(GrndsExchangeContext context) {
		GrndsTrace.enterScope(TRACE_TAG + ".disapproveVendorStaffDetail_xa");
		HttpServletRequest request = context.getRequest();
		try {
			Integer idUser = GlobalData.getUlIdStaff(request);
			ValidateLoginSI validateLoginSI = new ValidateLoginSI();
			// Set the User ID to SI object
			validateLoginSI.setIdUser(idUser);
			validateLoginSI.setCrudFlag(VALIDATE_USER_STATUS);
			// Get the Status of the User
			ValidateLoginSO validateLoginSO = admin
					.validateLogin(validateLoginSI);
			String cdStatus = validateLoginSO.getCdStatus() != null ? validateLoginSO
					.getCdStatus()
					: "";
			// Check if the status is Pending before allowing the user to
			// disapprove.
			if (CodesTables.CUSRSTAT_ACT.equals(cdStatus)) {
				// Password didn't match
				setErrorMessage("Cannot be disapproved after approval", request);
				throw new SecurityException();
			}
			SaveVendorStaffDetailSI saveVendorStaffDetailSI = populateSaveVendorStaffDetailSI(
					context, DISAPPROVE_VENDOR_STAFF_DETAIL);
			SaveVendorStaffDetailSO saveVendorStaffDetailSO = admin
					.saveVendorStaffDetail(saveVendorStaffDetailSI);

			if (saveVendorStaffDetailSO != null
					&& saveVendorStaffDetailSO.isSaveFlag()) {
				// Send Email Notification
				sendMail(
						saveVendorStaffDetailSI.getTxtUserEmail(),
						MessageLookup
								.getMessageByNumber(Messages.MSG_PORTAL_EMAIL_SUBJ2),
						MessageLookup
								.getMessageByNumber(Messages.MSG_PORTAL_EMAIL_DISAPPRV));
			}

			GrndsTrace.exitScope();
		} catch (SecurityException se) {
			GrndsTrace.msg(TRACE_TAG, 7,
					"Setting the error attribute and presentation branch");

			setErrorMessage(se.getMessage(), request);
			GrndsTrace.exitScope();
			return;
		} catch (Exception e) {
			processSevereException(context, e);
		}
	}

	/**
	 * Delete the Vendor Association from the Vendor Staff Detail page
	 * 
	 * @param context
	 *            The GrndsExchangeContext object
	 */
	public void deleteVendor_xa(GrndsExchangeContext context) {
		GrndsTrace.enterScope(TRACE_TAG + ".deleteVendor_xa");
		HttpServletRequest request = context.getRequest();
		BaseSessionStateManager state = getSessionStateManager(context);
		// Get the SO object
		RetrieveVendorStaffDetailSO retrieveVendorStaffDetailSO = (RetrieveVendorStaffDetailSO) state
				.getAttribute("retrieveVendorStaffDetailSO", request);
		if (retrieveVendorStaffDetailSO.getResourceListforUser().size() <= 1) {
			// An administrator attempts to Approve a pending registration
			// without associating
			// any vendors to the user.
			setErrorMessage(Messages.MSG_PORTAL_UPDATE_VENDORS, request);
			// Redirect to Staff Detail Page
			this.setPresentationBranch("errorStaff", context);
			return;
		}
		String screenName = ContextHelper.getStringSafe(request,
				"hdnScreenName").trim().length() <= 0 ? StringHelper.EMPTY_STRING
				: ContextHelper.getStringSafe(request, "hdnScreenName").trim();

		try {
			SaveVendorStaffDetailSI saveVendorStaffDetailSI = populateSaveVendorStaffDetailSI(
					context, DELETE_VENDOR_STAFF_DETAIL);
			SaveVendorStaffDetailSO saveVendorStaffDetailSO = admin
					.saveVendorStaffDetail(saveVendorStaffDetailSI);

			if (saveVendorStaffDetailSO != null
					&& saveVendorStaffDetailSO.isSaveFlag()) {
				screenName = ContextHelper.getStringSafe(request,
						"hdnScreenName").trim().length() <= 0 ? StringHelper.EMPTY_STRING
						: ContextHelper.getStringSafe(request, "hdnScreenName")
								.trim();
				if (screenName.equals(PORTAL_STAFF_LIST)) {
					// Redirect to Staff Detail Page
					this.setPresentationBranch("staffDtl", context);
				} else if (screenName.equals(PORTAL_PENDING_STAFF_LIST)) {
					// Redirect to Pending Page
					this.setPresentationBranch("pending", context);
				} else {
					// default (this should never be used. Just for safer side)
					this.setPresentationBranch("staffDtl", context);
				}
			}

			GrndsTrace.exitScope();
		} catch (SecurityException se) {
			GrndsTrace.msg(TRACE_TAG, 7,
					"Setting the error attribute and presentation branch");
			if (screenName.equals(PORTAL_STAFF_LIST)) {
				// Redirect to Staff Detail Page
				this.setPresentationBranch("errorStaff", context);
			} else if (screenName.equals(PORTAL_PENDING_STAFF_LIST)) {
				// Redirect to Pending Page
				this.setPresentationBranch("errorPending", context);
			} else {
				// default (this should never be used. Just for safer side)
				this.setPresentationBranch("errorStaff", context);
			}
			setErrorMessage(se.getMessage(), request);
			GrndsTrace.exitScope();
			return;
		} catch (ServiceException se) {
			GrndsTrace.msg(TRACE_TAG, 7,
					"Setting the error attribute and presentation branch");
			if (screenName.equals(PORTAL_STAFF_LIST)) {
				// Redirect to Staff Detail Page
				this.setPresentationBranch("errorStaff", context);
			} else if (screenName.equals(PORTAL_PENDING_STAFF_LIST)) {
				// Redirect to Pending Page
				this.setPresentationBranch("errorPending", context);
			} else {
				// default (this should never be used. Just for safer side)
				this.setPresentationBranch("errorStaff", context);
			}
			setErrorMessage(se.getMessage(), request);
			GrndsTrace.exitScope();
			return;
		} catch (Exception e) {
			processSevereException(context, e);
		}
	}

	/**
	 * Retrieve the Resource ID to display
	 * 
	 * @return
	 */
	private RetrieveVendorStaffDetailSI populateRetrieveVendorStaffDetailSI(
			GrndsExchangeContext context, int idUser, String screenName) {
		HttpServletRequest request = context.getRequest();
		RetrieveVendorStaffDetailSI retrieveVendorStaffDetailSI = new RetrieveVendorStaffDetailSI();
		retrieveVendorStaffDetailSI.setIdUser(idUser);
		retrieveVendorStaffDetailSI.setRetrieveFlag(screenName);
		// Set Logged In User Type
		UserProfile profile = UserProfileHelper.getUserProfile(context);
		if (profile.hasRight(UserProfile.PLCMNT_PRV_ADMIN)) {
			retrieveVendorStaffDetailSI
					.setUserAccessType(UserProfile.PLCMNT_PRV_ADMIN);
		} else if (profile.hasRight(UserProfile.PLCMNT_PRV_USRER)) {
			retrieveVendorStaffDetailSI
					.setUserAccessType(UserProfile.PLCMNT_PRV_USRER);
		} else if (profile.hasRight(UserProfile.NYTD_USER)) {
                        retrieveVendorStaffDetailSI
                                        .setUserAccessType(UserProfile.NYTD_USER);
		}
		Integer loggedInUserId = UserProfileHelper.getUserProfile(request)
				.getUserID();
		retrieveVendorStaffDetailSI.setIdLoggedInUser(loggedInUserId);
		return retrieveVendorStaffDetailSI;
	}

	private SaveVendorStaffDetailSI populateSaveVendorStaffDetailSI(
			GrndsExchangeContext context, String saveFlag)
			throws SecurityException {
		HttpServletRequest request = context.getRequest();
		// Set the User name (email ID) to SI object
		SaveVendorStaffDetailSI saveVendorStaffDetailSI = new SaveVendorStaffDetailSI();
		saveVendorStaffDetailSI.setSavePage(saveFlag);

		saveVendorStaffDetailSI.setIdUser(GlobalData.getUlIdStaff(request));
		saveVendorStaffDetailSI.setTxtUserEmail(ContextHelper.getStringSafe(
				request, "txtEmail"));
		saveVendorStaffDetailSI.setModifiedSystem(PORTAL_SYSTEM);
		Integer loggedInUserId = UserProfileHelper.getUserProfile(request)
				.getUserID();
		saveVendorStaffDetailSI.setLoggedInUser(loggedInUserId);
		// Set Logged In User Type
		UserProfile profile = UserProfileHelper.getUserProfile(context);
		if (profile.hasRight(UserProfile.PLCMNT_PRV_ADMIN)) {
			saveVendorStaffDetailSI
					.setUserAccessType(UserProfile.PLCMNT_PRV_ADMIN);
		} else if (profile.hasRight(UserProfile.PLCMNT_PRV_USRER)) {
			saveVendorStaffDetailSI
					.setUserAccessType(UserProfile.PLCMNT_PRV_USRER);
		} else if (profile.hasRight(UserProfile.NYTD_USER)) {
                        saveVendorStaffDetailSI
                                        .setUserAccessType(UserProfile.NYTD_USER);
		}
		if (saveFlag.equals(SAVE_VENDOR_STAFF_DETAIL)
				|| saveFlag.equals(APPROVE_VENDOR_STAFF_DETAIL)) {
			// Set the Update or Insert Flag
			if (ContextHelper.getStringSafe(request, "hdnSelectFlag").equals(
					StringHelper.BOOLEAN_TRUE)) {
				saveVendorStaffDetailSI.setCrudFlag(UPDATE);
			} else if (ContextHelper.getStringSafe(request, "hdnAddFlag")
					.equals(StringHelper.BOOLEAN_TRUE)) {
				saveVendorStaffDetailSI.setCrudFlag(INSERT);
			}
			saveVendorStaffDetailSI.setNmUserFirst(ContextHelper.getStringSafe(
					request, "txtFirstName"));
			saveVendorStaffDetailSI.setNmUserMiddle(ContextHelper
					.getStringSafe(request, "txtMiddleInitial"));
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
			saveVendorStaffDetailSI.setAddrUserAddrZip(ContextHelper
					.getStringSafe(request, "txtZip")
					+ ContextHelper.getStringSafe(request, "txtZipSuff"));
			saveVendorStaffDetailSI.setCdUserAddrState(ContextHelper
					.getStringSafe(request, "selState"));
			saveVendorStaffDetailSI.setCdUserAddrCounty(ContextHelper
					.getStringSafe(request, "selCounty"));
			saveVendorStaffDetailSI.setCdRequestType(ContextHelper
					.getStringSafe(request, "selReqType"));
			saveVendorStaffDetailSI.setIdPuvl(ContextHelper.getStringSafe(
					request, "hdnDisplayPuvlId").trim().length() <= 0 ? "0"
					: ContextHelper.getStringSafe(request, "hdnDisplayPuvlId"));
			saveVendorStaffDetailSI.setIdResource(ContextHelper.getStringSafe(
					request, "hdnDisplayRsrcId").trim().length() <= 0 ? "0"
					: ContextHelper.getStringSafe(request, "hdnDisplayRsrcId"));
			saveVendorStaffDetailSI.setCdStatus(ContextHelper.getStringSafe(
					request, "selStatus"));
			saveVendorStaffDetailSI.setCdUserType(ContextHelper.getStringSafe(
					request, "selReqType"));
			saveVendorStaffDetailSI.setDtStart(ContextHelper.getJavaDateSafe(
					request, "dtStart"));
			saveVendorStaffDetailSI.setDtEnd(ContextHelper.getJavaDateSafe(
					request, "dtEnd"));
			saveVendorStaffDetailSI.setIndUserAgreement(CheckboxHelper
					.getCheckboxValue(request, "cbxUsrAgrmnt"));
			// Set the Logged In User ID for auditing purpose as who approved
			if (saveFlag.equals(APPROVE_VENDOR_STAFF_DETAIL)) {
				saveVendorStaffDetailSI.setModifiedSystem(PORTAL_SYSTEM);
			}
			// If the User Access Type is User, then capture Security
			// Questions/Answers and Password
			if (UserProfile.PLCMNT_PRV_USRER.equals(saveVendorStaffDetailSI.getUserAccessType()) ||
			                UserProfile.NYTD_USER.equals(saveVendorStaffDetailSI.getUserAccessType()) ||
			                (UserProfile.PLCMNT_PRV_ADMIN.equals(saveVendorStaffDetailSI.getUserAccessType())&& 
			                                saveVendorStaffDetailSI.getIdUser().equals(
			                                            saveVendorStaffDetailSI.getLoggedInUser()))) {
				if (ContextHelper.getStringSafe(request, "txtNewPassword")
						.trim().length() > 0) {
					saveVendorStaffDetailSI.setTxtPassword(ContextHelper
							.getStringSafe(request, "txtNewPassword"));
					saveVendorStaffDetailSI.setDtLastPasswdReset(new Date());
				}
				saveVendorStaffDetailSI.setCdQuestion1(ContextHelper
						.getStringSafe(request, "selSecQues1"));
				saveVendorStaffDetailSI.setCdQuestion2(ContextHelper
						.getStringSafe(request, "selSecQues2"));
				saveVendorStaffDetailSI.setCdQuestion3(ContextHelper
						.getStringSafe(request, "selSecQues3"));
				saveVendorStaffDetailSI.setTxtAnswer1(ContextHelper
						.getStringSafe(request, "txtSecAns1"));
				saveVendorStaffDetailSI.setTxtAnswer2(ContextHelper
						.getStringSafe(request, "txtSecAns2"));
				saveVendorStaffDetailSI.setTxtAnswer3(ContextHelper
						.getStringSafe(request, "txtSecAns3"));
			}
			// If NYTD User
			if (profile.hasRight(UserProfile.NYTD_USER)) {
			  saveVendorStaffDetailSI.setTxtUserFB(ContextHelper.getStringSafe(request, "szTxtFacebook"));
			  saveVendorStaffDetailSI.setTxtUserMS(ContextHelper.getStringSafe(request, "szTxtMySpace"));
			  saveVendorStaffDetailSI.setTxtUserTW(ContextHelper.getStringSafe(request, "szTxtTwitter"));
			  saveVendorStaffDetailSI.setTxtUserOthSite(ContextHelper.getStringSafe(request, "szTxtOtherSite"));
			  saveVendorStaffDetailSI.setTxtUserNameOthSite(ContextHelper.getStringSafe(request, "szTxtUserName"));
			  saveVendorStaffDetailSI.setTxtUserPhnBest(ContextHelper.getPhoneSafe(request, "nbrPhoneBest"));
			  saveVendorStaffDetailSI.setTxtUserPhnBestExt(ContextHelper.getStringSafe(request, "nbrPhoneExtBest"));
			  saveVendorStaffDetailSI.setTxtUserPhnBestType(ContextHelper.getStringSafe(request, "rbIndPhoneBest"));
			  saveVendorStaffDetailSI.setTxtUserPhnAlt1(ContextHelper.getPhoneSafe(request, "nbrPhoneAltOne"));
			  saveVendorStaffDetailSI.setTxtUserPhnAlt1Ext(ContextHelper.getStringSafe(request, "nbrPhoneExtAltOne"));
			  saveVendorStaffDetailSI.setTxtUserPhnAlt1Type(ContextHelper.getStringSafe(request, "rbIndPhoneAltOne"));
			  saveVendorStaffDetailSI.setTxtUserPhnAlt2(ContextHelper.getPhoneSafe(request, "nbrPhoneAltTwo"));
			  saveVendorStaffDetailSI.setTxtUserPhnAlt2Ext(ContextHelper.getStringSafe(request, "nbrPhoneExtAltTwo"));
			  saveVendorStaffDetailSI.setTxtUserPhnAlt2Type(ContextHelper.getStringSafe(request, "rbIndPhoneAltTwo"));
			  saveVendorStaffDetailSI.setTxtCntctByText(ContextHelper.getStringSafe(request, "rbIndText"));
			  saveVendorStaffDetailSI.setTxtEmerContact(ContextHelper.getStringSafe(request, "szTxtEmerContact"));	
			}
		} else if (saveFlag.equals(PASSWORD_RESET_STAFF_DETAIL)) {
			// Generate Random Password using Password Generator
			try {
				PasswordGenerator pg = new PasswordGenerator();
				String randPassword = pg.generate();
				saveVendorStaffDetailSI.setTxtRandPassword(randPassword);
			} catch (Exception ex) {
				throw new SecurityException(
						"Password Generator Failed to generate new password!!!");
			}
		} else if (saveFlag.equals(DELETE_VENDOR_STAFF_DETAIL)) {
			saveVendorStaffDetailSI.setIdPuvl(ContextHelper.getStringSafe(
					request, "hdnDisplayPuvlId").trim().length() <= 0 ? "0"
					: ContextHelper.getStringSafe(request, "hdnDisplayPuvlId"));
			saveVendorStaffDetailSI.setIdResource(ContextHelper.getStringSafe(
					request, "hdnDisplayRsrcId").trim().length() <= 0 ? "0"
					: ContextHelper.getStringSafe(request, "hdnDisplayRsrcId"));

		}
		return saveVendorStaffDetailSI;
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
        private boolean isSecurityAnswerSet(List<String> secAnswerList) {
          if (secAnswerList != null && secAnswerList.size() > 0) {
                  Iterator<String> it = secAnswerList.iterator();
                  while (it.hasNext()) {
                          String answer = it.next();
                          if (StringHelper.isValid(answer)) {
                                  return true;
                          }
                  }
          }

          return false;
        }        
        
}
