package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN82SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN82SO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNG4DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNG4DO;
/**************************************************************************
**
** Module File:   CCMN82S.src
**
** Service Name:  CCMN82S
**
** Description:   This window while perform AUD operations for the
**                special handling window (CCMN73W).  It will update
**                part of one row in the CAPS CASE table.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  01/20/95
**
** Programmer:    Steven Elliott
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  7/27/95   RUSSELRM  SIR #988 Replaced ccmnb2d which updates a whole case 
**                      row with ccmng4d which only updates the special 
**                      handling, sensitivity and worker safety issues.  
**
**  10/20/95  SOOLEYAG  SIR #1874 - Added code logic in service and dam to
**                      handle timestamp mismatch errors.
**  7/26/96    zabihin  sir 21891 : version control code was missing, I
**                      added the lines.
**
**   8/12/96  vanderm   SIR 21968;  Database should be restored to its
**                      original state for all services which perform
**                      updates that encounter an error.  
**                      Error handling changed from FND_SEVERITY_WARNING to
**                      FND_SEVERITY_ERROR for all AUD dams.
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






public class Ccmn82s {
    static int transactionflag = - 1;
    CCMN82SO CCMN82S(CCMN82SI ccmn82si) {
        CCMN82SO ccmn82so = new CCMN82SO();
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
            userlog("ERROR: tpgetlev failed in CCMN82S (%s)\n", tpstrerror(tperrno));
            pServiceStatus.severity = FND_SEVERITY_ERROR;
            pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPBEGIN_FAILED;
            rc = Arcxmlerrors.ARC_ERR_TUX_TPBEGIN_FAILED;
            
            //## BEGIN TUX/XML: Declare XML variables
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        }
        else if (transactionflag == 1) {
            userlog("START: TRANSACTION ALREADY IN PROGRESS in CCMN82S\n");
        }
        else if (transactionflag == 0) {
            userlog("TRANSACTION IS STARTED in CCMN82S \n");
            bTransactionStarted = true;
        }
        
        /*
        ** Set the input message for the Invalidate function
        */
        /* allocate and intialize records for Invalidate Approval */
        /* pInputMsg->ROWCCMN46DI is the Event record that was */
        /* just updated in PostEvent   */
        
        /*
        ** SIR 18571 - This page doesn't have an approval of its own.
        ** InvalidateAprvl should always be sent the ulIdEvent of the
        ** pending stage closure.
        ** Old Code:
        */
        
        /*
        if (pInputMsg->ROWCCMN46DI.ulIdEvent == 0 ||
        !(strncmp(pInputMsg->ROWCCMN46DI.szCdEventStatus, EVENT_STATUS_NEW,
        strlen(EVENT_STATUS_NEW))))
        {
        rc=CallCCMN62D(pInputMsg,
        pOutputMsg,
        TUX_STATUSPARMS);
        PROCESS_TUX_RC_ERROR;
        pInvdInput->ulIdEvent = pInputMsg->ulIdEvent;
        }
        else
        {
        pInvdInput->ulIdEvent = pInputMsg->ROWCCMN46DI.ulIdEvent;
        }
        */
        /*
        ** New Code:
        */
        
        rc = ARC_PRFServiceStartTime_TUX(ccmn82si.getArchInputStruct());
        // end SIR 18571
        
        /*
        ** Call the Invalidate function
        */
        rc = CallCCMNG4D(ccmn82si, ccmn82so, pServiceStatus);
        
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
                
                //   PROCESS_TUX_RC_ERROR_TRANSACT is called only when there is an unexpected error
                // returned from the callDAM function.
            default :
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        }
        
        /*
        ** Load translation map with service name and version
        */
        
        /*
        ** Stop performance timer for service
        */
        ARC_PRFServiceStopTime_TUX(ccmn82si.getArchInputStruct() , ccmn82so.getArchOutputStruct());
        
        /*
        ** Populate DAM input structure
        */
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError_Transact(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber() , transactionflag);
        }
        else if (bTransactionStarted) {
            
            // 
            // End Call to Post Event Common Function - CCMN01U
            // 
            
            
            if (tpcommit(0) == - 1) {
                userlog("ERROR: tpcommit failed in service CCMN82S (%s)\n", tpstrerror(tperrno));
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        else {
            userlog("END: TRANSACTION ALREADY IN PROGRESS CCMN82S \n");
        }
        return ccmn82so;
    }

    static int CallCCMNG4D(CCMN82SI pInputMsg356, CCMN82SO * pOutputMsg326, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        /*
        ** Declare local variables
        */
        CCMNG4DI pCCMNG4DInputRec = null;
        CCMNG4DO pCCMNG4DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMNG4DInputRec = new CCMNG4DI();
        pCCMNG4DOutputRec = new CCMNG4DO();
        pCCMNG4DInputRec.setArchInputStruct(pInputMsg356.getArchInputStruct());
        pCCMNG4DInputRec.setUlIdCase(pInputMsg356.getSpecHD().getUlIdCase());
        pCCMNG4DInputRec.setTsSysTsLastUpdate2(pInputMsg356.getSpecHD().getTsSysTsLastUpdate2());
        pCCMNG4DInputRec.setSzCdCaseSpeclHndlg(pInputMsg356.getSpecHD().getSzCdCaseSpeclHndlg());
        pCCMNG4DInputRec.setBIndCaseSensitive(pInputMsg356.getSpecHD().getBIndCaseSensitive());
        pCCMNG4DInputRec.setBIndCaseWorkerSafety(pInputMsg356.getSpecHD().getBIndCaseWorkerSafety());
        pCCMNG4DInputRec.setSzTxtCaseWorkerSafety(pInputMsg356.getSpecHD().getSzTxtCaseWorkerSafety());
        pCCMNG4DInputRec.setSzTxtCaseSensitiveCmnts(pInputMsg356.getSpecHD().getSzTxtCaseSensitiveCmnts());
        
        
        /*
        ** Set rc to ARC_SUCCESS
        */
        rc = ccmng4dAUDdam(sqlca, pCCMNG4DInputRec, pCCMNG4DOutputRec);
        
        
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
