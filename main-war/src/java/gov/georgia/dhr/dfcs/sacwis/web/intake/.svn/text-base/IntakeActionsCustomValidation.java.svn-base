package gov.georgia.dhr.dfcs.sacwis.web.intake;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CallEntryRtrvOut;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CallEntrySvcStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FacDetailEntStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FacilRtrvOutRec;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PersListRtrvStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PersListRtrvStruct_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT76DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT76DO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * This class is used to perform the custom validation on Intake Actions.
 *
 * @author Jenn M Casdorph 11/25/2002 <p/> Change History: Date User Description -------- -----------
 *         ---------------------------------------------- 10/14/03 CORLEYAN SIR 19857 -- ContextHelper.get... replaces
 *         getInputValue(), removed InputValidation.UNSPECIFIED_INPUT_FIELD removed message lookup. <p/> 10/11/04 Ochumd
 *         Sir 23115 A child under 10 years of age can not be designated as an APs for CPS, RCL and RCCL intakes. <p/>
 *         07/15/05 ochumd Sir 23711 For APS CRSR - there can not be more than one PRN with Role of Client (CL).
 *         07/20/05 ochumd Sir 23720 If a user checks the box for Tracking information for cases involving
 *         methamphetamine and fails to enter comments 08/01/05 ochumd Sir 23810 - Removed code for sir 23711 and used
 *         Dam instead. a message will display indicating that the comment field is required. 12/20/07 - hjbaptiste
 *         STGAP 6848 Modified so that a child under 18 years of age can not be designated as an APs for CPS, RCL and
 *         RCCL intakes if they are not the Primary Care taker(PK).
 *         04/14/08	schoi	   STGAP00008020 - Added 6 validations for Non-Incident Request types.
 *         					   Dispositions, Determination Factors and Response Time must empty
 *         					   when a Non-Incident Request type is selected.
 *
 *         06/12/2008  arege      STGAP00008693     If the supervisor changes the Current Response time while approving
 *                                                  the intake and leaves the Reason Change Field is empty an error
 *                                                  message should be displayed.
 *         06/15/08  vdevarak     STGAP00009181  -  Modified code for MR - 011.    
 *         07/29/2008  arege      STGAP00009236     User Should not be able to Save and Submit from the IntakeActions Page. 
 *                                                  Case Manager is Submitting the intake for approval , so we should not be 
 *                                                  checking for the Disposition field as he does not enter the disposition.   
 *         11/25/2008  arege      STGAP00010103     Modified the code so that the user could select SCO or SCR as disposition
 *                                                  in a case involving child death where there are no other children who are alive.
 *         01/05/2009  arege      STGAP00009957     Added method isAllegTypeOther to find out if the allegation is of type 'OTHER'
 *                                                  Modified conditions for displaying the error message MSG_INT_DETFAC_CMNTS_REQ
 *         01/28/2009  arege      STGAP00009957     Made changes as per peer review.    
 *         03/31/2009  arege      STGAP00010106     Modified code so that case Manager can modify the intake before it is approved.
 *         04/15/2009  bgehlot    STGAP00012588     Added new Message MSG_INT_REASON_DOD_REQ and MSG_INT_TYPE_REQ                                                 
 *         06/11/2009  hjbaptiste STGAP00010103 - Validate that if Child Death is selected as a Special Investigation, approver will not be
 *                                                allowed to screen out unless Accidental Death or Natural Cause is selected as a Reason of Death on Intake
 *                                                Person Detail 
 *         05/26/2010  hjbaptiste SMS#51977     - MR66-Maltreatment In Care: Added call to check and see if Maltreatment took
 *                                                place while the child was/is in DFCS custody and to see if child's placement is 'Trial Home Visit'
 *         06/25/2010  bgehlot    SMS 59572.      Message MSG_INT_REASON_DOD_REQ and MSG_INT_TYPE_REQ would display for Child Death in Care also. This is a new code for MR-066
 *         06/29/2010  hnguyen    SMS 59958       Retrieve facility info from FacilRtrvOutRec in state, for validation to work correctly.                                       
 *         06/30/2010  bgehlot    SMS# 60651      End dated the CD, SI and NF code and created CDNC, SINC and NFNC codes. Replaced the old ones with new ones.
 *         04/30/2011  cwells     SMS#101883      Corrected logic to allow Accidental Death and Natural cause intakes to be submitted.
 *         06/12/2011 llokhande   CAPTA 4.3       removed Trail Home Visit condition to determine Maltreatement In Care.
 *                                                Added new message 'MSG_INT_SPCL_INV_CALL_TYPE_REQ'
 *                                                Removed message 'MSG_INT_SPCL_INV_REQ'.
 *         07/12/2011  arege      SMS#114648      The message MSG_INT_SPCL_INV_CALL_TYPE_REQ should display if there exists a placement provider on intake information page irrespective of maltreatment in care.      
 */
public class IntakeActionsCustomValidation extends FormValidation {
  /**
   * <p/> This method contains custom validation that is checked when the user complete an action on the Call
   * Information page. Actions include:
   * </p>
   * <blockquote>
   * <ul>
   * <li>Save</li>
   * <li>Save and Submit</li>
   * <li>Save and Assign</li>
   * <li>Delete from Allegation List</li>
   * <li>View Allegation Detail</li>
   * <li>Add Allegation</li>
   * <li>Law Jurisdiction Search</li>
   * <li>Mark for Deletion</li>
   * <li>Delete Intake</li>
   * <li>Access Approval Status
   * </ul>
   *
   * @return result - Returns false if the data fails validation. Returns true if the data passes validation.
   */
  
  
  
  @SuppressWarnings( { "unchecked" })
  protected boolean validateForm() {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".validationForm()");

    HttpServletRequest request = this.getRequest();
    BaseSessionStateManager state = super.getState();
    boolean result = true;

