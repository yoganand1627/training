package gov.georgia.dhr.dfcs.sacwis.web.subcare;

import gov.georgia.dhr.dfcs.sacwis.core.exception.RuntimeWrappedException;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @author steven.m.thrasher
 * 
 */
@SuppressWarnings("serial")
public class WTLPCustomValidation extends FormValidation {
  public static final String TRACE_TAG = "WTLPCustomValidation";

  /**
   * 
   * @return result - Returns false if the data fails validation. Returns true if the data passes validation.
   * @throws gov.georgia.dhr.dfcs.sacwis.core.exception.RuntimeWrappedException
   * 
   */
  protected boolean validateForm() throws RuntimeWrappedException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validateForm()");
    performanceTrace.enterScope();

    HttpServletRequest request = super.getRequest();
    boolean isValid = true;

    try {
      String volW = ContextHelper.getStringSafe(request, "descrVolW");
      String authPlace = ContextHelper.getStringSafe(request, WTLPConversation.IND_AUTH_PLACE);
      org.exolab.castor.types.Date fromDate = ContextHelper.getCastorDateSafe(request, WTLPConversation.TXT_WTLP_DURATION_FROM);
      org.exolab.castor.types.Date toDate = ContextHelper.getCastorDateSafe(request, WTLPConversation.TXT_WTLP_DURATION_TO);
      
      if (super.isButtonPressed(WTLPConversation.SAVE_BUTTON_ON_WTLP_PAGE)) {
        if ("VOL".equals(authPlace) && ("".equals(volW) || volW == null)) {
          isValid = false;
          setErrorMessage("descrVolW", Messages.MSG_VOL_W_EXP_REQ);
        }

      } // end if (super.isButtonPressed(PPTConversation.SAVE_BUTTON_ON_PPT_PAGE))
      if (fromDate != null && toDate != null && DateHelper.isAfter(fromDate, toDate)){
        isValid = false;
        setErrorMessage(WTLPConversation.TXT_WTLP_DURATION_FROM, Messages.MSG_FROM_DT_BEF_TO_DT);
      }
      if (super.isButtonPressed(WTLPConversation.SAVE_SUBMIT_ON_WTLP)) {
        String[] goalsStringArray = CheckboxHelper.getCheckedValues(request, WTLPConversation.ARRAY_TYPES_OF_GOALS);
        int coordName = ContextHelper.getIntSafe(request, WTLPConversation.TXT_COORD_NAME);
        String errorMessage = "";
        if ("VOL".equals(authPlace) && ("".equals(volW) || volW == null)) {
          setErrorMessage("descrVolW", Messages.MSG_VOL_W_EXP_REQ);
        }
        if (request.getParameter(WTLPConversation.PLAN_TYPE) == null
            || "".equals(request.getParameter(WTLPConversation.PLAN_TYPE))) {
          isValid = false;
          errorMessage = "Plan Type - " + MessageLookup.getMessageByNumber(Messages.SSM_COMPLETE_REQUIRED_SAVE_SUBMIT);
          setErrorMessage(errorMessage);

        } else if (request.getParameter(WTLPConversation.TXT_COORD_NAME) == null
                   || "".equals(request.getParameter(WTLPConversation.TXT_COORD_NAME))
                   || coordName == 0) {
          isValid = false;
          errorMessage = "YDP Coordinator - " + MessageLookup.getMessageByNumber(Messages.SSM_COMPLETE_REQUIRED_SAVE_SUBMIT);
          setErrorMessage(errorMessage);
        } else if (request.getParameter(WTLPConversation.TXT_WTLP_DATE) == null
                   || "".equals(request.getParameter(WTLPConversation.TXT_WTLP_DATE))) {
          isValid = false;
          setErrorMessage(WTLPConversation.TXT_WTLP_DATE, Messages.SSM_COMPLETE_REQUIRED_SAVE_SUBMIT);
        } else if (request.getParameter(WTLPConversation.TXT_WTLP_DURATION_FROM) == null
                   || "".equals(request.getParameter(WTLPConversation.TXT_WTLP_DURATION_FROM))) {
          isValid = false;
          setErrorMessage(WTLPConversation.TXT_WTLP_DURATION_FROM, Messages.SSM_COMPLETE_REQUIRED_SAVE_SUBMIT);
        } else if (request.getParameter(WTLPConversation.TXT_WTLP_DURATION_TO) == null
                   || "".equals(request.getParameter(WTLPConversation.TXT_WTLP_DURATION_TO))) {
          isValid = false;
          setErrorMessage(WTLPConversation.TXT_WTLP_DURATION_TO, Messages.SSM_COMPLETE_REQUIRED_SAVE_SUBMIT);        
        } else if (request.getParameter(WTLPConversation.TXT_STRENGTHS) == null
                   || "".equals(request.getParameter(WTLPConversation.TXT_STRENGTHS))) {
          isValid = false;
          errorMessage = "Strengths - " + MessageLookup.getMessageByNumber(Messages.SSM_COMPLETE_REQUIRED_SAVE_SUBMIT);
          setErrorMessage(errorMessage);
        } else if (request.getParameter(WTLPConversation.IND_AUTH_PLACE) == null
                        || "".equals(request.getParameter(WTLPConversation.IND_AUTH_PLACE))) {
          isValid = false;
          errorMessage = "Authority For Placement - " + MessageLookup.getMessageByNumber(Messages.SSM_COMPLETE_REQUIRED_SAVE_SUBMIT);
          setErrorMessage(errorMessage);
        } else if (request.getParameter(WTLPConversation.TXT_NEEDS) == null
                   || "".equals(request.getParameter(WTLPConversation.TXT_NEEDS))) {
          isValid = false;
          setErrorMessage(WTLPConversation.TXT_NEEDS, Messages.SSM_COMPLETE_REQUIRED_SAVE_SUBMIT);
        } else if (goalsStringArray.length == 0) {
          isValid = false;
          errorMessage = "Types of Goals - " + MessageLookup.getMessageByNumber(Messages.SSM_COMPLETE_REQUIRED_SAVE_SUBMIT);
          setErrorMessage(errorMessage);
        }

      } // end if (super.isButtonPressed(PPTConversation.SAVE_SUBMIT_ON_WTLP))
    } catch (Exception e) {
      throw new RuntimeWrappedException(e);
    }

    performanceTrace.exitScope();
    return isValid;
  }
}
