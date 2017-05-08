package gov.georgia.dhr.dfcs.sacwis.web.metaphor;

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.web.core.metaphor.ShowTab;

/*
Filter Class used for:
          FINANCIAL_ACCOUNT_DETAIL_FINANCIALACCT,
          FINANCIAL_ACCOUNT_REGISTER_FINANCIALACCT tabs
*/

public class FinancialAccountShowTab implements ShowTab {
  public boolean showTab(String tabId, HttpServletRequest request) {
    if ("financials/FinancialAcct".equalsIgnoreCase(String.valueOf(request.getAttribute(
            ArchitectureConstants.CONVERSATION)))
        &&
        ("displayFinancialAcctDetail".equalsIgnoreCase(String.valueOf(request.getAttribute(
                ArchitectureConstants.COMMAND)))
         || "saveFinancialAcctDetail".equalsIgnoreCase(String.valueOf(request.getAttribute(
                ArchitectureConstants.COMMAND)))
//            || String.valueOf( request.getAttribute( ArchitectureConstants.COMMAND ) ).equalsIgnoreCase( "addFinancialAcct" )
|| "addFinAcctRegisterDetail".equalsIgnoreCase(String.valueOf(request.getAttribute(ArchitectureConstants.COMMAND)))
|| "newUsingFinAcctRegister".equalsIgnoreCase(String.valueOf(request.getAttribute(ArchitectureConstants.COMMAND)))
|| "validatePersonId".equalsIgnoreCase(String.valueOf(request.getAttribute(ArchitectureConstants.COMMAND)))
|| "displayFinancialAcctRegister".equalsIgnoreCase(String.valueOf(request.getAttribute(ArchitectureConstants.COMMAND)))
|| "displayFinAcctRegisterDetail".equalsIgnoreCase(String.valueOf(request.getAttribute(ArchitectureConstants.COMMAND)))
|| "saveFinAcctRegisterDetail".equalsIgnoreCase(String.valueOf(request.getAttribute(ArchitectureConstants.COMMAND))))
            ) {
      return true;
    }

    return false;
  }

}