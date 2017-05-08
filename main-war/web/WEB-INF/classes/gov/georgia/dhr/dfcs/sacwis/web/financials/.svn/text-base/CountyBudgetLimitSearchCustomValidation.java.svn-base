package gov.georgia.dhr.dfcs.sacwis.web.financials;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

@SuppressWarnings("serial")
public class CountyBudgetLimitSearchCustomValidation extends FormValidation {
  
  public static final String TRACE_TAG = "CountyBudgetLimitSearchCustomValidation";

  protected boolean validateForm() {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validationForm()");
    performanceTrace.enterScope();
    HttpServletRequest request = super.getRequest();
    BaseSessionStateManager state = super.getState();
    UserProfile userProfile = UserProfileHelper.getUserProfile(request);

    // check if Program and County are null
    String county = ContextHelper.getStringSafe(request, "selCdCounty");
    String program = ContextHelper.getStringSafe(request, "selCdProgram");

    if ("".equals(program) && "".equals(county)) {
      setErrorMessage(Messages.MSG_PRGM_CNTY);
      state.removeAttribute(CountyBudgetLimitSearchConversation.SEARCH_RESULTS, request);
    }

    // check for counties the user can search on
    // first get the list of counties the user has
    // either by MAINTAIN_REGION attribute by UserProfile
    // Get all regions from the regions codestable.

    if (StringHelper.isValid(county) && !county.equals(userProfile.getUserCounty())) {
      //-- validate only entered county value according to user's maintainable regions
      List<String> userMaintainedRegions = userProfile.getUserMaintainedRegions();
      String region = Lookup.simpleDecodeSafe(CodesTables.CCNTYREG, county);
      if(!userMaintainedRegions.contains(region)) {
        setErrorMessage(Messages.MSG_BUD_CNTY);
        state.removeAttribute(CountyBudgetLimitSearchConversation.SEARCH_RESULTS, request);
      }
    }
    performanceTrace.exitScope();
    return getErrorMessages().isEmpty();
  }

}