    boolean bSubmit = (super.isButtonPressed("btnSubmit"));
    boolean bAssign = (super.isButtonPressed("btnAssign"));
    boolean bDeleteFromList = (super.isButtonPressed("btnDeleteFromList"));
    boolean bNewUsing = (super.isButtonPressed("btnNewUsingAlleg"));
    boolean bSave = super.isButtonPressed("btnSave");
    boolean bApproval = super.isButtonPressed("btnApprovalStatusFinal");
    ROWCINT76DO_ARRAY allegListArray = (ROWCINT76DO_ARRAY) state.getAttribute("allegListArray", request);
    PersListRtrvStruct intakePersonListRow = (PersListRtrvStruct) state.getAttribute("personListRow", request);
    if (intakePersonListRow == null) {
      intakePersonListRow = new PersListRtrvStruct();
    }
    // STGAP00007164: Need to count principal children to check if more than one child is involved
    // in a child death case.
    PersListRtrvStruct_ARRAY personListArray = (PersListRtrvStruct_ARRAY)state.getAttribute("PersListRtrvStruct_ARRAY", request);
    if (personListArray == null) {
      personListArray = new PersListRtrvStruct_ARRAY();
    }
    // Definition of child in this case is a PRINCIPAL under 18
    int principalChildCount = 0;
    int deadChildCount = 0;
    boolean isAccidentalDeath = false;
    boolean isNaturalCause = false;
    PersListRtrvStruct personRow;
    Enumeration e = personListArray.enumeratePersListRtrvStruct();
    boolean indAllegPerp = false;
    boolean indVictim = false;
    while (e.hasMoreElements()) {
      personRow = (PersListRtrvStruct) e.nextElement();
      int personRowAge = personRow.getLNbrPersonAge();
      String personRowType = personRow.getSzCdStagePersType();
      String personRole = personRow.getSzCdStagePersRole();
      //Per STGAP00010103 Added !DateHelper.isNull(personRow.getDtDtPersonBirth()) to the if statement
      // so that the persons with null DOB don't get added to the principalChildCount
      // 104353 removed !StringHelper.EMPTY_STRING.equals(personRow.getSzCdPersonDeath() condition.  Child Principal 
      // child should be included principalChildCount regardless of death status.  Value comes over as null anyway so condition was useless.  
      if ((!DateHelper.isNull(personRow.getDtDtPersonBirth()))|| (personRow.getSzCdPersonDeath() != null && !StringHelper.EMPTY_STRING.equals(personRow.getSzCdPersonDeath()))
                      && personRowAge < 18 && StringHelper.isValid(personRowType) && CodesTables.CPRSNTYP_PRN.equals(personRowType)) {
        principalChildCount++;
        if (DateHelper.isNull(personRow.getDtDtPersonDeath())==false) {
          // STGAP00010103: If user is attempting to approve the Intake, only allow Intake to be screened out if 
          // the Reason of Death is Accidental Death or Natural Cause.
          //104353 moving this inside if statement to only evaluate the children that that have passed. 
          isAccidentalDeath = (CodesTables.CRSNFDTH_ADH.equals(personRow.getSzCdPersonDeath()));
          isNaturalCause = (CodesTables.CRSNFDTH_NCE.equals(personRow.getSzCdPersonDeath()));
          deadChildCount++;
        }
      }
      //STGAP00009181 - Added the following two if conditions to see if there is atleast
      //one Principal with a role of Alleged Perpetrator and if there is atleast one Principal
      //with the role Victim
      if(CodesTables.CPRSNTYP_PRN.equals(personRowType) && CodesTables.CINTROLE_AP.equals(personRole)){
         indAllegPerp = true;
      }
      if(CodesTables.CPRSNTYP_PRN.equals(personRowType) && CodesTables.CINTROLE_VC.equals(personRole)){
        indVictim = true;
      }
    }
    //STGAP00009181 - if there is and there are no allegations recorded then display the message
    if(bSubmit && indAllegPerp && indVictim && (allegListArray == null || allegListArray.getROWCINT76DOCount() < 1)){
      setErrorMessage(Messages.MSG_INT_ALLEGATIONS_REQ);
      result = false;
    }
    String specInvest = ContextHelper.getStringSafe(request, "hdnSzCdSplInvest");

    CallEntryRtrvOut callEntryData = (CallEntryRtrvOut) request.getAttribute("CallEntryRtrvOut");

    if (callEntryData == null) {
      callEntryData = new CallEntryRtrvOut();
    }
    CallEntrySvcStruct entryInfo = callEntryData.getCallEntrySvcStruct();
    if (entryInfo == null) {
      entryInfo = new CallEntrySvcStruct();
    }
    
    FacilRtrvOutRec facilRtrvOutRec = (FacilRtrvOutRec) state.getAttribute("FacilRtrvOutRec", request);
    if (facilRtrvOutRec == null) {
      facilRtrvOutRec = new FacilRtrvOutRec();
    }
    FacDetailEntStruct facilityData = facilRtrvOutRec.getFacDetailEntStruct();
    if (facilityData == null) {
      facilityData = new FacDetailEntStruct();
    }
    
    String[] determinationFactors_PA = CheckboxHelper.getCheckedValues(request, "CPSdeterminationFactorsPA");
    List checkedFactors_PA = new ArrayList();
    checkedFactors_PA = Arrays.asList(determinationFactors_PA);
    String[] determinationFactors_NEG = CheckboxHelper.getCheckedValues(request, "CPSdeterminationFactorsNEG");
    List checkedFactors_NEG = new ArrayList();
    checkedFactors_NEG = Arrays.asList(determinationFactors_NEG);
    String[] determinationFactors_EA = CheckboxHelper.getCheckedValues(request, "CPSdeterminationFactorsEA");
    List checkedFactors_EA = new ArrayList();
    checkedFactors_EA = Arrays.asList(determinationFactors_EA);
    String[] determinationFactors_SA = CheckboxHelper.getCheckedValues(request, "CPSdeterminationFactorsSA");
    List checkedFactors_SA = new ArrayList();
    checkedFactors_SA = Arrays.asList(determinationFactors_SA);
    String[] determinationFactors_OTH = CheckboxHelper.getCheckedValues(request, "CPSdeterminationFactorsOTH");
    List checkedFactors_OTH = new ArrayList();
    checkedFactors_OTH = Arrays.asList(determinationFactors_OTH);
    String initialPriority = ContextHelper.getStringSafe(request, "selSzCdStageInitialPriority");
    //STGAP00009181 - Added code to check if there are determination factors
    //selected without comments in any section
    //Begin
    String paComments =ContextHelper.getStringSafe(request, "txtSzTxtPhyAbsCmnts");
    String negComments =ContextHelper.getStringSafe(request, "txtSzTxtNegAbsCmnts");
    String eaComments =ContextHelper.getStringSafe(request, "txtSzTxtEmAbsCmnts");
    String saComments =ContextHelper.getStringSafe(request, "txtSzTxtSxAbsCmnts");
    String othComments =ContextHelper.getStringSafe(request, "txtSzTxtOthCmnts");
    if(bSubmit && (determinationFactors_PA.length >0 && "".equals(paComments) ||
        determinationFactors_NEG.length >0 && "".equals(negComments) ||
          determinationFactors_EA.length >0 && "".equals(eaComments) ||
          determinationFactors_SA.length >0 && "".equals(saComments) 
           //Per STGAP00009957 commented out this condition as we do not need to display this message 
           // if there are no comments for determination factors of type 'OTHER' . but also check if there are 
           // either no allegations or allegation of type 'OTHER'
           // || determinationFactors_OTH.length >0 && "".equals(othComments)
          )){
            setErrorMessage(Messages.MSG_INT_DETFAC_CMNTS_REQ);
            result = false;
    }
    
