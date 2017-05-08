package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN09SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN09SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS03DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS03DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
/**************************************************************************
** 
** Module File:    CFIN09S.src
**
** Service Name:   CFIN09S
**
** Description:  This service will retrieve selected columns for static
**               search criteria from the Rejection Reason table. The
**               service will pass CD REJ RSN REJ ITEM ID and 
**               ID REJECTED ITEM into the DAM.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  November 13, 1995
** 
** Programmer:    Kristi Bradford
**
** Archive Information: $Revision:   1.0  $
**                      $Date:   27 May 1996 17:24:30  $
**                      $Modtime:   30 Mar 1996 00:12:04  $
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






public class Cfin09s {
    CFIN09SO CFIN09S(CFIN09SI cfin09si) {
        CFIN09SO cfin09so = new CFIN09SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        //## END TUX/XML: Declare XML variables
        
        int rc = FND_SUCCESS;
        int i226 = 0;
        
        /*
        ** Declare FOUNDATION variables 
        */
        
        /*
        ** Declare local variables 
        */
        
        CLSS03DI pCLSS03DInputRec = null;
        CLSS03DO pCLSS03DOutputRec = null;
        
        rc = ARC_PRFServiceStartTime_TUX(cfin09si.getArchInputStruct());
        
        
        
        /*
        ** Initialize Service Status Fields 
        */
        
        
        
        /*
        ** Perform Main Processing
        */
        
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCLSS03DInputRec = new CLSS03DI();
        
        pCLSS03DOutputRec = new CLSS03DO();
        pCLSS03DInputRec.setArchInputStruct(cfin09si.getArchInputStruct());
        pCLSS03DInputRec.setSzCdRejRsnRejItemId(cfin09si.getSzCdRejRsnRejItemId());
        pCLSS03DInputRec.setUlIdRejectedItemId(cfin09si.getUlIdRejectedItemId());
        pCLSS03DInputRec.getArchInputStruct().setUsPageNbr(cfin09si.getArchInputStruct().getUsPageNbr());
        pCLSS03DInputRec.getArchInputStruct().setUlPageSizeNbr(cfin09si.getArchInputStruct().getUlPageSizeNbr());
        
        /*
        ** Call CAUD08D The Contract County AUD performs a full row insert,
        ** update or delete to the Contract County table.
        */
        rc = clss03dQUERYdam(sqlca, pCLSS03DInputRec, pCLSS03DOutputRec);
        
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                
                
                //  Populate Output Message
                
                //  Set fields in CFIN09SO to fields in CLSS03DO
                
                // *
                // Note: Remove the "for" loop when necessary
                
                for (i226 = 0;i226 < pCLSS03DOutputRec.getArchOutputStruct().getUlRowQty();i226++) {
                    cfin09so.getROWCFIN09SOG00_ARRAY().getROWCFIN09SOG00(i226).setSzCdRejRsn(pCLSS03DOutputRec.getROWCLSS03DO_ARRAY().getROWCLSS03DO(i226).getSzCdRejRsn());
                }
                cfin09so.getArchOutputStruct().setBMoreDataInd(pCLSS03DOutputRec.getArchOutputStruct().getBMoreDataInd());
                cfin09so.getArchOutputStruct().setUlRowQty(pCLSS03DOutputRec.getArchOutputStruct().getUlRowQty());
                
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_DETAIL_DELETED;
                rc = WtcHelperConstants.ARC_SUCCESS;
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
        ARC_PRFServiceStopTime_TUX(cfin09si.getArchInputStruct() , cfin09so.getArchOutputStruct());
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber());
        }
        else {
            
            //  Analyze error code
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
        return cfin09so;
    }

}
