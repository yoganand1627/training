package gov.georgia.dhr.dfcs.sacwis.web.intake;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.person.RaceEthnicityBean;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CallDcsnAUD;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CallEntryRtrvOut;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CallEntrySvcStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PersListRtrvStruct;
import gov.georgia.dhr.dfcs.sacwis.web.common.AddressBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.person.RaceEthnicityHelper;
import org.exolab.castor.types.Date;

/*
 * Change History:
 *  Date      User      Description
 *  --------  --------  --------------------------------------------------
 * 07/13/04 ochumd       Sir 22934 - Replaced all references to cint19d with cint76d.
 * <pre>
 */

/**
 * <p>
 * This class validates data submitted from the Call Person Detail page.
 * </p>
 * <p/>
 * <p>
 * Error Message Summaries are as follows:
 * </p>
 * <blockquote>
 * <ol>
 * <li>Deleting Reporter and Intake is not an I&R or CRSR</li>
 * <li>Deleting a Person who has been related</li>
 * <li>Saving with only a middle name entered for Name Info</li>
 * <li>Saving an Address with no Address Type entered</li>
 * <li>Saving a DOB later than the Current Date</li>
 * <li>Saving a DOD later than the Current Date</li>
 * <li>Saving a DOB before the MINIMUM DATE OF BIRTH</li>
 * <li>Saving a DOB before the DOD</li>
 * <li>Saving a DOD without a DOB</li>
 * SIR 22811
 * <li>Saving a Phone Ext. without a Phone Number</li>
 * <li>Saving a Phone Number without a Phone Type</li>
 * <li>Nulling a previously entered Name (name deletions must be done on submodule)</li>
 * <li>Nulling a previously entered Address (address deletions must be done on submodule)</li>
 * <li>Nulling a previously entered Phone Number (phone deletions must be done on submodule)</li>
 * <li>Saving Person Type of COL and Role != No Role</li>
 * <li>Saving Marital Type Child Not APplicable and Age >= 18
 * </ol>
 * <p/> Specific fields can be entered once and not deleted directly from the Call Person Detail page. We use the
 * areFieldsDeleted() submethod to determine which (if any) fields have been entered previously and are now blank. If
 * data was retrieved for a field and the field is now blank, a boolean indicator will be set to true in the
 * deletedFields[] array at a specific index. Later in the validateForm() method checks are performed on the
 * deletedFields[] array and if the indicator is true an error message is set and the deletedFields[] array is passed to
 * the JSP. Onload of the JSP we cycle through the deletedFields[] array and check to see which fields the user
 * attempted to delete. These fields are then populated using the original retrieved values instead of the values (the
 * blank values) in the request.
 * 
 * @author Jenn M Casdorph 11/25/2002 <p/> Change History: Date User Description -------- -----------
 *         ---------------------------------------------- 10/14/03 CORLEYAN SIR 19857 -- ContextHelper.get... replaces
 *         getInputValue(), removed InputValidation.UNSPECIFIED_INPUT_FIELD removed message lookup. 4/5/2004 gerryc SIR
 *         22811 - added new error message if they try to save and they've entered a date of death but not date of
 *         birth. using MSG_DOB. 05/06/04 CORLEYAN SIR 22869 -- Make sure if the user has entered an Eth that a Race is
 *         entered, and vice versa
 */
public class CallPersonDetailCustomValidation extends FormValidation {
  /** @return result - Returns false if the data fails validation. Returns true if the data passes validation. */
  protected boolean validateForm() {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".validationForm()");

    BaseSessionStateManager state = super.getState();
    HttpServletRequest request = this.getRequest();

    RaceEthnicityBean reBean = new RaceEthnicityBean();

    CallEntryRtrvOut callEntryRtrvOut = (CallEntryRtrvOut) state.getAttribute("CallEntryRtrvOut", request);
    if (callEntryRtrvOut == null) {
      callEntryRtrvOut = new CallEntryRtrvOut();
    }
    CallEntrySvcStruct callEntryData = callEntryRtrvOut.getCallEntrySvcStruct();
    if (callEntryData == null) {
      callEntryData = new CallEntrySvcStruct();
    }

    CallDcsnAUD callDecisionData = callEntryRtrvOut.getCallDcsnAUD();
    if (callDecisionData == null) {
      callDecisionData = new CallDcsnAUD();
    }

