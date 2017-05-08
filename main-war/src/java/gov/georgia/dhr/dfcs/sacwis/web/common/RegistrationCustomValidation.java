package gov.georgia.dhr.dfcs.sacwis.web.common;


import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import javax.servlet.http.HttpServletRequest;

import org.apache.oro.text.perl.Perl5Util;

/**
 * This class is used to perform the custom validation on VendorStaffDetailPage 
 * 
 * @author ssubram 10/26/2009 
 * Change History:   
 * Date       User    Description 
 * ----       ----    ---------------------------------------------- 
 * 10/26/09   ssubram Initial Validation for Portal
 */
public class RegistrationCustomValidation extends FormValidation {
  public static final String TRACE_TAG = "RegistrationCustomValidation";
  
  private static final String PWD_PATTERN = "/^.*(?=.{8,})(?=.*[a-z])(?=.*[A-Z])(?=.*[" + "\\" + "d" + "\\" + "W]).*$/";
  
  
  /**
   * <p>
   * This method contains custom validation for Registration in Portal application
   * </p>
   * 
   * @return result - Returns false if the data fails validation. Returns true if the data passes validation.
   */

  protected boolean validateForm() {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "RegistrationCustomValidation.validationForm()");
    performanceTrace.enterScope();
    boolean result = true;
    HttpServletRequest request = super.getRequest();
    // Checking Password Standards and Match
    String newPassword = ContextHelper.getStringSafe(request, "txtNewPassword").trim();
    String newConfirmPassword = ContextHelper.getStringSafe(request, "txtNewPasswordConfirm").trim();
    Perl5Util m_perl = new Perl5Util();
    String pattern = PWD_PATTERN;
    boolean inverse = pattern.startsWith("!");
    if ((newPassword.length()>0)&&!(newConfirmPassword.length()>0)){
      setErrorMessage(Messages.MSG_PORTAL_PWD_REENTER);
      result = false;
    }
    if ((newPassword.length()>0)&&(newConfirmPassword.length()>0)){
      if (inverse) {
        pattern = pattern.substring(1);
      }
      result = m_perl.match(pattern, newPassword);
      if (inverse) {
        result = !result;
      }
      if (!result) {
        //The user attempts to submit a registration or update an existing password and the new password 
        //fails one or more of the conditions described in the message.
        setErrorMessage(Messages.MSG_PORTAL_PWD_STANDARDS);
      } else {
        if ((newPassword.length() < 8) || (newPassword.length() > 20)
            || (newPassword.substring(0, 8).equalsIgnoreCase("Password"))) {
          //The user attempts to submit a registration or update an existing password and the new password 
          //fails one or more of the conditions described in the message.
          setErrorMessage(Messages.MSG_PORTAL_PWD_STANDARDS);
          result = false;
        } else if (!(newPassword.equals(newConfirmPassword))) {
          //The user attempts to submit a registration with the new password not equal to the 
          //information entered in the re-enter new password field.
          setErrorMessage(Messages.MSG_PORTAL_PWD_MATCH);
          result = false;
        }
      }
    }
    String selSecQues1 = ContextHelper.getStringSafe(request,"selSecQues1");
    String selSecQues2 = ContextHelper.getStringSafe(request,"selSecQues2");
    String selSecQues3 = ContextHelper.getStringSafe(request,"selSecQues3");    
    if (selSecQues1.equals(selSecQues2) || selSecQues1.equals(selSecQues3) || selSecQues3.equals(selSecQues2)){
      setErrorMessage("selSecQues1", Messages.MSG_PORTAL_DUP_SEC_QUESTION);
      result = false;
    }
    //A user attempts to submit a registration as a Placement Provider Administrator without selecting 
    //either an existing vendor from the dropdown or entering a value in the Other field in the 
    //Access Request section.
    if (ContextHelper.getStringSafe(request,"selReqType").equals(CodesTables.CUSRTYP_PAD) &&
               ContextHelper.getStringSafe(request,"selVendor").trim().length() <=0 && 
               ContextHelper.getStringSafe(request,"txtOther").trim().length() <= 0){
      setErrorMessage("selVendor", Messages.MSG_PORTAL_PP_ADM_VEND_SELECT);
      result = false;  
    }
    //A user attempts to submit a registration as a Placement Provider Administrator having selecting 
    //both an existing vendor from the dropdown and entering a value in the Other field in the
    //Access Request section.
    if (ContextHelper.getStringSafe(request,"selReqType").equals(CodesTables.CUSRTYP_PAD) &&
                    ContextHelper.getStringSafe(request,"selVendor").trim().length() > 0 && 
                    ContextHelper.getStringSafe(request,"txtOther").trim().length() > 0){
      setErrorMessage("selVendor", Messages.MSG_PORTAL_PP_ADM_VEND_SELECT_ONE);
      result = false; 
    }
    //A user attempts to submit a registration as a Placement Provider User without selecting 
    //an existing vendor from the dropdown in the Access Request section.
    if (ContextHelper.getStringSafe(request,"selReqType").equals(CodesTables.CUSRTYP_PUS) &&
                    ContextHelper.getStringSafe(request,"selVendor").trim().length() <= 0){
      setErrorMessage("selVendor", Messages.MSG_PORTAL_PP_USR_VEND_SELECT);
      result = false;
    }
    return result;
  }
}

