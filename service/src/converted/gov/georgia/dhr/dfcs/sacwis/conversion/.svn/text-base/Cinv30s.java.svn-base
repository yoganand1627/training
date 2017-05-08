package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV30SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV30SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV46DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV46DO;
/**************************************************************************
** 
** Module File:   CINV30S.src
**
** Service Name:  CINV30S
**
** Description:   Person Address, Person Phone
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  02/10/95 
** 
** Programmer:    ALIAM
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  07/26/96   zabihin  sir 21891 : version control code was missing, I
**                      added the lines.
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cinv30s {
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final int SQL_NOT_FOUND = 1403;
    CINV30SO CINV30S(CINV30SI cinv30si) {
        CINV30SO cinv30so = new CINV30SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        rc = ARC_PRFServiceStartTime_TUX(cinv30si.getArchInputStruct());
        rc = CallCINV46D(cinv30si, cinv30so, pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        
        /*
        ** Load translation map with service name and version 
        */
        
        /*
        ** Stop performance timer for service 
        */
        ARC_PRFServiceStopTime_TUX(cinv30si.getArchInputStruct() , cinv30so.getArchOutputStruct());
        //## END TUX/XML: Turn the XML buffer into an input message struct 
        
        
        
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
        return cinv30so;
    }

    static int CallCINV46D(CINV30SI pInputMsg702, CINV30SO pOutputMsg652, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /* 
        ** Declare local variables
        */
        CINV46DI pCINV46DInputRec = null;
        CINV46DO pCINV46DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV46DInputRec = new CINV46DI();
        
        pCINV46DOutputRec = new CINV46DO();
        pCINV46DInputRec.setUlIdPerson(pInputMsg702.getUlIdPerson());
        rc = cinv46dQUERYdam(sqlca, pCINV46DInputRec, pCINV46DOutputRec);
        if (rc != 0) {
            
            
            //  Analyze return code
            switch (rc) {
                case NO_DATA_FOUND:
                    rc = SUCCESS;
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        
        else {
            pOutputMsg652.setSzAddrProfAssmtCity(pCINV46DOutputRec.getSzAddrCity());
            pOutputMsg652.setSzAddrProfAssmtStLn1(pCINV46DOutputRec.getSzAddrPersAddrStLn1());
            pOutputMsg652.setSzAddrProfAssmtStLn2(pCINV46DOutputRec.getSzAddrPersAddrStLn2());
            pOutputMsg652.setSzAddrProfAssmtZip(pCINV46DOutputRec.getLAddrZip());
            pOutputMsg652.setSzCdProfAssmtCounty(pCINV46DOutputRec.getSzCdAddrCounty());
            pOutputMsg652.setSzAddrProfAssmtState(pCINV46DOutputRec.getSzCdAddrState());
            pOutputMsg652.setLNbrPhone(pCINV46DOutputRec.getLNbrPhone());
            pOutputMsg652.setLNbrPhoneExtension(pCINV46DOutputRec.getLNbrPhoneExtension());
            pOutputMsg652.getArchOutputStruct().setUlRowQty(pCINV46DOutputRec.getArchOutputStruct().getUlRowQty());
        }
        return rc;
    }

}
