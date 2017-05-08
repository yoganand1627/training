package gov.georgia.dhr.dfcs.sacwis.web.intake;

import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.core.exception.RuntimeWrappedException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CallDcsnAUD;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CallEntryRtrvOut;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CallEntrySvcStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PersListRtrvStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PersListRtrvStruct_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.common.AddressBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.InputValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

/**
 * This class is used to perform the custom validation on Assigned Workload when the user attempts to Assign or Stage
 * Progress.
 * 
 * @author Jenn M Casdorph 11/25/2002 <p/> Change History: Date User Description -------- -----------
 *         ---------------------------------------------- 10/14/03 CORLEYAN SIR 19857 -- ContextHelper.get... replaces
 *         getInputValue(), removed InputValidation.UNSPECIFIED_INPUT_FIELD removed message lookup.
 *  
 *  <pre>
 *************Change History***************************************************
 *
 *  Date        User              Description
 *  03/14/2008  arege             Validation : Approval Status button
 *                                Condition  : Under the Special Call Type  section the Non Incident Request  
 *                                type is not selected. An error message is displayed as 
 *                                The intake must be marked as Non-Incident Request to Submit or Approve from the Intake Information page.
 * 
 *  03/28/2008  schoi			  STGAP00003968 - Restored a validation state for deleting a person 
 *							      when the person is a Reporter. Restored two String variables,
 *							      infoRefrl and spclReq for the validation state. Updated error messages
 *							      to clarify delete function for a related person.
 *
 *  04/07/2008  schoi			  STGAP00003968 - Updated error messages in accordance with database changes. 
 *  05/04/2010  bgehlot           SMS#51977: MSG_FACILITY_SEARCH displays when user do not enter resource id.
 *  06/24/2010  bgehlot           SMS#59296: MSG_FACILITY_SEARCH displays only when user does not enter the Provider Name
 *							      
 *	</pre>
 */
public class CallInformationCustomValidation extends FormValidation {
  /**
   * <p>
   * This method contains custom validation that is checked when the user completes an action on the Call Information
   * page. Actions include:
   * </p>
   * <p>
   * Error Message Summaries are as follows:
   * </p>
   * <blockquote>
   * <ol>
   * <li>Multiple Modify of Related Person</li>
   * <li>Missing Address Type in Call Entry</li>
   * <li>Missing Phone Type in Call Entry</li>
   * <li>Missing Phone in Call Entry</li>
   * <li>Facility Search w/o Name and Type</li>
   * <li>Special Request and I&R Info Entered</li>
   * <li>Incoming Program Type w/o Special Request Type</li>
   * <li>Special Request Type w/o Incoming Program Type</li>
   * <li>Assign or Close with Closure Code Entered</li>
   * <li>Selected delete, new using, view search, unrelate with multiple rows selected</li>
   * <li>Selected delete, new using, view search, unrelate, or detail with no rows selected</li>
   * <li>Delete Person marked as reporter (and case is not an IR or NCRSR)</li>
   * <li>Unrelate clicked for person who has not been related</li>
   * <li>Delete Person that has been related into the stage</li>
   * <li>Assign a CRSR without the SEC_ASSIGN_INTAKE_DIRECT security attribute</li>
   * </ol>
   * </blockquote
   * 
   * @return result - Returns false if the data fails validation. Returns true if the data passes validation.
   */
  
  
  protected boolean validateForm() {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".validationForm()");

    BaseSessionStateManager state = super.getState();
    HttpServletRequest request = this.getRequest();

    boolean result = true;

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

    String[] checkedValues = CheckboxHelper.getCheckedValues(request, "cbxPerson");
  //  String disposition = ContextHelper.getStringSafe(request, "selSzCdDisp"); //Ash

