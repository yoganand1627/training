package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV16SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV16SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN06UO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN05UO;
import gov.georgia.dhr.dfcs.sacwis.service.person.Ccmn05u;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV12DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV12DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSVC18DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSVC18DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSC59DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSC59DO;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUDE6DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUDE6DO;
/**************************************************************************
**
** Module File:   CINV16S.src
**
** Service Name:  CINV16S - CPS INV CONCL AUD
**
** Description:   This service updates information modified on the CPS
**                Investigation Conclusion window.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  4/19/95
**
** Programmer:    Alex Ramirez
**
** Date      Programmer Description
** --------  ---------- ------------------------------------------------
** 07/27/95  RAMIREAP   Substituted call to DAM CINT12 with call to DAM
**                      CSVC18. This last DAM uses timestamps in the update.
** 11/08/95  HELMKEST   SIR #1710 Add CheckStageEventStatus common function to
**                      the service.
** 01/31/96  BRUCKMK    SIR 3066: Call DAM CLSC59D to see if any Subcare
**                      stages exist for the current case.  This DAM only
**                      needs to be called for Closure Codes 64,66,68 and
**                      70, since these Closure Codes Progress to Family
**                      Preservation, which should not happen if a Subcare
**                      Stage already exists for the Case.
** 08/13/96  vanderm    SIR #21968 - Databse should be restored for all
**                      AUD services which return an error.  Error handling
**                      was changed from FND_SEVERITY_WARNING to
**                      FND_SEVERITY_ERROR.
** 02/11/97  ODONNERJ   SIR# 12093 - If the dtDtStageClose of SUB or FSU is <=
**                      the dtDtStageStart of the opening of most recent intake
**                      then it is OK to save and submit. Functionally, this
**                      is accomplished by looping through all the stage rows
**                      returned by clsc59d from above and storing the most
**                      recent intake date in a local date variable
**                      (dtDtMostRecentIntake).  Then in the second loop,
**                      an additional conditional con be added to compare dates.
**
** 10/26/01  CASDORJM   SARE2001 Modifications were made to the save service
**                      for the Investigation Conclusion window to ensure that
**                      the new indicator is saved into the database.
**
** 03/01/2002 ochumd    Sir #15712 - A new dam caude6d.pc is added to update to
**                      the stage person link given a stage id.  This dam is only
**                      called if there exist at least one principal with the role
**                      of Uk and the user has responded yes to the option to
**                      update role to NO.
**
**  12/05/2002  KRD     SIR 15669 - Added new codes to the Family Preservation
**                      edit check.  Required changes to ().
**
**   1/23/03   DWW      Added following line for error handling:
**                      if (RetVal == FND_SUCESS)  { rc=FND_SUCCESS; }
**
**  05/02/03   Srini    SIR 17188 - IMPACT: Added code to make Service Transaction
**                      aware.
**
**  05/05/2003  KRD     IMPACT - Code changes applied to support
**                      "Approver Mode" providing supervisors the ability to
**                      modify data without invalidating the pending
**                      approval.
**
**  05/20/2003 mcclaim  removed RetVal, replaced instance where it was being 
**                      used with rc; error conditions were getting hidden by 
**                      RetVal;  Also, made sure CallCAUDE6D was only called
**                      if rc == ARC_SUCCESS
**
**  06/23/03  Srini     SIR 18479 - Changed the error handler PROCESS_TUX_RC_ERROR 
**                      to PROCESS_TUX_RC_ERROR_NOFREE after the 
**                      ARC_UTLCheckServiceBatchBlock so that it doesn't free the 
**                      input and output objects before they are allocated
**
**  06/30/03  Srini     SIR 18602 - Modified to fix error handling for 
**                      transaction aware code
**
**  07/10/03  Srini     SIR 18602 - More changes. Changed all
**                      PROCESS_TUX_RC_ERROR calls to PROCESS_TUX_RC_ERROR_TRANSACT
**                      and PROCESS_TUX_SQL_ERROR calls to
**                      PROCESS_TUX_SQL_ERROR_TRANSACT calls.
**
**  07/14/03  JRIOS     SIR 18890 - Return MSG_USE_REMOVAL_SUB_CLOSURE_RSN
**                      if case has a SUB or FSU stage and user is closing
**                      the INV stage with any of the following closure
**                      reasons: Fam Refusal/No Legal Interven Poss-Close
**                      (80), Family Moved After Investigation-Close (82),
**                      Workload Constraints-Close (84), or Non-family
**                      Investigation (86).
**  06/16/2004 dejuanr  SIR 22936 - Added data element for CPS and Law
**                      Enforcment Joint contact - IND_CPS_LE_JNT_CNTCT & CD_CPS_LE_JNT_CNTCT
**  01/13/2004 dejuanr  SIR 22986 - Add victim taped fields
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cinv16s {
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final String EVENT_STATUS_PROGRESS = "PROC";
    public static final String EVENT_STATUS_COMPLETE = "COMP";
    public static final String EVENT_STATUS_PENDING = "PEND";
    
    public static final String NULL_STRING = "";
    public static final char YES = 'Y';
    public static final String CRSR_STAGE = "CRSR";
    
    /* SIR 3066: Added Edits for Family Preservation Closure Codes */
    public static final String FAM_PRES_CLOSURE_1 = "64";
    public static final String FAM_PRES_CLOSURE_2 = "66";
    public static final String FAM_PRES_CLOSURE_3 = "68";
    public static final String FAM_PRES_CLOSURE_4 = "70";
    /* SIR 15669 - Added "moderate family pres" closure codes */
    public static final String FAM_PRES_CLOSURE_5 = "65";
    public static final String FAM_PRES_CLOSURE_6 = "69";
    /* SIR 18890 - Added Edits for more closure codes */
    public static final String FAM_REFUSAL_CLOSURE = "80";
    public static final String FAM_MOVED_CLOSURE = "82";
    public static final String WORKLOAD_CONSTR_CLOSURE = "84";
    public static final String NONFAM_INV_CLOSURE = "86";
    
    public static final int FAM_PRES_CLOSURE_LEN = 2;
    public static final String FAMILY_PRESERV = "FRE";
    public static final String SUBCARE = "SUB";
    public static final String FAMILY_SUBCARE = "FSU";
    public static final int INITIAL_PAGE = 1;
    
    public static final int MSG_USE_REMOVAL_SUB_CLOSURE_RSN = 25600;
    
    /* Lose this - commented out 12093 not needed */
    /*#define MSG_FPR_NOT_FROM_INVEST     8333  */
    /* SIR# 12093 */
    public static final String INTAKE = "INT";
    
    /***********************************************
    ** begin Sir# 15712 - ochumd
    ************************************************/
    public static final String PERSON_STAGE_ROLE_UK = "UK";
    public static final String PERSON_TYPE_PRN = "PRN";
    public static final String NO_ROLE = "NO";
    static int transactionflag = - 1;
    CINV16SO CINV16S(CINV16SI cinv16si) {
        CINV16SO cinv16so = new CINV16SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        rc = ARC_UTLCheckServiceBatchBlock("CINV16S", pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
        /* END TUX/XML: Turn the XML buffer into an input message struct */
        
        
        //SIR 18602
        // Need to check if the transaction is already in progress as this service is called 
        // from another service.
        transactionflag = - 1;
        boolean bTransactionStarted = false;
        transactionflag = tpgetlev();
        
        /*
        ** Determine victim's and perp's new roles, based on
        ** their remaining allegations:
        **
        ** Named As         New Role
        **
        ** Victim & Perp    VICTIM_PERP
        ** Victim Only      ALLEGED_VICTIM
        ** Perp Only        ALLEGED_PERP
        ** No Remaining     NO_ROLE
        **  Allegations
        */
        
        /* Victim Role */
        if (transactionflag == - 1) {
            userlog("ERROR: tpgetlev failed in CINV16S (%s)\n", tpstrerror(tperrno));
            pServiceStatus.severity = FND_SEVERITY_ERROR;
            pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPBEGIN_FAILED;
            rc = Arcxmlerrors.ARC_ERR_TUX_TPBEGIN_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        }
        else if (transactionflag == 1) {
            // This is the case of transaction in progress.
            //So we should not start a new one
            userlog("START: TRANSACTION ALREADY IN PROGRESS in CINV16S\n");
        }
        else if (transactionflag == 0) {
            userlog("TRANSACTION IS STARTED in CINV16S\n");
            bTransactionStarted = true;
        }
        int usRowCtr = 0;/* Row Counter   */
        CCMN06UI pCCMN06UInputRec = null;/* R1/R2 Impact */
        CCMN06UO pCCMN06UOutputRec = null;/* R1/R2 Impact */
        rc = ARC_PRFServiceStartTime_TUX(cinv16si.getArchInputStruct());
        
        /*
        ** Run-time versioning
        */
        
        /*
        ** Check buffer size
        */
        /*
        ** Process error message and return to client
        */
        
        /*
        ** Initialize output message and length
        */
        
        /*
        ** Initialize service status fields
        */
        
        /**************************************************************************
        ** SIR 1710:  Add CheckStageEventStatus to Save service
        ** (BEGIN): Common Function: ccmn06u  Check Stage/Event common function
        **************************************************************************/
        /*
        ** Allocate memory for Common Function Input and Output Structures
        */
        
        pCCMN06UInputRec = new CCMN06UI();
        
        pCCMN06UOutputRec = new CCMN06UO();
        pCCMN06UInputRec.setArchInputStruct(cinv16si.getArchInputStruct());
        pCCMN06UInputRec.getArchInputStruct().setCReqFuncCd(cinv16si.getArchInputStruct().getCReqFuncCd());
        pCCMN06UInputRec.setUlIdStage(cinv16si.getROWCCMN45DO().getUlIdStage());
        pCCMN06UInputRec.setSzCdTask(cinv16si.getROWCCMN45DO().getSzCdTask());
        
        /*
        ** Call DAM
        */
        rc = Ccmn06u.CheckStageEventStatus(pCCMN06UInputRec, pCCMN06UOutputRec, pServiceStatus);
        
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                break;
                
            case Messages.MSG_SYS_STAGE_CLOSED:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_SYS_STAGE_CLOSED;
                break;
                
                // original return code analysis continued with second case
                
            case Messages.MSG_SYS_EVENT_STS_MSMTCH:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_SYS_EVENT_STS_MSMTCH;
                break;
            case Messages.MSG_SYS_MULT_INST:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_SYS_MULT_INST;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                break;
        }
        
        if (WtcHelperConstants.ARC_SUCCESS == rc) {
            
            if ((0 == cinv16si.getROWCINV14SOG00().getSzCdStageReasonClosed().substring(0, FAM_PRES_CLOSURE_LEN).compareTo(FAM_PRES_CLOSURE_1.substring(0, FAM_PRES_CLOSURE_LEN))) || (0 == cinv16si.getROWCINV14SOG00().getSzCdStageReasonClosed().substring(0, FAM_PRES_CLOSURE_LEN).compareTo(FAM_PRES_CLOSURE_2.substring(0, FAM_PRES_CLOSURE_LEN))) || (0 == cinv16si.getROWCINV14SOG00().getSzCdStageReasonClosed().substring(0, FAM_PRES_CLOSURE_LEN).compareTo(FAM_PRES_CLOSURE_3.substring(0, FAM_PRES_CLOSURE_LEN))) || (0 == cinv16si.getROWCINV14SOG00().getSzCdStageReasonClosed().substring(0, FAM_PRES_CLOSURE_LEN).compareTo(FAM_PRES_CLOSURE_4.substring(0, FAM_PRES_CLOSURE_LEN))) || (0 == cinv16si.getROWCINV14SOG00().getSzCdStageReasonClosed().substring(0, FAM_PRES_CLOSURE_LEN).compareTo(FAM_PRES_CLOSURE_5.substring(0, FAM_PRES_CLOSURE_LEN))) || (0 == cinv16si.getROWCINV14SOG00().getSzCdStageReasonClosed().substring(0, FAM_PRES_CLOSURE_LEN).compareTo(FAM_PRES_CLOSURE_6.substring(0, FAM_PRES_CLOSURE_LEN))) || (0 == cinv16si.getROWCINV14SOG00().getSzCdStageReasonClosed().substring(0, FAM_PRES_CLOSURE_LEN).compareTo(FAM_REFUSAL_CLOSURE.substring(0, FAM_PRES_CLOSURE_LEN))) || (0 == cinv16si.getROWCINV14SOG00().getSzCdStageReasonClosed().substring(0, FAM_PRES_CLOSURE_LEN).compareTo(FAM_MOVED_CLOSURE.substring(0, FAM_PRES_CLOSURE_LEN))) || (0 == cinv16si.getROWCINV14SOG00().getSzCdStageReasonClosed().substring(0, FAM_PRES_CLOSURE_LEN).compareTo(WORKLOAD_CONSTR_CLOSURE.substring(0, FAM_PRES_CLOSURE_LEN))) || (0 == cinv16si.getROWCINV14SOG00().getSzCdStageReasonClosed().substring(0, FAM_PRES_CLOSURE_LEN).compareTo(NONFAM_INV_CLOSURE.substring(0, FAM_PRES_CLOSURE_LEN)))) {
                
                rc = Ccfc40s.CallCLSC59D(cinv16si, cinv16so, pServiceStatus);
                
                switch (rc) {
                        
                    case WtcHelperConstants.ARC_SUCCESS:
                        break;
                    case Messages.MSG_FPR_NOT_FROM_INVEST:
                        break;
                    case MSG_USE_REMOVAL_SUB_CLOSURE_RSN:
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                }
            }
            
            if (WtcHelperConstants.ARC_SUCCESS == rc) {
                
                
                // Perp Role
                if (false == cinv16si.getArchInputStruct().getUlSysNbrReserved1()) {
                    
                    if (!(strncmp(cinv16si.getROWCCMN45DO().getSzCdEventStatus() , EVENT_STATUS_PENDING, EVENT_STATUS_PENDING.length()) != 0)) {
                        rc = Cinv55s.CallCCMN05U(cinv16si, cinv16so, pServiceStatus);
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                    }
                    rc = Cinv60s.CallCCMN01U(cinv16si, cinv16so, pServiceStatus);
                }
                switch (rc) {
                    case WtcHelperConstants.ARC_SUCCESS:
                        rc = Cinv12s.CallCINV12D(cinv16si, cinv16so, pServiceStatus);
                        
                        switch (rc) {
                            case WtcHelperConstants.ARC_SUCCESS:
                                
                                //  Call DAM
                                rc = Cinv18s.CallCSVC18D(cinv16si, cinv16so, pServiceStatus);
                                
                                switch (rc) {
                                        
                                    case WtcHelperConstants.ARC_SUCCESS:
                                        break;
                                        
                                    case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                                        break;
                                    case Messages.MSG_CMN_UPDATE_FAILED:
                                        break;
                                        
                                    default :
                                        Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                                }
                                break;
                                
                            case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                                break;
                            case Messages.MSG_CMN_UPDATE_FAILED:
                                break;
                                
                            default :
                                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                        }
                        break;
                        
                    case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                        break;
                        
                    case Messages.MSG_CMN_UPDATE_FAILED:
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                }
            }
        }
        
        if ((rc == WtcHelperConstants.ARC_SUCCESS) && (cinv16si.getBIndChkd() == 'Y')) {
            rc = CallCAUDE6D(cinv16si, cinv16so, pServiceStatus);
            
            switch (rc) {
                    
                case WtcHelperConstants.ARC_SUCCESS:
                    break;
                case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
            }
        }
        
        /*
        ** Load translation map with service name and version
        */
        
        /*
        ** Stop performance timer for service
        */
        ARC_PRFServiceStopTime_TUX(cinv16si.getArchInputStruct() , cinv16so.getArchOutputStruct());
        
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError_Transact(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber() , transactionflag);
        }
        else if (bTransactionStarted) {
            if // duplicate exists; return warning to user
            (tpcommit(0) == - 1) {
                userlog("ERROR: tpcommit failed in service CINV16S (%s)\n", tpstrerror(tperrno));
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
            }
            //SIR 18602
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        else {
            userlog("END: TRANSACTION ALREADY IN PROGRESS CINV16S\n");
        }
        return cinv16so;
    }

    static int CallCCMN05U(CINV16SI pInputMsg612, CINV16SO * pOutputMsg565, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        /*
        ** Declare local variables
        */
        CCMN05UI pInvdInput = null;
        CCMN05UO pInvdOutput = null;
        
        /*
        ** Reserve memory for Invalidate Function structures
        */
        pInvdInput = new CCMN05UI();
        
        pInvdOutput = new CCMN05UO();
        pInvdInput.setArchInputStruct(pInputMsg612.getArchInputStruct());
        pInvdInput.setUlIdEvent(pInputMsg612.getROWCCMN45DO().getUlIdEvent());
        rc = Ccmn05u.InvalidateAprvl(pInvdInput, pInvdOutput, pServiceStatus);
        return rc;
    }

    
    static int CallCCMN01U(CINV16SI pInputMsg613, CINV16SO * pOutputMsg566, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        CCMN01UI pCCMN01UInputRec = null;
        CCMN01UO pCCMN01UOutputRec = null;
        
        /*
        ** Reserve memory for PostEvent Function structures
        */
        pCCMN01UInputRec = new CCMN01UI();
        
        pCCMN01UOutputRec = new CCMN01UO();
        pCCMN01UInputRec.setArchInputStruct(pInputMsg613.getArchInputStruct());
        
        if ((pInputMsg613.getROWCINV10DOG00().getDtDtCPSInvstDtlIntake().day != - 1) && (pInputMsg613.getROWCINV10DOG00().getDtDtCPSInvstDtlIntake().month != - 1) && (pInputMsg613.getROWCINV10DOG00().getDtDtCPSInvstDtlIntake().year != - 1) && (pInputMsg613.getROWCINV10DOG00().getDtDtCPSInvstDtlAssigned().day != - 1) && (pInputMsg613.getROWCINV10DOG00().getDtDtCPSInvstDtlAssigned().month != - 1) && (pInputMsg613.getROWCINV10DOG00().getDtDtCPSInvstDtlAssigned().year != - 1) && (pInputMsg613.getROWCINV10DOG00().getDtDtCPSInvstDtlBegun().day != - 1) && (pInputMsg613.getROWCINV10DOG00().getDtDtCPSInvstDtlBegun().month != - 1) && (pInputMsg613.getROWCINV10DOG00().getDtDtCPSInvstDtlBegun().year != - 1) && (pInputMsg613.getROWCINV10DOG00().getDtDtCpsInvstDtlComplt().day != - 1) && (pInputMsg613.getROWCINV10DOG00().getDtDtCpsInvstDtlComplt().month != - 1) && (pInputMsg613.getROWCINV10DOG00().getDtDtCpsInvstDtlComplt().year != - 1) && (0 != pInputMsg613.getROWCINV14DOG00().getSzCdRiskAssmtRiskFind().compareTo(NULL_STRING) || (pInputMsg613.getROWCINV10DOG00().getCIndCpsInvstDtlRaNa() == YES)) && 0 != pInputMsg613.getROWCINV14SOG00().getSzCdStageReasonClosed().compareTo(NULL_STRING)) {
            if (0 == pInputMsg613.getROWCINV14SOG00().getSzCdStageType().compareTo(CRSR_STAGE)) {
                pInputMsg613.getROWCCMN45DO().setSzCdEventStatus(EVENT_STATUS_COMPLETE);
            }
            else //  Recommended Action field must be filled in order to change
            // status to "Complete"
            if (pInputMsg613.getROWCINV10DOG00().getCdCpsOverallDisptn().compareTo(NULL_STRING) != 0) {
                pInputMsg613.getROWCCMN45DO().setSzCdEventStatus(EVENT_STATUS_COMPLETE);
            }
            //  Set Event Status to "In Progress" if all required window fields
            // not filled
            else {
                pInputMsg613.getROWCCMN45DO().setSzCdEventStatus(EVENT_STATUS_PROGRESS);
            }
        }
        /*
        ** Set Event Status to "In Progress" if all required window fields
        ** not filled
        */
        else {
            pInputMsg613.getROWCCMN45DO().setSzCdEventStatus(EVENT_STATUS_PROGRESS);
        }
        pCCMN01UInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdEvent(pInputMsg613.getROWCCMN45DO().getUlIdEvent());
        pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdStage(pInputMsg613.getROWCCMN45DO().getUlIdStage());
        pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdPerson(pInputMsg613.getROWCCMN45DO().getUlIdPerson());
        pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdTask(pInputMsg613.getROWCCMN45DO().getSzCdTask());
        pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdEventType(pInputMsg613.getROWCCMN45DO().getSzCdEventType());
        
        pCCMN01UInputRec.getROWCCMN01UIG00().setDtDtEventOccurred(pInputMsg613.getROWCCMN45DO().getDtDtEventOccurred());
        pCCMN01UInputRec.getROWCCMN01UIG00().setSzTxtEventDescr(pInputMsg613.getROWCCMN45DO().getSzTxtEventDescr());
        pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdEventStatus(pInputMsg613.getROWCCMN45DO().getSzCdEventStatus());
        pCCMN01UInputRec.getROWCCMN01UIG00().setTsLastUpdate(pInputMsg613.getROWCCMN45DO().getTsLastUpdate());
        rc = Ccmn01u.PostEvent(pCCMN01UInputRec, pCCMN01UOutputRec, pServiceStatus);
        
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
                
            case WtcHelperConstants.ARC_SUCCESS:
                
                break;
                
            case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                
                // 
                // END CAUD15D
                // 
                
                break;
            case Messages.MSG_CMN_UPDATE_FAILED:
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        }
        return rc;
    }

    static int CallCINV12D(CINV16SI pInputMsg614, CINV16SO * pOutputMsg567, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        /*
        ** Declare local variables
        */
        CINV12DI pCINV12DInputRec = null;
        CINV12DO pCINV12DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV12DInputRec = new CINV12DI();
        
        pCINV12DOutputRec = new CINV12DO();
        pCINV12DInputRec.setArchInputStruct(pInputMsg614.getArchInputStruct());
        pCINV12DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        pCINV12DInputRec.setDtDtCPSInvstDtlAssigned(pInputMsg614.getROWCINV10DOG00().getDtDtCPSInvstDtlAssigned());
        pCINV12DInputRec.setDtDtCPSInvstDtlBegun(pInputMsg614.getROWCINV10DOG00().getDtDtCPSInvstDtlBegun());
        pCINV12DInputRec.setDtDtCpsInvstDtlComplt(pInputMsg614.getROWCINV10DOG00().getDtDtCpsInvstDtlComplt());
        
        /* There are no exceptable SQL errors.  A value of FND_SUCCESS
        ** will do nothing.
        */
        pCINV12DInputRec.setDtDtCPSInvstDtlIntake(pInputMsg614.getROWCINV10DOG00().getDtDtCPSInvstDtlIntake());
        /* There are no exceptable SQL errors.  A value of FND_SUCCESS
        ** will do nothing.
        */
        pCINV12DInputRec.setUlIdStage(pInputMsg614.getROWCINV10DOG00().getUlIdStage());
        pCINV12DInputRec.setSzCdCpsInvstDtlFamIncm(pInputMsg614.getROWCINV10DOG00().getSzCdCpsInvstDtlFamIncm());
        pCINV12DInputRec.setCdCpsOverallDisptn(pInputMsg614.getROWCINV10DOG00().getCdCpsOverallDisptn());
        pCINV12DInputRec.setCIndCpsInvstDtlRaNa(pInputMsg614.getROWCINV10DOG00().getCIndCpsInvstDtlRaNa());
        pCINV12DInputRec.setBIndCpsInvstSafetyPln(pInputMsg614.getROWCINV10DOG00().getBIndCpsInvstSafetyPln());
        pCINV12DInputRec.setBIndCpsInvstEaConcl(pInputMsg614.getROWCINV10DOG00().getBIndCpsInvstEaConcl());
        pCINV12DInputRec.setCIndCpsInvstAbbrv(pInputMsg614.getROWCINV10DOG00().getCIndCpsInvstAbbrv());
        pCINV12DInputRec.setBIndCpsInvstCpsLeJointContact(pInputMsg614.getROWCINV10DOG00().getBIndCpsInvstCpsLeJointContact());
        pCINV12DInputRec.setSzCdCpsInvstCpsLeJointContact(pInputMsg614.getROWCINV10DOG00().getSzCdCpsInvstCpsLeJointContact());
        pCINV12DInputRec.setSzTxtCpsInvstCpsLeJointContact(pInputMsg614.getROWCINV10DOG00().getSzTxtCpsInvstCpsLeJointContact());
        pCINV12DInputRec.setBIndVictimTaped(pInputMsg614.getROWCINV10DOG00().getBIndVictimTaped());
        pCINV12DInputRec.setSzCdVictimTaped(pInputMsg614.getROWCINV10DOG00().getSzCdVictimTaped());
        pCINV12DInputRec.setSzTxtVictimTaped(pInputMsg614.getROWCINV10DOG00().getSzTxtVictimTaped());
        pCINV12DInputRec.setTsLastUpdate(pInputMsg614.getROWCINV10DOG00().getTsLastUpdate());
        
        pCINV12DInputRec.setUlIdEvent(pInputMsg614.getROWCINV10DOG00().getUlIdEvent());
        pCINV12DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        
        /*
        ** Retrieve the IdSvcAuth based on the IdEvent
        */
        rc = cinv12dAUDdam(sqlca, pCINV12DInputRec, pCINV12DOutputRec);
        
        /*
        ** Analyze error code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                //  Call DAM to retrieve all Service Authorization events for a
                // particular IdEvent
                rc = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                break;
            case WtcHelperConstants.SQL_DUPLICATE_KEY:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_CMN_UPDATE_FAILED;
                rc = Messages.MSG_CMN_UPDATE_FAILED;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
        }
        return rc;
    }

    static int CallCSVC18D(CINV16SI pInputMsg615, CINV16SO * pOutputMsg568, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        /*
        ** Declare local variables
        */
        CSVC18DI pCSVC18DInputRec = null;
        CSVC18DO pCSVC18DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCSVC18DInputRec = new CSVC18DI();
        
        pCSVC18DOutputRec = new CSVC18DO();
        pCSVC18DInputRec.setArchInputStruct(pInputMsg615.getArchInputStruct());
        pCSVC18DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        pCSVC18DInputRec.setUlIdStage(pInputMsg615.getROWCINV14SOG00().getUlIdStage());
        pCSVC18DInputRec.setTmSysTmStageClose(pInputMsg615.getROWCINV14SOG00().getTmSysTmStageClose());
        pCSVC18DInputRec.setTmSysTmStageStart(pInputMsg615.getROWCINV14SOG00().getTmSysTmStageStart());
        pCSVC18DInputRec.setUlIdUnit(pInputMsg615.getROWCINV14SOG00().getUlIdUnit());
        pCSVC18DInputRec.setBIndStageClose(pInputMsg615.getROWCINV14SOG00().getBIndStageClose());
        /*
        ** Anything but success us unacceptable
        */
        pCSVC18DInputRec.setSzNmStage(pInputMsg615.getROWCINV14SOG00().getSzNmStage());
        
        pCSVC18DInputRec.setSzCdStage(pInputMsg615.getROWCINV14SOG00().getSzCdStage());
        pCSVC18DInputRec.setSzCdStageClassification(pInputMsg615.getROWCINV14SOG00().getSzCdStageClassification());
        pCSVC18DInputRec.setSzCdStageCnty(pInputMsg615.getROWCINV14SOG00().getSzCdStageCnty());
        pCSVC18DInputRec.setSzCdStageCurrPriority(pInputMsg615.getROWCINV14SOG00().getSzCdStageCurrPriority());
        pCSVC18DInputRec.setSzCdStageInitialPriority(pInputMsg615.getROWCINV14SOG00().getSzCdStageInitialPriority());
        pCSVC18DInputRec.setSzCdStageProgram(pInputMsg615.getROWCINV14SOG00().getSzCdStageProgram());
        pCSVC18DInputRec.setSzCdStageReasonClosed(pInputMsg615.getROWCINV14SOG00().getSzCdStageReasonClosed());
        pCSVC18DInputRec.setDtDtStageClose(pInputMsg615.getROWCINV14SOG00().getDtDtStageClose());
        
        pCSVC18DInputRec.setDtDtStageStart(pInputMsg615.getROWCINV14SOG00().getDtDtStageStart());
        
        /**************************************************************************
        ** Function Prototypes
        ***************************************************************************/
        
        pCSVC18DInputRec.setUlIdCase(pInputMsg615.getROWCINV14SOG00().getUlIdCase());
        pCSVC18DInputRec.setUlIdSituation(pInputMsg615.getROWCINV14SOG00().getUlIdSituation());
        pCSVC18DInputRec.setSzTxtStageClosureCmnts(pInputMsg615.getROWCINV14SOG00().getSzTxtStageClosureCmnts());
        
        pCSVC18DInputRec.setSzTxtStagePriorityCmnts(pInputMsg615.getROWCINV14SOG00().getSzTxtStagePriorityCmnts());
        pCSVC18DInputRec.setSzCdStageRegion(pInputMsg615.getROWCINV14SOG00().getSzCdStageRegion());
        pCSVC18DInputRec.setSzCdStageRsnPriorityChgd(pInputMsg615.getROWCINV14SOG00().getSzCdStageRsnPriorityChgd());
        
        pCSVC18DInputRec.setSzCdStageType(pInputMsg615.getROWCINV14SOG00().getSzCdStageType());
        pCSVC18DInputRec.setTsLastUpdate(pInputMsg615.getROWCINV14SOG00().getTsLastUpdate());
        rc = csvc18dAUDdam(sqlca, pCSVC18DInputRec, pCSVC18DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                
                //  Call DAM
                rc = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                break;
            case WtcHelperConstants.SQL_DUPLICATE_KEY:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_CMN_UPDATE_FAILED;
                rc = Messages.MSG_CMN_UPDATE_FAILED;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
        }
        return rc;
    }

    
    static int CallCLSC59D(CINV16SI pInputMsg616, CINV16SO * pOutputMsg569, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int rc2 = 0;
        int i322 = 0;
        boolean bIndFoundSub = false;
        CLSC59DI pCLSC59DInputRec = null;
        CLSC59DO pCLSC59DOutputRec = null;
        
        /* SIR# 12093 */
        FndInt3date dtDtMostRecentIntake = null;
        FndInt3date dtDtNullDate = null;
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCLSC59DInputRec = new CLSC59DI();
        
        pCLSC59DOutputRec = new CLSC59DO();
        
        pCLSC59DInputRec.setArchInputStruct(pInputMsg616.getArchInputStruct());
        
        pCLSC59DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
        pCLSC59DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSC59DO._CLSC59DO__ROWCLSC59DO_SIZE);
        pCLSC59DInputRec.setUlIdCase(pInputMsg616.getROWCINV14SOG00().getUlIdCase());
        rc = clsc59dQUERYdam(sqlca, pCLSC59DInputRec, pCLSC59DOutputRec);
        
        switch (rc) {
                // person may not yet have a designated ethnicity
            case WtcHelperConstants.SQL_SUCCESS:
                //  SIR# 12093 - If the dtDtStageClose of SUB or FSU is <=
                // the dtDtStageStart of the opening of most recent intake
                // then it is OK to save and submit. Functionally, this
                // is accomplished by looping through all the stage rows
                // returned by clsc59d from above and storing the most
                // recent intake date in a local date variable
                // (dtDtMostRecentIntake).  Then in the second loop,
                // an additional conditional con be added to compare dates.
                dtDtMostRecentIntake.day = DateHelper.NULL_DATE;
                dtDtMostRecentIntake.month = DateHelper.NULL_DATE;
                dtDtMostRecentIntake.year = DateHelper.NULL_DATE;
                dtDtNullDate.day = DateHelper.NULL_DATE;
                dtDtNullDate.month = DateHelper.NULL_DATE;
                dtDtNullDate.year = DateHelper.NULL_DATE;
                
                for (i322 = 0;i322 < pCLSC59DOutputRec.getArchOutputStruct().getUlRowQty();i322++) {
                    
                    //  Validate the day and year ranges.
                    if (0 == pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(i322).getSzCdStage().compareTo(INTAKE)) {
                        
                        
                        //  If invalid parameter encountered then break out of loop
                        // and set explan_code and rc appropriately before exiting DAM.
                        if (dtDtMostRecentIntake.year == DateHelper.NULL_DATE) {
                            dtDtMostRecentIntake = pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(i322).getDtDtStageClose();
                        }
                        rc = ARC_UTLCompareDateAndTime((FndInt3date) & dtDtMostRecentIntake, (char) 0, (FndInt3date) & pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(i322).getDtDtStageStart() , (char) 0);
                        if (rc < 0) // VALID PARMS
                        {
                            dtDtMostRecentIntake = pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(i322).getDtDtStageStart();
                        }
                    }
                }
                
                
                //  Loop through all the rows returned by the dam and
                // see if there have been any SUBcare or Family SUbcare
                // stages open
                //  SIR# 12093 - if any SUBcare or Family SUbcare
                // stages opened after the most Recent intake date
                // (dtDtMostRecentIntake)
                
                for (i322 = 0;i322 < pCLSC59DOutputRec.getArchOutputStruct().getUlRowQty() && bIndFoundSub == false;i322++) {
                    //## END TUX/XML: Turn the XML buffer into an input message struct 
                    
                    
                    
                    if ((0 == pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(i322).getSzCdStage().compareTo(SUBCARE)) || (0 == pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(i322).getSzCdStage().compareTo(FAMILY_SUBCARE))) {
                        rc = ARC_UTLCompareDateAndTime((FndInt3date) & dtDtMostRecentIntake, (char) 0, (FndInt3date) & pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(i322).getDtDtStageClose() , (char) 0);
                        
                        rc2 = ARC_UTLCompareDateAndTime((FndInt3date) & dtDtNullDate, (char) 0, (FndInt3date) & pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(i322).getDtDtStageClose() , (char) 0);
                        if ((rc < 0) || (rc2 >= 0)) {
                            bIndFoundSub = true;
                        }
                    }
                    else {
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        rc = SUCCESS;
                    }
                }
                if (bIndFoundSub) {
                    if ((0 == pInputMsg616.getROWCINV14SOG00().getSzCdStageReasonClosed().substring(0, FAM_PRES_CLOSURE_LEN).compareTo(FAM_PRES_CLOSURE_1.substring(0, FAM_PRES_CLOSURE_LEN))) || (0 == pInputMsg616.getROWCINV14SOG00().getSzCdStageReasonClosed().substring(0, FAM_PRES_CLOSURE_LEN).compareTo(FAM_PRES_CLOSURE_2.substring(0, FAM_PRES_CLOSURE_LEN))) || (0 == pInputMsg616.getROWCINV14SOG00().getSzCdStageReasonClosed().substring(0, FAM_PRES_CLOSURE_LEN).compareTo(FAM_PRES_CLOSURE_3.substring(0, FAM_PRES_CLOSURE_LEN))) || (0 == pInputMsg616.getROWCINV14SOG00().getSzCdStageReasonClosed().substring(0, FAM_PRES_CLOSURE_LEN).compareTo(FAM_PRES_CLOSURE_4.substring(0, FAM_PRES_CLOSURE_LEN))) || (0 == pInputMsg616.getROWCINV14SOG00().getSzCdStageReasonClosed().substring(0, FAM_PRES_CLOSURE_LEN).compareTo(FAM_PRES_CLOSURE_5.substring(0, FAM_PRES_CLOSURE_LEN))) || (0 == pInputMsg616.getROWCINV14SOG00().getSzCdStageReasonClosed().substring(0, FAM_PRES_CLOSURE_LEN).compareTo(FAM_PRES_CLOSURE_6.substring(0, FAM_PRES_CLOSURE_LEN)))) {
                        pServiceStatus.severity = FND_SEVERITY_WARNING;
                        pServiceStatus.explan_code = Messages.MSG_FPR_NOT_FROM_INVEST;
                        rc = Messages.MSG_FPR_NOT_FROM_INVEST;
                    }
                    //  Return MSG_USE_REMOVAL_SUB_CLOSURE_RSN if the closure reason
                    // is any of the following: Fam Refusal/No Legal Interven Poss-
                    // Close (80), Family Moved After Investigation-Close (82),
                    // Workload Constraints-Close (84), or Non-family Investigation
                    // (86).
                    else if ((0 == pInputMsg616.getROWCINV14SOG00().getSzCdStageReasonClosed().substring(0, FAM_PRES_CLOSURE_LEN).compareTo(FAM_REFUSAL_CLOSURE.substring(0, FAM_PRES_CLOSURE_LEN))) || (0 == pInputMsg616.getROWCINV14SOG00().getSzCdStageReasonClosed().substring(0, FAM_PRES_CLOSURE_LEN).compareTo(FAM_MOVED_CLOSURE.substring(0, FAM_PRES_CLOSURE_LEN))) || (0 == pInputMsg616.getROWCINV14SOG00().getSzCdStageReasonClosed().substring(0, FAM_PRES_CLOSURE_LEN).compareTo(WORKLOAD_CONSTR_CLOSURE.substring(0, FAM_PRES_CLOSURE_LEN))) || (0 == pInputMsg616.getROWCINV14SOG00().getSzCdStageReasonClosed().substring(0, FAM_PRES_CLOSURE_LEN).compareTo(NONFAM_INV_CLOSURE.substring(0, FAM_PRES_CLOSURE_LEN)))) {
                        pServiceStatus.severity = FND_SEVERITY_WARNING;
                        pServiceStatus.explan_code = MSG_USE_REMOVAL_SUB_CLOSURE_RSN;
                        rc = MSG_USE_REMOVAL_SUB_CLOSURE_RSN;
                    }
                }
                else {
                    rc = SUCCESS;
                }
                
                break;
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                
                break;
        }
        return rc;
    }

    static int CallCAUDE6D(CINV16SI pInputMsg617, CINV16SO * pOutputMsg570, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        CAUDE6DI pCAUDE6DInputRec = null;/* Stage Person Link update */
        
        /*
        ** Declare local variables
        */
        
        
        CAUDE6DO pCAUDE6DOutputRec = null;
        
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCAUDE6DInputRec = new CAUDE6DI();
        
        pCAUDE6DOutputRec = new CAUDE6DO();
        
        pCAUDE6DInputRec.setArchInputStruct(pInputMsg617.getArchInputStruct());
        pCAUDE6DInputRec.setUlIdStage(pInputMsg617.getROWCINV14SOG00().getUlIdStage());
        pCAUDE6DInputRec.setSzCdStagePersRole(PERSON_STAGE_ROLE_UK);
        pCAUDE6DInputRec.setSzCdStagePersType(PERSON_TYPE_PRN);
        pCAUDE6DInputRec.setSzCdStagePersRole2(NO_ROLE);
        
        rc = caude6dAUDdam(sqlca, pCAUDE6DInputRec, pCAUDE6DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                //  Set rc to MSG_DETAIL_DELETED
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                break;
                
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                break;
        }
        return rc;
    }

}
