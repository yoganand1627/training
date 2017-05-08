package gov.georgia.dhr.dfcs.sacwis.web.person;

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC26SO;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import org.exolab.castor.types.Date;

/**
 * ***************************************************************************** This class is used to perform the
 * custom validation on records check detail jsp
 *
 * @author Katy Laura 01/14/2003
 *         <p/>
 *         Change History: Date      User         Description --------  -----------
 *         ---------------------------------------------- 10/14/03  CORLEYAN     SIR 19857 -- ContextHelper.get...
 *         replaces getInputValue(), removed message lookup
 *         <p/>
 *         03/04/04  RIOSJA       SIR 22576 - Excluded DPS Criminal History record from the SSM_DATE_BEFORE_SAME_CURR
 *         Date of Request validation because it is already handled by a previous check.
 *         <p/>
 *         03/29/04  thompswa     SIR 22578 - Invalidate DPS Criminal History Check when DOB is approximate. 08/18/04
 *         CORLEYAN     SIR 22935 - Only allow DPS criminal history check if the person is a principal 09/28/04
 *         CORLEYAN     SIR 23184 - If the person is a COL, display the message preventing a DPS criminal history check,
 *         otherwise do not display the message.  This way Staff persons via Staff search can have a DPS criminal
 *         history check performed.
 *         <p/>
 *         
 *         6/6/2011               4.3 Capta Enhancement         Validating comments field when History is Yes and 
 *                                                              checking that all required fields are populated
 *         ******************************************************************************
 */
public class RecordsCheckDetailCustomValidation extends FormValidation {

  /**
   * *************************************************************************** constructor for the
   * RecordsCheckDetailCustomValidation class. ****************************************************************************
   */
  public RecordsCheckDetailCustomValidation() {
    super();
  }

  /**
   * *************************************************************************** list of messages to check on the detail
   * page *MSG_CONFIRM_ON_EXIT        -      a user tries to exit this window without saving *SSM_CFC_COMPLETED_DATE
   * -      The date requested and completed are in the wrong order *SSM_COMPLETE_REQUIRED      -      Search drop down
   * box has no selection but is required *SSM_DATE_BEFORE_SAME_CURR  -      the user tries to enter dt requested or
   * completed after *MSG_NO_DPS_MIN_INFO        -      missing key elements required for dps search, name, exact dob,
   * gender, race or ethnicity *MSG_SUB_NO_MINOR_DPS_CHECK -      the person's age is not > 13  criminal history
   * *MSG_CMN_PENDING_DPS        -      The user request a new dps check, but there is an an incomplete request
   * outstanding *MSG_DATE_BLANK_REQ         -      A blandk date completed is required for new row, of dps type
   *                 **************************************************************************** This method contains
   * custom validation for records check detail page
   *
   * @return result - returns false if the data fails validation. - returns true if the data passes validation.
   *         ****************************************************************************
   */

