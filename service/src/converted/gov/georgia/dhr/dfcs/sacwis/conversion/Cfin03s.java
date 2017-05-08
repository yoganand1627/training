package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN03SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN03SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CMSC06DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CMSC06DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
/**************************************************************************
** 
** Module File:   CFIN03S.src
**
** Service Name:  CFIN03S
**
** Description:   This service will save the information for the
**                entry fields fro CFIN03W - INVOICE HEADER.
**                The sercive will update the INVOICE table with 
**                the information that appears on the window.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.4 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  11/14/95
** 
** Programmer:    GLOORJW 
**
** Archive Information: $Revision:   1.1  $
**                      $Date:   17 Jul 1999 14:43:00  $
**                      $Modtime:   22 Jun 1999 16:05:46  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cfin03s {
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final String USER_ADD = "U";
    CFIN03SO CFIN03S(CFIN03SI cfin03si) {
        CFIN03SO cfin03so = new CFIN03SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        
        /*
        ** Declare local variables
        */
        int rc = FND_SUCCESS;
        
        /*
        ** Declare FOUNDATION variables 
        */
        int eak = 0;
        
        /*
        ** Declare local variables 
        */
        
        CMSC06DI pCMSC06DInputRec = null;
        CMSC06DO pCMSC06DOutputRec = null;
        
        /*
        ** Call TodoCommonFunction
        */
        rc = ARC_PRFServiceStartTime_TUX(cfin03si.getArchInputStruct());
        
        /*
        ** Run-time versioning
        */
        eak = sizeof ();
        
        
        
        /*
        ** Initialize Service Status Fields 
        */
        
        
        
        /*
        **  Perform Main Processing
        */
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCMSC06DInputRec = new CMSC06DI();
        
        pCMSC06DOutputRec = new CMSC06DO();
        pCMSC06DInputRec.setArchInputStruct(cfin03si.getArchInputStruct());
        
        /* BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo */
        pCMSC06DInputRec.getArchInputStruct().setCReqFuncCd(cfin03si.getArchInputStruct().getCReqFuncCd());
        pCMSC06DInputRec.setDAmtInvoClaimedAmount(cfin03si.getDAmtInvoClaimedAmount());
        
        //## BEGIN TUX/XML: Declare XML variables 
        pCMSC06DInputRec.setSzCdInvoAdjustmentRb(cfin03si.getSzCdInvoAdjustmentRb());
        pCMSC06DInputRec.setSzCdInvoPhase(cfin03si.getSzCdInvoPhase());
        pCMSC06DInputRec.setSzCdInvoType(cfin03si.getSzCdInvoType());
        pCMSC06DInputRec.setDtDtInvoReceivedDate(cfin03si.getDtDtInvoReceivedDate());
        pCMSC06DInputRec.setDtDtInvoEntryCompleted(cfin03si.getDtDtInvoEntryCompleted());
        pCMSC06DInputRec.setDtDtInvoEntryStarted(cfin03si.getDtDtInvoEntryStarted());
        pCMSC06DInputRec.setUlIdContract(cfin03si.getUlIdContract());
        pCMSC06DInputRec.setUlIdInvoInvoice(cfin03si.getUlIdInvoInvoice());
        pCMSC06DInputRec.setCIndInvoReadyForValid(cfin03si.getCIndInvoReadyForValid());
        pCMSC06DInputRec.setUMoInvoMonth(cfin03si.getUMoInvoMonth());
        pCMSC06DInputRec.setUYrInvoYear(cfin03si.getUYrInvoYear());
        pCMSC06DInputRec.setSzNbrInvoVid(cfin03si.getSzNbrInvoVid());
        pCMSC06DInputRec.setTsLastUpdate(cfin03si.getTsLastUpdate());
        if (WtcHelperConstants.REQ_FUNC_CD_ADD == cfin03si.getArchInputStruct().getCReqFuncCd()) {
            pCMSC06DInputRec.setDtDtInvoCreateDate(cfin03si.getDtDtInvoEntryStarted());
            pCMSC06DInputRec.setSzCdInvoGeneration(USER_ADD);
        }
        rc = cmsc06dAUDdam(sqlca, pCMSC06DInputRec, pCMSC06DOutputRec);
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                cfin03so.setUlIdInvoInvoice(pCMSC06DOutputRec.getUlIdInvoInvoice());
                cfin03so.setTsLastUpdate(pCMSC06DOutputRec.getTsLastUpdate());
                
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                
                break;
                
            case WtcHelperConstants.SQL_DUPLICATE_KEY:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_DUPLICATE_RECORD;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                
                break;
        }
        
        
        /*
        ** Load Translation Map
        */
        
        
        /*
        ** Stop Performance Timer
        */
        ARC_PRFServiceStopTime_TUX(cfin03si.getArchInputStruct() , cfin03so.getArchOutputStruct());
        
        
        /*
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
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        return cfin03so;
    }

}
