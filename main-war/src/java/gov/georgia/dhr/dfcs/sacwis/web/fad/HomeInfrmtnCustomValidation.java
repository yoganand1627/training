package gov.georgia.dhr.dfcs.sacwis.web.fad;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.Option;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.service.person.Person;
import gov.georgia.dhr.dfcs.sacwis.service.resource.Resource;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC37SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC37SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD07SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD37SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG01;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RetrieveResourceHouseholdMembersSO;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

/**
 * HomeInfrmtn.jsp Custom validation class
 * <p>
 * Description: Custom Validation for HomeInfrmtn.jsp
 * </p>
 * <p>
 * Copyright: Copyright (c) 2003
 * </p>
 * <p>
 * Company: TDPRS
 * </p>
 * 
 * @author J. Heather Dean
 * @version 1.0
 *          <p/>
 *          Change History: Date      User         Description --------  -----------
 *          ---------------------------------------------- 10/14/03  dickmaec     SIR 19857 -- ContextHelper.get...
 *          replaces getInputValue();
 *          <p/>
 *          10/14/03  dickmaec     As part of SIR 19857, all messages where shorted form
 *                                 MessageLookup.getMessageByNumber( Messages.SSM_FAD_MIN_LESS_MAX) to 
 *                                 Messages.SSM_FAD_MIN_LESS_MAX. 6/18/2004
 *                    gerryc       SIR 16052 - added validation on the principal type. Foster homes require one 
 *                                 FP principal, if the marital status is married, it requires a male and female FP.
 *                                 Adoptive homes require one AP principal, if the marital status is married, it 
 *                                 requires a male and female AP. Other types of homes require an FP or AP,
 *                                 and two of them if the maritial status is married.  Also changed around and 
 *                                 cleaned up code relating to non-prs homes.
 *          12/27/04  reedlg       SIR 22684 - Add edit on phone to require a primary phone for FAD home
 *                                 status other than INQUIRY or CLOSED and issue a message if no primary phone exists.
 *                                 No phone required for FAD home status INQUIRY or CLOSED. 
 *          1/26/2004 gerryc       SIR 23277 - removed edit that checks for open placements when switching the 
 *                                 status to Approved-Inactive. 
 *          4/14/2004 gerryc       SIR 23535 - modified condition for error message so that if the home insn't 
 *                                 strictly fostor or adoptive, the new role of Adoptive/Foster Parent is acceptable.
 *          04/18/05  Hadjimh      SIR#23327. Add a new field to the Home Information page. This new field would 
 *                                 be stored in the CAPS_RESOURCE table. 
 *                                 1) If the Non-FPS Adoptive Home checkbox is checked, staff will have to select 
 *                                 a 'Certifying Entity'. to indicate the certifying agency 
 *                                 2) This will be a required field when the Non-FPS Adoptive Home checkbox is 
 *                                 checked for a home. 
 *                                 3) If a user is modifying an existing Non-FPS Adoptive Home, this new field 
 *                                 will be required, unless the home status is also being changed to 
 *                                 'Pending Closure' or 'Closed'.
 *          03/27/07 aodutayo      Removed all references to code values that changed for SHINES. The code types in
 *                                 paritcular include CDFAHOMETYPE, CFACATEG, CFAHMSTA.
 *          12/10/07 eimomio       STGAP00005493: Home Information - Fields Not Saving or Not Requiring Supervisor Approval on Updates
 *          11/28/10 schoi         SMS #81140: MR-074 Updated code to reflect removal (filtering) of Unmarried Couple 
 *                                 from the Marital Status; Removed Unmarried Couple from the condition of MSG_FAD_MARITAL_NOT_FOR_ADO 
 *                                 and added condition to force user to choose another Marital Status if Unmarried Couple still exists
 *          12/04/10 schoi         SMS #81140: MR-074 Updated code to check Marital Status match with Person Detail record
 *                                 when the Home Information is submitted and supervisor clicks Approval Status button 
 *          01/04/11 schoi         SMS #81140: MR-074 Updated code per outstanding peer review item (minor); moved 
 *                                 MSG_FAD_MARITAL_NOT_MATCH_PERSON from the end of the code to the top to call validation when necessary  
 *          03/20/11 hnguyen       SMS#97850: MR-075 Updated logic to allow save in approval mode and enable validation in approval mode
 *                                 Also added new validation for medical and records checks.
 *          03/26/11 hnguyen       SMS#97850: MR-075 Updated logic that determines onHoldChanged and validation that need to occur.
 *          03/27/11 hnguyen       SMS#97850: MR-075 Corrected validation to handle new scenarios with Hold Placements and Approval.
 *          03/31/11 hnguyen       SMS#97850: MR-075 Corrected error message for home interest female age range. And reverted previous change
 *                                 validation for approved home age.
 *          06/06/11 hnguyen       SMS#111056: Corrected home records check validation.
 *          06/16/11 hnguyen       SMS#111056: Corrected home records check validation to require RC if RC due date is less than approval end
 *                                 and 5 year had lapse from last RC completed.
 *          08/24/11 hnguyen       STGAP00017009: Corrected logic that determines license change due to Approval Date 
 *                                 change to allow save of approval end date consequently calculating NCIC and GCIC records
 *                                 checks due date correctly.
 *          09/07/11 hnguyen       STGAP00017009: Due date to be an additional 1 year if 5 year RC period had not
 *                                 lapse by the end of the calculated due date.
 */
public class HomeInfrmtnCustomValidation extends FormValidation {

  /**
   * ***************************************************************************** * Declare any static constants.
   * ******************************************************************************
   */
  // static constants
  public static final String TRACE_TAG = "HomeInfrmtnCustomValidation";

  public static final int MAX_CAPACITY = 9999;

  public static final String BASIC = "famTypes1";

  public static final String EMERGENCY = "famTypes2";

  public static final String MEDICAL_FRAGILE = "famTypes3";

  public static final String RESPITE = "famTypes4";

  public static final String SPEC_FOSTER_CARE = "famTypes5";

  public static final String THERAPEUTIC = "famTypes6";

  public static final String M_MAX_YEAR = "selMaleMaxYear";

  public static final String M_MIN_YEAR = "selMaleMinYear";

  public static final String F_MIN_YEAR = "selFemaleMinYear";

  public static final String M_MIN_YEAR_INT = "selMaleMinYearInt";

  public static final String M_MAX_YEAR_INT = "selMaleMaxYearInt";

  public static final String F_MIN_YEAR_INT = "selFemaleMinYearInt";

  public static final String F_MAX_YEAR_INT = "selFemaleMaxYearInt";

  public static final String TXT_CAPACITY = "txtCapacity";

  public static final String SEL_CLOSURE_REASON = "selClosureReason";

  public static final String SEL_REC_REOPEN = "selRecReopen";

  public static final String SEL_INVOL_CLOSURE = "selInvolClosure";

  public static final String STATUS_RSN_COMMENTS = "txtStatusRsnComments";

  public static final String TRUE = "true";

  protected boolean validateForm() {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "validationForm");
    performanceTrace.enterScope();

    HttpServletRequest request = super.getRequest();
    BaseSessionStateManager state = super.getState();

    Person personEjb = getEjb(Person.class);
    Resource resource = getEjb(Resource.class);

    boolean result = true;

    CFAD07SO cfad07so = (CFAD07SO) state.getAttribute("CFAD07SO", request);
    CFAD37SO cfad37so = (CFAD37SO) state.getAttribute("CFAD37SO", request);

    org.exolab.castor.types.Date closureDate = ContextHelper.getCastorDateSafe(request, "closureDate");
    String fieldsDisabled = ContextHelper.getStringSafe(request, "fieldsDisabled");
    String status = ContextHelper.getStringSafe(request, "selStatus");
    String category = ContextHelper.getStringSafe(request, "selCategory");
    String adExchStatus = ContextHelper.getStringSafe(request, "selAdExchStatus");
    String closureReason = ContextHelper.getStringSafe(request, SEL_CLOSURE_REASON);
    String recReopen = ContextHelper.getStringSafe(request, SEL_REC_REOPEN);
    String closureType = ContextHelper.getStringSafe(request, SEL_INVOL_CLOSURE);
    String statusRsnComments = ContextHelper.getStringSafe(request, STATUS_RSN_COMMENTS);
    String maritalStatus = ContextHelper.getStringSafe(request, "selMaritalStatus");
    String annualIncome = ContextHelper.getStringSafe(request, "txtAnnualIncome");
    String currentNonDfcsState = "";
    org.exolab.castor.types.Date dtMarriage = ContextHelper.getCastorDateSafe(request, "marriageDate");
    org.exolab.castor.types.Date apprvlBeginDt = ContextHelper.getCastorDateSafe(request, "apprvlBeginDt");
    org.exolab.castor.types.Date apprvlEndDt = ContextHelper.getCastorDateSafe(request, "apprvlEndDt");
    boolean nonDfcsChanged = false;

