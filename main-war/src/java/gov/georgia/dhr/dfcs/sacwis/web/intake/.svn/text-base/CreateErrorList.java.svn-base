package gov.georgia.dhr.dfcs.sacwis.web.intake;

import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CallEntryRtrvOut;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FacilRtrvOutRec;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PersListRtrvStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PersListRtrvStruct_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT76DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT76DO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

/* Change History:
 Date      User      Description
 --------  --------  ----------------------------------------------------------
 03/30/04  resertg   SIR 22616 - Added code to throw MSG_INT_REMOVE_EXPC_ALLEG
 when needed.  Also updated Javadocs, cleaned up imports.
 04/05/04  resertg   Converted duplicate Literals to Constants, removed unused
 local variables.

 07/13/04 ochumd      Sir 22934 - Replaced all references to cint19d with cint76d.

 03/01/05 Ochumd      Sir 23428 - An error message regarding VP's in CPS cases is
 appearing when attempting to close a call as an I&R while
 there are still people on the Person List. Romoved I&R and
 Special Requests from this edit. Message Number : 38.
 05/09/05 ochumd      SIR 23019 - CFH,CCL and CCR are new CRSR types that have
 case names as facility names. Therefore,they should be
 excluded from Messages.MSG_INT_COUNTY_REQUD edit.
 06/30/05 ochumd      Sir 23711 - fixed and error created by an earlier sir fix.
 05/22/2008  arege       STGAP00008680 added an if condition to let user save a 
                         special circumstances Intake.
 09/18/2008  arege       STGAP00010093 : Rewrote an if condition so that System does not allow 
                         Save and Submit without a Narrative from Intake Information Page.  
 05/28/2009  hjbaptiste  STGAP00010103: Added additional condition to set MSG_INT_REC_ALLEG and MSG_INT_ONE_PRINC_VICTIM
                         when victim is required which now will not included when Child Death has  been selected as a 
                         Special Investigation call type and the Reason of Death is Natural Cause or Accidental Death. 
                         Program Area is also not required with Child Death intakes                                       
 06/30/2010 bgehlot   SMS# 60651 End dated the CD, SI and NF code and created CDNC, SINC and NFNC codes. Replaced the old ones with new ones.
 12/01/2010 cwells    SMS 76324 Displaying error message when an informational Intake is submitted. 
<pre>
 */

public class CreateErrorList {
  public static final String TRACE_TAG = "CreateErrorList";

  private CreateErrorList() {
  }

