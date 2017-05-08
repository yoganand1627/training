package gov.georgia.dhr.dfcs.sacwis.web.financials;

import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import javax.servlet.http.HttpServletRequest;

@SuppressWarnings("serial")
public class RestrictedFundsCustomValidation extends FormValidation {
  @Override
  protected boolean validateForm() {
    boolean valid = true;
    
    HttpServletRequest request = super.getRequest();
    double amount = ContextHelper.getMoneyAsDoubleSafe(request, RestrictedFundsConversation.RESERVED_AMOUNT_NAME);
    String reason = ContextHelper.getStringSafe(request, RestrictedFundsConversation.RESERVED_REASON_NAME);
    
    if(amount < 0){
      valid = false;
      setErrorMessage(RestrictedFundsConversation.RESERVED_AMOUNT_NAME, Messages.MSG_INV_RESERVED_AMOUNT);
      //setErrorMessage(RestrictedFundsConversation.RESERVED_AMOUNT_NAME, "Please enter a valid Reserved Amount");
    }
    if(amount != 0 && "".equals(reason)){
      valid = false;
      setErrorMessage(RestrictedFundsConversation.RESERVED_REASON_NAME, Messages.MSG_REQ_RESERVED_REASON);
      //setErrorMessage(RestrictedFundsConversation.RESERVED_REASON_NAME, "A Reserved Reason is required when reserving an amount other than $0");
    }
    
    return valid;
  }
}
