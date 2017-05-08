package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC20SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC20SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD75DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD75DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
/**************************************************************************
** 
** Module File:   CCFC20S.src
**
** Service Name:  CCFC20S
**
** Description:   This service will add/update all columns for an Id Case
**                from the RECORDS RETENTION table.  It will call DAM:
**                CAUD75D - REC RETN AUD.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.4 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  12/27/95
** 
** Programmer:    Lee Phillips 
**
** Archive Information: $Revision:   1.0  $
**                      $Date:   27 May 1996 16:38:16  $
**                      $Modtime:   29 Mar 1996 23:57:04  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**		
**  08/04/03   Srini    SIR 17827 - IMPACT: Made the service transactionaware.
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Ccfc20s {
    static int transactionflag = - 1;
    CCFC20SO CCFC20S(CCFC20SI ccfc20si) {
        CCFC20SO ccfc20so = new CCFC20SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        //## END TUX/XML: Turn the XML buffer into an input message struct 
        
        
        transactionflag = - 1;
        boolean bTransactionStarted = false;
        transactionflag = tpgetlev();
        
        if (transactionflag == - 1) {
            userlog("ERROR: tpgetlev failed in CCFC20S (%s)\n", tpstrerror(tperrno));
            pServiceStatus.severity = FND_SEVERITY_ERROR;
            pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPBEGIN_FAILED;
            
            
            //  Call CCMN43D
            rc = Arcxmlerrors.ARC_ERR_TUX_TPBEGIN_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        }
        else if (transactionflag == 1) {
            userlog("START: TRANSACTION ALREADY IN PROGRESS in CCFC20S\n");
        }
        else if (transactionflag == 0) {
            userlog("TRANSACTION IS STARTED in CCFC20S \n");
            bTransactionStarted = true;
        }
        
        /*
        ** Declare FOUNDATION variables 
        */
        
        /*
        ** Declare local variables 
        */
        //##  short rc = FND_SUCCESS;
        
        CAUD75DI pCAUD75DInputRec = null;
        CAUD75DO pCAUD75DOutputRec = null;
        rc = ARC_PRFServiceStartTime_TUX(ccfc20si.getArchInputStruct());
        
        
        
        /*
        ** Initialize Service Status Fields 
        */
        
        
        
        /*
        **  Perform Main Processing
        */
        
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCAUD75DInputRec = new CAUD75DI();
        
        pCAUD75DOutputRec = new CAUD75DO();
        pCAUD75DInputRec.setArchInputStruct(ccfc20si.getArchInputStruct());
        pCAUD75DInputRec.getArchInputStruct().setCReqFuncCd(ccfc20si.getArchInputStruct().getCReqFuncCd());
        pCAUD75DInputRec.setSzCdRecRtnRetenType(ccfc20si.getSzCdRecRtnRetenType());
        pCAUD75DInputRec.setSzTxtRecRtnDstryDtRsn(ccfc20si.getSzTxtRecRtnDstryDtRsn());
        pCAUD75DInputRec.setTsLastUpdate(ccfc20si.getTsLastUpdate());
        pCAUD75DInputRec.setUlIdCase(ccfc20si.getUlIdCase());
        pCAUD75DInputRec.setDtDtRecRtnDstryActual(ccfc20si.getDtDtRecRtnDstryActual());
        pCAUD75DInputRec.setDtDtRecRtnDstryElig(ccfc20si.getDtDtRecRtnDstryElig());
        rc = caud75dAUDdam(sqlca, pCAUD75DInputRec, pCAUD75DOutputRec);
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:// CLSC51D
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                break;
        }
        
        
        /*
        ** Load Translation Map
        */
        
        
        /*
        ** Stop Performance Timer
        */
        ARC_PRFServiceStopTime_TUX(ccfc20si.getArchInputStruct() , ccfc20so.getArchOutputStruct());
        
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError_Transact(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber() , transactionflag);
        }
        else if (bTransactionStarted) {
            
            if (tpcommit(0) == - 1) {
                userlog("ERROR: tpcommit failed in service CCFC20S (%s)\n", tpstrerror(tperrno));
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                
                //  Call DAM
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        else {
            userlog("END: TRANSACTION ALREADY IN PROGRESS CCFC20S \n");
        }
        return ccfc20so;
    }

}
