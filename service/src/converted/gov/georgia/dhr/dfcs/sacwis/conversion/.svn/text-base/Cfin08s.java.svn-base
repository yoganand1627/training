package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN08SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN08SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES04DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES04DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN44DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN44DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
/**************************************************************************
** 
** Module File:   CFIN08S.src
**
** Service Name:  CFIN08S- Foster Care Detail Validation
**
** Description:   This service will retrieve the name of a person from the 
**                PERSON table given the ID PERSON.  Additionally, the service
**                will retrieve the ACCLAIM NBR from the RESOURCE table given
**                the ID RESOURCE.  Indicators will be passed in to determine
**                which DAM to call- one or both
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  12-01-1995
** 
** Programmer:    Tyler L. Chessman
**
** Archive Information: $Revision:   1.0  $
**                      $Date:   27 May 1996 17:22:32  $
**                      $Modtime:   30 Mar 1996 00:11:50  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
** 01/23/03   Srini D   Commenting out the check for TRUE == pInputMsg->WcdIndRsrcChng
**						as per Anna's request on line's 243 and 390. 
** 
** 01/29/03  Srini D    Rolling back the previous change and setting INDICATOR_YES 
**						instead of TRUE
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cfin08s {
    CFIN08SO CFIN08S(CFIN08SI cfin08si) {
        CFIN08SO cfin08so = new CFIN08SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        int i225 = 0;
        
        /*
        ** Declare FOUNDATION variables 
        */
        
        /*
        ** Declare local variables 
        */
        
        CRES04DI pCRES04DInputRec = null;
        CRES04DO pCRES04DOutputRec = null;
        CCMN44DI pCCMN44DInputRec = null;
        CCMN44DO pCCMN44DOutputRec = null;
        rc = ARC_PRFServiceStartTime_TUX(cfin08si.getArchInputStruct());
        if (INDICATOR_YES == cfin08si.getWcdIndPrsnChng()) {
            
            //  Allocate memory for DAM Input and Output Structures
            pCCMN44DInputRec = new CCMN44DI();
            
            pCCMN44DOutputRec = new CCMN44DO();
            pCCMN44DInputRec.setArchInputStruct(cfin08si.getArchInputStruct());
            pCCMN44DInputRec.setUlIdPerson(cfin08si.getUlIdPerson());
            rc = ccmn44dQUERYdam(sqlca, pCCMN44DInputRec, pCCMN44DOutputRec);
            
            
            //  Analyze return code
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    cfin08so.setSzNmPersonFull(pCCMN44DOutputRec.getSzNmPersonFull());
                    break;
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = Messages.SSM_FIN_INVALID_PRSN_ID;
                    rc = Messages.SSM_FIN_INVALID_PRSN_ID;
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    break;
            }
        }
        if ((INDICATOR_YES == cfin08si.getWcdIndRsrcChng()) && (WtcHelperConstants.SQL_SUCCESS == rc)) {
            //  Allocate memory for DAM Input and Output Structures
            pCRES04DInputRec = new CRES04DI();
            
            pCRES04DOutputRec = new CRES04DO();
            pCRES04DInputRec.setArchInputStruct(cfin08si.getArchInputStruct());
            pCRES04DInputRec.setUlIdResource(cfin08si.getUlIdResource());
            
            //  Call DAM
            rc = cres04dQUERYdam(sqlca, pCRES04DInputRec, pCRES04DOutputRec);
            
            
            //  Analyze return code
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    cfin08so.setLNbrRsrcFacilAcclaim(pCRES04DOutputRec.getLNbrRsrcFacilAcclaim());
                    break;
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = Messages.SSM_FIN_INVALID_RSRC_ID;
                    //  Do nothing, the output message just returns success or failure
                    rc = Messages.SSM_FIN_INVALID_RSRC_ID;
                    
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    break;
            }
        }
        
        /*
        ** Load Translation Map
        */
        
        
        /*
        ** Stop Performance Timer
        */
        ARC_PRFServiceStopTime_TUX(cfin08si.getArchInputStruct() , cfin08so.getArchOutputStruct());
        
        /*
        ** Analyze error code
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
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        return cfin08so;
    }

}
