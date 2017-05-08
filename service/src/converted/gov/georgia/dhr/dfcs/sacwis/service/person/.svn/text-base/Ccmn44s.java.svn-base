package gov.georgia.dhr.dfcs.sacwis.service.person;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN44SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN44SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN06UO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNA8DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNA8DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNA9DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNA9DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD99DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD99DO;
/**************************************************************************
**
** Module File:   CCMN44S.src
**
** Service Name:  CCMN44S
**
** Description:   This is the AUD service for the Address List/Detail window.
**                It includes the following Data Access Modules:
**
**                      CCMNA8D
**                      CCMNA9D
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  24 JAN 95
**
** Programmer:    WHW
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  4/10/95   WEALANBC  Made some changes for technical review.  Implemented
**                      some new additions to the service shell.
**  1/17/96   GUARRICR  SIR#2426  Added CheckStageEventStatus common
**                      function.
**  1/24/96   YANTISTK  SIR#2109  Added new DAM call to CAUD99D to update the MEDICAID_
**                      UPDATE table upon a save when the address type is
**                      Medicaid.
**  03/12/97    KRD     SIR 10348 - To ensure that the timestamps on the
**                      start and end dates for addresses are set properly,
**                      we need to process the changes in reverse order.
**                      Required changes to the loop processing in
**                      CallCCMNA9D().
**
**   1/23/03   DWW      Added following line for error handling:
**                      if (RetVal == FND_SUCESS)  { rc=FND_SUCCESS; } 
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Ccmn44s {
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final char LB_NO_ACTION = ' ';
    
    /*SIR#2109*/
    public static final String MEDICAID_ADDRESS_CODE = "MD";
    public static final String MED_UPDATE_TYPE = "MED";
    public static final String MED_UPDATE_TRANS_TYPE = "SUS";
    CCMN44SO CCMN44S(CCMN44SI ccmn44si) {
        CCMN44SO ccmn44so = new CCMN44SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        int RetVal = SUCCESS;/* SIR#2426 */
        CCMN06UI pCCMN06UInputRec = null;/* Check Stage/Event common Function */
        
        /*
        ** Declare FOUNDATION variables
        */
        //##    #ifdef  _CINV16SI
        //##            _CINV16SI     *pInputMsg = ((_CINV16SI *) (pfpb->pTXN));
        //##    #endif
        //##
        //##    #ifdef  _CINV16SO
        //##            _CINV16SO    *pOutputMsg = ((_CINV16SO *) (pRTAF->pReply_txn_msg));
        //##            _APPL_STATUS *pServiceStatus = (_APPL_STATUS *) &(((_MSG_PARM_BLOCK *)
        //##                                     (pfpb->pTXN_PB))->appl_status);
        //##            _TRANSLATION *pOutputMsgTransMap = (_TRANSLATION *)
        //##                  &(((_MSG_PARM_BLOCK *) pRTAF->pReply_txn_pb)->translation);
        //##    long         *pOutputMsgSize = (long *) &(pRTAF->Reply_txn_msg_len);
        //##    #endif
        
        
        //##   _MSG_PARM_BLOCK *pMsgPB = ( _MSG_PARM_BLOCK * ) pfpb->pTXN_PB;
        //##   _MSG_PARM_BLOCK *pReturnPB = ( _MSG_PARM_BLOCK * ) pRTAF->pReply_txn_pb;
        //## END: TUX Service Change
        
        /*
        ** Declare local variables
        */
        
        CCMN06UO pCCMN06UOutputRec = null;
        int counter = 0;
        rc = ARC_PRFServiceStartTime_TUX(ccmn44si.getArchInputStruct());
        if (ccmn44si.getUlIdStage() != 0) {
            //  Allocate memory for Common Function Input and Output Structures
            pCCMN06UInputRec = new CCMN06UI();
            
            pCCMN06UOutputRec = new CCMN06UO();
            pCCMN06UInputRec.setArchInputStruct(ccmn44si.getArchInputStruct());
            pCCMN06UInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
            pCCMN06UInputRec.setUlIdStage(ccmn44si.getUlIdStage());
            pCCMN06UInputRec.setSzCdTask(ccmn44si.getSzCdTask());
            rc = Ccmn06u.CheckStageEventStatus(pCCMN06UInputRec, pCCMN06UOutputRec, pServiceStatus);
            
            
            
            //  Analyze return code
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
        }
        
        if (SUCCESS == RetVal) {
            
            //  Call DAM
            rc = Cint02s.CallCCMNA8D(ccmn44si, ccmn44so, pServiceStatus);
            
            //  Analyze return code
            switch (rc) {
                    
                case WtcHelperConstants.ARC_SUCCESS:
                    break;
                    
                case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            //  Do nothing, the output message just returns success or failure
            rc = Cint02s.CallCCMNA9D(ccmn44si, ccmn44so, pServiceStatus);
            
            //  Analyze return code
            switch (rc) {
                    
                case WtcHelperConstants.ARC_SUCCESS:
                    break;
                    
                case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    break;
                default :
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            
            //  SIR#2109 Call CAUD99D to Add or Update the MEDICAID UPDATE
            // table if the address type is 'Medicaid' (EMD) and if the
            // DataAction code is ADD or if the DataAction code is UPDATE and
            // the Medicaid Update flag is TRUE.
            for (counter = 0;counter < ccmn44si.getArchInputStruct().getUlPageSizeNbr();counter++) {
                
                if (!(ccmn44si.getROWCCMN44SIG00_ARRAY().getROWCCMN44SIG00(counter).getSzCdPersAddrLinkType().compareTo(MEDICAID_ADDRESS_CODE) != 0) && FND_YES == ccmn44si.getROWCCMN44SIG00_ARRAY().getROWCCMN44SIG00(counter).getBSysIndAddrMedUpdate()) {
                    //  This employee does not have any other "IN" assignments
                    rc = Cinv05s.CallCAUD99D(ccmn44si, ccmn44so, counter, pServiceStatus);
                    switch (rc) {
                            
                        case WtcHelperConstants.ARC_SUCCESS:
                            break;
                            
                        case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                            break;
                        default :
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    }
                }
            }
        }
        
        
        
        /* Setup for service function exit */
        
        
        ARC_PRFServiceStopTime_TUX(ccmn44si.getArchInputStruct() , ccmn44so.getArchOutputStruct());
        
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
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        return ccmn44so;
    }

    static int PrepServiceExit(_SERVICE_DATA * pfpb, _RTAF * pRTAF, _ABHI * pABHI) {
        _MSG_PARM_BLOCK * pMsgPB = (_MSG_PARM_BLOCK) pfpb.pTXN_PB;
        _MSG_PARM_BLOCK * pReturnPB = (_MSG_PARM_BLOCK) pRTAF.pReply_txn_pb;
        int rc = 0;/* Return code */
        pOutputMsgTransMap.map_name = "CCMN44SO";
        pOutputMsgTransMap.map_version = "01";
        
        /*
        ** Stop performance timer for service
        */
        
        ARC_PRFServiceStopTime_TUX(Csys08s.pInputMsg.getArchInputStruct() , Csys08s.pOutputMsg.getArchOutputStruct());
        return SUCCESS;
    }

    static int CallCCMNA8D(CCMN44SI pInputMsg340, CCMN44SO * pOutputMsg310, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int i167 = 0;
        int rc = 0;
        CCMNA8DI pCCMNA8DInputRec = null;
        CCMNA8DO pCCMNA8DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        
        pCCMNA8DInputRec = new CCMNA8DI();
        
        pCCMNA8DOutputRec = new CCMNA8DO();
        pCCMNA8DInputRec.setArchInputStruct(pInputMsg340.getArchInputStruct());
        
        /*
        ** Logic to be performed for every row in the list box.
        */
        
        for (i167 = 0;i167 < pInputMsg340.getArchInputStruct().getUlPageSizeNbr();i167++) {
            pCCMNA8DInputRec.setSzAddrPersAddrStLn1(pInputMsg340.getROWCCMN44SIG00_ARRAY().getROWCCMN44SIG00(i167).getSzAddrPersAddrStLn1());
            pCCMNA8DInputRec.setSzAddrPersAddrStLn2(pInputMsg340.getROWCCMN44SIG00_ARRAY().getROWCCMN44SIG00(i167).getSzAddrPersAddrStLn2());
            pCCMNA8DInputRec.setSzAddrCity(pInputMsg340.getROWCCMN44SIG00_ARRAY().getROWCCMN44SIG00(i167).getSzAddrCity());
            pCCMNA8DInputRec.setLAddrZip(pInputMsg340.getROWCCMN44SIG00_ARRAY().getROWCCMN44SIG00(i167).getLAddrZip());
            pCCMNA8DInputRec.setSzCdAddrCounty(pInputMsg340.getROWCCMN44SIG00_ARRAY().getROWCCMN44SIG00(i167).getSzCdAddrCounty());
            pCCMNA8DInputRec.setSzAddrPersAddrAttn(pInputMsg340.getROWCCMN44SIG00_ARRAY().getROWCCMN44SIG00(i167).getSzAddrPersAddrAttn());
            pCCMNA8DInputRec.setSzCdAddrState(pInputMsg340.getROWCCMN44SIG00_ARRAY().getROWCCMN44SIG00(i167).getSzCdAddrState());
            pCCMNA8DInputRec.setLdIdAddress(pInputMsg340.getROWCCMN44SIG00_ARRAY().getROWCCMN44SIG00(i167).getLdIdAddress());
            pCCMNA8DInputRec.tsLastUpdate = pInputMsg340.getROWCCMN44SIG00_ARRAY().getROWCCMN44SIG00(i167).getTsLastUpdate();
            pCCMNA8DInputRec.getArchInputStruct().setCReqFuncCd(pInputMsg340.getROWCCMN44SIG00_ARRAY().getROWCCMN44SIG00(i167).getSzCdScrDataAction());
            if ((WtcHelperConstants.REQ_FUNC_CD_ADD == pCCMNA8DInputRec.getArchInputStruct().getCReqFuncCd()) || (ServiceConstants.REQ_FUNC_CD_UPDATE == pCCMNA8DInputRec.getArchInputStruct().getCReqFuncCd())) {
                
                // SIR 21891 - missing versioning
                //  Run-time Versioning
                
                //  Check buffer size 
                // Process error message and return to client
                // Initialize output message and length
                
                // Initialize service status fields
                // 
                // SIR 1993:
                // Get System Date and Time for return to Client, since the Date 
                // should not be retrieved on the client side.
                // 
                
                rc = ccmna8dAUDdam(sqlca, pCCMNA8DInputRec, pCCMNA8DOutputRec);
            }
            else if (0 == pCCMNA8DInputRec.getArchInputStruct().getCReqFuncCd()) {
                i167 = CCMN44SI._CCMN44SI__ROWCCMN44SIG00_SIZE;
            }
            else {
                return Messages.ARC_ERR_BAD_FUNC_CD;
            }
            if ((WtcHelperConstants.REQ_FUNC_CD_ADD == pCCMNA8DInputRec.getArchInputStruct().getCReqFuncCd()) && (0 == rc)) {
                pInputMsg340.getROWCCMN44SIG00_ARRAY().getROWCCMN44SIG00(i167).setLdIdAddress(pCCMNA8DOutputRec.getLdIdAddress());
            }
            // 
            // (END): Retrieve DAM: cmsc09d      Nbr of other SUBCARE stages in case
            // 
            
            //  SIR 3577
            // If NbrStagesOpen is 0 or 1 then open the FRE stage
            if (rc != 0) {
                
                //  Analyze return code
                switch (rc) {
                    case NO_DATA_FOUND:
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                        pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                        
                        // Call DAMs to retrieve data
                        rc = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                        break;
                    case WtcHelperConstants.SQL_DUPLICATE_KEY:
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                        pServiceStatus.explan_code = Messages.MSG_CMN_UPDATE_FAILED;
                        rc = Messages.MSG_CMN_UPDATE_FAILED;
                        break;
                    case Arcutls.ARC_UTL_GENERAL_FAILURE:
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                }
            }
            
            else {
            }
        }
        return rc;
    }

    static int CallCCMNA9D(CCMN44SI pInputMsg341, CCMN44SO * pOutputMsg311, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int i168 = 0;
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        CCMNA9DI pCCMNA9DInputRec = null;
        CCMNA9DO pCCMNA9DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        
        pCCMNA9DInputRec = new CCMNA9DI();
        
        pCCMNA9DOutputRec = new CCMNA9DO();
        pCCMNA9DInputRec.setArchInputStruct(pInputMsg341.getArchInputStruct());
        
        /*
        ** Logic to be performed for every row in the list box.
        **
        ** SIR 10348 - CCMNA9D keeps track of the timestamps on the Start and End
        ** dates.  The primary addresses in the input message are sorted in
        ** reverse-modified order (i.e., the most recent primary name added or
        ** modified will be at beginning of the input message).  To ensure that
        ** the addresses receive the timestamps in the proper order, we need to
        ** process the list in reverse order.  This requires a change to the
        ** for loop from:
        **     for (i = 0; i < pInputMsg->ArchInputStruct.ulPageSizeNbr; i++)
        ** to:
        **     for (i = pInputMsg->ArchInputStruct.ulPageSizeNbr - 1; i>=0 ;i--)
        */
        for (i168 = pInputMsg341.getArchInputStruct().getUlPageSizeNbr() - 1;i168 >= 0;i168--) {
            pCCMNA9DInputRec.setSzCdPersAddrLinkType(pInputMsg341.getROWCCMN44SIG00_ARRAY().getROWCCMN44SIG00(i168).getSzCdPersAddrLinkType());
            pCCMNA9DInputRec.setDtDtPersAddrLinkEnd(pInputMsg341.getROWCCMN44SIG00_ARRAY().getROWCCMN44SIG00(i168).getDtDtPersAddrLinkEnd());
            pCCMNA9DInputRec.setDtDtPersAddrLinkStart(pInputMsg341.getROWCCMN44SIG00_ARRAY().getROWCCMN44SIG00(i168).getDtDtPersAddrLinkStart());
            pCCMNA9DInputRec.setUlIdPerson(pInputMsg341.getUlIdPerson());
            pCCMNA9DInputRec.setLdIdAddress(pInputMsg341.getROWCCMN44SIG00_ARRAY().getROWCCMN44SIG00(i168).getLdIdAddress());
            pCCMNA9DInputRec.setUlIdAddrPersonLink(pInputMsg341.getROWCCMN44SIG00_ARRAY().getROWCCMN44SIG00(i168).getUlIdAddrPersonLink());
            pCCMNA9DInputRec.setBIndPersAddrLinkInvalid(pInputMsg341.getROWCCMN44SIG00_ARRAY().getROWCCMN44SIG00(i168).getBIndPersAddrLinkInvalid());
            pCCMNA9DInputRec.setBIndPersAddrLinkPrimary(pInputMsg341.getROWCCMN44SIG00_ARRAY().getROWCCMN44SIG00(i168).getBIndPersAddrLinkPrimary());
            pCCMNA9DInputRec.setSzTxtPersAddrCmnts(pInputMsg341.getROWCCMN44SIG00_ARRAY().getROWCCMN44SIG00(i168).getSzTxtPersAddrCmnts());
            pCCMNA9DInputRec.tsSysTsLastUpdate2 = pInputMsg341.getROWCCMN44SIG00_ARRAY().getROWCCMN44SIG00(i168).getTsSysTsLastUpdate2();
            pCCMNA9DInputRec.getArchInputStruct().setCReqFuncCd(pInputMsg341.getROWCCMN44SIG00_ARRAY().getROWCCMN44SIG00(i168).getSzCdScrDataAction());
            rc = ccmna9dAUDdam(sqlca, pCCMNA9DInputRec, pCCMNA9DOutputRec);
            
            //  Analyze error code
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    
                    // 
                    // Call DAMs to retrieve data
                    // 
                    //  Call PostEvent
                    // 
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    
                    break;
                case NO_DATA_FOUND:
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                    
                    //  Call PostEvent
                    // 
                    rc = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                    
                    //  SIR #10113 - 6/14/96 - PURCELA - Move the freeing of CSES21D
                    // input and output headers inside the if statement.  If not,
                    // memory might be freed without being allocated.
                    
                    
                    
                    break;
                case WtcHelperConstants.SQL_DUPLICATE_KEY:
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_CMN_UPDATE_FAILED;
                    rc = Messages.MSG_CMN_UPDATE_FAILED;
                    
                    break;
                case Arcutls.ARC_UTL_GENERAL_FAILURE:
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    
            }
        }
        return rc;
    }

    static int CallCAUD99D(CCMN44SI pInputMsg342, CCMN44SO * pOutputMsg312, int counter, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CAUD99DI pCAUD99DInputRec = null;
        CAUD99DO pCAUD99DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        
        pCAUD99DInputRec = new CAUD99DI();
        
        pCAUD99DOutputRec = new CAUD99DO();
        pCAUD99DInputRec.setArchInputStruct(pInputMsg342.getArchInputStruct());
        
        
        pCAUD99DInputRec.setUlIdMedUpdStage(pInputMsg342.getUlIdStage());
        pCAUD99DInputRec.setUlIdMedUpdPerson(pInputMsg342.getUlIdPerson());
        pCAUD99DInputRec.setUlIdMedUpdRecord(pInputMsg342.getROWCCMN44SIG00_ARRAY().getROWCCMN44SIG00(counter).getLdIdAddress());
        pCAUD99DInputRec.setSzCdMedUpdType(MED_UPDATE_TYPE);
        pCAUD99DInputRec.setSzCdMedUpdTransTypE(MED_UPDATE_TRANS_TYPE);
        pCAUD99DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
        /* get the names from NAME table for person_forward */
        rc = caud99dAUDdam(sqlca, pCAUD99DInputRec, pCAUD99DOutputRec);
        /*
        ** RIOSJA, SIR 16123 - Removed GENERAL_PROT_CARE,
        ** DAY_CARE, IVE_FC_DAY_CARE, REGISTERED_FAMILY_HM
        ** and STATE_PAID_FC_DAY_CARE from the list of service
        ** auth types that are allowed to remain open when
        ** the last stage in the case is being closed. Only
        ** approved FORMER_DAY_CARE service auths are allowed
        ** to remain open.
        */
        if (rc != 0) {
            switch (rc) {
                case NO_DATA_FOUND:
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                    // get the names from NAME table for person_closed
                    rc = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                    break;
                case WtcHelperConstants.SQL_DUPLICATE_KEY:
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_CMN_UPDATE_FAILED;
                    // insert into NAME table
                    rc = Messages.MSG_CMN_UPDATE_FAILED;
                    break;
                case Arcutls.ARC_UTL_GENERAL_FAILURE:
                    
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        
        else {
        }
        return rc;
    }

}
