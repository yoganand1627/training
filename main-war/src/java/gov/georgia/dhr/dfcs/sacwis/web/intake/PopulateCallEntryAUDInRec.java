package gov.georgia.dhr.dfcs.sacwis.web.intake;

import javax.servlet.http.HttpServletRequest;

import org.grnds.structural.web.GrndsExchangeContext;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CallEntryAUDInRec;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CallEntrySvcStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.UnitStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CallEntryRtrvOut;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

/**
 * <p>
 * Title: populateCallEntryAUDInRec
 * </p>
 * <p>
 * Description: This class is used to populate the input structure that will Submit, Assign, or Close an Intake after it
 * has passed the final edits.
 * </p>
 * <p>
 * Copyright: Copyright (c) 2002
 * </p>
 * <p>
 * Company: Accenture
 * </p>
 * 
 * @author Jenn Casdorph
 * @version 1.0 <p/> * *
 * 
 * <pre>
 *                                     Change History:
 *                                      Date      User      Description
 *                                      --------  --------  --------------------------------------------------
 *                   &lt;p/&gt;
 *                                     06/30/05 ochumdr      SIR 23711 - APS Reform R2 - CRSR Four new Special Request
 *                                                           types added to the Special Request Dropdown. Code has been
 *                                                           added to enable save and assign to take place.
 *                                      *
 * </pre>
 */

public class PopulateCallEntryAUDInRec {
  public static final String TRACE_TAG = "PopulateCallEntryAUDInRec_SubmitAssignClose";

