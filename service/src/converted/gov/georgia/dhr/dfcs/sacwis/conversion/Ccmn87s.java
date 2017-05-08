package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN87SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN87SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNE2DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNE2DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
/**************************************************************************
** 
** Module File:   CCMN87S.src
**
** Service Name:  CCMN87S - VERIFY CODE1 CITY
**
** Description:   Retrieve counties linked to a Texas city.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  2/28/95 
** 
** Programmer:    RMR
**
** Archive Information: $Revision:   1.2  $
**                      $Date:   06 Aug 1996 11:21:42  $
**                      $Modtime:   05 Aug 1996 16:49:06  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  08/31/95    KRD     Modified due to data element name change of
**                      szAddrOfficeCity to szAddrMailCodeCity.  Required
**                      change to CallCCMNE2D().
**  7/26/96    zabihin  sir 21891 : version control code was missing, I
**                      just added the lines.
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






public class Ccmn87s {
    CCMN87SO CCMN87S(CCMN87SI ccmn87si) {
        CCMN87SO ccmn87so = new CCMN87SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        rc = ARC_UTLCheckServiceBatchBlock("CCMN87S", pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
        rc = ARC_PRFServiceStartTime_TUX(ccmn87si.getArchInputStruct());
        rc = CallCCMNE2D(ccmn87si, ccmn87so, pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        
        /*
        ** Load translation map with service name and version 
        */
        
        /*
        ** Stop performance timer for service 
        */
        ARC_PRFServiceStopTime_TUX(ccmn87si.getArchInputStruct() , ccmn87so.getArchOutputStruct());
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber());
        }
        else {
            
            
            // 
            // Analyze error code
            // 
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
        return ccmn87so;
    }

    static int CallCCMNE2D(CCMN87SI pInputMsg371, CCMN87SO pOutputMsg341, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int i181 = 0;
        int rc = 0;/* Return code */
        
        /* 
        ** Declare local variables
        */
        CCMNE2DI pCCMNE2DInputRec = null;
        CCMNE2DO pCCMNE2DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMNE2DInputRec = new CCMNE2DI();
        
        pCCMNE2DOutputRec = new CCMNE2DO();
        pCCMNE2DInputRec.setArchInputStruct(pInputMsg371.getArchInputStruct());
        pCCMNE2DInputRec.setSzAddrMailCodeCity(pInputMsg371.getCode1InStruct().getSzAddrCity() rc = ccmne2dQUERYdam(sqlca, pCCMNE2DInputRec, pCCMNE2DOutputRec));
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                
                //  Populate Output Message
                for (i181 = 0;i181 < pCCMNE2DOutputRec.getArchOutputStruct().getUlRowQty();i181++) {
                    pOutputMsg341.getCode1OutStruct_ARRAY().getCode1OutStruct(i181).setSzSysCode1CntyCode(pCCMNE2DOutputRec.getROWCCMNE2DO_ARRAY().getROWCCMNE2DO(i181).getSzSysCode1CntyCode()) };
                pOutputMsg341.getArchOutputStruct().setUlRowQty(pCCMNE2DOutputRec.getArchOutputStruct().getUlRowQty());
                
                pOutputMsg341.getArchOutputStruct().setBMoreDataInd(pCCMNE2DOutputRec.getArchOutputStruct().getBMoreDataInd());
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    
}
