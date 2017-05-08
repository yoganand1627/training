package gov.georgia.dhr.dfcs.sacwis.service.person;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC27SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC27SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD87DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD87DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
/**************************************************************************
**
** Module File:   CCFC27S.src
**
** Service Name:  CCFC27S
**
** Description:   This service will add rows to the Records Check table
**                and Update and Delete rows in the Records Check table
**                for a given IdRecCheck (maximum page size is 14 rows).
**
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.4 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  1/12/96
**
** Programmer:    CIN
**
** Archive Information: $Revision:   1.0  $
**                      $Date:   27 May 1996 16:39:32  $
**                      $Modtime:   29 Mar 1996 23:58:14  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**
**  06/23/03  Srini     SIR 18479 - Changed the error handler PROCESS_TUX_RC_ERROR
**                      to PROCESS_TUX_RC_ERROR_NOFREE after the
**                      ARC_UTLCheckServiceBatchBlock so that it doesn't free the
**                      input and output objects before they are allocated
*** 1/10/05   gerryc    SIR 23242 - added idRecCheck to be returned so that it
*                       could be sent to the page to be used for a narrative
*                       after inserting a record.
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Ccfc27s {
    CCFC27SO CCFC27S(CCFC27SI ccfc27si) {
        CCFC27SO ccfc27so = new CCFC27SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        
        rc = ARC_UTLCheckServiceBatchBlock("CCFC27S", pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
        
        /*
        ** Declare FOUNDATION variables
        */
        
        /*
        ** Declare local variables
        */
        //##  short rc = FND_SUCCESS;
        
        CAUD87DI pCAUD87DInputRec = null;
        CAUD87DO pCAUD87DOutputRec = null;
        
        
        
        
        /*
        ** List AUD
        */
        int usRow = 0;
        int usInputRow = 0;
        rc = ARC_PRFServiceStartTime_TUX(ccfc27si.getArchInputStruct());
        
        
        
        /*
        ** Initialize Service Status Fields
        */
        
        
        
        /*
        **  Perform Main Processing
        */
        
        /*
        ** List AUD DAM CAUD87D - This DAM will add/update/delete a full row to
        ** Records Check Table.  It will take as input an Id Rec Check
        */
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCAUD87DInputRec = new CAUD87DI();
        
        pCAUD87DOutputRec = new CAUD87DO();
        
        
        /*
        ** Start Performance Timer
        */
        rc = WtcHelperConstants.SQL_SUCCESS;
        
        /*
        ** While more rows are left to process and rc is zero,
        ** continue loop.
        */
        while ((usRow < ccfc27si.getArchInputStruct().getUlPageSizeNbr()) && (rc == WtcHelperConstants.SQL_SUCCESS)) {
            pCAUD87DInputRec.setArchInputStruct(ccfc27si.getArchInputStruct());
            pCAUD87DInputRec.getArchInputStruct().setCReqFuncCd(ccfc27si.getROWCCFC27SIG00_ARRAY().getROWCCFC27SIG00(usRow).getSzCdScrDataAction());
            pCAUD87DInputRec.setSzCdRecCheckCheckType(ccfc27si.getROWCCFC27SIG00_ARRAY().getROWCCFC27SIG00(usRow).getSzCdRecCheckCheckType());
            
            pCAUD87DInputRec.setSzCdRecCheckStatus(ccfc27si.getROWCCFC27SIG00_ARRAY().getROWCCFC27SIG00(usRow).getSzCdRecCheckStatus());
            pCAUD87DInputRec.setSzTxtRecCheckComments(ccfc27si.getROWCCFC27SIG00_ARRAY().getROWCCFC27SIG00(usRow).getSzTxtRecCheckComments());
            pCAUD87DInputRec.setDtDtRecCheckCompleted(ccfc27si.getROWCCFC27SIG00_ARRAY().getROWCCFC27SIG00(usRow).getDtDtRecCheckCompleted());
            pCAUD87DInputRec.setDtDtRecCheckRequest(ccfc27si.getROWCCFC27SIG00_ARRAY().getROWCCFC27SIG00(usRow).getDtDtRecCheckRequest());
            pCAUD87DInputRec.setTsLastUpdate(ccfc27si.getROWCCFC27SIG00_ARRAY().getROWCCFC27SIG00(usRow).getTsLastUpdate());
            pCAUD87DInputRec.setUlIdRecCheck(ccfc27si.getROWCCFC27SIG00_ARRAY().getROWCCFC27SIG00(usRow).getUlIdRecCheck());
            pCAUD87DInputRec.setUlIdRecCheckPerson(ccfc27si.getUlIdRecCheckPerson());
            pCAUD87DInputRec.setUlIdRecCheckRequestor(ccfc27si.getROWCCFC27SIG00_ARRAY().getROWCCFC27SIG00(usRow).getUlIdRecCheckRequestor());
            pCAUD87DInputRec.setUlIdStage(ccfc27si.getROWCCFC27SIG00_ARRAY().getROWCCFC27SIG00(usRow).getUlIdStage());
            
            //  Initialize Service Status Fields
            
            //  Perform Main Processing
            
            //  Set CCFC39SO WCD DtSystemDate to current date
            rc = caud87dAUDdam(sqlca, pCAUD87DInputRec, pCAUD87DOutputRec);
            
            
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    ccfc27so.setUlIdRecCheck(pCAUD87DOutputRec.getUlIdRecCheck());
                    break;
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                    break;
                case WtcHelperConstants.SQL_DUPLICATE_KEY:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_DUPLICATE_RECORD;
                    break;
                    // 
                    // There should be one row for every entry
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    break;
            }
            usRow++;
        }
        
        
        /*
        ** Load Translation Map
        */
        
        
        /*
        ** Stop Performance Timer
        */
        ARC_PRFServiceStopTime_TUX(ccfc27si.getArchInputStruct() , ccfc27so.getArchOutputStruct());
        /* ERR 1421: The following has been added to blank out the disposition.
        ** There is no switch statement because there are no acceptable errors.
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
        return ccfc27so;
    }

}