    //STGAP00009957 Check if there is an allegation of type 'OTHER'
    boolean allegOther = isAllegTypeOther(allegListArray);
    
    if(bSubmit && determinationFactors_OTH.length >0 && StringHelper.EMPTY_STRING.equals(othComments) && allegListArray!= null && allegOther ){
      setErrorMessage(Messages.MSG_INT_DETFAC_CMNTS_REQ);
      result = false;
    }
    
    if(bSubmit && determinationFactors_OTH.length >0 && StringHelper.EMPTY_STRING.equals(othComments) && (allegListArray == null || allegListArray.getROWCINT76DOCount()<1)){
      setErrorMessage(Messages.MSG_INT_DETFAC_CMNTS_REQ);
      result = false;
    }
 
    if( bSubmit && !ValidateResponseTimes(checkedFactors_PA, checkedFactors_NEG, checkedFactors_EA,
                                                checkedFactors_SA, checkedFactors_OTH, initialPriority)){
      result = false;
    }
    //If there is an allegation in the list and none of the determination factors of the corresponding 
    //type are selected then display an error message
    if (bSubmit && allegListArray!=null) {
      ROWCINT76DO allegListRow = null;
      Enumeration allegListEnum = allegListArray.enumerateROWCINT76DO();
       while (allegListEnum.hasMoreElements()) {
        allegListRow = (ROWCINT76DO) allegListEnum.nextElement();
        String alegType = allegListRow.getSzCdIntakeAllegType();
        if(CodesTables.CABALTYP_PP.equals(alegType) && determinationFactors_PA.length == 0){
          setErrorMessage(Messages.MSG_INT_DETFAC_REQ);
          result = false;
          break;
       }else if(CodesTables.CABALTYP_NN.equals(alegType) && determinationFactors_NEG.length == 0){
         setErrorMessage(Messages.MSG_INT_DETFAC_REQ);
         result = false;
         break;
       }else if(CodesTables.CABALTYP_EE.equals(alegType) && determinationFactors_EA.length == 0){
         setErrorMessage(Messages.MSG_INT_DETFAC_REQ);
         result = false;
         break;
       }else if(CodesTables.CABALTYP_SS.equals(alegType) && determinationFactors_SA.length == 0){
         setErrorMessage(Messages.MSG_INT_DETFAC_REQ);
         result = false;
         break;
       }else if(CodesTables.CABALTYP_OO.equals(alegType) && determinationFactors_OTH.length == 0){
         setErrorMessage(Messages.MSG_INT_DETFAC_REQ);
         result = false;
         break;
       }
      }
    }
    //STGAP00009181 - end
    String classification = ContextHelper.getStringSafe(request, "selSzCdStageClassification");
    // Sir 23115
    int personAge = intakePersonListRow.getLNbrPersonAge();
    String personRole = intakePersonListRow.getSzCdStagePersRole();
    String personRelationship = intakePersonListRow.getSzCdStagePersRelInt();
    String disposition = ContextHelper.getStringSafe(request, "selSzCdDisp");
    String reasonChanged = ContextHelper.getStringSafe(request,"selSzCdStageRsnPriorityChgd");

    // STGAP00008020
    // Response Time for Initial and Current Time
    String initialResponseTime = ContextHelper.getStringSafe(request,
    		"selSzCdStageInitialPriority");
    String currentResponseTime = ContextHelper.getStringSafe(request,
    		"selSzCdStageCurrPriority");
    // STGAP00008020

    // I&R and SPC type are retrieved by the CINT25S retrieve service as Incoming Disposition.
    // We hide that retrieved value in hdnSzCdIncomingDisposition on the Intake Actions page
    // and use it here to decide if the Intake has been marked as an I&R or SPC.
    // String disposition = ContextHelper.getStringSafe(request, "hdnSzCdIncomingDisposition");
    // String callEntryIR = "";
    // String callEntrySPC = "";
    //
    // if (!"".equals(disposition)
    // && !(disposition.startsWith(IntakeConstants.NON_CASE_RELATED_PREFIX) || disposition
    // .startsWith(IntakeConstants.CASE_RELATED_SPECREQ_PREFIX))) {
    // callEntryIR = disposition;
    // } else {
    // callEntrySPC = disposition;
    // }

    boolean approvalMode = false;
    if (GlobalData.isApprovalMode(request)) {
      approvalMode = true;
    }

    // //////////////////////////////////////////////////////////////////////////////
    // Error Message 1:
    //
    //
    // Condition: The user is attempting to delete an allegation from the list
    // without first selecting a radio button.
    //
    // Validation State: Delete Allegation or New Using Allegation
    // //////////////////////////////////////////////////////////////////////////////
    if (bDeleteFromList || bNewUsing) {
      String index = ContextHelper.getStringSafe(request, "rbAllegList");
      if ("".equals(index)) {
        setErrorMessage(Messages.MSG_SELECT_ROW_ACTION);
        result = false;
      }
    }

    // //////////////////////////////////////////////////////////////////////////////
    // Error Message 2:
    //
    //
    // Condition: The user is attempting to Save and Assign an Intake that is
    // classified as CPS and they do not have the SEC_ASSIGN_INTAKE_DIRECT
    // security attribute.
    // Note: This cannot be handled by hiding the Assign button because it is
    // dependent on the classification which is set on the page.
    //
    // Validation State: Save and Submit and Save and Assign
    // //////////////////////////////////////////////////////////////////////////////
    if ((bAssign) && (classification.equals(CodesTables.CCLASS_CPS))) {
      {
        setErrorMessage(Messages.MSG_ASSIGN_CPS_NO_SEC);
        result = false;
      }
    }

    // According to GA Policy, a child under the age of 18 can not be considered
    // an AP(Alleged Maltreator) if they are not the PK(Primary Caretaker)
    if ((null != personRole) && (personAge > 0)) {
      if ((bAssign || bSubmit || bSave)
          && ((classification.equals(CodesTables.CCLASS_CPS)) || (classification.equals(CodesTables.CCLASS_LCC)) || (classification
                                                                                                                                   .equals(CodesTables.CCLASS_LRC)))
          && (personAge < 18) && ("AP".equals(personRole) && !"PK".equals(personRelationship))) {
        setErrorMessage(Messages.MSG_INT_SAVE_CPS_CHILD_AGE);
        result = false;
      }
    }