    // SMS #81140: MR-074
    Integer stageID = GlobalData.getUlIdStage(request);

    boolean isApprover = false;
    if (GlobalData.isApprovalMode(request)) {
      isApprover = true;
    }

    String holdPlacementsCurrent = ContextHelper.getStringSafe(request, "ckOnHold");
    String holdPlacementsPrev = "";
    boolean holdPlaceChanged = false;

    // MR-075 home previous Hold Placement is determined by resource status,
    // not by what was last saved for hold placements checkbox.
    if (!HomeInfrmtnConversation.RSRC_STAT_ACTIVE.equals(cfad37so.getSzCdRsrcStatus())) {
      holdPlacementsPrev = "on";
    }

    // MR-075 Hold Placement changes only occurr when home is in approved - active status.
    if (!holdPlacementsCurrent.equals(holdPlacementsPrev)
        && (HomeInfrmtnConversation.CODE_STATUS_APPROVED_SPEC_ACTIVE.equals(status)
            || HomeInfrmtnConversation.CODE_STATUS_APPROVED_FULL_ACTIVE.equals(status) || HomeInfrmtnConversation.CODE_STATUS_APPROVED_TEMP_ACTIVE
                                                                                                                                                  .equals(status))) {
      holdPlaceChanged = true;
    }

    boolean isOnHold = false;

    if (!ContextHelper.getStringSafe(request, "ckOnHold").equals(StringHelper.EMPTY_STRING)) {
      isOnHold = true;
    }

    if (StringHelper.isTrue(CheckboxHelper.getCheckboxValue(request, "chkIndNonDFCSHome"))) {
      currentNonDfcsState = "Y";
    } else {
      currentNonDfcsState = "N";
    }
    // STGAP00005493: Validation done here for Ad. Exchange Status.
    boolean adExchStatusChanged = false;
    boolean apprvlBeginDtChanged = false;
    boolean apprvlEndDtChanged = false;

    if (!adExchStatus.equals(StringHelper.getNonNullString(cfad37so.getSzCdAdExchangeStat()))) {
      adExchStatusChanged = true;
    }

    if (!currentNonDfcsState.equals(cfad07so.getROWCFAD07SOG04().getCIndRshsNonDFCSHome())) {
      nonDfcsChanged = true;
    }
    if (this.isButtonPressed("btnSave1")
        && (adExchStatusChanged)
        && (HomeInfrmtnConversation.CODE_STATUS_APPROVED_FULL_ACTIVE.equals(status)
            || HomeInfrmtnConversation.CODE_STATUS_APPROVED_SPEC_ACTIVE.equals(status)
            || HomeInfrmtnConversation.CODE_STATUS_APPROVED_FULL_ACTIVE_30_DAY.equals(status)
            || HomeInfrmtnConversation.CODE_STATUS_APPROVED_SPEC_ACTIVE_30_DAY.equals(status) || HomeInfrmtnConversation.CODE_STATUS_APPROVED_TEMP_ACTIVE
                                                                                                                                                         .equals(status))) {
      setErrorMessage(Messages.MSG_FAD_SAVE_SUBMIT);
      result = false;
    }

    if (nonDfcsChanged
        && (HomeInfrmtnConversation.CODE_STATUS_APPROVED_FULL_ACTIVE.equals(status)
            || HomeInfrmtnConversation.CODE_STATUS_APPROVED_SPEC_ACTIVE.equals(status)
            || HomeInfrmtnConversation.CODE_STATUS_APPROVED_FULL_ACTIVE_30_DAY.equals(status)
            || HomeInfrmtnConversation.CODE_STATUS_APPROVED_SPEC_ACTIVE_30_DAY.equals(status) || HomeInfrmtnConversation.CODE_STATUS_APPROVED_TEMP_ACTIVE
                                                                                                                                                         .equals(status))) {
      setErrorMessage(Messages.MSG_FAD_SAVE_SUBMIT);
      result = false;
    }
    // If Save and Assign was clicked, and fields are disabled it is a reopen
    if (this.isButtonPressed("btnAssign") && fieldsDisabled.equals(TRUE)) {
      if (DateHelper.isToday(closureDate)) {
        setErrorMessage(Messages.MSG_HOME_REOPEN_DAY_WAIT);
        result = false;
      }

      // ochumd sir#18829 07/14/2003 No editing other than there must be one day
      // between closing and re-opening should occur therefore return result.
      return result;
    }

    /* HH SIR#18826 */
    if (this.isButtonPressed("btnSaveSubmit")) {
      if (!(HomeInfrmtnConversation.CODE_STATUS_PEND_FULL_APP.equals(status)
            || HomeInfrmtnConversation.CODE_STATUS_PEND_SPEC_APP.equals(status)
            || HomeInfrmtnConversation.CODE_STATUS_PEND_TEMP_APP.equals(status)
            || HomeInfrmtnConversation.CODE_STATUS_PEND_FULL_APP_30_DAY.equals(status)
            || HomeInfrmtnConversation.CODE_STATUS_PEND_SPEC_APP_30_DAY.equals(status)
            || HomeInfrmtnConversation.CODE_STATUS_PEND_UNAPPROVE.equals(status) || HomeInfrmtnConversation.CODE_STATUS_PENDING_CLOSURE
                                                                                                                                       .equals(status))
          && !(holdPlaceChanged)) {
        result = false;
        setErrorMessage(Messages.MSG_FAD_PENDING_STATUS_ONLY);
        return result;
      }
    }

    // MR-075 On submit or in approval mode clicking Approval Status
    // make sure marital status, annual income, and approval dates are entered.
    if (this.isButtonPressed("btnSaveSubmit") || (this.isButtonPressed("btnApprvlStatus") && isApprover)) {
      if (HomeInfrmtnConversation.CODE_STATUS_PEND_FULL_APP.equals(status)
          || HomeInfrmtnConversation.CODE_STATUS_PEND_SPEC_APP.equals(status)
          || HomeInfrmtnConversation.CODE_STATUS_PEND_FULL_APP_30_DAY.equals(status)
          || HomeInfrmtnConversation.CODE_STATUS_PEND_SPEC_APP_30_DAY.equals(status)
          || HomeInfrmtnConversation.CODE_STATUS_PEND_TEMP_APP.equals(status)) {
        if (maritalStatus.equals(StringHelper.EMPTY_STRING)) {
          setErrorMessage(Messages.MSG_FAD_NO_MAR_STATUS);
          result = false;
        }
        if (annualIncome.equals(StringHelper.EMPTY_STRING)) {
          setErrorMessage(Messages.MSG_FAD_NO_INCOME_STATUS);
          result = false;
        }
        if (apprvlBeginDt == null || apprvlEndDt == null) {
          setErrorMessage(Messages.MSG_FAD_HOME_APPRV_DTS_REQ);
          result = false;
        }
      }
    }

    boolean checkAges = true;
    SortedMap statuses = new TreeMap();
    if (state.getAttribute("restrictedStatusOptions", request) != null) {
      statuses = (SortedMap) state.getAttribute("restrictedStatusOptions", request);
    }
    Collection statusOptions = statuses.values();
    Iterator it = statusOptions.iterator();
    /*
     * SIR# 18628. if CODE_STATUS_PENDING_APPROVAL is not in the drop down box, then * do not give a message to choose
     * the Pending Approval from the drop down box.
     */
    boolean bMessageForSaveSubmit = false;
    while (it.hasNext()) {
      Option op = (Option) it.next();
      if (op.getCode().equals(HomeInfrmtnConversation.CODE_STATUS_PEND_FULL_APP)
          || op.getCode().equals(HomeInfrmtnConversation.CODE_STATUS_PEND_SPEC_APP)
          || op.getCode().equals(HomeInfrmtnConversation.CODE_STATUS_PEND_FULL_APP_30_DAY)
          || op.getCode().equals(HomeInfrmtnConversation.CODE_STATUS_PEND_SPEC_APP_30_DAY)
          || op.getCode().equals(HomeInfrmtnConversation.CODE_STATUS_PEND_TEMP_APP)) {
        bMessageForSaveSubmit = true;
      }
    }

