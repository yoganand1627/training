package gov.georgia.dhr.dfcs.sacwis.web.resource;


import java.util.Date;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.structs.output.RetrieveVendorStaffDetailSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RetrieveVendorStaffLinkDetailBean;
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
import javax.servlet.http.HttpServletRequest;

import org.grnds.structural.web.GrndsExchangeContext;

/**
 * This class is used to perform the custom validation on VendorStaffDetailPage
 * 
 * @author ssubram 10/26/2009 Change History: Date User Description ---- ----
 *         ---------------------------------------------- 10/26/09 ssubram Initial Validation for Portal
 */
public class VendorStaffDetailCustomValidation extends FormValidation {
  /**
   * <p>
   * This method contains custom validation For Vendor Staff Detail Page in SHINES
   * </p>
   * 
   * @return result - Returns false if the data fails validation. Returns true if the data passes validation.
   */
 
  public static final String TRACE_TAG = "VendorStaffDetailCustomValidation";
  
  protected boolean validateForm() {
    boolean result = true;
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG,
                                                             "VendorStaffDetailCustomValidation.validationForm()");
    performanceTrace.enterScope();
    BaseSessionStateManager state = super.getState();
    HttpServletRequest request = super.getRequest();
    GrndsExchangeContext context = super.getGrndsExchangeContext();
    if (isButtonPressed("Approve")||isButtonPressed("Save")){
      String resourceId = ContextHelper.getStringSafe(request, "hdnDisplayRsrcId");
      if (resourceId!=null && resourceId.trim().length()>0){
        String userType = ContextHelper.getStringSafe(request, "selUserType");
        if (userType == null||userType.trim().length()<1){
          //"User Type" is required
          setErrorMessage("selUserType",Messages.SSM_COMPLETE_REQUIRED);
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
            //"End Date" is required
            setErrorMessage("dtEnd",Messages.SSM_COMPLETE_REQUIRED);
            result = false;          
          }          
        }
        Date dateEnd = ContextHelper.getJavaDateSafe(request, "dtEnd");
        if(dateEnd!=null&&!selStatus.equals(CodesTables.CUSRSTAT_INA)){
          setErrorMessage("selStatus",Messages.MSG_ENDDT_NOT_INACTIVE);
          result = false;  
        }
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
    if (isButtonPressed("Approve")||isButtonPressed("Save")){
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
            }else if (existingDtEnd != null && dtStart.before(existingDtEnd)){
              setErrorMessage(MessageLookup.getMessageByNumber(Messages.MSG_PORTAL_VENDOR_UNIQUE));
              result = false;              
            }
          }
        }
        //For Staff Detail, when a new vendor is added, start date is required
        if (isButtonPressed("Save")) {
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