    boolean bMultipleDetail = (checkedValues.length > 1) ? true : false;
    boolean bClose = (super.isButtonPressed("btnSaveAndClose") || super.isButtonPressed("btnSaveAndClose1"));
    boolean bAssign = (super.isButtonPressed("btnSaveAndAssign") || super.isButtonPressed("btnSaveAndAssign1"));
    // boolean bFacilitySearch = (super.isButtonPressed("btnFacilitySearch"));
    boolean bDelete = super.isButtonPressed("btnDeleteFromList");
    boolean bNewUsing = super.isButtonPressed("btnNewUsing");
    boolean bViewSearch = super.isButtonPressed("btnViewSearch");
    boolean bUnrelate = super.isButtonPressed("btnUnrelate");
    boolean bDetail = super.isButtonPressed("btnDetail");
    boolean bFacilitySearch = super.isButtonPressed("btnFacilitySearch");
    
    boolean bSaveAndSubmit = (super.isButtonPressed("btnSaveAndSubmit") || super.isButtonPressed("btnSaveAndSubmit1"));
    boolean bApprovalStatus = super.isButtonPressed("btnApprovalStatusFinal"); //ash
    //ash
    boolean approvalMode = false;
    if (GlobalData.isApprovalMode(request)) {
      approvalMode = true;
    }
    //ash

    PersListRtrvStruct_ARRAY personListArray = (PersListRtrvStruct_ARRAY) state
                                                                               .getAttribute(
                                                                                             "PersListRtrvStruct_ARRAY",
                                                                                             request);
    if (personListArray == null) {
      personListArray = new PersListRtrvStruct_ARRAY();
    }
    PersListRtrvStruct person = null;

    String infoRefrl = ContextHelper.getStringSafe(request, "selSzCdInfoAndRefrl");
    String spclReq = ContextHelper.getStringSafe(request, "selSzCdSpclReq");
    String programArea = ContextHelper.getStringSafe(request, "selSzCdStageClassification");
    String cdNonIncReqType = ContextHelper.getStringSafe(request, "selSzCdNonIncReqType");

    String classification = callDecisionData.getSzCdStageClassification();
    if (classification == null) {
      classification = "";
    }

    // //////////////////////////////////////////////////////////////////////////////
    // Error Message:
    //
    //
    // Condition: The user has attempted to save an address in the Call Entry
    // Section without specifying an Address Type.
    //
    // Validation State: Any time the form is submitted the user must save
    // //////////////////////////////////////////////////////////////////////////////
    AddressBean aapEntryBean = AddressBean.getFromRequest("callEntryAddress", request);
    if (aapEntryBean == null) {
      aapEntryBean = new AddressBean();
    }

    if (IntakeUtils.addressDataExists(aapEntryBean)
        && "".equals(ContextHelper.getStringSafe(request, "selSzCdIncmgAddrType"))) {
      // !!! need error code
      setErrorMessage("selSzCdIncmgAddrType", "You must enter an address type to save address information.");
      // MessageLookup.getMessageByNumber(Messages.MSG_DUPLICATE_RECORD));
      result = false;
    }

    // //////////////////////////////////////////////////////////////////////////////
    // Error Message:
    //
    //
    // Condition: The user has attempted to save a Phone Number or Ext. in the Call Entry
    // Section without specifying an Phone Type.
    //
    // Validation State: Any time the form is submitted the user must save
    // //////////////////////////////////////////////////////////////////////////////
    if ((!"".equals(ContextHelper.getStringSafe(request, "txtSzNbrIncomingCallerPhone")) || !""
                                                                                               .equals(ContextHelper
                                                                                                                    .getStringSafe(
                                                                                                                                   request,
                                                                                                                                   "txtSzNbrIncmgCallerExt")))
        && ("".equals(ContextHelper.getStringSafe(request, "selSzCdIncmgPhoneType")))) {
      setErrorMessage("selSzCdIncmgPhoneType", "You must enter a phone type to save phone information.");
      result = false;
    }

