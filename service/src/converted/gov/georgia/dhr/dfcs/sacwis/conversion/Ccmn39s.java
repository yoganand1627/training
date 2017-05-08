package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN39SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN39SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNB8DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNB8DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
/**************************************************************************
** 
** Module File:   CCMN39S.src
**
** Service Name:  CCMN39S
**
** Description:   This service retrieves a record from the Stage Progression 
**                table
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  2-14-95 
** 
** Programmer:    Alex Ramirez
**
** Date      Programmer   Description
** --------  -----------  ------------------------------------------------
** 07/18/95  RAMIREAP     Updated file with the latest service shell changes.
**
** 1/17/96   DYARGR       SIR 2735:Added paging logic to this service, in the case
**                        that more than 10 rows are retrieved. Also only
**                        returning rows that have cd_stage_open
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Ccmn39s {
    CCMN39SO CCMN39S(CCMN39SI ccmn39si) {
        CCMN39SO ccmn39so = new CCMN39SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        
        /*
        ** Set rc to ARC_SUCCESS
        */
        rc = ARC_PRFServiceStartTime_TUX(ccmn39si.getArchInputStruct());
        rc = Ccmn02u.CallCCMNB8D(ccmn39si, ccmn39so, pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        
        /*
        ** Load translation map with service name and version 
        */
        
        /*
        ** Stop performance timer for service 
        */
        ARC_PRFServiceStopTime_TUX(ccmn39si.getArchInputStruct() , ccmn39so.getArchOutputStruct());
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
        return ccmn39so;
    }

    static int CallCCMNB8D(CCMN39SI pInputMsg337, CCMN39SO pOutputMsg307, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i165 = 0;
        int j = 0;
        
        CCMNB8DI pCCMNB8DInputRec = null;
        CCMNB8DO pCCMNB8DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMNB8DInputRec = new CCMNB8DI();
        
        pCCMNB8DOutputRec = new CCMNB8DO();
        pCCMNB8DInputRec.setArchInputStruct(pInputMsg337.getArchInputStruct());
        pCCMNB8DInputRec.setSzCdStage(pInputMsg337.getSzCdStage());
        pCCMNB8DInputRec.setSzCdStageProgram(pInputMsg337.getSzCdStageProgram());
        pCCMNB8DInputRec.setSzCdStageReasonClosed(pInputMsg337.getSzCdStageReasonClosed());
        pCCMNB8DInputRec.getArchInputStruct().setUsPageNbr(1);
        pCCMNB8DInputRec.getArchInputStruct().setUlPageSizeNbr(CCMNB8DO._CCMNB8DO__ROWCCMNB8DO_SIZE);
        pCCMNB8DOutputRec.getArchOutputStruct().setBMoreDataInd(1);
        rc = WtcHelperConstants.SQL_SUCCESS;
        
        /*
        ** SIR 2735
        ** Added paging logic to handle the case of more than
        ** ten rows being returned by StageProgression
        */
        while ((pCCMNB8DOutputRec.getArchOutputStruct().getBMoreDataInd() == true) && (WtcHelperConstants.SQL_SUCCESS == rc)) {
            rc = ccmnb8dQUERYdam(sqlca, pCCMNB8DInputRec, pCCMNB8DOutputRec);
            switch (rc) {
                    
                case WtcHelperConstants.SQL_SUCCESS:
                    //  Populate Output Message
                    for (i165 = 0;i165 < pCCMNB8DOutputRec.getArchOutputStruct().getUlRowQty();++i165) {
                        if (null != pCCMNB8DOutputRec.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(i165).getSzCdStageProgOpen()[0]) {
                            pOutputMsg307.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(j).setSCdStageProgProgram(pCCMNB8DOutputRec.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(i165).getSCdStageProgProgram());
                            pOutputMsg307.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(j).setSzCdStageProgStage(pCCMNB8DOutputRec.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(i165).getSzCdStageProgStage());
                            pOutputMsg307.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(j).setSCdStageProgStageType(pCCMNB8DOutputRec.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(i165).getSCdStageProgStageType());
                            pOutputMsg307.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(j).setSzCdStageProgRsnClosed(pCCMNB8DOutputRec.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(i165).getSzCdStageProgRsnClosed());
                            pOutputMsg307.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(j).setBIndStageProgClose(pCCMNB8DOutputRec.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(i165).getBIndStageProgClose());
                            pOutputMsg307.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(j).setSzCdStageProgOpen(pCCMNB8DOutputRec.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(i165).getSzCdStageProgOpen());
                            pOutputMsg307.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(j).setSzCdStageProgEventType(pCCMNB8DOutputRec.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(i165).getSzCdStageProgEventType());
                            
                            pOutputMsg307.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(j).setSzTxtStageProgEvntDesc(pCCMNB8DOutputRec.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(i165).getSzTxtStageProgEvntDesc());
                            j++;
                        }
                    }
                    pOutputMsg307.getArchOutputStruct().setUlRowQty(j);
                    
                    //  Call DAM
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    pCCMNB8DInputRec.getArchInputStruct().getUsPageNbr()++;
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        return rc;
    }

}