    // The user is attempting to Submit and Intake has not been marked as an I&R
    String cdNonIncReqType = ContextHelper.getStringSafe(request, "hdnSzCdNonIncReqType");
    String caseName = ContextHelper.getStringSafe(request, "hdnCaseName");
    if (bSubmit && (StringHelper.isValid(cdNonIncReqType) && !CodesTables.CNIRTYPE_IR.equals(cdNonIncReqType))
                    && ((caseName == null) || (StringHelper.EMPTY_STRING).equals(caseName))){
      setErrorMessage(Messages.MSG_INT_CASE_NAME_NEEDED);
      result = false;
    }
    // //////////////////////////////////////////////////////////////////////////////
    // Error Message 3:
    //
    //
    // Condition: The user is attempting to Save and Submit or Save and Assign an
    // I&R or NCRSR
    //
    // Validation State: Save and Submit and Save and Assign
    // //////////////////////////////////////////////////////////////////////////////
    // if ((bAssign || bSubmit)
    // && (StringHelper.isValid(callEntryIR) || (StringHelper.isValid(callEntrySPC) && callEntrySPC
    // .startsWith(IntakeConstants.NON_CASE_RELATED_PREFIX)))) {
    // setErrorMessage(Messages.MSG_ASSIGN_SUBMIT_IR_NCRSR);
    // result = false;
    // }

    // JMC - 08/22/2003 - It was necessary to remove this edit because in IMPACT, when the approver
    // saves and assigns the intake it no longer sets the incoming status to CLD (since
    // we opened up intakes with pending approvals for modification by the approver.)
    // That way the only way we can get the intake status to move from SBA to CLD is
    // to allow the primary staff to save and assign the intake.

    // //////////////////////////////////////////////////////////////////////////////
    // Error Message 4:
    //
    //
    // Condition: The user is attemping to Save and Assign and the priority
    // is equal to "N"
    //
    // Validation State: Save and Assign
    // //////////////////////////////////////////////////////////////////////////////
    if ((bAssign)
        && ((CodesTables.CPRIORTY_N).equals(ContextHelper.getStringSafe(request, "selSzCdStageInitialPriority")))
        && (!GlobalData.isApprovalMode(request))) {
      setErrorMessage(Messages.MSG_ASSIGN_PRIORITY_N);
      result = false;
    }

    // //////////////////////////////////////////////////////////////////////////////
    // Error Message 5:
    //
    //
    // Condition: The user is attempt to mark an Intake that has been
    // classified as an SPC or I&R for deletion.
    //
    //
    // Validation State: Mark for Deletion
    // //////////////////////////////////////////////////////////////////////////////
    // if ((super.isButtonPressed("btnMarkForDeletion"))
    // && (StringHelper.isValid(callEntryIR) || StringHelper.isValid(callEntrySPC))) {
    // setErrorMessage(Messages.MSG_DELETE_SPCIR);
    // result = false;
    // }

    // //////////////////////////////////////////////////////////////////////////////
    // Error Message 6:
    //
    //
    // Condition: The user is attempting to save the Worker Safety Issues checkbox
    // without entering comments.
    //
    //
    // Validation State: Save, Save and Submit, or Save and Assign.
    // //////////////////////////////////////////////////////////////////////////////
    if ("Y".equals(CheckboxHelper.getCheckboxValue(request, "cbxBIndCaseWorkerSafety"))
        && !StringHelper.isValid(ContextHelper.getStringSafe(request, "txtTxtIncmgWorkerSafety"))) {
      setErrorMessage("txtTxtIncmgWorkerSafety", Messages.MSG_WRK_SAFETY_CMMTS_REQ);
      result = false;
    }

    // //////////////////////////////////////////////////////////////////////////////
    // Error Message 7:
    //
    //
    // Condition: The user is attempting to save the Sensitive Case checkbox
    // without entering comments.
    //
    //
    // Validation State: Save, Save and Submit, or Save and Assign.
    // //////////////////////////////////////////////////////////////////////////////
    if ("Y".equals(CheckboxHelper.getCheckboxValue(request, "cbxBIndCaseSensitive"))
        && !StringHelper.isValid(ContextHelper.getStringSafe(request, "txtTxtIncomgSensitive"))) {
      setErrorMessage("txtTxtIncomgSensitive", Messages.MSG_SENSITIVE_CMMTS_REQ);
      result = false;
    }

    // //////////////////////////////////////////////////////////////////////////////
    // Error Message 8: Sir 23720
    //
    //
    // Condition: The user is attempting to save the Suspected Meth Case checkbox
    // without entering comments.
    //
    // if(state.getAttribute("ClientCount", request) != null){
    // clientCount1 = Integer.parseInt((String)state.getAttribute("ClientCount", request));
    // Validation State: Save, Save and Submit, or Save and Assign.
    // //////////////////////////////////////////////////////////////////////////////
    if ("Y".equals(CheckboxHelper.getCheckboxValue(request, "cbxBIndCaseSuspMeth"))
        && !StringHelper.isValid(ContextHelper.getStringSafe(request, "txtTxtIncomgSuspMeth"))) {
      setErrorMessage("txtTxtIncomgSuspMeth", Messages.MSG_SUSP_METH_CMMTS_REQ);
      result = false;
    }

    // //////////////////////////////////////////////////////////////////////////////
    // Error Message 10:
    //
    //
    // Condition: The user has selected Screen Out, Screen Out & Referred or Diversion
    // as the Disposition without entering Comments Regarding Screen Out or Diversion.
    //
    //
    // Validation State: Save, Save and Submit, or Save and Assign.
    // //////////////////////////////////////////////////////////////////////////////

    if ((CodesTables.CDISP_DIV.equals(disposition) || CodesTables.CDISP_SCO.equals(disposition) || CodesTables.CDISP_SCR
                                                                                                                        .equals(disposition))
        && !StringHelper.isValid(ContextHelper.getStringSafe(request, "txtSzTxtStagePriorityCmnts"))) {
      setErrorMessage("txtSzTxtStagePriorityCmnts", Messages.MSG_SCR_OUT_CMMTS_REQ);
      result = false;
    }

    // //////////////////////////////////////////////////////////////////////////////
    // Error Message 11:
    //
    //
    // Condition: disposition is required to Approve Intake
    //
    // Validation State: approvalMode and Approval.
    // //////////////////////////////////////////////////////////////////////////////

    if (approvalMode && bApproval && !StringHelper.isValid(disposition)) {
      setErrorMessage("selSzCdDisp", Messages.MSG_INV_CASE_DSPSTN_REQ);
      result = false;
    }

    // //////////////////////////////////////////////////////////////////////////////
    // Error Message 11A:
    // Per STGAP00008693
    //
    // Condition: If the supervisor changes the Current Response time while approving
    //            Reason Change Field is required.
    // Validation State: approvalMode and Approval.
    // //////////////////////////////////////////////////////////////////////////////

