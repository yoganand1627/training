package gov.georgia.dhr.dfcs.sacwis.service.person;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC31SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC31SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSC57DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSC57DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
/***************************************************************************
** 
** Module File:    CCFC31S.src
**
** Service Name:   CCFC31S
**
** Description:   This service will retrieve all rows from the 
**                Criminal History Table for a given ID_REC_CHECK.
**                The maximum page size retrieved is 10 rows.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  1/9/95 
** 
** Programmer:    CIN
**
** Archive Information: $Revision:   1.0  $
**                      $Date:   27 May 1996 16:39:46  $
**                      $Modtime:   29 Mar 1996 23:58:26  $
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






public class Ccfc31s {
    CCFC31SO CCFC31S(CCFC31SI ccfc31si) {
        CCFC31SO ccfc31so = new CCFC31SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        
        /*
        ** Call DAM
        */
        rc = ARC_UTLCheckServiceBatchBlock("CCFC31S", pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
        int i53 = 0;
        
        /*
        ** Declare FOUNDATION variables 
        */
        
        /*
        ** Declare local variables 
        */
        //##  long            rc = 0;
        
        CLSC57DI pCLSC57DInputRec = null;
        CLSC57DO pCLSC57DOutputRec = null;
        rc = ARC_PRFServiceStartTime_TUX(ccfc31si.getArchInputStruct());
        
        
        
        /*
        ** Initialize Service Status Fields 
        */
        
        
        
        /*
        ** Perform Main Processing
        */
        
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCLSC57DInputRec = new CLSC57DI();
        
        pCLSC57DOutputRec = new CLSC57DO();
        pCLSC57DInputRec.setArchInputStruct(ccfc31si.getArchInputStruct());
        pCLSC57DInputRec.setUlIdRecCheck(ccfc31si.getUlIdRecCheck());
        
        pCLSC57DInputRec.getArchInputStruct().setUsPageNbr(ccfc31si.getArchInputStruct().getUsPageNbr());
        pCLSC57DInputRec.getArchInputStruct().setUlPageSizeNbr(ccfc31si.getArchInputStruct().getUlPageSizeNbr());
        rc = clsc57dQUERYdam(sqlca, pCLSC57DInputRec, pCLSC57DOutputRec);
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                
                
                //  Populate Output Message
                
                //  Set fields in CCFC31SO to fields in CLSC57DO
                
                for (i53 = 0;i53 < pCLSC57DOutputRec.getArchOutputStruct().getUlRowQty();i53++) {
                    ccfc31so.getROWCCFC31SOG00_ARRAY().getROWCCFC31SOG00(i53).setSzCdCrimHistAction(pCLSC57DOutputRec.getROWCLSC57DO_ARRAY().getROWCLSC57DO(i53).getSzCdCrimHistAction());
                    ccfc31so.getROWCCFC31SOG00_ARRAY().getROWCCFC31SOG00(i53).setSzNmCrimHistReturned(pCLSC57DOutputRec.getROWCLSC57DO_ARRAY().getROWCLSC57DO(i53).getSzNmCrimHistReturned());
                    ccfc31so.getROWCCFC31SOG00_ARRAY().getROWCCFC31SOG00(i53).setSzTxtCrimHistCmnts(pCLSC57DOutputRec.getROWCLSC57DO_ARRAY().getROWCLSC57DO(i53).getSzTxtCrimHistCmnts());
                    ccfc31so.getROWCCFC31SOG00_ARRAY().getROWCCFC31SOG00(i53).setUlIdCrimHist(pCLSC57DOutputRec.getROWCLSC57DO_ARRAY().getROWCLSC57DO(i53).getUlIdCrimHist());
                    ccfc31so.getROWCCFC31SOG00_ARRAY().getROWCCFC31SOG00(i53).setTsLastUpdate(pCLSC57DOutputRec.getROWCLSC57DO_ARRAY().getROWCLSC57DO(i53).getTsLastUpdate());
                }
                ccfc31so.getArchOutputStruct().setBMoreDataInd(pCLSC57DOutputRec.getArchOutputStruct().getBMoreDataInd());
                ccfc31so.getArchOutputStruct().setUlRowQty(pCLSC57DOutputRec.getArchOutputStruct().getUlRowQty());
                
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
        ARC_PRFServiceStopTime_TUX(ccfc31si.getArchInputStruct() , ccfc31so.getArchOutputStruct());
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber());
        }
        else {
            // 
            // (END): Common Function: ccmn06u   Check Stage/Event common function
            // 
            
            
            
            
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
        return ccfc31so;
    }

}