    PersListRtrvStruct personListRow = (PersListRtrvStruct) state.getAttribute("personListRow", request);
    if (personListRow == null) {
      personListRow = new PersListRtrvStruct();
    }

    // Declare and Initialize String variables that will be used later in the method.
    String firstName = ContextHelper.getStringSafe(request, "txtSzNmNameFirst");
    String middleName = ContextHelper.getStringSafe(request, "txtSzNmNameMiddle");
    String lastName = ContextHelper.getStringSafe(request, "txtSzNmNameLast");
    String addressType = ContextHelper.getStringSafe(request, "selSzCdPersAddrLinkType");
    String phone = ContextHelper.getStringSafe(request, "txtLBNbrPhone");
    String phoneExt = ContextHelper.getStringSafe(request, "txtLNbrPhoneExtension");
    String phoneType = ContextHelper.getStringSafe(request, "selSzCdPhoneType");
    String persType = ContextHelper.getStringSafe(request, "selSzCdStagePersType");
    String persRole = ContextHelper.getStringSafe(request, "selSzCdStagePersRole");
    Date dateOfBirth = ContextHelper.getCastorDateSafe(request, "txtDateDtPersonBirth");
    Date dateOfDeath = ContextHelper.getCastorDateSafe(request, "txtDateDtPersonDeath");
    String stagePersRelInt = ContextHelper.getStringSafe(request, "selSzCdStagePersRelInt");
    AddressBean aapBean = AddressBean.getFromRequest(request);

    org.exolab.castor.types.Date minimumDate = new org.exolab.castor.types.Date();
    short century = (short) 18;
    short year = (short) 50;
    short month = (short) 1;
    short day = (short) 1;

    minimumDate.setYear(year);
    minimumDate.setMonth(month);
    minimumDate.setDay(day);
    minimumDate.setCentury(century);

    // Declare and Initialize Boolean variables that will be used later in the method.
    boolean result = true;
    boolean bDelete = super.isButtonPressed("btnDeleteFromDetail");
    boolean bSave = (super.isButtonPressed("btnSaveAndCopy") || super.isButtonPressed("btnContinue") || super
                                                                                                     .isButtonPressed("btnSaveCallPersonDetail"));
    boolean bMultipleSave = super.isButtonPressed("btnContinueMultiple");

    // SIR 18636 - JMC - Changed bPersonIsReporter to use ContextHelper instead of super.getInputValue()
    // as super.getInputValue() was not working correctly.
    boolean bPersonIsReporter = IntakeConstants.INDICATOR_YES
                                                             .equals(ContextHelper
                                                                                  .getStringSafe(request,
                                                                                                 "cbxBIndStagePersReporter"));
    boolean bPersonIsCaller = IntakeConstants.INDICATOR_YES.equals(ContextHelper.getStringSafe(request,
                                                                                               "hdnPersonIsCaller"));
    boolean bIandR = StringHelper.isValid(callEntryData.getSzCdInfoAndRefrl());
    boolean bNCRSR = (StringHelper.isValid(callEntryData.getSzCdSpclReq()) && (callEntryData.getSzCdSpclReq()
                                                                                                             .startsWith(IntakeConstants.NON_CASE_RELATED_PREFIX)));
    boolean bCRSR = (StringHelper.isValid(callEntryData.getSzCdSpclReq()) && (callEntryData.getSzCdSpclReq()
                                                                                                            .startsWith(IntakeConstants.CASE_RELATED_SPECREQ_PREFIX)));
    boolean bRegularINT = (!bIandR && !bNCRSR && !bCRSR);
    boolean[] deletedIndicators = areFieldsDeleted(personListRow);
    boolean bNewUsing = ("true".equals(ContextHelper.getStringSafe(request, "newUsing")));

    // //////////////////////////////////////////////////////////////////////////////
    // Error Message 1:
    //
    //
    // Condition: The user is attempting to delete a person marked as
    // a reporter* and the case is not an I&R of Non-Case
    // Related Special Request.
    //
    // Note: If the person is the caller the reporter checkbox is always
    // checked and disabled. Since a disabled checkbox does not submit
    // anything into the request we use the hidden field hdnPersonIsCaller
    // to check to see if the person is the caller and hence a reporter.
    // If hdnPersonIsCaller is "Y", this means the reporter checkbox is checked.
    //
    // Validation State: Delete
    // //////////////////////////////////////////////////////////////////////////////
    if (bDelete && (bPersonIsReporter || bPersonIsCaller) && !bIandR & !bNCRSR) {
      setErrorMessage(Messages.MSG_DEL_REPORTER);
      result = false;
    }

