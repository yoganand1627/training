package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV28SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV28SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN05UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN06UO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.service.person.Ccmn05u;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSYS21DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN62DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN62DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT21DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT21DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV24DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV24DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV36DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV36DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV43DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV43DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV49DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV49DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN87DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN87DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSVC38DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSVC38DO;
/**************************************************************************
**
** Module File:   CINV28S.src
**
** Service Name:  CINV28S - UPDATE CLIENT FACTORS
**
** Description:   This service updates information modified on the APS
**        Client Assessment window.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  2/9/95
**
** Programmer:    CRG
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
** 10/25/95   YANTISTK  SIR #1959 - Logic added so that APS Investigation
**                      Detail table is not updated if CD STAGE = 'Aging Out'.
** 11/14/95   HELMKEST  Add CheckStageEventStatus common function to the
**                      service.
**
** 01/26/96   ADKINSMC  SIR #2922 - Logic added to check if another user has
**                      already saved a Client Assessment.
** 03/22/96   PHILLILH  SIR #2695 - Logic added so that APS INVESTIGATION
**                      DETAIL table is not updated if CD STAGE = 'Service
**                      Delivery'.
** 07/31/96   OMARAJJ   SIR #20941 - Added code to the Function call to
**                      CCMN87D.  The Client Assessment window's Task Table
**                      status change to multiple instance with this SIR.
**                      So code was add to prevent multiple events of Status
**                      PROC.
**
**  08/13/96  VANDERM   SIR 21968 - Database needs to be restored for all
**                      AUD services which return errors.  Thus the error
**                      handling for all AUD dams was changed from
**                      FND_SEVERITY_WARNING to FND_SEVERITY_ERROR.
**
**  01/16/98  PAULS     SIR 14235 (PART 2) - Added a date field on the APS
**                      Client Assessment Window. This date can be backdated
**                      but no earlier than the INV. Start Date. Added
**                      Completion Check functionality on the Window and
**                      Edits onthe Client Assessment Window. Added  Code to
**                      this Service to change Client FactorProblem Dates that
**                      are later than the Client Assessment Date to be the same
**                      as the Client Assessment Date.
**   1/23/03   DWW      Added following line for error handling:
**                      if (RetVal == FND_SUCESS)  { rc=FND_SUCCESS; }
**
**  04/30/03   Srini        SIR 17091: Added the error handling to take care of full
**                          table scans for ccmn87dQUERYdam.
**
**  05/05/2003  KRD     IMPACT - Code changes applied to support
**                      "Approver Mode" providing supervisors the ability to
**                      modify data without invalidating the pending
**                      approval.
**
**	07/30/03   Srini    SIR#19044 Initialize the input structure pointers
**						before the InvalidateAprvl call.
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cinv28s {
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final String TASK_STATUS_COMPLETE = "COMP";
    public static final String EVENT_STATUS_NEW = "NEW";
    /*
    ** IMPACT BEGIN - add macro
    */
    public static final String EVENT_STATUS_PEND = "PEND";
    /*
    ** IMPACT END
    */
    
    /*
    ** SIR #1959 define code for Aging Out Stage
    */
    public static final String AGING_OUT_STAGE = "AOC";
    
    /*
    ** SIR #2695 define code for Service Delivery Stage
    */
    public static final String SVC_DELIV_STAGE = "SVC";
    
    /*
    ** SIR #2922 define code for Assessment event type
    */
    public static final String ASSMT_EVENT_TYPE = "ASM";
    
    /*
    ** SIR #20941 define Event Status for CCMN87D
    */
    public static final String EVENT_STATUS_PROC = "PROC";
    public static final int PAGE_NUM_ONE = 1;
    CINV28SO CINV28S(CINV28SI cinv28si) {
        CINV28SO cinv28so = new CINV28SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        
        /*
        ** Declare FOUNDATION variables
        */
        
        /*
        ** Declare local variables
        */
        ROWCCMN01UIG00 PostEventRec = null;
        CCMN05UI pInvdInput = null;
        CCMN05UO pInvdOutput = null;
        
        /* SIR 1710: Variables used in CheckStageEventStatus common function */
        int RetVal = SUCCESS;
        CCMN06UI pCCMN06UInputRec = null;/* Check Stage/Event common Function */
        
        CCMN06UO pCCMN06UOutputRec = null;
        rc = ARC_PRFServiceStartTime_TUX(cinv28si.getArchInputStruct());
        
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
        ** SIR 1710:
        ** (BEGIN): Common Function: ccmn06u  ** Check Stage/Event common function
        **************************************************************************/
        
        /*
        ** Allocate memory for Common Function Input and Output Structures
        */
        pCCMN06UInputRec = new CCMN06UI();
        
        pCCMN06UOutputRec = new CCMN06UO();
        pCCMN06UInputRec.setArchInputStruct(cinv28si.getArchInputStruct());
        pCCMN06UInputRec.getArchInputStruct().setCReqFuncCd(cinv28si.getArchInputStruct().getCReqFuncCd());
        pCCMN06UInputRec.setUlIdStage(cinv28si.getROWCCMN46DI().getUlIdStage());
        pCCMN06UInputRec.setSzCdTask(cinv28si.getROWCCMN46DI().getSzCdTask());
        rc = Ccmn06u.CheckStageEventStatus(pCCMN06UInputRec, pCCMN06UOutputRec, pServiceStatus);
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                //  Set RetVal to FND_SUCCESS
                RetVal = SUCCESS;
                break;
            case Messages.MSG_SYS_STAGE_CLOSED:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_SYS_STAGE_CLOSED;
                
                //  Set RetVal to FND_FAIL
                RetVal = Csub50s.FND_FAIL;
                break;
            case Messages.MSG_SYS_EVENT_STS_MSMTCH:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_SYS_EVENT_STS_MSMTCH;
                
                //  Set RetVal to FND_FAIL
                RetVal = Csub50s.FND_FAIL;
                break;
            case Messages.MSG_SYS_MULT_INST:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_SYS_MULT_INST;
                
                //  Set RetVal to FND_FAIL
                RetVal = Csub50s.FND_FAIL;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                
                //  Set RetVal to FND_FAIL
                RetVal = Csub50s.FND_FAIL;
                break;
        }
        if (SUCCESS == RetVal) {
            if (0 == cinv28si.getROWCCMN46DI().getUlIdEvent()) {
                
                //  Start Performance Timer
                rc = Ccmn02u.CallCCMN87D(cinv28si, cinv28so, pServiceStatus);
                
                
                //  Analyze return code
                switch (rc) {
                    case SUCCESS:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        rc = 0;
                        break;
                    case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                        pServiceStatus.severity = FND_SEVERITY_WARNING;
                        pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                        rc = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        break;
                    case NO_DATA_FOUND:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        
                        
                        //  Call CAUD44D
                        rc = 0;
                        break;
                    case Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST:
                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                        pServiceStatus.explan_code = Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST;
                        rc = Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST;
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                }
            }
            
            
            // Call CAUD57D if the service input message -> 
            // cIndPalFollupNoPubAst, No Public Assistance, is "NO"
            
            if (!(cinv28si.getROWCCMN46DI().getUlIdEvent() != 0)) {
                
                ARC_UTLGetDateAndTime(cinv28si.getROWCCMN46DI().getDtDtEventOccurred() , 0);
                cinv28si.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
            }
            else {
                cinv28si.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                cinv28so.getUlIdEvent().value = cinv28si.getROWCCMN46DI().getUlIdEvent();
            }
            PostEventRec.setUlIdEvent(cinv28si.getROWCCMN46DI().getUlIdEvent());
            PostEventRec.setUlIdStage(cinv28si.getROWCCMN46DI().getUlIdStage());
            PostEventRec.setUlIdPerson(cinv28si.getROWCCMN46DI().getUlIdPerson());
            PostEventRec.setSzCdTask(cinv28si.getROWCCMN46DI().getSzCdTask());
            PostEventRec.setSzCdEventType(cinv28si.getROWCCMN46DI().getSzCdEventType());
            PostEventRec.setDtDtEventOccurred(cinv28si.getROWCCMN46DI().getDtDtEventOccurred());
            PostEventRec.setSzTxtEventDescr(cinv28si.getROWCCMN46DI().getSzTxtEventDescr());
            PostEventRec.setSzCdEventStatus(cinv28si.getROWCCMN46DI().getSzCdEventStatus());
            PostEventRec.setTsLastUpdate(cinv28si.getROWCCMN46DI().getTsLastUpdate());
            rc = Ccmn25s.CallPostEvent(cinv28si.getArchInputStruct() , PostEventRec, cinv28so.getUlIdEvent() , pServiceStatus);
            
            
            //  Analyze return code
            switch (rc) {
                case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    break;
                case WtcHelperConstants.SQL_DUPLICATE_KEY:
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            if (cinv28si.getUlIdEvent() != 0 && false == cinv28si.getArchInputStruct().getUlSysNbrReserved1()) {
                
                //  Reserve memory for Invalidate Function structures
                pInvdInput = new CCMN05UI();
                
                pInvdOutput = new CCMN05UO();
                pInvdInput.setArchInputStruct(cinv28si.getArchInputStruct());
                if (cinv28si.getROWCCMN46DI().getUlIdEvent() == 0 ||!(strncmp(cinv28si.getROWCCMN46DI().getSzCdEventStatus() , EVENT_STATUS_NEW, EVENT_STATUS_NEW.length()) != 0)) {
                    
                    
                    //  Call CMSC08D to retrieve # of reversal line items
                    rc = Ccmn05u.CallCCMN62D(cinv28si, cinv28so, pServiceStatus);
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    pInvdInput.setUlIdEvent(cinv28si.getUlIdEvent());
                }
                else {
                    pInvdInput.setUlIdEvent(cinv28si.getROWCCMN46DI().getUlIdEvent());
                }
                
                
                //  Call CMSC08D to retrieve # of adjustment line items
                rc = Ccmn05u.InvalidateAprvl(pInvdInput, pInvdOutput, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            if (cinv28si.getROWCINV28SIG02().getSzCdScrDataAction() == WtcHelperConstants.REQ_FUNC_CD_UPDATE) {
                if (cinv28si.getROWCINV28SIG02().getSzCdStage().compareTo(AGING_OUT_STAGE) != 0 && cinv28si.getROWCINV28SIG02().getSzCdStage().compareTo(SVC_DELIV_STAGE) != 0) {
                    rc = Cinv21s.CallCINV24D(cinv28si, cinv28so, pServiceStatus);
                    
                    
                    //  Analyze return code
                    switch (rc) {
                            
                        case WtcHelperConstants.SQL_SUCCESS:
                            break;
                        case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    }
                }
            }
            
            //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
            // 01/22/2003 DWW: Added for error handling
            if (cinv28si.getROWCCMN46DI().getUlIdEvent() != 0 &&!(strncmp(cinv28si.getROWCCMN46DI().getSzCdEventStatus() , TASK_STATUS_COMPLETE, TASK_STATUS_COMPLETE.length()) != 0)) {
                rc = Cinv12s.CallCINV43D(cinv28si, cinv28so, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            
            
            //  Call CAUD04D for AUD
            rc = CallCINV36D(cinv28si, cinv28so, pServiceStatus);
            
            
            //  Analyze return code
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    break;
                    
                default :
                    
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            
            if ((0 == strncmp(cinv28si.getROWCCMN46DI().getSzCdEventStatus() , TASK_STATUS_COMPLETE, TASK_STATUS_COMPLETE.length())) || (0 == strncmp(cinv28si.getROWCCMN46DI().getSzCdEventStatus() , EVENT_STATUS_PEND, EVENT_STATUS_PEND.length()))) {
                rc = CallCSVC38D(cinv28si, cinv28so, pServiceStatus);
                
                
                //  Analyze return code
                switch (rc) {
                    case WtcHelperConstants.SQL_SUCCESS:
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                }
            }
        }
        
        
        
        
        /* Setup for service function exit */
        
        
        ARC_PRFServiceStopTime_TUX(cinv28si.getArchInputStruct() , cinv28so.getArchOutputStruct());
        
        if (RetVal == SUCCESS) {
            rc = SUCCESS;
        }
        
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber());
        }
        else {
            
            if (tpcommit(0) == - 1) {
                System.err.println("ERROR: tpcommit failed (" + (tpstrerror(tperrno)) + ")");
                userlog("ERROR: tpcommit failed (%s)\n", tpstrerror(tperrno));
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                
                //  Call CLSCB2D
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        return cinv28so;
    }

    static int PrepServiceExit(_SERVICE_DATA * pfpb, _RTAF * pRTAF, _ABHI * pABHI) {
        
        _MSG_PARM_BLOCK * pMsgPB = (_MSG_PARM_BLOCK) pfpb.pTXN_PB;
        _MSG_PARM_BLOCK * pReturnPB = (_MSG_PARM_BLOCK) pRTAF.pReply_txn_pb;
        int rc = 0;
        pOutputMsgTransMap.map_name = "CINV28SO";
        pOutputMsgTransMap.map_version = "01";
        
        /*
        ** Stop performance timer for service
        */
        
        ARC_PRFServiceStopTime_TUX(Csys08s.pInputMsg.getArchInputStruct() , Csys08s.pOutputMsg.getArchOutputStruct());
        return SUCCESS;
    }

    static int CallPostEvent(CSYS21DI.ArchInputStruct ArchInputStruct7, ROWCCMN01UIG00 ROWCCMN01UIG006, Pint ulIdEvent26, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = SUCCESS;/* Return code  */
        CCMN01UI pInputMsg688 = null;
        CCMN01UO pOutputMsg638 = null;
        pInputMsg688 = new CCMN01UI();
        pOutputMsg638 = new CCMN01UO();
        pInputMsg688.setArchInputStruct(ArchInputStruct7);
        pInputMsg688.setROWCCMN01UIG00(ROWCCMN01UIG006);
        pOutputMsg638.setUlIdEvent(ulIdEvent26.value);
        
        
        rc = Ccmn01u.PostEvent(pInputMsg688, pOutputMsg638, pServiceStatus);
        if (ulIdEvent26.value == null) {
            ulIdEvent26.value = pOutputMsg638.getUlIdEvent();
        }
        
        return rc;
    }

    static int CallCCMN62D(CINV28SI pInputMsg689, CINV28SO * pOutputMsg639, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        CCMN62DI pCCMN62DInputRec = null;
        CCMN62DO pCCMN62DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN62DInputRec = new CCMN62DI();
        
        pCCMN62DOutputRec = new CCMN62DO();
        pCCMN62DInputRec.setUlIdEvent(pInputMsg689.getUlIdEvent());
        pCCMN62DInputRec.setSzCdEventStatus(TASK_STATUS_COMPLETE);
        pCCMN62DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        
        /*
        ** Call CSYS06D
        */
        rc = ccmn62dAUDdam(sqlca, pCCMN62DInputRec, pCCMN62DOutputRec);
        if (rc != 0) {
            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    
    static int CallCINT21D(CINV28SI pInputMsg690, Pint ulIdSituation7, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CINT21DI pCINT21DInputRec = null;
        CINT21DO pCINT21DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINT21DInputRec = new CINT21DI();
        
        pCINT21DOutputRec = new CINT21DO();
        pCINT21DInputRec.setUlIdStage(pInputMsg690.getROWCCMN46DI().getUlIdStage());
        
        /*
        ** Call CCMN45D
        */
        rc = cint21dQUERYdam(sqlca, pCINT21DInputRec, pCINT21DOutputRec);
        /************************************************************************
        ** (BEGIN): Contract modification process if the contract already
        **          exists and a change has been made to the home's County field.
        **          SIR 20360
        ************************************************************************/
        /****************************** UPDATE CODE ****************************/
        
        /* if home is NOT being closed and is non-prs home */
        
        /*
        ** SIR 19600 - Modified statement to use FND_YES rather than TRUE.
        **
        ** Original code:
        **  if((TRUE == pInputMsg->bIndRsrcNonPrs)  &&
        */
        if (rc != 0) {
            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        else {
            ulIdSituation7.value = pCINT21DOutputRec.getUlIdSituation();
        }
        return rc;
    }

    static int CallCINV24D(CINV28SI pInputMsg691, CINV28SO * pOutputMsg640, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CINV24DI pCINV24DInputRec = null;
        CINV24DO pCINV24DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV24DInputRec = new CINV24DI();
        
        pCINV24DOutputRec = new CINV24DO();
        pCINV24DInputRec.setSzCdApsInvstFinalPrty(pInputMsg691.getROWCINV28SIG02().getSzCdApsInvstFinalPrty());
        pCINV24DInputRec.setSzcdApsInvstOvrallDisp(pInputMsg691.getROWCINV28SIG02().getSzcdApsInvstOvrallDisp());
        pCINV24DInputRec.setDtDtApsInvstBegun(pInputMsg691.getROWCINV28SIG02().getDtDtApsInvstBegun());
        pCINV24DInputRec.setDtDtApsInvstCltAssmt(pInputMsg691.getROWCINV28SIG02().getDtDtApsInvstCltAssmt());
        pCINV24DInputRec.setDtDtApsInvstCmplt(pInputMsg691.getROWCINV28SIG02().getDtDtApsInvstCmplt());
        pCINV24DInputRec.setUlIdEvent(pInputMsg691.getROWCINV28SIG02().getUlIdEvent());
        pCINV24DInputRec.setUlIdStage(pInputMsg691.getROWCINV28SIG02().getUlIdStage());
        pCINV24DInputRec.setTsLastUpdate(pInputMsg691.getROWCINV28SIG02().getTsLastUpdate());
        pCINV24DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        rc = cinv24dAUDdam(sqlca, pCINV24DInputRec, pCINV24DOutputRec);
        switch (rc) {
            case SUCCESS:
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                
                //  Call DAM
                rc = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                break;
                
            default :
                
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCINV36D(CINV28SI pInputMsg692, CINV28SO pOutputMsg641, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i345 = 0;
        Pint ulIdSituation8 = new Pint();
        CINV36DI pCINV36DInputRec = null;
        CINV36DO pCINV36DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV36DInputRec = new CINV36DI();
        
        pCINV36DOutputRec = new CINV36DO();
        /* insert into educational_history table */
        rc = Ccmn02u.CallCINT21D(pInputMsg692, ulIdSituation8, pServiceStatus);
        switch (rc) {
                
            case SUCCESS:
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        
        
        /*
        ** Populate Input Structure for DAM
        */
        for (i345 = 0;i345 < pInputMsg692.getArchInputStruct().getUlPageSizeNbr();i345++) {
            if (pInputMsg692.getROWCINV28SIG01_ARRAY().getROWCINV28SIG01(i345).getSzCdSysDataActionOutcome() == WtcHelperConstants.REQ_FUNC_CD_DELETE) {
                rc = CallCINV49D(pInputMsg692.getROWCINV28SIG01_ARRAY().getROWCINV28SIG01(i345).getUlIdApsCltFactor() , pOutputMsg641, pServiceStatus);
                
                //  Analyze return code
                switch (rc) {
                    case SUCCESS:
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                }
            }
            pCINV36DInputRec.getROWCINV36DI().setUlIdApsCltFactor(pInputMsg692.getROWCINV28SIG01_ARRAY().getROWCINV28SIG01(i345).getUlIdApsCltFactor());
            if (pInputMsg692.getROWCINV28SIG01_ARRAY().getROWCINV28SIG01(i345).getSzCdScrDataAction() == WtcHelperConstants.REQ_FUNC_CD_ADD) {
                pCINV36DInputRec.getROWCINV36DI().setUlIdEvent(pOutputMsg641.getUlIdEvent().value);
                pCINV36DInputRec.getROWCINV36DI().setUlIdSituation(ulIdSituation8.value);
            }
            else {
                pCINV36DInputRec.getROWCINV36DI().setUlIdEvent(pInputMsg692.getROWCINV28SIG01_ARRAY().getROWCINV28SIG01(i345).getUlIdEvent());
                pCINV36DInputRec.getROWCINV36DI().setUlIdSituation(pInputMsg692.getROWCINV28SIG01_ARRAY().getROWCINV28SIG01(i345).getUlIdSituation());
            }
            pCINV36DInputRec.getROWCINV36DI().setSzCdApsClientFactor(pInputMsg692.getROWCINV28SIG01_ARRAY().getROWCINV28SIG01(i345).getSzCdApsClientFactor());
            pCINV36DInputRec.getROWCINV36DI().setSzCdApsCltFactorAns(pInputMsg692.getROWCINV28SIG01_ARRAY().getROWCINV28SIG01(i345).getSzCdApsCltFactorAns());
            pCINV36DInputRec.getROWCINV36DI().setCCdApsClientFactor(pInputMsg692.getROWCINV28SIG01_ARRAY().getROWCINV28SIG01(i345).getCCdApsClientFactor());
            pCINV36DInputRec.getROWCINV36DI().setSzTxtApsCltFactorCmnts(pInputMsg692.getROWCINV28SIG01_ARRAY().getROWCINV28SIG01(i345).getSzTxtApsCltFactorCmnts());
            pCINV36DInputRec.getROWCINV36DI().setTsLastUpdate(pInputMsg692.getROWCINV28SIG01_ARRAY().getROWCINV28SIG01(i345).getTsLastUpdate());
            pCINV36DInputRec.getArchInputStruct().setCReqFuncCd(pInputMsg692.getROWCINV28SIG01_ARRAY().getROWCINV28SIG01(i345).getSzCdScrDataAction());
            rc = cinv36dAUDdam(sqlca, pCINV36DInputRec, pCINV36DOutputRec);
            switch (rc) {
                    
                case SUCCESS:
                    break;
                    
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                    
                    //  Call DAM
                    rc = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        
        return rc;
    }

    static int CallCINV43D(CINV28SI pInputMsg693, CINV28SO * pOutputMsg642, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CINV43DI pCINV43DInputRec = null;
        CINV43DO pCINV43DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV43DInputRec = new CINV43DI();
        
        pCINV43DOutputRec = new CINV43DO();
        pCINV43DInputRec.setUlIdEvent(pInputMsg693.getROWCCMN46DI().getUlIdEvent());
        
        rc = cinv43dAUDdam(sqlca, pCINV43DInputRec, pCINV43DOutputRec);
        if (rc != 0) {
            switch (rc) {
                case NO_DATA_FOUND:
                    rc = 0;
                    
                    break;
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        return rc;
    }

    static int CallCINV49D(Pint ulIdApsCltFactor1, CINV28SO * pOutputMsg643, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CINV49DI pCINV49DInputRec = null;
        CINV49DO pCINV49DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV49DInputRec = new CINV49DI();
        
        pCINV49DOutputRec = new CINV49DO();
        pCINV49DInputRec.setUlIdApsCltFactor(ulIdApsCltFactor1.value);
        pCINV49DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_DELETE);
        rc = cinv49dAUDdam(sqlca, pCINV49DInputRec, pCINV49DOutputRec);
        
        if (rc != 0) {
            switch (rc) {
                case NO_DATA_FOUND:
                    rc = 0;
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        return rc;
    }

    static int CallCCMN87D(CINV28SI pInputMsg694, CINV28SO * pOutputMsg644, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CCMN87DI pCCMN87DInputRec = null;
        CCMN87DO pCCMN87DOutputRec = null;
        int usRow = 0;/* SIR#20941 */
        
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN87DInputRec = new CCMN87DI();
        
        pCCMN87DOutputRec = new CCMN87DO();
        pCCMN87DInputRec.setArchInputStruct(pInputMsg694.getArchInputStruct());
        pCCMN87DInputRec.setUlIdStage(pInputMsg694.getROWCCMN46DI().getUlIdStage());
        pCCMN87DInputRec.setSzCdTask(pInputMsg694.getROWCCMN46DI().getSzCdTask());
        pCCMN87DInputRec.getArchInputStruct().setUsPageNbr(PAGE_NUM_ONE);
        pCCMN87DInputRec.getArchInputStruct().setUlPageSizeNbr(CCMN87DO._CCMN87DO__ROWCCMN87DO_SIZE);
        pCCMN87DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        
        /*
        ** Call DAM
        */
        rc = ccmn87dQUERYdam(sqlca, pCCMN87DInputRec, pCCMN87DOutputRec);
        
        /*
        ** SIR 2922-
        ** Blindly return rc code to allow user to determine
        ** proper course of action
        */
        
        
        /* SIR#20941 - This SIR allows for the existance of multiple Client
        ** Assessment events.  Thus, the following code was added to prevent the
        ** error encountered in SIR #2922, but allows for multiple instances.
        */
        for (usRow = 0;usRow < pCCMN87DOutputRec.getArchOutputStruct().getUlRowQty();usRow++) {
            if (!(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(usRow).getSzCdEventStatus().compareTo(EVENT_STATUS_PROC) != 0)) {
                rc = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                usRow = pCCMN87DOutputRec.getArchOutputStruct().getUlRowQty();
            }
        }
        return rc;
    }

    static int CallCSVC38D(CINV28SI pInputMsg695, CINV28SO pOutputMsg645, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CSVC38DI pCSVC38DInputRec = null;
        CSVC38DO pCSVC38DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCSVC38DInputRec = new CSVC38DI();
        
        pCSVC38DOutputRec = new CSVC38DO();
        
        pCSVC38DInputRec.setUlIdEvent(pOutputMsg645.getUlIdEvent().value);
        
        pCSVC38DInputRec.setDtDtApsInvstCltAssmt(pInputMsg695.getROWCINV28SIG02().getDtDtApsInvstCltAssmt());
        pCSVC38DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        rc = csvc38dAUDdam(sqlca, pCSVC38DInputRec, pCSVC38DOutputRec);
        switch (rc) {
            case SUCCESS:
                break;
            case NO_DATA_FOUND:
                rc = 0;
                break;
                
                //  PWO 1111: Removed case statement.
                // case SQL_NOT_FOUND:
                // pServiceStatus->severity    = FND_SEVERITY_ERROR;
                // pServiceStatus->explan_code = MSG_CMN_TMSTAMP_MISMATCH;
                // rc = MSG_CMN_TMSTAMP_MISMATCH;
                // break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

}
