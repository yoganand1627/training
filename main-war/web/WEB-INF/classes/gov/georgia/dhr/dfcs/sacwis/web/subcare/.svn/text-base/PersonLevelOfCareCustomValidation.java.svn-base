//Declare your class pacakge
package gov.georgia.dhr.dfcs.sacwis.web.subcare;

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

/**
 * This class is used to perform the custom validation on Level of Care when the user chooses to Save.
 *
 * @author Paula Blaha 2/20/2003
 *         <p/>
 *         Change History: Date      User         Description --------  -----------
 *         ---------------------------------------------- 10/14/03  dejuanr      SIR 19857 -- ContextHelper.get...
 *         replaces getInputValue(); 12/0203   CORLEYAN     LOC Enhancement - Ensure that when the user selects a level
 *         that the start date entered corresponds with the level selected. 02/15/05  CORLEYAN     SIR 23400 - If the
 *         page mode is new, ensure that the user only enters Review Types for ALOCs, and that Review Type is required
 *         for ALOCs 03/15/05  CORLEYAN     SIR 23472 - Removed edit to prevent post dating of BLOCS
 */
public class PersonLevelOfCareCustomValidation extends FormValidation {
  /**
   * <p>This method contains custom validation that is checked when the user tries to Save the Level of Care page.</p>
   *
   * @return result - Returns false if the data fails validation.  Returns true if the data passes validation.
   */
  protected boolean validateForm() {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validationForm()");
    performanceTrace.enterScope();

    HttpServletRequest request = super.getRequest();

    org.exolab.castor.types.Date endDate = ContextHelper.getCastorDateSafe(request, "txtEndDate");
    org.exolab.castor.types.Date startDate = ContextHelper.getCastorDateSafe(request, "txtStartDate");
    org.exolab.castor.types.Date changeDate = DateHelper.toCastorDateSafe("09/01/2003");

    boolean result = true;
    String type = ContextHelper.getStringSafe(request, "selSzCdPlocType");
    String level = ContextHelper.getStringSafe(request, "selSzCdPlocChild");
    // SIR 23400
    String revType = ContextHelper.getStringSafe(request, "selSzCdRevType");
    String pageMode = PageMode.getPageMode(request);

    // functional rec 9.07.01.03
    // If the type is "authorized", End date is required.
    if ("ALOC".equals(type) && endDate == null) {
      setErrorMessage("txtEndDate", Messages.SSM_COMPLETE_REQUIRED);
      result = false;
    }

    // Outcome Court Date cannot be > Date Filed
    // Start date cannot be > end date
    if (endDate != null && startDate != null && DateHelper.isBefore(endDate, startDate)) {
      setErrorMessage("txtStartDate", Messages.SSM_START_BEFORE_SAME_END);
      result = false;
    }

    // If type is "requested", the user must not enter an End Date
    if ("RLOC".equals(type) && endDate != null) {
      setErrorMessage("txtEndDate", Messages.MSG_LOC_REQUESTED);
      result = false;
    }

    // LOC Enhancement If the start date is before the change date make sure that the
    // level selected is not Basic, Moderate, Specialized, or Intense, otherwise make
    // sure it is not 1-6
    if (startDate != null && DateHelper.isBefore(startDate, changeDate)) {
      if ("210".equals(level) || "220".equals(level) || "230".equals(level) || "240".equals(level)) {
        setErrorMessage("txtStartDate", Messages.MSG_START_LEVEL_BMSI);
        result = false;
      }
    } else {
      if ("010".equals(level) ||
          "020".equals(level) ||
          "030".equals(level) ||
          "040".equals(level) ||
          "050".equals(level) ||
          "060".equals(level)) {
        setErrorMessage("txtStartDate", Messages.MSG_START_LEVEL);
        result = false;
      }

    }

    if (pageMode.equals(PageModeConstants.NEW)) {
      // If the type selected is not ALOC, a Type dropdown cannot be selected
      if (!"ALOC".equals(type) &&
          !"".equals(revType)) {
        setErrorMessage("selSzCdRevType", Messages.MSG_NO_REV_TYPE);
        result = false;
      }
      // If the type selected is ALOC, a Type dropdown required
      if ("ALOC".equals(type) &&
          "".equals(revType)) {
        setErrorMessage("selSzCdRevType", Messages.MSG_REV_TYPE_REQ);
        result = false;
      }

    }

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return result;

  }

  /**
   * ***************************************************************************** *  Declare any static constants.
   * ******************************************************************************
   */
  // static constants
  public static final String TRACE_TAG = "LevelOfCareCustomValidation";
}


