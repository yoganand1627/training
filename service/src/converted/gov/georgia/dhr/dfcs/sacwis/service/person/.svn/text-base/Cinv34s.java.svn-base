package gov.georgia.dhr.dfcs.sacwis.service.person;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV34SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV34SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN06UO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV48DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV48DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV41DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV41DO;
/**************************************************************************
**
** Module File:   CINV34S.src
**
** Service Name:  CINV34S
**
** Description:   This service is responsible for adding or updating
**                information from the Person Characteristics window.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  January 20, 1995
**
** Programmer:    Terry T. Cavallaro
**
** DAMS called:   CINV48D
**                CINV41D
**
** Change History:
**
**  Date     User               SIR  Description
**  -------  ------------------ ---  --------------------------------------
**  10/08/95 DMV                1703 Memset DAM Records
**  11/28/95 YANTISTK			1710 Added CheckStageEventStatus common function
**	06/11/01 ANG					 Security upgrade - added code so that
**									 if a person with the SEC_MNTN_PERSON
**									 attribute tries to save, a flag will
**									 be passed in so that the common
**									 function ccmn06u will not be called.
**   1/23/03   DWW      Added following line for error handling:
**                      if (RetVal == FND_SUCESS)  { rc=FND_SUCCESS; } 
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cinv34s {
    CINV34SO CINV34S(CINV34SI cinv34si) {
        CINV34SO cinv34so = new CINV34SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        int RetVal = SUCCESS;/*SIR#1710*/
        int i347 = 0;
        CCMN06UI pCCMN06UInputRec = null;/* SIR#1710 CheckStageEventStatus function */
        CCMN06UO pCCMN06UOutputRec = null;/* SIR#1710 */
        
        
        /*
        ** Call CCMN45D - retrieves row from event table which CCMN01U
        ** (below) will modify
        */
        rc = ARC_PRFServiceStartTime_TUX(cinv34si.getArchInputStruct());
        if ('N' == cinv34si.getBSysIndGeneric()) {
            // 
            // SIR#1710
            // (BEGIN): Common Function: ccmn06u   Check Stage/Event common function
            // 
            //  Allocate memory for Common Function Input and Output Structures
            pCCMN06UInputRec = new CCMN06UI();
            
            pCCMN06UOutputRec = new CCMN06UO();
            pCCMN06UInputRec.setArchInputStruct(cinv34si.getArchInputStruct());
            pCCMN06UInputRec.getArchInputStruct().setCReqFuncCd(cinv34si.getArchInputStruct().getCReqFuncCd());
            pCCMN06UInputRec.setUlIdStage(cinv34si.getUlIdStage());
            pCCMN06UInputRec.setSzCdTask(cinv34si.getSzCdTask());
            rc = Ccmn06u.CheckStageEventStatus(pCCMN06UInputRec, pCCMN06UOutputRec, pServiceStatus);
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:// for clss37d
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    //  Set RetVal to FND_SUCCESS
                    RetVal = SUCCESS;
                    break;
                case Messages.MSG_SYS_STAGE_CLOSED:// caud28d
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_SYS_STAGE_CLOSED;
                    
                    //  Set RetVal to FND_FAIL
                    RetVal = Csub50s.FND_FAIL;
                    break;
                case Messages.MSG_SYS_EVENT_STS_MSMTCH:// caud28d
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_SYS_EVENT_STS_MSMTCH;
                    
                    //  Set RetVal to FND_FAIL
                    RetVal = Csub50s.FND_FAIL;
                    break;
                case Messages.MSG_SYS_MULT_INST:// for CAUD20D
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
            
            if (cinv34si.getSListRowsQty() > 0) {
                rc = Ccmn03u.CallCINV48D(cinv34si, cinv34so, pServiceStatus);
                if (rc != SUCCESS) {
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                }
            }
            rc = Ccfc14s.CallCINV41D(cinv34si, cinv34so, pServiceStatus);
            
            if (rc != SUCCESS) {
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
        }
        
        
        /* Setup for service function exit */
        
        
        ARC_PRFServiceStopTime_TUX(cinv34si.getArchInputStruct() , cinv34so.getArchOutputStruct());
        
        if (RetVal == SUCCESS) {
            rc// DAM name should be in lower case
             = SUCCESS;
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
        return cinv34so;
    }

    static int PrepServiceExit(_SERVICE_DATA * pfpb, _RTAF * pRTAF, _ABHI * pABHI) {
        _MSG_PARM_BLOCK * pMsgPB = (_MSG_PARM_BLOCK) pfpb.pTXN_PB;
        _MSG_PARM_BLOCK * pReturnPB = (_MSG_PARM_BLOCK) pRTAF.pReply_txn_pb;
        int rc = 0;/* Return code */
        pOutputMsgTransMap.map_name = "CINV34SO";
        pOutputMsgTransMap.map_version = "01";
        
        
        /* Stop performance timer for service */
        
        ARC_PRFServiceStopTime_TUX(Csys08s.pInputMsg.getArchInputStruct() , Csys08s.pOutputMsg.getArchOutputStruct());
        return SUCCESS;
    }

    static int CallCINV48D(CINV34SI pInputMsg708, CINV34SO * pOutputMsg658, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int i348 = 0;
        int rc = 0;/* Return code */
        CINV48DI pCINV48DInputRec = null;
        CINV48DO pCINV48DOutputRec = null;
        
        /* Allocate memory for Input and Output Structures */
        pCINV48DInputRec = new CINV48DI();
        
        
        pCINV48DOutputRec = new CINV48DO();
        pCINV48DInputRec.setArchInputStruct(pInputMsg708.getArchInputStruct());
        
        /************ Populate characteristic additions/updates ************/
        
        for (i348 = 0;i348 < pInputMsg708.getSListRowsQty();i348++) 
        
        {
            pCINV48DInputRec.getROWCINV48DI().setUlIdPerson(pInputMsg708.getUlIdPerson());
            pCINV48DInputRec.getROWCINV48DI().setUlIdCharacteristics(pInputMsg708.getROWCINV34SIG_ARRAY().getROWCINV34SIG(i348).getUlIdCharacteristics());
            pCINV48DInputRec.getROWCINV48DI().setSzCdCharCategory(pInputMsg708.getROWCINV34SIG_ARRAY().getROWCINV34SIG(i348).getSzCdCharCategory());
            pCINV48DInputRec.getROWCINV48DI().setCdCharacteristic(pInputMsg708.getROWCINV34SIG_ARRAY().getROWCINV34SIG(i348).getCdCharacteristic());
            pCINV48DInputRec.getROWCINV48DI().getDtDtCharStart().day = pInputMsg708.getROWCINV34SIG_ARRAY().getROWCINV34SIG(i348).getDtDtCharStart().day;
            pCINV48DInputRec.getROWCINV48DI().getDtDtCharStart().month = pInputMsg708.getROWCINV34SIG_ARRAY().getROWCINV34SIG(i348).getDtDtCharStart().month;
            pCINV48DInputRec.getROWCINV48DI().getDtDtCharStart().year = pInputMsg708.getROWCINV34SIG_ARRAY().getROWCINV34SIG(i348).getDtDtCharStart().year;
            pCINV48DInputRec.getROWCINV48DI().getDtDtCharEnd().day = pInputMsg708.getROWCINV34SIG_ARRAY().getROWCINV34SIG(i348).getDtDtCharEnd().day;
            pCINV48DInputRec.getROWCINV48DI().getDtDtCharEnd().month = pInputMsg708.getROWCINV34SIG_ARRAY().getROWCINV34SIG(i348).getDtDtCharEnd().month;
            pCINV48DInputRec.getROWCINV48DI().getDtDtCharEnd().year = pInputMsg708.getROWCINV34SIG_ARRAY().getROWCINV34SIG(i348).getDtDtCharEnd().year;
            pCINV48DInputRec.getROWCINV48DI().setSysLastUpdate(pInputMsg708.getROWCINV34SIG_ARRAY().getROWCINV34SIG(i348).getSysLastUpdate());
            pCINV48DInputRec.getArchInputStruct().setCReqFuncCd(pInputMsg708.getROWCINV34SIG_ARRAY().getROWCINV34SIG(i348).getSzCdScrDataAction());
            pCINV48DInputRec.getROWCINV48DI().setLNbrPersonAge(pInputMsg708.getLNbrPersonAge());
            
            if (null != pInputMsg708.getROWCINV34SIG_ARRAY().getROWCINV34SIG(i348).getSzCdScrDataAction()) {
                
                // get the records for case_merge_to from events & stage table
                rc = cinv48dAUDdam(sqlca, pCINV48DInputRec, pCINV48DOutputRec);
                if (rc != 0) {
                    
                    switch (rc) {
                        case NO_DATA_FOUND:
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                            pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                            
                            // get the records for case_merge_from from events & stage table
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
            }
        }
        return rc;
    }

    static int CallCINV41D(CINV34SI pInputMsg709, CINV34SO * pOutputMsg659, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CINV41DI pCINV41DInputRec = null;
        CINV41DO pCINV41DOutputRec = null;
        int i349 = 0;
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV41DInputRec = new CINV41DI();
        
        pCINV41DOutputRec = new CINV41DO();
        pCINV41DInputRec.setTsSysTsLastUpdate2(pInputMsg709.getTsLastUpdate());
        
        pCINV41DInputRec.setCCdPersonSex(pInputMsg709.getCCdPersonSex());
        pCINV41DInputRec.setSzNmPersonFull(pInputMsg709.getSzNmPersonFull());
        pCINV41DInputRec.setDtDtPersonBirth(pInputMsg709.getDtDtPersonBirth());
        pCINV41DInputRec.setBIndPersonDobApprox(pInputMsg709.getBIndPersonDobApprox());
        pCINV41DInputRec.setDtDtPersonDeath(pInputMsg709.getDtDtPersonDeath());
        pCINV41DInputRec.setSzCdPersonDeath(pInputMsg709.getSzCdPersonDeath());
        pCINV41DInputRec.setSzCdPersonMaritalStatus(pInputMsg709.getSzCdPersonMaritalStatus());
        pCINV41DInputRec.setSzCdPersonLanguage(pInputMsg709.getSzCdPersonLanguage());
        
        pCINV41DInputRec.setSzCdPersonEthnicGroup(pInputMsg709.getSzCdPersonEthnicGroup());
        pCINV41DInputRec.setCdPersonStatus(pInputMsg709.getCdPersonStatus());
        pCINV41DInputRec.setUlIdPerson(pInputMsg709.getUlIdPerson());
        pCINV41DInputRec.setBCdPersonChar(pInputMsg709.getBCdPersonChar());
        pCINV41DInputRec.setSzCdPersonReligion(pInputMsg709.getSzCdPersonReligion());
        pCINV41DInputRec.setSzCdPersonLivArr(pInputMsg709.getSzCdPersonLivArr());
        pCINV41DInputRec.setDtDtPersonDeath(pInputMsg709.getDtDtPersonDeath());
        pCINV41DInputRec.setSzTxtOccupation(pInputMsg709.getSzTxtOccupation());
        pCINV41DInputRec.setLNbrPersonAge(pInputMsg709.getLNbrPersonAge());
        
        pCINV41DInputRec.setArchInputStruct(pInputMsg709.getArchInputStruct());
        rc = cinv41dAUDdam(sqlca, pCINV41DInputRec, pCINV41DOutputRec);
        if (rc != 0) {
            
            
            //  Analyze return code
            switch (rc) {
                    
                    //  On an INSERT or UPDATE statement, SQL_DUPLICATE_KEY is returned
                    // if there is an attempt to store a duplicate primary key value.
                    // pServiceStatus->explan_code should be set to the appropriate
                    // message by the programmer.
                case NO_DATA_FOUND:
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                    rc = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                    break;
                case WtcHelperConstants.SQL_DUPLICATE_KEY:
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_CMN_UPDATE_FAILED;
                    rc = Messages.MSG_CMN_UPDATE_FAILED;
                    //  Do nothing, the output message just returns success or failure
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

}
