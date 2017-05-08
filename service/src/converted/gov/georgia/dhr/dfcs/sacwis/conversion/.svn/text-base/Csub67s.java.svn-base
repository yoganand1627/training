package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB67SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB67SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT40DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT40DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN45DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN45DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
/**************************************************************************
** 
** Module File:    CSUB67S.src
**
** Service Name:   CSUB67S
**
** Description:   This service retrieves the Event row and Stage row
**                for a closure event given IdEvent and IdStage
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  8 December 1995 
** 
** Programmer:    Greg Dyar
**
** Archive Information: $Revision:   1.0  $
**                      $Date:   27 May 1996 19:20:18  $
**                      $Modtime:   30 Mar 1996 00:27:54  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
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






public class Csub67s {
    CSUB67SO CSUB67S(CSUB67SI csub67si) {
        CSUB67SO csub67so = new CSUB67SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        //## END TUX/XML: Declare XML variables
        
        int rc = FND_SUCCESS;
        rc = ARC_UTLCheckServiceBatchBlock("CSUB67S", pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
        int i436 = 0;
        
        /*
        ** Declare FOUNDATION variables 
        */
        
        /*
        ** Declare local variables 
        */
        
        CINT40DI pCINT40DInputRec = null;
        CINT40DO pCINT40DOutputRec = null;
        
        CCMN45DI pCCMN45DInputRec = null;
        CCMN45DO pCCMN45DOutputRec = null;/* pointer to DAM output record  */
        
        /*
        ** Declare FOUNDATION variables
        */
        
        /*
        ** Declare local variables
        */
        
        
        
        /*
        ** Start performance timer for service
        */
        rc = ARC_PRFServiceStartTime_TUX(csub67si.getArchInputStruct());
        rc = ARC_UTLGetDateAndTime(csub67so.getDtWCDDtSystemDate() , 0);
        
        //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        
        
        /**************************************************************************
        ** (BEGIN): Stage Retrieval CINT40D
        **************************************************************************/
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCINT40DInputRec = new CINT40DI();
        
        pCINT40DOutputRec = new CINT40DO();
        pCINT40DInputRec.setArchInputStruct(csub67si.getArchInputStruct());
        
        //## BEGIN TUX/XML: Declare XML variables
        pCINT40DInputRec.setUlIdStage(csub67si.getUlIdStage());
        rc = cint40dQUERYdam(sqlca, pCINT40DInputRec, pCINT40DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                csub67so.getROWCSUB67SOG01().setSzCdStage(pCINT40DOutputRec.getSzCdStage());
                csub67so.getROWCSUB67SOG01().setUlIdStage(pCINT40DOutputRec.getUlIdStage());
                csub67so.getROWCSUB67SOG01().setUlIdCase(pCINT40DOutputRec.getUlIdCase());
                csub67so.getROWCSUB67SOG01().setSzCdStageType(pCINT40DOutputRec.getSzCdStageType());
                csub67so.getROWCSUB67SOG01().setSzCdStageProgram(pCINT40DOutputRec.getSzCdStageProgram());
                csub67so.getROWCSUB67SOG01().setSzNmStage(pCINT40DOutputRec.getSzNmStage());
                
                //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo
                
                csub67so.getROWCSUB67SOG01().setTsLastUpdate(pCINT40DOutputRec.getTsLastUpdate());
                csub67so.getROWCSUB67SOG01().setSzCdStageReasonClosed(pCINT40DOutputRec.getSzCdStageReasonClosed());
                csub67so.getROWCSUB67SOG01().setSzTxtStageClosureCmnts(pCINT40DOutputRec.getSzTxtStageClosureCmnts());
                csub67so.getROWCSUB67SOG01().setDtDtStageClose(pCINT40DOutputRec.getDtDtStageClose());
                
                if (0 != csub67si.getUlIdEvent()) {
                    
                    
                    
                    //  Initialize Service Status Fields
                    
                    
                    // 
                    // (BEGIN): CCMN45D
                    // 
                    
                    //  Allocate memory for DAM Input and Output Structures
                    pCCMN45DInputRec = new CCMN45DI();
                    
                    pCCMN45DOutputRec = new CCMN45DO();
                    pCCMN45DInputRec.setArchInputStruct(csub67si.getArchInputStruct());
                    pCCMN45DInputRec.setUlIdEvent(csub67si.getUlIdEvent());
                    
                    //  Call CheckStageEventStatus
                    rc = ccmn45dQUERYdam(sqlca, pCCMN45DInputRec, pCCMN45DOutputRec);
                    switch (rc) {
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            
                            // 
                            // Service Macro Definitions
                            // 
                            
                            // 
                            // Function Prototypes
                            // 
                            csub67so.getROWCSUB67SOG00().setSzCdTask(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdTask());
                            csub67so.getROWCSUB67SOG00().setTsLastUpdate(pCCMN45DOutputRec.getROWCCMN45DO().getTsLastUpdate());
                            csub67so.getROWCSUB67SOG00().setSzCdEventStatus(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdEventStatus());
                            csub67so.getROWCSUB67SOG00().setSzCdEventType(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdEventType());
                            csub67so.getROWCSUB67SOG00().setDtDtEventOccurred(pCCMN45DOutputRec.getROWCCMN45DO().getDtDtEventOccurred());
                            
                            //## BEGIN TUX/XML: Declare XML variables 
                            csub67so.getROWCSUB67SOG00().setUlIdEvent(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdEvent());
                            csub67so.getROWCSUB67SOG00().setUlIdStage(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdStage());
                            csub67so.getROWCSUB67SOG00().setUlIdPerson(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdPerson());
                            csub67so.getROWCSUB67SOG00().setSzTxtEventDescr(pCCMN45DOutputRec.getROWCCMN45DO().getSzTxtEventDescr());
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                            break;
                    }
                }
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                // 
                // Call DAMs to update data
                // 
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
        ARC_PRFServiceStopTime_TUX(csub67si.getArchInputStruct() , csub67so.getArchOutputStruct());
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
        return csub67so;
    }

}