  /******************************************************************************
   *  This method contains custom validation for records check detail page
   *   @return result - returns false if the data fails validation.
   *                  - returns true if the data passes validation.
   ******************************************************************************/
  protected boolean validateForm() {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validationForm()");
    performanceTrace.enterScope();

    boolean result = true;
    // if the button pressed is btnSave, validate; otherwise, no validation is required
    if (isButtonPressed("btnSave")) {
      boolean resultSave = validateSave();
      result = resultSave;
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return result;
  }

  /**
   * *************************************************************************** This method contains custom validation
   * for the save button on the records check detail page
   *
   * @return result - returns false if the data fails validation. - returns true if the data passes validation.
   *         ****************************************************************************
   */
  protected boolean validateSave() {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validationForm()");
    performanceTrace.enterScope();

    BaseSessionStateManager state = super.getState();
    HttpServletRequest request = this.getRequest();

    boolean resultSave = true;

    CCFC26SO ccfc26so = (CCFC26SO) state.getAttribute("CCFC26SO", request);
    String txtCIndRecCheckDpsIncomplete = ccfc26so.getCIndRecCheckDpsIncomplete();
    String hdnCdCheckType = ContextHelper.getStringSafe(request, "hdnCdCheckType");
    String hdnComments = ContextHelper.getStringSafe(request, "hdnComments");
    String szCdStagePersType = PersonHelper.getSzCdStagePersType(request);
    String history = ContextHelper.getStringSafe(request, "rbHistory");

    // if the type of search is null, block the save
    if (hdnCdCheckType.equals(StringHelper.EMPTY_STRING)) {
      hdnCdCheckType = ContextHelper.getStringSafe(request, "selCdSearchType");
    }

    // if the type of search is null, block the save
    if (hdnComments.equals(StringHelper.EMPTY_STRING)) {
      hdnComments = ContextHelper.getStringSafe(request, "selComments");
    }

    // get the request date using super.getInputValue. if null get the value
    // set on the page
    Date hdnDtRequest = ContextHelper.getCastorDateSafe(request, "hdnDtRequest");
    if (hdnDtRequest == null) {
      hdnDtRequest = ContextHelper.getCastorDateSafe(request, "selDtRequest");
    }

    // get the date completed, if null set it = to the value selected on the page
    Date hdnDtCompleted = ContextHelper.getCastorDateSafe(request, "hdnDtCompleted");
    if (hdnDtCompleted == null) {
      hdnDtCompleted = DateHelper.toCastorDateSafe(super.getInputValue("selDtCompleted"));
    }

    String txtSubjectName = ccfc26so.getSzNmPersonFull();
    String txtGender = ccfc26so.getCCdPersonSex();
    String txtRaceEthnicity = ccfc26so.getSzCdPersonEthnicGroup();
    Date dtDob = ccfc26so.getDtDtPersonBirth();
    String bDobExists = null;
    String bGenderUnknown = null;
    /*SIR 22578 Age Approx checkbox & Gender dropdown on Person Detail page*/
    String bDobIsApproximate = ccfc26so.getBIndPersonDobApprox();
    if (dtDob == null) {
      bDobExists = "false";
      /*SIR 22578 If DOB doesn't exist, presume DOB is approximate*/
      bDobIsApproximate = "Y";
    } else {
      bDobExists = "true";
    }
    if (txtGender == null ||
        "U".equals(txtGender)) {
      /*SIR 22578 If txtGender doesn't exist, presume Gender is Unknown*/
      bGenderUnknown = "true";
    } else {
      bGenderUnknown = "false";
    }

    String pageMode = (String) state.getAttribute("pageMode", request);

    //---------------------
    //---test for errors---
    //---------------------
    // test for errors in new dps rows

    // if the type of search selected for a new row = '10'/dps, is there an
    // outstanding incomplete request? the pagemode was set to NEW in the add_xa.
    // Use page mode to verify this is an add; modified 03/03/03
    if (hdnCdCheckType.equals(STRING_VALUE_OF_10) &&
        txtCIndRecCheckDpsIncomplete != null &&
        "Y".equals(txtCIndRecCheckDpsIncomplete) &&
        pageMode.equals(PageModeConstants.NEW)) {
      setErrorMessage(Messages.MSG_CMN_PENDING_DPS);
      resultSave = false;
    }

    // if the user is adding a new dps row,  the date completed must be null
    // the pagemode was set to NEW in the add_xa.  Use page mode to verify this
    // is an add
    if (hdnCdCheckType.equals(STRING_VALUE_OF_10) && hdnDtCompleted != null && pageMode.equals(PageModeConstants.NEW)) {
      setErrorMessage("selDtCompleted", Messages.MSG_DATE_BLANK_REQ);
      resultSave = false;
    }

    // commented out by Corey to fulfill requirement CO-CAPTA4.3-4.1.9 for 4.3 Capta Release
    // if a date completed is entered
    // the user is required to provide Comments.  
//    if (hdnComments.equals(StringHelper.EMPTY_STRING) && hdnDtCompleted != null) {
//      setErrorMessage("selComments", Messages.MSG_REC_COMMENT_ENTRY_REQUIRED);
//      resultSave = false;
//    }
    
    // comments are now required whenever "Yes" is selected for the history
    if(ArchitectureConstants.Y.equals(history) && "".equals(hdnComments)){
      setErrorMessage("Since History checkbox is checked, a Comment Entry is required.");
      resultSave = false;
    }
    
    // add check for required fields
    if (hdnDtRequest == null || hdnCdCheckType == null) {
      setErrorMessage("All required fields must be entered.");
    }

    // if the type of search selected for a new row = '10'/dps the user must use
    // today's date for dtRequest. the pagemode was set to NEW in the add_xa.
    // Use page mode to verify this is an add; modified 03/03/03
    if (hdnCdCheckType.equals(STRING_VALUE_OF_10) &&
        !hdnDtRequest.equals(DateHelper.getTodayCastorDate()) &&
        pageMode.equals(PageModeConstants.NEW)) {
      setErrorMessage("selDtRequest", Messages.SSM_DATE_EQUAL_CURR);
      resultSave = false;
    }

    // if the user tries to enter dt requested later than the current date
    // ----------
    // RIOSJA, SIR 22576 - Added "!hdnCdCheckType.equals( STRING_VALUE_OF_10 )"
    // condition because Date of Request validation for DPS Criminal History
    // is already handled by the previous if statement.
    if (!hdnCdCheckType.equals(STRING_VALUE_OF_10) && hdnDtRequest != null && DateHelper.isAfterToday(hdnDtRequest)) {
      setErrorMessage("selDtRequest", Messages.SSM_DATE_BEFORE_SAME_CURR);
      resultSave = false;
    }

    // if the user tries to enter dt completed later than the current date
    if (hdnDtCompleted != null && DateHelper.isAfterToday(hdnDtCompleted)) {
      setErrorMessage("selDtCompleted", Messages.SSM_DATE_BEFORE_SAME_CURR);
      resultSave = false;
    }

    //  The date requested and completed are in the wrong order
    if (hdnDtCompleted != null && hdnDtRequest != null && DateHelper.isBefore(hdnDtCompleted, hdnDtRequest)) {
      setErrorMessage(Messages.SSM_CFC_COMPLETED_DATE);
      resultSave = false;
    }

    // A field, from the person table, required for dps checks, is missing or null
    if (hdnCdCheckType.equals(STRING_VALUE_OF_10) &&
        ((txtSubjectName.equals(StringHelper.EMPTY_STRING))
         || ("true".equals(bGenderUnknown))
         || (txtRaceEthnicity.equals(StringHelper.EMPTY_STRING))
         || ("Y".equals(bDobIsApproximate))
        )
            ) {
      setErrorMessage(Messages.MSG_NO_DPS_MIN_INFO);
      resultSave = false;
    }

    // the person's age is  < 14  criminal history, no criminal history checkis
    // allowed.
    if (hdnCdCheckType.equals(STRING_VALUE_OF_10)
        && "true".equals(bDobExists)) {
      if ((DateHelper.getAge(dtDob) < 14)) {
        setErrorMessage(Messages.MSG_SUB_NO_MINOR_DPS_CHECK);
        resultSave = false;
      }
    }

    // SIR 22935
    // SIR 23184 - Changed !PRN to COL
    if (hdnCdCheckType.equals(STRING_VALUE_OF_10) &&
        "COL".equals(szCdStagePersType)) {
      setErrorMessage(Messages.MSG_DPS_CRIM_PRN);
      resultSave = false;
    }

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return resultSave;
  } // end validateSave method

  /**
   * ***************************************************************************** *  Declare any static constants.
   * ******************************************************************************
   */
// static constants
  public static final String TRACE_TAG = "RecordsCheckDetailCustomValidation";
  public static final String STRING_VALUE_OF_10 = "10";
} // end class