    // SMS #81140: MR-074
    // Check Marital Status match with Person Detail record
    // when supervisor clicks Approval Status button after the page submission
    if (super.isButtonPressed("btnApprvlStatus") && (isApprover)) {
      if (HomeInfrmtnConversation.checkIfMaritalStatusInconsistent(stageID, maritalStatus, getEjb(Resource.class))) {
        setErrorMessage(Messages.MSG_FAD_MARITAL_NOT_MATCH_PERSON);
        result = false;
      }
    }

    org.exolab.castor.types.Date today = DateHelper.toCastorDate(new java.util.Date());

    boolean isClosure = false;
    if (HomeInfrmtnConversation.CODE_STATUS_CLOSED.equals(status)
        || HomeInfrmtnConversation.CODE_STATUS_PENDING_CLOSURE.equals(status)) {
      isClosure = true;
    }

    boolean isNonPrs;
    isNonPrs = StringHelper.isTrue(CheckboxHelper.getCheckboxValue(request, "chkIndNonDFCSHome"));
    /* SIR# 23327. added sCertifyEntity */
    String sCertifyEntity = ContextHelper.getStringSafe(request, "txtSzCertifyEntity");

    int capacity = ContextHelper.getIntSafe(request, TXT_CAPACITY);

    String[] checkBoxes = CheckboxHelper.getCheckedValues(request, "famTypes");
    boolean atLeastOneFamTypeChecked = false;
    if (checkBoxes.length > 0) {
      atLeastOneFamTypeChecked = true;
    }
    java.util.List famTypes = java.util.Arrays.asList(checkBoxes);
    boolean indBasic = famTypes.contains(HomeInfrmtnConversation.CODE_BASIC);
    boolean indEmergency = famTypes.contains(HomeInfrmtnConversation.CODE_EMERGENCY);
    boolean indTherapeutic = famTypes.contains(HomeInfrmtnConversation.CODE_THERAPEUTIC);
    boolean indSFC = famTypes.contains(HomeInfrmtnConversation.CODE_SPEC_FOST_CARE);
    boolean indMedFragile = famTypes.contains(HomeInfrmtnConversation.CODE_MEDICALLY_FRAGILE);
    boolean indRespite = famTypes.contains(HomeInfrmtnConversation.CODE_RESPITE);
    boolean isLicensingSectionPopulated = false;

    // Home Interest Age Ranges
    int femaleMinMonthInt = 0;
    femaleMinMonthInt = ContextHelper.getIntSafe(request, "selFemaleMinMonthInt");
    int femaleMinYearInt = 0;
    femaleMinYearInt = ContextHelper.getIntSafe(request, F_MIN_YEAR_INT);
    int femaleMinAgeInMonthInts = (femaleMinYearInt * 12) + femaleMinMonthInt;

    int femaleMaxMonthInt = 0;
    femaleMaxMonthInt = ContextHelper.getIntSafe(request, "selFemaleMaxMonthInt");
    int femaleMaxYearInt = 0;
    femaleMaxYearInt = ContextHelper.getIntSafe(request, "selFemaleMaxYearInt");
    int femaleMaxAgeInMonthInts = (femaleMaxYearInt * 12) + femaleMaxMonthInt;

    int maleMinMonthInt = 0;
    maleMinMonthInt = ContextHelper.getIntSafe(request, "selMaleMinMonthInt");
    int maleMinYearInt = 0;
    maleMinYearInt = ContextHelper.getIntSafe(request, M_MIN_YEAR_INT);
    int maleMinAgeInMonthInts = (maleMinYearInt * 12) + maleMinMonthInt;

    int maleMaxMonthInt = 0;
    if (ContextHelper.getStringSafe(request, "selMaleMaxMonthInt") != null) {
      maleMaxMonthInt = ContextHelper.getIntSafe(request, "selMaleMaxMonthInt");
    }
    int maleMaxYearInt = 0;
    if (ContextHelper.getStringSafe(request, "selMaleMaxYearInt") != null) {
      maleMaxYearInt = ContextHelper.getIntSafe(request, "selMaleMaxYearInt");
    }
    int maleMaxAgeInMonthInts = (maleMaxYearInt * 12) + maleMaxMonthInt;

    boolean interestAgesExist = false;
    if (maleMaxAgeInMonthInts > 0 || maleMinAgeInMonthInts > 0 || femaleMaxAgeInMonthInts > 0
        || femaleMinAgeInMonthInts > 0) {
      interestAgesExist = true;
    }

    boolean noInterests = false;
    // txtNumberChildren doesnt exist in SHINES
    // boolean noNOC = false;
    if (maleMaxAgeInMonthInts == 0 && maleMinAgeInMonthInts == 0 && femaleMaxAgeInMonthInts == 0
        && femaleMinAgeInMonthInts == 0) {
      noInterests = true;
    }
    /*
     * SIR #18713: The home must be interested in at least one * ethnicity before it can be saved & submitted for
     * certification.
     */
    boolean bEthnicity = NewHomeCustomValidation.hasEthnicity(getRequest());
    boolean bChildChar = NewHomeCustomValidation.hasChildChar(getRequest());

    /* end SIR #18713 */
    // Licensing Age Ranges
    int femaleMinMonth = ContextHelper.getIntSafe(request, "selFemaleMinMonth");
    int femaleMinYear = ContextHelper.getIntSafe(request, F_MIN_YEAR);
    int femaleMinAgeInMonths = (femaleMinYear * 12) + femaleMinMonth;
    int femaleMaxMonth = ContextHelper.getIntSafe(request, "selFemaleMaxMonth");
    int femaleMaxYear = ContextHelper.getIntSafe(request, "selFemaleMaxYear");
    int femaleMaxAgeInMonths = (femaleMaxYear * 12) + femaleMaxMonth;
    int maleMinMonth = ContextHelper.getIntSafe(request, "selMaleMinMonth");
    int maleMinYear = ContextHelper.getIntSafe(request, M_MIN_YEAR);
    int maleMinAgeInMonths = (maleMinYear * 12) + maleMinMonth;
    int maleMaxMonth = ContextHelper.getIntSafe(request, "selMaleMaxMonth");
    int maleMaxYear = ContextHelper.getIntSafe(request, M_MAX_YEAR);
    int maleMaxAgeInMonths = (maleMaxYear * 12) + maleMaxMonth;

    boolean licenseAgesExist = false;
    if (maleMaxAgeInMonths > 0 || maleMinAgeInMonths > 0 || femaleMaxAgeInMonths > 0 || femaleMinAgeInMonths > 0) {
      licenseAgesExist = true;
    }

    String licenseDisabled = ContextHelper.getStringSafe(request, "licenseDisabled");

    if (!licenseDisabled.equals(TRUE)) {
      if (atLeastOneFamTypeChecked || capacity > 0 || maleMaxAgeInMonths > 0 || femaleMaxAgeInMonths > 0) {
        isLicensingSectionPopulated = true;
      }
    }
    //
    // ||recReopen.equals(StringHelper.EMPTY_STRING)||
    // closureType.equals(StringHelper.EMPTY_STRING)||closureType.equals(StringHelper.EMPTY_STRING)
    // STGAP00005493: Home Information - Fields Not Saving or Not Requiring Supervisor Approval on Updates

    // closure Reason
    if (closureReason.equals(StringHelper.EMPTY_STRING)) {
      if (status.equals(HomeInfrmtnConversation.CODE_STATUS_PENDING_CLOSURE)) {
        setErrorMessage(SEL_CLOSURE_REASON, Messages.MSG_PENDCLS__NO_CLO_REASON);
        result = false;
      }

      if (status.equals(HomeInfrmtnConversation.CODE_STATUS_CLOSED)) {
        setErrorMessage(SEL_CLOSURE_REASON, Messages.MSG_CLS_NO_CLO_REASON);
        result = false;
      }
    } else {
      if (!status.equals(HomeInfrmtnConversation.CODE_STATUS_PENDING_CLOSURE)
          && !status.equals(HomeInfrmtnConversation.CODE_STATUS_CLOSED)) {
        setErrorMessage(SEL_CLOSURE_REASON, Messages.MSG_NO_CLOSURE);
        result = false;
      }
    }

