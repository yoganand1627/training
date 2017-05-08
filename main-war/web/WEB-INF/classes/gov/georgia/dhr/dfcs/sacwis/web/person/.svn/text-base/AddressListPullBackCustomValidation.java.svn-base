package gov.georgia.dhr.dfcs.sacwis.web.person;

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

/**
 * <p>Title: Address List Pull Back Custom Validation </p> <p>Copyright: Copyright (c) 2002</p> <p>Company: Accenture
 * </p>
 * <p/>
 * Change History: Date      User         Description --------  -----------  ----------------------------------------------
 * 10/14/03  CORLEYAN     SIR 19857 -- ContextHelper.get... replaces getInputValue(), removed message lookup
 */

public class AddressListPullBackCustomValidation extends FormValidation {

  public static final String TRACE_TAG = "AddressListPullBackCustomValidation";

  protected boolean validateForm() {
    HttpServletRequest request = this.getRequest();
    boolean result = true;

    if ("".equals(ContextHelper.getStringSafe(request, "rbAddressRadioIndex"))) {
      setErrorMessage(Messages.MSG_SELECT_ROW_ACTION);
      result = false;
    }

    return result;

  }
}
