package gov.georgia.dhr.dfcs.sacwis.web.financials;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import javax.servlet.http.HttpServletRequest;

import org.grnds.structural.web.GrndsExchangeContext;

public class ContractServiceDetailAddCustomValidation extends FormValidation {
  
  private static final long serialVersionUID = 1L;

  protected boolean validateForm(){
    boolean isValid = true;
    GrndsExchangeContext context = super.getGrndsExchangeContext();
    HttpServletRequest request = context.getRequest();
    
    // get parameters
    boolean isValidateProgramCode = ArchitectureConstants.Y.equals(ContextHelper.getStringSafe(request, "validateProgCode")) ? true : false;
    boolean isValidateServiceSelection = ArchitectureConstants.Y.equals(ContextHelper.getStringSafe(request, "validateServiceSelection")) ? true : false;
    String [] checkedValues = CheckboxHelper.getCheckedValues(request.getParameterMap(), "cbxProgCdServices");
    String programCode = ContextHelper.getStringSafe(request, "szProgCode");
    
    // validate that program code has been chosen
    if(isValidateProgramCode){
      if("".equals(programCode)){
        setErrorMessage("Program Code – This field is required.");
        isValid = false;
      }
    }else if(isValidateServiceSelection){
      // vaidate that services have been chosen
      if(checkedValues == null || checkedValues.length <= 0){
        setErrorMessage(Messages.MSG_SVC_CODE_NONE_SELECTED);
        isValid = false;
      }else{
        getState().setAttribute("checkedValues", checkedValues, request);
      }
    }
    
    return isValid;
  }
}
