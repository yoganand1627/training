package gov.georgia.dhr.dfcs.sacwis.web.contacts;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>Title: Contact Search List Custom Validation</p> <p>Description: This page is used to make sure that a user
 * doesn't select more than 5 Principals/Collaterals, the From Date has to be prior to the To Date, and the From date
 * can't be a date in the future</p> <p>Copyright: Copyright (c) 2003</p> <p>Company: TDPRS</p>
 * <pre>
 * Change History:
 * Date      User              Description
 * --------  ----------------  ----------------------------------------------
 * 01/28/03  Todd Reser        Initial Revision.
 * 01/31/03  Todd Reser        Optimized Imports, added Trace to All Methods.
 * 02/07/03  Todd Reser        Alphabetized StageArray and removed duplicates.
 * 02/10/03  Todd Reser        Removed Debug Comments.
 * 02/13/03  Todd Reser        Updated JavaDoc comments.
 * 04/28/03  Todd Reser        Added Javadoc's, changed to equals() for strings.
 * 07/24/05  werlem            SIR 23728 - MPS Phase II Enhancement to add Contact List and Detail to MPS.
 * 02/22/10  wjcochran         MR-062 - Show an error message if a user attempts to
 *                             add a Contact more than 14 days after the start of the
 *                             ONG & FCF stages and has not created Contact Standards.
 * </pre>
 *
 * @author Todd Reser
 * @version 1.8
 */
@SuppressWarnings("serial")
public class ContactSearchListCustomValidation extends FormValidation {
  
  //-- these strings are the unkeyed (not stage-specific) contact types
  //-- that are allowed to be copied
  private static final Set<String> COPY_ALLOWED_CONTACTS = new HashSet<String>(Arrays.asList(new String[]{"REG",
                                                                                                          "TRN",
                                                                                                          "PVC"}));
  // These stages require completed Contact Standards before a new
  // Contact can be added
  private static final Set<String> PCS_REQ_STAGES = new HashSet<String>(Arrays.asList(new String[]{"FSU", "ONG"}));
  
  /**
   * This page is used to make sure that a user doesn't select more than 5 Principals/Collaterals, the From Date has to
   * be prior to the To Date, and the From date can't be a date in the future.
   *
   * @return result - Returns false if the data fails validation.  Returns true if the data passes validation.
   */
  protected boolean validateForm() {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validateForm()");
    performanceTrace.enterScope();

    HttpServletRequest request = this.getRequest();

    if (isButtonPressed("btnSearch")) {
      // If more than 5 Principals/Collaterals were checked, yell at 'em about it!
      String[] collateralsPrincipalsArray = CheckboxHelper.getCheckedValues(request, "cbxUlIdPerson");
      if (collateralsPrincipalsArray.length > 5) {
        String message = MessageLookup.getMessageByNumber(Messages.MSG_CMN_MAX_SELECTED);
        message = MessageLookup.addMessageParameter(message, "5");
        setErrorMessage(message);
      }

      org.exolab.castor.types.Date fromDate =
              DateHelper.toCastorDateSafe(ContextHelper.getStringSafe(request, "dtScrSearchDateFrom"));

      org.exolab.castor.types.Date toDate =
              DateHelper.toCastorDateSafe(ContextHelper.getStringSafe(request, "dtScrSearchDateTo"));

      //If the From date is after the To date yell at 'em!
      if (fromDate != null && DateHelper.isAfter(fromDate, toDate)) {
        setErrorMessage("dtScrSearchDateFrom", Messages.MSG_SVC_CNTCT_END_DT);
      }

      // If Search is pressed and From wasn't filled in when to date was show that the from is conditionally required
      if (fromDate == null && toDate != null) {
        setErrorMessage("dtScrSearchDateFrom", Messages.SSM_COMPLETE_REQUIRED);
      }

      //If the From Date is in the future and not the "NULL date" yell at them about that too!
      if (fromDate != null && DateHelper.isAfterToday(fromDate)) {
        setErrorMessage("dtScrSearchDateFrom", Messages.MSG_SVC_NO_FUTURE_FROM_DATE);
      }
    }

    //If they didn't select a contact and clicked New using throw an error
    if (isButtonPressed("btnNewUsing")) {
      String ulRowSelected = ContextHelper.getStringSafe(request, "ulRowSelected");
      if ("".equals(ulRowSelected)) {
        setErrorMessage(Messages.MSG_NO_ROW_SELECTED_CONTINUE);
      } else { // Check to see if the contact type is allowed to be a "New Using"
        String contactType = ContextHelper.getStringSafe(request, "hdnContactType");

        if(!COPY_ALLOWED_CONTACTS.contains(contactType)) {
          setErrorMessage(Messages.MSG_CONTACT_STAGE_MISMATCH);
        }
      }
    }
    
    /* MR-062 - If a user attempts to add a Contact without a 
     * documented Contact Standard for ONG & FCF stages more
     * than 14 days after the stage open, then show an error
     * message to the user.
     */
    if (isButtonPressed("btnAdd") || isButtonPressed("btnNewUsing")) {
      String strIndCanAddContacts = ContextHelper.getStringSafe(request, "hdnCanAddContact");
      
      if (ArchitectureConstants.N.equals(strIndCanAddContacts)) {
        setErrorMessage(Messages.MSG_CONTACT_PCS_REQUIRED);
      }
    }

    performanceTrace.exitScope();
    return getErrorMessages().isEmpty();
  }

  public static final String TRACE_TAG = "ContactSearchListCustomValidation";
}