    if (approvalMode && bApproval) {
      if(!(initialResponseTime.equals(currentResponseTime))){
        if(!StringHelper.isValid(reasonChanged)){
           setErrorMessage("selSzCdStageRsnPriorityChgd",Messages.MSG_REASON_CHANGED_REQ);
      result = false;
        }
      }
    }

    // ////////////////////////////////////////////////////////////////////////////
    // Error Message 12:
    //
    //
    // Condition:If the Disposition dropdown box value is set to Screen Out & Referred,
    // then the values for Service Provider Name and Type of Service must be populated. .
    //
    //
    // Validation State: Save, Save and Submit, or Save and Assign.
    // //////////////////////////////////////////////////////////////////////////////

    if ((CodesTables.CDISP_SCR.equals(disposition))
        && !StringHelper.isValid(ContextHelper.getStringSafe(request, "hdnRefferedResourceId"))) {
      setErrorMessage(Messages.MSG_SVC_PROV_NM_TYP_REQ);
      result = false;
    }

    // //////////////////////////////////////////////////////////////////////////////
    // Error Message 13:
    //
    //
    // Condition: The user has selected Screen Out, Screen Out & Referred or Diversion
    // as the Disposition without entering screen out reason.
    //
    //
    // Validation State: Save, Save and Submit, or Save and Assign.
    // //////////////////////////////////////////////////////////////////////////////

    if ((CodesTables.CDISP_DIV.equals(disposition) || CodesTables.CDISP_SCO.equals(disposition) || CodesTables.CDISP_SCR
                                                                                                                        .equals(disposition))
        && !StringHelper.isValid(ContextHelper.getStringSafe(request, "selSzCdScreentOutReason"))) {
      setErrorMessage("selSzCdScreentOutReason", Messages.MSG_SCRN_OUT_RSN_REQ);
      result = false;
    }


    // STGAP00008020

    //////////////////////////////////////////////////////////////////////////////
    // Error Message 14: STGAP00008020
    // Validation for Disposition
    //
    // Condition: The user has selected Screen Out, Screen Out & Referred or Diversion
    // as the Disposition without entering screen out reason.
    //
    //
    // Validation State: Save and Submit or Approval Status.
    // //////////////////////////////////////////////////////////////////////////////

    // Save and Submit
    //STGAP00008399: Added a check to see if the disposition is ACA, DIV, SCO, or SCR so that the error
    //message will be displayed only for those cases.
    boolean checkDisp = (CodesTables.CDISP_ACA.equals(disposition) || CodesTables.CDISP_DIV.equals(disposition)
                    || CodesTables.CDISP_SCO.equals(disposition) || CodesTables.CDISP_SCR.equals(disposition));
    
    //STGAP00009236: User Should not be able to Save and Submit from the IntakeActions Page. Case Manager is Submitting the 
    //the intake for approval , so we should not be checking for the Disposition field as he does not enter disposition
    if (bSubmit && StringHelper.isValid(cdNonIncReqType)) {
    	setErrorMessage(Messages.MSG_INT_SAVE_NI_DISP);
        result = false;
        }

    // Approval Status
    if (bApproval && approvalMode && StringHelper.isValid(cdNonIncReqType)
    		&& checkDisp) {
    	setErrorMessage(Messages.MSG_INT_SAVE_NI_DISP);
        result = false;
        }

    //////////////////////////////////////////////////////////////////////////////
    // Error Message 15: STGAP00008020
    // Validation for Determination Factors
    //
    // Condition: The user has selected any Determination Factors.
    //
    //
    // Validation State: Save and Submit or Approval Status.
    // //////////////////////////////////////////////////////////////////////////////

    // Save and Submit
    if (bSubmit && StringHelper.isValid(cdNonIncReqType)
    		&& ((determinationFactors_PA.length != 0) || (determinationFactors_NEG.length != 0) ||
    				(determinationFactors_EA.length != 0) || (determinationFactors_SA.length != 0) ||
    				(determinationFactors_OTH.length != 0))) {
    	setErrorMessage(Messages.MSG_INT_SAVE_NI_DETERM_FACTORS);
        result = false;
        }

    // Approval Status
    if (bApproval && approvalMode && StringHelper.isValid(cdNonIncReqType)
    		&& ((determinationFactors_PA.length != 0) || (determinationFactors_NEG.length != 0) ||
    				(determinationFactors_EA.length != 0) || (determinationFactors_SA.length != 0) ||
    				(determinationFactors_OTH.length != 0))) {
     	setErrorMessage(Messages.MSG_INT_SAVE_NI_DETERM_FACTORS);
        result = false;
        }

    //////////////////////////////////////////////////////////////////////////////
    // Error Message 16: STGAP00008020
    // Validation for Response Time
    //
    // Condition: The user has selected any Response Time.
    //
    //
    // Validation State: Save and Submit or Approval Status.
    // //////////////////////////////////////////////////////////////////////////////

    // Save and Submit
    if (bSubmit && StringHelper.isValid(cdNonIncReqType)
    		&& (StringHelper.isValid(initialResponseTime) || (StringHelper.isValid(currentResponseTime)))) {
    	setErrorMessage(Messages.MSG_INT_SAVE_NI_RESP_TIME);
        result = false;
        }

    // Approval Status
    if (bApproval && approvalMode && StringHelper.isValid(cdNonIncReqType)
    		&& (StringHelper.isValid(initialResponseTime) || (StringHelper.isValid(currentResponseTime)))) {
    	setErrorMessage(Messages.MSG_INT_SAVE_NI_RESP_TIME);
        result = false;
        }

    //////////////////////////////////////////////////////////////////////////////
    // Error Message 17: STGAP00007164
    // Validation for Diversion/Screen Out of Child Death case
    //
    // Condition: The user has selected a disposition of diversion, screen out or screen out and
    // referred for a child death intake special investigation, where one child is dead and others
    // are in the household, or checkbox indicating a child death with other children is checked
    //
    // Validation State: Save, Save and Submit or Approval Status.
    // //////////////////////////////////////////////////////////////////////////////
    if ((CodesTables.CSPECREQ_CDNC.equals(specInvest) || CodesTables.CSPECREQ_CDIC.equals(specInvest)) ||
                    (deadChildCount > 0)
                    || checkedFactors_OTH.contains(CodesTables.COTHER_OCHD)) {
      if (CodesTables.CDISP_DIV.equals(disposition)) {
        setErrorMessage(Messages.MSG_INT_SAVE_DEATH_DIV_HOUSEHOLD);
        result = false;
      }
      // Per STGAP00010103 throw error message only if there is childDeath and there exists 
      // another principal child in the case who is alive and Reason of Death is not Accidental Death or Natural Cause.
      // Per STGAP00010106 check for this validation only if it is approval mode, Case Manager does not enter disposition
      //101883: Corrected logic to allow Accidental Death and Natural cause intakes to be submitted. 
      else if (approvalMode && ((principalChildCount - deadChildCount > 0)  && (!isAccidentalDeath && !isNaturalCause)) && 
                       (CodesTables.CDISP_SCO.equals(disposition) || CodesTables.CDISP_SCR.equals(disposition))) {
        setErrorMessage(Messages.MSG_INT_SAVE_DEATH_SCREENOUT);
        result = false;
      }
    }
    
