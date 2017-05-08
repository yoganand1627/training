package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN20SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN20SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD02DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD02DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
/**************************************************************************
** 
** Module File:    CFIN20S.src
**
** Service Name:   CFIN20S - Payment Approval List Save
**
** Description:   This service will save selected columns to the Invoice table.
**                The DAM will AUD the CD INVO APPROVED, ID PERSON and 
**                SYS TS LAST UPDATE columns to the Invoice table where
**                ID INVOICE == Host:ID INVOICE.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  11/21/95 
** 
** Programmer:    Diana L. Feller
**
** Archive Information: $Revision:   1.0  $
**                      $Date:   27 May 1996 17:53:46  $
**                      $Modtime:   08 May 1996 21:40:36  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  05/03/96  PHILLILH  SIR #20882 - Add dtDtInvoApprovalDate to the Service
**                      Input Message so that it can be saved to the Invoice
**                      table.
**
**  06/23/03  Srini     SIR 18479 - Changed the error handler PROCESS_TUX_RC_ERROR 
**						to PROCESS_TUX_RC_ERROR_NOFREE after the 
**						ARC_UTLCheckServiceBatchBlock so that it doesn't free the 
**						input and output objects before they are allocated
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cfin20s {
    CFIN20SO CFIN20S(CFIN20SI cfin20si) 
    {
        CFIN20SO cfin20so = new CFIN20SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        rc = ARC_UTLCheckServiceBatchBlock("CFIN20S", pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
        int i231 = 0;
        
        /*
        ** Declare FOUNDATION variables 
        */
        
        /*
        ** Declare local variables 
        */
        int usRow = 0;
        
        CAUD02DI pCAUD02DInputRec = null;
        CAUD02DO pCAUD02DOutputRec = null;
        rc = ARC_PRFServiceStartTime_TUX(cfin20si.getArchInputStruct());
        
        
        
        /*
        ** Initialize Service Status Fields 
        */
        
        
        
        /*
        ** Perform Main Processing
        */
        
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCAUD02DInputRec = new CAUD02DI();
        
        pCAUD02DOutputRec = new CAUD02DO();
        
        /*
        **  While more rows are selected in listbox and SysCdDataOutcome is not null
        */
        
        while ((usRow < cfin20si.getArchInputStruct().getUlPageSizeNbr()) && (WtcHelperConstants.SQL_SUCCESS == rc)) 
        {
            pCAUD02DInputRec.setArchInputStruct(cfin20si.getArchInputStruct());
            pCAUD02DInputRec.getArchInputStruct().setCReqFuncCd(cfin20si.getROWCFIN20SIG_ARRAY().getROWCFIN20SIG(usRow).getSzCdSysDataActionOutcome());
            pCAUD02DInputRec.setUlIdInvoInvoice(cfin20si.getROWCFIN20SIG_ARRAY().getROWCFIN20SIG(usRow).getUlIdInvoInvoice());
            pCAUD02DInputRec.setUlIdPerson(cfin20si.getROWCFIN20SIG_ARRAY().getROWCFIN20SIG(usRow).getUlIdPerson());
            pCAUD02DInputRec.setSzCdInvoApproved(cfin20si.getROWCFIN20SIG_ARRAY().getROWCFIN20SIG(usRow).getSzCdInvoApproved());
            pCAUD02DInputRec.setDtDtInvoApprovalDate(cfin20si.getROWCFIN20SIG_ARRAY().getROWCFIN20SIG(usRow).getDtDtInvoApprovalDate());
            pCAUD02DInputRec.setTsLastUpdate(cfin20si.getROWCFIN20SIG_ARRAY().getROWCFIN20SIG(usRow).getTsLastUpdate());
            rc = caud02dAUDdam(sqlca, pCAUD02DInputRec, pCAUD02DOutputRec);
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
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
            usRow++;
        }
        
        /*
        ** Load Translation Map
        */
        
        
        /*
        ** Stop Performance Timer
        */
        ARC_PRFServiceStopTime_TUX(cfin20si.getArchInputStruct() , cfin20so.getArchOutputStruct());
        
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
        return cfin20so;
    }

}
