/**
 * 
 */
package gov.georgia.dhr.dfcs.sacwis.web.admin;

import java.util.Date;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.service.admin.Admin;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ValidateLoginSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RetrieveVendorStaffDetailSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RetrieveVendorStaffLinkDetailBean;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ValidateLoginSO;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;

import javax.servlet.http.HttpServletRequest;
import org.apache.oro.text.perl.Perl5Util;
import org.apache.oro.text.regex.MalformedPatternException;

import org.grnds.structural.web.GrndsExchangeContext;

/**
 * This class is used to perform the custom validation on VendorStaffDetailPage
 * 
 * @author ssubram 10/26/2009 
 * 
 * Change History: 
 * Date      User              Description
 * --------  ----------------  --------------------------------------------------
 * 10/26/2009  ssubram         Initial Validation for Portal
 * 08/25/2010  schoi           SMS #66384: MR-067 Added validations for NYTD User
 *         
 *
 */
public class VendorStaffDetailCustomValidation extends FormValidation {
  /**
   * <p>
   * This method contains custom validation for Vendor Staff Detail in Portal
   * </p>
   * 
   * @return result - Returns false if the data fails validation. Returns true if the data passes validation.
   */
 
  public static final String TRACE_TAG = "VendorStaffDetailCustomValidation";

  private static final String PWD_PATTERN = "/^.*(?=.{8,})(?=.*[a-z])(?=.*[A-Z])(?=.*[" + "\\" + "d" + "\\" + "W]).*$/";
  
  private static final String PORTAL_STAFF_LIST = "portalActive";

  private static final String PORTAL_PENDING_STAFF_LIST = "portalPending";
  
  private static final String SELECT_USER_PASSWORD = "SELECT_USER_PASSWORD";
  
  private static final String PHONE_TYPE_CELL = "CL";
  
  protected boolean validateForm() {
    boolean result = true;
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG,
                                                             "VendorStaffDetailCustomValidation.validationForm()");
    performanceTrace.enterScope();
    BaseSessionStateManager state = super.getState();
    HttpServletRequest request = super.getRequest();
    GrndsExchangeContext context = super.getGrndsExchangeContext();

    String screenName = ContextHelper.getStringSafe(request, "hdnScreenName").trim().length() <= 0 ? StringHelper.EMPTY_STRING
                                                                                                  : ContextHelper
                                                                                                                 .getStringSafe(
                                                                                                                                request,
                                                                                                                                "hdnScreenName")
                                                                                                                 .trim();
    UserProfile profile = UserProfileHelper.getUserProfile(context);
    if(profile.hasRight(UserProfile.PLCMNT_PRV_ADMIN)
                    && !(GlobalData.getUlIdStaff(request)==profile.getUserID())){
      
      if (isButtonPressed("Approve")||isButtonPressed("Save")){
        String resourceId = ContextHelper.getStringSafe(request, "hdnDisplayRsrcId");
        if (resourceId!=null && resourceId.trim().length()>0){
          String userType = ContextHelper.getStringSafe(request, "selReqType");
          if (userType == null||userType.trim().length()<1){
            //"User Type" is required
            setErrorMessage("selReqType",Messages.SSM_COMPLETE_REQUIRED);
            result = false;          
          }
          String selStatus = ContextHelper.getStringSafe(request, "selStatus");
          if (selStatus == null||selStatus.trim().length()<1){
            //"status" is required
            setErrorMessage("selStatus",Messages.SSM_COMPLETE_REQUIRED);
            result = false;          
          }else if (selStatus.equals(CodesTables.CUSRSTAT_INA)){
            Date dateEnd = ContextHelper.getJavaDateSafe(request, "dtEnd");
            if (dateEnd == null){
              //"End Date" is required if the status is inactive.
              setErrorMessage("dtEnd",Messages.SSM_COMPLETE_REQUIRED);
              result = false;          
            }          
          }

          //If End Date is present, Status must be Inactive
          Date dateEnd = ContextHelper.getJavaDateSafe(request, "dtEnd");
          if(dateEnd!=null&&!selStatus.equals(CodesTables.CUSRSTAT_INA)){
            setErrorMessage("selStatus",Messages.MSG_ENDDT_NOT_INACTIVE);
            result = false;  
          }
        }
      }
    }   
    
