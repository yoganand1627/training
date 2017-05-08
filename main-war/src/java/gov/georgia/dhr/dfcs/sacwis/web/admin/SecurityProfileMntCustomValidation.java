package gov.georgia.dhr.dfcs.sacwis.web.admin;

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

/**
 * <p>Title: SecurityProfileMntCustomValidation </p> <p>Description: Custom Validation for SecurityProfileMnt page</p>
 * <p>Copyright: Copyright (c) 2002</p> <p>Company: </p>
 *
 * @author Habib Hadjimani
 * @version 1.0 * Date      User         Description --------  -----------  ----------------------------------------------
 *          10/13/03  dickmaec     SIR 19857 -- ContextHelper.get... replaces getInputValue();
 */

public class SecurityProfileMntCustomValidation extends FormValidation {

  protected boolean validateForm() {
    HttpServletRequest request = super.getRequest();

    boolean result = true;

    if (this.isButtonPressed("btnAdd")) {
      result = true;
    } else if (this.isButtonPressed("btnDelete") || this.isButtonPressed("btnNewUsing")) {
      String radioButtonValue = ContextHelper.getStringSafe(request, "rbSecurityProfileRadioIndex");
      if ((radioButtonValue == null) || "".equals(radioButtonValue)) {
        setErrorMessage(Messages.MSG_SELECT_ROW_ACTION);
        result = false;
      }
    }

    return result;
  }
}
