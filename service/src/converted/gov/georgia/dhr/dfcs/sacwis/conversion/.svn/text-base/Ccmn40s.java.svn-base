package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN40SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN40SO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNA5DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNA5DO;
/**************************************************************************
** 
** Module File:   CCMN40S.src
**
** Service Name:  CCMN40S
**
** Description:   Retrieves the Office name
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  02/06/95 
** 
** Programmer:    Karl R. Dalley / Ramani Vishnubhotla
**
** Archive Information: $Revision:   1.2  $
**                      $Date:   06 Aug 1996 11:21:36  $
**                      $Modtime:   05 Aug 1996 16:49:04  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  04/25/95    KRD     Corrections prior to Technical Code Review to 
**                      clean up code and meet standards.
**  05/09/95    KRD     Fixes to meet new error handling.
**  06/20/95    KRD     Corrections due to Technical Code Review.
**  09/26/95    KRD     SIR 1456 - Modified CallCCMNA5D() due to addition
**                      of CD OFFICE REGION to the input record of CCMNA5D
**                      and the service input message.
**  7/26/96    zabihin  sir 21891 : version control code was missing, I 
**                       added the line.
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Ccmn40s {
    CCMN40SO CCMN40S(CCMN40SI ccmn40si) {
        CCMN40SO ccmn40so = new CCMN40SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        
        /*
        ** Declare local variables
        */
        int rc = FND_SUCCESS;
        
        
        /*
        ** Call CLSS11D in order to retrieve the service line
        ** information corresponding to the previous version.
        */
        rc = ARC_PRFServiceStartTime_TUX(ccmn40si.getArchInputStruct());
        
        /*
        ** Call CLSS11D to retrieve current version information
        */
        rc = CallCCMNA5D(ccmn40si, ccmn40so, pServiceStatus);
        
        switch (rc) {
            case WtcHelperConstants.ARC_SUCCESS:
            case Messages.MSG_CMN_INVALID_OFFICE:
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                break;
        }
        
        /*
        ** Load translation map with service name and version 
        */
        
        /*
        ** Stop performance timer for service 
        */
        ARC_PRFServiceStopTime_TUX(ccmn40si.getArchInputStruct() , ccmn40so.getArchOutputStruct());
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
        return ccmn40so;
    }

    static int CallCCMNA5D(CCMN40SI pInputMsg338, CCMN40SO pOutputMsg308, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        CCMNA5DI pCCMNA5DInputRec = null;/* Input Copybook  */
        CCMNA5DO pCCMNA5DOutputRec = null;/* Output Copybook */
        
        /* 
        ** Declare local variables
        */
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMNA5DInputRec = new CCMNA5DI();
        
        pCCMNA5DOutputRec = new CCMNA5DO();
        pCCMNA5DInputRec.setArchInputStruct(pInputMsg338.getArchInputStruct());
        
        pCCMNA5DInputRec.setSzCdOfficeProgram(pInputMsg338.getSzCdOfficeProgram());
        pCCMNA5DInputRec.setSzAddrMailCode(pInputMsg338.getSzAddrMailCode());
        pCCMNA5DInputRec.setSzCdOfficeRegion(pInputMsg338.getSzCdOfficeRegion());
        rc = ccmna5dQUERYdam(sqlca, pCCMNA5DInputRec, pCCMNA5DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg308.setUlIdOffice(pCCMNA5DOutputRec.getUlIdOffice());
                pOutputMsg308.setSzNmOfficeName(pCCMNA5DOutputRec.getSzNmOfficeName());
                
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_CMN_INVALID_OFFICE;
                rc = Messages.MSG_CMN_INVALID_OFFICE;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

}
