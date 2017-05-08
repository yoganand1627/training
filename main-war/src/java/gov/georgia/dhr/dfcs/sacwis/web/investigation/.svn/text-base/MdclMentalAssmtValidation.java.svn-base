package gov.georgia.dhr.dfcs.sacwis.web.investigation;

// -- java classes --

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.web.admin.AdminAddressPhoneBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

/**
 * This class is used to validate parameters entered on Medical Mental Assessment page.
 * 
 * @author Michael Ochu, Nov., 2002 <p/> Change History: Date User Description -------- -----------
 *         ---------------------------------------------- 10/15/03 dickmaec SIR 19857 -- ContextHelper.get... replaces
 *         getInputValue(); <p/> 10/15/03 dickmaec As part of SIR 19857, all messages where shorted from
 *         MessageLookup.getMessageByNumber( Messages.SSM_FAD_MIN_LESS_MAX) to Messages.SSM_FAD_MIN_LESS_MAX. 03/25/04
 *         CORLEYAN SIR 22627 either name or other can be entered but not both.
 */
@SuppressWarnings("serial")
public class MdclMentalAssmtValidation extends FormValidation {
  /**
   * This method performs custom validation on the data submitted on the Medical Mental Assessment Page
   * 
   * @return <code>true</code> if the form data is valid; <code>false</code> otherwise.
   */
  protected boolean validateForm() {
    // Instantiate a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "validateForm()");
    HttpServletRequest request = super.getRequest();

    AdminAddressPhoneBean aapBean = (AdminAddressPhoneBean) AdminAddressPhoneBean.getFromRequest(request);
    // start the method trace
    performanceTrace.enterScope();

    boolean isValid = true;
    String other = ContextHelper.getStringSafe(request, "txtOther");
    String reason = ContextHelper.getStringSafe(request, "selReason");
    String name = ContextHelper.getStringSafe(request, "selSzNmProfAssmtName");
    String comments = ContextHelper.getStringSafe(request, "txtcomments");
    org.exolab.castor.types.Date txtDate = ContextHelper.getCastorDateSafe(request, "txtDate");
    String address1 = "";

    if (txtDate != null && DateHelper.isAfterToday(txtDate)) {
      setErrorMessage("txtDate", Messages.MSG_SVC_NO_FUTURE_DATE);
      isValid = false;
    }

    // Name and or other fields must be entered in other to save
    address1 = aapBean.getAddress1();
    if ("".equals(other) && "".equals(name) && "".equals(address1)) {
      setErrorMessage("selSzNmProfAssmtName", Messages.MSG_INV_NAME_OTHER_REQ);
      isValid = false;
    }

    // Make sure Reason "Other" is not entered without Findings
    if (reason.equalsIgnoreCase(MdclMentalAssmtConversation.MED_REASON_OTHER) && "".equals(comments)) {
      setErrorMessage("txtcomments", Messages.MSG_OTHER_COMMENTS_MMA);
      isValid = false;
    }
    // Make sure Other is entered, if Address/Phone Details Other is populated.
    if (!"".equals(address1) && "".equals(other)) {
      setErrorMessage("txtOther", Messages.MSG_OTHER_NOT_ENTERED);
      isValid = false;

    }
    // Name or Other field must be populated, not both.
    if (!"".equals(other) && !"".equals(name)) {
      setErrorMessage(Messages.MSG_NM_OR_OTH);
      isValid = false;
    }
       

    performanceTrace.getTotalTime();
    performanceTrace.exitScope("result is" + isValid);
    return isValid;
  }

  // static constants
  public static final String TRACE_TAG = "MdclMentalAssmtValidation";

}
