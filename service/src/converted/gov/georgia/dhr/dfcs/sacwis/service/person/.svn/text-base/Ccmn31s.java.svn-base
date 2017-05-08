package gov.georgia.dhr.dfcs.sacwis.service.person;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN31SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN31SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN06UO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN95DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN95DO;
/**************************************************************************
**
** Module File:   CCMN31S.src
**
** Service Name:  CCMN31S
**
** Description:   This is the AUD service for the Phone List/Detail window.
**                It consists of only the CCMN95D Data Access Module.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  30 JAN 95
**
** Programmer:    CRG
**
** Archive Information: $Revision:   1.1  $
**                      $Date:   17 Mar 1997 19:29:14  $
**                      $Modtime:   13 Mar 1997 11:07:02  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  4/11/95   WEALANBC  Made some changes for technical review.  Implemented
**                      recent changes to the service shell.
**  1/17/96   GUARRICR  SIR#2426  Added CheckStageEventStatus common
**                      function.
**  03/12/97    KRD     SIR 10348 - To ensure that the timestamps on the
**                      start and end dates for phones are set properly, we
**                      need to process the changes in reverse order.
**                      Required changes to the loop processing in
**                      CallCCMN95D().
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






public class Ccmn31s {
    CCMN31SO CCMN31S(CCMN31SI ccmn31si) {
        CCMN31SO ccmn31so = new CCMN31SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        //## END TUX/XML: Declare XML variables
        
        int rc = FND_SUCCESS;
        int RetVal = SUCCESS;/* SIR#2426 */
        CCMN06UI pCCMN06UInputRec = null;/* SIR#1710 Check Stage/Event common function */
        CCMN06UO pCCMN06UOutputRec = null;/* SIR#1710 */
        
        /*
        ** Call DAM
        */
        rc = ARC_PRFServiceStartTime_TUX(ccmn31si.getArchInputStruct());
        if (ccmn31si.getUlIdStage() != 0) {
            //  Allocate memory for Common Function Input and Output Structures
            pCCMN06UInputRec = new CCMN06UI();
            
            pCCMN06UOutputRec = new CCMN06UO();
            pCCMN06UInputRec.setArchInputStruct(ccmn31si.getArchInputStruct());
            pCCMN06UInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
            pCCMN06UInputRec.setUlIdStage(ccmn31si.getUlIdStage());
            pCCMN06UInputRec.setSzCdTask(ccmn31si.getSzCdTask());
            rc = Ccmn06u.CheckStageEventStatus(pCCMN06UInputRec, pCCMN06UOutputRec, pServiceStatus);
            
            //  Analyze return code
            // switch # 1
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
            rc = Cint02s.CallCCMN95D(ccmn31si, ccmn31so, pServiceStatus);
            if (rc != SUCCESS) {
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
        }
        
        
        /* Setup for service function exit */
        
        
        ARC_PRFServiceStopTime_TUX(ccmn31si.getArchInputStruct() , ccmn31so.getArchOutputStruct());
        
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
        return ccmn31so;
    }

    static int PrepServiceExit(_SERVICE_DATA * pfpb, _RTAF * pRTAF, _ABHI * pABHI) {
        _MSG_PARM_BLOCK * pMsgPB = (_MSG_PARM_BLOCK) pfpb.pTXN_PB;
        _MSG_PARM_BLOCK * pReturnPB = (_MSG_PARM_BLOCK) pRTAF.pReply_txn_pb;
        int rc = 0;
        pOutputMsgTransMap.map_name = "CCMN31SO";
        pOutputMsgTransMap.map_version = "01";
        
        /*
        ** Stop performance timer for service
        */
        
        ARC_PRFServiceStopTime_TUX(Csys08s.pInputMsg.getArchInputStruct() , Csys08s.pOutputMsg.getArchOutputStruct());
        return SUCCESS;
    }

    
    static int CallCCMN95D(CCMN31SI pInputMsg286, CCMN31SO * pOutputMsg269, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int i152 = 0;
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CCMN95DI pCCMN95DInputRec = null;
        CCMN95DO pCCMN95DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        
        pCCMN95DInputRec = new CCMN95DI();
        
        pCCMN95DOutputRec = new CCMN95DO();
        pCCMN95DInputRec.setArchInputStruct(pInputMsg286.getArchInputStruct());
        
        /*
        ** Logic to be performed for every row in the list box.
        **
        ** SIR 10348 - CCMN95D keeps track of the timestamps on the Start and End
        ** dates.  The primary phones in the input message are sorted in
        ** reverse-modified order (i.e., the most recent primary phone added or
        ** modified will be at beginning of the input message).  To ensure that
        ** the phones receive the timestamps in the proper order, we need to
        ** process the list in reverse order.  This requires a change to the
        ** for loop from:
        **     for (i = 0; i < pInputMsg->usSysNbrNumberOfRows; i++)
        ** to:
        **     for (i = pInputMsg->usSysNbrNumberOfRows - 1; i>=0; i--)
        */
        for (i152 = pInputMsg286.getUsSysNbrNumberOfRows() - 1;i152 >= 0;i152--) {
            pCCMN95DInputRec.getROWCCMN95DI().setUlIdPerson(pInputMsg286.getUlIdPerson());
            pCCMN95DInputRec.getROWCCMN95DI().setUlIdPhone(pInputMsg286.getROWCCMN31SI_ARRAY().getROWCCMN31SI(i152).getUlIdPhone());
            pCCMN95DInputRec.getROWCCMN95DI().setSzCdPhoneType(pInputMsg286.getROWCCMN31SI_ARRAY().getROWCCMN31SI(i152).getSzCdPhoneType());
            
            pCCMN95DInputRec.getROWCCMN95DI().setLNbrPhone(pInputMsg286.getROWCCMN31SI_ARRAY().getROWCCMN31SI(i152).getLNbrPhone());
            
            
            pCCMN95DInputRec.getROWCCMN95DI().setLNbrPhoneExtension(pInputMsg286.getROWCCMN31SI_ARRAY().getROWCCMN31SI(i152).getLNbrPhoneExtension());
            pCCMN95DInputRec.getROWCCMN95DI().setDtDtPersonPhoneStart(pInputMsg286.getROWCCMN31SI_ARRAY().getROWCCMN31SI(i152).getDtDtPersonPhoneStart());
            pCCMN95DInputRec.getROWCCMN95DI().setDtDtPersonPhoneEnd(pInputMsg286.getROWCCMN31SI_ARRAY().getROWCCMN31SI(i152).getDtDtPersonPhoneEnd());
            pCCMN95DInputRec.getROWCCMN95DI().setBIndPersonPhonePrimary(pInputMsg286.getROWCCMN31SI_ARRAY().getROWCCMN31SI(i152).getBIndPersonPhonePrimary());
            pCCMN95DInputRec.getROWCCMN95DI().setBIndPersonPhoneInvalid(pInputMsg286.getROWCCMN31SI_ARRAY().getROWCCMN31SI(i152).getBIndPersonPhoneInvalid());
            pCCMN95DInputRec.getROWCCMN95DI().setSzTxtPhoneComments(pInputMsg286.getROWCCMN31SI_ARRAY().getROWCCMN31SI(i152).getSzTxtPhoneComments());
            pCCMN95DInputRec.getROWCCMN95DI().setTsLastUpdate(pInputMsg286.getROWCCMN31SI_ARRAY().getROWCCMN31SI(i152).getTsLastUpdate());
            pCCMN95DInputRec.getArchInputStruct().setCReqFuncCd(pInputMsg286.getROWCCMN31SI_ARRAY().getROWCCMN31SI(i152).getSzCdScrDataAction());
            rc = ccmn95dAUDdam(sqlca, pCCMN95DInputRec, pCCMN95DOutputRec);
            
            switch (rc) {
                    
                case WtcHelperConstants.SQL_SUCCESS:
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    
                    break;
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
                    
                    break;
                case Arcutls.ARC_UTL_GENERAL_FAILURE:
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    
                    
                    break;
            }
        }
        return rc;
    }

}
