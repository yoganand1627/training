package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN26SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN26SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN52DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN52DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
/**************************************************************************
** 
** Module File:   CCMN26S.src
**
** Service Name:  CCMN26S
**
** Description:   Updates the IND STAGE PERS EMP NEW field in the 
**        STAGE PERSON LINK table for a certain person 
**        and a certain STAGE.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  01/07/95 
** 
** Programmer:    Alex Ramirez/Mary Sladewski
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**                
**  7/26/96    zabihin  sir 21891 : version control code was missing, I
**                       added the lines.
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/


/*
** Extern for version control table.
*/






public class Ccmn26s {
    CCMN26SO CCMN26S(CCMN26SI ccmn26si) {
        CCMN26SO ccmn26so = new CCMN26SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        
        /*
        ** Call CMSC46D
        */
        rc = ARC_PRFServiceStartTime_TUX(ccmn26si.getArchInputStruct());
        
        if (ccmn26si.getROWCCMN52DI_ARRAY().getROWCCMN52DI(0).getUlIdStage() != 0) {
            rc = Ccmn14s.CallCCMN52D(ccmn26si, ccmn26so, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        
        /*
        ** Load translation map with service name and version 
        */
        
        /*
        ** Stop performance timer for service 
        */
        ARC_PRFServiceStopTime_TUX(ccmn26si.getArchInputStruct() , ccmn26so.getArchOutputStruct());
        
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
        return ccmn26so;
    }

    
    static int CallCCMN52D(CCMN26SI pInputMsg274, CCMN26SO * pOutputMsg257, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int i150 = 0;
        int rc = 0;/* Return code */
        CCMN52DI pCCMN52DInputRec = null;
        CCMN52DO pCCMN52DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN52DInputRec = new CCMN52DI();
        
        pCCMN52DOutputRec = new CCMN52DO();
        pCCMN52DInputRec.setUlIdPerson(pInputMsg274.getUlIdPerson());
        pCCMN52DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        
        for (i150 = 0;((pInputMsg274.getROWCCMN52DI_ARRAY().getROWCCMN52DI(i150).getUlIdStage() != 0) && (i150 < CCMN26SI._CCMN26SI__ROWCCMN52DI_SIZE));i150++) {
            pCCMN52DInputRec.setUlIdStage(pInputMsg274.getROWCCMN52DI_ARRAY().getROWCCMN52DI(i150).getUlIdStage());
            pCCMN52DInputRec.setTsLastUpdate(pInputMsg274.getROWCCMN52DI_ARRAY().getROWCCMN52DI(i150).getTsLastUpdate());
            rc = ccmn52dAUDdam(sqlca, pCCMN52DInputRec, pCCMN52DOutputRec);
            
            //  Analyze return code
            switch (rc) {
                case SUCCESS:
                    break;
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                    
                    
                    //  Initialize rc for loop
                    rc = SUCCESS;
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        return rc;
        
    }

}