  /**
   * This submethod is used to populate the CINT12S input object. Since the CINT12S service is also used to save the
   * Call Entry section of the Call Information page, this submethod must have access to the retrieved data for Call
   * Entry so it does not overwrite anything with null. We pass the callEntryRtrvOut struct to the submethod. This
   * submethod then makes a carbon copy using the IntakeUtils.copyCallEntrySvcStructOutToIn() submethod and populates
   * the input object accordingly. The logic to populate the overall stage information was moved into
   * PopulateCallEntryAUDInRec.populateCallEntrySvcStructStageInfo() since it is fairly complicated and used on both the
   * Intake Actions and Call Information conversation.
   * 
   * @param context
   * @param cReqFuncCd
   * @param callEntryRtrvOut
   * @return
   */
  public static CallEntryAUDInRec populate(GrndsExchangeContext context, CallEntryRtrvOut callEntryRtrvOut,
                                           String cReqFuncCd) {

    HttpServletRequest request = context.getRequest();
    UserProfile user = UserProfileHelper.getUserProfile(request);

    if (cReqFuncCd == null) {
      cReqFuncCd = "";
    }

    if (callEntryRtrvOut == null) {
      callEntryRtrvOut = new CallEntryRtrvOut();
    }

    gov.georgia.dhr.dfcs.sacwis.structs.output.CallEntrySvcStruct retrievedStruct = callEntryRtrvOut
                                                                                                    .getCallEntrySvcStruct();
    if (retrievedStruct == null) {
      retrievedStruct = new gov.georgia.dhr.dfcs.sacwis.structs.output.CallEntrySvcStruct();
    }

    gov.georgia.dhr.dfcs.sacwis.structs.output.CallDcsnAUD callDecision = callEntryRtrvOut.getCallDcsnAUD();
    if (callDecision == null) {
      callDecision = new gov.georgia.dhr.dfcs.sacwis.structs.output.CallDcsnAUD();
    }

    // String disposition = FormattingHelper.formatString(retrievedStruct.getSzCdIncomingDisposition());
    String disposition = FormattingHelper.formatString(callDecision.getSzCdIncomingDisposition());

    if (!"".equals(disposition)
        && (disposition.startsWith(IntakeConstants.NON_CASE_RELATED_PREFIX) || disposition
                                                                                          .startsWith(IntakeConstants.CASE_RELATED_SPECREQ_PREFIX))) {
      retrievedStruct.setSzCdSpclReq(disposition);
    } else if (!"".equals(disposition)) {
      retrievedStruct.setSzCdInfoAndRefrl(disposition);
    }
    // This was getting set to gibberish in the service so pass in null
    retrievedStruct.setTsIncmgCallDisp(null);

    // Initialize the Structures we are going to populate.
    CallEntryAUDInRec callEntryAUDInRec = new CallEntryAUDInRec();
    ArchInputStruct input = new ArchInputStruct();
    UnitStruct unitStruct = new UnitStruct();

    callEntryAUDInRec.setUlIdEmployee(UserProfileHelper.getUserProfile(request).getUserID());

    // If the current priority is different from the priority the intake
    // had when the call was retrieved, then create a priority change
    // event if we are called from approval. If we have already created the event in
    // a previous call of CINT12S, the PRIORITY_EVENT_CREATED indicator will be "true"
    // NOTE: We set this at the bottom of this helper method.
    if (StringHelper.isValid((String) request.getAttribute(IntakeConstants.PRIORITY_CHANGED))
        && !"true".equals(request.getAttribute(IntakeConstants.PRIORITY_EVENT_CREATED))) {
      callEntryAUDInRec.setCSysIndEventToCreate(IntakeConstants.EVENT_CHANGE_PRIORITY_IND);
    }

    // Populate the ArchInputStruct
    input.setCReqFuncCd(cReqFuncCd);
    input.setUlSysNbrReserved1(GlobalData.getApprovalFlag(request));

    // Populate the UnitStruct
    unitStruct.setSzCdUnitProgram(user.getUserProgram());
    unitStruct.setSzNbrUnit(user.getUserUnit());
    unitStruct.setSzCdUnitRegion(user.getUserRegion());
    //STGAP00015116 - Need the county to ensure any
    // Unit searches return a unique unit
    unitStruct.setSzCdUnitCounty(user.getUserCounty());

    // First we make a carbon copy of what was retrieved

    // If we are in approval mode, we want to make sure the the case id
    // is not lost. If we did not retrieve a case id, we use the case id
    // that is put into global data for the stage.
    if (GlobalData.isApprovalMode(request)) {
      if (retrievedStruct.getUlIdCase() == 0) {
        retrievedStruct.setUlIdCase(GlobalData.getUlIdCase(request));
      }
    }

    CallEntrySvcStruct callEntrySvcStruct = IntakeUtils.copyCallEntrySvcStructOutToIn(retrievedStruct);
    callEntrySvcStruct.setSzCdIncmgAllegType(callDecision.getSzCdIncmgAllegType());
    callEntrySvcStruct.setSzNmStage(callDecision.getSzNmStage());

    if (GlobalData.isApprovalMode(request)) {
      callEntrySvcStruct.setSzSysCdWinMode(PageModeConstants.APPROVE);
    } else {
      callEntrySvcStruct.setSzSysCdWinMode(PageModeConstants.EDIT);
    }
    // Populate the Stage Information using
    callEntrySvcStruct = populateCallEntrySvcStructStageInfo(callEntrySvcStruct,
                                                             retrievedStruct.getSzCdNonRsdntReqType(),
                                                             callDecision.getSzCdStageClassification(),
                                                             retrievedStruct.getCdIncomingProgramType(), cReqFuncCd,
                                                             callDecision.getSzCdIncmgAllegType(),
                                                             callDecision.getSzCdStageCurrPriority());

    // If there is a value for hdnResourceId this means that we have completed a Resource Search
    // and are saving the retrieved resource info for the first time.
    if (ContextHelper.getIntSafe(request, "hdnResourceId") != 0) {
      callEntrySvcStruct.setUlIdResource(ContextHelper.getIntSafe(request, "hdnResourceId"));
    }

    // In the original windows code, the SaveAndSubmit and SaveAndClose functions made a call to
    // PopulateCallEntryServiceMessage() and then manipulated the CallEntrySvcStruct after the function
    // was called. That additional logic is included below.
    if (cReqFuncCd.equals(ServiceConstants.REQ_FUNC_CD_SAVE_AND_ASSIGN)) {
      input.setUlSysNbrReserved1(ArchitectureConstants.N);
      String specialRequestCode = FormattingHelper.formatString(retrievedStruct.getSzCdSpclReq());

      // JMC - Added the first if clause because for some reason, we are not retrieving the
      // correct Reason Closed when we save and assign. We can just check to see if there
      // is a value on the Intake Actions page and save that instead of saving the '01'
      // in the last else clause.
      if (StringHelper.isValid(ContextHelper.getStringSafe(request, "selSzCdDisp"))) {
        callEntrySvcStruct.setSzCdStageReasonClosed(ContextHelper.getStringSafe(request, "selSzCdDisp"));
      } else if (StringHelper.isValid(retrievedStruct.getSzCdStageReasonClosed())) {
        callEntrySvcStruct.setSzCdStageReasonClosed(retrievedStruct.getSzCdStageReasonClosed());
      } else if (specialRequestCode.startsWith(IntakeConstants.CASE_RELATED_SPECREQ_PREFIX)) {
        callEntrySvcStruct.setSzCdStageReasonClosed(IntakeConstants.CLOSURE_CD_CASE_REL_SR);
      } else if (specialRequestCode.startsWith(IntakeConstants.NON_CASE_RELATED_PREFIX)) {
        callEntrySvcStruct.setSzCdStageReasonClosed(null);
      } else {
        callEntrySvcStruct.setSzCdStageReasonClosed(IntakeConstants.CLOSURE_CD_INTAKE);
      }
    } else if (cReqFuncCd.equals(ServiceConstants.REQ_FUNC_CD_SAVE_AND_SUBMIT)) {
      callEntrySvcStruct.setDtIncomingCallDisposed(null);
    }
    callEntryAUDInRec.setArchInputStruct(input);
    callEntryAUDInRec.setUnitStruct(unitStruct);
    callEntryAUDInRec.setCallEntrySvcStruct(callEntrySvcStruct);
    callEntryAUDInRec.setSzCdEventStatus(callEntryRtrvOut.getSzCdEventStatus());
    callEntryAUDInRec.setSzCdStageCurrPriority(callDecision.getSzCdStageCurrPriority());
    // SIR 19820 - If the approver changed the priority, we need to send the service the previous
    // current priority so it can write the correct event description for the change priority event.
    // If we have already created the event though, we do not want to create a new one. We will
    // set the PRIORITY_EVENT_CREATED indicator into the request the first time we call the
    // CINT12S save and check it each subsequent time.
    if (StringHelper.isValid((String) request.getAttribute(IntakeConstants.PRIORITY_CHANGED))
        && !"true".equals(request.getAttribute(IntakeConstants.PRIORITY_EVENT_CREATED))) {
      callEntryAUDInRec.setSzCdStageCurrPriority(ContextHelper.getStringSafe(request, "hdnCurrPriority"));
      request.setAttribute(IntakeConstants.PRIORITY_EVENT_CREATED, "true");
    }

    // We only want to set the incoming status back to OPN if the user is not the
    // approver.
    if (CodesTables.CINCMGST_SBA.equals(callEntrySvcStruct.getCdIncmgStatus())
        && ServiceConstants.REQ_FUNC_CD_SAVE.equals(cReqFuncCd) && !GlobalData.isApprovalMode(request)) {
      callEntrySvcStruct.setCdIncmgStatus(CodesTables.CINCMGST_OPN);
    }
    return callEntryAUDInRec;
  }