    //STGAP00012588: User selects child death  type on the Intake Information page  but neglects to enter the reason for 
    //death and DOD on the Person Detail page an error message displays directing the user to enter the reason and/or DOD.  
    //SMS 59572. Message would display for Child Death in Care also. This is a new code for MR-066
    boolean showErrorMessage = false;
    if (bSubmit && (CodesTables.CSPECREQ_CDNC.equals(specInvest) || CodesTables.CSPECREQ_CDIC.equals(specInvest))) {
      if(personListArray != null){
        PersListRtrvStruct person;
        Enumeration enumPerson = personListArray.enumeratePersListRtrvStruct();
        while (enumPerson.hasMoreElements()) {
          person = (PersListRtrvStruct) enumPerson.nextElement();
          String personCdType = person.getSzCdStagePersType();
          String personCdRole = person.getSzCdStagePersRole();
          if (CodesTables.CPRSNTYP_PRN.equals(personCdType) && CodesTables.CINTROLE_VC.equals(personCdRole)) {
            if (DateHelper.isNull(person.getDtDtPersonDeath()) || ((person.getSzCdPersonDeath() == null || StringHelper.EMPTY_STRING.equals(person.getSzCdPersonDeath())))) {
              showErrorMessage = true;
            }else{
              showErrorMessage = false;
              break;
            }
          }
        }
        if(showErrorMessage){
          setErrorMessage(Messages.MSG_INT_REASON_DOD_REQ);
          result = false;
        }
      }
    }
    
    //STGAP00012588: User enters the reason for death and DOD on the Person Detail page  but neglects to selects 
    //child death  type on the Intake Information page an error message displays directing the user to enter type on
    // Intake Action Page.
    if(bSubmit){
      if(personListArray != null){
        PersListRtrvStruct person;
        Enumeration enumPerson = personListArray.enumeratePersListRtrvStruct();
        while (enumPerson.hasMoreElements()) {
          person = (PersListRtrvStruct) enumPerson.nextElement();
          String personCdType = person.getSzCdStagePersType();
          String personCdRole = person.getSzCdStagePersRole();
          if (CodesTables.CPRSNTYP_PRN.equals(personCdType) && CodesTables.CINTROLE_VC.equals(personCdRole)) {
            if (!DateHelper.isNull(person.getDtDtPersonDeath()) || ((person.getSzCdPersonDeath() != null && !StringHelper.EMPTY_STRING.equals(person.getSzCdPersonDeath())))) {
              //SMS 59572. Message would display for Child Death in Care also. This is a new code for MR-066
              if(!CodesTables.CSPECREQ_CDNC.equals(specInvest) && !CodesTables.CSPECREQ_CDIC.equals(specInvest)){
                setErrorMessage(Messages.MSG_INT_TYPE_REQ);
                result = false;
                break;
              }
            }
          }
        }
      }
    }
    
    // MR-066: If maltreatment in care, the special investigation call type is required and the placement/non-placement
    // provider section. The placement/non-placement provider section is only required if the child identified
    // as a victim on an allegation is not a 'Trial Home Visit'
    //CAPTA 4.3 - Remove Trail Home Visit condition.
    if(bSubmit || bApproval){
      String indIncmgMaltreatInCare = ContextHelper.getString(request, "rbIndMaltreatInCare");
      String nmIncmgFacil = facilityData.getNmIncmgFacilName();
      int idResource = facilityData.getUlIdResource();
      // If any of the alleged victim's allegation took place while 'In DFCS Custody'(This indicates maltreatment in care)
      // selections for special investigation and placement/non-placement provider(if child was not in a 'Trial Home Visit') are required
      if (ArchitectureConstants.Y.equals(indIncmgMaltreatInCare)) {
        //String indTrialHomeVisit = ContextHelper.getStringSafe(request, "hdnIndTrialHomeVisit");
        // If did not select a special investigation and a resource (or did not enter one) and it's not 'Trial Home Visit', display the message 
        // requiring both the special investigation and the placement/non-placement provider section.
        //CAPTA 4.3 - removing trial home visit condition.
        //if (!StringHelper.isValid(specInvest) && (!StringHelper.isValid(nmIncmgFacil) && idResource == 0) && !ArchitectureConstants.Y.equals(indTrialHomeVisit)) {
        if (!StringHelper.isValid(specInvest) && (!StringHelper.isValid(nmIncmgFacil) && idResource == 0) ) {
          setErrorMessage(Messages.MSG_INT_SPCL_INV_PLACEMENT_REQ);
          result = false;
        }
        // If user did select a special investigation but not a resource (or did not enter one) and it's not 'Trial Home Visit', display the message 
        // requiring both the special investigation and the placement/non-placement provider section.
        //CAPTA 4.3 - removing trial home visit condition
        //else if (StringHelper.isValid(specInvest) && (!StringHelper.isValid(nmIncmgFacil) && idResource == 0) && !ArchitectureConstants.Y.equals(indTrialHomeVisit)) {
        else if (StringHelper.isValid(specInvest) && (!StringHelper.isValid(nmIncmgFacil) && idResource == 0) ) {
          setErrorMessage(Messages.MSG_INT_SPCL_INV_PLACEMENT_REQ);
          result = false;
        }
        // If any of the previous conditions fail then we only need to show the message requiring the special investigation
        // if one was not selected
        //CAPTA 4.3 - removing this message
        /*else if (!StringHelper.isValid(specInvest)) {
          setErrorMessage(Messages.MSG_INT_SPCL_INV_REQ);
          result = false;
        }*/
      }
      //SMS#114648 The following message should display if there exists a placement provider on intake information page irrespective of maltreatment in care.      
      //CAPTA 4.3 - if user documented placement/non placement provider section but not selected the special investigation call type, display the message
      // to select Special Investigation Call Type when documenting placement/non placement provider.
      if (!StringHelper.isValid(specInvest) && StringHelper.isValid(nmIncmgFacil)) {
        setErrorMessage(Messages.MSG_INT_SPCL_INV_CALL_TYPE_REQ);
        result = false;
      }      
    }
    