    /*
     * HANDLED ON THE JSP //////////////////////////////////////////////////////////////////////////////// // Error
     * Message 2: // // // Condition: The user is attempting to delete a person that has been related // into the stage. // //
     * Validation State: Delete //////////////////////////////////////////////////////////////////////////////// if
     * (bDelete && (personListRow.getSzCdStagePersSearchInd() != null ) &&
     * (personListRow.getSzCdStagePersSearchInd().equals(IntakeConstants.RELATED))) { setErrorMessage("You may not
     * delete a person that has been related into the stage.");
     * //MessageLookup.getMessageByNumber(Messages.MSG_DUPLICATE_RECORD)); result = false; }
     */
    // //////////////////////////////////////////////////////////////////////////////
    // Error Message 3:
    //
    //
    // Condition: The user is attempting to save a person with only a middle
    // name entered.
    //
    // Validation State: Save
    // //////////////////////////////////////////////////////////////////////////////
    if (bSave && (!"".equals(middleName)) && ("".equals(firstName)) && ("".equals(lastName))) {
      setErrorMessage(Messages.MSG_INT_MIDDLE_NAME_ONLY);
      result = false;
    }
    // //////////////////////////////////////////////////////////////////////////////
    // Error Message 4:
    //
    // Condition: The user is attempting to save an address and the Address Type
    // has not been entered.
    //
    // Validation State: Save and Multiple Save
    // //////////////////////////////////////////////////////////////////////////////
    if (aapBean == null) {
      aapBean = new AddressBean();
    }

    if ((bSave || bMultipleSave) && (IntakeUtils.addressDataExists(aapBean)) && ("".equals(addressType))) {
      setErrorMessage("selSzCdPersAddrLinkType", Messages.MSG_ADDR_TYPE_REQ);
      result = false;
    }
    // //////////////////////////////////////////////////////////////////////////////
    // Error Message 5:
    //
    // Condition: The user is attempting to save a Date of Birth that is later than the
    // current date.
    //
    // Validation State: Save
    // //////////////////////////////////////////////////////////////////////////////
    if (bSave && dateOfBirth != null && (DateHelper.isAfterToday(dateOfBirth))) {
      setErrorMessage("txtDateDtPersonBirth", Messages.MSG_INV_DT_BIRTH);
      result = false;
    }

    // //////////////////////////////////////////////////////////////////////////////
    // Error Message 6:
    //
    // Condition: The user is attempting to save a Date of Death that is later than the
    // current date.
    //
    // Validation State: Save
    // //////////////////////////////////////////////////////////////////////////////
    if (bSave && dateOfDeath != null && (DateHelper.isAfterToday(dateOfDeath))) {
      setErrorMessage("txtDateDtPersonDeath", Messages.MSG_INV_DT_DEATH_GT_TODAY);
      result = false;
    }
    // //////////////////////////////////////////////////////////////////////////////
    // Error Message 7:
    //
    // Condition: The user is attempting to save a Date of Birth that is before
    // the minimum date of birth 1/1/1850.
    //
    // Validation State: Save
    // //////////////////////////////////////////////////////////////////////////////
    if (bSave && dateOfBirth != null && (DateHelper.isBefore(dateOfBirth, minimumDate))) {
      setErrorMessage("txtDateDtPersonBirth", Messages.MSG_DT_BIRTH_BEFORE_MIN);
      result = false;
    }
    // //////////////////////////////////////////////////////////////////////////////
    // Error Message 8:
    //
    // Condition: The user is attempting to save a Date of Death that is before
    // the Date of Birth.
    //
    // Validation State: Save
    // //////////////////////////////////////////////////////////////////////////////
    if (bSave && dateOfBirth != null && dateOfDeath != null && (DateHelper.isBefore(dateOfDeath, dateOfBirth))) {
      setErrorMessage("txtDateDtPersonDeath", Messages.MSG_INV_DT_DEATH_LT_DT_BIRTH);
      result = false;
    }

