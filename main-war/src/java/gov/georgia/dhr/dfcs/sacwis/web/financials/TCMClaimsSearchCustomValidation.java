package gov.georgia.dhr.dfcs.sacwis.web.financials;

import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import javax.servlet.http.HttpServletRequest;

@SuppressWarnings("serial")
public class TCMClaimsSearchCustomValidation extends FormValidation {
  @Override
  protected boolean validateForm() {
    HttpServletRequest request = super.getRequest();
    switch(TCMClaimsSearchConversation.getTCMUserClass(request)) {
    case TCMClaimsSearchConversation.USER_CLASS_CASE_MGR:
      validateCaseMgr(request);
      break;
    case TCMClaimsSearchConversation.USER_CLASS_SUPERVISOR:
      validateSupervisor(request);
      break;
    case TCMClaimsSearchConversation.USER_CLASS_BILLING_UNIT:
      validateBillingUnit(request);
      break;
    }
    return getErrorMessages().isEmpty();
  }
  
  private void validateCaseMgr(HttpServletRequest request) {
    if("".equals(ContextHelper.getStringSafe(request, "selCdCounty"))) {
      setErrorMessage("selCdCounty", Messages.SSM_COMPLETE_REQUIRED);
    }
    if("".equals(ContextHelper.getStringSafe(request, "txtIdStaff"))) {
      setErrorMessage("txtIdStaff", Messages.SSM_COMPLETE_REQUIRED);
    } else {
      UserProfile user = UserProfileHelper.getUserProfile(request);
      if(ContextHelper.getIntSafe(request, "txtIdStaff") != user.getUserID()) {
        setErrorMessage(Messages.MSG_SVC_TCM_CMGR_NOT_USER);
      }
    }
    if("".equals(ContextHelper.getStringSafe(request, "txtIdClient")) &&
       "".equals(ContextHelper.getStringSafe(request, "txtMonth"))) {
      setErrorMessage(Messages.MSG_SVC_TCM_CMGR_REQ);
    }
  }
  
  private void validateSupervisor(HttpServletRequest request) {
    if("".equals(ContextHelper.getStringSafe(request, "selCdCounty"))) {
      setErrorMessage("selCdCounty", Messages.SSM_COMPLETE_REQUIRED);
    }
    if("".equals(ContextHelper.getStringSafe(request, "txtIdStaff")) &&
       "".equals(ContextHelper.getStringSafe(request, "txtUnit")) &&
       "".equals(ContextHelper.getStringSafe(request, "txtIdClient")) &&
       "".equals(ContextHelper.getStringSafe(request, "txtMonth"))) {
      setErrorMessage(Messages.MSG_SVC_TCM_SUP_REQ);
    }
  }
  
  private void validateBillingUnit(HttpServletRequest request) {
    boolean hasCounty = !"".equals(ContextHelper.getStringSafe(request, "selCdCounty"));
    boolean hasMonth = !"".equals(ContextHelper.getStringSafe(request, "txtMonth"));
    if(hasCounty && !hasMonth) {
      setErrorMessage("txtMonth", Messages.MSG_SVC_TCM_BU_REQ);
    } else if(!hasCounty && hasMonth) {
      setErrorMessage("selCdCounty", Messages.MSG_SVC_TCM_BU_REQ);
    } else if(!hasCounty && !hasMonth) {
      boolean noIdStaff = "".equals(ContextHelper.getStringSafe(request, "txtIdStaff"));
      boolean noIdClient = "".equals(ContextHelper.getStringSafe(request, "txtIdClient"));
      if(noIdStaff && noIdClient) {
        setErrorMessage(Messages.MSG_SVC_TCM_BU_ID_REQ);
      }
    }
  }
}
