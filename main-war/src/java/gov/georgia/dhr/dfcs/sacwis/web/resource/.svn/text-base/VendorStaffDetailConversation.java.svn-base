package gov.georgia.dhr.dfcs.sacwis.web.resource;

import javax.servlet.http.HttpServletRequest;
import org.grnds.facility.config.GrndsConfiguration;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.LookupException;
import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.mail.EmailDelivery;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.PasswordGenerator;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.service.admin.Admin;
import gov.georgia.dhr.dfcs.sacwis.structs.input.RetrieveVendorStaffDetailSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SaveVendorStaffDetailSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ValidateLoginSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES03SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PaymentOfCareRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RetrieveVendorStaffDetailSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SaveVendorStaffDetailSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ValidateLoginSO;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import java.util.List;
import java.util.ArrayList;

public class VendorStaffDetailConversation extends BaseHiddenFieldStateConversation {

  private Admin admin;

  private static final String SAVE_VENDOR_STAFF_DETAIL = "SAVE_VENDOR_STAFF_DETAIL";

  private static final String APPROVE_VENDOR_STAFF_DETAIL = "APPROVE_VENDOR_STAFF_DETAIL";

  private static final String DISAPPROVE_VENDOR_STAFF_DETAIL = "DISAPPROVE_VENDOR_STAFF_DETAIL";

  private static final String DELETE_VENDOR_STAFF_DETAIL = "DELETE_VENDOR_STAFF_DETAIL";

  private static final String PASSWORD_RESET_STAFF_DETAIL = "PASSWORD_RESET_STAFF_DETAIL";
  
  private static final String COUNT_PORTAL_USER_BY_EMAIL_AND_NOT_ID_USER = "COUNT_PORTAL_USER_BY_EMAIL_AND_NOT_ID_USER";
  
  protected static final String RESOURCE_PULLBACK_INFO = ResourceSearchPullBackInfo.RESOURCE_PULLBACK_REQUEST;

  //Note: the following are only used in SHINES
  private static final String SHINES_STAFF_LIST = "shinesActive";
  
  private static final String SHINES_PENDING_STAFF_LIST = "shinesPending";
  
  private static final String SHINES_PENDING_ADMIN_LIST = "shinesPendingAdmin";
  
  private static final String SEC_VENDOR_STAFF_ACCESS = "SEC_VENDOR_STAFF_ACCESS";
  
  private static final String SHINES_SYSTEM = "SHINES_SYSTEM";

  private static final String UPDATE = "UPDATE";

  private static final String INSERT = "INSERT";

  private static final String FROM_LIST_PAGE = "FROM_LIST_PAGE";
  
  private static final String FROM_RSRC_SEARCH = "FROM_RSRC_SEARCH";
  
  private static final String VALIDATE_USER_STATUS = "VALIDATE_USER_STATUS";
  
  /** String SMTP */
  private static final String SMTP_HOST = GrndsConfiguration.getInstance()
                                                            .getProperty(ArchitectureConstants.GRNDS_DOMAIN,
                                                                         "smtp.host.name");

  private static final String SMTP_USER_NAME = GrndsConfiguration.getInstance()
                                                                 .getProperty(ArchitectureConstants.GRNDS_DOMAIN,
                                                                              "smtp.user.name");

  private static final String SMTP_USER_PASSWORD = GrndsConfiguration.getInstance()
                                                                     .getProperty(ArchitectureConstants.GRNDS_DOMAIN,
                                                                                  "smtp.user.password");

  private static final String SMTP_USER_EMAIL = GrndsConfiguration.getInstance()
                                                                  .getProperty(ArchitectureConstants.GRNDS_DOMAIN,
                                                                               "smtp.user.email");

  private static final String SMTP_USER_DONOT_REPLY = GrndsConfiguration
                                                                        .getInstance()
                                                                        .getProperty(
                                                                                     ArchitectureConstants.GRNDS_DOMAIN,
                                                                                     "smtp.user.donot.reply");

  public void setAdmin(Admin admin) {
    this.admin = admin;
  }