    // recreopen
    if (recReopen.equals(StringHelper.EMPTY_STRING)) {
      if (status.equals(HomeInfrmtnConversation.CODE_STATUS_PENDING_CLOSURE)) {
        setErrorMessage(SEL_REC_REOPEN, Messages.MSG_PENDCLS__NO_CLO_REASON);
        result = false;
      }

      if (status.equals(HomeInfrmtnConversation.CODE_STATUS_CLOSED)) {
        setErrorMessage(SEL_REC_REOPEN, Messages.MSG_CLS_NO_CLO_REASON);
        result = false;
      }
    } else {
      if (!status.equals(HomeInfrmtnConversation.CODE_STATUS_PENDING_CLOSURE)
          && !status.equals(HomeInfrmtnConversation.CODE_STATUS_CLOSED)) {
        setErrorMessage(SEL_REC_REOPEN, Messages.MSG_NO_CLOSURE);
        result = false;
      }
    }
    // closureType
    if (closureType.equals(StringHelper.EMPTY_STRING)) {
      if (status.equals(HomeInfrmtnConversation.CODE_STATUS_PENDING_CLOSURE)) {
        setErrorMessage(SEL_INVOL_CLOSURE, Messages.MSG_PENDCLS__NO_CLO_REASON);
        result = false;
      }

      if (status.equals(HomeInfrmtnConversation.CODE_STATUS_CLOSED)) {
        setErrorMessage(SEL_INVOL_CLOSURE, Messages.MSG_CLS_NO_CLO_REASON);
        result = false;
      }
    } else {
      if (!status.equals(HomeInfrmtnConversation.CODE_STATUS_PENDING_CLOSURE)
          && !status.equals(HomeInfrmtnConversation.CODE_STATUS_CLOSED)) {
        setErrorMessage(SEL_INVOL_CLOSURE, Messages.MSG_NO_CLOSURE);
        result = false;
      }
    }
    // comments
    if (statusRsnComments.equals(StringHelper.EMPTY_STRING)) {
      if (status.equals(HomeInfrmtnConversation.CODE_STATUS_PENDING_CLOSURE)) {
        setErrorMessage(STATUS_RSN_COMMENTS, Messages.MSG_PENDCLS__NO_CLO_REASON);
        result = false;
      }

      if (status.equals(HomeInfrmtnConversation.CODE_STATUS_CLOSED)) {
        setErrorMessage(STATUS_RSN_COMMENTS, Messages.MSG_CLS_NO_CLO_REASON);
        result = false;
      }
    } else {
      if (!status.equals(HomeInfrmtnConversation.CODE_STATUS_PENDING_CLOSURE)
          && !status.equals(HomeInfrmtnConversation.CODE_STATUS_CLOSED)) {
        setErrorMessage(STATUS_RSN_COMMENTS, Messages.MSG_NO_CLOSURE);
        result = false;
      }
    }
    int openPlacements = ContextHelper.getIntSafe(request, "txtPlacements");
    String previousStatus = StringHelper.EMPTY_STRING;
    if (cfad07so != null && cfad07so.getROWCFAD07SOG04() != null) {
      previousStatus = cfad07so.getROWCFAD07SOG04().getSzCdRshsFaHomeStatus();
    }
    /* HH: SIR# 18716 */
    boolean bNoApprovalNeeded = (HomeInfrmtnConversation.CODE_STATUS_CLOSED.equals(status)
                                 || HomeInfrmtnConversation.CODE_STATUS_WAITLIST.equals(status)
                                 || HomeInfrmtnConversation.CODE_STATUS_APPLICANT.equals(status) || HomeInfrmtnConversation.CODE_STATUS_INQUIRY
                                                                                                                                               .equals(status));

    if (status.equals(HomeInfrmtnConversation.CODE_STATUS_PENDING_CLOSURE) && openPlacements > 0
        && !(closureReason.equals(CodesTables.CFACLOSE_AFS) || closureReason.equals(CodesTables.CFACLOSE_AFN))) {
      setErrorMessage(Messages.MSG_FAD_PLCMT_CLS);
      result = false;
    }

    boolean licensingInfoHasChanged = false;
    /*
     * SIR 16052 added these indicators for checking if there are principals with the right role, and if the status is
     * married, there are both a male and female principal
     */
    String indFosterParent = ArchitectureConstants.N;
    String indAdoptiveParent = ArchitectureConstants.N;
    String indMarriedFP = ArchitectureConstants.N;
    String indMarriedAP = ArchitectureConstants.N;
    String indMarriedAorF = ArchitectureConstants.N;
    String indFostAdoptParent = ArchitectureConstants.N; // SIR 23535

    org.exolab.castor.types.Date dbDate = DateHelper.toCastorDate(cfad37so.getDtDtApprvlBegin());

    if (!DateHelper.isEqual(apprvlBeginDt, dbDate)) {
      apprvlBeginDtChanged = true;
    }
    org.exolab.castor.types.Date dbEndDate = DateHelper.toCastorDate(cfad37so.getDtDtApprvlEnd());
    if (!DateHelper.isEqual(apprvlEndDt, dbEndDate)) {
      apprvlEndDtChanged = true;
    }
    if (cfad37so != null) {
      // MR-075 If this is a hold placement change user cant
      // modify the category and home status.
      // HD 6/18/2003 -- If category or status has changed, licensing info has changed.
      if (!category.equals(cfad37so.getSzCdRsrcCategory())) {
        licensingInfoHasChanged = true;
      } else if (!status.equals(cfad37so.getSzCdRsrcFaHomeStatus())) {
        licensingInfoHasChanged = true;
      }

      // MR-075 Dont set if this is a hold placement change,
      // section is disabled anyway.
      if (!holdPlaceChanged && isLicensingSectionPopulated) {
        if (capacity != cfad37so.getUNbrRsrcFacilCapacity()) {
          licensingInfoHasChanged = true;
        } else if (maleMaxAgeInMonths != cfad37so.getUNbrRsrcMlAgeMax()
                   || maleMinAgeInMonths != cfad37so.getUNbrRsrcMlAgeMin()) {
          licensingInfoHasChanged = true;
        } else if (femaleMaxAgeInMonths != cfad37so.getUNbrRsrcFMAgeMax()
                   || femaleMinAgeInMonths != cfad37so.getUNbrRsrcFMAgeMin()) {
          licensingInfoHasChanged = true;
        } else if (hasFamTypeChanged(checkBoxes, cfad37so.getCCdRsrcFaHomeType1_CFAD37SO())) {
          licensingInfoHasChanged = true;
        } else if (apprvlBeginDtChanged) {
          licensingInfoHasChanged = true;
        } else if (apprvlEndDtChanged) {
          licensingInfoHasChanged = true;
        }
      }

      indFosterParent = cfad37so.getBIndFosterParent();
      indAdoptiveParent = cfad37so.getBIndAdoptiveParent();
      indFostAdoptParent = cfad37so.getBIndFostAdoptParent(); // SIR 23535
      indMarriedFP = cfad37so.getBIndMarriedFP();
      indMarriedAP = cfad37so.getBIndMarriedAP();
      indMarriedAorF = cfad37so.getBIndMarriedAorF();
    }

    String vid = StringHelper.EMPTY_STRING;
    if (ContextHelper.getStringSafe(request, "vid") != null) {
      vid = ContextHelper.getStringSafe(request, "vid");
    }

    boolean statusPrecedesPendingApproval = false;
    if (status.equals(HomeInfrmtnConversation.CODE_STATUS_INQUIRY)
        || status.equals(HomeInfrmtnConversation.CODE_STATUS_APPLICANT)
        || status.equals(HomeInfrmtnConversation.CODE_STATUS_CLOSED)
        || status.equals(HomeInfrmtnConversation.CODE_STATUS_WAITLIST)) {
      statusPrecedesPendingApproval = true;
    }