    // //////////////////////////////////////////////////////////////////////////////
    // Error Message:
    //
    //
    // Condition: The user has attempted to save a Phone Type in the Call Entry
    // Section without specifying a Phone Number.
    //
    // Validation State: Any time the form is submitted the user must save
    // //////////////////////////////////////////////////////////////////////////////
    if (!"".equals(ContextHelper.getStringSafe(request, "selSzCdIncmgPhoneType"))
        && "".equals(ContextHelper.getStringSafe(request, "txtSzNbrIncomingCallerPhone"))) {
      setErrorMessage("txtSzNbrIncomingCallerPhone", "You must enter a phone number to save a phone type.");
      result = false;
    }

    // //////////////////////////////////////////////////////////////////////////////
    // Error Message:
    //
    //
    // Condition: A Reporter Type in the Call Entry needs to be required for all intakes
    // EXCEPT Non-Incident request Types. If a Non-Incident request Type was not selected
    // then a reporter type is required
    //
    // Validation State: Save and Submit/Save and Close/Continue/Save
    // //////////////////////////////////////////////////////////////////////////////
    if ("".equals(ContextHelper.getStringSafe(request, "selszCdIncmgCallerInt"))
        && "".equals(ContextHelper.getStringSafe(request, "selSzCdNonIncReqType"))) {
      setErrorMessage("selszCdIncmgCallerInt",
                      "You must enter a Reporter Type if nothing was selected in the Non-Incident Request Type field.");
      result = false;
    }

    // //////////////////////////////////////////////////////////////////////////////
    // Error Message:
    //
    //
    // Condition: The user has attempted to save a Phone Ext in the Call Entry
    // Section without specifying a Phone Number.
    //
    // Validation State: Any time the form is submitted the user must save
    // //////////////////////////////////////////////////////////////////////////////
    if (!"".equals(ContextHelper.getStringSafe(request, "txtSzNbrIncmgCallerExt"))
        && "".equals(ContextHelper.getStringSafe(request, "txtSzNbrIncomingCallerPhone"))) {
      setErrorMessage("txtSzNbrIncomingCallerPhone", "You must enter a phone number to save a phone extension.");
      result = false;
    }

    // //////////////////////////////////////////////////////////////////////////////
    // Error Message:
    //
    //
    // Condition: The user is attempting to save the Call Information page
    // and has entered both Special Request and Information and Referral
    // data.
    //
    // Validation State: Save
    // //////////////////////////////////////////////////////////////////////////////
    // if (!"".equals(infoRefrl) && !"".equals(spclReq)) {
    // setErrorMessage(Messages.MSG_SPC_IR_EXCLUSIVE);
    // result = false;
    // }
    // //////////////////////////////////////////////////////////////////////////////
    // Error Message:
    //
    //
    // Condition: A Special Request Type requires a Program Type.
    //
    // Validation State: Save, Save and Assign, Save and Submit, and
    // Save and Close.
    // //////////////////////////////////////////////////////////////////////////////
    if (bSaveAndSubmit && !StringHelper.isValid(cdNonIncReqType)) {
      setErrorMessage("selSzCdNonIncReqType", Messages.MSG_ASSIGN_SUBMIT_SPCIR_ONLY);
      result = false;
    }
    
    
    ///////////////////////////////////////////////////////////////////////////////////
    // Validation : Approval Status button
    // Condition  : Under the Special Call Type  section the Non Incident Request  
    //              type is not selected. An error message is displayed as 
    //                              
    // The intake must be marked as Non-Incident Request to 
    // Submit or Approve from the Intake Information page.
    // 
    //////////////////////////////////////////////////////////////////////////////////
    
    if (approvalMode && bApprovalStatus && !StringHelper.isValid(cdNonIncReqType)) {
      setErrorMessage("selSzCdNonIncReqType", Messages.MSG_ASSIGN_SUBMIT_SPCIR_ONLY);
      result = false;
    }
       
    
    // //////////////////////////////////////////////////////////////////////////////
    // Error Message:
    //
    //
    // Condition: If the users presses the Save & Submit button from the Intake Information page.
    //
    // Validation State: Save and Submit, and
    // Save and Close.
    // //////////////////////////////////////////////////////////////////////////////
    if ("".equals(programArea)
        && (CodesTables.CNIRTYPE_IC.equals(cdNonIncReqType) || CodesTables.CNIRTYPE_NI.equals(cdNonIncReqType)
            || CodesTables.CNIRTYPE_PA.equals(cdNonIncReqType) || CodesTables.CNIRTYPE_PF.equals(cdNonIncReqType))) {
      setErrorMessage("selSzCdStageClassification", Messages.MSG_PRG_TYPE_REQ);
      result = false;
    }

