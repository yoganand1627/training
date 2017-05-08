package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV12SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV12SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
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
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV43DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV43DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN62DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN62DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV16DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV16DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV12DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV12DO;
/**************************************************************************
**
** Module File:   cinv12s.src
**
** Service Name:  CINV12S
**
** Description:   Saves information for the Emergency Action Table
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  3/9/95
**
** Programmer:    SPR
**
** Updated:    5/22/95 by MKB
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  11/14/95  HELMKEST  Add CheckStageEventStatus common function to the
**                      CINV06S service.
**
**  08/13/96  VANDERM   SIR 21968 - Database needs to be restored for all
**                      AUD services which return errors.  Thus the error
**                      handling for all AUD dams was changed from
**                      FND_SEVERITY_WARNING to FND_SEVERITY_ERROR.
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
**  06/30/03  Srini     SIR 18602 - Modified to fix error handling for
**                      transaction aware code
**
**  07/10/03  Srini     SIR 18602 - More changes. Changed all PROCESS_TUX_RC_ERROR
**                      calls to PROCESS_TUX_RC_ERROR_TRANSACT and
**                      PROCESS_TUX_SQL_ERROR calls to
**                      PROCESS_TUX_SQL_ERROR_TRANSACT calls.
**
**  07/30/03   Srini    SIR#19044 Initialize the input structure pointers
**                      before the InvalidateAprvl call.
**
**  01/24/04  RIOSJA    SIR 22486 - Added logic to this service so that the
**                      service determines whether or not the family is
**                      eligible for Emergency Assistance. In CAPS, this
**                      same logic was in the Emergency Assistance window
**                      (cinv13w.win), and the window passed the indicator
**                      value to this service. But in IMPACT, the logic
**                      was never added to the CPSInvCnclsnConversation,
**                      so Person Eligibility was not being determined
**                      properly. This fix will correct the problem.
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cinv12s {
    
    /* RIOSJA, SIR 22486 */
    public static final String CEAFINCM_I5 = "I5";
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final String EVENT_STATUS_PROGRESS = "PROC";
    public static final String EVENT_STATUS_COMPLETE = "COMP";
    public static final String EVENT_STATUS_PENDING = "PEND";
    public static final int NUMLISTBOXROWS = 3;
    static int transactionflag = - 1;
    CINV12SO CINV12S(CINV12SI cinv12si) {
        CINV12SO cinv12so = new CINV12SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        //## END TUX/XML: Turn the XML buffer into an input message struct
        
        
        //SIR 17188 - IMPACT: Added code to make Service Transaction aware
        // Need to check if the transaction is already in progress as this service is called
        // from another service.
        //SIR 18602
        transactionflag = - 1;
        boolean bTransactionStarted = false;
        transactionflag = tpgetlev();
        if (transactionflag == - 1) {
            userlog("ERROR: tpgetlev failed in CINV12S (%s)\n", tpstrerror(tperrno));
            pServiceStatus.severity = FND_SEVERITY_ERROR;
            pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPBEGIN_FAILED;
            rc = Arcxmlerrors.ARC_ERR_TUX_TPBEGIN_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        }
        else if (transactionflag == 1) {
            // This is the case of transaction in progress.
            //So we should not start a new one
            userlog("START: TRANSACTION ALREADY IN PROGRESS in CINV12S\n");
        }
        else if (transactionflag == 0) {
            userlog("TRANSACTION IS STARTED in CINV12S\n");
            bTransactionStarted = true;
        }
        
        /*
        ** Declare FOUNDATION variables
        */
        
        /*
        ** Declare local variables
        */
        ROWCCMN01UIG00 PostEventInputRec = null;
        CCMN01UO PostEventOutputRec = null;
        CCMN05UI pInvdInput = null;
        CCMN05UO pInvdOutput = null;
        
        /* SIR 1710: Variables used in CheckStageEventStatus common function */
        int RetVal = SUCCESS;
        
        CCMN06UI pCCMN06UInputRec = null;
        CCMN06UO pCCMN06UOutputRec = null;
        rc = ARC_PRFServiceStartTime_TUX(cinv12si.getArchInputStruct());
        if (!(cinv12si.getROWCCMN01UIG00().getUlIdEvent() != 0)) {
            ARC_UTLGetDateAndTime(cinv12si.getROWCCMN01UIG00().getDtDtEventOccurred() , 0);
            cinv12si.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
        }
        else {
            cinv12si.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
            cinv12so.getUlIdEvent().value = cinv12si.getROWCCMN01UIG00().getUlIdEvent();
        }
        
        /**************************************************************************
        ** SIR 1710:
        ** (BEGIN): Common Function: ccmn06u  ** Check Stage/Event common function
        **************************************************************************/
        
        /*
        ** Allocate memory for Common Function Input and Output Structures
        */
        pCCMN06UInputRec = new CCMN06UI();
        
        pCCMN06UOutputRec = new CCMN06UO();
        pCCMN06UInputRec.setArchInputStruct(cinv12si.getArchInputStruct());
        pCCMN06UInputRec.getArchInputStruct().setCReqFuncCd(cinv12si.getArchInputStruct().getCReqFuncCd());
        pCCMN06UInputRec.setUlIdStage(cinv12si.getROWCCMN01UIG00().getUlIdStage());
        pCCMN06UInputRec.setSzCdTask(cinv12si.getROWCCMN01UIG00().getSzCdTask());
        rc = Ccmn06u.CheckStageEventStatus(pCCMN06UInputRec, pCCMN06UOutputRec, pServiceStatus);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
                
                //SIR:17091 Srini: Added the error handling to take care of full table scans.
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
                
                //SIR:17091 Srini: Added the error handling to take care of full table scans.
            case Messages.MSG_SYS_MULT_INST:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_SYS_MULT_INST;
                
                //  Set RetVal to FND_FAIL
                RetVal = Csub50s.FND_FAIL;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                
                //  Set RetVal to FND_FAIL
                RetVal = Csub50s.FND_FAIL;
                break;
        }
        
        if (SUCCESS == RetVal) {
            PostEventInputRec.setUlIdEvent(cinv12si.getROWCCMN01UIG00().getUlIdEvent());
            PostEventInputRec.setUlIdStage(cinv12si.getROWCCMN01UIG00().getUlIdStage());
            PostEventInputRec.setUlIdPerson(cinv12si.getROWCCMN01UIG00().getUlIdPerson());
            PostEventInputRec.setSzCdTask(cinv12si.getROWCCMN01UIG00().getSzCdTask());
            PostEventInputRec.setSzCdEventType(cinv12si.getROWCCMN01UIG00().getSzCdEventType());
            PostEventInputRec.setDtDtEventOccurred(cinv12si.getROWCCMN01UIG00().getDtDtEventOccurred());
            PostEventInputRec.setTsLastUpdate(cinv12si.getROWCCMN01UIG00().getTsLastUpdate());
            PostEventInputRec.setSzTxtEventDescr(cinv12si.getROWCCMN01UIG00().getSzTxtEventDescr());
            PostEventInputRec.setSzCdEventStatus(cinv12si.getROWCCMN01UIG00().getSzCdEventStatus());
            rc = Ccmn25s.CallPostEvent(cinv12si.getArchInputStruct() , PostEventInputRec, cinv12so.getUlIdEvent() , pServiceStatus);
            
            //  Analyze return code
            switch (rc) {
                case WtcHelperConstants.ARC_SUCCESS:
                    break;
                    
                case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
            }
            if (false == cinv12si.getArchInputStruct().getUlSysNbrReserved1()) {
                
                if (cinv12si.getUlIdEvent() != 0) {
                    //  Reserve memory for Invalidate Function structures
                    pInvdInput = new CCMN05UI();
                    pInvdOutput = new CCMN05UO();
                    pInvdInput.setArchInputStruct(cinv12si.getArchInputStruct());
                    
                    if (cinv12si.getArchInputStruct().getCReqFuncCd() == WtcHelperConstants.REQ_FUNC_CD_UPDATE) {
                        pInvdInput.setUlIdEvent(cinv12si.getROWCCMN01UIG00().getUlIdEvent());
                    }
                    else {
                        rc = Ccmn05u.CallCCMN62D(cinv12si, cinv12so, pServiceStatus);
                        
                        if (rc != 0) {
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                        }
                        pInvdInput.setUlIdEvent(cinv12si.getUlIdEvent());
                    }
                    
                    //  Call CSES01D, Contract Version retrieve for an idContract
                    rc = Ccmn05u.InvalidateAprvl(pInvdInput, pInvdOutput, pServiceStatus);
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                }
                
                if (cinv12si.getROWCCMN01UIG00().getUlIdEvent() != 0 &&!(strncmp(cinv12si.getROWCCMN01UIG00().getSzCdEventStatus() , EVENT_STATUS_COMPLETE, EVENT_STATUS_COMPLETE.length()) != 0)) {
                    
                    //  Call CAUD15D. Performs a full row
                    // update/insert to the Contract Version table.
                    rc = Cinv15s.CallCINV43D(cinv12si, cinv12so, pServiceStatus);
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                }
            }
            
            rc = CallCINV16D(cinv12si, cinv12so, pServiceStatus);
            
            //  Analyze return code
            switch (rc) {
                    
                    //SIR:17091 Srini: Added the error handling to take care of full table scans.
                case WtcHelperConstants.ARC_SUCCESS:
                    break;
                case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
            }
            
            //  Call CAUD17D.  The Contract Service AUD performs a full row
            // insert to the Contract Service table.
            rc = Cinv16s.CallCINV12D(cinv12si, cinv12so, pServiceStatus);
            
            //  Analyze return code
            switch (rc) {
                    
                case WtcHelperConstants.ARC_SUCCESS:
                    break;
                    
                    //SIR:17091 Srini: Added the error handling to take care of full table scans.
                case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                    break;
                    
                default :
                    
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
            }
        }
        
        
        /* Setup for service function exit */
        
        
        ARC_PRFServiceStopTime_TUX(cinv12si.getArchInputStruct() , cinv12so.getArchOutputStruct());
        
        if (RetVal == SUCCESS) {
            
            rc = SUCCESS;
        }
        
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError_Transact(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber() , transactionflag);
        }
        else if (bTransactionStarted) {
            
            if (tpcommit(0) == - 1) {
                userlog("ERROR: tpcommit failed in service CINV12S (%s)\n", tpstrerror(tperrno));
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                // Retrieve DAM from Contract_County
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
            }
            //SIR 18602
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        else {
            userlog("END: TRANSACTION ALREADY IN PROGRESS CINV12S\n");
        }
        return cinv12so;
    }

    static int PrepServiceExit(_SERVICE_DATA * pfpb, _RTAF * pRTAF, _ABHI * pABHI) {
        _MSG_PARM_BLOCK * pMsgPB = (_MSG_PARM_BLOCK) pfpb.pTXN_PB;
        
        _MSG_PARM_BLOCK * pReturnPB = (_MSG_PARM_BLOCK) pRTAF.pReply_txn_pb;
        int rc = 0;/* Return code */
        pOutputMsgTransMap.map_name = "CINV03SO";
        pOutputMsgTransMap.map_version = "01";
        
        /*
        ** Stop performance timer for service
        */
        
        ARC_PRFServiceStopTime_TUX(Csys08s.pInputMsg.getArchInputStruct() , Csys08s.pOutputMsg.getArchOutputStruct());
        return SUCCESS;
    }

    static int CallPostEvent(CSYS21DI.ArchInputStruct ArchInputStruct2, ROWCCMN01UIG00 ROWCCMN01UIG002, Pint ulIdEvent15, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = SUCCESS;/* Return code */
        CCMN01UI pInputMsg580 = null;
        CCMN01UO pOutputMsg532 = null;
        pInputMsg580 = new CCMN01UI();
        pOutputMsg532 = new CCMN01UO();
        pInputMsg580.setArchInputStruct(ArchInputStruct2);
        pInputMsg580.setROWCCMN01UIG00(ROWCCMN01UIG002);
        pOutputMsg532.setUlIdEvent(ulIdEvent15.value);
        rc = Ccmn01u.PostEvent(pInputMsg580, pOutputMsg532, pServiceStatus);
        
        if (ulIdEvent15.value == null) {
            ulIdEvent15.value = pOutputMsg532.getUlIdEvent();
        }
        return rc;
    }

    static int CallCINV43D(CINV12SI pInputMsg581, CINV12SO * pOutputMsg533, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        CINV43DI pCINV43DInputRec = null;
        CINV43DO pCINV43DOutputRec = null;/* ToDo Update DAM */
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV43DInputRec = new CINV43DI();
        pCINV43DOutputRec = new CINV43DO();
        pCINV43DInputRec.setArchInputStruct(pInputMsg581.getArchInputStruct());
        
        pCINV43DInputRec.setUlIdEvent(pInputMsg581.getROWCCMN01UIG00().getUlIdEvent());
        
        /*
        ** Call CCMN39D
        */
        rc = cinv43dAUDdam(sqlca, pCINV43DInputRec, pCINV43DOutputRec);
        if (rc != 0) {
            switch (rc) {
                    
                case NO_DATA_FOUND:
                    rc = 0;
                    
                    break;
                default :
                    
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
            }
        }
        return rc;
    }

    static int CallCCMN62D(CINV12SI pInputMsg582, CINV12SO * pOutputMsg534, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        /*
        ** Declare local variables
        */
        CCMN62DI pCCMN62DInputRec = null;
        CCMN62DO pCCMN62DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN62DInputRec = new CCMN62DI();
        pCCMN62DOutputRec = new CCMN62DO();
        pCCMN62DInputRec.setArchInputStruct(pInputMsg582.getArchInputStruct());
        pCCMN62DInputRec.setUlIdEvent(pInputMsg582.getUlIdEvent());
        pCCMN62DInputRec.setSzCdEventStatus(EVENT_STATUS_COMPLETE);
        pCCMN62DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        
        /*
        ** Call CSES37D
        */
        rc = ccmn62dAUDdam(sqlca, pCCMN62DInputRec, pCCMN62DOutputRec);
        if (rc != WtcHelperConstants.SQL_SUCCESS) {
            Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
        }
        return rc;
    }

    static int CallCINV16D(CINV12SI pInputMsg583, CINV12SO pOutputMsg535, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        int usRowCtr = 0;
        CINV16DI pCINV16DInputRec = null;
        CINV16DO pCINV16DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV16DInputRec = new CINV16DI();
        pCINV16DOutputRec = new CINV16DO();
        pCINV16DInputRec.setArchInputStruct(pInputMsg583.getArchInputStruct());
        
        /*
        ** Populate Input Structure for DAM
        */
        
        
        for (usRowCtr = 0;usRowCtr < pInputMsg583.getArchInputStruct().getUlPageSizeNbr();usRowCtr++) {
            if (pInputMsg583.getArchInputStruct().getCReqFuncCd() == WtcHelperConstants.REQ_FUNC_CD_ADD) {
                pInputMsg583.getROWCINV12SIG00_ARRAY().getROWCINV12SIG00(usRowCtr).setSzCdScrDataAction(WtcHelperConstants.REQ_FUNC_CD_ADD);
            }
            if (pInputMsg583.getUlIdStage() == true) {
                pInputMsg583.getROWCINV12SIG00_ARRAY().getROWCINV12SIG00(usRowCtr).setSzCdScrDataAction(WtcHelperConstants.REQ_FUNC_CD_ADD);
            }
            
            pCINV16DInputRec.setSzCdEaQuestion(pInputMsg583.getROWCINV12SIG00_ARRAY().getROWCINV12SIG00(usRowCtr).getSzCdEaQuestion());
            
            //  Continue formating CCMN43DI. The following is a check
            // for the primary employee
            
            if (pInputMsg583.getROWCINV12SIG00_ARRAY().getROWCINV12SIG00(usRowCtr).getSzCdScrDataAction() == WtcHelperConstants.REQ_FUNC_CD_UPDATE) {
                
                pCINV16DInputRec.setUlIdEmergencyAssist(pInputMsg583.getROWCINV12SIG00_ARRAY().getROWCINV12SIG00(usRowCtr).getUlIdEmergencyAssist());
            }
            else {
                
                //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
                pCINV16DInputRec.setUlIdEmergencyAssist(0);
            }
            pCINV16DInputRec.setBIndEaResponse(pInputMsg583.getROWCINV12SIG00_ARRAY().getROWCINV12SIG00(usRowCtr).getBIndEaResponse());
            pCINV16DInputRec.setUlIdEvent(pOutputMsg535.getUlIdEvent().value);
            pCINV16DInputRec.setTsLastUpdate(pInputMsg583.getROWCINV12SIG00_ARRAY().getROWCINV12SIG00(usRowCtr).getTsLastUpdate());
            pCINV16DInputRec.getArchInputStruct().setCReqFuncCd(pInputMsg583.getROWCINV12SIG00_ARRAY().getROWCINV12SIG00(usRowCtr).getSzCdScrDataAction());
            rc = cinv16dAUDdam(sqlca, pCINV16DInputRec, pCINV16DOutputRec);
            
            //  Analyze error code
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    
                    break;
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                    rc = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                    usRowCtr = pInputMsg583.getArchInputStruct().getUlPageSizeNbr();
                    
                    break;
                case WtcHelperConstants.SQL_DUPLICATE_KEY:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_CMN_UPDATE_FAILED;
                    rc = Messages.MSG_CMN_UPDATE_FAILED;
                    
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
            }
        }
        return rc;
    }

    static int CallCINV12D(CINV12SI pInputMsg584, CINV12SO * pOutputMsg536, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CINV12DI pCINV12DInputRec = null;
        CINV12DO pCINV12DOutputRec = null;
        int usRowCtr = 0;
        
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV12DInputRec = new CINV12DI();
        pCINV12DOutputRec = new CINV12DO();
        pCINV12DInputRec.setArchInputStruct(pInputMsg584.getArchInputStruct());
        
        pCINV12DInputRec.setSzCdCpsInvstDtlFamIncm(pInputMsg584.getROWCINV12SIG01().getSzCdCpsInvstDtlFamIncm());
        pCINV12DInputRec.setCdCpsOverallDisptn(pInputMsg584.getROWCINV12SIG01().getCdCpsOverallDisptn());
        pCINV12DInputRec.setDtDtCPSInvstDtlAssigned(pInputMsg584.getROWCINV12SIG01().getDtDtCPSInvstDtlAssigned());
        pCINV12DInputRec.setDtDtCPSInvstDtlBegun(pInputMsg584.getROWCINV12SIG01().getDtDtCPSInvstDtlBegun());
        pCINV12DInputRec.setDtDtCPSInvstDtlIntake(pInputMsg584.getROWCINV12SIG01().getDtDtCPSInvstDtlIntake());
        pCINV12DInputRec.setDtDtCpsInvstDtlComplt(pInputMsg584.getROWCINV12SIG01().getDtDtCpsInvstDtlComplt());
        if (pCINV12DInputRec.getDtDtCPSInvstDtlAssigned().year == 0) {
        }
        
        if (pCINV12DInputRec.getDtDtCPSInvstDtlBegun().year == 0) {
            
        }
        if (pCINV12DInputRec.getDtDtCPSInvstDtlIntake().year == 0) {
        }
        if (pCINV12DInputRec.getDtDtCpsInvstDtlComplt().year == 0) {
            
        }
        pCINV12DInputRec.setUlIdEvent(pInputMsg584.getROWCINV12SIG01().getUlIdEvent());
        pCINV12DInputRec.setUlIdStage(pInputMsg584.getROWCINV12SIG01().getUlIdStage());
        pCINV12DInputRec.setBIndCpsInvstSafetyPln(pInputMsg584.getROWCINV12SIG01().getBIndCpsInvstSafetyPln());
        pCINV12DInputRec.setCIndCpsInvstDtlRaNa(pInputMsg584.getROWCINV12SIG01().getCIndCpsInvstDtlRaNa());
        pCINV12DInputRec.setBIndCpsInvstEaConcl(INDICATOR_YES);
        
        /*
        ** All EA Eligibility questions must be answered 'Yes' for
        ** the family to be eligible for Emergency Assistance.
        */
        for (usRowCtr = 0;usRowCtr < pInputMsg584.getArchInputStruct().getUlPageSizeNbr();usRowCtr++) {
            //## END TUX/XML: Turn the XML buffer into an input message struct 
            
            
            
            if (INDICATOR_YES != pInputMsg584.getROWCINV12SIG00_ARRAY().getROWCINV12SIG00(usRowCtr).getBIndEaResponse()) {
                pCINV12DInputRec.setBIndCpsInvstEaConcl(Cint14s.INDICATOR_NO);
                // 
                // (END): CLSS68D - Retrieve contract service codes for
                // the contract, period, and version passed to the DAM.
                // 
                
                break;
            }
        }
        if (0 == strncmp(pInputMsg584.getROWCINV12SIG01().getSzCdCpsInvstDtlFamIncm() , CEAFINCM_I5, CEAFINCM_I5.length())) {
            pCINV12DInputRec.setBIndCpsInvstEaConcl(Cint14s.INDICATOR_NO);
        }
        pCINV12DInputRec.setCIndCpsInvstAbbrv(pInputMsg584.getROWCINV12SIG01().getCIndCpsInvstAbbrv());
        pCINV12DInputRec.setTsLastUpdate(pInputMsg584.getROWCINV12SIG01().getTsLastUpdate());
        pCINV12DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        
        /*
        ** Retrieve the IdSvcAuth based on the IdEvent
        */
        rc = cinv12dAUDdam(sqlca, pCINV12DInputRec, pCINV12DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                
                //  Retrieve the IdSvcAuth based on the IdEvent
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

    
}