    /*
     * New Error Message - SIR 22811 Condition: The user attempts to save a Date of Death but no Date of Birth
     * Validation State: Save
     */
    if (bSave && dateOfBirth == null && dateOfDeath != null) {
      setErrorMessage("txtDateDtPersonBirth", Messages.MSG_DOB);
      result = false;
    }

    // //////////////////////////////////////////////////////////////////////////////
    // Error Message 9:
    //
    //
    // Condition: The user is attempting to save a phone extension without entering
    // a phone number.
    //
    // Validation State: Save and Multiple Save
    // //////////////////////////////////////////////////////////////////////////////
    if ((bSave || bMultipleSave) && !("".equals(phoneExt)) && ("".equals(phone))) {
      setErrorMessage("txtLBNbrPhone", Messages.MSG_PHONE_NUM_REQ);
      result = false;
    }

    // //////////////////////////////////////////////////////////////////////////////
    // Error Message 10:
    //
    //
    // Condition: The user is attempting to save a phone number without entering
    // a phone type.
    //
    // Validation State: Save and Multiple Save
    // //////////////////////////////////////////////////////////////////////////////
    if ((bSave || bMultipleSave) && !("".equals(phone)) && ("".equals(phoneType))) {
      setErrorMessage("selSzCdPhoneType", Messages.MSG_PHONE_TYPE_REQ);
      result = false;
    }
    // //////////////////////////////////////////////////////////////////////////////
    // Error Message 11:
    //
    //
    // Condition: The user has saved name information previously for the person. Now,
    // the user is attempting to delete the name information directly from
    // the Call Person Detail page instead of using the Name History submodule.
    // Name deletion must be performed on the submodule because the name must
    // be end-dated.
    // If this is a new using, the user is allowed to delete name information since
    // it has never been saved before.
    // Validation State: Save and Multiple Save
    // //////////////////////////////////////////////////////////////////////////////
    if ((bSave || bMultipleSave) && (!bNewUsing) && deletedIndicators[IntakeConstants.NAME_INDEX]) {
      setErrorMessage(Messages.MSG_DEL_NAME_ON_SUB);
      result = false;
    }
    // //////////////////////////////////////////////////////////////////////////////
    // Error Message 12:
    //
    //
    // Condition: The user has saved address information previously for the person. Now,
    // the user is attempting to delete the address information directly from
    // the Call Person Detail page instead of using the Address List submodule.
    // Address deletion must be performed on the submodule because the address must
    // be end-dated.
    // If this is a new using, the user is allowed to delete address information since
    // it has never been saved before.
    //
    // Validation State: Save and Multiple Save
    // //////////////////////////////////////////////////////////////////////////////
    if ((bSave || bMultipleSave)
        && (!bNewUsing)
        && (deletedIndicators[IntakeConstants.ADDRESS_1_INDEX] || deletedIndicators[IntakeConstants.ADDRESS_2_INDEX]
            || deletedIndicators[IntakeConstants.CITY_INDEX] || deletedIndicators[IntakeConstants.STATE_INDEX]
            || deletedIndicators[IntakeConstants.ZIP_INDEX] || deletedIndicators[IntakeConstants.COUNTY_INDEX] || deletedIndicators[IntakeConstants.ADDRESS_TYPE_INDEX])) {
      setErrorMessage(Messages.MSG_DEL_ADDR_ON_SUB);
      result = false;
    }

    // //////////////////////////////////////////////////////////////////////////////
    // Error Message 13:
    //
    //
    // Condition: The user has saved phone information previously for the person. Now,
    // the user is attempting to save null for any of the phone fields
    // instead of using the Phone List submodule to delete phone history.
    // If ANY phone field was saved and is now blank this message will be displayed.
    // If this is a new using, the user is allowed to delete phone information since
    // it has never been saved before.
    //
    // Validation State: Save
    // //////////////////////////////////////////////////////////////////////////////
    if ((bSave && !bNewUsing)
        && (deletedIndicators[IntakeConstants.PHONE_INDEX] || deletedIndicators[IntakeConstants.PHONE_EXT_INDEX] || deletedIndicators[IntakeConstants.PHONE_TYPE_INDEX])) {
      setErrorMessage(Messages.MSG_DEL_PHONE_ON_SUB);
      result = false;
    }