    performanceTrace.exitScope();
    return result;
  } 

  /**
   * <p>
   * STGAP00009181 - This method is a rewrite of validate5DaysResponseTimeByFactors and it validates the checked Determination Factors
   * on the Intake Actions page if Immediate to 24 hrs is not selected as the Initial Response Time. This is to satisfy
   * Requirements in section 1.19 and the new MR-011 requirements of the Intake Actions Detailed Designs document.
   * </p>
   *
   * @param checkedFactors_PA
   * @param checkedFactors_NEG
   *          checkedFactors_EA checkedFactors_SA checkedFactors_OTH
   * @param inialPriority
   * @param allegListArray
   * @return boolean result
   */
  @SuppressWarnings( { "unchecked" })
  private boolean ValidateResponseTimes(List checkedFactors_PA, List checkedFactors_NEG, List checkedFactors_EA,
                                        List checkedFactors_SA, List checkedFactors_OTH, String inialPriority) {
    boolean result = true;
    //Validating Immediate response times
    if (!CodesTables.CPRIORTY_IM.equals(inialPriority)) {
      // Check the Physical Abuse Determination Factors
      if (checkedFactors_PA != null) {
        if (// Immediate medical treatment or hospitalization required.
        checkedFactors_PA.contains(CodesTables.CPHYABSE_PCKA)
                        // Child under age 8
                        || checkedFactors_PA.contains(CodesTables.CPHYABSE_PC08)
                        // Multiple Bruises Welts are marks
                        || checkedFactors_PA.contains(CodesTables.CPHYABSE_PCBP)
                        // Alleged perpetrator has access to the child and child limited by disability
                        || (checkedFactors_PA.contains(CodesTables.CPHYABSE_PCAQ) && checkedFactors_PA
                                                                                                      .contains(CodesTables.CPHYABSE_PCLD))
                        // Child under age 13, child afraid to go home and non-maltreating caretaker not protective of
                        // child
                        || (checkedFactors_PA.contains(CodesTables.CPHYABSE_PC13)
                            && checkedFactors_PA.contains(CodesTables.CPHYABSE_PCAH) && checkedFactors_PA
                                                                                                         .contains(CodesTables.CPHYABSE_PCBD))
                        // Child under age 13, child afraid to go home,non-maltreating caretaker protective of child and
                        // caretaker physically/emotionally/intellectually disabled
                        || (checkedFactors_PA.contains(CodesTables.CPHYABSE_PC13)
                            && checkedFactors_PA.contains(CodesTables.CPHYABSE_PCAH)
                            && !checkedFactors_PA.contains(CodesTables.CPHYABSE_PCBD) && (checkedFactors_PA
                                                                                                           .contains(CodesTables.CPHYABSE_PCJA)
                                                                                          || checkedFactors_PA
                                                                                                              .contains(CodesTables.CPHYABSE_PCEI) || checkedFactors_PA
                                                                                                                                                                       .contains(CodesTables.CPHYABSE_PCII)))
                        // Child under 13, child afraid to go home and self referral by child
                        || (checkedFactors_PA.contains(CodesTables.CPHYABSE_PC13)
                            && checkedFactors_PA.contains(CodesTables.CPHYABSE_PCAH) && checkedFactors_PA
                                                                                                         .contains(CodesTables.CPHYABSE_PCKD))
                        // Child limited by disability and Child left alone
                        || (checkedFactors_PA.contains(CodesTables.CPHYABSE_PCLD) && checkedFactors_PA
                                                                                                      .contains(CodesTables.CPHYABSE_PCAC))) {
          result = false;
        }
      }

      // Check the Neglect Determination Factors
      if (checkedFactors_NEG != null) {
        if (// Child in severe danger of harm
        checkedFactors_NEG.contains(CodesTables.CNEGLECT_NCDH)
                        // Child suffering from serious untreated medical condition
                        || checkedFactors_NEG.contains(CodesTables.CNEGLECT_NCNA)
                        // Mother or Infant tested positive for illegal drugs/alcohol
                        || checkedFactors_NEG.contains(CodesTables.CNEGLECT_NPID)
                        // Suspicion that a mother or infant will test positive for illegal drugs or fetal alcohol
                        // syndrome
                        || checkedFactors_NEG.contains(CodesTables.CNEGLECT_NSID)
                        // Caretaker not willing to meet child's basic needs
                        || checkedFactors_NEG.contains(CodesTables.CNEGLECT_NCLQ)
                        // Caretaker not capable of meeting child's basic needs
                        || checkedFactors_NEG.contains(CodesTables.CNEGLECT_NCMN)
                        // Child under age 13, child afraid to go home and self referral by child
                        || (checkedFactors_NEG.contains(CodesTables.CNEGLECT_NCA1)
                            && checkedFactors_NEG.contains(CodesTables.CNEGLECT_NCAD) && checkedFactors_NEG
                                                                                                           .contains(CodesTables.CNEGLECT_NCBA))
                        // Child left alone and under age 8
                        || (checkedFactors_NEG.contains(CodesTables.CNEGLECT_NC1A) && checkedFactors_NEG
                                                                                                        .contains(CodesTables.CNEGLECT_NC8Y))
                        // Child left alone, over age 8 and unable to care for himself/herself
                        || (checkedFactors_NEG.contains(CodesTables.CNEGLECT_NC1A)
                            && !checkedFactors_NEG.contains(CodesTables.CNEGLECT_NC8Y) && checkedFactors_NEG
                                                                                                            .contains(CodesTables.CNEGLECT_NCCH))
                        // Child with a disability that has been left alone
                        || (checkedFactors_NEG.contains(CodesTables.CNEGLECT_NC1A) && checkedFactors_NEG
                                                                                                        .contains(CodesTables.CNEGLECT_NCLD))
                        // Caretaker demonstrates physical/intellectual/emotional instability
                        || checkedFactors_NEG.contains(CodesTables.CNEGLECT_NTBD)
                        || checkedFactors_NEG.contains(CodesTables.CNEGLECT_NTAV)
                        || checkedFactors_NEG.contains(CodesTables.CNEGLECT_NTAP)
                        // There is Ongoing history
                        || checkedFactors_NEG.contains(CodesTables.CNEGLECT_NCCQ))
          result = false;
      }
      // Check the Emotional Abuse Determination Factors
      if (checkedFactors_EA != null) {
        if (// Cruel, callous or bizarre punishment/behavior by the caretaker
        checkedFactors_EA.contains(CodesTables.CEMLABSE_ECCK)
                        // Child present's an observable condition and Caretaker demonstrates
                        // physical/intelectual/emotional instability
                        || (checkedFactors_EA.contains(CodesTables.CEMLABSE_ECOC) && (checkedFactors_EA
                                                                                                       .contains(CodesTables.CEMLABSE_ECQB)
                                                                                      || checkedFactors_EA
                                                                                                          .contains(CodesTables.CEMLABSE_ECQD) || checkedFactors_EA
                                                                                                                                                                   .contains(CodesTables.CEMLABSE_ECQS)))
                        // Cruel callous or bizarre punishment alleged
                        || checkedFactors_EA.contains(CodesTables.CEMLABSE_ECAT)
                        // Child 8 and under and left alone
                        || (checkedFactors_EA.contains(CodesTables.CEMLABSE_ECAG) && checkedFactors_EA
                                                                                                      .contains(CodesTables.CEMLABSE_ECCD))
                        // Cruel, callous or bizarre punishment/behavior by the caretaker or caretaker believes
                        // child is a religious figure or devil- Addressing requirement MR011.12
                        || checkedFactors_EA.contains(CodesTables.CEMLABSE_ECCK)
                        || checkedFactors_EA.contains(CodesTables.CEMLABSE_EPDD)
                        // Parent self reporting and unable to cope and feel they will harm or kill the children or
                        // requesting removal of child
                        || (checkedFactors_EA.contains(CodesTables.CEMLABSE_EPAD) && (checkedFactors_EA
                                                                                                       .contains(CodesTables.CEMLABSE_EPBD) || checkedFactors_EA
                                                                                                                                                                .contains(CodesTables.CEMLABSE_EPCD)))
                        // Ongoing History
                        || checkedFactors_EA.contains(CodesTables.CEMLABSE_EOHI)) {
          result = false;
        }
      }
      // Check the Sex Abuse Determination Factors
      if (checkedFactors_SA != null) {
        if (// Allegations of sodomy,vaginal intercourse, or oral sex and there is Medical evidence
        (checkedFactors_SA.contains(CodesTables.CSEXABSE_SSME) && checkedFactors_SA.contains(CodesTables.CSEXABSE_SSNT))
                        // Child afraid to go home
                        || checkedFactors_SA.contains(CodesTables.CSEXABSE_SPAD)
                        // Child 8 or under and is left alone
                        || (checkedFactors_SA.contains(CodesTables.CSEXABSE_SAAM) && checkedFactors_SA
                                                                                                      .contains(CodesTables.CSEXABSE_SSMT))
                        // There is ongoing history
                        || checkedFactors_SA.contains(CodesTables.CSEXABSE_SOHI)
                        // Alleged perpetrator has access to the child
                        || checkedFactors_SA.contains(CodesTables.CSEXABSE_SMAC)
                        // History of Abuse
                        || checkedFactors_SA.contains(CodesTables.CSEXABSE_SACD)
                        // Ongoing History or pattern of incidents
                        || checkedFactors_SA.contains(CodesTables.CSEXABSE_SOHI)) {
          result = false;
        }

        // Check the Other Determination Factors
        if (checkedFactors_OTH != null) {
          if (// Child resides in the same household of a child who died of what may have been child maltreatment
          checkedFactors_OTH.contains(CodesTables.COTHER_OCHD)
          // New birth to a parent with another child in placement
                          || checkedFactors_OTH.contains(CodesTables.COTHER_OBPC)
                          // Maltreatment to a child in custody, regardless of placement
                          || checkedFactors_OTH.contains(CodesTables.COTHER_OMCC)
                          // Child detained by a physician
                          || checkedFactors_OTH.contains(CodesTables.COTHER_OCCP)
                          // Request for short-term emergency care
                          || checkedFactors_OTH.contains(CodesTables.COTHER_OCDD)) {
            result = false;
          }
        }

      }
    }

    //Validating 24 hour response times
    if (result && !CodesTables.CPRIORTY_24.equals(inialPriority) && !CodesTables.CPRIORTY_IM.equals(inialPriority)) {
      // Check the Physical Abuse Determination Factors
      if (checkedFactors_PA != null) {
        if (// When child is at risk of serious injury.
        checkedFactors_PA.contains(CodesTables.CPHYABSE_PCAE)
                        // Child received discipline resulting in injury
                        || checkedFactors_PA.contains(CodesTables.CPHYABSE_PCBL)
                        // Alleged perpetrator has access to the child
                        || checkedFactors_PA.contains(CodesTables.CPHYABSE_PCAQ)
                        // Child limited by disability
                        || checkedFactors_PA.contains(CodesTables.CPHYABSE_PCLD)
                        // Caretaker physically/emotionally/intellectually disabled
                        || checkedFactors_PA.contains(CodesTables.CPHYABSE_PCEI)
                            || checkedFactors_PA.contains(CodesTables.CPHYABSE_PCII) || checkedFactors_PA
                                                                                                         .contains(CodesTables.CPHYABSE_PCJA)) {
          result = false;
        }
      }

      // Check the Neglect Determination Factors
      if (checkedFactors_NEG != null) {
        if (// Child limited by disability
        checkedFactors_NEG.contains(CodesTables.CNEGLECT_NCCH)
        // Child unable to care for himself/herself
                        || checkedFactors_NEG.contains(CodesTables.CNEGLECT_NCLD)) {
          result = false;
        }
        // Check the Emotional Abuse Determination Factors
        if (checkedFactors_EA != null) {
          // Serious emotional damage to children resulting from parent or caretaker's actions
          if (checkedFactors_EA.contains(CodesTables.CEMLABSE_ECCS)) {
            result = false;
          }
        }
        // Check the Sex Abuse Determination Factors
        if (checkedFactors_SA != null) {
          if (// Allegations of sodomy,vaginal intercourse, or oral sex
          checkedFactors_SA.contains(CodesTables.CSEXABSE_SSME)) {
            result = false;
          }
        }
      }
    }
    if (!result) {
      setErrorMessage(Messages.MSG_INT_DTR_FTR_RSPN_TIM);
    }
    return result;
  }

 /**
  * STGAP00009957 - This method will return true if there is an Allegation of type 'OTHER' in the allegation array.
  * @param allegListArray
  * @return boolean result
  */
  private boolean isAllegTypeOther(ROWCINT76DO_ARRAY allegListArray) {
    boolean result = false;
    ROWCINT76DO allegListRow = null;
    Enumeration allegListEnum = allegListArray.enumerateROWCINT76DO();

    while (allegListEnum.hasMoreElements()) {
      allegListRow = (ROWCINT76DO) allegListEnum.nextElement();
      String alegType = allegListRow.getSzCdIntakeAllegType();
      if (CodesTables.CABALTYP_OO.equals(alegType)) {
        result = true;
        break;
      }
    }

    return result;
  }
  
  public static final String TRACE_TAG = "IntakeActionsCustomValidation";
}