    // //////////////////////////////////////////////////////////////////////////////
    // Error Message:
    //
    //
    // Condition: A program type requires that a special request type to be entered.
    //
    // Validation State: Save, Save and Assign, Save and Submit, and
    // Save and Close.
    // //////////////////////////////////////////////////////////////////////////////
    // if (!"".equals(programType) && "".equals(spclReq)) {
    // setErrorMessage("selCdIncomingProgramType", Messages.MSG_SPCL_REQ_REQ);
    // result = false;
    // }

    // //////////////////////////////////////////////////////////////////////////////
    // Error Message:
    //
    //
    // Condition: The user is attempting to multiple-modify a related person.
    //
    // Validation State: Mutliple Modify Call Person Detail
    // //////////////////////////////////////////////////////////////////////////////
    if (bMultipleDetail) {
      int multiIndex = 0;
      for (int i = 0; i < checkedValues.length; i++) {
        multiIndex = Integer.parseInt(checkedValues[i]);
        person = personListArray.getPersListRtrvStruct(multiIndex);
        if ((person.getSzCdStagePersSearchInd() != null)
            && (person.getSzCdStagePersSearchInd().equals(IntakeConstants.RELATED))) {
          // !!! need error code
          setErrorMessage("You cannot multi-select a related person.");
          // MessageLookup.getMessageByNumber(Messages.MSG_DUPLICATE_RECORD));
          result = false;
          break;
        }
      }
    }

    // //////////////////////////////////////////////////////////////////////////////
    // Error Message:
    //
    //
    // Condition: The user is attempting to perform a Facility Search without
    // first entering a facility name or selecting a facility type
    // to search on.
    //
    // Validation State: Facility Search
    // //////////////////////////////////////////////////////////////////////////////
    //SMS#51977 Added the condition for Resource ID. User can search only by resource ID
    //SMS#59296: MSG_FACILITY_SEARCH displays only when user does not enter the Provider Name
    if ((bFacilitySearch)
        && ("".equals(ContextHelper.getStringSafe(request, "txtResourceId"))) &&("".equals(ContextHelper.getStringSafe(request, "txtNmIncmgFacilNameSearch")))) {
      setErrorMessage(Messages.MSG_FACILITY_SEARCH);
      result = false;
    }

    // //////////////////////////////////////////////////////////////////////////////
    // Error Message:
    //
    //
    // Condition: The user is attempting to Save and Assign or Save and Close
    // and a Closure Code exists.
    // if ((this or this) and (this or (this and this) or this))
    //
    //
    // Validation State: Save and Assign and Save and Close
    // //////////////////////////////////////////////////////////////////////////////
    if ((bAssign || bClose)
        && (((CodesTables.CCPSPRTY_N).equals(callDecisionData.getSzCdStageCurrPriority()))
            || (((CodesTables.CCPSPRTY_N).equals(callDecisionData.getSzCdStageInitialPriority())) && (!(StringHelper
                                                                                                                    .isValid(callDecisionData
                                                                                                                                             .getSzCdStageCurrPriority())))) || (StringHelper
                                                                                                                                                                                             .isValid(callDecisionData
                                                                                                                                                                                                                      .getSzCdStageReasonClosed())))) {
      setErrorMessage(Messages.MSG_CLSR_CD_ASSIGN_CLOSE);
      result = false;
    }