    // //////////////////////////////////////////////////////////////////////////////
    // Error Message 14:
    //
    //
    // Condition: The user has entered a Person Type of COL and is attempting to
    // to save a value for Person Role other than "No Role"
    //
    // Validation State: Save
    // //////////////////////////////////////////////////////////////////////////////
    if ((bSave) && (persType.equals(CodesTables.CPRSNTYP_COL)) && (!persRole.equals(CodesTables.CINTROLE_NO))) {
      setErrorMessage("selSzCdStagePersRole", Messages.MSG_COL_NEEDS_NO_ROLE);
      result = false;
    }

    // //////////////////////////////////////////////////////////////////////////////
    // Error Message 15:
    //
    //
    // Condition: The user has entered "Child - not Applicable" for Marital type
    // and an age > = 18.
    //
    // Validation State: Save
    // //////////////////////////////////////////////////////////////////////////////
    int ageFromDOB = DateHelper.getAge(ContextHelper.getCastorDateSafe(request, "txtDateDtPersonBirth"));
    if (bSave && (CodesTables.CMARSTAT_CH.equals(ContextHelper.getStringSafe(request, "selSzCdPersonMaritalStatus")))
        && (17 < ContextHelper.getIntSafe(request, "txtLNbrPersonAge") || 17 < ageFromDOB)) {
      setErrorMessage("selSzCdPersonMaritalStatus", Messages.MSG_MARITAL_CHILD_18);
      result = false;
    }

    request.setAttribute("deletedIndicators", deletedIndicators);

    performanceTrace.exitScope();

    // //////////////////////////////////////////////////////////////////////////////
    // SIR 22869
    // Error Message 16:
    //
    // Condition: The user is attempting to save race with out ethnicity or vice versa
    //
    // Validation State: Save
    // //////////////////////////////////////////////////////////////////////////////
    if (bSave
        && ((RaceEthnicityHelper.isEthnicityChecked(request) && !RaceEthnicityHelper.isRaceChecked(request)) || (!RaceEthnicityHelper
                                                                                                                                     .isEthnicityChecked(request) && RaceEthnicityHelper
                                                                                                                                                                                        .isRaceChecked(request)))) {
      setErrorMessage(Messages.SSM_ETHNIC_AND_RACE);
      result = false;
    }

    // //////////////////////////////////////////////////////////////////////////////
    // Error Message 17:
    //
    //
    // Condition: If the user has selected Relatioship as primary caretaker(PK), then county must required.
    //
    //
    // Validation State: Save.
    // //////////////////////////////////////////////////////////////////////////////

    if ((bSave && CodesTables.CRELVICT_PK.equals(stagePersRelInt) && aapBean != null && ((aapBean.getCounty() == null) || (StringHelper.EMPTY_STRING
                                                                                                                                 .equals(aapBean
                                                                                                                                                .getCounty()))))) {
      setErrorMessage("addressCounty", Messages.MSG_INT_COUNTY_REQUD);
      result = false;
    }

