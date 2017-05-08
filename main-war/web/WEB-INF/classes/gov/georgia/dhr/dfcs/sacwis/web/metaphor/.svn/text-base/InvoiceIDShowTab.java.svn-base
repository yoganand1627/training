package gov.georgia.dhr.dfcs.sacwis.web.metaphor;

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.web.core.metaphor.ShowTab;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;

/*
Filter class used for INVOICE_INVOICE tab
*/

public class InvoiceIDShowTab implements ShowTab {
  public boolean showTab(String tabId, HttpServletRequest request) {
    return (GlobalData.getUlIdInvoice(request) != 0);
  }
}


