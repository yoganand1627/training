package gov.georgia.dhr.dfcs.sacwis.web.common;

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import org.apache.oro.text.perl.Perl5Util;

/**
 * This class is used to perform the custom validation on the Change Password page 
 * when the user attempts to login to Portal with a temp password and must reset the password.
 * 
 * @author pcoogan 11/05/2009 
 * Change History: 
 * Date     User     Description 
 * ----     ----     ---------------------------------------------- 
 * 11/05/09 pcoogan  Created for SHINES portal.
 */

public class ChangePasswordCustomValidation extends FormValidation {
  public static final String TRACE_TAG = "ChangePasswordCustomValidation";

  // We define the Perl string here instead of within constraints to allow us
  // to display the error message on the page without displaying the password value
  // within the error message.
  private static final String PWD_PATTERN = "/^.*(?=.{8,})(?=.*[a-z])(?=.*[A-Z])(?=.*[" + "\\" + "d" + "\\" + "W]).*$/";

  /**
   * <p>
   * This method contains custom validation that is used to check that a new password entered on the Portal change
   * password page meets password constraints, without using normal constraints function to prevent displaying the new
   * password to the page.
   * </p>
   * 
   * @return result - Returns false if the data fails validation. Returns true if the data passes validation.
   */
  protected boolean validateForm() {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG,
                                                             "ChangePasswordCustomValidation.validationForm()");
    performanceTrace.enterScope();
    BaseSessionStateManager state = super.getState();
    HttpServletRequest request = super.getRequest();
    boolean result = true;

    if (isButtonPressed("Logon")) {

      String newPassword = ContextHelper.getStringSafe(request, UserProfileHelper.NEW_PASSWORD_KEY).trim();
      String newConfirmPassword = ContextHelper.getStringSafe(request, UserProfileHelper.NEW_PASSWORD_CONFIRM_KEY)
                                               .trim();

      // The following code duplicates the pattern matching code within
      // ValidationPatternMatcher.java to verify the portal password meets standards
      // re upper, lower, and numeric items

      Perl5Util m_perl = new Perl5Util();
      String pattern = PWD_PATTERN;
      boolean inverse = pattern.startsWith("!");

      if (inverse) {
        pattern = pattern.substring(1);
      }

      result = m_perl.match(pattern, newPassword);

      if (inverse) {
        result = !result;
      }
      if (!result) {
        setErrorMessage(Messages.MSG_PORTAL_PWD_STANDARDS);
      } else {

        // Verify other password standards for length and not = to password
        if ((newPassword.length() < 8) || (newPassword.length() > 20)
            || (newPassword.substring(0, 8).equalsIgnoreCase("Password"))) {

          setErrorMessage(Messages.MSG_PORTAL_PWD_STANDARDS);
          result = false;

        } else if (!(newPassword.equals(newConfirmPassword))) {

          setErrorMessage(Messages.MSG_PORTAL_PWD_MATCH);
          result = false;

        }

      }
    }
    return result;
  }
}
