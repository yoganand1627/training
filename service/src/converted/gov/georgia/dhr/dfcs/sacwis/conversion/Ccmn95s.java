package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN95SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN95SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS79DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS79DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS80DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS80DO;
/**************************************************************************
**
** Module File:    CCMN95S.src
**
** Service Name:   CCMN95S
**
** Description:   This service calls DAMS CLSS79D.pc and CLSS80D.pc
**                to retrieve from the Person_Race and Person_Ethnicity
**                tables.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  10/30/2000
**
** Programmer:    Smithal
**
** Archive Information: $Revision:   1.1  $
**                      $Date:   21 Nov 2000 15:44:10  $
**                      $Modtime:   21 Nov 2000 10:41:46  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  10/24/00 Smithal    Initial Release
**  02/18/03 WEBSTED	REMOVED KRDs return of sizeof(CCMN95) as an rc
**			to make it work with impact
**  02/26/03 WEBSTED    got rid of the ulRowQty reset so that it would not 
**                      overwrite the number of races returned;
**                      changed it so that it only marshals one ethnicity
**                      so that there can be multiple races marshalled
**                      using ulRowQty
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Ccmn95s {
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final String CLOSED = "CLD";
    CCMN95SO CCMN95S(CCMN95SI ccmn95si) {
        CCMN95SO ccmn95so = new CCMN95SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code  */
        int i182 = 0;
        rc = ARC_PRFServiceStartTime_TUX(ccmn95si.getArchInputStruct());
        rc = Ccmn04s.CallCLSS79D(ccmn95si, ccmn95so, pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        rc = Ccmn04s.CallCLSS80D(ccmn95si, ccmn95so, pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        
        /*krd2000
        **let's see what happens
        */
        /*
        ** 18 Feb 2003, WEBSTED
        ** It breaks IMPACT, thats what
        ** rc = sizeof(_CCMN95SO);
        */
        
        /* *pOutputMsgSize = sizeof(_ARCHOUTPUTSTRUCT) +
        **         pOutputMsg->ArchOutputStruct.ulRowQty *
        **         sizeof(_CCMN95SO);
        */
        
        /*
        ** Load Translation Map
        */
        
        
        /*
        ** Stop Performance Timer
        */
        ARC_PRFServiceStopTime_TUX(ccmn95si.getArchInputStruct() , ccmn95so.getArchOutputStruct());
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber());
        }
        else {
            
            //  If the Services saves were successful retrieva
            // all of the counties for the previous version and
            // save them for the new version
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
        return ccmn95so;
    }

    static int CallCLSS79D(CCMN95SI pInputMsg374, CCMN95SO pOutputMsg344, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i183 = 0;
        
        CLSS79DI pCLSS79DInputRec = null;
        CLSS79DO pCLSS79DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCLSS79DInputRec = new CLSS79DI();
        
        pCLSS79DOutputRec = new CLSS79DO();
        pCLSS79DInputRec.setArchInputStruct(pInputMsg374.getArchInputStruct());
        pCLSS79DInputRec.setUlIdPerson(pInputMsg374.getUlIdPerson());
        rc = clss79dQUERYdam(sqlca, pCLSS79DInputRec, pCLSS79DOutputRec);
        
        if (rc != 0) {
            
            switch (rc) {
                case NO_DATA_FOUND:
                    pOutputMsg344.getArchOutputStruct().setUlRowQty(0);
                    
                    //  Call CSES01D.  The Contract Period Rtrv DAM receives IdContract 
                    // and NbrCnperPeriod for the previous period and returns all columns
                    // for the latest contract version record in the Contract Version table.
                    rc = 0;
                    break;
                case Arcutls.ARC_UTL_GENERAL_FAILURE:
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        
        else {
            
            //  Populate Output Message
            
            for (i183 = 0;i183 < pCLSS79DOutputRec.getArchOutputStruct().getUlRowQty();++i183) {
                pOutputMsg344.getROWCCMN95SOG00_ARRAY().getROWCCMN95SOG00(i183).setSzCdPersonRace(pCLSS79DOutputRec.getROWCLSS79DO_ARRAY().getROWCLSS79DO(i183).getSzCdPersonRace());
            }
            pOutputMsg344.getArchOutputStruct().setUlRowQty(pCLSS79DOutputRec.getArchOutputStruct().getUlRowQty());
            pOutputMsg344.getArchOutputStruct().setBMoreDataInd(pCLSS79DOutputRec.getArchOutputStruct().getBMoreDataInd());
        }
        return WtcHelperConstants.ARC_SUCCESS;
    }

    static int CallCLSS80D(CCMN95SI pInputMsg375, CCMN95SO pOutputMsg345, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int i184 = 0;
        
        CLSS80DI pCLSS80DInputRec = null;
        CLSS80DO pCLSS80DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCLSS80DInputRec = new CLSS80DI();
        
        pCLSS80DOutputRec = new CLSS80DO();
        pCLSS80DInputRec.setArchInputStruct(pInputMsg375.getArchInputStruct());
        pCLSS80DInputRec.setUlIdPerson(pInputMsg375.getUlIdPerson());
        
        
        
        /*
        ** Start Performance Timer
        */
        rc = clss80dQUERYdam(sqlca, pCLSS80DInputRec, pCLSS80DOutputRec);
        
        if (rc != 0) {
            switch (rc) {
                case NO_DATA_FOUND:
                    rc = 0;
                    break;
                case Arcutls.ARC_UTL_GENERAL_FAILURE:
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        
        else {
            
            //  Populate Output Message
            
            for (i184 = 0;i184 < pCLSS80DOutputRec.getArchOutputStruct().getUlRowQty();++i184) {
                pOutputMsg345.getROWCCMN95SOG01_ARRAY().getROWCCMN95SOG01(i184).setSzCdPersonEthnicity(pCLSS80DOutputRec.getROWCLSS80DO_ARRAY().getROWCLSS80DO(i184).getSzCdPersonEthnicity());
            }
            //   PROCESS_TUX_SQL_ERROR is called only when there is an unexpected
            // SQL error returned from the DAM.
            pOutputMsg345.getArchOutputStruct().setBMoreDataInd(pCLSS80DOutputRec.getArchOutputStruct().getBMoreDataInd());
        }
        return WtcHelperConstants.ARC_SUCCESS;
    }

}
