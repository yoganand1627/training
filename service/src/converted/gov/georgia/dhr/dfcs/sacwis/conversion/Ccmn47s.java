package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN47SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN47SO;
import gov.georgia.dhr.dfcs.sacwis.service.person.Ccmn04u;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNC0DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNC0DO;
/**************************************************************************
** 
** Module File:   CCMN47S.src
**
** Service Name:  CCMN47S - RETRIEVE UNIT ID
**
** Description:   This service is designed to retrieve ID UNIT for a Parent
**                Unit, given CD UNIT PROGRAM, CD UNIT REGION, and NBR UNIT.
**                
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  24 Feb 1995 
** 
** Programmer:    KRD
** 
** DAMS           CCMNC0
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  8/6/96    zabihin  sir 21891 : version control line was missing, so 
**                      just added the line.
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Ccmn47s {
    CCMN47SO CCMN47S(CCMN47SI ccmn47si) {
        CCMN47SO ccmn47so = new CCMN47SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        int uCount = 0;/* loop variable */
        rc = ARC_PRFServiceStartTime_TUX(ccmn47si.getArchInputStruct());
        
        /*
        ** Call CDYN19D
        */
        rc = Ccmn04u.CallCCMNC0D(ccmn47si, ccmn47so, pServiceStatus);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                break;
                
            case Messages.MSG_CMN_INVALID_PARENT_UNIT:
                
                break;
                
            default :
                
                //## BEGIN TUX/XML: Declare XML variables 
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        
        /*
        ** Load translation map with service name and version 
        */
        
        /*
        ** Stop performance timer for service 
        */
        ARC_PRFServiceStopTime_TUX(ccmn47si.getArchInputStruct() , ccmn47so.getArchOutputStruct());
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
        return ccmn47so;
    }

    static int CallCCMNC0D(CCMN47SI pInputMsg344, CCMN47SO pOutputMsg314, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /* 
        ** Declare local variables
        */
        CCMNC0DI pCCMNC0DInputRec = null;
        CCMNC0DO pCCMNC0DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMNC0DInputRec = new CCMNC0DI();
        pCCMNC0DOutputRec = new CCMNC0DO();
        pCCMNC0DInputRec.setArchInputStruct(pInputMsg344.getArchInputStruct());
        pCCMNC0DInputRec.setSzCdUnitProgram(pInputMsg344.getSzCdUnitProgram());
        pCCMNC0DInputRec.setSzCdUnitRegion(pInputMsg344.getSzCdUnitRegion());
        pCCMNC0DInputRec.setSzNbrUnit(pInputMsg344.getSzNbrUnit());
        rc = ccmnc0dQUERYdam(sqlca, pCCMNC0DInputRec, pCCMNC0DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg314.setUlIdUnit(pCCMNC0DOutputRec.getUlIdUnit());
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_CMN_INVALID_PARENT_UNIT;
                rc = Messages.MSG_CMN_INVALID_PARENT_UNIT;
                break;// from for loop
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

}