    // //////////////////////////////////////////////////////////////////////////////
    // Error Message:
    //
    //
    // Condition: The user selected the New Using button, the Delete button,
    // the View Search button, or the Unrelate Button with multiple
    // rows selected.
    //
    // Validation State: Delete, New Using, View Search, Unrelate
    // //////////////////////////////////////////////////////////////////////////////
    if ((bDelete || bNewUsing || bViewSearch || bUnrelate) && (checkedValues.length > 1)) {
      // !!! need error code
      setErrorMessage(Messages.MSG_INT_MULTIPLE_ROWS);
      // MessageLookup.getMessageByNumber(Messages.MSG_DUPLICATE_RECORD));
      result = false;
    }

    // //////////////////////////////////////////////////////////////////////////////
    // Error Message:
    //
    //
    // Condition: The user selected the Delete button, the New Using button,
    // the View Search button, the Unrelate Button or the
    // Detail button without first selecting a row.
    //
    // Validation State: Delete, New Using, View Search, Unrelate, Detail
    // //////////////////////////////////////////////////////////////////////////////
    if ((bDelete || bNewUsing || bViewSearch || bUnrelate || bDetail) && (checkedValues.length == 0)) {
      // !!! need error code
      setErrorMessage(Messages.MSG_SELECT_ROW_ACTION);
      // MessageLookup.getMessageByNumber(Messages.MSG_DUPLICATE_RECORD));
      result = false;
    }

    // //////////////////////////////////////////////////////////////////////////////
    // Error Message:
    //
    //
    // Condition: User is attempting to unrelate a person that has not been related.
    // Note: We check to make sure the user has checked a row before
    // performing this check. If no row was selected, and the user
    // is attempting to unrelate - checkedValues[0] will throw an
    // array index out of bounds in this check.
    //
    // Validation State: Unrelate
    // //////////////////////////////////////////////////////////////////////////////
    if (checkedValues.length != 0) {
      if ((bUnrelate)
          && !((IntakeConstants.PERSON_IS_RELATED).equals(ContextHelper.getStringSafe(request, "hdnPersonRelated_"
                                                                                               + checkedValues[0])))) {
        setErrorMessage(Messages.MSG_ATTEMPT_UNRELATE_ON_UNRELATED);
        result = false;
      }
    }
    // //////////////////////////////////////////////////////////////////////////////
    // Error Message:
    //
    //
    // Condition: The user is attempting to delete a person marked as
    // a reporter* and the case is not an I&R of Non-Case
    // Related Special Request.
    // Note: We check to make sure the user has checked a row before
    // performing this check. If no row was selected, and the user
    // is attempting to delete - checkedValues[0] will throw an
    // array index out of bounds in this check.
    //
    // Validation State: Delete
    // //////////////////////////////////////////////////////////////////////////////

    if (checkedValues.length != 0) {
    	if (bDelete && !(StringHelper.isValid(infoRefrl) || (StringHelper.isValid(spclReq) 
    			&& spclReq.startsWith(IntakeConstants.NON_CASE_RELATED_PREFIX))) &&
    			((IntakeConstants.PERSON_IS_REPORTER).equals(
    					ContextHelper.getStringSafe(request, "hdnReporter_" + checkedValues[0])))) {
       				setErrorMessage(Messages.MSG_INT_DELETE_REPORTER);
       				result = false;
    				}
    }

    // //////////////////////////////////////////////////////////////////////////////
    // Error Message:
    //
    //
    // Condition: The user is attempting to delete a person who has been related
    // into the stage.
    // Note: We check to make sure the user has checked a row before
    // performing this check. If no row was selected, and the user
    // is attempting to delete - checkedValues[0] will throw an
    // array index out of bounds in this check.
    //
    //
    // Validation State: Delete
    // //////////////////////////////////////////////////////////////////////////////
    if (checkedValues.length != 0) {
      if (bDelete
          && ((IntakeConstants.PERSON_IS_RELATED).equals(ContextHelper.getStringSafe(request, "hdnPersonRelated_"
                                                                                              + checkedValues[0])))) {
        setErrorMessage(Messages.MSG_DELETE_RELATED);
        result = false;
      }
    }

