package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV60SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV60SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN06UO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN05UO;
import gov.georgia.dhr.dfcs.sacwis.service.person.Ccmn05u;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV53DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV53DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSVC18DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSVC18DO;
/**************************************************************************
**
** Module File:   CINV60S.src
**
** Service Name:  CINV60S - LIC INV CONCL AUD
**
** Description:   This service updates information modified on the Licensing
**                Investigation Conclusion window. It updates a row in the
**                LICENSING INVST DTL, EVENT, and STAGE tables. The service
**                also invalidates an approval if one is pending for the
**                current ID EVENT.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  4/19/95
**
** Programmer:    RAMIREAP
**
** Change History:
** Date      User      Description
** --------  --------  --------------------------------------------------
**  11/13/95  HELMKEST  SIR 1710: Included CheckStageEventStatus common
**                      function. (CCMN06U)
**
** 08/13/96  vanderm    SIR #21968 - Databse should be restored for all
**                      AUD services which return an error.  Error handling
**                      was changed from FND_SEVERITY_WARNING to
**                      FND_SEVERITY_ERROR.
**
**   1/23/03   DWW      Added following line for error handling:
**                      if (RetVal == FND_SUCESS)  { rc=FND_SUCCESS; }
**
**  05/05/03   Srini    SIR #17268. Changed the ArchInputStruct to ArchOutputStruct
**                      in the cinv60so.h and also made the corresponding modifications
**                      to the marshaling code.
**
**  05/05/2003  KRD     IMPACT - Code changes applied to support
**                      "Approver Mode" providing supervisors the ability to
**                      modify data without invalidating the pending
**                      approval.
**
**  08/05/03   Srini    SIR 17827 - IMPACT: Made the service transactionaware.
**
**  03/30/04   douglacs SIR 22756 - added fields to LICENSING_INVST_DTL
**
**  04/18/05   brauchs  SIR 23458 - If statement had been accidentally commented out - reinstated the end of comment (line 960).
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cinv60s {
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final String EVENT_STATUS_PROGRESS = "PROC";
    public static final String EVENT_STATUS_COMPLETE = "COMP";
    public static final String EVENT_STATUS_PENDING = "PEND";
    
    /**************************************************************************
    ** Global variables
    ***************************************************************************/
    /*
    ** SIR 2426 - Define Null String for use in comparison
    */
    public static final String NULL_STRING = "";
    public static final String OTHER = "XX";
    public static final String COR_ACT = "20";
    static int transactionflag = - 1;
    CINV60SO CINV60S(CINV60SI cinv60si) {
        CINV60SO cinv60so = new CINV60SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        //## END TUX/XML: Turn the XML buffer into an input message struct 
        
        
        transactionflag = - 1;
        boolean bTransactionStarted = false;
        transactionflag = tpgetlev();
        if (transactionflag == - 1) {
            userlog("ERROR: tpgetlev failed in CINV60S (%s)\n", tpstrerror(tperrno));
            pServiceStatus.severity = FND_SEVERITY_ERROR;
            pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPBEGIN_FAILED;
            rc = Arcxmlerrors.ARC_ERR_TUX_TPBEGIN_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        }
        else if (transactionflag == 1) {
            userlog("START: TRANSACTION ALREADY IN PROGRESS in CINV60S\n");
        }
        else if (transactionflag == 0) {
            userlog("TRANSACTION IS STARTED in CINV60S \n");
            bTransactionStarted = true;
        }
        
        /*
        ** Declare FOUNDATION variables
        */
        //##    #ifdef  _CINV60SI
        //##            _CINV60SI     *pInputMsg = ((_CINV60SI *) (pfpb->pTXN));
        //##    #endif
        
        //##    #ifdef  _CINV60SO
        //##            _CINV60SO    *pOutputMsg = ((_CINV60SO *) (pRTAF->pReply_txn_msg));
        //##            _APPL_STATUS *pServiceStatus = (_APPL_STATUS *) &(((_MSG_PARM_BLOCK *)
        //##                                     (pfpb->pTXN_PB))->appl_status);
        //##            _TRANSLATION *pOutputMsgTransMap = (_TRANSLATION *)
        //##                  &(((_MSG_PARM_BLOCK *) pRTAF->pReply_txn_pb)->translation);
        //##    long         *pOutputMsgSize = (long *) &(pRTAF->Reply_txn_msg_len);
        //##    #endif
        //##
        //##
        //##   _MSG_PARM_BLOCK *pMsgPB = ( _MSG_PARM_BLOCK * ) pfpb->pTXN_PB;
        //##   _MSG_PARM_BLOCK *pReturnPB = ( _MSG_PARM_BLOCK * ) pRTAF->pReply_txn_pb;
        //## END: TUX Service Change
        
        /*
        ** Declare local variables
        */
        
        /* SIR 1710: Variables used in CheckStageEventStatus common function */
        int RetVal = SUCCESS;
        CCMN06UI pCCMN06UInputRec = null;/* Check Stage/Event common Function */
        
        CCMN06UO pCCMN06UOutputRec = null;
        rc = ARC_PRFServiceStartTime_TUX(cinv60si.getArchInputStruct());
        
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
        pCCMN06UInputRec.setArchInputStruct(cinv60si.getArchInputStruct());
        pCCMN06UInputRec.getArchInputStruct().setCReqFuncCd(cinv60si.getArchInputStruct().getCReqFuncCd());
        
        pCCMN06UInputRec.setUlIdStage(cinv60si.getROWCINV56SOG02().getUlIdStage());
        pCCMN06UInputRec.setSzCdTask(cinv60si.getROWCINV56SOG01().getSzCdTask());
        
        
        /*
        ** Call CINV39D
        */
        rc = Ccmn06u.CheckStageEventStatus(pCCMN06UInputRec, pCCMN06UOutputRec, pServiceStatus);
        
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
                
                //  removed the SQL_NOT_FOUND case from the switch statement after
                // dam call. SIR 2952
                
                break;
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
            
            if (false == cinv60si.getArchInputStruct().getUlSysNbrReserved1()) {
                
                if (!(strncmp(cinv60si.getROWCINV56SOG01().getSzCdEventStatus() , EVENT_STATUS_PENDING, EVENT_STATUS_PENDING.length()) != 0)) {
                    
                    //set rc value to FND_FAIL
                    rc = Cinv16s.CallCCMN05U(cinv60si, cinv60so, pServiceStatus);
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                }
                rc = Cinv16s.CallCCMN01U(cinv60si, cinv60so, pServiceStatus);
            }
            
            switch (rc) {
                case WtcHelperConstants.ARC_SUCCESS:
                    rc = CallCINV53D(cinv60si, cinv60so, pServiceStatus);
                    
                    
                    //  Analyze return code
                    switch (rc) {
                        case WtcHelperConstants.ARC_SUCCESS:
                            
                            
                            //  Call CSEC62D
                            rc = Cinv16s.CallCSVC18D(cinv60si, cinv60so, pServiceStatus);
                            
                            //  Analyze return code
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
                            
                            // 
                            // END CAUD15D
                            // 
                            
                            //  SIR #10053 - Move the end else here.  It was previously
                            // after the other cases, despite the fact that the else
                            // is inside the Case SQL_SUCCESS
                            
                            
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
        
        /*
        ** Load translation map with service name and version
        */
        
        /*
        ** Stop performance timer for service
        */
        ARC_PRFServiceStopTime_TUX(cinv60si.getArchInputStruct() , cinv60so.getArchOutputStruct());
        
        if (RetVal == SUCCESS) {
            
            //set rc value to FND_FAIL
            rc = SUCCESS;
        }
        
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError_Transact(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber() , transactionflag);
        }
        else if (bTransactionStarted) {
            
            if (tpcommit(0) == - 1) {
                userlog("ERROR: tpcommit failed in service CINV60S (%s)\n", tpstrerror(tperrno));
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                
                
                //  Set rc to ARC_SUCCESS
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        else {
            userlog("END: TRANSACTION ALREADY IN PROGRESS CINV60S \n");
        }
        return cinv60so;
    }

    
    static int CallCCMN05U(CINV60SI pInputMsg789, CINV60SO * pOutputMsg734, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
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
        pInvdInput.setArchInputStruct(pInputMsg789.getArchInputStruct());
        
        pInvdInput.setUlIdEvent(pInputMsg789.getROWCINV56SOG01().getUlIdEvent());
        
        /*
        ** Call CSES42D
        */
        rc = Ccmn05u.InvalidateAprvl(pInvdInput, pInvdOutput, pServiceStatus);
        return rc;
    }

    static int CallCCMN01U(CINV60SI pInputMsg790, CINV60SO * pOutputMsg735, Arcxmlerrors.TUX_DECL_STATUSPARMS) /*
    ** IMPACT END
    */
    {
        //## END TUX/XML: Declare XML variables
        
        int rc = 0;
        /*
        ** Declare local variables
        */
        CCMN01UI pCCMN01UInputRec = null;
        CCMN01UO pCCMN01UOutputRec = null;
        
        /*
        ** Reserve memory for PostEvent Function structures
        */
        pCCMN01UInputRec = new CCMN01UI();
        
        pCCMN01UOutputRec = new CCMN01UO();
        pCCMN01UInputRec.setArchInputStruct(pInputMsg790.getArchInputStruct());
        if ((pInputMsg790.getROWCINV56SOG02().getDtDtLicngInvstAssigned().day != - 1) && (pInputMsg790.getROWCINV56SOG02().getDtDtLicngInvstAssigned().month != - 1) && (pInputMsg790.getROWCINV56SOG02().getDtDtLicngInvstAssigned().year != - 1) && (pInputMsg790.getROWCINV56SOG02().getDtDtLicngInvstDtlBegun().day != - 1) && (pInputMsg790.getROWCINV56SOG02().getDtDtLicngInvstDtlBegun().month != - 1) && (pInputMsg790.getROWCINV56SOG02().getDtDtLicngInvstDtlBegun().year != - 1) && (pInputMsg790.getROWCINV56SOG02().getDtDtLicngInvstComplt().day != - 1) && (pInputMsg790.getROWCINV56SOG02().getDtDtLicngInvstComplt().month != - 1) && (pInputMsg790.getROWCINV56SOG02().getDtDtLicngInvstComplt().year != - 1) && (pInputMsg790.getROWCINV56SOG02().getDtDtLicngInvstIntake().day != - 1) && (pInputMsg790.getROWCINV56SOG02().getDtDtLicngInvstIntake().month != - 1) && (pInputMsg790.getROWCINV56SOG02().getDtDtLicngInvstIntake().year != - 1) && 0 != pInputMsg790.getROWCINV56SOG02().getSzCdLicngInvstOvrallDisp().compareTo(NULL_STRING) && 0 != pInputMsg790.getROWCINV56SOG03().getSzCdStageReasonClosed().compareTo(NULL_STRING)) {
            
            if (!(pInputMsg790.getROWCINV56SOG03().getSzCdStageReasonClosed().compareTo(COR_ACT) != 0) && 0 != pInputMsg790.getROWCINV56SOG02().getSzCdLicngInvstCoractn().compareTo(NULL_STRING)) {
                
                //  Initialize Service Status Fields
                
                //   Perform Main Processing
                
                if (!(pInputMsg790.getROWCINV56SOG02().getSzCdLicngInvstCoractn().compareTo(OTHER) != 0) && 0 != pInputMsg790.getROWCINV56SOG02().getTxtLicngInvstNoncomp().compareTo(NULL_STRING)) {
                    
                    pInputMsg790.getROWCINV56SOG01().setSzCdEventStatus(EVENT_STATUS_COMPLETE);
                }
                if (0 != pInputMsg790.getROWCINV56SOG02().getSzCdLicngInvstCoractn().compareTo(OTHER)) {
                    pInputMsg790.getROWCINV56SOG01().setSzCdEventStatus(EVENT_STATUS_COMPLETE);
                }
            }
            //  If the Recommended Action != "Corrective Action"
            else if (0 != pInputMsg790.getROWCINV56SOG03().getSzCdStageReasonClosed().compareTo(COR_ACT)) {
                pInputMsg790.getROWCINV56SOG01().setSzCdEventStatus(EVENT_STATUS_COMPLETE);
            }
        }
        /*
        ** Set Event Status to "In Progress" if all required window fields
        ** not filled
        */
        else {
            pInputMsg790.getROWCINV56SOG01().setSzCdEventStatus(EVENT_STATUS_PROGRESS);
        }
        pCCMN01UInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdEvent(pInputMsg790.getROWCINV56SOG01().getUlIdEvent());
        pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdStage(pInputMsg790.getROWCINV56SOG01().getUlIdStage());
        pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdPerson(pInputMsg790.getROWCINV56SOG01().getUlIdPerson());
        pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdTask(pInputMsg790.getROWCINV56SOG01().getSzCdTask());
        pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdEventType(pInputMsg790.getROWCINV56SOG01().getSzCdEventType());
        pCCMN01UInputRec.getROWCCMN01UIG00().setDtDtEventOccurred(pInputMsg790.getROWCINV56SOG01().getDtDtEventOccurred());
        pCCMN01UInputRec.getROWCCMN01UIG00().setSzTxtEventDescr(pInputMsg790.getROWCINV56SOG01().getSzTxtEventDescr());
        pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdEventStatus(pInputMsg790.getROWCINV56SOG01().getSzCdEventStatus());
        pCCMN01UInputRec.getROWCCMN01UIG00().setTsLastUpdate(pInputMsg790.getROWCINV56SOG01().getTsLastUpdate());
        /*
        ** Call CLSS68D:
        ** SELECT * FROM CONTRACT_COUNTY C WHERE C.ID_CONTRACT =
        ** AND C.NBR_CNCNTY_PERIOD  =        AND C.NBR_CNCNTY_VERSION =
        */
        rc = Ccmn01u.PostEvent(pCCMN01UInputRec, pCCMN01UOutputRec, pServiceStatus);
        
        /*
        ** Analyze return code
        */
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
        return rc;
    }

    static int CallCINV53D(CINV60SI pInputMsg791, CINV60SO * pOutputMsg736, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        CINV53DI pCINV53DInputRec = null;
        CINV53DO pCINV53DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV53DInputRec = new CINV53DI();
        
        pCINV53DOutputRec = new CINV53DO();
        pCINV53DInputRec.setArchInputStruct(pInputMsg791.getArchInputStruct());
        pCINV53DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        pCINV53DInputRec.setDtDtLicngInvstIntake(pInputMsg791.getROWCINV56SOG02().getDtDtLicngInvstIntake());
        pCINV53DInputRec.setDtDtLicngInvstDtlBegun(pInputMsg791.getROWCINV56SOG02().getDtDtLicngInvstDtlBegun());
        pCINV53DInputRec.setDtDtLicngInvstComplt(pInputMsg791.getROWCINV56SOG02().getDtDtLicngInvstComplt());
        pCINV53DInputRec.setDtDtLicngInvstAssigned(pInputMsg791.getROWCINV56SOG02().getDtDtLicngInvstAssigned());
        pCINV53DInputRec.setUlIdStage(pInputMsg791.getROWCINV56SOG02().getUlIdStage());
        pCINV53DInputRec.setSzCdLicngInvstOvrallDisp(pInputMsg791.getROWCINV56SOG02().getSzCdLicngInvstOvrallDisp());
        pCINV53DInputRec.setTxtLicngInvstNoncomp(pInputMsg791.getROWCINV56SOG02().getTxtLicngInvstNoncomp());
        pCINV53DInputRec.setSzCdLicngInvstCoractn(pInputMsg791.getROWCINV56SOG02().getSzCdLicngInvstCoractn());
        pCINV53DInputRec.setTsLastUpdate(pInputMsg791.getROWCINV56SOG02().getTsLastUpdate());
        pCINV53DInputRec.setUlIdEvent(pInputMsg791.getROWCINV56SOG02().getUlIdEvent());
        pCINV53DInputRec.setUlIdResource(pInputMsg791.getROWCINV56SOG02().getUlIdResource());
        pCINV53DInputRec.setSzNmResource(pInputMsg791.getROWCINV56SOG02().getSzNmResource());
        pCINV53DInputRec.setLNbrRsrcFacilAcclaim(pInputMsg791.getROWCINV56SOG02().getLNbrRsrcFacilAcclaim());
        pCINV53DInputRec.setSzCdRsrcFacilType(pInputMsg791.getROWCINV56SOG02().getSzCdRsrcFacilType());
        pCINV53DInputRec.setSzTxtRsrcComments(pInputMsg791.getROWCINV56SOG02().getSzTxtRsrcComments());
        pCINV53DInputRec.setLNbrFacilPhoneNumber(pInputMsg791.getROWCINV56SOG02().getLNbrFacilPhoneNumber());
        pCINV53DInputRec.setLNbrFacilPhoneExtension(pInputMsg791.getROWCINV56SOG02().getLNbrFacilPhoneExtension());
        pCINV53DInputRec.setSzAddrRsrcAddrAttn(pInputMsg791.getROWCINV56SOG02().getSzAddrRsrcAddrAttn());
        
        pCINV53DInputRec.setSzAddrRsrcAddrStLn1(pInputMsg791.getROWCINV56SOG02().getSzAddrRsrcAddrStLn1());
        pCINV53DInputRec.setSzAddrRsrcAddrStLn2(pInputMsg791.getROWCINV56SOG02().getSzAddrRsrcAddrStLn2());
        pCINV53DInputRec.setSzAddrRsrcAddrCity(pInputMsg791.getROWCINV56SOG02().getSzAddrRsrcAddrCity());
        pCINV53DInputRec.setSzAddrRsrcAddrCounty(pInputMsg791.getROWCINV56SOG02().getSzAddrRsrcAddrCounty());
        pCINV53DInputRec.setSzAddrRsrcAddrState(pInputMsg791.getROWCINV56SOG02().getSzAddrRsrcAddrState());
        pCINV53DInputRec.setSzAddrRsrcAddrZip(pInputMsg791.getROWCINV56SOG02().getSzAddrRsrcAddrZip());
        
        pCINV53DInputRec.setUlIdAffilResource(pInputMsg791.getROWCINV56SOG02().getUlIdAffilResource());
        pCINV53DInputRec.setSzNmAffilResource(pInputMsg791.getROWCINV56SOG02().getSzNmAffilResource());
        pCINV53DInputRec.setSzTxtAffilComments(pInputMsg791.getROWCINV56SOG02().getSzTxtAffilComments());
        pCINV53DInputRec.setLNbrAffilPhoneNumber(pInputMsg791.getROWCINV56SOG02().getLNbrAffilPhoneNumber());
        pCINV53DInputRec.setLNbrAffilPhoneExtension(pInputMsg791.getROWCINV56SOG02().getLNbrAffilPhoneExtension());
        pCINV53DInputRec.setSzAffilAddrAttn(pInputMsg791.getROWCINV56SOG02().getSzAffilAddrAttn());
        pCINV53DInputRec.setSzAffilAddrStLn1(pInputMsg791.getROWCINV56SOG02().getSzAffilAddrStLn1());
        pCINV53DInputRec.setSzAffilAddrStLn2(pInputMsg791.getROWCINV56SOG02().getSzAffilAddrStLn2());
        pCINV53DInputRec.setSzAffilAddrCity(pInputMsg791.getROWCINV56SOG02().getSzAffilAddrCity());
        pCINV53DInputRec.setSzAffilAddrCounty(pInputMsg791.getROWCINV56SOG02().getSzAffilAddrCounty());
        pCINV53DInputRec.setSzAffilAddrState(pInputMsg791.getROWCINV56SOG02().getSzAffilAddrState());
        pCINV53DInputRec.setSzAffilAddrZip(pInputMsg791.getROWCINV56SOG02().getSzAffilAddrZip());
        pCINV53DInputRec.setUlIdClassFclty(pInputMsg791.getROWCINV56SOG02().getUlIdClassFclty());
        pCINV53DInputRec.setUlIdClassAffilFclty(pInputMsg791.getROWCINV56SOG02().getUlIdClassAffilFclty());
        pCINV53DInputRec.setLNbrAffilAcclaim(pInputMsg791.getROWCINV56SOG02().getLNbrAffilAcclaim());
        pCINV53DInputRec.setLNbrAgency(pInputMsg791.getROWCINV56SOG02().getLNbrAgency());
        pCINV53DInputRec.setLNbrBranch(pInputMsg791.getROWCINV56SOG02().getLNbrBranch());
        pCINV53DInputRec.setLNbrAffilAgency(pInputMsg791.getROWCINV56SOG02().getLNbrAffilAgency());
        pCINV53DInputRec.setLNbrAffilBranch(pInputMsg791.getROWCINV56SOG02().getLNbrAffilBranch());
        pCINV53DInputRec.setSzCdAffilFacilType(pInputMsg791.getROWCINV56SOG02().getSzCdAffilFacilType());
        
        pCINV53DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        rc = cinv53dAUDdam(sqlca, pCINV53DInputRec, pCINV53DOutputRec);
        
        
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
                //  Call CAUD17D.  The Contract Service AUD performs a full row
                // insert to the Contract Service table.
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

    static int CallCSVC18D(CINV60SI pInputMsg792, CINV60SO * pOutputMsg737, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
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
        pCSVC18DInputRec.setArchInputStruct(pInputMsg792.getArchInputStruct());
        pCSVC18DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        pCSVC18DInputRec.setUlIdStage(pInputMsg792.getROWCINV56SOG03().getUlIdStage());
        pCSVC18DInputRec.setTmSysTmStageClose(pInputMsg792.getROWCINV56SOG03().getTmSysTmStageClose());
        pCSVC18DInputRec.setTmSysTmStageStart(pInputMsg792.getROWCINV56SOG03().getTmSysTmStageStart());
        pCSVC18DInputRec.setUlIdUnit(pInputMsg792.getROWCINV56SOG03().getUlIdUnit());
        pCSVC18DInputRec.setBIndStageClose(pInputMsg792.getROWCINV56SOG03().getBIndStageClose());
        pCSVC18DInputRec.setSzNmStage(pInputMsg792.getROWCINV56SOG03().getSzNmStage());
        pCSVC18DInputRec.setSzCdStage(pInputMsg792.getROWCINV56SOG03().getSzCdStage());
        pCSVC18DInputRec.setSzCdStageClassification(pInputMsg792.getROWCINV56SOG03().getSzCdStageClassification());
        pCSVC18DInputRec.setSzCdStageCnty(pInputMsg792.getROWCINV56SOG03().getSzCdStageCnty());
        pCSVC18DInputRec.setSzCdStageCurrPriority(pInputMsg792.getROWCINV56SOG03().getSzCdStageCurrPriority());
        pCSVC18DInputRec.setSzCdStageInitialPriority(pInputMsg792.getROWCINV56SOG03().getSzCdStageInitialPriority());
        pCSVC18DInputRec.setSzCdStageProgram(pInputMsg792.getROWCINV56SOG03().getSzCdStageProgram());
        pCSVC18DInputRec.setSzCdStageReasonClosed(pInputMsg792.getROWCINV56SOG03().getSzCdStageReasonClosed());
        pCSVC18DInputRec.setDtDtStageClose(pInputMsg792.getROWCINV56SOG03().getDtDtStageClose());
        pCSVC18DInputRec.setDtDtStageStart(pInputMsg792.getROWCINV56SOG03().getDtDtStageStart());
        pCSVC18DInputRec.setUlIdCase(pInputMsg792.getROWCINV56SOG03().getUlIdCase());
        pCSVC18DInputRec.setUlIdSituation(pInputMsg792.getROWCINV56SOG03().getUlIdSituation());
        pCSVC18DInputRec.setSzTxtStageClosureCmnts(pInputMsg792.getROWCINV56SOG03().getSzTxtStageClosureCmnts());
        pCSVC18DInputRec.setSzTxtStagePriorityCmnts(pInputMsg792.getROWCINV56SOG03().getSzTxtStagePriorityCmnts());
        pCSVC18DInputRec.setSzCdStageRegion(pInputMsg792.getROWCINV56SOG03().getSzCdStageRegion());
        pCSVC18DInputRec.setSzCdStageRsnPriorityChgd(pInputMsg792.getROWCINV56SOG03().getSzCdStageRsnPriorityChgd());
        pCSVC18DInputRec.setSzCdStageType(pInputMsg792.getROWCINV56SOG03().getSzCdStageType());
        pCSVC18DInputRec.setTmSysTmStageStart(pInputMsg792.getROWCINV56SOG03().getTmSysTmStageStart());
        pCSVC18DInputRec.setTmSysTmStageClose(pInputMsg792.getROWCINV56SOG03().getTmSysTmStageClose());
        pCSVC18DInputRec.setTsLastUpdate(pInputMsg792.getROWCINV56SOG03().getTsLastUpdate());
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
