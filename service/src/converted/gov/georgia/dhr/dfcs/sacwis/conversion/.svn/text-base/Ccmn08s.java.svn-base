package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN08SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN08SO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN34DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN34DO;
/**************************************************************************
** 
** Module File:   CCMN08S.src
**
** Service Name:  CCMN08S
**
** Description:   Retrieve Unit supervisor's name
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  1/25/95 
** 
** Programmer:    Karl R. Dalley / Ramani Vishnubhotla
**
** Archive Information: $Revision:   1.2  $
**                      $Date:   06 Aug 1996 11:21:14  $
**                      $Modtime:   05 Aug 1996 16:49:02  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  04/25/95    KRD     Corrections prior to Technical Code Review to 
**                      clean up code and meet standards   .
**  05/09/95    KRD     Fixes to meet new error handling.
**  06/20/95    KRD     Corrections due to Technical Code Review.
**  7/26/96    zabihin  sir 21891 : version control code was missing, I
**                       added the lines.
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Ccmn08s {
    CCMN08SO CCMN08S(CCMN08SI ccmn08si) {
        CCMN08SO ccmn08so = new CCMN08SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        rc = ARC_PRFServiceStartTime_TUX(ccmn08si.getArchInputStruct());
        
        /*
        ** Call DAM
        */
        rc = CallCCMN34D(ccmn08si, ccmn08so, pServiceStatus);
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.ARC_SUCCESS:
            case Messages.MSG_CMN_INVALID_UNIT:
                
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
        ARC_PRFServiceStopTime_TUX(ccmn08si.getArchInputStruct() , ccmn08so.getArchOutputStruct());
        
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
        return ccmn08so;
    }

    static int CallCCMN34D(CCMN08SI pInputMsg222, CCMN08SO pOutputMsg203, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        CCMN34DI pCCMN34DInputRec = null;/* Input Copybook  */
        CCMN34DO pCCMN34DOutputRec = null;/* Output Copybook */
        
        /* 
        ** Declare local variables
        */
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN34DInputRec = new CCMN34DI();
        
        pCCMN34DOutputRec = new CCMN34DO();
        pCCMN34DInputRec.setSzCdUnitProgram(pInputMsg222.getSzCdUnitProgram());
        pCCMN34DInputRec.setSzCdUnitRegion(pInputMsg222.getSzCdUnitRegion());
        pCCMN34DInputRec.setSzNbrUnit(pInputMsg222.getSzNbrUnit());
        pCCMN34DInputRec.setArchInputStruct(pInputMsg222.getArchInputStruct());
        rc = ccmn34dQUERYdam(sqlca, pCCMN34DInputRec, pCCMN34DOutputRec);
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg203.setSzCdUnitProgram(pCCMN34DOutputRec.getSzCdUnitProgram());
                pOutputMsg203.setSzCdUnitRegion(pCCMN34DOutputRec.getSzCdUnitRegion());
                pOutputMsg203.setSzNbrUnit(pCCMN34DOutputRec.getSzNbrUnit());
                pOutputMsg203.setUlIdUnit(pCCMN34DOutputRec.getUlIdUnit());
                pOutputMsg203.setUlIdPerson(pCCMN34DOutputRec.getUlIdPerson());
                pOutputMsg203.setSzNmPersonFull(pCCMN34DOutputRec.getSzNmPersonFull());
                pOutputMsg203.setTsLastUpdate(pCCMN34DOutputRec.getTsLastUpdate());
                
                
                //  Call CINT40D
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_WARNING;
                pServiceStatus.explan_code = Messages.MSG_CMN_INVALID_UNIT;
                rc = Messages.MSG_CMN_INVALID_UNIT;
                
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                
                break;
        }
        return rc;
    }

}
