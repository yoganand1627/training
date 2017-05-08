package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN24SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN24SO;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN35DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN35DO;
/**************************************************************************
** 
** Module File:   CCMN24S.src
**
** Service Name:  CCMN24S - RETRIEVE UNIT LIST
**
** Description:   This service is designed to retrieve a list of units
**                from the database.  It is sent CD UNIT PROGRAM, CD
**                CD UNIT REGION, and NBR UNIT.  It returns data from
**                the PERSON and UNIT tables.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  03 February 1995
** 
** Programmer:    KRD
**
** DAMs Called:   CCMN35D  
**        
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  7/26/96    zabihin  sir 21891 : version control code was missing, I
**                      added the lines.
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
/*#include <sqlca.h>*/

/*
** Extern for version control table.
*/






public class Ccmn24s {
    CCMN24SO CCMN24S(CCMN24SI ccmn24si) {
        CCMN24SO ccmn24so = new CCMN24SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        rc = ARC_UTLCheckServiceBatchBlock("CCMN24S", pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
        int ulCount = 0;/* loop variable */
        rc = ARC_PRFServiceStartTime_TUX(ccmn24si.getArchInputStruct());
        rc = CallCCMN35D(ccmn24si, ccmn24so, pServiceStatus);
        switch (rc) {
            case Messages.MSG_CMN_INVALID_UNIT:
            case Messages.MSG_CMN_UNIT_LIST_INV:
                
                break;
            case WtcHelperConstants.SQL_SUCCESS:
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        
        /*
        ** Load translation map with service name and version 
        */
        
        /*
        ** Stop performance timer for service 
        */
        ARC_PRFServiceStopTime_TUX(ccmn24si.getArchInputStruct() , ccmn24so.getArchOutputStruct());
        
        
        
        
        /*
        ** SIR 14963
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
                
                //  Call DAM
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        return ccmn24so;
    }

    static int CallCCMN35D(CCMN24SI pInputMsg263, CCMN24SO pOutputMsg246, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i149 = 0;
        /*
        ** Declare local variables
        */
        CCMN35DI pCCMN35DInputRec = null;
        CCMN35DO pCCMN35DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN35DInputRec = new CCMN35DI();
        
        pCCMN35DOutputRec = new CCMN35DO();
        pCCMN35DInputRec.setSzCdUnitProgram(pInputMsg263.getSzCdUnitProgram());
        pCCMN35DInputRec.setSzCdUnitRegion(pInputMsg263.getSzCdUnitRegion());
        pCCMN35DInputRec.setSzNbrUnit(pInputMsg263.getSzNbrUnit());
        pCCMN35DInputRec.getArchInputStruct().setUsPageNbr(pInputMsg263.getArchInputStruct().getUsPageNbr());
        pCCMN35DInputRec.getArchInputStruct().setUlPageSizeNbr(pInputMsg263.getArchInputStruct().getUlPageSizeNbr());
        rc = ccmn35dQUERYdam(sqlca, pCCMN35DInputRec, pCCMN35DOutputRec);
        
        /* Analyze return code */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                //  Populate Output Message
                for (i149 = 0;i149 < pCCMN35DOutputRec.getArchOutputStruct().getUlRowQty();++i149) {
                    
                    
                    
                    
                    
                    
                    pOutputMsg246.getROWCCMN24SOG01_ARRAY().getROWCCMN24SOG01(i149).setSzCdUnitSpecialization(pCCMN35DOutputRec.getROWCCMN35DO_ARRAY().getROWCCMN35DO(i149).getSzCdUnitSpecialization());
                    pOutputMsg246.getROWCCMN24SOG01_ARRAY().getROWCCMN24SOG01(i149).setSzNbrUnit(pCCMN35DOutputRec.getROWCCMN35DO_ARRAY().getROWCCMN35DO(i149).getSzNbrUnit());
                    pOutputMsg246.getROWCCMN24SOG01_ARRAY().getROWCCMN24SOG01(i149).setUlIdUnit(pCCMN35DOutputRec.getROWCCMN35DO_ARRAY().getROWCCMN35DO(i149).getUlIdUnit());
                    pOutputMsg246.getROWCCMN24SOG01_ARRAY().getROWCCMN24SOG01(i149).setUlIdPerson(pCCMN35DOutputRec.getROWCCMN35DO_ARRAY().getROWCCMN35DO(i149).getUlIdPerson());
                    pOutputMsg246.getROWCCMN24SOG01_ARRAY().getROWCCMN24SOG01(i149).setSzNmPersonFull(pCCMN35DOutputRec.getROWCCMN35DO_ARRAY().getROWCCMN35DO(i149).getSzNmPersonFull());
                    pOutputMsg246.getROWCCMN24SOG01_ARRAY().getROWCCMN24SOG01(i149).setSzScrNbrUnitParent(pCCMN35DOutputRec.getROWCCMN35DO_ARRAY().getROWCCMN35DO(i149).getSzScrNbrUnitParent());
                }
                pOutputMsg246.getArchOutputStruct().setUlRowQty(pCCMN35DOutputRec.getArchOutputStruct().getUlRowQty());
                
                // 
                // Service Macro Definitions
                // 
                // Commented out on 5/15/95 becuase it is redundant to the service
                // front end
                // EXEC SQL INCLUDE sqlca;
                
                // 
                // Function Prototypes
                // 
                
                pOutputMsg246.getArchOutputStruct().setBMoreDataInd(pCCMN35DOutputRec.getArchOutputStruct().getBMoreDataInd());
                
                break;
                
            case NO_DATA_FOUND:
                //  If the Recommended Action = "Corrective Action" and the Corrective
                // Action field is not NULL
                if (pInputMsg263.getSzNbrUnit()[0] != null) {
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_CMN_INVALID_UNIT;
                    rc = Messages.MSG_CMN_INVALID_UNIT;
                }
                else {
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_CMN_UNIT_LIST_INV;
                    rc = Messages.MSG_CMN_UNIT_LIST_INV;
                }
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

}