  public static int[] create(IntakeDataBean intake, UserProfile user, int buttonPressed) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".finalEdit()" + new Date());

    CallEntryRtrvOut callEntryRtrvOut = intake.getCallEntryDecision();
    PersListRtrvStruct_ARRAY personListArray = intake.getPersonlistarray();
    FacilRtrvOutRec facilRtrvOutRec = intake.getFacility();
    ROWCINT76DO_ARRAY allegListArray = intake.getAllegListArray();

    // Do a null check on all the structures passed in to the finalEdit method.
    if (callEntryRtrvOut == null) {
      callEntryRtrvOut = new CallEntryRtrvOut();
    }
    if (personListArray == null) {
      personListArray = new PersListRtrvStruct_ARRAY();
    }
    if (facilRtrvOutRec == null) {
      facilRtrvOutRec = new FacilRtrvOutRec();
    }
    if (allegListArray == null) {
      allegListArray = new ROWCINT76DO_ARRAY();
    }

    List usMessageList = new ArrayList();

    gov.georgia.dhr.dfcs.sacwis.structs.output.DetermListAUD determinationFactors = callEntryRtrvOut.getDetermListAUD();
    if (determinationFactors == null) {
      determinationFactors = new gov.georgia.dhr.dfcs.sacwis.structs.output.DetermListAUD();
    }

    // Unpack the above objects. We will need some of the "sub-objects" later.
    gov.georgia.dhr.dfcs.sacwis.structs.output.CallEntrySvcStruct callEntryData = callEntryRtrvOut
                                                                                                  .getCallEntrySvcStruct();
    if (callEntryData == null) {
      callEntryData = new gov.georgia.dhr.dfcs.sacwis.structs.output.CallEntrySvcStruct();
    }

    // Add in comments -
    String disposition = FormattingHelper.formatString(callEntryData.getSzCdIncomingDisposition());
    if (!disposition.equals(StringHelper.EMPTY_STRING)
        && (disposition.startsWith(IntakeConstants.NON_CASE_RELATED_PREFIX) || disposition
                                                                                          .startsWith(IntakeConstants.CASE_RELATED_SPECREQ_PREFIX))) {
      callEntryData.setSzCdSpclReq(disposition);
    } else if (!disposition.equals(StringHelper.EMPTY_STRING)) {
      callEntryData.setSzCdInfoAndRefrl(disposition);
    }
    gov.georgia.dhr.dfcs.sacwis.structs.output.CallDcsnAUD callDecisionData = callEntryRtrvOut.getCallDcsnAUD();
    if (callDecisionData == null) {
      callDecisionData = new gov.georgia.dhr.dfcs.sacwis.structs.output.CallDcsnAUD();
    }

    gov.georgia.dhr.dfcs.sacwis.structs.output.FacDetailEntStruct facilityData = facilRtrvOutRec
                                                                                                .getFacDetailEntStruct();
    if (facilityData == null) {
      facilityData = new gov.georgia.dhr.dfcs.sacwis.structs.output.FacDetailEntStruct();
    }

    // Instantiate these object for later use
    Enumeration personEnum = null;
    Enumeration allegEnum = null;
    PersListRtrvStruct personRow = new PersListRtrvStruct();
    ROWCINT76DO allegRow = new ROWCINT76DO();

    // The following are boolean variables that are used through out Final Edits.
    boolean bCPSCCLRCCL = false;
    boolean bAPSFacility = false;
    boolean bAPSCommunity = false;
    boolean bAPSOutOfState = false;
    boolean bAPSOtherAgency = false;
    boolean bCPSCommunity = false;
    boolean bSearchPerson = false;
    boolean bRealPeopleExist = false;
    boolean bAllegationsExists = false;
    boolean bEXPLOnly = false;
    boolean bAPSDisabFactors = false;
    boolean bEmancipatedMinor = false;
    boolean bAged = false;
    boolean bAssign = false;
    boolean bSubmit = false;
    boolean bClose = false;
    boolean prnAP_VPExists = false;
    
    
    
    // Defect STGAP00000244 When saving and submitting from Intake Information for a
    // Non-Incident Request Type an error list of irrelevent errors is shown instead of
    // saving and submitting.

    boolean bNonIncidentReqType = false;

    switch (buttonPressed) {
    case IntakeConstants.SUBMIT_BUTTON:
      bSubmit = true;
      break;
    case IntakeConstants.ASSIGN_BUTTON:
      bAssign = true;
      break;
    case IntakeConstants.CLOSE_BUTTON:
      bClose = true;
      break;
    }

    // The following are string variables that will be used through out the Final Edits
    String stageClassification = FormattingHelper.formatString(callDecisionData.getSzCdStageClassification());
    String personType = StringHelper.EMPTY_STRING;
    String personRole = StringHelper.EMPTY_STRING;
    String alleg = StringHelper.EMPTY_STRING;
    // String spclReq = FormattingHelper.formatString(callEntryData.getSzCdSpclReq());

    // The following are counters/ints that will be used through out the Final Edits
    int usCINT03WRows = 0; // This will hold the number of Determination Factors
    int usCINT04WRows = 0; // This will hold the number of Persons on the Person List
    int usCINT07WRows = 0; // This will hold the number of Allegations on the Allegation List
    int usRelevantFactors = 0; // Holds the number of relevant Determination factors.
    // int usOldestVictimPrinciples = 0; // Hold the number of principals designated as 'OV'
    int usNbrVCVPPrinciples = 0;

    // True if classification is type CPS, CCL, or RCCL.
    bCPSCCLRCCL = (stageClassification.startsWith(IntakeConstants.CCLASS_PREFIX_CPS) || stageClassification
                                                                                                           .startsWith(IntakeConstants.CCLASS_PREFIX_LICENSE));

    // True if the call has been marked as an Info and Referall or Classified as an I&R
    // bIAndR = (StringHelper.isValid(callEntryData.getSzCdInfoAndRefrl()) || stageClassification
    // .equals(CodesTables.CCLASS_IR));

    // True if the classification is SPC or I&R
    // bSPCIR = (stageClassification.equals(CodesTables.CCLASS_SPC) ||
    // stageClassification.equals(CodesTables.CCLASS_IR));

    // True if the special request entered starts with a "N"

    // True if classification is an APS Facility
    bAPSFacility = (stageClassification.equals(CodesTables.CCLASS_AFC));

    // True if classification is an APS Community
    bAPSCommunity = (stageClassification.equals(CodesTables.CCLASS_APS));

    // True if classification is an APS Out of State
    bAPSOutOfState = (stageClassification.equals(CodesTables.CCLASS_AOS));

    // True if classification is an APS Other State Agency
    bAPSOtherAgency = (stageClassification.equals(CodesTables.CCLASS_AOA));

    // True if classification is a CPS Community
    bCPSCommunity = (stageClassification.equals(CodesTables.CCLASS_CPS));

    // The following will be used by message number 42. It determines whether the person list box is to be searched.
    bSearchPerson = ((stageClassification.startsWith(IntakeConstants.CCLASS_PREFIX_CPS)) || (bAPSCommunity)
                     || (bAPSOutOfState) || (bAPSOtherAgency) || (stageClassification.equals(CodesTables.CCLASS_SPC)));

    bNonIncidentReqType = ((callEntryData.getSzCdNonRsdntReqType() != null) && !StringHelper.EMPTY_STRING
                                                                                                         .equals(callEntryData
                                                                                                                              .getSzCdNonRsdntReqType()));

    // The following will find the number of Determination Factors
    gov.georgia.dhr.dfcs.sacwis.structs.output.CdIncmgDeterm_ARRAY determArray = determinationFactors
                                                                                                     .getCdIncmgDeterm_ARRAY();
    if (determArray == null) {
      determArray = new gov.georgia.dhr.dfcs.sacwis.structs.output.CdIncmgDeterm_ARRAY();
    }
    usCINT03WRows = determArray.getCdIncmgDetermCount();

    // FIX UNTIL getCount() WORKS - IF IT EVER WORKS
    // Enumerate through the determination factors and get a count of how many there are since
    // getCount() does not appear to work.
    Enumeration e = determArray.enumerateCdIncmgDeterm();
    usCINT03WRows = 0;
    while (e.hasMoreElements()) {
      String n = (String) e.nextElement();
      if ((n != null) && (!n.equals(StringHelper.EMPTY_STRING))) {
        usCINT03WRows++;
      }
    }
    // END TESTING

    // The following will be used to hold the number of rows in the Person List.
    usCINT04WRows = personListArray.getPersListRtrvStructCount();

    // True if entries exist in the Person List
    bRealPeopleExist = (usCINT04WRows > 0) ? true : false;

    // The following will find the number of Allegations in the Allegation List
    usCINT07WRows = allegListArray.getROWCINT76DOCount();

    // True is Allegations exist on the ALlegation List.
    bAllegationsExists = (usCINT07WRows > 0) ? true : false;

    // The following is a list of APS disability factors. The boolean
    // bAPSDisabFactors is based on this part of this list. The factors
    // that are considered to be disability factors are marked with a '*'.
    // Aged CAG
    // Chemical Dependency CCD *
    // Emancipated Minor CEM
    // Hearing Impaired CHI *
    // Mental Illness CMI *
    // Mental Retardation CMR *
    // Physically Disabled CPD *
    // Visually Impaired CVI *
    Enumeration determEnum = determArray.enumerateCdIncmgDeterm();
    String determFactor = StringHelper.EMPTY_STRING;
    while (determEnum.hasMoreElements()) {
      determFactor = FormattingHelper.formatString((String) determEnum.nextElement());
      bAPSDisabFactors = bAPSDisabFactors || determFactor.equals(CodesTables.CADETFCT_CCD)
                         || determFactor.equals(CodesTables.CADETFCT_CHI)
                         || determFactor.equals(CodesTables.CADETFCT_CMI)
                         || determFactor.equals(CodesTables.CADETFCT_CMR)
                         || determFactor.equals(CodesTables.CADETFCT_CPD)
                         || determFactor.equals(CodesTables.CADETFCT_CVI);

      bEmancipatedMinor = bEmancipatedMinor || determFactor.equals(CodesTables.CADETFCT_CEM);
      bAged = bAged || determFactor.equals(CodesTables.CADETFCT_CAG);
    }

    // begin mcclaim 06/16/2003, messages left out of CreateErrorList,
    // but in section 1.1.10 of Call Information Detailed Design.doc

    // Messages.MSG_INT_WRONG_PRINCPL_ROLE
    if (bAPSCommunity) {
      personEnum = personListArray.enumeratePersListRtrvStruct();

      while (personEnum.hasMoreElements()) {
        personRow = (PersListRtrvStruct) personEnum.nextElement();

        if (((CodesTables.CPRSNTYP_PRN).equals(personRow.getSzCdStagePersType()))
            && ((CodesTables.CINTROLE_AP).equals(personRow.getSzCdStagePersRole()) == false)
            && ((CodesTables.CINTROLE_VC).equals(personRow.getSzCdStagePersRole()) == false)
            && ((CodesTables.CINTROLE_VP).equals(personRow.getSzCdStagePersRole()) == false)) {
          usMessageList.add(Messages.MSG_INT_WRONG_PRINCPL_ROLE);
          break;
        }
      }
    }

    // Messages.MSG_INT_VP_UNDER_10
    if (bCPSCCLRCCL) {
      personEnum = personListArray.enumeratePersListRtrvStruct();

      while (personEnum.hasMoreElements()) {
        personRow = (PersListRtrvStruct) personEnum.nextElement();
        int age = getAge(personRow);

        if ((age < 10) && (age != -1) && (CodesTables.CINTROLE_VP.equals(personRow.getSzCdStagePersRole()))) {
          usMessageList.add(Messages.MSG_INT_VP_UNDER_10);
          break;
        }
      }
    }

    // MSG_INT_INITIAL_PRIORITY_CPS - prevented by javascript for selecting something
    // other than 'N', '1', or '2'

    // MSG_INT_INI_PRIOR_APS_COM - prevented by javascript from selecting 'N'

    // MSG_INT_ASSIGN_PRIORITY
    // "You have entered a closure cd. Assign a priority ?N? or remove the closure cd."
    // Actually javascript prevents you from having something other than "N" as priority
    // and a closure code

    // end mcclaim

    /*
     * Error Message : A Facility Search must be performed on an AFC or * LIC Intake. * * Psuedo Code : If (Facility *
     * Name field != NULL) AND (Search checkbox on * Facility Detail = unchecked) * * Assumptions : ***AFC/MHMR*** This
     * message will now appear in the * error list window, a user will not be able to exit * intake without doing a
     * search on the facility for * AFC and CCL (LIC) cases. * Assumed that only workers entering AFC or LIC intakes *
     * will edit the facility window (thus edit the Name field). * * Save States : Assign, Submit * * Message Number : 1
     */
    // String facilSearchInd = FormattingHelper.formatString(facilityData.getBIndIncmgFacilSearch());
    // if (!bSPCIR &&
    // ((StringHelper.isValid(facilityData.getNmIncmgFacilName())) &&
    // !(facilSearchInd.equals(IntakeConstants.INDICATOR_YES)))) {
    // // A search has not been conducted.
    // usMessageList.add(Messages.MSG_INT_RESOURCE_SEARCH);
    // }
    /*
     * Error Message : A Facility Type must be entered for an AFC or LIC * Intake. * * Psuedo Code : If (Classification !=
     * I&R OR SPC) AND (Facility * Type field == NULL) AND (Facility * Name field != NULL) * * Assumptions : Only
     * workers entering AFC or LIC intakes will edit * the facility window (thus edit the Name field). * * Save States :
     * Assign, Submit * * Message Number : 2
     */
    // if (!bSPCIR &&
    // (StringHelper.isValid(facilityData.getNmIncmgFacilName()) &&
    // ((FormattingHelper.formatString(facilityData.getSzCdIncmgFacilType())).equals(StringHelper.EMPTY_STRING))) &&
    // (bAssign ||
    // bSubmit))
    // {
    // usMessageList.add(Messages.MSG_INT_AFC_REQ_TYPE);
    // }
    /*
     * * Error Message : VC's under age 7 with 'head/face inj', 'serious inj' and * 'VC access. to AP' require initial
     * priority '1'. * * Psuedo Code : If (Classification = CPS OR CCL OR RCCL) AND (age < 7 AND * (CPS Determination
     * factors = 'head/face injury' AND * 'serious injury' AND 'VC accessible to AP') AND * (Initial Priority != 1) * *
     * Assumptions : Determining factors include but are not limited to the above * list. * * Save States : Assign,
     * Submit * * Message Number : 3
     */
    if (bCPSCCLRCCL && !((CodesTables.CCPSPRTY_1).equals(callDecisionData.getSzCdStageInitialPriority()))
        && (bAssign || bSubmit)) {
      // In the following loop it is assumed each factor will appear only once.
      determEnum = determArray.enumerateCdIncmgDeterm();
      determFactor = StringHelper.EMPTY_STRING;
      while (determEnum.hasMoreElements()) {
        determFactor = FormattingHelper.formatString((String) determEnum.nextElement());
        if (determFactor.equals(CodesTables.CCDETFCT_FH) || determFactor.equals(CodesTables.CCDETFCT_SER)
            || determFactor.equals(CodesTables.CCDETFCT_AAP)) {
          usRelevantFactors++;
        }
      }
      // If enough Relevant Factors have been found then the age and
      // role of each person must be checked. (See NOTE below for info on ROLE)
      if (usRelevantFactors == IntakeConstants.MINIMUM_CPS_FACTORS) {
        personEnum = personListArray.enumeratePersListRtrvStruct();
        personRow = new PersListRtrvStruct();
        while (personEnum.hasMoreElements()) {
          personRow = (PersListRtrvStruct) personEnum.nextElement();
          // At this point if a person under 7 is found, we will exit the loop and add an error
          // to the error list. NOTE: In the original CAPs comment, it is mentioned that
          // the person must be an alleged victim. However, the CAPs code did not actually case on
          // Role. This might need to be re-evaluated in the future.

          int age = getAge(personRow);
          if ((age < IntakeConstants.HIGH_PRIORITY_AGE) && (age != -1)) {
            usMessageList.add(Messages.MSG_INT_PRIORITY1_REQUIRED);
            break;
          }
        }
      }
    }

    /*
     * Error Message : APS allegations require an alleged victim, * allegation type and alleged perpetrator. * * Psuedo
     * Code : If (Classification = APS OR APS Facility) AND * (VC column = NULL OR Alleg. column = NULL OR AP * column =
     * NULL). * * Assumptions : All allegation types are searched for. The search * is not limited to APS allegations. * *
     * Save States : Assign, Submit * * Message Number : 4
     */
    if ((bAPSCommunity || bAPSFacility) && (bAssign || bSubmit)) {
      allegEnum = allegListArray.enumerateROWCINT76DO();
      while (allegEnum.hasMoreElements()) {
        allegRow = (ROWCINT76DO) allegEnum.nextElement();
        if ((allegRow.getUlIdVictim() == 0) || !StringHelper.isValid(allegRow.getSzCdIntakeAllegType()) ||
        // Location of Maltreatment,Maltreatment Code,Date of Alleged Incident
            !StringHelper.isValid(allegRow.getSzCdIntakeAllegMalCode()) || (allegRow.getUlIdAllegedPerpetrator() == 0)) {
          usMessageList.add(Messages.MSG_INT_APS_ALLEG_REQ_FLDS);
          break;
        }

      }
    }

    /*
     * Error Message : Calls assigned a priority of 'N' must be submitted * for approval. * * Psuedo Code : If
     * (Classification = CPS OR CCL OR RCCL) AND * (Initial Priority = 'N') AND NOT (Security to * assign intakes
     * directly). * * Assumptions : Nothing in the following code checks to see if this * is a submit for final
     * apporoval. This final edit * will not be displayed if the intake worker has * permission to assign directly. This
     * is based on * his security profile. * * Save States : Assign, Close * * Message Number : 5
     */
    if (bCPSCCLRCCL && ((CodesTables.CCPSPRTY_N).equals(callDecisionData.getSzCdStageInitialPriority()))
         && (bAssign || bClose)) {
      usMessageList.add(Messages.MSG_INT_PRIORITY_N_SUBMIT);
    }

 // Definition of child in this case is a PRINCIPAL under 18
    int principalChildCount = 0;
    int deadChildCount = 0;
    boolean isAccidentalDeath = false;
    boolean isNaturalCause = false;
    boolean requireProgramArea = true;
    personEnum = personListArray.enumeratePersListRtrvStruct();
    while (personEnum.hasMoreElements()) {
      personRow = (PersListRtrvStruct) personEnum.nextElement();
      int personRowAge = personRow.getLNbrPersonAge();
      String personRowType = personRow.getSzCdStagePersType();
      personRole = personRow.getSzCdStagePersRole();
      //STGAP00010103 Person with null DOB don't get added to the principalChildCount
      if ((!DateHelper.isNull(personRow.getDtDtPersonBirth())|| (personRow.getSzCdPersonDeath() != null && !StringHelper.EMPTY_STRING.equals(personRow.getSzCdPersonDeath())))
                      && personRowAge < 18 && StringHelper.isValid(personRowType) && CodesTables.CPRSNTYP_PRN.equals(personRowType)) {
        principalChildCount++;
        if (DateHelper.isNull(personRow.getDtDtPersonDeath())==false) {
          deadChildCount++;
        }
        // STGAP00010103: Do not require Program Area if the Reason of Death is Accidental Death or Natural Cause.
        isAccidentalDeath = (CodesTables.CRSNFDTH_ADH.equals(personRow.getSzCdPersonDeath()));
        isNaturalCause = (CodesTables.CRSNFDTH_NCE.equals(personRow.getSzCdPersonDeath()));
      }
      
      if ((principalChildCount - deadChildCount >= 0)  || (isAccidentalDeath || isNaturalCause)) {
        requireProgramArea = false;
      }
    }
    /*
     * Error Message : You must select Program Area
     */
    if (!bNonIncidentReqType && (bAssign || bSubmit) && requireProgramArea) {
      if (StringHelper.EMPTY_STRING.equals(stageClassification)) {
        usMessageList.add(Messages.MSG_INT_PROG_AREA);
      }
    }
    
    /*
     * Error Message : Persons assigned the Rel/Int code of 'OV' must be * assigned the role code of victim. * * Psuedo
     * Code : If (Classification != SPC OR I&R) AND (Rel/Int = * 'OV' AND Role != 'VC') (This must be checked for * each
     * person). * * Assumptions : * * Save States : Assign, Submit * * Message Number : 6
     */
    // if (!bSPCIR) {
    // personEnum = personListArray.enumeratePersListRtrvStruct();
    // while (personEnum.hasMoreElements()) {
    // personRow = (PersListRtrvStruct) personEnum.nextElement();
    // if (((CodesTables.CRPTRINT_OV).equals(personRow.getSzCdStagePersRelInt())) &&
    // !((CodesTables.CINTROLE_VC).equals(personRow.getSzCdStagePersRole())) &&
    // !((CodesTables.CINTROLE_VP).equals(personRow.getSzCdStagePersRole()))) {
    // usMessageList.add(Messages.MSG_INT_OV_ROLE_CODE);
    // break;
    // }
    // }
    // }
    /*
     * Error Message : Allegations of A/N/E have been recorded. The report * must be classified and forwarded or CWA. * *
     * Psuedo Code : If (Allegations exist) AND (Classification = SPC OR * I&R) * * Assumptions : ANE allegations make
     * up all allegation types. * * Save States : Assign, Close, Submit * * Message Number : 7
     */
    // if (bAllegationsExists && bSPCIR) {
    // usMessageList.add(Messages.MSG_INT_CALLS_WITH_ALLEGS);
    // }
    /*
     * Error Message : At least one principal must be a victim. * * Psuedo Code : If (Classification != I&R OR SPC) and
     * (Role!= 'VC' * or 'VP' for at least one PRN). * * Assumptions : You must assign at least one principal the role
     * of * 'VC' or 'VP' (alleged victim or victim/perp).** * * Save States : Assign, Submit * * Message Number : 8
     */
    String specialCircumstances = callEntryData.getSzCdSpclCircumstances();
    String specInvestigation = callEntryData.getSzCdSpclInvstgtn();
    boolean noVCReqd = false;
    //STGAP00008680
    noVCReqd = (CodesTables.CSPECCIR_JCN.equals(specialCircumstances)
                    || CodesTables.CSPECCIR_OHA.equals(specialCircumstances)
                    || CodesTables.CSPECCIR_SEC.equals(specialCircumstances)
                    || CodesTables.CSPECCIR_SPN.equals(specialCircumstances) 
                    || CodesTables.CSPECCIR_VIP.equals(specialCircumstances)
                    || ((CodesTables.CSPECREQ_CDNC.equals(specInvestigation) || CodesTables.CSPECREQ_CDIC.equals(specInvestigation)) && (isAccidentalDeath || isNaturalCause)));
    
    if (!bNonIncidentReqType && (bAssign || bSubmit)) {

      if (!noVCReqd) {

        personEnum = personListArray.enumeratePersListRtrvStruct();
        boolean personExists = false;
        // This loop will be exited as soon as a one principal victim is found. If a principal
        // victim is not found then an error will be added to the Error List vector.
        while (personEnum.hasMoreElements()) {
          personRow = (PersListRtrvStruct) personEnum.nextElement();
          if (((CodesTables.CPRSNTYP_PRN).equals(personRow.getSzCdStagePersType()))
              && (((CodesTables.CINTROLE_VC).equals(personRow.getSzCdStagePersRole())) || ((CodesTables.CINTROLE_VP)
                                                                                                                    .equals(personRow
                                                                                                                                     .getSzCdStagePersRole())))) {
            personExists = true;
            break;
          }
        }
        if (!personExists) {
          usMessageList.add(Messages.MSG_INT_ONE_PRINC_VICTIM);
        }
      }
    }
    /*
     * Error Message : Only one principal may be assigned the Rel/Int of * 'OV' (oldest victim).** * * Psuedo Code : If
     * (more than one PRN's Rel/Int = 'OV') * * Assumptions : * * Save States : Assign, Submit * * Message Number : 9
     */
    // if (bAssign || bSubmit) {
    // personEnum = personListArray.enumeratePersListRtrvStruct();
    // while (personEnum.hasMoreElements()) {
    // personRow = (PersListRtrvStruct) personEnum.nextElement();
    // if (((CodesTables.CPRSNTYP_PRN).equals(personRow.getSzCdStagePersType())) &&
    // ((CodesTables.CRPTRINT_OV).equals(personRow.getSzCdStagePersRelInt()))) {
    // usOldestVictimPrinciples++;
    // }
    // }
    // if (usOldestVictimPrinciples > IntakeConstants.MAX_OLDEST_VICTIM_PRN) {
    // usMessageList.add(Messages.MSG_INT_ONE_PRINCIPAL_OV);
    // }
    // }
    /*
     * Error Message : You have not entered the Call Narrative. * * Psuedo Code : If (Classification != SPC OR I&R) AND
     * (Call * Narrative not accessed). * * Assumptions : The blob will not be saved until the end. * Therefore the
     * narrative has been accessed if and * only if the data has changed. Opening the record * call dialogue but not
     * changing any data does not * constitute accessing. * * Save States : Assign, Submit * * Message Number : 10
     */
    // STGAP00010093 : Modified the if condition so that 
    // System does not allow Save and Submit without a Narrative from Intake Information. 
    if ((!intake.hasCallNarr()) && (bAssign || bSubmit)) {
      usMessageList.add(Messages.MSG_INT_NO_CALL_NARRATIVE);
    }

    /*
     * Error Message : There are no allegations recorded. States : Assign, Submit * * Message Number : 11
     */
    if (!bNonIncidentReqType && !bAllegationsExists && !noVCReqd && (bAssign || bSubmit)) {
      usMessageList.add(Messages.MSG_INT_NO_ALLEGATIONS);
    }
    
    
    //  SMS 76324 Displaying message and not allowing user to save and submit IR(Information) Intakes 
    if(CodesTables.CINRTYPE_IR.equals(callEntryData.getSzCdNonRsdntReqType()) && bSubmit){
    	usMessageList.add(Messages.MSG_INT_IR_SUBMIT);
    }
    

    
    /* STGAP00007568,If the  SaveandSubmit or Save button, if the PrimaryCaretaker has no County.
     * Error Message : County is required for the Primary Caretaker.
     */     
    if (!bNonIncidentReqType)
      if (bSubmit) {
        personEnum = personListArray.enumeratePersListRtrvStruct();
        while (personEnum.hasMoreElements()) {
          personRow = (PersListRtrvStruct) personEnum.nextElement();
          if (personRow != null && CodesTables.CRELVICT_PK.equals(personRow.getSzCdStagePersRelInt()))
            if (!StringHelper.isValid(personRow.getSzCdAddrCounty())) {
              usMessageList.add(Messages.MSG_INT_COUNTY_REQUD);
              break;
            }
        }
      }
    /*
     * Error Message : Suicidal Threat has been alleged. The AP and the * VC must be the same person (of Role VP). * *
     * Psuedo Code : If (Classification = APS Community) AND (Alleg. = * SUTH AND AP column on Allegation List != AV
     * column * on Allegation List) (This must be checked for each * allegation). * * Assumptions : * * Save States :
     * Assign, Submit * * Message Number : 12
     */
    if (bAPSCommunity && (!bNonIncidentReqType && (bAssign || bSubmit))) {
      allegEnum = allegListArray.enumerateROWCINT76DO();
      while (allegEnum.hasMoreElements()) {
        allegRow = (ROWCINT76DO) allegEnum.nextElement();
        if ((CodesTables.CABALTYP_SUTH).equals(allegRow.getSzCdIntakeAllegType())
            && (allegRow.getUlIdAllegedPerpetrator() != allegRow.getUlIdVictim())) {
          usMessageList.add(Messages.MSG_INT_SUICIDAL_THREAT);
          break;
        }
      }
    }

    /*
     * Error Message : You must assign an initial priority to this report. * * Psuedo Code : If (Classification != SPC
     * OR I&R) AND (Initial * Priority = NULL). * * Assumptions : * * Save States : Assign, Submit * * Message Number :
     * 13
     */
    if (!bNonIncidentReqType && !(StringHelper.isValid(callDecisionData.getSzCdStageInitialPriority()))
        && (bAssign || bSubmit)) {
      usMessageList.add(Messages.MSG_INT_ASSIGN_INIT_PRIORITY);
    }

    /*
     * Error Message : The VC and AP within one allegation tried may not be * the same person. * * Psuedo Code : If
     * (Classification = CPS OR CCL OR RCCL) AND ('VC' * column on Allegation List = 'AP'column on Allegation * List)
     * (This must be checked for each allegation.) * * Assumptions : * * Save States : Assign, Submit * * Message Number :
     * 14
     */
    if (!bNonIncidentReqType && bCPSCCLRCCL && (bAssign || bSubmit)) {
      allegEnum = allegListArray.enumerateROWCINT76DO();
      while (allegEnum.hasMoreElements()) {
        allegRow = (ROWCINT76DO) allegEnum.nextElement();
        if (allegRow.getUlIdAllegedPerpetrator() == allegRow.getUlIdVictim()) {
          usMessageList.add(Messages.MSG_INT_VC_AP_NOT_SAME);
          break;
        }
      }
    }
    /*
     * Error Message : You must assign a different individual the roles of * alleged victim and alleged perpetrator for
     * this * allegation type. * * Psuedo Code : If (Classification = APS Community) AND (Alleg. = * EMAB OR PHAB OR
     * SXAB OR EXPL AND 'AP' column on * Allegation List = 'AV'column on Allegation List) * (This must be checked for
     * each allegation.) * * Assumptions : *+ * Save States : Assign, Submit * * Message Number : 15
     */
    if (!bNonIncidentReqType && bAPSCommunity && (bAssign || bSubmit)) {
      allegEnum = allegListArray.enumerateROWCINT76DO();
      while (allegEnum.hasMoreElements()) {
        allegRow = (ROWCINT76DO) allegEnum.nextElement();
        alleg = FormattingHelper.formatString(allegRow.getSzCdIntakeAllegType());
        if ((alleg.equals(CodesTables.CABALTYP_EMAB) || alleg.equals(CodesTables.CABALTYP_PHAB)
             || alleg.equals(CodesTables.CABALTYP_SXAB) || alleg.equals(CodesTables.CABALTYP_EXPL))
            && (allegRow.getUlIdAllegedPerpetrator() == allegRow.getUlIdVictim())) {
          usMessageList.add(Messages.MSG_INT_ASSIGN_DIFRNT_ROLES);
          break;
        }
      }
    }

    /*
     * Error Message : You must assign at least one principal a role of * 'AP' or 'VP.' * * Psuedo Code : If
     * (Classification = APS Community) AND (Person * Type = PRN AND Role != 'AP' OR 'VP'). (Edit message * should
     * appear only if this condition is truefor * each and every person. As soon as it is false for * one person, the
     * edit is satisfied.) * * Assumptions : * * Save States : Assign, Submit * * Message Number : 16
     */
    if (!bNonIncidentReqType && bAPSCommunity && (bAssign || bSubmit)) {
      personEnum = personListArray.enumeratePersListRtrvStruct();
      while (personEnum.hasMoreElements()) {
        personRow = (PersListRtrvStruct) personEnum.nextElement();
        if (((CodesTables.CPRSNTYP_PRN).equals(personRow.getSzCdStagePersType()))
            && (((CodesTables.CINTROLE_VC).equals(personRow.getSzCdStagePersRole())) || ((CodesTables.CINTROLE_VP)
                                                                                                                  .equals(personRow
                                                                                                                                   .getSzCdStagePersRole())))) {
          prnAP_VPExists = true;
          break;
        }
      }
      if (!prnAP_VPExists) {
        usMessageList.add(Messages.MSG_INT_ONE_PRINC_AP);
      }
    }

    /*
     * Error Message : Victim does not meet the statutory definitions for * an APS situation. * * Psuedo Code : If
     * (Classification = APS Community) AND (Role = 'VP' * OR 'VC') NOT((age >= 65) AND (APS Determination * Factors =
     * Aged) OR (18 <= age <= 64) AND (APS * Determination Factors = any of the disability codes) * OR (0 < Age < 18)
     * AND (APS Determination Factors = * Emancipated Minor) AND (Disability Factors)) * * Assumptions : The independant
     * variable "(Role = 'VP' OR 'VC')" * has been factored out of the previous version of * the psuedo code and placed
     * in front of the first * "NOT". This change will make it so that this * final edit will never go off for 'AP's. * *
     * Error will be logged if there is no age specified * (see change history for details). This affects the * third
     * valid APS scanerio. The constraint * "(Age < 18)" has been changed to "(0 < Age < 18)" * * Save States : Assign,
     * Submit * * Message Number : 17
     */
    if (!bNonIncidentReqType && bAPSCommunity && (bAssign || bSubmit)) {
      personEnum = personListArray.enumeratePersListRtrvStruct();
      while (personEnum.hasMoreElements()) {
        personRow = (PersListRtrvStruct) personEnum.nextElement();
        personRole = FormattingHelper.formatString(personRow.getSzCdStagePersRole());

        boolean roleVcOrVp = ((CodesTables.CINTROLE_VC).equals(personRole) || (CodesTables.CINTROLE_VP)
                                                                                                       .equals(personRole));

        int age = getAge(personRow);

        boolean passedRetirement = (age >= IntakeConstants.RETIREMENT_AGE);
        boolean legalAdult = (age >= IntakeConstants.LEGAL_ADULT_AGE);
        boolean ageEntered = (age != -1);

        if (roleVcOrVp &&

        !((passedRetirement && bAged) ||

        (!passedRetirement && legalAdult && bAPSDisabFactors) ||

        (ageEntered && !legalAdult && bEmancipatedMinor && bAPSDisabFactors))) {
          usMessageList.add(Messages.MSG_INT_VC_STATUTORY);
          break;
        }
      }
    }

    /*
     * Error Message : You may only assign one principal the role of 'VC' * (alleged victim). * * Psuedo Code : If
     * (Classification = APS Community) AND (more than one person of Type = PRN * has Role = 'VC' OR 'VP'). * *
     * Assumptions : * * Save States : Assign, Submit * * Message Number : 18
     */
    if (!bNonIncidentReqType && bAPSCommunity && (bAssign || bSubmit)) {
      personEnum = personListArray.enumeratePersListRtrvStruct();
      usNbrVCVPPrinciples = 0;
      while (personEnum.hasMoreElements()) {
        personRow = (PersListRtrvStruct) personEnum.nextElement();
        personRole = FormattingHelper.formatString(personRow.getSzCdStagePersRole());
        personType = personRow.getSzCdStagePersType();
        boolean roleVcOrVp = ((CodesTables.CINTROLE_VC).equals(personRole) || (CodesTables.CINTROLE_VP)
                                                                                                       .equals(personRole));

        if (((CodesTables.CPRSNTYP_PRN).equals(personType)) && roleVcOrVp) {
          usNbrVCVPPrinciples++;
          if (usNbrVCVPPrinciples > IntakeConstants.MAX_PRN_VP_VC) {
            usMessageList.add(Messages.MSG_INT_ONE_VC);
            break;
          }
        }
      }
    }

    /*
     * Error Message : You must choose a case name for intakes and CRSR. * * Psuedo Code : If NOT(Classification = I&R
     * OR Non-Case Related Special Request) * AND (Case Name = NULL) * * Assumptions : The NM STAGE will be used instead
     * of NM CASE because * NM STAGE is set in the record call dialogue. * * Save States : Assign, Close, Submit * *
     * Message Number : 19
     */
    if (!bNonIncidentReqType && (callDecisionData.getSzNmStage() == null)
        || (StringHelper.EMPTY_STRING).equals(callDecisionData.getSzNmStage())) {
      usMessageList.add(Messages.MSG_INT_CASE_NAME_NEEDED);
    }

    /*
     * * * Error Message : You must enter a closure code when a priority of * 'N' is entered. * * Psuedo Code : If
     * (Classification = CPS OR CCL OR RCCL) AND * (Current Priority = 'N') AND (Closure Code = NULL) * * Assumptions : * *
     * Save States : Assign, Submit * * Message Number : 20
     */
    if (bCPSCCLRCCL
        && ((CodesTables.CCPSPRTY_N).equals(callDecisionData.getSzCdStageCurrPriority()))
        && (FormattingHelper.formatString(callDecisionData.getSzCdStageReasonClosed())
                                                                                      .equals(StringHelper.EMPTY_STRING))
        && (bAssign || bSubmit)) {
      usMessageList.add(Messages.MSG_INT_CLOSURE_CD_NEEDED);
    }

    /*
     * Error Message : You must enter 'Aged' or 'Disability' determination * factors for an APS intake. * * Psuedo Code :
     * If (Classification = APS Community OR APS Facility) * AND (APS Determination Factors not selected) * *
     * Assumptions : It is assumed that each allegaion will appear no more * than once each. * * Save States : Assign,
     * Submit * * Message Number : 21
     */
    if (!bNonIncidentReqType && (bAPSCommunity || bAPSFacility) && !(bAged || bAPSDisabFactors) && (bAssign || bSubmit)) {
      usMessageList.add(Messages.MSG_INT_DETERM_FACTORS_APS);
    }

    /*
     * Error Message : You must either select determination factors or * 'No Factor' for a CPS report. * * Psuedo Code :
     * If (Classification = CPS) AND (no CPS Determination * Factors selected AND 'No Factors' checkbox is * unchecked) * *
     * Assumptions : * * Save States : Assign, Submit * * Message Number : 22
     */
    if (!bNonIncidentReqType && bCPSCommunity
        && (IntakeConstants.INDICATOR_NO.equals(callDecisionData.getBIndIncmgNoFactor())) && (usCINT03WRows == 0)
        && (bAssign || bSubmit)) {
      usMessageList.add(Messages.MSG_INT_NO_FACTORS);
    }

    /*
     * Error Message : You must remove APS-only allegations from a CPS or * Licensing report. * * Psuedo Code : If
     * (Classification = code beginning with 'C' or 'L') * AND (Allegation Type = code beginning with 'A'.) * (All
     * allegations must be checked.) * * Assumptions : There is no relationship between an allegation code * and whther
     * it is APS or CPS. Allegations will be * categorized as APS or CPS by comparing to a static * list. * * Save
     * States : Assign, Submit * * Message Number : 23
     */
    if (!bNonIncidentReqType
        && (stageClassification.startsWith(IntakeConstants.CCLASS_PREFIX_LICENSE) || stageClassification
                                                                                                        .startsWith(IntakeConstants.CCLASS_PREFIX_CPS))
        && (bAssign || bSubmit)) {
      allegEnum = allegListArray.enumerateROWCINT76DO();
      while (allegEnum.hasMoreElements()) {
        allegRow = (ROWCINT76DO) allegEnum.nextElement();
        alleg = FormattingHelper.formatString(allegRow.getSzCdIntakeAllegType());
        if (alleg.equals(CodesTables.CABALTYP_EXPL) || alleg.equals(CodesTables.CABALTYP_MHNG)
            || alleg.equals(CodesTables.CABALTYP_SUTH)) {
          usMessageList.add(Messages.MSG_INT_REMOVE_APS_ALLEG);
          break;
        }
      }
    }

    /*
     * Error Message : You must remove CPS-only allegations from an APS * report. * * Psuedo Code : If (Classification =
     * code beginning with 'A') AND * (Allegation Type = code beginning with 'C'.) * (All allegations must be checked.) * *
     * Assumptions : There is no relationship between an allegation code * and whther it is APS or CPS. Allegations will
     * be * categorized as APS or CPS by comparing to a static * list. * * Save States : Assign, Submit * * Message
     * Number : 24
     */
    if (!bNonIncidentReqType && stageClassification.startsWith(IntakeConstants.APS_PREFIX) && (bAssign || bSubmit)) {
      allegEnum = allegListArray.enumerateROWCINT76DO();
      while (allegEnum.hasMoreElements()) {
        allegRow = (ROWCINT76DO) allegEnum.nextElement();
        alleg = FormattingHelper.formatString(allegRow.getSzCdIntakeAllegType());
        if (alleg.equals(CodesTables.CABALTYP_ABAN) || alleg.equals(CodesTables.CABALTYP_NSUP)
            || alleg.equals(CodesTables.CABALTYP_RAPR)) {
          usMessageList.add(Messages.MSG_INT_REMOVE_CPS_ALLEG);
          break;
        }
      }
    }

    /*
     * Error Message : You must remove AFC-only allegations from an APS or * CPS report. * * Psuedo Code : If
     * (Classification = code beginning with 'A') AND * (Allegation Type = Neglect) * (All allegations must be checked.) * *
     * Assumptions : There is no relationship between an allegation code * and whether it is APS or CPS. Allegations
     * will be * categorized as APS or CPS by comparing to a static * list. * * Save States : Assign, Submit * * Message
     * Number : 25
     */
    if (!(stageClassification.equals(CodesTables.CCLASS_AFC)) && (bAssign || bSubmit)) {
      allegEnum = allegListArray.enumerateROWCINT76DO();
      while (allegEnum.hasMoreElements()) {
        allegRow = (ROWCINT76DO) allegEnum.nextElement();
        alleg = FormattingHelper.formatString(allegRow.getSzCdIntakeAllegType());
        if (alleg.equals(CodesTables.CABALTYP_NEGL)) {
          usMessageList.add(Messages.MSG_INT_REMOVE_AFC_ALLEG);
          break;
        }
      }
    }

    /*
     * Error Message : You must choose a Primary Allegation for all * intake reports. * * Psuedo Code : If
     * (Classification != I&R OR SPC) AND (Primary * Allegation = NULL). * * Assumptions : * * Save States : Assign,
     * Submit * * Message Number : 26
     */
    // if (!bSPCIR &&
    // !(StringHelper.isValid(callDecisionData.getSzCdIncmgAllegType())) &&
    // (bAssign || bSubmit)) {
    // usMessageList.add(Messages.MSG_INT_PRIMARY_ALLEG);
    // } else if (!bSPCIR &&
    // !(FormattingHelper.formatString(callDecisionData.getSzCdAllegType()).equals(
    // StringHelper.EMPTY_STRING)) &&
    // (bAssign || bSubmit)) {
    // //TODO - ASK KARL ABOUT THIS ERROR MESSAGE I DON'T THINK THIS CAN HAPPEN ANYMORE!
    // }
    /*
     * Error Message : You must record at least one allegation regarding * each principal identified as an AP, VC or VP. * *
     * Psuedo Code : If (Role = 'AP' * OR 'VC' OR 'VP') AND (Data Action != 'D' OR 'R') AND * (no row of the Allegation
     * List contains that name). * (This must be checked for each person.) * * Assumptions : If someone is a principle
     * victim perpetrator then * it is sufficient that that person appear once in the * allegation list as either a
     * victim or as a * perpetrator. * * Save States : Assign, Submit * * Message Number : 27
     */
    if (!bNonIncidentReqType && (bAssign || bSubmit)) {
      boolean personWithNoAllegationFound = false;
      personEnum = personListArray.enumeratePersListRtrvStruct();

      // We only want to loop through person list until we find a person with no matching allegation.
      // When a person with no matching allegation is found, we break out of the person list while loop
      while ((personEnum.hasMoreElements()) && !personWithNoAllegationFound) {
        personRow = (PersListRtrvStruct) personEnum.nextElement();
        personRole = FormattingHelper.formatString(personRow.getSzCdStagePersRole());
        boolean isPrincipal = (CodesTables.CPRSNTYP_PRN.equals(personRow.getSzCdStagePersType()));
        boolean roleVcOrVp = ((CodesTables.CINTROLE_VC).equals(personRole) || (CodesTables.CINTROLE_VP)
                                                                                                       .equals(personRole));

        if (isPrincipal && (roleVcOrVp || ((CodesTables.CINTROLE_AP).equals(personRole)))) {
          // A person has been found that requires an allegation. The allegation list will now be search.
          // If the person is not found in the search an error message will be added to the usMessageList.
          allegEnum = allegListArray.enumerateROWCINT76DO();
          boolean allegFound = false;

          // We only want to loop through the allegation list array until we find an allegation that matches the person.
          while (allegEnum.hasMoreElements()) {
            allegRow = (ROWCINT76DO) allegEnum.nextElement();
            // There are three mutually exclusive cases. The person may be a perpetrator, a victim perpetrator,
            // or a victim.
            if (personRole.equals(CodesTables.CINTROLE_AP)) {
              // The person is an alleged perpetrator. The person must be involved in an allegation as a perp.
              if (personRow.getUlIdPerson() == allegRow.getUlIdAllegedPerpetrator()) {
                allegFound = true;
                break;
              }
            } else if (personRole.equals(CodesTables.CINTROLE_VP)) {
              // The person is a victim perpetrator. The person must be involved in an allegation as a victim
              // perpetrator.
              if ((personRow.getUlIdPerson() == allegRow.getUlIdAllegedPerpetrator())
                  || (personRow.getUlIdPerson() == allegRow.getUlIdVictim())) {
                allegFound = true;
                break;
              }
            } else if (personRole.equals(CodesTables.CINTROLE_VC)) {
              // The person is a victim. The person must be involved in an allegation as a victim.
              if (personRow.getUlIdPerson() == allegRow.getUlIdVictim()) {
                allegFound = true;
                break;
              }
            }
          } // End allegation list while loop
          // If no matching allegation was found for the person in question, we can break out of the person list
          // while loop and set the error message into usMessageList.
          if (!allegFound) {
            usMessageList.add(Messages.MSG_INT_REC_ALLEG);
            break; // this break exits the person list while loop.
          }
        } // End (if principal) if loop
      } // End person list while loop
    } // End main if loop

    // TODO SEE IF WE CAN SAVE STUFF ON CALL INFO AND INTAKE ACTIONS TO MAKE THIS TRUE

    /*
     * Error Message : You may not assign a priority to an I&R or Special * Request call. * * Psuedo Code : If
     * (Classification = I&R OR SPC) AND (Initial * Priority != NULL). * * Assumptions : * * Save States : Assign,
     * Close, Submit * * Message Number : 28
     */

    // if (bSPCIR && StringHelper.isValid(callDecisionData.getSzCdStageInitialPriority())) {
    // usMessageList.add(Messages.MSG_INT_NO_IR_PRIOR_ALOW);
    // }
    /*
     * Error Message : You must assign an initial priority of '1' or '2' * for allegations of sexual abuse or suicidal
     * threat. * * Psuedo Code : If (Classification = APS Community) AND (Alleg. = * SXAB OR SUTH) AND (Initial Priority !=
     * '1' OR '2'). * (Each allegation should be checked.) * * Assumptions : * * Save States : Assign, Submit * *
     * Message Number : 29
     */
    if (bAPSCommunity && !((CodesTables.CPRIORTY_1).equals(callDecisionData.getSzCdStageInitialPriority()))
        && !((CodesTables.CPRIORTY_2).equals(callDecisionData.getSzCdStageInitialPriority())) && (bAssign || bSubmit)) {
      allegEnum = allegListArray.enumerateROWCINT76DO();
      while (allegEnum.hasMoreElements()) {
        allegRow = (ROWCINT76DO) allegEnum.nextElement();
        alleg = FormattingHelper.formatString(allegRow.getSzCdIntakeAllegType());
        if (alleg.equals(CodesTables.CABALTYP_SUTH) || alleg.equals(CodesTables.CABALTYP_SXAB)) {
          usMessageList.add(Messages.MSG_INT_PRIORITY_SXAB);
          break;
        }
      }
    }

    /*
     * Error Message : You must assign an initial priority of '2' or '4' * when EXPL is the only allegation. * * Psuedo
     * Code : If (Classification = APS Community) AND (the Alleg. * column = EXPL) AND (Initial Priority != '2' OR '4'). *
     * (Each allegation must be checked. The Alleg. type * must be EXPL for each row or the edit should be passed * and
     * no message should appear.) * * Assumptions : * * Save States : Assign, Submit * * Message Number : 30
     */
    if (!bNonIncidentReqType && bAPSCommunity
        && !((CodesTables.CPRIORTY_2).equals(callDecisionData.getSzCdStageInitialPriority()))
        && !((CodesTables.CPRIORTY_4).equals(callDecisionData.getSzCdStageInitialPriority())) && (bAssign || bSubmit)) {
      bEXPLOnly = bAllegationsExists;
      allegEnum = allegListArray.enumerateROWCINT76DO();
      while (allegEnum.hasMoreElements()) {
        allegRow = (ROWCINT76DO) allegEnum.nextElement();
        if (!(CodesTables.CABALTYP_EXPL).equals(allegRow.getSzCdIntakeAllegType())) {
          bEXPLOnly = false;
          break;
        }
      }
      if (bEXPLOnly) {
        usMessageList.add(Messages.MSG_INT_PRIORITY_EXPL);
      }
    }

    /*
     * Error Message : Assign a new priority. Initial priority may not be * 4 unless EXPL is the only allegation. * *
     * Psuedo Code : If (Classification = APS Community) AND (Initial * Priority = '4') AND (Alleg. != EXPL). (Each *
     * allegation row must be checked. If it fails once, * the edit is passed and no message should appear.) * *
     * Assumptions : * * Save States : Assign, Submit * * Message Number : 31
     */
    if (!bNonIncidentReqType && (bAPSCommunity)
        && ((CodesTables.CPRIORTY_4).equals(callDecisionData.getSzCdStageInitialPriority())) && (bAssign || bSubmit)) {
      allegEnum = allegListArray.enumerateROWCINT76DO();
      while (allegEnum.hasMoreElements()) {
        allegRow = (ROWCINT76DO) allegEnum.nextElement();
        if (!(CodesTables.CABALTYP_EXPL).equals(allegRow.getSzCdIntakeAllegType())) {
          usMessageList.add(Messages.MSG_INT_PRIORITY_4);
          break;
        }
      }
    }
    /*
     * Error Message : All CPS intakes must have at least one principal * assigned the Rel/Int of "OV". * * Psuedo Code :
     * If Classification = 'CPS' or 'LCC' or 'LRC' or 'COA' * or 'COS' AND Rel/Int != 'OV'). The edit is only run * if
     * it is true after all principals have been checked. * * Assumptions : If there are no principals then the error
     * message * will be posted. * * Save States : Assign, Submit * * Message Number : 32
     */
    // if ((bCPSCommunity ||
    // stageClassification.equals(CodesTables.CCLASS_LCC) ||
    // stageClassification.equals(CodesTables.CCLASS_LRC) ||
    // stageClassification.equals(CodesTables.CCLASS_COA) ||
    // stageClassification.equals(CodesTables.CCLASS_COS)) &&
    // (bAssign || bSubmit)) {
    // personEnum = personListArray.enumeratePersListRtrvStruct();
    // personFound = false;
    // while (personEnum.hasMoreElements()) {
    // personRow = (PersListRtrvStruct) personEnum.nextElement();
    // boolean isPrincipal = ((CodesTables.CPRSNTYP_PRN).equals(personRow.getSzCdStagePersType()));
    // if (isPrincipal && ((CodesTables.CRELVICT_OV).equals(personRow.getSzCdStagePersRelInt()))) {
    // personFound = true;
    // break;
    // }
    // }
    // if (!personFound) {
    // usMessageList.add(Messages.MSG_INT_CPS_OV_PRINC_REQ);
    // }
    // }
    /*
     * Error Message : All intakes involving a facility must have a Facility * name entered. * * Psuedo Code : If
     * Classification = 'AFC' or 'LCC' or 'LRC' AND Facility * Name = NULL * * Assumptions : * * Save States : Assign,
     * Submit * * Message Number : 33
     */
    if (!bNonIncidentReqType
        && (bAPSFacility || stageClassification.equals(CodesTables.CCLASS_LCC) || stageClassification
                                                                                                     .equals(CodesTables.CCLASS_LRC))
        && (!StringHelper.isValid(facilityData.getNmIncmgFacilName())) && (bAssign || bSubmit)) {
      usMessageList.add(Messages.MSG_INT_NULL_FACIL_NM);
    }    

    /*
     * Error Message : You must remove all entries in the Person List for * I&R and NCRSR calls. * * Psuedo Code : If
     * (People exist) AND ((Classification = 'I&R') OR * (Spec Req Type code begins with and 'N')) * * Assumptions : * *
     * Save States : Assign, Submit, Close * * Message Number : 34
     */
    // if (bRealPeopleExist
    // && (((FormattingHelper.formatString(callEntryData.getSzCdSpclReq()))
    // .startsWith(IntakeConstants.CCLASS_PREFIX_N)))) {
    // usMessageList.add(Messages.MSG_INT_REMOVE_PEOPLE);
    // }
    /*
     * Error Message : County is required for the Primary Caretaker.
     */

    /*
     * Error Message : A county address is required for all persons * designated as the case name. * * Psuedo Code : If
     * ((NM STAGE exist AND !(I&R OR NCRSR)) * AND (bSearchPerson AND (person's full name in CINT04Ws LB) * AND (no
     * person county)) OR * (NOT bSearchPerson) AND (no facility county)) * * Assumptions : The NM STAGE, if any, must
     * be chosen from something * that has a county. That something may either be a * person or a facility. As to
     * whether the NM STAGE * corresponds to a person or a facility is a function * of the classification and nothing
     * else. A constant * suffix "et al" will be appended to the NM STAGE * if the NM STAGE corresponds to a facility.
     * This * information is represented in the following table * * Classifiction Code County "et al" * _____________
     * ____ ______ _______ * CPS C* Person N * APS Facility AFC Facility Y * Child Care Licensing LRC Facility Y *
     * Residential Licensing LCC Facility Y * APS Community APS Person N * * Save States : Assign, Close, Submit * *
     * Message Number : 35
     */
    // Begin SIR 23019 - CFH,CCL and CCR are new CRSR types that have case names as
    // facility names. They should be excluded from this edit.
    // if (StringHelper.isValid(callDecisionData.getSzNmStage())
    // && !((FormattingHelper.formatString(callEntryData.getSzCdSpclReq()).startsWith(IntakeConstants.CCLASS_PREFIX_N)))
    // && (!("CFH".equalsIgnoreCase(callEntryData.getSzCdSpclReq()))
    // || !("CCL".equalsIgnoreCase(callEntryData.getSzCdSpclReq())) || !("CCR"
    // .equalsIgnoreCase(callEntryData
    // .getSzCdSpclReq()))))
    // // End SIR 23019
    // {
    // // TODO .. what is this???
    // if (bSearchPerson) {
    // personEnum = personListArray.enumeratePersListRtrvStruct();
    // while (personEnum.hasMoreElements()) {
    // personRow = (PersListRtrvStruct) personEnum.nextElement();
    // if ((FormattingHelper.formatString(callDecisionData.getSzNmStage())).equals(personRow.getSzNmPersonFull())) {
    // break;
    // }
    // }
    // if (!StringHelper.isValid(personRow.getSzCdAddrCounty())) {
    // usMessageList.add(Messages.MSG_INT_COUNTY_REQUD);
    // }
    // } else {
    // // if (!StringHelper.isValid(facilityData.getSzCdIncmgFacilCnty())) {
    // // usMessageList.add(Messages.MSG_INT_FACILITY_ADDRESS);
    // // }
    // }
    // }
    /*
     * Error Message : Law enforcement jurisdiction required for this call * type. * * Psuedo Code : if (Classification
     * prefixed with L or C) AND * (Jurisdiction is NULL) * * Assumptions : * * Save States : Assign, Submit * * Message
     * Number : 36
     */
    if (!bNonIncidentReqType && bCPSCCLRCCL && !StringHelper.isValid(callEntryData.getSzNmJurisdiction())
        && (bAssign || bSubmit)) {
      usMessageList.add(Messages.MSG_INT_LAW_ENFORCEMENT);
    }

    /*
     * * Error Message : Each VP must be assigned both victim and perp roles * in allegation list. * * Pseudo Code : If
     * (Classification != I&R OR SPC) AND (Role = 'VP') * AND (both columns of the Allegation List contain that name). * *
     * Save States : Assign, Submit * * Message Number : 37
     */
    if (!bNonIncidentReqType && (bAssign || bSubmit)) {
      personEnum = personListArray.enumeratePersListRtrvStruct();
      int personId = 0;
      boolean victimFound = false;
      boolean perpFound = false;
      // We enumerate through the person list because we have to check these conditions for every
      // single person.
      while (personEnum.hasMoreElements()) {
        personRow = (PersListRtrvStruct) personEnum.nextElement();
        personId = personRow.getUlIdPerson();
        boolean isPrincipal = (CodesTables.CPRSNTYP_PRN.equals(personRow.getSzCdStagePersType()));
        personRole = FormattingHelper.formatString(personRow.getSzCdStagePersRole());
        // This error check is only concerned with principals assigned the role of VP
        if (isPrincipal && (personRole.equals(CodesTables.CINTROLE_VP))) {
          allegEnum = allegListArray.enumerateROWCINT76DO();
          // Enumerate through the allegation list until allegations are found
          // where the person is a victim and the person is a perp.
          while (allegEnum.hasMoreElements()) {
            allegRow = (ROWCINT76DO) allegEnum.nextElement();
            if (personId == allegRow.getUlIdVictim()) {
              victimFound = true;
            }
            if (personId == allegRow.getUlIdAllegedPerpetrator()) {
              perpFound = true;
            }
            // If we have found instances where the person is a victim and the person is a perpetrator we do
            // not need to loop through any of the remaining allegations, so we break out of the allegation enumeration.
            if (victimFound && perpFound) {
              break;
            }
          } // End allegation loop while loop
          // If we loop through the entire allegation list and the person is not listed as a victim or the
          // person is not listed as a perpetrator or both then we display the message the MSG_INT_VP_BOTH_ROLES
          // a break out of the person list enumeration. After we have found one person that meets the error
          // conditions we really don't care if any other persons meet the criteria.
          if (!victimFound || !perpFound) {
            usMessageList.add(Messages.MSG_INT_VP_BOTH_ROLES);
            break;
          }
        } // End IF (person is principal with role = VP
      } // End person list while loop
    } // End main IF loop

    /*
     * * Error Message : You have assigned a principal an incorrect role. Victims in * an AFC case may not be be
     * assigned the role of 'VP' ('Victim/ * Perpetrator'). * * Pseudo Code : If (Classification = APS Facility) AND
     * (Person Type = PRN * AND Role = 'VP Victim/Perpetrator') (This must be checked for * each person) * * * Save
     * States : Assign, Submit * * Message Number : 38
     */
    if (bAPSFacility) {

      personEnum = personListArray.enumeratePersListRtrvStruct();
      while (personEnum.hasMoreElements()) {
        personRow = (PersListRtrvStruct) personEnum.nextElement();
        boolean isPrincipal = (CodesTables.CPRSNTYP_PRN.equals(personRow.getSzCdStagePersType()));
        personRole = FormattingHelper.formatString(personRow.getSzCdStagePersRole());
        if (isPrincipal && (personRole.equals(CodesTables.CINTROLE_VP))) {
          usMessageList.add(Messages.MSG_INT_NO_VP_FOR_AFC);
          break;
        }
      }
    }
    /*
     * Error Message : You have assigned a principal an incorrect role. Adults in * CPS cases may not be be assigned the
     * role of 'VP' ('Victim/ * Perpetrator'). * * Pseudo Code : If (Classification = CPS Facility) AND (Person Type =
     * PRN * AND Role = 'VP Victim/Perpetrator') * AND (legalAdult) * (This must be checked for * each person) * * *
     * Save States : Assign, Submit * * Message Number : 38
     */
    /*
     * Ochumd Sir 23428 - Romove Special Request and I&R from this edit * if (bCPSCCLRCCL) // || bSPCIR).
     */
    if (bCPSCCLRCCL) {
      personEnum = personListArray.enumeratePersListRtrvStruct();
      while (personEnum.hasMoreElements()) {
        personRow = (PersListRtrvStruct) personEnum.nextElement();
        boolean isPrincipal = (CodesTables.CPRSNTYP_PRN.equals(personRow.getSzCdStagePersType()));

        int age = getAge(personRow);
        boolean legalAdult = (age >= IntakeConstants.LEGAL_ADULT_AGE);
        personRole = FormattingHelper.formatString(personRow.getSzCdStagePersRole());
        if (isPrincipal && legalAdult && (personRole.equals(CodesTables.CINTROLE_VP))) {
          usMessageList.add(Messages.MSG_INT_NO_ADULT_VP_FOR_CPS);
          break;
        }
      }
    }

    // SIR 22616 - Added code to throw MSG_INT_REMOVE_EXPC_ALLEG when needed
    /*
     * Error Message : You must remove LIC-only allegations from a CPS or APS * reports. * * Psuedo Code : If
     * (Classification != LRC or LCC) * AND (Allegation Type = EXPC) * (All allegations must be checked.) * * Save
     * States : Assign, Submit * * Message Number : 39
     */

    if (!stageClassification.equals(CodesTables.CCLASS_LRC) && !stageClassification.equals(CodesTables.CCLASS_LCC)) {
      allegEnum = allegListArray.enumerateROWCINT76DO();
      while (allegEnum.hasMoreElements()) {
        allegRow = (ROWCINT76DO) allegEnum.nextElement();
        alleg = FormattingHelper.formatString(allegRow.getSzCdIntakeAllegType());
        if (alleg.equals(CodesTables.CABALTYP_EXPC)) {
          usMessageList.add(Messages.MSG_INT_REMOVE_EXPC_ALLEG);
          break;
        }
      }

    }

    // Since the Error List takes an int[] as input, we need to convert the usMessageList ArrayList into
    // an int[] and return that.

    int[] errorArray = new int[usMessageList.size()];
    Iterator i = usMessageList.iterator();

    int counter = 0;
    while (i.hasNext()) {
      errorArray[counter] = (Integer) i.next();
      counter++;
    }

    performanceTrace.exitScope();

    return errorArray;
  }

  public static int getButtonPressed(HttpServletRequest request) {
    if (StringHelper.isValid(ContextHelper.getStringSafe(request, "btnSaveAndSubmit.x"))) {
      return IntakeConstants.SUBMIT_BUTTON;
    } else if (StringHelper.isValid(ContextHelper.getStringSafe(request, "btnSaveAndAssign.x"))) {
      return IntakeConstants.ASSIGN_BUTTON;
    } else // (StringHelper.isValid(ContextHelper.getStringSafe(request, "btnSaveAndClose.x")))
    {
      return IntakeConstants.CLOSE_BUTTON;
    }
  }

  /**
   * returns -1 if date of birth is unavailable and age is 0 if date of birth exists, but age is 0, it recalculates age
   *
   * @param personRow
   *          PersListRtrvStruct
   * @return Age gov.georgia.dhr.dfcs.sacwis.core.utility.Date
   */
  protected static int getAge(PersListRtrvStruct personRow) {
    if (personRow.getDtDtPersonBirth() == null) {
      if (personRow.getLNbrPersonAge() == 0)

      {
        return -1;
      }
      return personRow.getLNbrPersonAge();
    }
    // !!! I'm not worrying about the case where they don't match
    if (personRow.getLNbrPersonAge() != 0) {
      return personRow.getLNbrPersonAge();
    }
    return DateUtility.getAge(new gov.georgia.dhr.dfcs.sacwis.core.utility.Date(personRow.getDtDtPersonBirth()));
  }
}
