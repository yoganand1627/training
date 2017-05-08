package gov.georgia.dhr.dfcs.sacwis.web.exchange;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import javax.servlet.http.HttpServletRequest;

public class ExchangeChildSearchCustomValidation extends FormValidation {
  protected boolean validateForm() {
    boolean isValid = true;
    final String IND_RETURN_ERROR = "indReturnError"; 
    HttpServletRequest request = super.getRequest();
    BaseSessionStateManager state = super.getState();
    
    //check age ranges
    int minMaleYear = ContextHelper.getIntSafe(request, "selMaleMinYearInt");
    int maxMaleYear = ContextHelper.getIntSafe(request, "selMaleMaxYearInt");
    int minMaleMonth = ContextHelper.getIntSafe(request, "selMaleMinMonthInt");
    int maxMaleMonth = ContextHelper.getIntSafe(request, "selMaleMaxMonthInt");
    int minFemaleYear = ContextHelper.getIntSafe(request, "selFemaleMinYearInt");
    int maxFemaleYear = ContextHelper.getIntSafe(request, "selFemaleMaxYearInt");
    int minFemalMonth = ContextHelper.getIntSafe(request, "selFemaleMinMonthInt");
    int maxFemaleMonth = ContextHelper.getIntSafe(request, "selFemaleMaxMonthInt");
    int minMaleAgeInMonths = (minMaleYear * 12) + minMaleMonth;
    int maxMaleAgeInMonths = (maxMaleYear * 12) + maxMaleMonth;
    int minFemaleAgeInMonths = (minFemaleYear * 12) + minFemalMonth;
    int maxFemaleAgeInMonths = (maxFemaleYear * 12) + maxFemaleMonth;
  
    if(minMaleAgeInMonths>maxMaleAgeInMonths || minFemaleAgeInMonths>maxFemaleAgeInMonths){
      isValid = false;
      setErrorMessage(Messages.SSM_MIN_LESS_MAX);
      state.setAttribute(IND_RETURN_ERROR, ArchitectureConstants.Y, request);
    }

    return isValid;
  }
}