    // If Status is Pending Approval or higher on a license change and home is a PRS home, submit is required
    if (!this.isButtonPressed("btnSaveSubmit") && !isApprover) {
      if (this.isButtonPressed("btnSave1") && !bNoApprovalNeeded) {
        if ((isNonPrs)
            && !(holdPlaceChanged)
            && (HomeInfrmtnConversation.CODE_STATUS_PEND_FULL_APP.equals(status)
                || HomeInfrmtnConversation.CODE_STATUS_PEND_SPEC_APP.equals(status)
                || HomeInfrmtnConversation.CODE_STATUS_PEND_FULL_APP_30_DAY.equals(status)
                || HomeInfrmtnConversation.CODE_STATUS_PEND_SPEC_APP_30_DAY.equals(status)
                || HomeInfrmtnConversation.CODE_STATUS_PEND_TEMP_APP.equals(status))) {
          setErrorMessage(Messages.MSG_FAD_SAVE_SUBMIT);
          result = false;
        } else if (holdPlaceChanged
                   && (HomeInfrmtnConversation.CODE_STATUS_APPROVED_FULL_ACTIVE.equals(status)
                       || HomeInfrmtnConversation.CODE_STATUS_APPROVED_SPEC_ACTIVE.equals(status) || HomeInfrmtnConversation.CODE_STATUS_APPROVED_TEMP_ACTIVE
                                                                                                                                                             .equals(status))) {
          setErrorMessage(Messages.MSG_FAD_HOLD_SAVE_SUBMIT);
          result = false;
        }
      }

      /*****************************************************************************************************************
       * SIR# 18716: added bNoApprovalNeeded. if a home status is changed from inquiry to closed, no approval is needed *
       ****************************************************************************************************************/
      if (!isNonPrs && !bNoApprovalNeeded) {
        if (licensingInfoHasChanged
            && (HomeInfrmtnConversation.CODE_STATUS_APPROVED_FULL_ACTIVE.equals(status)
                || HomeInfrmtnConversation.CODE_STATUS_APPROVED_SPEC_ACTIVE.equals(status)
                || HomeInfrmtnConversation.CODE_STATUS_APPROVED_FULL_ACTIVE_30_DAY.equals(status)
                || HomeInfrmtnConversation.CODE_STATUS_APPROVED_SPEC_ACTIVE_30_DAY.equals(status)
                || HomeInfrmtnConversation.CODE_STATUS_APPROVED_TEMP_ACTIVE.equals(status))) {
          setErrorMessage(Messages.MSG_FAD_CHANGE_TO_PEND);
          result = false;
        } else if ((HomeInfrmtnConversation.CODE_STATUS_PEND_FULL_APP.equals(status)
                    || HomeInfrmtnConversation.CODE_STATUS_PEND_SPEC_APP.equals(status)
                    || HomeInfrmtnConversation.CODE_STATUS_PEND_FULL_APP_30_DAY.equals(status)
                    || HomeInfrmtnConversation.CODE_STATUS_PEND_SPEC_APP_30_DAY.equals(status)
                    || HomeInfrmtnConversation.CODE_STATUS_PEND_TEMP_APP.equals(status)
                    || HomeInfrmtnConversation.CODE_STATUS_PEND_UNAPPROVE.equals(status)
                    || HomeInfrmtnConversation.CODE_STATUS_PENDING_CLOSURE.equals(status))) {
          setErrorMessage(Messages.MSG_FAD_SAVE_SUBMIT);
          result = false;
        } else if (status != null && !status.equals(previousStatus) && !statusPrecedesPendingApproval
                   && licensingInfoHasChanged) {
          setErrorMessage(Messages.MSG_FAD_SAVE_SUBMIT);
          result = false;
        } else if (licensingInfoHasChanged && !statusPrecedesPendingApproval) {
          setErrorMessage(Messages.MSG_FAD_SAVE_SUBMIT);
          result = false;
        }
      }
    } else {
      if (!isClosure) {
        /*
         * SIR #18713: The home must be interested in at least one * ethnicity before it can be saved & submitted for
         * certification.
         */
        if (!bEthnicity) {
          setErrorMessage(Messages.MSG_FAD_ETHNIC_REQ);
          result = false;
        }
        if (!bChildChar) {
          setErrorMessage(Messages.MSG_FAD_CHAR_REQ);
          result = false;
        }

        /***************************************************************************************************************
         * SIR# 18621: added "if ( closureReason == null)". MSG_FAD_CHANGE_TO_PEND message is not necessary if
         * closureReason is null. *
         **************************************************************************************************************/
        if (closureReason == null) {
          // If Save and Submit, status must be Pending Approval
          // SIR# 18628. added bMessageForSaveSubmit to the if condition
          if (!(HomeInfrmtnConversation.CODE_STATUS_PEND_FULL_APP.equals(status)
                || HomeInfrmtnConversation.CODE_STATUS_PEND_SPEC_APP.equals(status)
                || HomeInfrmtnConversation.CODE_STATUS_PEND_FULL_APP_30_DAY.equals(status)
                || HomeInfrmtnConversation.CODE_STATUS_PEND_SPEC_APP_30_DAY.equals(status)
                || HomeInfrmtnConversation.CODE_STATUS_PEND_UNAPPROVE.equals(status) || HomeInfrmtnConversation.CODE_STATUS_PEND_TEMP_APP
                                                                                                                                         .equals(status))
              && bMessageForSaveSubmit) {
            setErrorMessage(Messages.MSG_FAD_CHANGE_TO_PEND);
            result = false;
          }
        }

        // If Save and Submit, home Interest Section must be populated for a dfcs home
        if (!isNonPrs) {
          if (noInterests) {
            setErrorMessage(M_MIN_YEAR_INT, Messages.MSG_FAD_NO_INTERESTS);
            result = false;
          }
        }
        // depending on home type and marital status, different principals are required.

        // if it's a foster home, a foster parent principal is required.
        if (HomeInfrmtnConversation.CODE_FOSTER.equals(category)) {
          // if marital status is married, there should be two principals, one
          // male, one female, both with the Rel/Int of FP
          if (HomeInfrmtnConversation.CODE_MRTL_STATUS_MARRIED.equals(maritalStatus)
              && ArchitectureConstants.N.equals(indMarriedFP)) {
            setErrorMessage(Messages.MSG_FAD_TWO_FP_REQ);
            result = false;
          } else if (ArchitectureConstants.N.equals(indFosterParent)
                     && (ArchitectureConstants.N.equals(indFostAdoptParent)))
          // only one FP is required
          {
            setErrorMessage(Messages.MSG_FAD_FP_REQ);
            result = false;
          }
        }
        // if it's an adoptive home, an adoptive parent principal is required.
        else if (HomeInfrmtnConversation.CODE_ADOPTIVE.equals(category)) {
          // if marital status is married, there should be two principals, one
          // male, one female, both with the Rel/int of AP
          if (HomeInfrmtnConversation.CODE_MRTL_STATUS_MARRIED.equals(maritalStatus)
              && ArchitectureConstants.N.equals(indMarriedAP)) {
            setErrorMessage(Messages.MSG_FAD_TWO_AP_REQ);
            result = false;
          } else if (ArchitectureConstants.N.equals(indAdoptiveParent)
                     && (ArchitectureConstants.N.equals(indFostAdoptParent)))
          // only one AP is required
          {
            setErrorMessage(Messages.MSG_FAD_AP_REQ);
            result = false;
          }
        }
        // it's not strictly foster or adoptive
        else {
          // if it's marked as married there must me a male and female principal
          // with AP or FP status.
          if (HomeInfrmtnConversation.CODE_MRTL_STATUS_MARRIED.equals(maritalStatus)
              && ArchitectureConstants.N.equals(indMarriedAorF)) {
            setErrorMessage(Messages.MSG_FAD_TWO_PRN_REQ);
            result = false;
          } else if (ArchitectureConstants.N.equals(indAdoptiveParent)
                     && ArchitectureConstants.N.equals(indFosterParent)
                     && ArchitectureConstants.N.equals(indFostAdoptParent))
          // if it's not strictly foster or adoptive, FP, AP, or AF are ok, but at
          // least 1 must be there
          {
            setErrorMessage(Messages.MSG_FAD_NO_CARETAKER);
            result = false;
          }
        }
        // end checking home type and marital status

        // MR-075 Only validate if a DFCS Home,
        // for non-DFCS Home we dont care about the interest age exists or not.
        if ((HomeInfrmtnConversation.CODE_STATUS_PEND_FULL_APP.equals(status)
             || HomeInfrmtnConversation.CODE_STATUS_PEND_SPEC_APP.equals(status)
             || HomeInfrmtnConversation.CODE_STATUS_PEND_FULL_APP_30_DAY.equals(status)
             || HomeInfrmtnConversation.CODE_STATUS_PEND_SPEC_APP_30_DAY.equals(status) || HomeInfrmtnConversation.CODE_STATUS_PEND_TEMP_APP
                                                                                                                                            .equals(status))
            && interestAgesExist && !licenseAgesExist && !isNonPrs) {
          setErrorMessage(Messages.SSM_FAD_INTEREST_AGE);
          checkAges = false;
          result = false;
        }
      } // end if not closure
    }