    return result;
  }

  /**
   * This submethod sets the boolean indicator to true into the deletedIndicators array at if the field in question had
   * a value and is now null or blank.
   * 
   * @param personListRow
   * @return boolean
   */
  private boolean[] areFieldsDeleted(PersListRtrvStruct personListRow) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".validationForm()");
    HttpServletRequest request = this.getRequest();

    boolean[] deletedIndicators = { false, false, false, false, false, false, false, false, false, false, false };
    try {
      // NAME
      String retrievedFirst = FormattingHelper.formatString(personListRow.getSzNmNameFirst());
      String retrievedMiddle = FormattingHelper.formatString(personListRow.getSzNmNameMiddle());
      String retrievedLast = FormattingHelper.formatString(personListRow.getSzNmNameLast());

      String currentFirst = ContextHelper.getStringSafe(request, "txtSzNmNameFirst");
      String currentMiddle = ContextHelper.getStringSafe(request, "txtSzNmNameMiddle");
      String currentLast = ContextHelper.getStringSafe(request, "txtSzNmNameLast");

      // ADDRESS
      String retrievedAddress1 = FormattingHelper.formatString(personListRow.getSzAddrPersAddrStLn1());
      String retrievedAddress2 = FormattingHelper.formatString(personListRow.getSzAddrPersAddrStLn2());
      String retrievedCity = FormattingHelper.formatString(personListRow.getSzAddrCity());
      String retrievedState = FormattingHelper.formatString(personListRow.getSzCdAddrState());
      String retrievedZip = FormattingHelper.formatString(personListRow.getLAddrZip());
      String retrievedCounty = FormattingHelper.formatString(personListRow.getSzCdAddrCounty());
      String retrievedAddressType = FormattingHelper.formatString(personListRow.getSzCdPersAddrLinkType());

      AddressBean aapBean = AddressBean.getFromRequest(super.getRequest());

      if (aapBean == null) {
        aapBean = new AddressBean();
      }
      String currentAddress1 = FormattingHelper.formatString(aapBean.getAddress1());
      String currentAddress2 = FormattingHelper.formatString(aapBean.getAddress2());
      String currentCity = FormattingHelper.formatString(aapBean.getCity());
      String currentState = FormattingHelper.formatString(aapBean.getState());
      String currentZip = FormattingHelper.formatString(aapBean.getZip());
      String currentCounty = FormattingHelper.formatString(aapBean.getCounty());
      String currentAddressType = ContextHelper.getStringSafe(request, "selSzCdPersAddrLinkType");

      // PHONE
      String retrievedPhone = FormattingHelper.formatString(personListRow.getLNbrPhone());
      String retrievedExt = FormattingHelper.formatString(personListRow.getLNbrPhoneExtension());
      String retrievedPhoneType = FormattingHelper.formatString(personListRow.getSzCdPhoneType());

      String currentPhone = ContextHelper.getStringSafe(request, "txtLBNbrPhone");
      String currentExt = ContextHelper.getStringSafe(request, "txtLNbrPhoneExtension");
      String currentPhoneType = ContextHelper.getStringSafe(request, "selSzCdPhoneType");

      if (!("".equals(retrievedAddress1)) && ("".equals(currentAddress1))) {
        deletedIndicators[IntakeConstants.ADDRESS_1_INDEX] = true;
      }
      if (!("".equals(retrievedAddress2)) && ("".equals(currentAddress2))) {
        deletedIndicators[IntakeConstants.ADDRESS_2_INDEX] = true;
      }
      if (!("".equals(retrievedCity)) && ("".equals(currentCity))) {
        deletedIndicators[IntakeConstants.CITY_INDEX] = true;
      }
      if (!("".equals(retrievedState)) && ("".equals(currentState))) {
        deletedIndicators[IntakeConstants.STATE_INDEX] = true;
      }

      if (!("".equals(retrievedZip)) && ("".equals(currentZip))) {
        deletedIndicators[IntakeConstants.ZIP_INDEX] = true;
      }
      if (!("".equals(retrievedCounty)) && ("".equals(currentCounty))) {
        deletedIndicators[IntakeConstants.COUNTY_INDEX] = true;
      }
      if (!("".equals(retrievedAddressType)) && ("".equals(currentAddressType))) {
        deletedIndicators[IntakeConstants.ADDRESS_TYPE_INDEX] = true;
      }
      if (!("".equals(retrievedPhone)) && ("".equals(currentPhone))) {
        deletedIndicators[IntakeConstants.PHONE_INDEX] = true;
      }
      if (!("".equals(retrievedExt)) && ("".equals(currentExt))) {
        deletedIndicators[IntakeConstants.PHONE_EXT_INDEX] = true;
      }
      if (!("".equals(retrievedPhoneType)) && ("".equals(currentPhoneType))) {
        deletedIndicators[IntakeConstants.PHONE_TYPE_INDEX] = true;
      }
      if ((!("".equals(retrievedFirst)) || !("".equals(retrievedMiddle)) || !("".equals(retrievedLast)))
          && ("".equals(currentFirst) && "".equals(currentMiddle) && "".equals(currentLast))) {
        deletedIndicators[IntakeConstants.NAME_INDEX] = true;
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Deleted Indicators Threw an Exception: " + e.getMessage());
    }

    performanceTrace.exitScope();

    return deletedIndicators;
  }

  public static final String TRACE_TAG = "CallPersonDetailCustomValidation";
}
