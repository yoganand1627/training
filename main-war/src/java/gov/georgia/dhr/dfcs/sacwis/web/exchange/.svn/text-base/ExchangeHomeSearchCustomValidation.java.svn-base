package gov.georgia.dhr.dfcs.sacwis.web.exchange;

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

public class ExchangeHomeSearchCustomValidation extends FormValidation {
  protected boolean validateForm() {
    boolean isValid = true;
    
    HttpServletRequest request = super.getRequest();
    BaseSessionStateManager state = super.getState();
    
    //check age ranges
    int minMonth = ContextHelper.getIntSafe(request, "selMinMonth");
    int minYear = ContextHelper.getIntSafe(request, "selMinYear");
    int minAgeInMonths = (minYear * 12) + minMonth;
    int maxMonth = ContextHelper.getIntSafe(request, "selMaxMonth");
    int maxYear = ContextHelper.getIntSafe(request, "selMaxYear");
    int maxAgeInMonths = (maxYear * 12) + maxMonth;
    
    
    String cdPersonSex = ContextHelper.getStringSafe(request, "selSzCdGender");
  
    if (StringHelper.isValid(cdPersonSex)) {
      if (minAgeInMonths == 0 || maxAgeInMonths == 0) {
        isValid = false;
        setErrorMessage("selMinYear", Messages.MSG_FAD_AGE_REQ);
      } else if (minAgeInMonths > maxAgeInMonths) {
        isValid = false;
        setErrorMessage("selMinYear", Messages.SSM_MIN_LESS_MAX);
      }
    } else {
      if (minAgeInMonths != 0 || maxAgeInMonths != 0) {
        isValid = false;
        setErrorMessage("selSzCdGender", Messages.MSG_GENDER_REQ_AGE_RNGE);
      }
    }

    return isValid;
  }
}
