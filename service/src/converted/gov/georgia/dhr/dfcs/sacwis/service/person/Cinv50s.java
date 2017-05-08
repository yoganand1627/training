package gov.georgia.dhr.dfcs.sacwis.service.person;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV50SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV50SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN06UO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV78DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV78DO;
/**************************************************************************
**
** Module File:   cinv50.src
**
** Service Name:  Update Person Search Ind
**
** Description:   This service will update only the person search indicator
**                on the stage person link table.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  3/13/95
**
** Programmer:    D.M. Verso
**
** DAMS called:   CINV78D
**
**
** Change History:
**
**  Date     User      SIR    Description
**  -------  --------  -----  --------------------------------------
**  11/28/95 YANTISTK  1710   Added CheckStageEventStatus common function
**
**  08/02/96 YANTISTK  21881  Added a new case statement after the call to
**                            CINV78D to handle SQL_NOT_FOUND.
**
**   1/23/03   DWW      Added following line for error handling:
**                      if (RetVal == FND_SUCESS)  { rc=FND_SUCCESS; }
**
**  04/09/2003  KRD     IMPACT - The Person Search Indicator is now being
**                      updated from the Person Search page rather than
**                      by Person List (as was done in CAPS).  CINV78D was
**                      modified to use IdStage and IdPerson without
**                      tsLastUpdate.  Required changes to CallCINV78D().
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cinv50s {
    CINV50SO CINV50S(CINV50SI cinv50si) {
        CINV50SO cinv50so = new CINV50SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        int RetVal = SUCCESS;/*SIR#1710*/
        CCMN06UI pCCMN06UInputRec = null;/* Check Stage/Event common function */
        
        CCMN06UO pCCMN06UOutputRec = null;
        rc = ARC_PRFServiceStartTime_TUX(cinv50si.getArchInputStruct());
        
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
        ** SIR#1710
        ** (BEGIN): Common Function: ccmn06u  ** Check Stage/Event common function
        **************************************************************************/
        /*
        ** Allocate memory for Common Function Input and Output Structures
        */
        pCCMN06UInputRec = new CCMN06UI();
        
        pCCMN06UOutputRec = new CCMN06UO();
        pCCMN06UInputRec.setArchInputStruct(cinv50si.getArchInputStruct());
        
        pCCMN06UInputRec.getArchInputStruct().setCReqFuncCd(cinv50si.getArchInputStruct().getCReqFuncCd());
        pCCMN06UInputRec.setUlIdStage(cinv50si.getUlIdStage());
        pCCMN06UInputRec.setSzCdTask(cinv50si.getSzCdTask());
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
            rc = CallCINV78D(cinv50si, cinv50so, pServiceStatus);
            if (rc != SUCCESS) {
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
        }
        
        
        /* Setup for service function exit */
        
        
        ARC_PRFServiceStopTime_TUX(cinv50si.getArchInputStruct() , cinv50so.getArchOutputStruct());
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
                
                //  Call DAM
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        return cinv50so;
    }

    static int PrepServiceExit(_SERVICE_DATA * pfpb, _RTAF * pRTAF, _ABHI * pABHI) {
        _MSG_PARM_BLOCK * pMsgPB = (_MSG_PARM_BLOCK) pfpb.pTXN_PB;
        /* unsigned short *,    SIR 13532 */
        _MSG_PARM_BLOCK * pReturnPB = (_MSG_PARM_BLOCK) pRTAF.pReply_txn_pb;
        int rc = 0;
        pOutputMsgTransMap.map_name = "CINV50SO";
        pOutputMsgTransMap.map_version = "01";
        
        /*
        ** Stop performance timer for service
        */
        
        ARC_PRFServiceStopTime_TUX(Csys08s.pInputMsg.getArchInputStruct() , Csys08s.pOutputMsg.getArchOutputStruct());
        return SUCCESS;
    }

    static int CallCINV78D(CINV50SI pInputMsg757, CINV50SO * pOutputMsg705, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CINV78DI pCINV78DInputRec = null;
        CINV78DO pCINV78DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV78DInputRec = new CINV78DI();
        
        
        pCINV78DOutputRec = new CINV78DO();
        pCINV78DInputRec.setArchInputStruct(pInputMsg757.getArchInputStruct());
        pCINV78DInputRec.setUlIdPerson(pInputMsg757.getUlIdStagePerson());
        pCINV78DInputRec.setUlIdStage(pInputMsg757.getUlIdStage());
        pCINV78DInputRec.setSzCdStagePersSearchInd(pInputMsg757.getSzCdStagePersSearchInd());
        
        
        /*
        ** Call CCMN45D
        */
        rc = cinv78dAUDdam(sqlca, pCINV78DInputRec, pCINV78DOutputRec);
        /**************************************************************************
        ** (END): Common Function: csub40u ** ToDo common function: from ToDoInfo
        **************************************************************************/
        
        if (rc != 0) {
            switch (rc) {
                case Arcutls.ARC_UTL_GENERAL_FAILURE:
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    break;
                case NO_DATA_FOUND:
                    pServiceStatus.explan_code = Messages.MSG_CFC_PERFORM_SEARCH;
                    rc = SUCCESS;
                    break;
                    
                    //   PROCESS_TUX_SQL_ERROR is called only when there is an unexpected
                    // SQL error returned from the DAM.
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        
        else {
        }
        return rc;
    }

}
