package gov.georgia.dhr.dfcs.sacwis.service.person;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT23SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT23SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN06UO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT18DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT18DO;
/**************************************************************************
**
** Module File:   CINT23S.src
**
** Service Name:  CINT23S
**
** Description:   This service updates all the identifiers for a given person.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  01/16/95
**
** Programmer:    Steven Elliott
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  04/03/95  ELLIOTSL  Logic has been added so that the DAM CINT23D will
**			be called if and only if there are rows in the input
**			message.  If there are no rows in the input message
**                      then the service will be exited and success will
**                      be returned.
**
**  05/12/95  ELLIOTSL  The PROCESS_TUX_RC_ERROR that occures after CallCINT18D
**			has been moved to the end of this service call in
**			order to assure that service wrap up logic will
**			always get excecuted.
**
**  01/17/96  GUARRICR  SIR#2426  Added CheckStageEventStatus common
**                      function.
**
**   1/23/03   DWW      Added following line for error handling:
**                      if (RetVal == FND_SUCESS)  { rc=FND_SUCCESS; }
**  04/15/05  DEMOMA	Added field bIndValidateByInterface for Sir23446
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/


/*
** Extern for version control table.
*/






public class Cint23s {
    CINT23SO CINT23S(CINT23SI cint23si) {
        CINT23SO cint23so = new CINT23SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        int RetVal = SUCCESS;/* SIR#2426 */
        CCMN06UI pCCMN06UInputRec = null;/*SIR#1710*/
        CCMN06UO pCCMN06UOutputRec = null;/*SIR#1710*/
        rc = ARC_PRFServiceStartTime_TUX(cint23si.getArchInputStruct());
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        if (cint23si.getUlIdStage() != 0) {
            //  Allocate memory for Common Function Input and Output Structures
            pCCMN06UInputRec = new CCMN06UI();
            
            pCCMN06UOutputRec = new CCMN06UO();
            pCCMN06UInputRec.setArchInputStruct(cint23si.getArchInputStruct());
            pCCMN06UInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
            pCCMN06UInputRec.setUlIdStage(cint23si.getUlIdStage());
            pCCMN06UInputRec.setSzCdTask(cint23si.getSzCdTask());
            
            //  Call DAM
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
        }
        if (SUCCESS == RetVal) {
            if (cint23si.getArchInputStruct().getUlPageSizeNbr() != 0) {
                rc = Cint02s.CallCINT18D(cint23si, cint23so, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
        }
        
        /*
        ** Load translation map with service name and version
        */
        
        /*
        ** Stop performance timer for service
        */
        ARC_PRFServiceStopTime_TUX(cint23si.getArchInputStruct() , cint23so.getArchOutputStruct());
        if (RetVal == SUCCESS) {
            rc = SUCCESS;
            
        }
        
        /*
        ** Analyze error code
        */
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
                
                
                //  Call CAUD17D.  The Contract Service AUD performs a full row
                // insert to the Contract Service table.
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        return cint23so;
    }

    
    static int CallCINT18D(CINT23SI pInputMsg468, CINT23SO pOutputMsg428, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        //## END TUX/XML: Declare XML variables 
        
        int rc = 0;
        /*
        ** Declare local variables
        */
        int ulCurrentRow = 0;
        
        CINT18DI pCINT18DInputRec = null;
        CINT18DO pCINT18DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINT18DInputRec = new CINT18DI();
        pCINT18DOutputRec = new CINT18DO();
        if (!(pCINT18DInputRec != null) ||!(pCINT18DOutputRec != null)) {
            rc = Arcxmlerrors.ARC_ERR_INTERNAL_ERROR;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            return rc;
        }
        pCINT18DInputRec.setArchInputStruct(pInputMsg468.getArchInputStruct());
        
        for (ulCurrentRow = 0;ulCurrentRow < pCINT18DInputRec.getArchInputStruct().getUlPageSizeNbr();ulCurrentRow++) {
            pCINT18DInputRec.setSzCdPersonIdType(pInputMsg468.getCINT14WLB_ARRAY().getCINT14WLB(ulCurrentRow).getSzCdPersonIdType());
            pCINT18DInputRec.setBIndPersonIDInvalid(pInputMsg468.getCINT14WLB_ARRAY().getCINT14WLB(ulCurrentRow).getBIndPersonIDInvalid());
            pCINT18DInputRec.setSzDescPersonID(pInputMsg468.getCINT14WLB_ARRAY().getCINT14WLB(ulCurrentRow).getSzDescPersonID());
            pCINT18DInputRec.setDtPersonIDStart(pInputMsg468.getCINT14WLB_ARRAY().getCINT14WLB(ulCurrentRow).getDtPersonIDStart());
            pCINT18DInputRec.setDtPersonIDEnd(pInputMsg468.getCINT14WLB_ARRAY().getCINT14WLB(ulCurrentRow).getDtPersonIDEnd());
            pCINT18DInputRec.setSzNbrPersonIdNumber(pInputMsg468.getCINT14WLB_ARRAY().getCINT14WLB(ulCurrentRow).getSzNbrPersonIdNumber());
            pCINT18DInputRec.setUlIdPerson(pInputMsg468.getCINT14WLB_ARRAY().getCINT14WLB(ulCurrentRow).getUlIdPerson());
            pCINT18DInputRec.setUlIdPersonId(pInputMsg468.getCINT14WLB_ARRAY().getCINT14WLB(ulCurrentRow).getUlIdPersonId());
            pCINT18DInputRec.setTsSysTsLastUpdate2(pInputMsg468.getCINT14WLB_ARRAY().getCINT14WLB(ulCurrentRow).getTsSysTsLastUpdate2());
            pCINT18DInputRec.setBIndValidateByInterface(pInputMsg468.getCINT14WLB_ARRAY().getCINT14WLB(ulCurrentRow).getBIndValidateByInterface());
            pCINT18DInputRec.getArchInputStruct().setCReqFuncCd(pInputMsg468.getCINT14WLB_ARRAY().getCINT14WLB(ulCurrentRow).getSzCdScrDataAction());
            rc = cint18dAUDdam(sqlca, pCINT18DInputRec, pCINT18DOutputRec);
            
            
            if (rc != 0) {
                
                
                
                //  Analyze return code
                switch (rc) {
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                }
            }
            
            
            else {
                pOutputMsg428.setArchOutputStruct(pCINT18DOutputRec.getArchOutputStruct());
            }
        }
        return rc;
    }

}