    // If Closing home, don't validate
    if (!isClosure) {
      if (!TRUE.equals(fieldsDisabled)) {
        // SIR 16052 reformatted. Error messages for Non-PRS homes are listed here.
        if (isNonPrs) {
          // if home is non-prs there must be a business address with vendor ID
          result &= correctBusinessAddressAndVendorId(cfad07so);

          // non-prs homes should have a marital status
          /*
           * if (maritalStatus.equals(StringHelper.EMPTY_STRING)) { setErrorMessage(Messages.MSG_FAD_NO_MAR_STATUS);
           * result = false; }
           */

          // if marital status is married, there should be two principal AP, one male, one female
          if (HomeInfrmtnConversation.CODE_MRTL_STATUS_MARRIED.equals(maritalStatus)
              && ArchitectureConstants.N.equals(indMarriedAP)) {
            setErrorMessage(Messages.MSG_FAD_TWO_AP_REQ);
            result = false;
          }

        } // end if it is a non-DFCS home

        // no interest checks for nonprs homes sir#18824
        if (!isNonPrs) {
          // Interest Age Range checks
          if (maleMinAgeInMonthInts != 0 && maleMaxAgeInMonthInts == 0) {
            setErrorMessage("selMaleMaxYearInt", Messages.MSG_MIN_MALE_RANGE_INTEREST);
            result = false;
          } else if (maleMinAgeInMonthInts == 0 && maleMaxAgeInMonthInts != 0) {
            setErrorMessage(M_MIN_YEAR_INT, Messages.MSG_MAX_MALE_RANGE_INTEREST);
            result = false;
          } else if (maleMinAgeInMonthInts > maleMaxAgeInMonthInts) {
            setErrorMessage(M_MIN_YEAR_INT, Messages.SSM_FAD_MIN_LESS_MAX);
            result = false;
          }

          if (femaleMinAgeInMonthInts != 0 && femaleMaxAgeInMonthInts == 0) {
            setErrorMessage("selFemaleMaxYearInt", Messages.MSG_MIN_FEMALE_RANGE_INTEREST);
            result = false;
          } else if (femaleMinAgeInMonthInts == 0 && femaleMaxAgeInMonthInts != 0) {
            setErrorMessage(F_MIN_YEAR_INT, Messages.MSG_MAX_FEMALE_RANGE_INTEREST);
            result = false;
          } else if (femaleMinAgeInMonthInts > femaleMaxAgeInMonthInts) {
            setErrorMessage(F_MIN_YEAR_INT, Messages.SSM_FAD_MIN_LESS_MAX);
            result = false;
          }
        }
        if (dtMarriage != null) {
          if (DateHelper.isAfter(dtMarriage, today)) {
            setErrorMessage(Messages.SSM_FAD_MARRIAGE_DATE);
            result = false;
          }
        }

        if ("01".equals(maritalStatus) && dtMarriage == null) {
          setErrorMessage(Messages.MSG_FAD_NO_MARRIAGE);
          result = false;
        }

      } // if not fields disabled

      /* HH: SIR# 18671: added bStatusIsChanged to the if condition */

      // JMC - SIR 19515 - We should always run the following checks on Save and
      // Save and Submit unless the home status precedes pending approval. I have
      // no idea why we the original code was checking what it was checking.
      if (!statusPrecedesPendingApproval && !holdPlaceChanged) {
        if (!HomeInfrmtnConversation.CODE_ADOPTIVE.equals(category) && !indEmergency && !indMedFragile
            && !indTherapeutic && !indSFC && !indRespite && !indBasic) {
          setErrorMessage(Messages.MSG_FAD_FOST_TYPE);
          result = false;
        }

        if (capacity == 0) {
          if (HomeInfrmtnConversation.CODE_STATUS_APPROVED_FULL_ACTIVE.equals(status) && !isOnHold && !holdPlaceChanged) {
            setErrorMessage(TXT_CAPACITY, Messages.MSG_ACTIVE_FULL_NO_HOME_CAPACITY);
            result = false;
          } else if (HomeInfrmtnConversation.CODE_STATUS_APPROVED_SPEC_ACTIVE.equals(status) && !isOnHold
                     && !holdPlaceChanged) {
            setErrorMessage(TXT_CAPACITY, Messages.MSG_ACTIVE_SPEC_NO_HOME_CAPACITY);
            result = false;
          } else if (HomeInfrmtnConversation.CODE_STATUS_APPROVED_FULL_ACTIVE_30_DAY.equals(status)) {
            setErrorMessage(TXT_CAPACITY, Messages.MSG_ACTIVE_FULL_NO_HOME_CAPACITY);
            result = false;
          } else if (HomeInfrmtnConversation.CODE_STATUS_APPROVED_SPEC_ACTIVE_30_DAY.equals(status)) {
            setErrorMessage(TXT_CAPACITY, Messages.MSG_ACTIVE_SPEC_NO_HOME_CAPACITY);
            result = false;
          } else if (HomeInfrmtnConversation.CODE_STATUS_APPROVED_TEMP_ACTIVE.equals(status) && !isOnHold
                     && !holdPlaceChanged) {
            setErrorMessage(TXT_CAPACITY, Messages.MSG_ACTIVE_TEMP_NO_HOME_CAPACITY);
            result = false;
          } else if (HomeInfrmtnConversation.CODE_STATUS_PEND_FULL_APP.equals(status)) {
            setErrorMessage(TXT_CAPACITY, Messages.MSG_PEND_FULL_NO_HOME_CAPACITY);
            result = false;
          } else if (HomeInfrmtnConversation.CODE_STATUS_PEND_SPEC_APP.equals(status)) {
            setErrorMessage(TXT_CAPACITY, Messages.MSG_PEND_SPEC_NO_HOME_CAPACITY);
            result = false;
          } else if (HomeInfrmtnConversation.CODE_STATUS_PEND_FULL_APP_30_DAY.equals(status)) {
            setErrorMessage(TXT_CAPACITY, Messages.MSG_PEND_FULL_NO_HOME_CAPACITY);
            result = false;
          } else if (HomeInfrmtnConversation.CODE_STATUS_PEND_SPEC_APP_30_DAY.equals(status)) {
            setErrorMessage(TXT_CAPACITY, Messages.MSG_PEND_SPEC_NO_HOME_CAPACITY);
            result = false;
          } else if (HomeInfrmtnConversation.CODE_STATUS_PEND_TEMP_APP.equals(status)) {
            setErrorMessage(TXT_CAPACITY, Messages.MSG_PEND_TEMP_NO_HOME_CAPACITY);
            result = false;
          }
        }

        if (checkAges) {
          // MR-075 Added the approved and pending 30 day grace statuses.
          // Validate on Approved status only if Hold Placement checkbox is selected.
          // if status is Approved (full, specail and temporary) Active,
          // or Pending (full, special and temporary)Approval, age range becomes required
          if ((!holdPlaceChanged && (HomeInfrmtnConversation.CODE_STATUS_APPROVED_FULL_ACTIVE.equals(status)
                                     || HomeInfrmtnConversation.CODE_STATUS_APPROVED_SPEC_ACTIVE.equals(status) || HomeInfrmtnConversation.CODE_STATUS_APPROVED_TEMP_ACTIVE
                                                                                                                                                                           .equals(status)))
              || HomeInfrmtnConversation.CODE_STATUS_APPROVED_FULL_ACTIVE_30_DAY.equals(status)
              || HomeInfrmtnConversation.CODE_STATUS_APPROVED_SPEC_ACTIVE_30_DAY.equals(status)
              || HomeInfrmtnConversation.CODE_STATUS_PEND_FULL_APP.equals(status)
              || HomeInfrmtnConversation.CODE_STATUS_PEND_SPEC_APP.equals(status)
              || HomeInfrmtnConversation.CODE_STATUS_PEND_FULL_APP_30_DAY.equals(status)
              || HomeInfrmtnConversation.CODE_STATUS_PEND_SPEC_APP_30_DAY.equals(status)
              || HomeInfrmtnConversation.CODE_STATUS_PEND_TEMP_APP.equals(status)) {

            // MR-075 For DFCS and non-DFCS home licensing age range is required
            if (maleMinAgeInMonths == 0 && maleMaxAgeInMonths == 0 && femaleMinAgeInMonths == 0
                && femaleMaxAgeInMonths == 0) {
              setErrorMessage(M_MAX_YEAR, Messages.MSG_FAD_AGE_REQ);
              // HD 6/10/2003 -- Just return, to prevent all the following errors
              return false;
            }

            // Licensing Age Range Checks
            if (maleMinAgeInMonths != 0 && maleMaxAgeInMonths == 0) {
              setErrorMessage(M_MAX_YEAR, Messages.MSG_MIN_MALE_RANGE);
              result = false;
            } else if (maleMinAgeInMonths == 0 && maleMaxAgeInMonths != 0) {
              setErrorMessage(M_MIN_YEAR, Messages.MSG_MAX_MALE_RANGE);
              result = false;
            } else if (maleMinAgeInMonths > maleMaxAgeInMonths) {
              setErrorMessage(M_MIN_YEAR, Messages.SSM_FAD_MIN_LESS_MAX);
              result = false;
            }

            if (femaleMinAgeInMonths != 0 && femaleMaxAgeInMonths == 0) {
              setErrorMessage("selFemaleMaxYear", Messages.MSG_MIN_FEMALE_RANGE);
              result = false;
            } else if (femaleMinAgeInMonths == 0 && femaleMaxAgeInMonths != 0) {
              setErrorMessage(F_MIN_YEAR, Messages.MSG_MAX_FEMALE_RANGE);
              result = false;
            } else if (femaleMinAgeInMonths > femaleMaxAgeInMonths) {
              setErrorMessage(F_MIN_YEAR, Messages.SSM_FAD_MIN_LESS_MAX);
              result = false;
            }

            // MR-075 For DFCS home, interest age range AND license age range is required
            // and approval age range need to fall within interest age range.
            if (!isNonPrs) {
              // License/Interest Age Range checks
              // Max interest age greater than max approved age (Only check this if status is higher
              // than Applicant OR Approved ages have been entered.)
              if ((licenseAgesExist && interestAgesExist) || !statusPrecedesPendingApproval) {
                // ochumd sir #18802 - "Min Year - The Max Interest Age must be less
                // than or equal to the Max Approved Age." should be linking to Max Year.
                if (maleMaxAgeInMonths > 0) {
                  if (maleMaxAgeInMonthInts < maleMaxAgeInMonths) {
                    setErrorMessage(M_MAX_YEAR_INT, Messages.SSM_FAD_MAX_GTR_APVD);
                    result = false;
                  }
                }
                if (femaleMaxAgeInMonths > 0) {
                  if (femaleMaxAgeInMonthInts < femaleMaxAgeInMonths) {
                    setErrorMessage(F_MAX_YEAR_INT, Messages.SSM_FAD_MAX_GTR_APVD);
                    result = false;
                  }
                }
                // Min interest age greater than max approved age
                if (maleMaxAgeInMonths > 0) {
                  if (maleMinAgeInMonthInts > maleMaxAgeInMonths) {
                    setErrorMessage(M_MIN_YEAR_INT, Messages.SSM_FAD_MIN_GTR_APVD);
                    result = false;
                  }
                }

                // Min interest age greater than max approved age
                if (femaleMaxAgeInMonths > 0) {
                  if (femaleMinAgeInMonthInts > femaleMaxAgeInMonths) {
                    setErrorMessage(F_MIN_YEAR_INT, Messages.SSM_FAD_MIN_GTR_APVD);
                    result = false;
                  }
                }

                // Max Interest age less than min approved age
                if (maleMaxAgeInMonthInts != 0) {
                  if (maleMaxAgeInMonthInts < maleMinAgeInMonths) {
                    setErrorMessage(M_MIN_YEAR_INT, Messages.SSM_FAD_MAX_LESS_APVD);
                    result = false;
                  }
                }
                // Max Interest age less than min approved age
                if (femaleMaxAgeInMonthInts != 0) {
                  if (femaleMaxAgeInMonthInts < femaleMinAgeInMonths) {
                    setErrorMessage(F_MIN_YEAR_INT, Messages.SSM_FAD_MAX_LESS_APVD);
                    result = false;
                  }
                }
                // Min Interest age greater than min approved age
                if (maleMinAgeInMonthInts != 0) {
                  if (maleMinAgeInMonthInts > maleMinAgeInMonths) {
                    setErrorMessage(M_MIN_YEAR_INT, Messages.SSM_FAD_MIN_LESS_APVD);
                    result = false;
                  }
                }
                // Min Interest age greater than min approved age
                if (femaleMinAgeInMonthInts != 0) {
                  if (femaleMinAgeInMonthInts > femaleMinAgeInMonths) {
                    setErrorMessage(F_MIN_YEAR_INT, Messages.SSM_FAD_MIN_LESS_APVD);
                    result = false;
                  }
                }
              } // end if higher than applicant OR license ages exist
            } // end dfcs home
          } // end if !HoldPlaceChanged or pending statuses
        } // end if checkAges
      } // end !statusPrecedesPendingApproval && !holdPlaceChanged
    } // end if not closure