  /**
   * This submethod contains the logic used to populate the CINT12S CallEntrySvcStruct Stage Information. The logic
   * cases on whether the Intake in question is marked as a Special Request, an I&R, or a normal Intake. The CINT12S
   * service is called under many different circumstances. This is the most complex of the populate logic so it makes
   * sense to seperate it out in a submethod to avoid having to maintain the logic in multiple places.
   * 
   * @param callEntrySvcStruct
   * @param specialReq
   * @param infoRefrl
   * @param classification
   * @param programType
   * @param cReqFuncCd
   * @param allegType
   * @param currPriority
   * @return
   */
  public static CallEntrySvcStruct populateCallEntrySvcStructStageInfo(CallEntrySvcStruct callEntrySvcStruct,
                                                                       String cdNonIncidentReqType, String classification,
                                                                       String programType, String cReqFuncCd,
                                                                       String allegType, String currPriority) {
    // ochumd Sir 23711 this is neccessary here cos CSREQSTG has only one row
    // identified as Code = CAP and Decode = C-REG.
    //String apsSpecialReg = "";
//    if ("CDD".equals(specialReq) || "CAC".equals(specialReq) || "CLE".equals(specialReq) || "CST".equals(specialReq)) {
//      apsSpecialReg = "CAP";
//    }
    callEntrySvcStruct.setCdIncomingProgramType(null);

    if (CodesTables.CNIRTYPE_IC.equals(cdNonIncidentReqType)||CodesTables.CNIRTYPE_PA.equals(cdNonIncidentReqType)||CodesTables.CNIRTYPE_PF.equals(cdNonIncidentReqType)||CodesTables.CNIRTYPE_NI.equals(cdNonIncidentReqType))
    {
      callEntrySvcStruct.setSzCdIncomingDisposition(cdNonIncidentReqType);
      //callEntrySvcStruct.setSzCdSpclReq(specialReq);
      callEntrySvcStruct.setCdIncomingProgramType(programType);
      callEntrySvcStruct.setSzCdStageProgram(programType);
      // Check to see if the the Special Request is case related.
      // It will begin with "C-". If it is not and the save indicator is
      // that of a save to the workload,then insert INT as the stage and
      // SPC as the stage type. If the save indicator is that of save and
      // assign or submit, then insert SPC as the stage and " " as the
      // stage type.
//      if (!specialReq.startsWith(IntakeConstants.CASE_RELATED_SPECREQ_PREFIX)) {
//        if (cReqFuncCd.equals(ServiceConstants.REQ_FUNC_CD_SAVE)) {
//          callEntrySvcStruct.setSzCdStageType(CodesTables.CCLASS_SPC);
//          callEntrySvcStruct.setSzCdStage(CodesTables.CSTAGES_INT);
//        } else if (cReqFuncCd.equals(ServiceConstants.REQ_FUNC_CD_SAVE_AND_SUBMIT)
//                   || cReqFuncCd.equals(ServiceConstants.REQ_FUNC_CD_SAVE_AND_ASSIGN)) {
//          callEntrySvcStruct.setSzCdStage(CodesTables.CCLASS_SPC);
//          callEntrySvcStruct.setSzCdStageType(null);
//        }
//      }
//      // The request is case related and needs to have the
//      // special request code as the stage type.
//      else {
//        // Sir 23711 - At this point if it is APS it must be CRSR.
//        // if ("APS".equals(programType)) {
//        // callEntrySvcStruct.setSzCdStageType(
//        // Lookup.simpleDecodeSafe(CodesTables.CSREQSTG, apsSpecialReg));
//        // }
//        // Sir 23711 - At this point if it is non APS CRSR.
//        // else {
// //       callEntrySvcStruct.setSzCdStageType(Lookup.simpleDecodeSafe(CodesTables.CSREQSTG, specialReq));
//      }
      callEntrySvcStruct.setSzCdStage(CodesTables.CSTAGES_INT);

    }
    // } else if (StringHelper.isValid(infoRefrl)) {
    // // the program code is saved to the stage and case tables.
    // // JMC - CAPS SIR 15265 - We should be able to enter program type for I&R's instead
    // // of always saving PRS.
    // // callEntrySvcStruct.setCdIncomingProgramType(programType);
    // // callEntrySvcStruct.setSzCdStageProgram(programType);
    callEntrySvcStruct.setSzCdStageProgram(CodesTables.CSRPGTYP_CPS);
    // callEntrySvcStruct.setSzCdIncomingDisposition(infoRefrl);
    // callEntrySvcStruct.setSzCdInfoAndRefrl(infoRefrl);
    if (cReqFuncCd.equals(ServiceConstants.REQ_FUNC_CD_SAVE)) {
      callEntrySvcStruct.setSzCdStageType(CodesTables.CCLASS_CPS);
      callEntrySvcStruct.setSzCdStage(CodesTables.CSTAGES_INT);
    } else if (cReqFuncCd.equals(ServiceConstants.REQ_FUNC_CD_SAVE_AND_SUBMIT)
               || cReqFuncCd.equals(ServiceConstants.REQ_FUNC_CD_SAVE_AND_ASSIGN)) {
      callEntrySvcStruct.setSzCdStage(CodesTables.CSTAGES_INT);
      callEntrySvcStruct.setSzCdStageType(CodesTables.CCLASS_CPS);
    }

    // If there is not an I&R or Special Request, the call must be an
    // intake, and must have a stage type code which is a concatenation
    // of the primary allegation and the priority.
    // Note: There are two alleg types in the call decision object. Use
    // IncmgAllegType here because this is what the retrieve service
    // returns. We attempted to use just AllegType and found that
    // the service does not return a value for callDecision.getSzCdAllegType()
//    else if (StringHelper.isValid(allegType) && StringHelper.isValid(currPriority)) {
//      // The program code for an intake depends on the classification
//      // chosen from Call Decision. The first letter of the
//      // classification code will tell the program it belongs to.
//      // CPS //
//      if (classification.startsWith(IntakeConstants.CLASS_PREFIX_CPS)) {
//        callEntrySvcStruct.setSzCdStageProgram(CodesTables.CPGRMS_CPS);
//      } else if (classification.equals(CodesTables.CPGRMS_AFC)) {
//        callEntrySvcStruct.setSzCdStageProgram(CodesTables.CPGRMS_AFC);
//      } else if (classification.startsWith(IntakeConstants.CLASS_PREFIX_APS)) {
//        callEntrySvcStruct.setSzCdStageProgram(CodesTables.CPGRMS_APS);
//      } else if (classification.equals(CodesTables.CCLASS_LCC)) {
//        callEntrySvcStruct.setSzCdStageProgram(CodesTables.CPGRMS_CCL);
//      } else if (classification.equals(CodesTables.CCLASS_LRC)) {
//        callEntrySvcStruct.setSzCdStageProgram(CodesTables.CPGRMS_RCL);
//      }
//      // The intake has fallen through the logic to chose a program.
//      // Send a generic program to insure the Assign logic will not fail.
//      else {
//        callEntrySvcStruct.setSzCdStageProgram(CodesTables.CSRPGTYP_CPS);
//      }
//      callEntrySvcStruct.setSzCdStageType(allegType + currPriority);
//      callEntrySvcStruct.setSzCdStage(CodesTables.CSTAGES_INT);
//    }

    // This is just a catch-all. When we save the Intake and not enough information
    // is entered, this is the logic that will determine what information we save to
    // the workload.
    //
    else {
      callEntrySvcStruct.setSzCdStageType(null);
      callEntrySvcStruct.setSzCdStage(CodesTables.CSTAGES_INT);
      callEntrySvcStruct.setSzCdIncomingDisposition(null);
    }
    return callEntrySvcStruct;
  }
}