    // //////////////////////////////////////////////////////////////////////////////
    // Error Message:
    //
    //
    // Condition: The user is attempting to perform a person search for a related person.
    // Note: We check to make sure the user has checked a row before
    // performing this check. If no row was selected, and the user
    // is attempting to delete - checkedValues[0] will throw an
    // array index out of bounds in this check.
    //
    //
    // Validation State: View Search
    // //////////////////////////////////////////////////////////////////////////////
    if (checkedValues.length != 0) {
      if (bViewSearch
          && ((IntakeConstants.PERSON_IS_RELATED).equals(ContextHelper.getStringSafe(request, "hdnPersonRelated_"
                                                                                              + checkedValues[0])))) {
        setErrorMessage(Messages.MSG_VIEW_SEARCH_4_RELATED);
        result = false;
      }
    }
    /*
     * JMC - 05/29/2003 - After revisiting this issue - Pete Deckinga was able to ascertain that the user does not in
     * fact need any security attributes to save and assign an I&R or SPC. I am leaving this code in, in the event that
     * this decision is again overturned. // JMC - SIR 16869 - Removed the code in the JSP that would disable the Assign //
     * button any time the user did not have the SEC_ASSIGN_INTAKE_DIRECT security // attribute (this was incorrectly
     * requested in SIR 17490). Added in this // validation check to make sure the user has the correct security if the
     * user // is attempting to directly assign a CPS Case Related Special Requets.
     * 
     * //////////////////////////////////////////////////////////////////////////////// // Error Message: // // //
     * Condition: The user is attempting to Save and Assign a Case Related // Special Request and they do not have the
     * SEC_ASSIGN_INTAKE_DIRECT // Security Attribute // // Validation State: Assign
     * //////////////////////////////////////////////////////////////////////////////// if (bAssign &&
     * programType.equals(CodesTables.CCLASS_CPS) && StringHelper.isValid(spclReq) &&
     * spclReq.startsWith(IntakeConstants.CASE_RELATED_SPECREQ_PREFIX) &&
     * !(user.hasRight(UserProfile.SEC_ASSIGN_INTAKE_DIRECT))) {
     * setErrorMessage(InputValidation.UNSPECIFIED_INPUT_FIELD, "You do not have the proper security to directly assign
     * CPS Intakes."); //MessageLookup.getMessageByNumber(Messages.MSG_SELECT_ROW_ACTION)); result = false; }
     */

    // //////////////////////////////////////////////////////////////////////////////
    // Error Message:
    //
    //
    // Condition: The user is saving a Call Date in the future.
    //
    // Validation State: Assign
    // //////////////////////////////////////////////////////////////////////////////
    try {
      org.exolab.castor.types.Date date = ContextHelper.getCastorDateSafe(request, "dtDtIncomingCall");
      String time = ContextHelper.getTimeSafe(request, "txtTmTmIncmgCall");
      java.util.Date javaDate = DateHelper.toJavaDate(date, time);
      if (javaDate.after(new java.util.Date())) {
        setErrorMessage(InputValidation.UNSPECIFIED_INPUT_FIELD, Messages.MSG_INT_DATE_IN_FUTURE);
        result = false;
      }
    } catch (ParseException ex) {
      throw new RuntimeWrappedException(ex);
    }

    /*
     * Error Message : You must choose a case name for intakes that are not I&R*
     * 
     */
    if (bSaveAndSubmit && StringHelper.isValid(cdNonIncReqType) && (callDecisionData.getSzNmStage() == null)
        && (!CodesTables.CNIRTYPE_IR.equals(cdNonIncReqType)) || (StringHelper.EMPTY_STRING).equals(callDecisionData.getSzNmStage())) {

      setErrorMessage(Messages.MSG_INT_CASE_NAME_NEEDED);
      result = false;
    }

    performanceTrace.exitScope();
    return result;
  }

  public static final String TRACE_TAG = "CallInformationCustomValidation";
}