    /* SIR# 23327. added sCertifyEntity condition & error message */
    // Required for non-DFCS home
    if ((this.isButtonPressed("btnApprvlStatus") && isApprover) || this.isButtonPressed("btnSaveSubmit")
        || this.isButtonPressed("btnSave1")) {
      if (isNonPrs && !isClosure && StringHelper.EMPTY_STRING.equals(sCertifyEntity)) {
        setErrorMessage(Messages.MSG_CERTIFY_ENTITY_REQ);
        result = false;
      }
    }

    // SIR 22684 - If status not INQUIRY/CLOSED and no Primary Phone exists, display error message.
    boolean primaryPhoneExists = false;
    String selSzCdFacilPhoneType = "";
    ROWCFAD07SOG00_ARRAY phoneArray = new ROWCFAD07SOG00_ARRAY();
    // if(cfad07so.getROWCFAD07SOG00_ARRAY() != null)
    // {
    phoneArray = cfad07so.getROWCFAD07SOG00_ARRAY();
    // }
    if (!HomeInfrmtnConversation.CODE_STATUS_INQUIRY.equals(status)
        && !HomeInfrmtnConversation.CODE_STATUS_PENDING_CLOSURE.equals(status)
        && !HomeInfrmtnConversation.CODE_STATUS_CLOSED.equals(status)) {
      for (int phoneIndex = 0; phoneIndex < (phoneArray.getROWCFAD07SOG00Count()); phoneIndex++) {
        ROWCFAD07SOG00 phoneRow = new ROWCFAD07SOG00();
        phoneRow = phoneArray.getROWCFAD07SOG00(phoneIndex);
        selSzCdFacilPhoneType = phoneRow.getSzCdFacilPhoneType();
        if (selSzCdFacilPhoneType.equals(HomeInfrmtnConversation.CODE_PHONE_TYPE_PRIMARY)) {
          primaryPhoneExists = true;
        }
      }
      if (!primaryPhoneExists) {
        setErrorMessage(Messages.MSG_FAD_REQ_PRIMARY_PHONE);
        result = false;
      }
      // }
    }// end SIR 22684

    // User has a home of type Adopt, Foster/Adopt, or Relative Adopt
    // and chose Marital status as Separated.
    if ((category.equals(CodesTables.CFACATEG_D) || category.equals(CodesTables.CFACATEG_A) || category
                                                                                                       .equals(CodesTables.CFACATEG_L))
        && (maritalStatus.equals(CodesTables.CFAMSTRC_07) || maritalStatus.equals(CodesTables.CFAMSTRC_09))) {
      setErrorMessage(Messages.MSG_FAD_MARITAL_NOT_FOR_ADO);
      result = false;
    }

    // SMS #81140: MR-074 Force user to choose another Marital Status if Unmarried Couple still exists
    if (maritalStatus.equals(CodesTables.CFAMSTRC_19)) {
      setErrorMessage(Messages.MSG_FAD_MARITAL_STATUS_INVALID);
      result = false;
    }