    if ((screenName.equals(PORTAL_STAFF_LIST) && (profile.hasRight(UserProfile.PLCMNT_PRV_USRER)&&
                    !profile.hasRight(UserProfile.PLCMNT_PRV_ADMIN)||
                    (profile.hasRight(UserProfile.PLCMNT_PRV_ADMIN) &&
                       GlobalData.getUlIdStaff(request)==profile.getUserID()))) ||
                       profile.hasRight(UserProfile.NYTD_USER))
                    {    
      // Checking Password Standards and Match
      String newPassword = ContextHelper.getStringSafe(request, "txtNewPassword").trim();
      String newConfirmPassword = ContextHelper.getStringSafe(request, "txtNewPasswordConfirm").trim();
      Perl5Util m_perl = new Perl5Util();
      String pattern = PWD_PATTERN;
      boolean inverse = pattern.startsWith("!");
      if ((newPassword.length()>0)&&!(newConfirmPassword.length()>0)){
        setErrorMessage(Messages.MSG_PORTAL_PWD_REENTER);
        result = false;
      }
      if ((newPassword.length()>0)&&(newConfirmPassword.length()>0)){
        if (inverse) {
          pattern = pattern.substring(1);
        }
        result = m_perl.match(pattern, newPassword);
        if (inverse) {
          result = !result;
        }
        if (!result) {
          //The user attempts to submit a registration or update an existing password and the new password 
          //fails one or more of the conditions described in the message.
          setErrorMessage(Messages.MSG_PORTAL_PWD_STANDARDS);
          result = false;
        } else {
          if ((newPassword.length() < 8) || (newPassword.length() > 20)
              || (newPassword.substring(0, 8).equalsIgnoreCase("Password"))) {
            //The user attempts to submit a registration or update an existing password and the new password 
            //fails one or more of the conditions described in the message.
            setErrorMessage(Messages.MSG_PORTAL_PWD_STANDARDS);
            result = false;
          } else if (!(newPassword.equals(newConfirmPassword))) {
            //The user attempts to submit a registration with the new password not equal to the 
            //information entered in the re-enter new password field.
            setErrorMessage(Messages.MSG_PORTAL_PWD_MATCH);
            result = false;
          }
        }
      }
      // Checking questions
      String selSecQues1 = ContextHelper.getStringSafe(request, "selSecQues1");
      String selSecQues2 = ContextHelper.getStringSafe(request, "selSecQues2");
      String selSecQues3 = ContextHelper.getStringSafe(request, "selSecQues3");
      if (selSecQues1.equals(selSecQues2) || selSecQues1.equals(selSecQues3) || selSecQues3.equals(selSecQues2)) {
        setErrorMessage(Messages.MSG_PORTAL_DUP_SEC_QUESTION);
        result = false;
      }  
    }
    // SMS #66384: MR-067 
    if (profile.hasRight(UserProfile.NYTD_USER)) {    
      // Checking for required fields
      String emerContact = ContextHelper.getStringSafe(request, "szTxtEmerContact");
      if (!StringHelper.isValid(emerContact)) {
        String eMsg = "If we cannot locate you, who is a reliable adult who knows where you are? (Name and Contact Information) - "; 
        setErrorMessage(eMsg + MessageLookup.getMessageByNumber(Messages.SSM_COMPLETE_REQUIRED));
        result = false;
      }
      // Checking User Name if Other Site is entered
      String otherSite = ContextHelper.getStringSafe(request, "szTxtOtherSite");
      String otherSiteUserName = ContextHelper.getStringSafe(request, "szTxtUserName");
      if (StringHelper.isValid(otherSite) && !StringHelper.isValid(otherSiteUserName)) {
        setErrorMessage(Messages.MSG_PORTAL_OTHER_SITE);
        result = false;
      }
      //Checking "Can DFCS contact you by text?" if Cell is selected as the phone type
      String IndPhoneBest = ContextHelper.getStringSafe(request, "rbIndPhoneBest");
      String IndPhoneAltOne = ContextHelper.getStringSafe(request, "rbIndPhoneAltOne");
      String IndPhoneAltTwo = ContextHelper.getStringSafe(request, "rbIndPhoneAltTwo");     
      String rbIndTxt = ContextHelper.getStringSafe(request, "rbIndText");
      if ((!StringHelper.isValid(rbIndTxt)) && (PHONE_TYPE_CELL.equals(IndPhoneBest) ||
                      PHONE_TYPE_CELL.equals(IndPhoneAltOne) || PHONE_TYPE_CELL.equals(IndPhoneAltTwo))) {
        setErrorMessage(Messages.MSG_PORTAL_CONTACT_BY_TEXT);
        result = false;
      }  
    }    
    
    
    if (isButtonPressed("Approve")){
      boolean startDtEntered = true;
      String puvlIdStr = ContextHelper.getStringSafe(request, "hdnDisplayPuvlId").trim().length() <= 0 ? "0"
                                                                                      : ContextHelper
                                                                                                     .getStringSafe(
                                                                                                                    request,
                                                                                                                    "hdnDisplayPuvlId");
      Integer puvlId = 0;
      try{
        puvlId = Integer.parseInt(puvlIdStr);
      }catch (NumberFormatException nfe){
        puvlId = 0;
      }
      Date dateStart = ContextHelper.getJavaDateSafe(request, "dtStart");
      if (dateStart == null){
        //"Start Date" is required
        setErrorMessage("dtStart",Messages.SSM_COMPLETE_REQUIRED);
        startDtEntered = false;
        result = false;          
      } 
      //user agreement not required to disapprove
      String userAgrmnt = ContextHelper.getStringSafe(request, "cbxUsrAgrmnt");
      if(userAgrmnt == null||userAgrmnt.trim().length()<1){
              setErrorMessage("cbxUsrAgrmnt",Messages.SSM_COMPLETE_REQUIRED);
          result = false;     
      }      
      //Get the SO object
      RetrieveVendorStaffDetailSO retrieveVendorStaffDetailSO = 
            (RetrieveVendorStaffDetailSO)state.getAttribute("retrieveVendorStaffDetailSO",request);
      if (retrieveVendorStaffDetailSO.getResourceListforUser().size() < 1){
        //An administrator attempts to Approve a pending registration without associating 
        //any vendors to the user.
        setErrorMessage(Messages.MSG_PORTAL_APPRV_VENDOR);
        result = false;        
      }
      List<RetrieveVendorStaffLinkDetailBean> resourceList = 
                                          retrieveVendorStaffDetailSO.getResourceListforUser();
      if (resourceList.size() > 0){
        for(int i = 0; i < resourceList.size(); i++){
          RetrieveVendorStaffLinkDetailBean rvsldBean = resourceList.get(i);
          if (startDtEntered && !rvsldBean.getIdPortalUserVendorLink().equals(puvlId)&& 
                          rvsldBean.getDtStart() == null){
            setErrorMessage(MessageLookup.getMessageByNumber(Messages.MSG_PORTAL_VNDR_START_DT));
            result = false;
            break;
          }
        }
      }
    }
    if (isButtonPressed("Delete")){
      //Get the SO object
      RetrieveVendorStaffDetailSO retrieveVendorStaffDetailSO = 
            (RetrieveVendorStaffDetailSO)state.getAttribute("retrieveVendorStaffDetailSO",request);
      if (retrieveVendorStaffDetailSO.getResourceListforUser().size() <= 1){
        //An administrator attempts to Approve a pending registration without associating 
        //any vendors to the user.
        setErrorMessage(Messages.MSG_PORTAL_UPDATE_VENDORS);
        result = false;        
      }
    }
    if ((isButtonPressed("Approve")||isButtonPressed("Save"))&&
                    (screenName.equals(PORTAL_STAFF_LIST)||screenName.equals(PORTAL_PENDING_STAFF_LIST)) 
                    && profile.hasRight(UserProfile.PLCMNT_PRV_ADMIN)){
      String strIdResource = ContextHelper.getStringSafe(request, "hdnDisplayRsrcId");
      Date dtStart = ContextHelper.getJavaDateSafe(request, "dtStart");
      Date dtEnd = ContextHelper.getJavaDateSafe(request, "dtEnd");
      String statusCd = ContextHelper.getStringSafe(request, "selStatus");
      //Check for unique Vendor with the overlapped date only if the Add button is clicked
      if (ContextHelper.getStringSafe(request, "hdnAddFlag").equals(StringHelper.BOOLEAN_TRUE)){
        RetrieveVendorStaffDetailSO retrieveVendorStaffDetailSO = 
              (RetrieveVendorStaffDetailSO)state.getAttribute("retrieveVendorStaffDetailSO",request);
        List<RetrieveVendorStaffLinkDetailBean> resourceList = 
                                                retrieveVendorStaffDetailSO.getResourceListforUser();
        for(int i = 0; i < resourceList.size(); i++){
          RetrieveVendorStaffLinkDetailBean rvsldBean = resourceList.get(i);
          if (strIdResource.equals(String.valueOf(rvsldBean.getIdResource()))){
            Date existingDtEnd = rvsldBean.getDtEnd();
            if (existingDtEnd == null){
              setErrorMessage(MessageLookup.getMessageByNumber(Messages.MSG_PORTAL_VENDOR_UNIQUE));
              result = false;            
            }else if (existingDtEnd != null && dtStart!= null && dtStart.before(existingDtEnd)){
              setErrorMessage(MessageLookup.getMessageByNumber(Messages.MSG_PORTAL_VENDOR_UNIQUE));
              result = false;              
            }
          }
        }
        //For Portal Staff Detail, when a new vendor is added, Administrator Agreement
        //and start date are required
        if (isButtonPressed("Save") && screenName.equals(PORTAL_STAFF_LIST)&& 
                        profile.hasRight(UserProfile.PLCMNT_PRV_ADMIN)) {
          String userAgrmnt = ContextHelper.getStringSafe(request, "cbxUsrAgrmnt");
          if(userAgrmnt == null||userAgrmnt.trim().length()<1){
                  setErrorMessage("cbxUsrAgrmnt",Messages.SSM_COMPLETE_REQUIRED);
              result = false;     
          }
          if (dtStart == null){
            //"Start Date" is required when adding a new Vendor after the approval process. 
            setErrorMessage("dtStart",Messages.SSM_COMPLETE_REQUIRED);
            result = false;          
          }
        }
      }
      Date curDate = new Date();
      if (DateHelper.isAfter(dtStart, curDate)){
        setErrorMessage(MessageLookup.getMessageByNumber(Messages.MSG_PORTAL_VENDOR_START));
        result = false;
      } 
      if (DateHelper.isAfter(dtEnd, curDate)){
        setErrorMessage(MessageLookup.getMessageByNumber(Messages.MSG_PORTAL_VENDOR_END));
        result = false;
      }       
      if (DateHelper.isAfter(dtStart, dtEnd)){
        setErrorMessage(MessageLookup.getMessageByNumber(Messages.MSG_PORTAL_VENDOR_START_BEFORE_END));
        result = false;
      }
    }    
    return result;
  }
}
