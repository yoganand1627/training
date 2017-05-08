package gov.georgia.dhr.dfcs.sacwis.web.admin;

// -- architecture classes --

import java.text.ParseException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.Date;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

/**
 * StaffSecurityMnt.jsp Custom validation class This method checks all custom validation for the Staff Security
 * Maintenance page
 *
 * @author Eric Dickman
 * @version 1.0 Change History: Date      User         Description --------  -----------
 *          ---------------------------------------------- 10/13/03  dickmaec     SIR 19857 -- ContextHelper.get...
 *          replaces getInputValue(); 06/16/05  berkime      SIR 23596 - made it so that if the user checked the none
 *          checkbox then the user could not check any other boxes when saved
 */

public class StaffSecurityMntCustomValidation extends FormValidation {
  /**
   * This method performs custom validation on the data submitted on the Staff Sec Mnt page
   *
   * @return <code>true</code> if the form data is valid; <code>false</code> otherwise.
   */

  protected boolean validateForm() {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG,
                                                             ".validationForm()");
    performanceTrace.enterScope();

    HttpServletRequest request = this.getRequest();

    //Ensures that an user slects a radio button when trying to delete a Designee
    boolean results = true;
    //variables used on this page
    Date maxDate = new Date();
    maxDate.addMonths(3);
    Date expDate = new Date();
    String expDateFieldName = "";
    String expirationDate = "";
    Date todayDate = new Date();
    //SIR 18780
    String expDateDisable = ContextHelper.getStringSafe(request, "hdnExpDateDisable");

    if (this.isButtonPressed("btnSave")) {
      int nbrDate = 0;
      String nbrExpDate = ContextHelper.getStringSafe(request, "hdnNbrExpDate");
      if (nbrExpDate != null && !"".equals(nbrExpDate)) {
        nbrDate = Integer.parseInt(nbrExpDate);
      }

      //Ensures that the user does not enter a date greater than 3 months for the
      //expriation date.
      try {
        for (int i = 0; i < nbrDate; i++) {
          expDateFieldName = "txtExpiration" + Integer.toString(i);
          expirationDate = ContextHelper.getStringSafe(request, expDateFieldName);

          //SIR 17857 -- Changed to DateHelper.toJavaDateFromInput, to allow the user to enter in the
          //Date in both of the following formats:  05/01/2003 or 05012003.
          //expDate = DateUtility.validateAsDate( expirationDate );
          expDate.setTime(DateHelper.toJavaDateFromInput(expirationDate));

          if (expDate.isDayAfter(maxDate)) {
            setErrorMessage(expDateFieldName, Messages.SSM_DATE_AFTER_SAME_CURR);
            results = false;
          }

          //SIR 18780 -- Added a new message SSM_DATE_BEFORE_CURR_DATE and will be thrown if the date is before
          //todays date.
          if ("false".equals(expDateDisable)) {
            if (expDate.isDayBefore(todayDate)) {
              setErrorMessage(expDateFieldName, Messages.SSM_DATE_BEFORE_CURR_DATE);
              results = false;
            }
          }
        }
      }

      catch (ParseException e) {
        GrndsTrace.msg(TRACE_TAG, 7, "" + e.getMessage());
      }

      Map map = this.getInputMap();
      if (map == null) {
        results = false;
        GrndsTrace.msg(TRACE_TAG, 7, "");
      }
    }

    //Checks the Temp Designee Section to ensure that the date is not greater then three months.
    else if (this.isButtonPressed("btnSaveTemp")) {
      Date tempryDate = new Date();
      try {
        String tempDate = ContextHelper.getStringSafe(request, "tempDate");
        if (tempDate != null && !"".equals(tempDate)) {
          //Date tempryDate = DateUtility.validateAsDate( tempDate );
          //SIR 17857 -- Changed to DateHelper.toJavaDateFromInput, to allow the user to enter in the
          //Date in both of the following formats:  05/01/2003 or 05012003.
          tempryDate.setTime(DateHelper.toJavaDateFromInput(tempDate));
          if (tempryDate.isDayAfter(maxDate) || tempryDate.isDayBefore(todayDate)) {
            setErrorMessage("tempDate", Messages.SSM_DATE_AFTER_SAME_CURR);
            results = false;
          }
        }
      }
      catch (ParseException e) {
        GrndsTrace.msg(TRACE_TAG, 7, "" + e.getMessage());
      }
      Map map = this.getInputMap();
      if (map == null) {
        results = false;
        GrndsTrace.msg(TRACE_TAG, 7, "");
      }
    }
    //SIR 23596
    //this code is to make sure if they check the none checkbox then that is
    //the only box that they can check
    String[] cbValues = CheckboxHelper.getCheckedValues(request,
                                                        "cbSecurityProfiles");
    String[] cbITValues = CheckboxHelper.getCheckedValues(request,
                                                          "cbITSecurityProfiles");
    boolean checkedNone = false;
    for (int i = 0; i < cbValues.length; i++) {
      if ("NONE".equals(cbValues[i])) {
        checkedNone = true;
        break;
      }
    }
    if (checkedNone) {
      for (int i = 0; i < cbValues.length; i++) {
        if (!"NONE".equals(cbValues[i])) {
          setErrorMessage(Messages.MSG_SEC_ONLY_NONE_CHECKED);
          results = false;
          break;
        }
      }
      for (int i = 0; i < cbITValues.length; i++) {
        if (!results) {
          break;
        }
        if (!"NONE".equals(cbITValues[i])) {
          results = false;
          setErrorMessage(Messages.MSG_SEC_ONLY_NONE_CHECKED);
          break;
        }
      }
    }

    performanceTrace.getTotalTime();
    performanceTrace.exitScope(results);
    return results;
  }

  /**
   * ***************************************************************************** *  Declare any static constants.
   * ******************************************************************************
   */
// static constants
  public static final String TRACE_TAG = "StaffSecurityMntCustomValidation";
}