    // MR-075 Medical and Record Check requirements for submitting/approving home
    // if apprvlEndDt == null then don't do the following validation, previous validation will kick in
    if(apprvlEndDt != null){
      // Sync based on data currently persisted in database, not what currently entered on page.
      // Approval End Date may just currently entered on page, therefore sync service will not
      // calculate the due date for GCIC, NCIC, or Medical just yet.
      resource.syncResourceHhMbrsFaPersonDtl(GlobalData.getUlIdResource(request));
      RetrieveResourceHouseholdMembersSO retrieveResourceHouseholdMembersSO = resource.retrieveResourceHouseholdMembers(GlobalData.getUlIdResource(request));

      List<Integer> resourceHouseholdMembersList = retrieveResourceHouseholdMembersSO.getResourceHouseholdMembers();

      if ((HomeInfrmtnConversation.CODE_STATUS_PEND_FULL_APP.equals(status)
           || HomeInfrmtnConversation.CODE_STATUS_PEND_SPEC_APP.equals(status) || HomeInfrmtnConversation.CODE_STATUS_PEND_TEMP_APP.equals(status))
          && (isButtonPressed("btnSaveSubmit") || (isApprover && isButtonPressed("btnApprvlStatus")))
          && (resourceHouseholdMembersList != null && !resourceHouseholdMembersList.isEmpty())) {

          Iterator<Integer> itRsrcHhMbr = resourceHouseholdMembersList.iterator();
          boolean isMedicalNotCurrent = false;
          
          while(itRsrcHhMbr.hasNext()){
            Integer idPerson = itRsrcHhMbr.next();
            CCFC37SI ccfc37si = new CCFC37SI();
            ccfc37si.setUlIdPerson(idPerson.intValue());
            
            if(idPerson != null){
              CCFC37SO ccfc37so = personEjb.retrievePersonDTL(ccfc37si);
              
              if(ccfc37so.getUlIdPerson() > 0){
                String indAnnualMed = ccfc37so.getBIndAnnualMed();
                
                if(ccfc37so.getDtDtLastMed() == null){
                  // all resource household member need at least one medical done
                  isMedicalNotCurrent = true;
                }else if(StringHelper.toBooleanSafe(indAnnualMed)){
                  // only FA person with annual medical checkbox selected would have a due date
                  Date YearFromLastMedDt = DateHelper.addToDate(ccfc37so.getDtDtLastMed(),1,0,0);
                  Calendar calMedDueDate = Calendar.getInstance();
                  // set due date to set year from last med
                  calMedDueDate.setTime(YearFromLastMedDt);
                  
                  // set due date with new approval end date month/day value
                  calMedDueDate.set(Calendar.MONTH, apprvlEndDt.getMonth()-1);
                  calMedDueDate.set(Calendar.DAY_OF_MONTH, apprvlEndDt.getDay());
                  
                  // compare new due date against new approval end date
                  if(calMedDueDate.getTime().compareTo(DateHelper.toJavaDate(apprvlEndDt)) < 0){
                    isMedicalNotCurrent = true;
                  }
                }
              }
            }
          }

          if(isMedicalNotCurrent){
            setErrorMessage(Messages.MSG_FAD_MEDICAL_NOT_CURRENT);
            result = false;
          }
      }
  
      if ((HomeInfrmtnConversation.CODE_STATUS_PEND_FULL_APP.equals(status)
           || HomeInfrmtnConversation.CODE_STATUS_PEND_SPEC_APP.equals(status) || HomeInfrmtnConversation.CODE_STATUS_PEND_TEMP_APP.equals(status))
          && (isButtonPressed("btnSaveSubmit")  || (isApprover && isButtonPressed("btnApprvlStatus")))
          && (resourceHouseholdMembersList != null && !resourceHouseholdMembersList.isEmpty())) {
          
          Iterator<Integer> itRsrcHhMbr = resourceHouseholdMembersList.iterator();
          boolean isGcicNcicNotCurrent = false;
          
          while(itRsrcHhMbr.hasNext()){
            Integer idPerson = itRsrcHhMbr.next();
            CCFC37SI ccfc37si = new CCFC37SI();
            ccfc37si.setUlIdPerson(idPerson.intValue());
            
            if(idPerson != null){
              CCFC37SO ccfc37so = personEjb.retrievePersonDTL(ccfc37si);
              
              if(ccfc37so.getUlIdPerson() > 0){
                Date lastGcicRc = ccfc37so.getDtDtLastGcicRc();
                Date lastNcicRc = ccfc37so.getDtDtLastNcicRc();
                
                if( lastGcicRc != null && lastNcicRc != null){
                  Date year5LastGcicRc = DateHelper.addToDate(ccfc37so.getDtDtLastGcicRc(),5,0,0);
                  Date year5LastNcicRc = DateHelper.addToDate(ccfc37so.getDtDtLastNcicRc(),5,0,0);

	                Calendar calGcicDueDate = Calendar.getInstance();
	                Calendar calNcicDueDate = Calendar.getInstance();
	                // set time for the year
	                calGcicDueDate.setTime(year5LastGcicRc);
	                calNcicDueDate.setTime(year5LastNcicRc);
	                
	                // set due date with new approval end date month/day value
	                calGcicDueDate.set(Calendar.MONTH, apprvlEndDt.getMonth()-1);
	                calGcicDueDate.set(Calendar.DAY_OF_MONTH, apprvlEndDt.getDay());
	                calNcicDueDate.set(Calendar.MONTH, apprvlEndDt.getMonth()-1);
	                calNcicDueDate.set(Calendar.DAY_OF_MONTH, apprvlEndDt.getDay());
	                
	                // check if 5 year would lapse by the calculated due date.
	                // if not then increment calculated due date by one year.
	                // the deciding factor here is when the month and day fall.
	                if(year5LastGcicRc.compareTo(calGcicDueDate.getTime()) > 0){
	                  // if new approval end cause 5 year period to not lapse then
	                  // new due date will have an additional year
	                  calGcicDueDate.add(Calendar.YEAR, 1);
	                }
	                if(year5LastNcicRc.compareTo(calNcicDueDate.getTime()) > 0){
	                  // if new approval end cause 5 year period to not lapse then
	                  // new due date will have an additional year
	                  calNcicDueDate.add(Calendar.YEAR, 1);
	                }
	                
	                // compare new due date against new end date
	                if(calGcicDueDate.getTime().compareTo(DateHelper.toJavaDate(apprvlEndDt)) < 0){
	                  isGcicNcicNotCurrent = true;
	                }
	                if(calNcicDueDate.getTime().compareTo(DateHelper.toJavaDate(apprvlEndDt)) < 0){
	                  isGcicNcicNotCurrent = true;
	                }
                }else{
                  // lastGcicRc is null OR lastNcicRc is null
                  isGcicNcicNotCurrent = true;
                }
              }
            }
        }
  
        if(isGcicNcicNotCurrent){
          setErrorMessage(Messages.MSG_FAD_GCIC_NCIC_NOT_CURRENT);
          result = false;
        }
      }
    } // end if apprvlEndDt != null

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    return result;
  }

  private boolean hasFamTypeChanged(String[] checkboxValues, String oldValues) {
    int index = 0;
    int size = 0;
    while (index < checkboxValues.length) {
      size += checkboxValues[index].length();
      index++;
    }
    if (size != oldValues.length()) {
      return true;
    }
    index = 0;
    while (index < checkboxValues.length) {
      if (oldValues.indexOf(checkboxValues[index]) == -1) {
        return true;
      }
      index++;
    }
    return false;
  }

  private boolean correctBusinessAddressAndVendorId(CFAD07SO cfad07so) {
    boolean result = true;
    boolean vendorIDExists = false;
    boolean businessAddressExists = false;
    // ochumd sir#18815 -Non-PRS Adoptive home must enter Business address
    // and Vendor ID before the home can be Saved & Assigned.
    ROWCFAD07SOG01_ARRAY addressList = cfad07so.getROWCFAD07SOG01_ARRAY();
    Enumeration addressEnumeration = addressList.enumerateROWCFAD07SOG01();
    if (addressEnumeration != null) {
      ROWCFAD07SOG01 addressRow;
      while (addressEnumeration.hasMoreElements()) {
        addressRow = (ROWCFAD07SOG01) addressEnumeration.nextElement();
        String vendorID = addressRow.getSzNbrRsrcAddrVid();
        String businessAddress = addressRow.getSzAddrRsrcAddrStLn1();
        if (HomeInfrmtnConversation.CODE_ADDR_TYPE_BUS.equals(addressRow.getSzCdRsrcAddrType()) && !"".equals(vendorID)) {
          vendorIDExists = true;
        }

        if (HomeInfrmtnConversation.CODE_ADDR_TYPE_BUS.equals(addressRow.getSzCdRsrcAddrType())
            && !"".equals(businessAddress)) {
          businessAddressExists = true;
        }
      }
    }
    /*  if (businessAddressExists) {
        if (!vendorIDExists) {
          setErrorMessage(Messages.MSG_VID_REQ);
          result = false;
        }
      } else {
        setErrorMessage(Messages.MSG_VENDOR_ID_NUMBER);
        result = false;
      }*/
    return result;
  }
}