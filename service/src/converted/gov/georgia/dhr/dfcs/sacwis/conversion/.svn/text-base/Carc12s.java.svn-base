package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CARC12SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CARC12SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS12DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS12DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
/**************************************************************************
**
** Module File:    CARC12S.src
**
** Service Name:   CARC12S
**
** Description:   The Security Class retrieval will retrieve all rows from
**                the SECURITY CLASS table.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  26-OCT-95
**
** Programmer:    adkinsmc
**
** Archive Information: $Revision:   1.1  $
**                      $Date:   03 Sep 1999 08:27:38  $
**                      $Modtime:   02 Sep 1999 17:45:20  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  04/18/01  thompswa  SECURITY UPGRADE:  cIndRestrict passes IND_RESTRICT
**                      in the SECURITY_CLASS table from the retrieve service
**                      back to the Security Profile Maintenance Window.
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/





public class Carc12s {
    CARC12SO CARC12S(CARC12SI carc12si) {
        CARC12SO carc12so = new CARC12SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        int i7 = 0;
        
        /*
        ** Declare FOUNDATION variables
        */
        
        /*
        ** Declare local variables
        */
        //##  long            rc = 0;
        
        CLSS12DI pCLSS12DInputRec = null;
        CLSS12DO pCLSS12DOutputRec = null;
        
        
        /*
        ** Call CINV43D
        */
        rc = ARC_PRFServiceStartTime_TUX(carc12si.getArchInputStruct());
        
        
        
        /*
        ** Initialize Service Status Fields
        */
        
        
        
        /*
        ** Perform Main Processing
        */
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCLSS12DInputRec = new CLSS12DI();
        
        pCLSS12DOutputRec = new CLSS12DO();
        pCLSS12DInputRec.setArchInputStruct(carc12si.getArchInputStruct());
        pCLSS12DInputRec.getArchInputStruct().setUsPageNbr(carc12si.getArchInputStruct().getUsPageNbr());
        pCLSS12DInputRec.getArchInputStruct().setUlPageSizeNbr(carc12si.getArchInputStruct().getUlPageSizeNbr());
        rc = clss12dQUERYdam(sqlca, pCLSS12DInputRec, pCLSS12DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                
                
                //  Populate Output Message
                
                //  Set fields in CARC12SOG00 to fields in CLSS12DOG00
                
                
                for (i7 = 0;i7 < pCLSS12DOutputRec.getArchOutputStruct().getUlRowQty();i7++) {
                    
                    carc12so.getROWCARC12SOG00_ARRAY().getROWCARC12SOG00(i7).setSzNmSecurityClass(pCLSS12DOutputRec.getROWCLSS12DO_ARRAY().getROWCLSS12DO(i7).getSzNmSecurityClass());
                    carc12so.getROWCARC12SOG00_ARRAY().getROWCARC12SOG00(i7).setSzTxtSecurityClassProfil(pCLSS12DOutputRec.getROWCLSS12DO_ARRAY().getROWCLSS12DO(i7).getSzTxtSecurityClassProfil());
                    carc12so.getROWCARC12SOG00_ARRAY().getROWCARC12SOG00(i7).setTsLastUpdate(pCLSS12DOutputRec.getROWCLSS12DO_ARRAY().getROWCLSS12DO(i7).getTsLastUpdate());
                    carc12so.getROWCARC12SOG00_ARRAY().getROWCARC12SOG00(i7).setCIndRestrict(pCLSS12DOutputRec.getROWCLSS12DO_ARRAY().getROWCLSS12DO(i7).getCIndRestrict());
                }
                carc12so.getArchOutputStruct().setBMoreDataInd(pCLSS12DOutputRec.getArchOutputStruct().getBMoreDataInd());
                carc12so.getArchOutputStruct().setUlRowQty(pCLSS12DOutputRec.getArchOutputStruct().getUlRowQty());
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
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
        ARC_PRFServiceStopTime_TUX(carc12si.getArchInputStruct() , carc12so.getArchOutputStruct());
        
        //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo
        /* 01/22/2003 DWW: Added for error handling */
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
                
                //  Call DAM: This DAM will add/update/delete a full row to RECORDS_CHECK
                // table. It will take as input an ID_REC_CHECK
                // NOTE: does not insert or update a value for case id
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        return carc12so;
    }

}