  /**
   * Save the Vendor Staff Detail page
   * 
   * @param context
   *                The GrndsExchangeContext object
   */
  public void saveVendorStaffDetail_xa(GrndsExchangeContext context) {
    GrndsTrace.enterScope(TRACE_TAG + ".saveVendorStaffDetail_xa");
    HttpServletRequest request = context.getRequest();
    try {
      boolean passwordChangeFlag = false;
      String screenName = ContextHelper.getStringSafe(request, "hdnScreenName").trim().length() <= 0 ? StringHelper.EMPTY_STRING
                                                                                                     : ContextHelper
                                                                                                                    .getStringSafe(
                                                                                                                                   request,
                                                                                                                                   "hdnScreenName")
                                                                                                                    .trim();
      //Check for the duplicate of the email id before updating
      //Set the User name (email ID) to SI object
      ValidateLoginSI validateLoginSI = new ValidateLoginSI();
      int idUser = GlobalData.getUlIdStaff(request);
      String userName = ContextHelper.getStringSafe(request, "txtEmail")!=null?ContextHelper.getStringSafe(request, "txtEmail"):"";
      validateLoginSI.setUserName(userName);
      validateLoginSI.setIdUser(idUser);
      validateLoginSI.setCrudFlag(COUNT_PORTAL_USER_BY_EMAIL_AND_NOT_ID_USER);    
      //Get the decrypted password
      ValidateLoginSO validateLoginSO = admin.validateLogin(validateLoginSI);
      if (validateLoginSO.getEmailCount() > 0){
        //Constraint violation for updating the email with the existing email address in the system.
        throw new SecurityException(MessageLookup.getMessageByNumber(Messages.MSG_PORTAL_DUP_REG));
      }      
      SaveVendorStaffDetailSI saveVendorStaffDetailSI = populateSaveVendorStaffDetailSI(context,
                                                                                        SAVE_VENDOR_STAFF_DETAIL);
      SaveVendorStaffDetailSO saveVendorStaffDetailSO = admin.saveVendorStaffDetail(saveVendorStaffDetailSI);

      if (saveVendorStaffDetailSO != null && saveVendorStaffDetailSO.isSaveFlag()) {
        if (passwordChangeFlag){
          setInformationalMessage(Messages.MSG_PORTAL_PWD_UPDATE, request);
        }
        if (screenName.equals(SHINES_STAFF_LIST)) {
          // Redirect to Staff Detail Page
          this.setPresentationBranch("staffDtl", context);
        } else if (screenName.equals(SHINES_PENDING_STAFF_LIST)) {
          // Redirect to Pending Admin Page
          this.setPresentationBranch("pending", context);
        } else if (screenName.equals(SHINES_PENDING_ADMIN_LIST)) {
          // Redirect to Pending Admin Page
          this.setPresentationBranch("pendingAdmin", context);
        } else {
          // default (this should never be used. Just for safer side)
          this.setPresentationBranch("staffDtl", context);
        }
      }
      GrndsTrace.exitScope();
    } catch (SecurityException se) {
      GrndsTrace.msg(TRACE_TAG, 7, "Setting the error attribute and presentation branch");
      String screenName = ContextHelper.getStringSafe(request, "hdnScreenName").trim().length() <= 0 ? StringHelper.EMPTY_STRING
                                                                                                    : ContextHelper
                                                                                                                   .getStringSafe(
                                                                                                                                  request,
                                                                                                                                  "hdnScreenName")
                                                                                                                   .trim();
      if (screenName.equals(SHINES_STAFF_LIST)) {
        // Redirect to Staff Detail Page
        this.setPresentationBranch("errorStaff", context);
      } else if (screenName.equals(SHINES_PENDING_STAFF_LIST)) {
        // Redirect to Pending Page
        this.setPresentationBranch("errorPending", context);
      } else if (screenName.equals(SHINES_PENDING_ADMIN_LIST)) {
        // Redirect to Pending Page
        this.setPresentationBranch("errorPendingAdmin", context);
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
   * Do any necessary processing before displaying the Vendor Staff Detail page
   * 
   * @param context
   *                The GrndsExchangeContext object
   */
  public void displayVendorStaffDetail_xa(GrndsExchangeContext context) {
    GrndsTrace.enterScope(TRACE_TAG + ".displayVendorStaffDetail_xa");
    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();
    int idUser = ContextHelper.getIntSafe(request, "hdnUlIdUser");
    String screenName = SHINES_STAFF_LIST;
    if (idUser <= 0) {
      // Get the ID User from the Global Data if user clicks on Staff Detail Tab
      idUser = GlobalData.getUlIdStaff(request);
    }
    // Load the data for the retrieval
    RetrieveVendorStaffDetailSI retrieveVendorStaffDetailSI = populateRetrieveVendorStaffDetailSI(context, idUser,
                                                                                                  screenName);
    // Retrieve the data
    RetrieveVendorStaffDetailSO retrieveVendorStaffDetailSO = admin
                                                                   .retrieveVendorStaffDetail(retrieveVendorStaffDetailSI);
    // Set Logged In User Type
    retrieveVendorStaffDetailSO.setUserAccessType(SEC_VENDOR_STAFF_ACCESS);
    // Set From Page as List Page
    retrieveVendorStaffDetailSO.setFromPage(FROM_LIST_PAGE);
    state.setAttribute("retrieveVendorStaffDetailSO", retrieveVendorStaffDetailSO, request);
    GlobalData.setUlIdStaff(idUser, request);
    GrndsTrace.exitScope();
  }

  /**
   * Do any necessary processing before displaying the Pending Vendor Staff Detail page
   * 
   * @param context
   *                The GrndsExchangeContext object
   */
  public void displayPendingVendorStaffDetail_xa(GrndsExchangeContext context) {
    GrndsTrace.enterScope(TRACE_TAG + ".displayPendingVendorStaffDetail_xa");
    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();
    int idUser = ContextHelper.getIntSafe(request, "hdnUlIdUser");
    String screenName = SHINES_PENDING_STAFF_LIST;
    if (idUser <= 0) {
      // Get the ID User from the Global Data if user clicks on Staff Detail Tab
      idUser = GlobalData.getUlIdStaff(request);
    }
    // Load the data for the retrieval
    RetrieveVendorStaffDetailSI retrieveVendorStaffDetailSI = populateRetrieveVendorStaffDetailSI(context, idUser,
                                                                                                  screenName);
    // Retrieve the data
    RetrieveVendorStaffDetailSO retrieveVendorStaffDetailSO = admin
                                                                   .retrieveVendorStaffDetail(retrieveVendorStaffDetailSI);
    // Set Logged In User Type
    retrieveVendorStaffDetailSO.setUserAccessType(SEC_VENDOR_STAFF_ACCESS);
    // Set From Page as List Page
    retrieveVendorStaffDetailSO.setFromPage(FROM_LIST_PAGE);    
    state.setAttribute("retrieveVendorStaffDetailSO", retrieveVendorStaffDetailSO, request);
    GlobalData.setUlIdStaff(idUser, request);
    GrndsTrace.exitScope();
  }
  public static List<CodeAttributes> getMethodOptions(String screenName) {
    List<CodeAttributes> methodOptions = new ArrayList<CodeAttributes>();
    List<CodeAttributes> codesTable = null;

    try {
      codesTable = Lookup.getCategoryCollectionSortedByDecode(CodesTables.CUSRSTAT);
    } catch (LookupException le) {
      throw new IllegalStateException("Lookup data has not been initialized. Contact tech support for assistance.");
    }
    if (codesTable != null) {
      if (screenName.equals(SHINES_STAFF_LIST)) {
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
   * Do any necessary processing before displaying the Pending Vendor Admin Detail page
   * 
   * @param context
   *                The GrndsExchangeContext object
   */
  public void displayPendingPortalAdminDetail_xa(GrndsExchangeContext context) {
    GrndsTrace.enterScope(TRACE_TAG + ".displayPendingPortalAdminDetail_xa");
    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();
    int idUser = ContextHelper.getIntSafe(request, "hdnUlIdUser");
    String screenName = SHINES_PENDING_ADMIN_LIST;
    if (idUser <= 0) {
      // Get the ID User from the Global Data if user clicks on Staff Detail Tab
      idUser = GlobalData.getUlIdStaff(request);
    }
    // Load the data for the retrieval
    RetrieveVendorStaffDetailSI retrieveVendorStaffDetailSI = populateRetrieveVendorStaffDetailSI(context, idUser,
                                                                                                  screenName);
    // Retrieve the data
    RetrieveVendorStaffDetailSO retrieveVendorStaffDetailSO = admin
                                                                   .retrieveVendorStaffDetail(retrieveVendorStaffDetailSI);
    // Set Logged In User Type
    retrieveVendorStaffDetailSO.setUserAccessType(SEC_VENDOR_STAFF_ACCESS);
    // Set From Page as List Page
    retrieveVendorStaffDetailSO.setFromPage(FROM_LIST_PAGE);    
    state.setAttribute("retrieveVendorStaffDetailSO", retrieveVendorStaffDetailSO, request);
    GlobalData.setUlIdStaff(idUser, request);
    GrndsTrace.exitScope();
  }
  /**
   * Approve the Pending Vendor Staff Detail page
   * 
   * @param context
   *                The GrndsExchangeContext object
   */
  public void approveVendorStaffDetail_xa(GrndsExchangeContext context) {
    GrndsTrace.enterScope(TRACE_TAG + ".approveVendorStaffDetail_xa");
    HttpServletRequest request = context.getRequest();
    String screenName = ContextHelper.getStringSafe(request, "hdnScreenName").trim().length() <= 0 ? StringHelper.EMPTY_STRING
                                                                                                   : ContextHelper
                                                                                                                  .getStringSafe(
                                                                                                                                 request,
                                                                                                                                 "hdnScreenName")
                                                                                                                  .trim();
    
    try {
      SaveVendorStaffDetailSI saveVendorStaffDetailSI = populateSaveVendorStaffDetailSI(context,
                                                                                        APPROVE_VENDOR_STAFF_DETAIL);
      SaveVendorStaffDetailSO saveVendorStaffDetailSO = admin.saveVendorStaffDetail(saveVendorStaffDetailSI);

      if (saveVendorStaffDetailSO != null && saveVendorStaffDetailSO.isSaveFlag()) {
        // Send Email Notification
        sendMail(saveVendorStaffDetailSI.getTxtUserEmail(),MessageLookup.getMessageByNumber(Messages.MSG_PORTAL_EMAIL_SUBJ2), 
                 MessageLookup.addMessageParameter(MessageLookup.getMessageByNumber(Messages.MSG_PORTAL_EMAIL_APPRV)
                                                   , saveVendorStaffDetailSI.getTxtUserEmail()));
        if (screenName.equals(SHINES_PENDING_STAFF_LIST)) {
          // Redirect to Pending Admin Page
          this.setPresentationBranch("pending", context);
        } else if (screenName.equals(SHINES_PENDING_ADMIN_LIST)) {
          // Redirect to Pending Admin Page
          this.setPresentationBranch("pendingAdmin", context);
        }
      }

      GrndsTrace.exitScope();
    } catch (SecurityException se) {
      GrndsTrace.msg(TRACE_TAG, 7, "Setting the error attribute and presentation branch");
      if (screenName.equals(SHINES_PENDING_STAFF_LIST)) {
        // Redirect to Pending Page
        this.setPresentationBranch("errorPending", context);
      } else if (screenName.equals(SHINES_PENDING_ADMIN_LIST)) {
        // Redirect to Pending Admin Page
        this.setPresentationBranch("errorPendingAdmin", context);
      }
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
   *                The GrndsExchangeContext object
   */
  public void disapproveVendorStaffDetail_xa(GrndsExchangeContext context) {
    GrndsTrace.enterScope(TRACE_TAG + ".disapproveVendorStaffDetail_xa");
    HttpServletRequest request = context.getRequest();
    String screenName = ContextHelper.getStringSafe(request, "hdnScreenName").trim().length() <= 0 ? StringHelper.EMPTY_STRING
                                                                                                   : ContextHelper
                                                                                                                  .getStringSafe(
                                                                                                                                 request,
                                                                                                                                 "hdnScreenName")
                                                                                                                  .trim();
    
    try {
      Integer idUser = GlobalData.getUlIdStaff(request);
      ValidateLoginSI validateLoginSI = new ValidateLoginSI();
      //Set the User ID to SI object
      validateLoginSI.setIdUser(idUser);
      validateLoginSI.setCrudFlag(VALIDATE_USER_STATUS);
      //Get the Status of the User
      ValidateLoginSO validateLoginSO = admin.validateLogin(validateLoginSI); 
      String cdStatus = validateLoginSO.getCdStatus()!=null?validateLoginSO.getCdStatus():"";
      //Check if the status is Pending before allowing the user to disapprove.
      if (CodesTables.CUSRSTAT_ACT.equals(cdStatus)){
        //Password didn't match
        setErrorMessage("Cannot be disapproved after approval",request);
        throw new SecurityException();
      }

      SaveVendorStaffDetailSI saveVendorStaffDetailSI = populateSaveVendorStaffDetailSI(context,
                                                                                        DISAPPROVE_VENDOR_STAFF_DETAIL);
      SaveVendorStaffDetailSO saveVendorStaffDetailSO = admin.saveVendorStaffDetail(saveVendorStaffDetailSI);

      if (saveVendorStaffDetailSO != null && saveVendorStaffDetailSO.isSaveFlag()) {
        // Send Email Notification
        sendMail(saveVendorStaffDetailSI.getTxtUserEmail(),MessageLookup.getMessageByNumber(Messages.MSG_PORTAL_EMAIL_SUBJ2), 
                 MessageLookup.getMessageByNumber(Messages.MSG_PORTAL_EMAIL_DISAPPRV));
        if (screenName.equals(SHINES_PENDING_STAFF_LIST)) {
          // Redirect to Pending Admin Page
          this.setPresentationBranch("pending", context);
        } else if (screenName.equals(SHINES_PENDING_ADMIN_LIST)) {
          // Redirect to Pending Admin Page
          this.setPresentationBranch("pendingAdmin", context);
        }        
      }

      GrndsTrace.exitScope();
    } catch (SecurityException se) {
      GrndsTrace.msg(TRACE_TAG, 7, "Setting the error attribute and presentation branch");
      if (screenName.equals(SHINES_PENDING_STAFF_LIST)) {
        // Redirect to Pending Page
        this.setPresentationBranch("errorPending", context);
      } else if (screenName.equals(SHINES_PENDING_ADMIN_LIST)) {
        // Redirect to Pending Admin Page
        this.setPresentationBranch("errorPendingAdmin", context);
      }
      setErrorMessage(se.getMessage(), request);
      GrndsTrace.exitScope();
      return;
    } catch (Exception e) {
      processSevereException(context, e);
    }
  }

  /**
   * Delete the Vendor
   * 
   * @param context
   *                The GrndsExchangeContext object
   */
  public void deleteVendor_xa(GrndsExchangeContext context) {
    GrndsTrace.enterScope(TRACE_TAG + ".deleteVendor_xa");
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    //Get the SO object
    RetrieveVendorStaffDetailSO retrieveVendorStaffDetailSO = 
          (RetrieveVendorStaffDetailSO)state.getAttribute("retrieveVendorStaffDetailSO",request);
    String screenName = ContextHelper.getStringSafe(request, "hdnScreenName").trim().length() <= 0 ? StringHelper.EMPTY_STRING
                                                                                                   : ContextHelper
                                                                                                                  .getStringSafe(
                                                                                                                                 request,
                                                                                                                                 "hdnScreenName")
                                                                                                                  .trim();
    
    if (retrieveVendorStaffDetailSO.getResourceListforUser().size() <= 1){
      //An administrator attempts to Approve a pending registration without associating 
      //any vendors to the user.
      setErrorMessage(Messages.MSG_PORTAL_UPDATE_VENDORS,request);              
      // Redirect to Staff Detail Page
      this.setPresentationBranch("errorStaff", context);
      return;      
    }    
    try {
      SaveVendorStaffDetailSI saveVendorStaffDetailSI = populateSaveVendorStaffDetailSI(context,
                                                                                        DELETE_VENDOR_STAFF_DETAIL);
      SaveVendorStaffDetailSO saveVendorStaffDetailSO = admin.saveVendorStaffDetail(saveVendorStaffDetailSI);

      if (saveVendorStaffDetailSO != null && saveVendorStaffDetailSO.isSaveFlag()) {
        if (screenName.equals(SHINES_STAFF_LIST)) {
          // Redirect to Staff Detail Page
          this.setPresentationBranch("staffDtl", context);
        } else if (screenName.equals(SHINES_PENDING_STAFF_LIST)) {
          // Redirect to Pending Admin Page
          this.setPresentationBranch("pending", context);
        } else if (screenName.equals(SHINES_PENDING_ADMIN_LIST)) {
          // Redirect to Pending Admin Page
          this.setPresentationBranch("pendingAdmin", context);
        } else {
          // default (this should never be used. Just for safer side)
          this.setPresentationBranch("staffDtl", context);
        }
      }

      GrndsTrace.exitScope();
    } catch (SecurityException se) {
      GrndsTrace.msg(TRACE_TAG, 7, "Setting the error attribute and presentation branch");

      if (screenName.equals(SHINES_STAFF_LIST)) {
        // Redirect to Staff Detail Page
        this.setPresentationBranch("errorStaff", context);
      } else if (screenName.equals(SHINES_PENDING_STAFF_LIST)) {
        // Redirect to Pending Page
        this.setPresentationBranch("errorPending", context);
      } else if (screenName.equals(SHINES_PENDING_ADMIN_LIST)) {
        // Redirect to Pending Page
        this.setPresentationBranch("errorPendingAdmin", context);
      } else {
        // default (this should never be used. Just for safer side)
        this.setPresentationBranch("errorStaff", context);
      }
      setErrorMessage(se.getMessage(), request);
      GrndsTrace.exitScope();
      return;
    } catch (ServiceException se) {
      GrndsTrace.msg(TRACE_TAG, 7, "Setting the error attribute and presentation branch");

      if (screenName.equals(SHINES_STAFF_LIST)) {
        // Redirect to Staff Detail Page
        this.setPresentationBranch("errorStaff", context);
      } else if (screenName.equals(SHINES_PENDING_STAFF_LIST)) {
        // Redirect to Pending Page
        this.setPresentationBranch("errorPending", context);
      } else if (screenName.equals(SHINES_PENDING_ADMIN_LIST)) {
        // Redirect to Pending Page
        this.setPresentationBranch("errorPendingAdmin", context);
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
  public void selectResource_xa(GrndsExchangeContext context) {
    GrndsTrace.enterScope(TRACE_TAG + ".selectResource_xa");
    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();
    int idUser = ContextHelper.getIntSafe(request, "hdnUlIdUser");
    String screenName = ContextHelper.getStringSafe(request, "hdnScreenName");
    if (idUser <= 0) {
      // Get the ID User from the Global Data if user clicks on Staff Detail Tab
      idUser = GlobalData.getUlIdStaff(request);
    }
    try {
      // Retrieve the data
      RetrieveVendorStaffDetailSO retrieveVendorStaffDetailSO =(RetrieveVendorStaffDetailSO)state.getAttribute("retrieveVendorStaffDetailSO",  request);
      if (retrieveVendorStaffDetailSO == null){
        // Load the data for the retrieval
        RetrieveVendorStaffDetailSI retrieveVendorStaffDetailSI = populateRetrieveVendorStaffDetailSI(context, idUser,
                                                                                                      screenName);
        // Retrieve the data
        retrieveVendorStaffDetailSO = admin.retrieveVendorStaffDetail(retrieveVendorStaffDetailSI);
      }
      // Set Logged In User Type
      retrieveVendorStaffDetailSO.setUserAccessType(SEC_VENDOR_STAFF_ACCESS);
      // Set From Page as List Page
      retrieveVendorStaffDetailSO.setFromPage(FROM_RSRC_SEARCH);       
      state.setAttribute("retrieveVendorStaffDetailSO", retrieveVendorStaffDetailSO, request);
      GlobalData.setUlIdStaff(idUser, request);
      GrndsTrace.exitScope();
    } catch (Exception e) {
      processSevereException(context, e);
    } finally {
      GrndsTrace.exitScope();
    }
  }
  
  public void setResource_xa(GrndsExchangeContext context){
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".setResource_xa");
    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();
    try {
      RetrieveVendorStaffDetailSO retrieveVendorStaffDetailSO = (RetrieveVendorStaffDetailSO) state.getAttribute("retrieveVendorStaffDetailSO", request);
      populateResource(request, retrieveVendorStaffDetailSO);

      state.setAttribute("retrieveVendorStaffDetailSO", retrieveVendorStaffDetailSO,request);

    } catch (SecurityException se) {
      GrndsTrace.msg(TRACE_TAG, 7, "Setting the error attribute and presentation branch");
      setErrorMessage(se.getMessage(), request);
      GrndsTrace.exitScope();
      return;
    } catch (Exception e) {
      processSevereException(context, e);
    } finally {
      performanceTrace.exitScope();
    }    
  }
  /**
   * Reset Password Vendor Staff Detail page
   * 
   * @param context
   *                The GrndsExchangeContext object
   */
  public void resetPassword_xa(GrndsExchangeContext context) {
    GrndsTrace.enterScope(TRACE_TAG + ".resetPassword_xa");
    HttpServletRequest request = context.getRequest();
    try {
      SaveVendorStaffDetailSI saveVendorStaffDetailSI = populateSaveVendorStaffDetailSI(context,
                                                                                        PASSWORD_RESET_STAFF_DETAIL);
      SaveVendorStaffDetailSO saveVendorStaffDetailSO = admin.saveVendorStaffDetail(saveVendorStaffDetailSI);

      if (saveVendorStaffDetailSO != null && saveVendorStaffDetailSO.isSaveFlag()) {
        // Send Email Notification
        sendMail(saveVendorStaffDetailSI.getTxtUserEmail(),MessageLookup.getMessageByNumber(Messages.MSG_PORTAL_EMAIL_SUBJ3), 
                 MessageLookup.addMessageParameter(MessageLookup.getMessageByNumber(Messages.MSG_PORTAL_EMAIL_TEMPPWD)
                                                                 , saveVendorStaffDetailSO.getTxtResetPassword()));
        setInformationalMessage(Messages.MSG_PORTAL_PWD_RESET_SUCCESS, request);
      }
      GrndsTrace.exitScope();
    } catch (SecurityException se) {
      GrndsTrace.msg(TRACE_TAG, 7, "Setting the error attribute and presentation branch");
      setErrorMessage(se.getMessage(), request);
      GrndsTrace.exitScope();
      return;
    } catch (Exception e) {
      processSevereException(context, e);
    }
  }
  
  protected void populateResource(HttpServletRequest request, RetrieveVendorStaffDetailSO retrieveVendorStaffDetailSO) {
    CRES03SO cres03so = (CRES03SO) request.getAttribute(RESOURCE_PULLBACK_INFO);
    if (cres03so == null) {
      return;
    }
    request.removeAttribute(RESOURCE_PULLBACK_INFO);
    int idResourceIdForPullback = 0;
    idResourceIdForPullback = cres03so.getUlIdResource();
    if (idResourceIdForPullback != 0) {
      retrieveVendorStaffDetailSO.setIdResource(cres03so.getUlIdResource());
      retrieveVendorStaffDetailSO.setNmResource(String.valueOf(cres03so.getSzNmResource()));
    }
  }  
  /**
   * Retrieve the Resource ID to display
   * 
   * @return
   */
  private RetrieveVendorStaffDetailSI populateRetrieveVendorStaffDetailSI(GrndsExchangeContext context, int idUser,
                                                                          String screenName) {
    HttpServletRequest request = context.getRequest();    
    RetrieveVendorStaffDetailSI retrieveVendorStaffDetailSI = new RetrieveVendorStaffDetailSI();
    retrieveVendorStaffDetailSI.setIdUser(idUser);
    retrieveVendorStaffDetailSI.setRetrieveFlag(screenName);
    retrieveVendorStaffDetailSI.setUserAccessType(SEC_VENDOR_STAFF_ACCESS);
    Integer loggedInUserId = UserProfileHelper.getUserProfile(request).getUserID();
    retrieveVendorStaffDetailSI.setIdLoggedInUser(loggedInUserId);    
    return retrieveVendorStaffDetailSI;
  }

  private SaveVendorStaffDetailSI populateSaveVendorStaffDetailSI(GrndsExchangeContext context, String saveFlag)
                                                                                                                throws SecurityException {
    HttpServletRequest request = context.getRequest();
    // Set the User name (email ID) to SI object
    SaveVendorStaffDetailSI saveVendorStaffDetailSI = new SaveVendorStaffDetailSI();
    saveVendorStaffDetailSI.setSavePage(saveFlag);

    saveVendorStaffDetailSI.setIdUser(GlobalData.getUlIdStaff(request));
    saveVendorStaffDetailSI.setTxtUserEmail(ContextHelper.getStringSafe(request, "txtEmail"));
    saveVendorStaffDetailSI.setModifiedSystem(SHINES_SYSTEM);
    Integer loggedInUserId = UserProfileHelper.getUserProfile(request).getUserID();
    saveVendorStaffDetailSI.setLoggedInUser(loggedInUserId); 
    // Set Logged In User Type
    saveVendorStaffDetailSI.setUserAccessType(SEC_VENDOR_STAFF_ACCESS);
    if (saveFlag.equals(SAVE_VENDOR_STAFF_DETAIL) || saveFlag.equals(APPROVE_VENDOR_STAFF_DETAIL)) {
      // Set the Update or Insert Flag
      if (ContextHelper.getStringSafe(request, "hdnSelectFlag").equals(StringHelper.BOOLEAN_TRUE)) {
        saveVendorStaffDetailSI.setCrudFlag(UPDATE);
      } else if (ContextHelper.getStringSafe(request, "hdnAddFlag").equals(StringHelper.BOOLEAN_TRUE)) {
        saveVendorStaffDetailSI.setCrudFlag(INSERT);
      }
      saveVendorStaffDetailSI.setNmUserFirst(ContextHelper.getStringSafe(request, "txtFirstName"));
      saveVendorStaffDetailSI.setNmUserMiddle(ContextHelper.getStringSafe(request, "txtMiddleInitial"));
      saveVendorStaffDetailSI.setNmUserLast(ContextHelper.getStringSafe(request, "txtLastName"));
      saveVendorStaffDetailSI.setTxtTitle(ContextHelper.getStringSafe(request, "txtTitle"));
      saveVendorStaffDetailSI.setNbrUserPhone(ContextHelper.getPhoneSafe(request, "txtPhoneNumber"));
      saveVendorStaffDetailSI.setNbrUserPhoneExtension(ContextHelper.getStringSafe(request, "txtPhoneExtension"));
      saveVendorStaffDetailSI.setAddrUserAddrStLn1(ContextHelper.getStringSafe(request, "txtAddress1"));
      saveVendorStaffDetailSI.setAddrUserAddrStLn2(ContextHelper.getStringSafe(request, "txtAddress2"));
      saveVendorStaffDetailSI.setAddrUserAddrCity(ContextHelper.getStringSafe(request, "txtCity"));
      saveVendorStaffDetailSI.setAddrUserAddrZip(ContextHelper.getStringSafe(request, "txtZip")
                                                 + ContextHelper.getStringSafe(request, "txtZipSuff"));
      saveVendorStaffDetailSI.setCdUserAddrState(ContextHelper.getStringSafe(request, "selState"));
      saveVendorStaffDetailSI.setCdUserAddrCounty(ContextHelper.getStringSafe(request, "selCounty"));
      saveVendorStaffDetailSI.setCdRequestType(ContextHelper.getStringSafe(request, "selReqType"));
      saveVendorStaffDetailSI
                             .setIdPuvl(ContextHelper.getStringSafe(request, "hdnDisplayPuvlId").trim().length() <= 0 ? "0"
                                                                                                                     : ContextHelper
                                                                                                                                    .getStringSafe(
                                                                                                                                                   request,
                                                                                                                                                   "hdnDisplayPuvlId"));
      saveVendorStaffDetailSI
                             .setIdResource(ContextHelper.getStringSafe(request, "hdnDisplayRsrcId").trim().length() <= 0 ? "0"
                                                                                                                         : ContextHelper
                                                                                                                                        .getStringSafe(
                                                                                                                                                       request,
                                                                                                                                                       "hdnDisplayRsrcId"));
      saveVendorStaffDetailSI.setCdStatus(ContextHelper.getStringSafe(request, "selStatus"));
      saveVendorStaffDetailSI.setCdUserType(ContextHelper.getStringSafe(request, "selUserType"));
      saveVendorStaffDetailSI.setDtStart(ContextHelper.getJavaDateSafe(request, "dtStart"));
      saveVendorStaffDetailSI.setDtEnd(ContextHelper.getJavaDateSafe(request, "dtEnd"));
      saveVendorStaffDetailSI.setIndUserAgreement(CheckboxHelper.getCheckboxValue(request, "cbxUsrAgrmnt"));
      //Set the Logged In User ID for auditing purpose as who approved
      if (saveFlag.equals(APPROVE_VENDOR_STAFF_DETAIL)) {
        saveVendorStaffDetailSI.setModifiedSystem(SHINES_SYSTEM);
      }
    } else if (saveFlag.equals(DELETE_VENDOR_STAFF_DETAIL)) {
      saveVendorStaffDetailSI
                             .setIdPuvl(ContextHelper.getStringSafe(request, "hdnDisplayPuvlId").trim().length() <= 0 ? "0"
                                                                                                                     : ContextHelper
                                                                                                                                    .getStringSafe(
                                                                                                                                                   request,
                                                                                                                                                   "hdnDisplayPuvlId"));
      saveVendorStaffDetailSI
                            .setIdResource(ContextHelper.getStringSafe(request, "hdnDisplayRsrcId").trim().length() <= 0 ? "0"
                                                                                                  : ContextHelper
                                                                                                                 .getStringSafe(
                                                                                                                                request,
                                                                                                                                "hdnDisplayRsrcId"));


    } else if (saveFlag.equals(PASSWORD_RESET_STAFF_DETAIL)) {
      //Generate Random Password using Password Generator
      try {
        PasswordGenerator pg = new PasswordGenerator();
        String randPassword = pg.generate();
        saveVendorStaffDetailSI.setTxtRandPassword(randPassword);
      } catch (Exception ex) {
        throw new SecurityException("Password Generator Failed to generate new password!!!");
      }
    }
    return saveVendorStaffDetailSI;
  }
  
  private void sendMail(String email, String subject, String body) throws Exception{
    try {
      // Send Email Notification
      EmailDelivery ed = new EmailDelivery();
      //ed.setSMTPHost(SMTP_HOST);
      // Comment the following line before Committing back to the Repository
      ed.setSMTPHost(SMTP_HOST,SMTP_USER_NAME,SMTP_USER_PASSWORD);
      ed.setTo(email);
      ed.setFrom(SMTP_USER_EMAIL, SMTP_USER_NAME);
      ed.setSubject(subject);
      ed.setBody(body);
      ed.sendMsg();
    } catch (Exception ex) {
      throw new SecurityException("Your data saved successfully. But Email transmission failed. If the problem persists contact your Administrator.");
    }
  }
}

